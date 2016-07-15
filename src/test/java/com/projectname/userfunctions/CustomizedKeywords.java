package com.projectname.userfunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.projectname.base.InitializeClasses;
import com.thoughtworks.selenium.webdriven.commands.Click;

public class CustomizedKeywords {

	public void RemoveEmailAccount(WebDriver driver ) throws Exception
	 {
		driver.findElement(By.xpath("//*[@id='navbar']/div/a[1]/b")).click();
		Thread.sleep(2000);
		
		int rowCount=driver.findElements(By.xpath("//div[@class='indent-responsive']/div[2]/div[1]/div[1]/table/tbody/tr")).size();
		System.out.println("Row count in EMail at present are: "+rowCount);

		try
		{

		 	
		 	while(rowCount>=1)
		 	{
		 		System.out.println("Entered into loop");
		 		driver.findElement(By.xpath("//*[@id='navbar']/div/a[1]/b")).click();
		 		Thread.sleep(5000);
				driver.findElement(By.xpath("//div[@class='indent-responsive']/div/div/div/div[2]/div[1]/div[1]/div[2]/a")).click();
			 	Thread.sleep(1000);
			 	driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/th/a")).click();
			 	Thread.sleep(5000);
			 	
		 		
		 		String xpath="//div[@class='buttons']/div[4]/div[1]/form[1]/button";
		 		System.out.println(xpath);
		 		System.out.println("The deleted account is: "+ driver.findElement(By.xpath(xpath)).getText());
		 		driver.findElement(By.xpath(xpath)).click();
		 		Thread.sleep(5000);
		 		rowCount=driver.findElements(By.xpath("//div[@class='indent-responsive']/div[2]/div[1]/div[1]/table/tbody/tr")).size();
		 		System.out.println("Present row count is: "+ rowCount);
		 		/*if(rowCount==1)
		 			break;*/
		 	}
		}
		catch(Exception e)
		{
				System.out.println("There is no accounts to be deleted");
				driver.findElement(By.xpath("//div[@class='navbar-right btn-group top-margin-tiny']/a/b")).click();
				Thread.sleep(2000);
		}
	 }
	
	public void RemoveStorageAccount(WebDriver driver ) throws Exception
	 {
		driver.findElement(By.xpath("//*[@id='navbar']/div/a[1]/b")).click();
		Thread.sleep(2000);
		
		int rowCount=driver.findElements(By.xpath("//div[@class='indent-responsive']/div[2]/div[2]/div[1]/table/tbody/tr")).size();
		System.out.println("Row count in EMail at present are: "+rowCount);
		try
		{
		 	while(rowCount>=1)
		 	{
		 		System.out.println("Entered into loop");
		 		driver.findElement(By.xpath("//*[@id='navbar']/div/a[1]/b")).click();
		 		Thread.sleep(5000);
				driver.findElement(By.xpath("//div[@class='indent-responsive']/div/div/div/div[2]/div[2]/div[1]/div[2]/a")).click();
			 	Thread.sleep(1000);
			 	driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/th/a")).click();
			 	Thread.sleep(5000);
			 	
		 		String xpath="//div[@class='buttons']/div[5]/div[1]/form[1]/button";
		 		System.out.println(xpath);
		 		System.out.println("The deleted account is: "+ driver.findElement(By.xpath(xpath)).getText());
		 		driver.findElement(By.xpath(xpath)).click();
		 		Thread.sleep(5000);
		 		rowCount=driver.findElements(By.xpath("//div[@class='indent-responsive']/div[2]/div[2]/div[1]/table/tbody/tr")).size();
		 		System.out.println("Present row count in Storage accounts are: "+ rowCount);
		 		/*if(rowCount==1)
		 			break;*/
		 	}
		}
		catch(Exception e)
		{
				System.out.println("There are no accounts to be deleted");
				driver.findElement(By.xpath("//div[@class='navbar-right btn-group top-margin-tiny']/a/b")).click();
				Thread.sleep(2000);
		}
	 }
	
