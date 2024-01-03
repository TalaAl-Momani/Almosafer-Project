import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.Assertion;

public class ParameterClass {
    static WebDriver driver= new ChromeDriver();
    String thewebsite="https://qa.almosafer.com/en";
    
    Assertion myassert= new Assertion();
    //String expectedlanguge= new String ("العربية");
    String expectedlangugeArabic= "العربية";
    String expectedlangugeEnglish="English";
    
    String ExpectedCurrency="SAR";
    
    String expectedcontact="+966554400000";
    
	String ExpectedResult="false";	
	Random rand = new Random();

    
    
    
    
}
