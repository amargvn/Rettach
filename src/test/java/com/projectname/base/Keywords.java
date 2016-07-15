package com.projectname.base;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import jxl.Sheet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
import org.python.tests.CustomizableMapHolder;

import com.projectname.actions.Alertverify;
import com.projectname.actions.Authentication;
import com.projectname.actions.AutoIT;
import com.projectname.actions.CloseBrowser;
import com.projectname.actions.CompairText;
import com.projectname.actions.CompareTwoFiles;
import com.projectname.actions.GetAttributeALT;
import com.projectname.actions.GetAttributeValue;
import com.projectname.actions.GetWebPageLinks;
import com.projectname.actions.IsDisplayed;
import com.projectname.actions.IsEnabled;
import com.projectname.actions.IsSelected;
import com.projectname.actions.TestData;
import com.projectname.actions.VerifyPageTitle;
import com.projectname.actions.VerifyText;
import com.projectname.actions.WaitForText;
import com.projectname.actions.WebTable;
import com.projectname.actions.WindowHandling;
import com.projectname.userfunctions.CustomizedKeywords;
import com.projectname.userfunctions.UnSelected;
import com.projectname.utils.TestConstants;

public class Keywords extends FunctionLibrary {

	TestConstants tc;
	WindowHandling wh = new WindowHandling();
	TestData td = new TestData();
	CustomizedKeywords ck=new CustomizedKeywords();
	
