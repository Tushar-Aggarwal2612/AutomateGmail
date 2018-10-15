package Test;

import java.io.IOException;

import actions.Actions;

public class TestScenarios extends Actions{
 public void gmailAutomate() throws InterruptedException, IOException{
	 navigateURL(website);
	 waitDriverForGivenSec();
	// ScreenCapture();
	 loginGmail();
	 waitDriverForGivenSec();
	// ScreenCapture();
	 enterPassword();
	 waitDriverForGivenSec();
	// ScreenCapture();
	 composeEmail();
	 waitDriverForGivenSec();
//	 ScreenCapture();
//	 Thread.sleep(2000);
	 Logout();
	// ScreenCapture();
	 waitDriverForGivenSec();
	 CloseDriver();
 }
}
