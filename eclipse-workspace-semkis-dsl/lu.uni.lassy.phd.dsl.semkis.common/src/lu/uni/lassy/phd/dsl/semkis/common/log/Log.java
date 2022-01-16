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

import java.net.URL;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;

import lu.uni.lassy.phd.dsl.semkis.common.Activator;

public class Log {
	 private static boolean init = false;
	 
	 //type of log used
	 final private static String LOG_SUPPORT_LOG4J = "LOG4J";
	 final private static String LOG_SUPPORT_ECLIPSE = "ECLIPSE";
	 final private static String logSupport = LOG_SUPPORT_ECLIPSE;

	 //log levels supported wrt Excalibur Preferences set by user
	 //default is ERROR, meaning that FATAL and ERROR issues will be logged.
	 static private boolean fatal = false;
	 static private boolean error = false;
	 static private boolean warning = false;
	 static private boolean info = false;
	 static private boolean debug = false;
	 static private boolean trace = false;

	/** Public methods*/
	 
	 /**
	  * Method to set the Level of the error
	  * @param level
	  */
	public static void setLevel(String level) {
		fatal = false;
		error = false;
		warning = false;
		info = false;
		debug = false;
		trace = false;
		Log.info("setting log level to:" + level);
		if (level != null) {
			switch (level.toUpperCase()) {
				case "TRACE" :
					trace = true;
					//$FALL-THROUGH$
				case "DEBUG" :
					debug = true;
					//$FALL-THROUGH$
				case "INFO" :
					info = true;
					//$FALL-THROUGH$
				case "WARN" :
					warning = true;
					//$FALL-THROUGH$
				case "ERROR" :
					error = true;
					//$FALL-THROUGH$
				case "FATAL" :
					fatal = true;
					//$FALL-THROUGH$
				default:
					break;
			}
			if (isLog4J()) {
				if (!Log.init) {
					init();
				}
				//level = level.toUpperCase();
				FileAppender appender = (FileAppender) Logger.getRootLogger().getAppender("file");
				if (fatal) {
					appender.setThreshold(Level.FATAL);
				}
				if (error) {
					appender.setThreshold(Level.ERROR);
				}
				if (warning) {
					appender.setThreshold(Level.WARN);
				}
				if (info) {
					appender.setThreshold(Level.INFO);
				}
				if (debug) {
					appender.setThreshold(Level.DEBUG);
				}
				if (trace) {
					appender.setThreshold(Level.TRACE);
				}
			}
		}
	}
	
	//
	// FATAL
	// not supported by Eclipse so redirected as error, prefixed with FATAL-
	public static void fatal(Class<?> cl, String msg) {
		if (fatal) {
			if (isEclipseLog()) {
				error("FATAL-" + msg);
			} else if (isLog4J()) {
				if (!Log.init) {
					init();
				}
				LogManager.getLogger(getName(cl)).log(Level.FATAL, msg);
			}
		}
	}

	//
	// ERROR
	//
	public static void error(Class<?> cl, String msg) {
		if (error) {
			if (isEclipseLog()) {
				error(msg);
			} else if (isLog4J()) {
				if (!Log.init) {
					init();
				}
				LogManager.getLogger(getName(cl)).log(Level.ERROR, msg);
	//		org.eclipse.core.internal.runtime.Log log = new org.eclipse.core.internal.runtime.Log(Activator.getDefault(), logger);
			}
		}
	}
	
	public static void error(String msg) {
		error(msg, null);
	}
	
	public static void error(String msg, Exception e) {
		if (error) {
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, IStatus.OK, msg, e);
			Activator.getDefault().getLog().log(status);
		}
	}

	//
	// WARNING
	//
	public static void warn(Class<?> cl, String msg) {
		if (warning) {
			if (isEclipseLog()) {
				warn(msg);
			} else if (isLog4J()) {
				if (!Log.init) {
					init();
				}
				LogManager.getLogger(getName(cl)).log(Level.WARN, msg);
			}
		}
	}
	
	public static void warn(String msg) {
		warn(msg, null);
	}
	
	public static void warn(String msg, Exception e) {
		if (warning) {
			IStatus status = new Status(IStatus.WARNING, Activator.PLUGIN_ID, IStatus.OK, msg, e);
		    Activator.getDefault().getLog().log(status);
		}
	}
	
	//
	// INFO
	//
	public static void info(Class<?> cl, String msg) {
		if (info) {
			if (isEclipseLog()) {
				info(msg);
			} else if (isLog4J()) {
				if (!Log.init) {
					init();
				}
				LogManager.getLogger(getName(cl)).log(Level.INFO, msg);
			}
		}
	}
	
	public static void info(String msg) {
		info(msg, null);
	}
	
	public static void info(String msg, Exception e) {
		if (info) {
			IStatus status = new Status(IStatus.INFO, Activator.PLUGIN_ID, IStatus.OK, msg, e);
		    Activator.getDefault().getLog().log(status);
		}
	}
	
	//
	// DEBUG
	// not supported by Eclipse so redirected as info, prefixed with DEBUG-
	public static void debug(String msg) {
		debug(null, msg);
	}

	public static void debug(Class<?> cl, String msg) {
		if (debug) {
			if (isEclipseLog()) {
				info("DEBUG-" + msg);
			} else if (isLog4J()) {
				if (!Log.init) {
					init();
				}
				LogManager.getLogger(getName(cl)).log(Level.DEBUG, msg);
			}
		}
	}

	//
	// TRACE
	// not supported by Eclipse so redirected as info, prefixed with TRACE-
	public static void trace(Class<?> cl, String msg) {
		if (trace) {
			if (isEclipseLog()) {
				info("TRACE-" + msg);
			} else if (isLog4J()) {
				if (!Log.init) {
					init();
				}
				LogManager.getLogger(getName(cl)).log(Level.TRACE, msg);
			}
		}
	}

	public static void trace(String msg) {
		trace(null, msg);
	}

/* PRIVATE METHODS */
	private static String getName(Class<?> cl) {
		String name = cl.getName();
		if (name.indexOf("$") > 0) {
			name = name.substring(0, name.indexOf("$")); 
		}
		return name;
	}
	
	private static void init() {
		try {
			URL base = FileLocator.toFileURL(Platform.getBundle("lu.uni.lassy.phd.dsl.semkis.common").getEntry("/"));
	        String absoluteFilePath =base.getPath()+"tesma_log4j.properties";
			PropertyConfigurator.configure(absoluteFilePath);
			init = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static private boolean isEclipseLog() {
		return logSupport.equals(LOG_SUPPORT_ECLIPSE);
	}

	static private boolean isLog4J() {
		return logSupport.equals(LOG_SUPPORT_LOG4J);
	}
	
	
}