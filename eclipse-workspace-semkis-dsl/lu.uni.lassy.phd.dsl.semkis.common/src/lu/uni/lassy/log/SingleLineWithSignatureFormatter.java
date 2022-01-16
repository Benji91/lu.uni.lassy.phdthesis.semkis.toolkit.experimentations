/*******************************************************************************
 * Copyright (c) 2017 University of Luxembourg.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     REIS Sandro - initial API and implementation
 *******************************************************************************/
package lu.uni.lassy.log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

import lu.uni.lassy.phd.dsl.semkis.common.utils.String_Utils;

/**
 * based on <b>SingleLineFormatter</b> from <a href="http://java.sys-con.com/node/44698">Jerason Banes</a><br>
 * @author Sandro Reis
 * @version 3.0 - Sandro Reis � 2012 
 *
 */
public class  SingleLineWithSignatureFormatter extends Formatter {

	private final SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	private final Date date = new Date();
	 
	/**
	 * @param record
	 * @return the string with the new format
	 */
	@Override
	public String format(final LogRecord record)
	{
		date.setTime(System.currentTimeMillis());
		return "["+dateformat.format(date)+  "] * " + String_Utils.padRightSpaces(record.getLevel().getName(), 7) +" * ["+record.getSourceClassName()+"." +record.getSourceMethodName() + "] "+record.getMessage()+"\r\n";
	}
}