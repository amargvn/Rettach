package com.rettach.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.projectname.actions.Browsers;
import com.projectname.actions.RealBrowsers;
import com.rettach.base.EmailReportUtil;
import com.rettach.base.FunctionLibrary;
import com.rettach.base.InitializeClasses;
import com.rettach.base.ReportUtil;
import com.rettach.utils.TestUtil;

public class DriverScriptTest {

	public static WebDriver driver;
	public static WebDriverWait driverWait;
	public  String keyword;
	public  String stepDescription;
	public  String result;
	public  DriverScriptTest dstest;
	public  float totalTestCaseCount, runTestCaseCount = 0, failedTestCases;
	public RealBrowsers rb;
	Browsers browser;
	protected InitializeClasses iClass = new InitializeClasses();
	protected FunctionLibrary fb;
	
	@BeforeClass
	public void beforeClass() throws Exception {
		fb = new FunctionLibrary();
		iClass.initialize();
		iClass.initialize().log.info("Initialized All Resources Files");
		fb.setTestClassName(DriverScriptTest.this.getClass().getName());
		iClass.initialize().log.info("Creatng Driver Script Object");
		dstest = new DriverScriptTest();
		iClass.initialize().log.info("Creating Test Suite");
		fb.startTesting();
		iClass.initialize().log.info("Creating Test Suite For Email Report");
		fb.emailStartTesting();
		browser = new Browsers();
		rb = new RealBrowsers();
		
	}

	@Test
	public void driverScript() throws Exception {
		browser.browserSelection();
	}

	
	
	@AfterSuite
	public static void endScript() throws Exception {
		ReportUtil.updateEndTime(TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa"));
		EmailReportUtil.updateEndTime(TestUtil
				.now("dd.MMMMM.yyyy hh.mm.ss aaa"));
		// mail();
	}
}