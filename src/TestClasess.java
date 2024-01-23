import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.awt.RenderingHints.Key;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.*;


public class TestClasess extends ParameterClass {
	
	
	@BeforeTest
	public void myBeforeTest() {
		driver.get(thewebsite);
		driver.manage().window().maximize();
	}
	
	
	@Test(description = "test number 1")
	public void checkTheLanguge() {
	   String AactualLanguge=driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div/div[1]/div[2]/div/a[1]")).getText();
		myassert.assertEquals(AactualLanguge, expectedlangugeArabic);
		System.out.println(AactualLanguge);
		
		
		
	}

	
	@Test (description = "test number 2")
	public void checkTheCurrency() {
		String theactualcurrency=driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div/div[1]/div[2]/div/div[1]/div/button")).getText();
		myassert.assertEquals(theactualcurrency, ExpectedCurrency);
	}

	
	
	@Test(description = "test number 3")
	public void checkthecontacyiscorrect() {
		String actualcontact=driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div/div[1]/div[2]/div/a[2]/strong")).getText();
		myassert.assertEquals(actualcontact, expectedcontact);
	}
	
	@Test(description= "test number 4")
	public void hotel_tab_is_not_selected() {
	WebElement hoteltab= driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tab-hotels\"]"));
	String actual=	hoteltab.getAttribute("aria-selected");
	myassert.assertEquals(actual, ExpectedResult);
	
	}
	@SuppressWarnings("deprecation")
	@Test(description= "test number 5")
	public void Check_The_Depruter_Date (){  
		int numberOfDateExtra = 1;
		Date todayTime= new Date();
		int ActualdayOfTheMonth= todayTime.getDate();
		String TheDayOnTheWebsite=driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-flights\"]/div/div[2]/div[1]/div/div[3]/div/div/div/div[1]/span[2]")).getText();
		int editedDateAsInteger=Integer.parseInt(TheDayOnTheWebsite);
		myassert.assertEquals(editedDateAsInteger, ActualdayOfTheMonth+numberOfDateExtra);
	}
		
		
	@SuppressWarnings("deprecation")// 
	@Test(description= "test number 6")
	public void CheckTheBackDate (){
		int numberOfDateExtra = 2;
		Date todayTime= new Date();
		int ActualdayOfTheMonth= todayTime.getDate();
		String TheDayOnTheWebsite=driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-flights\"]/div/div[2]/div[1]/div/div[3]/div/div/div/div[2]/span[2]")).getText();
		int editedDateAsInteger=Integer.parseInt(TheDayOnTheWebsite);
		myassert.assertEquals(editedDateAsInteger, ActualdayOfTheMonth+numberOfDateExtra);
	}
		
	@Test(description= "test number 7")
	public void RandomCheckTheWebSiteLanguage() {
		
		String [] MyWebsiteURLs= {"https://qa.almosafer.com/ar", "https://qa.almosafer.com/en"};
		
		int MyIndex=rand.nextInt(0,2 );
       
		driver.get(MyWebsiteURLs[MyIndex]);
		
		if (driver.getCurrentUrl().contains("ar")) {  
       
		String lang=driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div/div[1]/div[2]/div/a[1]")).getText();
		
      
		myassert.assertEquals(lang, expectedlangugeEnglish);  
		
		
		}else {
			
			String lang = driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div/div[1]/div[2]/div/a[1]")).getText();
			
			myassert.assertEquals(lang, expectedlangugeArabic);

		}
	}
        @Test(description ="test number 8", priority =1)
		public void TestHotelTab() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			
			String [] MyWebsiteURLs= {"https://qa.almosafer.com/ar", "https://qa.almosafer.com/en"};
			String[]ArabiCountries= {"دبي","جده"};
			int ArabicIndex=rand.nextInt(0,2);
			String []EnglishCountries= {"dubai","jeddah","Riyad"};
			int EnglishIndix=rand.nextInt(0,3);
			int MyIndex=rand.nextInt(0,2 );
			driver.get(MyWebsiteURLs[MyIndex]);
			
			if (driver.getCurrentUrl().contains("ar")) { 
				
	        WebElement HotelTab=  driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tab-hotels\"]"));
			HotelTab.click();
			Thread.sleep(2000);
			WebElement SearchBar=driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-hotels\"]/div/div/div/div[1]/div/div[1]/div/div/input"));
	         SearchBar.sendKeys(ArabiCountries[ArabicIndex]);
	         Thread.sleep(1000);
	         WebElement searchButton=driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-hotels\"]/div/div/div/div[4]/button")) ;
	         SearchBar.sendKeys(Keys.ARROW_DOWN);
	         searchButton.click();
	         
			}else {
				WebElement HotelTab=driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tab-hotels\"]"));
				HotelTab.click();
				Thread.sleep(2000);
				WebElement SearchBar=driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-hotels\"]/div/div/div/div[1]/div/div[1]/div/div/input"));
				WebElement searhButton=driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-hotels\"]/div/div/div/div[4]/button"));
		        SearchBar.sendKeys(EnglishCountries[EnglishIndix]);
		         
		        SearchBar.sendKeys(Keys.ARROW_DOWN);
		        searhButton.click();
			}		
		}
		
		@Test(description  = "test number 9 ",priority=2)
		public void RandomlySelecetNumberOfVesetor () {
			 WebElement numberOfVisitor=driver.findElement(By.xpath("//*[@id=\"__next\"]/section[2]/div/section/div/div/div/div/div[3]/div/select"));
			 Select mySelector = new Select((numberOfVisitor));
		     int myindex=rand.nextInt(0,1);
			 mySelector.selectByIndex(myindex);
		}
		
		@Test (description = " test number 10", priority=3) 
		public void SearchHotell () {
	    WebElement searchButton=driver.findElement(By.xpath("//*[@id=\"__next\"]/section[2]/div/section/div/div/div/div/div[4]/button"));
	    searchButton.click();
		}
		
		
		@Test(description = "test number 11", priority = 4)
		public void DoneSearching() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		String SearchReasult=driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/section/span")).getText();
		boolean ActualReasultInTheWebsite= SearchReasult.contains("found")|| SearchReasult.contains("وجدنا");
		
    	myassert.assertEquals(ActualReasultInTheWebsite, true);
		}
		
		@Test (description = "test number12", priority = 5)
		public void SortingFromLowtToHigh () throws InterruptedException {
			WebElement LowestPrice= driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div[2]/section[1]/div/button[2]"));
			LowestPrice.click();
			Thread.sleep(3000);
			WebElement RightSide=driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div[2]"));
			List <WebElement> ThePrice=RightSide.findElements(By.className("Price_value"));
			for(int i =0 ; i<ThePrice.size() ; i++)
			{
				String PriceOnTheWebSite=ThePrice.get(i).getText();
				int EditedPriceAsInt=Integer.parseInt(PriceOnTheWebSite);
				ThePrice.get(0).getText();
				
				
				
				
			
			}

		}
}
			
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	


