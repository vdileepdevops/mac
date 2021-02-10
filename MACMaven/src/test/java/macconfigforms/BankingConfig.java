package macconfigforms;

import org.testng.annotations.Test;
  import java.io.File;
  import java.text.SimpleDateFormat;
  import java.util.Date;
  import java.util.concurrent.TimeUnit;
  import org.apache.commons.io.FileUtils;
  import org.openqa.selenium.By;
  import org.openqa.selenium.JavascriptExecutor;
  import org.openqa.selenium.Keys;
  import org.openqa.selenium.OutputType;
  import org.openqa.selenium.TakesScreenshot;
  import org.openqa.selenium.WebDriver;
  import org.openqa.selenium.WebElement;
  import org.openqa.selenium.chrome.ChromeDriver;
  import org.openqa.selenium.support.ui.ExpectedConditions;
  import org.openqa.selenium.support.ui.Select;
  import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

  public class BankingConfig 
  {
    public static WebDriver driver;
    @BeforeClass
    public static void home() throws Throwable
    {
    	System.setProperty("webdriver.chrome.driver", "E://Eclipse//chromedriver87//chromedriver.exe");
    	driver=new ChromeDriver();
    	driver.get("http://13.234.192.218:65504");	
    	driver.findElement(By.name("username")).sendKeys("admin@kapilit.com");
    	driver.findElement(By.name("password")).sendKeys("kapil");
        driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    	driver.findElement(By.xpath("//input[@class='btn btn-b-icon px-3 border-0 btn-block']")).click();
        Thread.sleep(2000);
    }
    @AfterClass
    public void window()
    {
    	driver.close();
    }
        @Test(priority=0)
        public void memType() throws Throwable
        {
        	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        	WebDriverWait wait=new WebDriverWait(driver,10);
        	WebElement w=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-navigation/div/nav/ul/li[4]/a")));
        	w.click();
        	WebDriverWait wait1=new WebDriverWait(driver,10);
        	WebElement w1=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='acc-73']/div[1]/div[1]/a")));
        	w1.click();
        	WebDriverWait wait2=new WebDriverWait(driver,10);
        	WebElement w2=wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='collapse74']/div/ul/li[1]/a")));
        	w2.click();
        	driver.findElement(By.xpath("//input[@formcontrolname='pmembertype']")).sendKeys("Regular Type");
        	Thread.sleep(2000);
        	driver.findElement(By.xpath("/html/body/app-root/app-navigation/div/div[2]/div[1]/div[3]/app-membertype-new/div[2]/div/div/form/div[1]/div[6]/div/div[1]/label")).click();
        	driver.findElement(By.xpath("/html/body/app-root/app-navigation/div/div[2]/div[1]/div[3]/app-membertype-new/div[2]/div/div/form/div[1]/div[6]/div/div[2]/label")).click();
        	driver.findElement(By.xpath("/html/body/app-root/app-navigation/div/div[2]/div[1]/div[3]/app-membertype-new/div[2]/div/div/form/div[1]/div[6]/div/div[3]/label")).click();
            Thread.sleep(2000);
        	driver.findElement(By.xpath("/html/body/app-root/app-navigation/div/div[2]/div[1]/div[3]/app-membertype-new/div[2]/div/div/form/div[2]/div/div/a/i")).click();
        	Thread.sleep(2000);
        	WebElement w3=driver.findElement(By.id("toast-container"));
        	String text=w3.getText();
        	System.out.println(text);
        	 Date d = new Date();
             System.out.println(d.toString());
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
             Thread.sleep(2000);
        	File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        	FileUtils.copyFile(screenshotFile , new File("E:\\Eclipse\\MAC Screen Shots\\Config forms\\"+sdf.format(d)+".jpg"));
        }
        //Share Creation Details
        @Test(priority=1)
        public void share()
        {
        	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        	WebDriverWait wait=new WebDriverWait(driver,10);
//        	WebElement w=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-navigation/div/nav/ul/li[4]/a")));
//        	w.click();
//        	WebDriverWait wait1=new WebDriverWait(driver,10);
//        	WebElement w1=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='acc-73']/div[1]/div[1]/a")));
//        	w1.click();
        	WebDriverWait wait2=new WebDriverWait(driver,10);
        	WebElement w2=wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='collapse74']/div/ul/li[3]/a")));
        	w2.click();
            driver.findElement(By.xpath("//input[@formcontrolname='psharename']")).sendKeys("Regular Share Class");
            driver.findElement(By.xpath("//input[@formcontrolname='psharecode']")).sendKeys("RSC");
            WebDriverWait wa1=new WebDriverWait(driver,15);
            WebElement we1=wa1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-navigation/div/div[2]/div[1]/div[3]/app-shares-config-new/div[2]/div/div[4]/div/div/button")));
            we1.click();
        }
        @Test(priority=2)
        public void shareConfig() throws Throwable
        {    
            WebElement mul=driver.findElement(By.xpath("//*[@id='pmembertypeid']/div/div/div[2]/input"));
            mul.click();
           WebElement w3=driver.findElement(By.xpath("//*[@id='pmembertypeid']/div/div/div[2]/input"));
            w3.sendKeys("ELECTED REGULAR MEMBERS",Keys.ENTER);
//            w3.sendKeys("Non-Elected Members",Keys.ENTER);
            
            WebElement mul1=driver.findElement(By.xpath("//*[@id='pApplicanttype']/div/div/div[2]/input"));
            mul1.click();
            WebElement w4=driver.findElement(By.xpath("//*[@id='pApplicanttype']/div/div/div[2]/input"));
             w4.sendKeys("Regular/General",Keys.ENTER);
//            w4.sendKeys("Senior Citizen",Keys.ENTER);
            driver.findElement(By.xpath("//input[@formcontrolname='pfacevalue']")).sendKeys("1200");
            driver.findElement(By.xpath("//input[@formcontrolname='pminshares']")).sendKeys("5");
            driver.findElement(By.xpath("//input[@formcontrolname='pmaxshares']")).sendKeys("50");
            driver.findElement(By.id("inlineRadio2")).click();
            driver.findElement(By.xpath("//input[@formcontrolname='pmultipleshares']")).clear();
            driver.findElement(By.xpath("//input[@formcontrolname='pmultipleshares']")).sendKeys("5");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='share-config']/app-share-capital/div[1]/div/div/a")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='share-config']/app-share-capital/div[3]/a[2]")).click();
            WebElement  toggle1 =driver.findElement(By.id("Employment"));
            JavascriptExecutor js1 = (JavascriptExecutor)driver;
            js1.executeScript("arguments[0].click();", toggle1);
            driver.findElement(By.xpath("//*[@id='referral-commission']/app-share-referral-commission/form/div[2]/div[1]/div[2]/div/div[2]/label")).click();
            driver.findElement(By.name("pcommissionpercentageValue")).sendKeys("2");
            WebElement toggle2=driver.findElement(By.id("tds"));
            JavascriptExecutor js2= (JavascriptExecutor)driver;
            js2.executeScript("arguments[0].click();",toggle2);
            Select s=new Select(driver.findElement(By.id("ptdssection")));
            s.selectByVisibleText("194H");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='referral-commission']/app-share-referral-commission/div/a[2]")).click();
            Thread.sleep(2000);
            WebElement w5=driver.findElement(By.id("toast-container"));
          	String text=w5.getText();
          	System.out.println(text);
       	 Date d = new Date();
         System.out.println(d.toString());
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
         Thread.sleep(2000);
    	File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(screenshotFile , new File("E:\\Eclipse\\MAC Screen Shots\\Config forms\\"+sdf.format(d)+".jpg"));
    
        }
        // A/c Type Creation
        @Test(priority=3)
        public void saving()
        {
        	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        	WebDriverWait wait=new WebDriverWait(driver,10);
//        	WebElement w=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-navigation/div/nav/ul/li[4]/a")));
//        	w.click();
//        	WebDriverWait wait1=new WebDriverWait(driver,10);
//        	WebElement w1=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='acc-73']/div[1]/div[1]/a")));
//        	w1.click();
        	WebDriverWait wait2=new WebDriverWait(driver,10);
        	WebElement w2=wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='collapse74']/div/ul/li[4]/a")));
        	w2.click();
        	driver.findElement(By.xpath("//input[@formcontrolname='pSavingAccountname']")).sendKeys("Salary Saving Account ");
        	driver.findElement(By.xpath("//*[@id='savingnameandcode']/app-savings-name-code/div[3]/a[2]")).click();
        }
        @Test(priority=4)
        public void saConfig()
        {
        	WebElement m1=driver.findElement(By.xpath("//*[@id='pMembertypeid']/div/div/div[2]/input"));
        	m1.click();
        	WebElement w3=driver.findElement(By.xpath("/html/body/app-root/app-navigation/div/div[2]/div[1]/div[3]/app-savings-config-new/div[2]/div/div[2]/app-savings-configuration/form/div[1]/div[1]/div/ng-select/div/div/div[2]/input"));
            w3.sendKeys("ELECTED REGULAR MEMBERS",Keys.ENTER);
//            w3.sendKeys("Non-Elected Members",Keys.ENTER);
            WebElement m2=driver.findElement(By.xpath("//*[@id='pApplicanttype']/div/div/div[2]/input"));
            m2.click();
            WebElement w4=driver.findElement(By.xpath("/html/body/app-root/app-navigation/div/div[2]/div[1]/div[3]/app-savings-config-new/div[2]/div/div[2]/app-savings-configuration/form/div[1]/div[2]/div/ng-select/div/div/div[2]/input"));
            w4.sendKeys("Regular/General",Keys.ENTER);
//            w4.sendKeys("Senior Citizen",Keys.ENTER);
            driver.findElement(By.xpath("//input[@formcontrolname='pMinopenamount']")).clear();
            driver.findElement(By.xpath("//input[@formcontrolname='pMinopenamount']")).sendKeys("10000");
            Select s=new Select(driver.findElement(By.xpath("//select[@formcontrolname='pInterestpayout']")));
           s.selectByVisibleText(" Monthly");
           driver.findElement(By.xpath("//input[@formcontrolname='pInterestrate']")).clear();
           driver.findElement(By.xpath("//input[@formcontrolname='pInterestrate']")).sendKeys("11.5");
           driver.findElement(By.xpath("//input[@formcontrolname='pMinbalance']")).clear();
           driver.findElement(By.xpath("//input[@formcontrolname='pMinbalance']")).sendKeys("1000");
           WebElement toggle1=driver.findElement(By.id("penaltyapplicable"));
           JavascriptExecutor js1=(JavascriptExecutor) driver;
           js1.executeScript("arguments[0].click();", toggle1);
           driver.findElement(By.xpath("//input[@formcontrolname='pPenaltyvalue']")).sendKeys("100");
           JavascriptExecutor js = (JavascriptExecutor) driver;
           js.executeScript("window.scrollBy(0,-350)", "");
           WebElement toggle2=driver.findElement(By.id("savingspayinapplicable"));
           JavascriptExecutor js2=(JavascriptExecutor) driver;
           js2.executeScript("arguments[0].click();", toggle2);
           Select s1=new Select(driver.findElement(By.xpath("//select[@formcontrolname='pSavingspayinmode']")));
           s1.selectByVisibleText(" Monthly"); 
           driver.findElement(By.xpath("//*[@id='savingconfig']/app-savings-configuration/form/div[2]/div[2]/div/div[2]/div[2]/div[1]/div/input")).sendKeys("1000");
           driver.findElement(By.xpath("//*[@id='savingconfig']/app-savings-configuration/form/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/input")).sendKeys("10000");
           WebElement toggle3=driver.findElement(By.id("withdrawallimitapplicable"));
           JavascriptExecutor js3=(JavascriptExecutor)driver;
           js3.executeScript("arguments[0].click();",toggle3);
           driver.findElement(By.xpath("//input[@formcontrolname='pMaxwithdrawllimit']")).sendKeys("5000");
           driver.findElement(By.xpath("//*[@id='savingconfig']/app-savings-configuration/form/div[3]/a[2]")).click();
           driver.findElement(By.xpath("//*[@id='savingconfig']/app-savings-configuration/form/div[5]/a[2]")).click();
        }
        @Test(priority=5)
        public void saloanfacility()
        {
        	WebElement toggle4=driver.findElement(By.id("loanfacilityapplicable"));
        	JavascriptExecutor js4=(JavascriptExecutor)driver;
        	js4.executeScript("arguments[0].click()", toggle4);
        	driver.findElement(By.xpath("//input[@formcontrolname='pEligiblepercentage']")).sendKeys("80");
        	driver.findElement(By.xpath("//input[@formcontrolname='pAgeperiod']")).sendKeys("6");
            Select s2=new Select(driver.findElement(By.xpath("//select[@formcontrolname='pAgeperiodtype']")));
        	s2.selectByVisibleText("Months");
            driver.findElement(By.xpath("//*[@id='loanfacility']/app-loan-facility/div[3]/a[2]")).click();
        }
        @Test(priority=6)
        public void sadocuments()
        {
        	driver.findElement(By.xpath("/html/body/app-root/app-navigation/div/div[2]/div[1]/div[3]/app-savings-config-new/div[2]/div/div[4]/app-identification-documents/div[2]/div[2]/a/img[1]")).click();
        	driver.findElement(By.xpath("/html/body/app-root/app-navigation/div/div[2]/div[1]/div[3]/app-savings-config-new/div[2]/div/div[4]/app-identification-documents/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[1]/input")).click();
        	driver.findElement(By.xpath("//*[@id='mandatorykyc']/app-identification-documents/div[3]/div/div/a[2]")).click();
        }
        @Test(priority=7)
        public void sareferences() throws Throwable
        {
        	WebElement toggle5=driver.findElement(By.id("referralCommissionapplicable"));
        	JavascriptExecutor js5=(JavascriptExecutor)driver;
        	js5.executeScript("arguments[0].click();", toggle5);
        	driver.findElement(By.id("pCommissionValue")).sendKeys("500");
        	WebElement toggle6=driver.findElement(By.id("Istdsapplicable"));
        	JavascriptExecutor js6=(JavascriptExecutor)driver;
        	js6.executeScript("arguments[0].click();", toggle6);
            Select s3=new Select(driver.findElement(By.xpath("//select[@formcontrolname='ptdssection']")));
            s3.selectByIndex(8);
            Thread.sleep(2000);
        	driver.findElement(By.xpath("//*[@id='refferral']/app-referral-commission/div[3]/div/div/a[2]")).click();
        	Thread.sleep(2000);
        	WebElement w3=driver.findElement(By.id("toast-container"));
        	String text=w3.getText();
        	System.out.println(text);
       	 Date d = new Date();
         System.out.println(d.toString());
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
         Thread.sleep(2000);
    	File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(screenshotFile , new File("E:\\Eclipse\\MAC Screen Shots\\Config forms\\"+sdf.format(d)+".jpg"));
        }
        //Fixed Deposit Creation
        @Test(priority=8)
        public void fd()
    	{
    		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//    		WebDriverWait wait=new WebDriverWait(driver,10);
//    		WebElement w=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-navigation/div/nav/ul/li[4]/a")));
//    		w.click();
//    		WebDriverWait wait1=new WebDriverWait(driver,10);
//    		WebElement w1=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='acc-73']/div[1]/div[1]/a")));
//    		w1.click();
    		WebDriverWait wait2=new WebDriverWait(driver,10);
    		WebElement w2=wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='collapse74']/div/ul/li[6]/a")));
    		w2.click();
    		driver.findElement(By.xpath("//input[@formcontrolname='pFdname']")).sendKeys(" Yearly Fixed Deposit ");
    		driver.findElement(By.xpath("/html/body/app-root/app-navigation/div/div[2]/div[1]/div[3]/app-fdconfig-new/div[3]/div/div/div/button")).click();
    	}
        @Test(priority=9)
    	public void fdConfig()
    	{
    		WebElement m1=driver.findElement(By.xpath("//*[@id='pMembertypeid']/div/div/div[2]/input"));
    		m1.click();
    		WebElement w3=driver.findElement(By.xpath("/html/body/app-root/app-navigation/div/div[2]/div[1]/div[3]/app-fdconfig-new/div[2]/div/div/div/div[2]/app-fdconfiguration/form/div[1]/div[1]/div/ng-select/div/div/div[2]/input"));
    	    w3.sendKeys("ELECTED REGULAR MEMBERS",Keys.ENTER);
//    	    w3.sendKeys("Non-Elected Members",Keys.ENTER);
    		WebElement m2=driver.findElement(By.xpath("//*[@id='pApplicanttype']/div/div/div[2]/input"));
    		m2.click();
    		WebElement w4=driver.findElement(By.xpath("/html/body/app-root/app-navigation/div/div[2]/div[1]/div[3]/app-fdconfig-new/div[2]/div/div/div/div[2]/app-fdconfiguration/form/div[1]/div[2]/div/ng-select/div/div/div[2]/input"));
    		w4.sendKeys("Regular/General",Keys.ENTER);
    	//  w4.sendKeys("Senior Citizen",Keys.ENTER);
    		driver.findElement(By.xpath("//*[@id='monthly']")).click();
    		driver.findElement(By.xpath("//input[@formcontrolname='pMininstalmentamount']")).sendKeys("50000");
    		driver.findElement(By.xpath("//input[@formcontrolname='pMaxinstalmentamount']")).sendKeys("1000000");
    		driver.findElement(By.xpath("//*[@id='option2']")).click();
    		driver.findElement(By.xpath("//input[@formcontrolname='pMultiplesofamount']")).clear();
    		driver.findElement(By.xpath("//input[@formcontrolname='pMultiplesofamount']")).sendKeys("1000");
    		driver.findElement(By.xpath("//input[@formcontrolname='pfromnoofmonths']")).sendKeys("12");
    		driver.findElement(By.xpath("//input[@formcontrolname='ptonoofmonths']")).sendKeys("72");
    		driver.findElement(By.xpath("//input[@formcontrolname='pInterestratefrom']")).sendKeys("8");
    		driver.findElement(By.xpath("//input[@formcontrolname='pInterestrateto']")).sendKeys("11.5");
    		WebElement toggle1=driver.findElement(By.id("Referral-fd"));
    	    JavascriptExecutor js1=(JavascriptExecutor)driver;
    	    js1.executeScript("arguments[0].click();", toggle1);
    	    driver.findElement(By.xpath("//*[@id='fdConfiguration']/app-fdconfiguration/form/div[3]/div[4]/div[1]/div/div/div[2]/div/div/div[2]/label")).click();
    	    driver.findElement(By.xpath("//input[@formcontrolname='pCommissionValue']")).sendKeys("4");
    	    driver.findElement(By.xpath("//*[@id='fdConfiguration']/app-fdconfiguration/form/div[3]/div[4]/div[2]/div/a[2]")).click(); //Add button
    	    driver.findElement(By.xpath("/html/body/app-root/app-navigation/div/div[2]/div[1]/div[3]/app-fdconfig-new/div[3]/div/div/div/button")).click(); // Save & Continue
    	}
    	@Test(priority=10)
    	public void fdprematurity()
    	{
    		//Loan Facility Details
    		WebElement toggle2=driver.findElement(By.id("loanfacty"));
    	    JavascriptExecutor js2=(JavascriptExecutor)driver;
    	    js2.executeScript("arguments[0].click();", toggle2);
    	    driver.findElement(By.xpath("//input[@formcontrolname='pEligiblepercentage']")).sendKeys("80");
    	    driver.findElement(By.xpath("//input[@formcontrolname='pAgeperiod']")).sendKeys("3");
    	    Select s2=new Select(driver.findElement(By.xpath("//select[@formcontrolname='pAgeperiodtype']")));
    	    s2.selectByVisibleText("Months");
    // Prematurity details
    		WebElement toggle3=driver.findElement(By.id("lockin"));
    	    JavascriptExecutor js3=(JavascriptExecutor)driver;
    	    js3.executeScript("arguments[0].click();", toggle3);
    	    driver.findElement(By.xpath("//input[@formcontrolname='pPrematuretyageperiod']")).sendKeys("6");
    	    Select s3=new Select(driver.findElement(By.xpath("//select[@formcontrolname='pPrematuretyageperiodtype']")));
    	    s3.selectByVisibleText("Months");
    	    driver.findElement(By.xpath("//input[@formcontrolname='pminprematuritypercentage']")).sendKeys("0");
    	    driver.findElement(By.xpath("//input[@formcontrolname='pmaxprematuritypercentage']")).sendKeys("12");
    	    Select s4=new Select(driver.findElement(By.xpath("//select[@formcontrolname='pprematurityperiodtype']")));
    	    s4.selectByVisibleText("Months");
    	    driver.findElement(By.xpath("//input[@formcontrolname='pPercentage']")).sendKeys("2");
    	    driver.findElement(By.xpath("//*[@id='fdLoanFacility']/app-fdloanandfacility/form/div[5]/div[2]/div[4]/div/a")).click();
    //Late fee details
    		WebElement toggle4=driver.findElement(By.id("latefee"));
    	    JavascriptExecutor js4=(JavascriptExecutor)driver;
    	    js4.executeScript("arguments[0].click();", toggle4);
    	    driver.findElement(By.xpath("//input[@formcontrolname='pLatefeepayblevalue']")).sendKeys("500");
    	    driver.findElement(By.xpath("//input[@formcontrolname='pLatefeeapplicablefrom']")).clear();
    	    driver.findElement(By.xpath("//input[@formcontrolname='pLatefeeapplicablefrom']")).sendKeys("10");
    	    Select s5=new Select(driver.findElement(By.xpath("//select[@formcontrolname='pLatefeeapplicabletype']")));
    	    s5.selectByVisibleText("Days");
    	    driver.findElement(By.xpath("/html/body/app-root/app-navigation/div/div[2]/div[1]/div[3]/app-fdconfig-new/div[3]/div/div/div/button")).click();// Save & Continue
    	}
    	@Test(priority=11)
    	public void fddocuments() throws Throwable
    	{
    	    WebDriverWait wa2=new WebDriverWait(driver,10);
    	    WebElement we2=wa2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-navigation/div/div[2]/div[1]/div[3]/app-fdconfig-new/div[2]/div/div/div/div[4]/app-fdidentification/form/div/div/app-identification-documents/div[2]/div[2]/a/img[1]")));
    	    we2.click();
    	    driver.findElement(By.xpath("/html/body/app-root/app-navigation/div/div[2]/div[1]/div[3]/app-fdconfig-new/div[2]/div/div/div/div[4]/app-fdidentification/form/div/div/app-identification-documents/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[1]/input")).click();
    	    driver.findElement(By.xpath("/html/body/app-root/app-navigation/div/div[2]/div[1]/div[3]/app-fdconfig-new/div[3]/div/div/div/button")).click(); //save 
    	    Thread.sleep(2000);
        	WebElement w3=driver.findElement(By.id("toast-container"));
        	String text=w3.getText();
        	System.out.println(text);
       	 Date d = new Date();
         System.out.println(d.toString());
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
         Thread.sleep(2000);
    	File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(screenshotFile , new File("E:\\Eclipse\\MAC Screen Shots\\Config forms\\"+sdf.format(d)+".jpg"));
    
    	}
    	//RD Transaction Creation
    	@Test(priority=12)
    	public void rd()
    	{
    		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//    		WebDriverWait wait=new WebDriverWait(driver,10);
//    		WebElement w=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-navigation/div/nav/ul/li[4]/a")));
//    		w.click();
//    		WebDriverWait wait1=new WebDriverWait(driver,10);
//    		WebElement w1=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='acc-73']/div[1]/div[1]/a")));
//    		w1.click();
    		WebDriverWait wait2=new WebDriverWait(driver,10);
    		WebElement w2=wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='collapse74']/div/ul/li[5]/a")));
    		w2.click();
    		driver.findElement(By.xpath("//input[@formcontrolname='pRdname']")).sendKeys("Monthly Recurring Deposits");
    	    WebDriverWait wa1=new WebDriverWait(driver,10);
    	    WebElement we1=wa1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-navigation/div/div[2]/div[1]/div[3]/app-rdconfig-new/div[2]/div[2]/button")));
    	    we1.click();
    	}
    	@Test(priority=13)
    	public void rdConfig()
    	{
    		WebElement m1=driver.findElement(By.xpath("//*[@id='pMembertypeid']/div/div/div[2]/input"));
    		m1.click();
    		WebElement w3=driver.findElement(By.xpath("//*[@id='pMembertypeid']/div/div/div[2]/input"));
    	    w3.sendKeys("ELECTED REGULAR MEMBERS",Keys.ENTER);
//    	    w3.sendKeys("Non-Elected Members",Keys.ENTER);
    		WebElement m2=driver.findElement(By.xpath("//*[@id='pApplicanttype']/div/div/div[2]/input"));
    		m2.click();
    		WebElement w4=driver.findElement(By.xpath("//*[@id='pApplicanttype']/div/div/div[2]/input"));
    		w4.sendKeys("Regular/General",Keys.ENTER);
    	//  w4.sendKeys("Senior Citizen",Keys.ENTER);
    		driver.findElement(By.xpath("//input[@formcontrolname='pMininstalmentamount']")).sendKeys("1000");
    		driver.findElement(By.xpath("//input[@formcontrolname='pMaxinstalmentamount']")).sendKeys("20000");
    		driver.findElement(By.xpath("//*[@id='option2']")).click();
    		driver.findElement(By.xpath("//input[@formcontrolname='pMultiplesofamount']")).clear();
    		driver.findElement(By.xpath("//input[@formcontrolname='pMultiplesofamount']")).sendKeys("1000");
    		Select s1=new Select(driver.findElement(By.xpath("//select[@formcontrolname='pInstalmentpayin']")));
    		s1.selectByVisibleText("Monthly");
    		driver.findElement(By.xpath("//input[@formcontrolname='pfromnoofmonths']")).sendKeys("12");
    		driver.findElement(By.xpath("//input[@formcontrolname='ptonoofmonths']")).sendKeys("72");
    		driver.findElement(By.xpath("//input[@formcontrolname='pInterestratefrom']")).sendKeys("8");
    		driver.findElement(By.xpath("//input[@formcontrolname='pInterestrateto']")).sendKeys("11.5");
    		WebElement toggle1=driver.findElement(By.id("Referral-fd"));
    	    JavascriptExecutor js1=(JavascriptExecutor)driver;
    	    js1.executeScript("arguments[0].click();", toggle1);
    	    driver.findElement(By.xpath("//*[@id='rdconfig']/app-rdconfiguration/form/div[2]/div[5]/div/div/div[3]/div[1]/div/div/div[2]/div/div/div[2]/label")).click();
    	    driver.findElement(By.xpath("//input[@formcontrolname='pCommissionValue']")).sendKeys("4");
    	    driver.findElement(By.xpath("//*[@id='rdconfig']/app-rdconfiguration/form/div[2]/div[5]/div/div/div[3]/div[2]/div/a[2]")).click(); //Add button
    	    driver.findElement(By.xpath("/html/body/app-root/app-navigation/div/div[2]/div[1]/div[3]/app-rdconfig-new/div[2]/div[2]/button")).click();
    	}
    	@Test(priority=14)
    	public void rdPrematurity()
    	{
    		//Loan Facility Details
    		WebElement toggle2=driver.findElement(By.id("loanfacty"));
    	    JavascriptExecutor js2=(JavascriptExecutor)driver;
    	    js2.executeScript("arguments[0].click();", toggle2);
    	    driver.findElement(By.xpath("//input[@formcontrolname='pEligiblepercentage']")).sendKeys("60");
    	    driver.findElement(By.xpath("//input[@formcontrolname='pAgeperiod']")).sendKeys("3");
    	    Select s2=new Select(driver.findElement(By.xpath("//select[@formcontrolname='pAgeperiodtype']")));
    	    s2.selectByVisibleText("Months");
    	    // Prematurity details
    	   	WebElement toggle3=driver.findElement(By.id("lockin"));
    	    JavascriptExecutor js3=(JavascriptExecutor)driver;
    	    js3.executeScript("arguments[0].click();", toggle3);
    	    driver.findElement(By.xpath("//input[@formcontrolname='pPrematuretyageperiod']")).sendKeys("3");
    	    Select s3=new Select(driver.findElement(By.xpath("//select[@formcontrolname='pPrematuretyageperiodtype']")));
    	    s3.selectByVisibleText("Months");
    	    driver.findElement(By.xpath("//input[@formcontrolname='pminprematuritypercentage']")).sendKeys("0");
    	    driver.findElement(By.xpath("//input[@formcontrolname='pmaxprematuritypercentage']")).sendKeys("12");
    	    Select s4=new Select(driver.findElement(By.xpath("//select[@formcontrolname='pprematurityperiodtype']")));
    	    s4.selectByVisibleText("Months");
    	    driver.findElement(By.xpath("//input[@formcontrolname='pPercentage']")).sendKeys("2");
    	    driver.findElement(By.xpath("//*[@id='loanfacility']/app-rdloanandfacility/form/div[5]/div[2]/div[4]/div/a")).click(); 
    	    //Late fee details
    		WebElement toggle4=driver.findElement(By.id("latefee"));
    	    JavascriptExecutor js4=(JavascriptExecutor)driver;
    	    js4.executeScript("arguments[0].click();", toggle4);
    	    driver.findElement(By.xpath("//input[@formcontrolname='pLatefeepayblevalue']")).sendKeys("500");
    	    driver.findElement(By.xpath("//input[@formcontrolname='pLatefeeapplicablefrom']")).sendKeys("5");
    	    Select s5=new Select(driver.findElement(By.xpath("//select[@formcontrolname='pLatefeeapplicabletype']")));
    	    s5.selectByVisibleText("Days");
    	   driver.findElement(By.xpath("/html/body/app-root/app-navigation/div/div[2]/div[1]/div[3]/app-rdconfig-new/div[2]/div[2]/button")).click();
    	}
    	@Test(priority=15)
    	public void rdDocuments() throws Throwable
    	{
    	    WebDriverWait wa2=new WebDriverWait(driver,10);
    	    WebElement we2=wa2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-navigation/div/div[2]/div[1]/div[3]/app-rdconfig-new/div[2]/div[1]/div[4]/app-rdidentification/div[2]/div[2]/app-identification-documents/div[2]/div[2]/a/img[1]")));
    	    we2.click();
    	    driver.findElement(By.xpath("/html/body/app-root/app-navigation/div/div[2]/div[1]/div[3]/app-rdconfig-new/div[2]/div[1]/div[4]/app-rdidentification/div[2]/div[2]/app-identification-documents/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[1]/input")).click();
    	    driver.findElement(By.xpath("/html/body/app-root/app-navigation/div/div[2]/div[1]/div[3]/app-rdconfig-new/div[2]/div[2]/button")).click(); //save 
    	    Thread.sleep(2000);
        	WebElement w3=driver.findElement(By.id("toast-container"));
        	String text=w3.getText();
        	System.out.println(text);
       	 Date d = new Date();
         System.out.println(d.toString());
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
         Thread.sleep(2000);
    	File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(screenshotFile , new File("E:\\Eclipse\\MAC Screen Shots\\Config forms\\"+sdf.format(d)+".jpg"));
    	}

    	
  }



