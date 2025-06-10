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
		try {
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
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
			//Verify Laptops & Notebooks page is open with title text verification
			String AT= driver.getTitle();
			//String ET="Laptops & Notebooks";
		 assert driver.getTitle().equals("Laptops") : "Title mismatch!";

			
			
		 WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("input-sort")));
		 Select dropd = new Select(dropdown);
		 dropd.selectByVisibleText("Model (A - Z)");
		 WebElement first = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='MacBook']")));
		first.click();
		
			
		WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tab-description")));
		System.out.println("Description: \n" + description.getText());
		try {
            WebElement specs = driver.findElement(By.xpath("//li[@class='active']"));
            Actions actions = new Actions(driver);
            actions.moveToElement(specs).click().perform();
            Thread.sleep(1000);  // Small wait, since this is a secondary action
            WebElement specification = driver.findElement(By.id("tab-specification"));
            
            // Wait explicitly for the specifications section
            WebDriverWait waitForSpecs = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement specContent = waitForSpecs.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("tab-specification"))
            );
            System.out.println("Specification: \n" + specification.getText());
        } catch (Exception e) {
            System.out.println("No specification tab found: " + e.getMessage());
        }
		     
		WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-cart")));
			addToCartButton.click();
			WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-success")));
			System.out.println("Success message: " + successMsg.getText());

	} catch (Exception e) {
        e.printStackTrace();
    } finally {
        // Quit the driver
        driver.quit();
    }}}
	


