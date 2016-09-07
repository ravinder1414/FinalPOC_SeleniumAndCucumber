package Netthandelen.ExecutionEngine;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import Netthandelen.Config.ActionKeywords;
import Netthandelen.Config.Constants;
import Netthandelen.Utility.Email;
import Netthandelen.Utility.ExcelUtils;
import Netthandelen.Utility.ReportUtil;
import Netthandelen.Utility.TestUtilN;

public class DriverScript {
	
	static Logger loger = Logger.getLogger(DriverScript.class);


	public static ActionKeywords actionKeywords;
	public static String sActionKeyword;
	public static Method method[];

	public static int iTestStep;
	public static int iTestLastStep;
	public static String sTestCaseID;
	public static String sRunMode;
	public static boolean bResult;
	public static String startTime;
	public static String endTime;
	public static int pass,fail,notexec;
	
	public DriverScript() throws NoSuchMethodException, SecurityException{

		actionKeywords = new ActionKeywords();
		method = actionKeywords.getClass().getMethods();

	}

	public static void main(String[] args) throws Exception {
		

		DOMConfigurator.configure("log4j.xml");

		ExcelUtils.setExcelFile(Constants.sPath);

		DriverScript driverScr = new DriverScript();
		driverScr.execute_TestCase();


		

	}

	private static void execute_TestCase() throws Exception {
		loger.debug("execute_TestCase");


		int iTotalTestCases = ExcelUtils.getRowCount(Constants.Sheet_TestCases);

		bResult = true;
		startTime=TestUtilN.currentTime();
		for(int iTestcase=1;iTestcase<=iTotalTestCases;iTestcase++){

			sTestCaseID = ExcelUtils.getCellData(iTestcase, Constants.Col_TestCaseID, Constants.Sheet_TestCases); 

			sRunMode = ExcelUtils.getCellData(iTestcase, Constants.Col_Execute,Constants.Sheet_TestCases);
			
			iTestStep = ExcelUtils.getRowContains(sTestCaseID, Constants.Col_TestCaseID, Constants.Sheet_TestSteps);
			iTestLastStep = ExcelUtils.getTestStepsCount(Constants.Sheet_TestSteps, sTestCaseID, iTestStep);
			
			if (sRunMode.equals("Y")){				

				bResult = true;

				for (;iTestStep<iTestLastStep;iTestStep++){

					sActionKeyword = ExcelUtils.getCellData(iTestStep, 3,Constants.Sheet_TestSteps);

					bResult=execute_Actions();
					
					if(bResult)						
					{	
						ExcelUtils.setCellData(Constants.KEYWORD_PASS,iTestcase,Constants.Col_Result,Constants.Sheet_TestCases);
						
					}
					else
					{							
						ExcelUtils.setCellData(Constants.KEYWORD_FAIL,iTestcase,Constants.Col_Result,Constants.Sheet_TestCases);
						
					}
				}		



			}
			else
			{
				ExcelUtils.setCellData("Not Executed",iTestcase,Constants.Col_Result,Constants.Sheet_TestCases);
				for (;iTestStep<iTestLastStep;iTestStep++)
				{	
					ExcelUtils.setCellData("Not Executed", iTestStep, Constants.Col_TestStepResult, Constants.Sheet_TestSteps);
					notexec++;
				}
			}

		}
		endTime=TestUtilN.currentTime();
		//ReportUtil.startTesting("D://index.html",startTime,endTime);
		ReportUtil.startTesting(Constants.ReportPath,startTime,endTime,pass,fail,notexec);
		//C:\Users\satyanand.patel\workspace\Netthandelen\Report
		TestUtilN.zip(Constants.ZipPath);
		//Email.execute("path.zip");
		
		
}

	private static boolean execute_Actions()  {
		boolean flag=false;
		for(int i=0;i<=(method.length)-1;i++){

			if(method[i].getName().equalsIgnoreCase(sActionKeyword)){

				try {
					method[i].invoke(actionKeywords);
					
					flag=true;
					
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
		
					e.printStackTrace();flag=false;
				}catch(Exception e)
				{
					e.printStackTrace();
					flag=false;System.out.println("Flag:"+flag);
				}
				
				
				
					
					
					try {
						if(flag==true){
							ExcelUtils.setCellData(Constants.KEYWORD_PASS, iTestStep, Constants.Col_TestStepResult, Constants.Sheet_TestSteps);
							pass++;
						}
						else
						{
							ExcelUtils.setCellData(Constants.KEYWORD_FAIL, iTestStep, Constants.Col_TestStepResult, Constants.Sheet_TestSteps);
							fail++;
						}
						
					} catch (Exception e) {
					
						e.printStackTrace();flag=false;
					}
					break;
				


			}

		}
		return flag;
	}
}
