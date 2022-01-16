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
package lu.uni.lassy.phd.dsl.semkis.preferences;

import org.eclipse.jface.preference.IPreferenceStore;

import lu.uni.lassy.phd.dsl.semkis.common.Activator;

public class SemkisPreferences {

	//Logging preferences
	public static final String LOG_LEVEL = "LOG_LEVEL";
	public static final String DEFAULT_LOG_LEVEL = "debug";

	/*
	 *Setter for the default Log Level 
	 */
	public static void setDefaultLogLevel() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		store.setDefault(LOG_LEVEL, DEFAULT_LOG_LEVEL);
	}
	
	/*
	 * Getters for the default Log Level
	 */
	public static String getLogLevel() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		String value = store.getString(store.getString(LOG_LEVEL));
		return value;
	}
}
