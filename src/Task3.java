import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Task3 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Actions actions = new Actions(driver);

		Dimension dimension = new Dimension(375, 812); // iPhone X dimensions
		driver.manage().window().setSize(dimension);
		driver.get("https://www.bayt.com/en/jordan/");
		Thread.sleep(5000);

		// JOB TITLE SEARCH BOX
		driver.findElement(By.xpath("//*[@id=\"text_search\"]")).click();
		actions.click(driver.findElement(By.cssSelector(
				"body > div.popover.is-full.is-wide.is-active > div.list-menu.is-autosize > div:nth-child(2) > div > input")))
				.sendKeys("Quality Assurance Engineer").sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build()
				.perform();

		// COUNTRY FIELD
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"search_country__r\"]")).click();
		actions.click(driver.findElement(By.cssSelector(
				"body > div.popover.is-full.is-wide.is-active > div.list-menu.is-autosize > div:nth-child(2) > div > input")))
				.sendKeys("United Arab Emirates - Dubai").build().perform();
		Thread.sleep(3000);
		actions.click(driver.findElement(By.cssSelector(
				"body > div.popover.is-full.is-wide.is-active > div.list-menu.is-autosize > div.list-menu-group.no-minsize > ul > li > a")))
				.build().perform();

		Thread.sleep(3000);

		// FIND JOB BUTTON
		driver.findElement(By.cssSelector("#form > div > div.col.is-2 > button")).click();

		// APPLY TO THE JOB
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");
		driver.findElement(By.xpath("//*[@id=\"results_inner_card\"]/ul/li[2]/div[2]/div[1]/div/h2/a")).click();
		Thread.sleep(6000);
		driver.findElement(By.linkText("Easy apply")).click();

		// TODO: move this as task 1 method
		Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,350)");
		driver.findElement(By.xpath("//*[@id=\"JsApplicantRegisterForm_firstName\"]")).sendKeys("Baysalan");
		driver.findElement(By.xpath("//*[@id=\"JsApplicantRegisterForm_lastName\"]")).sendKeys("Abuahamd");
		driver.findElement(By.xpath("//*[@id=\"JsApplicantRegisterForm_email\"]")).sendKeys(generateEmail());
		driver.findElement(By.xpath("//*[@id=\"JsApplicantRegisterForm_password\"]")).sendKeys("Baysalan@123");
		driver.findElement(By.xpath("//*[@id=\"JsApplicantRegisterForm_mobPhone\"]")).sendKeys("795475545");
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"register\"]")).click();
		
		Thread.sleep(10000);
        driver.close();

	}

	private static String generateEmail() {
		String uuid = UUID.randomUUID().toString();
		return "y_" + uuid.substring(0, 8) + "@task.com";
	}
}
