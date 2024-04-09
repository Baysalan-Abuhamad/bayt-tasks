
import java.time.Duration;
import java.util.Set;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;



public class Task1 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String email = generateEmail();
        String password = "Baysalan@123";
        
        driver.manage().window().maximize();
		driver.get("https://www.bayt.com/en/jordan/");
		
		
		// POINT 2:   
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		Thread.sleep(1000);

		WebElement footerItem = driver.findElement(By.linkText("About Us"));
        footerItem.click();
  
        // POINT 3 :
        WebElement careers = driver.findElement(By.xpath("//*[@id=\"yw0\"]/li[2]/a"));
        careers.click();
        
        WebElement jobLink = driver.findElement(By.xpath("/html/body/section[2]/div[2]/div/div[1]/div[1]/div/div[1]/h5/a"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", jobLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", jobLink);
        
     // Get current window handle
        String currentWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(currentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        
        Thread.sleep(3000);
        WebElement apply = driver.findElement(By.xpath("//*[@id=\"applyLink_1\"]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", apply);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", apply);
        

        Thread.sleep(15000);
        
        js.executeScript("window.scrollBy(0,350)");
        driver.findElement(By.xpath("//*[@id=\"JsApplicantRegisterForm_firstName\"]")).sendKeys("Baysalan");
        driver.findElement(By.xpath("//*[@id=\"JsApplicantRegisterForm_lastName\"]")).sendKeys("Abuahamd");
        driver.findElement(By.xpath("//*[@id=\"JsApplicantRegisterForm_email\"]")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"JsApplicantRegisterForm_password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"JsApplicantRegisterForm_mobPhone\"]")).sendKeys("795475925");
        driver.findElement(By.xpath("//*[@id=\"register\"]")).click();
       

        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"skip-btn\"]")).click();
        
        // Register FORM
        
        Actions actions = new Actions(driver);
        actions.click(driver.findElement(By.xpath("//*[@id=\"personalInformationForm_birthDay__r\"]"))).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        actions.click(driver.findElement(By.xpath("//*[@id=\"personalInformationForm_birthMonth__r\"]"))).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        driver.findElement(By.xpath("//*[@id=\"personalInformationForm_birthYear__r\"]")).click();
        Thread.sleep(1000);
        actions.click(driver.findElement(By.xpath("//*[@id=\"yw0\"]/section[2]/div[1]/div/div/div/div[3]/div[1]/div/div[1]/div[2]/div/input"))).sendKeys("1999").sendKeys(Keys.ENTER).build().perform();
        driver.findElement(By.xpath("//*[@id=\"personalInformationForm_gender\"]/label[2]")).click();
        actions.click(driver.findElement(By.xpath("//*[@id=\"personalInformationForm_nationalityCitizenAc__r\"]"))).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        actions.click(driver.findElement(By.xpath("//*[@id=\"personalInformationForm_resCountry__r\"]"))).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        
        js.executeScript("window.scrollBy(0,150)");
        Thread.sleep(6000);
        driver.findElement(By.xpath("//*[@id=\"personalInformationForm_resCity__r\"]")).click();
        actions.click(driver.findElement(By.xpath("//*[@id=\"yw0\"]/section[2]/div[5]/div/div[1]/div/div[1]/div[2]/div/input"))).sendKeys("Aktobe").sendKeys(Keys.ENTER).build().perform();

        
        actions.click(driver.findElement(By.xpath("//*[@id=\"personalInformationForm_visaStatus__r\"]"))).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
      
        js.executeScript("window.scrollBy(0,150)");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"experienceForm_hasExperience\"]/label[2]")).click();
        
        /* EDUCATION FIELDS */
        js.executeScript("window.scrollBy(0,350)");
        Thread.sleep(2000);
        actions.click(driver.findElement(By.xpath("//*[@id=\"EducationForm_degree__r\"]"))).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"EducationForm_institution\"]")).click();
        actions.click(driver.findElement(By.xpath("//*[@id=\"EducationForm_institution\"]"))).sendKeys("Jordan").build().perform();
        Thread.sleep(4000);
        actions.click(driver.findElement(By.xpath("//*[@id=\"EducationForm_institution\"]"))).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        
        Thread.sleep(2000);
        //EDUCATION country
        driver.findElement(By.xpath("//*[@id=\"EducationForm_educationCountry__r\"]")).click();
        actions.click(driver.findElement(By.xpath("//*[@id=\"yw0\"]/section[5]/div[3]/div/div[1]/div/div[1]/div[2]/div/input"))).sendKeys("jordan").build().perform();
        Thread.sleep(5000);
        actions.click(driver.findElement(By.xpath("//*[@id=\"yw0\"]/section[5]/div[3]/div/div[1]/div/div[1]/div[2]/div/input"))).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

    
        Thread.sleep(5000);
        js.executeScript("window.scrollBy(0,200)");
        driver.findElement(By.xpath("//*[@id=\"EducationForm_educationCity__r\"]")).click();
        Thread.sleep(1000);
        actions.click(driver.findElement(By.xpath("//*[@id=\"yw0\"]/section[5]/div[4]/div/div[1]/div/div[1]/div[2]/div/input"))).sendKeys("Amman").build().perform();
        Thread.sleep(5000);
        actions.click(driver.findElement(By.xpath("//*[@id=\"yw0\"]/section[5]/div[4]/div/div[1]/div/div[1]/div[2]/div/input"))).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
      
        
        Thread.sleep(2000);
        actions.click(driver.findElement(By.xpath("//*[@id=\"EducationForm_major\"]"))).sendKeys("Education And IT").build().perform();
        Thread.sleep(5000);
        actions.click(driver.findElement(By.xpath("//*[@id=\"EducationForm_major\"]"))).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
        //EDUCATION date
        js.executeScript("window.scrollBy(0,200)");
        Thread.sleep(3000);
        actions.click(driver.findElement(By.xpath("//*[@id=\"EducationForm_completionMonth__r\"]"))).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"EducationForm_completionYear__r\"]")).click();
        Thread.sleep(2000);
        actions.click(driver.findElement(By.xpath("//*[@id=\"yw0\"]/section[5]/div[7]/div/div/div[2]/div[1]/div/div[1]/div[2]/div/input"))).sendKeys("2020").build().perform();
        Thread.sleep(3000);
        actions.click(driver.findElement(By.xpath("//*[@id=\"yw0\"]/section[5]/div[7]/div/div/div[2]/div[1]/div/div[1]/div[2]/div/input"))).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

        js.executeScript("window.scrollBy(0,250)");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"yw0\"]/footer/div/input")).click();

        
        Thread.sleep(6000);
        actions.click(driver.findElement(By.xpath("//*[@id=\"applyToJobForm_visa_status__r\"]"))).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();


        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"applyToJobFormID\"]/footer/button")).click();
        
        Thread.sleep(5000);
