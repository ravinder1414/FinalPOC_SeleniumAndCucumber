package Netthandelen.ExecutionEngine;

import org.apache.log4j.Logger;



public class LoggerExample {
	
private static Logger Log = Logger.getLogger(LoggerExample.class.getName());
public static Logger logger = Logger.getLogger(LoggerExample.class);

	public static void startTestCase(String sTestCaseName){
		 
		  
		   Log.info("$$$$$$$$$$$$$$$$$$$$$"	+sTestCaseName+ 	"$$$$$$$$$$$$$$$$$$$$$$$$$");
		  
	 
		   }
	 
	
		public static void endTestCase(String sTestCaseName){
		   Log.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");
		  
		   }
	 
	
		public static void info(String message) {
			   Log.info(message);
			   }
	 
		public static void warn(String message) {
		   Log.warn(message);
		   }
	 
		public static void error(String message) {
		   Log.error(message);
		   }
	 
		public static void fatal(String message) {
		   Log.fatal(message);
		   }
	 
		public static void debug(String message) {
		   Log.debug(message);
		   }
		
		
		public void testLoggerDebug() {
			logger.debug("Hello.. im in Debug method");
		}

		public void testLoggerInfo() {
			logger.info("Hello.. im in Info method");
		}

		public void testLoggerWarn() {
			logger.warn("Hello.. im in Warn method");
		}

		public void testLoggerError() {
			logger.error("Hello.. im in Error method");
		}

		public void testLoggerFatal() {
			logger.fatal("Hello.. im in Fatal method");
		}
		
		public static void main(String[] args) {
				LoggerExample example = new LoggerExample();
					example.testLoggerDebug();
					example.testLoggerInfo();
					example.testLoggerWarn();
					example.testLoggerError();
					example.testLoggerFatal();
			}
}
