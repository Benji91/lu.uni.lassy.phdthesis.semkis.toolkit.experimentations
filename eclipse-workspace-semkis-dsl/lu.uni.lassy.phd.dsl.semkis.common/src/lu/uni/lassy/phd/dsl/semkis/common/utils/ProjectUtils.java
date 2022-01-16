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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;

import lu.uni.lassy.phd.dsl.semkis.common.log.Log;

public class ProjectUtils {
	public static IFolder createFolder(IFolder folder) {
        IContainer parent = folder.getParent();
        if (parent instanceof IFolder) {
            createFolder((IFolder) parent);
        }
        if (!folder.exists()) {
        	try {
				folder.create(false, true, new NullProgressMonitor());
			} catch (CoreException e) {
				Log.error(ProjectUtils.class, e.getMessage());
			}
        }
        WorkspaceUtils.refreshFolder(folder);
        return folder;
    }
	
	public static boolean createDirectory(String filepath){
		  Path path = Paths.get(filepath);
	        //if directory exists?
	        if (!Files.exists(path)) {
	            try {
	                Files.createDirectories(path);
	                return true;
	            } catch (IOException e) {
	                //fail to create directory
	                e.printStackTrace();
	            }
	        }
	        return false;
	}
	public static boolean fileExistsInProject(String projectName, String filePath) {
    	IProject project = WorkspaceUtils.getProjectByName(projectName);
    	if (project != null) {
	    	IFile file = project.getFile(filePath);
	    	WorkspaceUtils.refreshFile(file);
	    	return file.exists();
    	}
    	return false;
    }
	
	public static IFolder getFolder(IProject project, String folderPath) {
    	IFolder folder = project.getFolder(folderPath);
    	if (folder.exists()) {
    		return folder;
    	}
    	return createFolder(folder);
	}
}
