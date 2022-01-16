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

import java.util.ArrayList;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;

public class ProjectFileHandler {
	private ArrayList<IFile> files;
	private ArrayList<IResource> resources;
	
	private String fileextension;
	
	public ProjectFileHandler(String fileextension){
		files= new ArrayList<IFile>();
		resources=new ArrayList<IResource>();
		this.fileextension=fileextension;
	}
	
	public void processContainer(IContainer container) throws CoreException{
		   IResource [] members = container.members();
		   for (IResource member : members){
		      if (member instanceof IContainer){
		         processContainer((IContainer)member);
		      }
		      else 
		    	  if (member instanceof IFile){
			    	if(member.getFileExtension().equals(fileextension)){
			    		files.add((IFile) member);
			    		resources.add(member);
			    	}
		    	  }
		    }
		  
		}



	public void printFileNames(){
		for(int i=0;i<files.size();i++){
			System.out.println(files.get(i).getName());
		}
	}
	
	public ArrayList<IFile> getFiles() {
		return files;
	}

	public void setFiles(ArrayList<IFile> files) {
		this.files = files;
	}




	public ArrayList<IResource> getResources() {
		return resources;
	}




	public void setResources(ArrayList<IResource> resources) {
		this.resources = resources;
	}

	
}
