package QA_Test_pkg;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

  // Question: 4) Repeat Step 3 for all newly found links and store them in the same data structure

/*   SOLUTION: On the navigated to, main Wikipedia page- Script below performs the following:
 * 
 *             In an arraylist collection class, it stores the urls of the 11th link and up to the last one that
 *             is currently the 333th. This is done utlizing the .getAttribute() method.
 *             Then, it displays these urls on the console along with their count (How many newly found urls- which is 323).

	   */

           /**********************************************************************************************************
                                Screenshots provided in:  4_Screenshot.png
          **********************************************************************************************************/
public class D_newlyFoundLinks {

	@Test
	public void D_newlyFoundLinksTest()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); //"--disable-extensions"
		WebDriver driver = new ChromeDriver(options);        
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.wikipedia.org/");
		
		// According to the below 2 lines, The number of total links is 333 
		int number_of_links= driver.findElements(By.tagName("a")).size();  
	    System.out.println("Total number of links on this webpage is: "+number_of_links);   //333 !
	    System.out.println("==========================================================");

	    //Below line: Creates an ArrayList data structure that stores the 11th to the 333th links' urls.
	    ArrayList<String> new_titles= new ArrayList<String>(); 
	    
	    for(int i=10; i<number_of_links;  i++) 
	    {
	    String newlyFound_url= driver.findElements(By.tagName("a")).get(i).getAttribute("href");
	    new_titles.add(newlyFound_url);
	    }
	    System.out.println("Newly found links are listed below:--->");
	    System.out.println(new_titles); //to view the list of url's of the newly found links that are stored in the collection class
	    //new_titles.stream().forEach(System.out::println);
	    //Above commented out line: to VERTICALLY view the list of url's of the newly found links that are stored in the collection class
	    System.out.println("");
	    System.out.println("Number of URLS displayed above in console is: " +new_titles.size());   
	}
}