 /*public void RemoveEmailAccount(WebDriver driver ) throws Exception
	 {
		driver.findElement(By.xpath("//*[@id='navbar']/div/a[1]/b")).click();
		Thread.sleep(2000);
		
		int rowCount=driver.findElements(By.xpath("//div[@class='indent-responsive']/div[2]/div[1]/div[1]/table/tbody/tr")).size();
		System.out.println("Row count in EMail at present are: "+rowCount);

		try
		{
			driver.findElement(By.xpath("//div[@class='indent-responsive']/div/div/div/div[2]/div[1]/div[1]/div[2]/a")).click();
		 	Thread.sleep(1000);
		 	
		 	driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/th/a")).click();
		 	Thread.sleep(5000);
		 	
		 	for(int i=0;i<=rowCount;i++)
		 	{
		 		System.out.println("Entered into loop");
		 		String xpath="//div[@class='buttons']/div[4]/div[1]/form[1]/button";
		 		System.out.println(xpath);
		 		System.out.println("The deleted account is: "+ driver.findElement(By.xpath(xpath)).getText());
		 		driver.findElement(By.xpath(xpath)).click();
		 		System.out.println("Present row count is: "+ rowCount);
		 		if(rowCount>=1)
		 			RemoveEmailAccount(driver);
		 		else
		 			break;
		 	}
		}
		catch(Exception e)
		{
				System.out.println("There is no accounts to be deleted");
				driver.findElement(By.xpath("//*[@id='navbar']/div/a[1]/b")).click();
				Thread.sleep(2000);
		}
	 }*/
	
	
	 /*public void RemoveStorageAccount(WebDriver driver) throws Exception
	 {
		 driver.findElement(By.xpath("//*[@id='navbar']/div/a/button")).click();
		 try{
			 Thread.sleep(1000);
			 
			 int rowCount=driver.findElements(By.xpath("//div[@class='indent-responsive']/div[2]/div[2]/div[1]/table/tbody")).size();
			 
			 System.out.println("Row count is: "+rowCount);
			 
			 for (int i = 1; i <=rowCount; i++) {
				 driver.findElement(By.xpath("//div[@class='indent-responsive']/div/div/div/div[2]/div[2]/div[1]/div[2]/a")).click();
				 driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/th/a")).click();
				 String xpath="//div[@class='buttons']/div[5]/div[" +i + "]/form[1]/button";
				 System.out.println("The added account is: "+ driver.findElement(By.xpath(xpath)).getText());
			 		driver.findElement(By.xpath(xpath)).click();
			 		RemoveStorageAccount(driver);
			}
			 
		 }
		 catch(Exception e)
		 {
//			 Log.info(e);
			 System.out.println("There is no accounts to be deleted");
		 }
	 }*/
	 
	/*public void RemoveStorageAccount(WebDriver driver) throws Exception
	 {
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//*[@id='navbar']/div/a/button")).click();
		 
		 int rowCount=driver.findElements(By.xpath("//div[@class='indent-responsive']/div[2]/div[2]/div[1]/table/tbody/tr")).size();
		 System.out.println("Row count in Storage at present are: "+ rowCount);
		 
		 try{
			 Thread.sleep(1000);
			 	driver.findElement(By.xpath("//div[@class='indent-responsive']/div/div/div/div[2]/div[2]/div[1]/div[2]/a")).click();
			 	driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/th/a")).click();
			 	Thread.sleep(5000);
			 	
			 	for(int i=1;i<=rowCount;i++)
			 	{
			 		String xpath="//div[@class='buttons']/div[5]/div[1]/form[1]/button";
			 		System.out.println("The deleted account is: "+ driver.findElement(By.xpath(xpath)).getText());
			 		driver.findElement(By.xpath(xpath)).click();
			 		System.out.println(rowCount);
			 		
			 		if(rowCount>=1)
			 			RemoveStorageAccount(driver);
			 		else
			 			break;
			 	}
		 }
		 catch(Exception e)
		 {
			
			 System.out.println("There is no accounts to be deleted");
			 driver.findElement(By.xpath("//*[@id='navbar']/div/a/button")).click();
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//div[@class='tour-step step5-general col-lg-6 col-md-6 col-sm-10 col-xs-12']/div/table/tbody/tr[3]/td/a")).click();
			
		}
	 }*/
}
