import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
import org.openqa.selenium.WebElement;

public class Practice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver","/Users/divyasachdeva/Documents/chromedriver-mac-arm64/chromedriver");
		WebDriver driver = new ChromeDriver();
		//Go to https://naveenautomationlabs.com/opencart
		driver.get(" https://naveenautomationlabs.com/opencart");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		
		//Hover on Laptops and Notebooks tab
		WebElement element=driver.findElement(By.linkText("Laptops & Notebooks"));
		Actions action=new Actions(driver);
		
		 action.moveToElement(element).perform();
		 Thread.sleep(3000);
		 //. Select show all Laptop and Notebook options
		 WebElement select=driver.findElement(By.linkText("Show All Laptops & Notebooks"));
		 //select.click();
		 action.moveToElement(select).click().perform();
		 
		
		 
		
			System.out.println(driver.getTitle());
			Thread.sleep(3000);
			
			//Verify Laptops & Notebooks page is open with title text verification
			//String AT= driver.getTitle();
			//String ET="Laptops & Notebooks";
			
			//Assert.assertEquals(driver.getTitle(),"Your Store");
			WebElement dropdown= driver.findElement(By.id("input-sort"));
			
			Select dropd = new Select(dropdown);
			dropd.selectByVisibleText("Model (A - Z)");
			Thread.sleep(3000);
			
			WebElement first= driver.findElement(By.xpath(" //a[normalize-space()='MacBook']"));
			first.click();
			Thread.sleep(3000);
			
			 WebElement description = driver.findElement(By.id("tab-description"));
		     System.out.println("Description: \n" + description.getText());
		     Thread.sleep(3000);
		     
		    // try {
			
			/*WebElement specs=driver.findElement(By.xpath("//li[@class='active']"));
			Actions actions = new Actions(driver);
			actions.moveToElement(specs).click().perform();
			Thread.sleep(1000);
			specs.click();
			WebElement specification = driver.findElement(By.id("tab-specification"));
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement specContent = wait.until(
			    ExpectedConditions.visibilityOfElementLocated(By.id("tab-specification"))
			);

	        System.out.println("Specification: \n" + specification.getText());
			Thread.sleep(3000);
		     
		     //catch (Exception e) {
		            //e.printStackTrace();}*/
			WebElement addToCartButton = driver.findElement(By.id("button-cart"));
			addToCartButton.click();
			WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-success")));
			System.out.println("Success message: " + successMsg.getText());

		     
		     
		    
			
			
		 
		 driver.quit();
		

	}

}
