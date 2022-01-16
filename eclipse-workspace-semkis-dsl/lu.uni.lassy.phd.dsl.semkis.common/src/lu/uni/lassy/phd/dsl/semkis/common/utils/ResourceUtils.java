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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

public class ResourceUtils {
	/**
	 * 
	 * @param resourceURI
	 * @param resourceSetProvider
	 * @return
	 */
	public static Resource getResource(URI resourceURI, IResourceSetProvider resourceSetProvider) {
		ResourceSet resourceSet = ResourceSetUtils.getResourceSet(resourceURI, resourceSetProvider);
		Resource resource = resourceSet.getResource(resourceURI, true);
		return resource;
	}

	public static Resource getResource(IFile iFile, IResourceSetProvider resourceSetProvider) {
		URI resourceURI = URI.createPlatformResourceURI(iFile.getFullPath().toOSString(), true);
		return getResource(resourceURI, resourceSetProvider);
	}

	/**
	 * 
	 * @param iFile
	 * @return
	 */
	public static Resource getResource(IFile iFile) {
		ResourceSet resourceSet = ResourceSetUtils.getResourceSet(iFile);
		if (resourceSet != null) {
			URI uri = URI.createPlatformResourceURI(iFile.getFullPath().toOSString(), true);
			Resource resource = resourceSet.getResource(uri, true);
			//Seems that the msrd and msrv files are not loaded (but msr files are loaded), how come ?
			//try to force loading the resource ?		
			/* if ("msrd".equals(iFile.getFileExtension())) {
				try {
					resource.load(null);
				} catch (IOException e) {
					Log.error(ResourceUtils.class, e.getMessage());
				}
				EcoreUtil.resolveAll(resource);
			}*/
			return resource;
		}
		return null;
	}
	/**
	 * 
	 * @param resourceURI
	 * @return
	 */
	public static Resource getResource(URI resourceURI) {
		ResourceSet resourceSet = ResourceSetUtils.getResourceSet(resourceURI);
		Resource resource = resourceSet.getResource(resourceURI, true);
		return resource;
	}
}