//        driver.close();
        
        // task 2 
        actions.click(driver.findElement(By.cssSelector("#yw0 > li.is-first > ul > li:nth-child(7) > a"))).build().perform();
        Thread.sleep(5000);
        actions.click(driver.findElement(By.cssSelector("#yw0 > li.is-first > ul > li.popover-owner.is-active > div > ul > li.has-divider > a"))).build().perform();

        Thread.sleep(5000);
        // login
        actions.click(driver.findElement(By.xpath("//*[@id=\"yw0\"]/li[9]/ul/li[1]/a"))).build().perform();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"LoginForm_username\"]")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"LoginForm_password\"]")).sendKeys(password);
        
        actions.click(driver.findElement(By.xpath("//*[@id=\"login-button\"]"))).build().perform();
        Thread.sleep(5000);
        actions.click(driver.findElement(By.cssSelector("#yw0 > li.is-first > ul > li:nth-child(7) > a"))).build().perform();
        Thread.sleep(2000);
        actions.click(driver.findElement(By.cssSelector("#yw0 > li.is-first > ul > li.popover-owner.is-active > div > ul > li:nth-child(1) > a"))).build().perform();
        Thread.sleep(5000);
        js.executeScript("window.scrollBy(0,document.body.scrollHeight - 350)");
        actions.click(driver.findElement(By.cssSelector("body > div.row.box.m20t-d.m10t-m > section > div > div:nth-child(14) > div.card-content > p > a"))).build().perform();
        Thread.sleep(5000);
        actions.click(driver.findElement(By.xpath("/html/body/div[7]/section/div/div[2]/ul/li[1]/button"))).build().perform();
        Thread.sleep(5000);
        actions.click(driver.findElement(By.xpath("/html/body/div[9]/div/div/div[3]/div/button[2]"))).build().perform();
        Thread.sleep(15000);

	}
	 private static String generateEmail() {
	        String uuid = UUID.randomUUID().toString();
	        return "y_" + uuid.substring(0, 8) + "@task.com"; 
	    }
	 

}
