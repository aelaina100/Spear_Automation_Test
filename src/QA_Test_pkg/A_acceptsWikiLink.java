package QA_Test_pkg;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import graphql.Assert;

// 1) Accepts a Wikipedia link - return/throw an error if the link is not a valid wiki link.

     // Solution: If link provided is not the wiki main page, then compiler throws an exception.
       // This is determined by the page title, as it is ''Wikipedia' (For wiki main page). If it's not,then script fails.


             /**********************************************************************************************************
                                  Screenshots provided in:    1_Passes.png & 1_Fails.png
             **********************************************************************************************************/
                  
public class A_acceptsWikiLink {
	@Test
	public void A_acceptsWikiLinkTest()
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); 
		WebDriver driver = new ChromeDriver(options);        
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		
		String url= "https://ca.yahoo.com/";
		String pageTitle= "Wikipedia";
		
		driver.get(url);
		String title= driver.getTitle();   // title is:   'Wikipedia'
		
		if(title.equals(pageTitle))
		{
			Assert.assertTrue(true);
			System.out.println(" Link provided:  " +url+ "  is a VALID wiki link since title is: '"+  pageTitle+"'");
		// For the above line: In real-time, I use logs instead (via incorporating Log4J framework component)	
		}
	
		else
		{
			System.out.println(" Link provided:  " +url+ "  is a NOT a valid wiki link since title is: '"+  driver.getTitle()+"'");
			// For the above line: In real-time, I use logs instead (via incorporating Log4J framework component)
			Assert.assertTrue(false);    // Throwing an exception if executed.
		}

	}

}