	/**
	 * Retrieving objects form control sheet
	 * 
	 * @param i
	 * @param colom
	 * @param tdshetnum
	 * @param csheet
	 * @param fileName
	 * @param keyword2
	 * @param stepDescription
	 * @throws Exception
	 */
	public String controlScript(String browser, int row, int colom,
			String tdshetnum, Sheet csheet, String testcaseid,
			String stepDescription, String keyword2, String fileName)
			throws Exception {
		ActionElements acElem = new ActionElements();
		fb = new FunctionLibrary();
		iClass.initialize().controllerSheet = csheet;
		it.steps = new ArrayList<Variables>();
		Robot r = new Robot();
		String result = "Pass";
		int webtableCounter = 0;
		
		for (int k = 1; k < iClass.initialize().controllerSheet.getRows(); k++) {
			TestConstants tc;
			String testLinkID = iClass.initialize().controllerSheet.getCell(0, k).getContents();
			String desc = iClass.initialize().controllerSheet.getCell(1, k).getContents();
			String keyword = iClass.initialize().controllerSheet.getCell(2, k).getContents()
					.toUpperCase();
			String keywordtype = iClass.initialize().controllerSheet.getCell(3, k).getContents();
			String objectProp = iClass.initialize().controllerSheet.getCell(4, k).getContents();
			String object = iClass.initialize().OR.getProperty(objectProp);
			String data = null;
			Object testdata = null;
			String webObject = null;
			try {
				switch (keyword) {
				case "ACCEPTALERT":
					iClass.initialize().log.info("Accepting Alert");
					try {
						driver.switchTo().alert().accept();
					} catch (Exception e) {

					}
					result = "Pass";
					break;
				case "CHECKBOX":
				case "RADIOBUTTON":
					testdata = td.testData(colom, row, tdshetnum);
					data = (String) testdata;
					iClass.initialize().log.info("Clicking on " + data
							+ " Radiobutton");
					String buttonvalue = iClass.initialize().OR.getProperty(data);
					tc = acElem.actionElement(keyword, keywordtype, buttonvalue, data);
					tc.result = result;
					colom++;
					break;
				case "COMPARETWOFILES":
					CompareTwoFiles ctf = new CompareTwoFiles();
					iClass.initialize().log.info("Compareing two files-----");
					testdata = td.testData(colom, row, tdshetnum);
					data = (String) testdata;
					result = ctf.compareTwoFiles(keyword, keywordtype, object,
							data);
					colom++;
					break;
				case "CLICK":
					iClass.initialize().log.info("Clicking on Button " + object);
					tc = acElem.actionElement(keyword, keywordtype, object, data);
					result = "Pass";
					break;
				case "CLICKENTER":
					iClass.initialize().log.info("Clicking on Enter Key");
					tc = acElem.actionElement(keyword, keywordtype, object, data);
					tc.result = result;
					break;
				case "CLICKESC":
					iClass.initialize().log.info("Clicking on Escape Button");
					Thread.sleep(3000);
					tc = acElem.actionElement(keyword, keywordtype, object, data);
					tc.result = result;
					break;
				case "CLICKTAB":
					iClass.initialize().log.info("Clicking on TAB Button");
					tc = acElem.actionElement(keyword, keywordtype, object, data);
					tc.result = result;
					break;
				case "CLOSEBROWSER":
					CloseBrowser cb = new CloseBrowser();
					iClass.initialize().log.info("Closing Browser");
					cb.closeBrowser(driver);
					result = "Pass";
					break;
				case "CLOSEWINDOW":
					iClass.initialize().log.info("Closing Child Window");
					wh.closeWindow(driver);
					result = "Pass";
					break;
				case "COMPARETEXT":
					iClass.initialize().log.info("Compairing Text");
					CompairText ct = new CompairText();
					result = ct.compairText(keyword, keywordtype, object,
							objectProp);
					break;
				case "DESC":
					result = "desc";
					break;
				case "DEFAULTCONTENT":
					iClass.initialize().log.info("Switch to default content");
					driver.switchTo().defaultContent();
					result = "Pass";
					break;
				case "DELETEACCOUNT":
					iClass.initialize().log.info("Clicking on Button " + object);
					ck.RemoveEmailAccount(driver);
					ck.RemoveStorageAccount(driver);
//					tc = acElem.actionElement(keyword, keywordtype, object, data);
//					result = "Pass";
					break;
				case "GETALLLINKS":
					iClass.initialize().log.info("Getting All Links from Webpage");
					GetWebPageLinks gwpl = new GetWebPageLinks();
					gwpl.getLinks(driver);
					result = "Pass";
					break;
				case "GETATTRIBUTEVALUE":
					GetAttributeValue gavalue = new GetAttributeValue();
					iClass.initialize().log
							.info("Getting the value form WebPage-----");
					result = gavalue.getAttributeValue(keyword, keywordtype,
							object, objectProp);
					break;
				case "GETATTRIBUTEALT":
					GetAttributeALT galt = new GetAttributeALT();
					iClass.initialize().log
							.info("Getting the value form WebPage-----");
					result = galt.getAttributeAlt(keyword, keywordtype, object,
							objectProp);
					break;
				case "GETELEMENTTEXT":
					iClass.initialize().log.info("Getting Text From Webpage");
					tc = acElem.actionElement(keyword, keywordtype, object, data);
					tc.result = result;
					break;
				case "GETPAGETITLE":
					iClass.initialize().log.info("Getting Page Title");
					driver.getTitle();
					result = "Pass";
					break;
				case "GOBACK":
					iClass.initialize().log.info("Clicking on Back Button");
					driver.navigate().back();
					result = "Pass";
					break;
				case "GOFORWARD":
					driver.navigate().forward();
					result = "Pass";
					break;
				case "INPUT":
					iClass.initialize().log.info("Entering Data into " + object);
					data = null;
					System.out.println("testdata===" + colom + row + tdshetnum);
					testdata = td.testData(colom, row, tdshetnum);
					data = (String) testdata;
					tc = acElem.actionElement(keyword, keywordtype, object, data);
					result = "Pass";
					colom++;
					break;
				case "ISDISPLAYED":
					IsDisplayed idis = new IsDisplayed();
					if (idis.isDisplayed(keyword, keywordtype, object,
							objectProp)) {
						result = "Pass";
					} else {
						result = "Fail";
					}
					break;
				case "ISSELECTED":
					IsSelected is = new IsSelected();
					if (is.isSelected(keyword, keywordtype, object, objectProp)) {
						result = "Pass";
					} else {
						result = "Fail";
					}
					break;
				case "UNSELECTED":
				     UnSelected uns = new UnSelected();
				     if (uns.unSelected(keyword, keywordtype, object, objectProp)) {
				      result = "Pass";
				     } else {
				      result = "Fail";
				     }
				     break;
				case "ISENABLED":
					IsEnabled ie = new IsEnabled();
					if (ie.isEnabled(keyword, keywordtype, object, objectProp)) {
						result = "Pass";
					} else {
						result = "Fail";
					}
					break;
				case "KEYDOWN":
					iClass.initialize().log.info("Clicking on Down Button");
					Thread.sleep(3000);
					tc = acElem.actionElement(keyword, keywordtype, object, data);
					tc.result = result;
					break;
				case "MOUSEOVER":
					iClass.initialize().log.info("Mouse Over to " + object);
					tc = acElem.actionElement(keyword, keywordtype, object, data);
					tc.result = result;
					break;
				case "OPENNEWTAB":
					iClass.initialize().log.info("Open New Tab");
					try {
						r.keyPress(KeyEvent.VK_CONTROL);
						r.keyPress(KeyEvent.VK_N);
					} catch (Exception e) {
						driver.findElement(By.tagName("body")).sendKeys(
								Keys.CONTROL + "n");
					}
					result = "Pass";
					break;
				case "OPENURL":
					iClass.initialize().log.info("Navigating to ---" + object);
					driver.navigate().to(object);
					result = "Pass";
					break;
				case "PASTE":
					iClass.initialize().log.info("Paste Text into Textbox");
					tc = acElem.actionElement(keyword, keywordtype, object, data);
					tc.result = result;
					break;
				case "REFRESH":
					iClass.initialize().log.info("Refreshing Page........");
					driver.navigate().refresh();
					result = "Pass";
					break;
				case "SCROLL":
					iClass.initialize().log.info("Scroll down");
					tc = acElem.actionElement(keyword, keywordtype, object, data);
					tc.result = result;
					break;
				case "SELECT":
					testdata = td.testData(colom, row, tdshetnum);
					data = (String) testdata;
					iClass.initialize().log.info("Selecting DropDown Value " + data);
					tc = acElem.actionElement(keyword, keywordtype, object, data);
					tc.result = result;
					colom++;
					break;
				case "WEBSELECT":
					testdata = td.testData(colom, row, tdshetnum);
					data = (String) testdata;
					webObject = object + webtableCounter;
					System.out.println("Webtable counter value-====>>"
							+ webObject);
					tc = acElem.actionElement(keyword, keywordtype, webObject, data);
					tc.result = result;
					colom++;
					break;
				case "SELECTFRAME":
					iClass.initialize().log.info("Switch to frame------");
					tc = acElem.actionElement(keyword, keywordtype, object, data);
					tc.result = result;
					break;
				case "SWITCHTONEWWINDOW":
					iClass.initialize().log.info("Switch to New Window");
					wh.windowhandle(driver);
					result = "Pass";
					break;
				case "SWITCHTOPARENTWINDOW":
					iClass.initialize().log.info("Switching to Parent Window");
					wh.Mainwindow(driver);
					result = "Pass";
					break;
				case "VERIFYALERT":
					Alertverify av = new Alertverify();
					iClass.initialize().log.info("Verifying Alert-----");
					result = av.alertverify(objectProp, driver);
					break;
				case "VERIFYTEXT":
					iClass.initialize().log.info("Verifying Text");
					VerifyText vt = new VerifyText();
					if (vt.verifyText(keyword, keywordtype, object, objectProp)) {
						result = "Pass";
					} else {
						result = "Fail";
					}
					break;
				case "VERIFYPAGETITLE":
					VerifyPageTitle vpt = new VerifyPageTitle();
					iClass.initialize().log.info("Verifying Page Title");
					result = vpt.verifyPageTitle(driver, keyword, keywordtype,
							object, objectProp);
					break;
				case "WAIT":
					iClass.initialize().log.info("Loading Page");
					Thread.sleep(10000);
					result = "Pass";
					break;
				case "WAITFORTEXT":
					iClass.initialize().log.info("Loading Page");
					WaitForText wft = new WaitForText();
					wft.waitForText();
					break;
				case "WEBTABLE":
					WebTable wtable = new WebTable();
					webtableCounter = wtable.webTable(object, driver);
					break;
				case "AUTOIT":
					iClass.initialize().log.info("Executing Auto IT Script");
					AutoIT ait = new AutoIT();
					ait.autoIT(objectProp);
					break;
				case "AUTHENTICATION":
					iClass.initialize().log.info("Executing VBScript");
					Authentication auth = new Authentication();
					auth.authentication();
					break;
				default:
					break;
				}
				reportSteps(result, desc, keyword, fileName + testLinkID
						+ ".png", object, testcaseid, testLinkID);

			} catch (UnhandledAlertException e) {
				driver.switchTo().alert().accept();
			} catch (Exception e) {
				result = "Fail";
				iClass.initialize().log.info("", e);
				it.failcount++;
				report(result, desc, keyword, fileName, object, testcaseid);
				e.printStackTrace();
				it.result = result;
				it.desc = desc;
				it.keyword = keyword;
				it.fileName = fileName;
				it.object = object;
				it.testcaseid = testcaseid;
				it.steps.add(it);
				break;
			}
		}
		reportEmailMain(browser, result, fileName, testcaseid, it.failcount);
		for (int i = 0; i < it.steps.size(); i++) {
			String re = it.steps.get(i).result;
			String ds = it.steps.get(i).desc;
			String testLinkID = it.steps.get(i).testLinkID;
			System.out.println("test Link ID for Email Report=====>>>"
					+ testLinkID);
			switch (re) {
			case "Fail":
				EmailReportUtil.addTestCaseSteps(ds, re, testLinkID);
				break;
			case "Pass":
			case "res":
				EmailReportUtil.addTestCaseSteps(ds, re, testLinkID);
				break;
			default:
				break;
			}
		}
		return result;
	}

}
