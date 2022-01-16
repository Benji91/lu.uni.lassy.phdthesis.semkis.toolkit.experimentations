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
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import lu.uni.lassy.phd.dsl.semkis.common.log.Log;

public class ResourceSetUtils {
	
	/*
	 * WITH XTEXT Dependency Injection
	 */
	public static ResourceSet getResourceSet(URI resourceURI, IResourceSetProvider resourceSetProvider) {
		IFile iFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(resourceURI.toPlatformString(true)));
		return getResourceSet(iFile, resourceSetProvider);
	}

	public static ResourceSet getResourceSet(IFile iFile, IResourceSetProvider resourceSetProvider) {
		IProject iProject = iFile.getProject();
		if (!iProject.exists()) {
			iProject = WorkspaceUtils.getProjectByIFile(iFile);
		}
		return getResourceSet(iProject, resourceSetProvider);
	}
	
	public static ResourceSet getResourceSet(IProject iProject, IResourceSetProvider resourceSetProvider) {
		ResourceSet resourceSet = resourceSetProvider.get(iProject);
		return resourceSet;
	}

	/*
	 * WITHOUT XTEXT Dependency Injection
	 */

	public static ResourceSet getResourceSet(IProject project) {
		try{
			Session session = SiriusUtils.getSession(project);
			//if (session != null) {
			return session.getTransactionalEditingDomain().getResourceSet();
		} catch(Exception e){
			String msg = "Sirius session not yet loaded, if this happens at project creation, it's normal. If not perform a \"Consistency Check\".";
			Log.warn(ResourceSetUtils.class, msg);
		}
		
		return null;
	}

	public static ResourceSet getResourceSet(IFile iFile) {
		IProject iProject = iFile.getProject();
		if (!iProject.exists()) {
			iProject = WorkspaceUtils.getProjectByIFile(iFile);
		}
		return getResourceSet(iProject);
	}

	public static ResourceSet getResourceSet(URI resourceURI) {
		IFile iFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(resourceURI.toPlatformString(true)));
		return getResourceSet(iFile);
	}

}