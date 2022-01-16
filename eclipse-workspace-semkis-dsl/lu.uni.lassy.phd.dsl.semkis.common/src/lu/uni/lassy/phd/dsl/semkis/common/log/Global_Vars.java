/*******************************************************************************
 * Copyright (c) 2020 University of Luxembourg.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     JAHIC Benjamin - initial API and implementation
 *******************************************************************************/
package lu.uni.lassy.phd.dsl.semkis.common.log;

import java.util.logging.Logger;

/**
 * @author Sandro Reis
 * @version 3.0 - Sandro Reis � 2012 
 * 
 */
public class Global_Vars {

	/**
	 * private Constant to hold the name for the application's LOG.<p>
	 * <b>USAGE in SLF4J:</b><br>
	 * <code>import lu.uni.fstc.utils.Global;<br>
	 * import org.slf4j.Logger;<br>
	 * import org.slf4j.LoggerFactory;<br>
	 * <br>
	 * public class MyClass {<br>
	 *   final (static) Logger logger = LoggerFactory.getLogger(Global.PAM_LOGGER_NAME);<br>
	 *     ... etc<br>
	 * }</code><p>
	 * <b>USAGE in 1.4 Logger API:</b><br>
	 * <code>Logger logger = Logger.getLogger("com.example.MyServer");<br>
	 * Handler handler = new FileHandler("test.log");<br>
	 * LogRecord record = new LogRecord(Level.FINEST, "Value of 'myvar' is "+myvar);<br>
	 * logger.setHandler(handler);<br>
	 * logger.log(record);</code><p>
	 */
	private static final String LOGGER_NAME = "SEMKIS_LOG";

	/**
	 * Global Constant to hold the object that actually logs information on file/console<p>
	 * Based on the Logger: <b>java.util.logging.Logger</b><br>
	 * The levels in descending order are:
	 * <ul><li>SEVERE (highest value)
	 * <li>WARNING
	 * <li>INFO
	 * <li>CONFIG
	 * <li>FINE
	 * <li>FINER
	 * <li>FINEST (lowest value)</ul>
	 * @see java.util.logging.Logger
	 */
	public static final Logger logger = Logger.getLogger(LOGGER_NAME);
}