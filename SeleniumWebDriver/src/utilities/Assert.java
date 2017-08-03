package utilities;

public class Assert {
	
	public static void assertTrue(ValidationType vType, boolean condition, String message){
		try{
			org.testng.Assert.assertTrue(condition);
			report(vType, message, null);
		}catch(AssertionError ae){
			report(vType, message, ae);
		}
	}
	
	public static void assertEquals(ValidationType vType, String message, String expected, String actual){
		try{
			org.testng.Assert.assertEquals(expected, actual);
			report(vType, message, null);
		}catch(AssertionError ae){
			report(vType, message, ae);
		}
	}
	
	private static void report(ValidationType vType, String message, AssertionError ae){
		if(ae == null){
			switch(vType){
			case Assert:
			case Verify:
				Report.log(Status.PASS, message);
				break;
			case AssertAndCapture:
			case VerifyAndCapture:
				Report.log(Status.PassAndCapture, message);
				break;
			}
			
		}else{
			switch(vType){
			case Assert:
			case AssertAndCapture:
				Report.log(Status.FAIL, message);
				throw ae;
			case Verify:
			case VerifyAndCapture:
				Report.log(Status.FAIL, message);
				break;
			}
		}
	}
}
