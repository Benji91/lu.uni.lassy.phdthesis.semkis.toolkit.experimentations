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
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.Resource;

import java.util.ArrayList;
import java.util.List;

public class FileHandler {
		 
	public static List<Resource> getProjectResources(IProject project){
		List<Resource> resources = new ArrayList<Resource>();
		List<IFile> files = new ArrayList<IFile>();
		try {
			
			ProjectFileHandler fileHandler = new ProjectFileHandler("sks");
			fileHandler.processContainer(project);
			files = fileHandler.getFiles();
			
		} 
		catch (CoreException e) {
			e.printStackTrace();
		}
		SiriusUtils.reloadSession(project);
		
		for (IFile f : files){
			resources.add(ResourceUtils.getResource(f));
        }
		return resources;
	}
	
	
}
