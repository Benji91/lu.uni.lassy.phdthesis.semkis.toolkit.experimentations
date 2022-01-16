/*******************************************************************************
 * Copyright (c) 2017 University of Luxembourg.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     JAHIC Benjamin - initial API and implementation
 *******************************************************************************/
package lu.uni.lassy.phd.dsl.semkis.common.utils;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.emf.common.util.URI;
import org.eclipse.sirius.business.api.session.SessionManager;

public class SiriusUtils {
	public static final String SIRIUS_DEFAULT_FILE_NAME = "representations.aird";
	public static Session reloadSession(IProject project) {
		Option<ModelingProject> modelingProject = ModelingProject.asModelingProject(project);
		
		Session session = null;
		if (modelingProject.some()) {
			session = modelingProject.get().getSession();

			//if session is open then close the session
			if (session != null && session.isOpen()) {
				session.close(new NullProgressMonitor());
			}
			session = getSession(project);
		}

		return session;
	}
	
	public static Session getSession(IProject project) {
		Option<ModelingProject> modelingProject = ModelingProject.asModelingProject(project);
		
		Session session = null;
		if (modelingProject.some()) {
			session = modelingProject.get().getSession();

			//if session is null then get a new session instance
			if (session == null) {
				Option<URI> airdFileURI = modelingProject.get().getMainRepresentationsFileURI(new NullProgressMonitor());
				if (airdFileURI.some()) {
					session = SessionManager.INSTANCE.getSession(airdFileURI.get(), new NullProgressMonitor());
					session.getReferencedSessionResources();
				} else {
					IFile mainIFile = project.getFile(SiriusUtils.SIRIUS_DEFAULT_FILE_NAME);
					URI uriEMF = URI.createPlatformResourceURI(mainIFile.getFullPath().toString(), true);
					//uriEML should be platform:/resource/lu.uni.lassy.excalibur.evoting/representations.aird
					session = SessionManager.INSTANCE.getSession(uriEMF, new NullProgressMonitor());
					session.getReferencedSessionResources();
				}
			}
			//open the session if it is not yet opened
			if (!session.isOpen()) {
				session.open(new NullProgressMonitor());
			}
		}

		return session;
	}

	

	

	
}
