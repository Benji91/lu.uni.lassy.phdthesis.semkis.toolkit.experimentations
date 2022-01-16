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
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import lu.uni.lassy.phd.dsl.semkis.common.log.Log;

public class WorkspaceUtils {
	
	
	/**
	 * Retrieve the selected file in the package explorer
	 * @return
	 */
	public static IFile retrieveSelectedFile(){
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
	    if (window != null)
	    {
	        IStructuredSelection selection = (IStructuredSelection) window.getSelectionService().getSelection();
	        Object firstElement = selection.getFirstElement();
	        if(firstElement!=null){
	        			        	
	        	if (selection instanceof ITreeSelection) {
	                TreeSelection treeSelection = (TreeSelection) selection;
	                TreePath[] treePaths = treeSelection.getPaths();
	                TreePath treePath = treePaths[0];

	                Object lastSegmentObj = treePath.getLastSegment();
	                
	                if(lastSegmentObj instanceof IAdaptable) {
	                    IFile file = (IFile) ((IAdaptable) lastSegmentObj).getAdapter(IFile.class);
	                    if(file != null) {
	                        //String path = file.getRawLocation().toOSString();
	                    	return file;
	                    }
	                }
	            }
	        }
	       
	    }
		return null;
	}
	
	
	
	public static IProject[] getProjects() {
		return ResourcesPlugin.getWorkspace().getRoot().getProjects();
	}

	public static IProject getProjectByIFile(IFile file) {
		for (IProject project: WorkspaceUtils.getProjects()) {
			if (file.getFullPath().toOSString().startsWith(project.getLocation().toOSString())
					|| file.getFullPath().toOSString().startsWith(IPath.SEPARATOR + project.getName())) {
				return project;
			}
		}
		return null;
	}
	public static IProject getProjectByName(String projectName) {
		return ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
	}

	
	public static void refreshFile(final IFile file) {
		Display.getDefault().syncExec(new Runnable() {
			@Override
			public void run() {
				try {
					 file.refreshLocal(IResource.DEPTH_ZERO, new NullProgressMonitor());
				} catch (CoreException e) {
					Log.error(WorkspaceUtils.class, e.getMessage());
				}
			}
		});
	}
	
	public static void deleteProject(IProject proj) {
		try {
			proj.delete(true, new NullProgressMonitor());
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
	
	public static void refreshProject(final IProject project) {
		Display.getDefault().syncExec(new Runnable() {
			@Override
			public void run() {
				try {
					project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
				} catch (CoreException e) {
					Log.error(WorkspaceUtils.class, e.getMessage());
				}
			}
		});
	}
	public static Shell getShell() {
		if (PlatformUI.getWorkbench().getWorkbenchWindows().length > 0) {
			return PlatformUI.getWorkbench().getWorkbenchWindows()[0].getShell();
		} 
		return null;
	}
	
	public static void refreshFolder(final IFolder folder) {
		Display.getDefault().syncExec(new Runnable() {
			@Override
			public void run() {
				try {
					 folder.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
				} catch (CoreException e) {
					Log.error(WorkspaceUtils.class, e.getMessage());
				}
			}
		});
	}

}
