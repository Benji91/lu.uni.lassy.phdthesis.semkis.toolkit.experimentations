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

import java.net.InetAddress;

//import lu.uni.lassy.proactivity.Global_Vars;

/**
 * @author Sandro Reis
 * @version 3.0 - Sandro Reis � 2011/2012
 *
 */
public class IT_Utils {

	/* **********************************************************************************
	 * Specific Method(s) to call Moodle script(s)
	 * **********************************************************************************
	 */
	/**
	 * @param connParams
	 * @param user_id
	 * @param subject
	 * @param body
	 * @return the URL created
	 * @throws ConfigurationException
	 */
	/*/
	 public static java.net.URL buildSendEmailURL(MoodleConnectionParameters connParams ,long user_id, String subject, String body) throws ConfigurationException {
	 	try {
			if (connParams == null)
				throw new ConfigurationException("Configuration Parameters Undefined.");

//			if (connParams.protocol == null || connParams.protocol.isEmpty() || 
//			connParams.sendMailHost == null || connParams.sendMailHost.isEmpty() || 
//			connParams.sendMailScript == null || connParams.sendMailScript.isEmpty())
			if ((String_Utils.isEmptyOrNullString(connParams.protocol)) ||
					(String_Utils.isEmptyOrNullString(connParams.sendMailHost))||
					(String_Utils.isEmptyOrNullString(connParams.sendMailScript)))
				throw new ConfigurationException("Configuration Parameters Incomplete.");

			String urlString;
			urlString = "&to=" + user_id;
			urlString += "&subject=" + subject;
			urlString += "&txt=" + body;

			// Create connection
			java.net.URI uri = new java.net.URI(connParams.protocol, connParams.sendMailHost, connParams.sendMailScript, urlString, null);

			java.net.URL url = uri.toURL();
			return url;
		} catch (java.net.MalformedURLException e) {
			e.printStackTrace();
		} catch (java.net.URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
/**/

	/**
	 * taken from http://www.roseindia.net/java/java-get-example/get-computer-name.shtml
	 * @return the string representing the Computer name
	 */
	public static String getComputerName() {
		try {
			final String computername = InetAddress.getLocalHost().getCanonicalHostName();// .getHostName();
			return computername;
		} catch (final Exception e){
//			Global_Vars.logger.severe("Exception caught =" + e.getMessage());
		}
		return null;
	}
}