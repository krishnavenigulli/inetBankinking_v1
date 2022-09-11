package com.inetBanking.utilities;

import org.testng.ITestListener;
//import org.testng.TestListenerAdapter;
import org.testng.ITestResult;

public class Reporting implements ITestListener {
	 private int m_count = 0;

	  @Override
	  public void onTestFailure(ITestResult tr) {
	    log("Failed");
	  }

	  @Override
	  public void onTestSkipped(ITestResult tr) {
	    log("Skipped");
	  }

	  @Override
	  public void onTestSuccess(ITestResult tr) {
	    log("success");
	  }

	  private void log(String string) {
	    System.out.print(string);
	    if (m_count++ % 40 == 0) {
	      System.out.println("");
	    }
	  }

}
