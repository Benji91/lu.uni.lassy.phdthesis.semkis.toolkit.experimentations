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
package lu.uni.lassy.phd.dsl.semkis.common.nature;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

public class SemkisProjectNature implements IProjectNature {
	 
    public static final String NATURE_ID = "lu.uni.lassy.phd.dsl.semkis.ui.projectnature"; //$NON-NLS-1$
 
    @Override
    public void configure() throws CoreException {
        // TODO Auto-generated method stub
    }
 
    @Override
    public void deconfigure() throws CoreException {
        // TODO Auto-generated method stub
    }
 
    @Override
    public IProject getProject() {
        // TODO Auto-generated method stub
        return null;
    }
 
    @Override
    public void setProject(IProject project) {
        // TODO Auto-generated method stub
    }
 
}