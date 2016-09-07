package netthandelen_TestFunctionality;

	
import java.lang.reflect.Method;
import org.testng.annotations.Test;
import netthandelen_Utility.Email;
import netthandelen_Utility.TestUtilN;
	

	public class EmailReport {

		
		@Test
		public void Login(Method objMethod) throws Exception {
			
				
					Thread.sleep(10000);
					//Convert Report to ZIP File
					
					TestUtilN.zip("C:\\JAVA_PROJECTS\\Demo\\test-output\\html");
					Thread.sleep(10000);
					
					//Send mail to attachment ZIP
					Email.execute("Report.zip");
				}

			
		}

