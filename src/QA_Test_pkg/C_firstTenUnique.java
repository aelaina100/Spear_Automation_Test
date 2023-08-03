package QA_Test_pkg;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/*
Question: 3) Scrape the link provided in Step 1, for the first 10 unique (not previously added already) wiki links embedded in 
the page and store them in a data structure of your choice.

SOLUTION: On the navigated to, main Wikipedia page, Script below performs the following:

   1- Script clicks on the first 10 links, rendering main page and the 10 other windows concurrently opened. 
   2- Controller switches from the main page and onto each child window,one by one, storing the page title of each in an Array List.
   3- And merly to demonstrate: These page titles stored in the collection class, are displayed in the console      */



                    /**********************************************************************************************************
                        / Screenshots provided in        3_Screenshot.png
                    **********************************************************************************************************/
public class C_firstTenUnique {
	
	@Test
	public void C_firstTenUniqueTest(){
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); 
		WebDriver driver = new ChromeDriver(options);        
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.wikipedia.org/");
		//int number_of_links= driver.findElements(By.tagName("a")).size();  
		//System.out.println(number_of_links);   //333 !
		Actions a= new Actions(driver);
		for (int i=0; i<10; i++)   
		{	  // Below line opens the first 10 pages.
			a.moveToElement(driver.findElements(By.tagName("a")).get(i)).keyDown(Keys.SHIFT).click().build().perform();
		}
		
		// Next, I will get the title of each open page 
		ArrayList<String> titles= new ArrayList<String>();
		Set<String> ids= driver.getWindowHandles();   // creating a set datastructure called "ids"
		Iterator<String> it= ids.iterator();          // creating an iterating object called 'it'
		
	    while (it.hasNext())                        // 'while' statement to detect whether there exists a child window open.
	    {
	    	driver.switchTo().window(it.next());  
	    	String page_title= driver.getTitle();  
	 //above line: I could use[driver.getCurrentUrl()] instead of [driver.getTitle()] if intention is to get URL's instead of page titles.
	    	titles.add(page_title);  // Storing the 10 page titles into a collection class (ArrayList)
	    }
	    titles.stream().forEach(System.out::println); // Displaying, the stored page titles, in console (Vertically)
	    driver.quit();            // closing all open windows.
	    
	    // Note: In real time, all these commented out lines are instead included in logs( log.info, log.fatal, log.debug, log.error).
	   

	}

}
