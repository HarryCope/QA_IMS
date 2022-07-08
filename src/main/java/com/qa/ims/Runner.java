package com.qa.ims;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.utils.DBUtils;

public class Runner {

	public static final Logger LOGGER = LogManager.getLogger();

	public static void main(String[] args) {

		DBUtils dbu = new DBUtils();
		IMS ims = new IMS();
		ims.imsSystem();
		LOGGER.info("SO LONG!");
	}
// mkaing a much bigger change to this file in an attempt to resolve a merge conflict.
}
