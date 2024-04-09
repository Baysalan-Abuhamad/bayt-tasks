<?php

require_once('vendor/ .php'); // Assuming you have Selenium WebDriver PHP bindings installed via Composer

use Facebook\WebDriver\Remote\RemoteWebDriver;
use Facebook\WebDriver\WebDriverBy;
use Facebook\WebDriver\WebDriverExpectedCondition;

// Set up Selenium WebDriver
$host = 'http://localhost:4444/wd/hub'; // Selenium server address
$capabilities = array(\Facebook\WebDriver\Remote\WebDriverCapabilityType::BROWSER_NAME => 'chrome');
$driver = RemoteWebDriver::create($host, $capabilities);

// Open Bayt.com website
$driver->get('https://www.bayt.com/en/jordan/');

// Scroll down to the page footer and click on the "About Us" link
$footerAboutUsLink = $driver->findElement(WebDriverBy::linkText('About Us'));
$driver->executeScript("arguments[0].scrollIntoView(true);", [$footerAboutUsLink]);
$footerAboutUsLink->click();

 $driver->findElement(WebDriverBy::xpath('//*[@id=\"yw0\"]/li[2]/a'))->click();

 $jobLink = $driver->findElement(WebDriverBy::xpath('/html/body/section[2]/div[2]/div/div[1]/div[1]/div/div[1]/h5/a'));
 usleep(1000000);
 $driver->executeScript("arguments[0].scrollIntoView(true);", [$jobLink]);
 $driver->executeScript("arguments[0].click();", [$jobLink]);

 // Get current window handle
 $currentWindowHandle = $driver->getWindowHandle();
$allWindowHandles = $driver->getWindowHandles();

foreach ($allWindowHandles as $windowHandle) {
    if ($windowHandle !== $currentWindowHandle) {
        $driver->switchTo()->window($windowHandle);
        break;
    }
}

usleep(3000000);
$apply = $driver->findElement(WebDriverBy::xpath('//*[@id=\"applyLink_1\"]'));
$driver->executeScript("arguments[0].scrollIntoView(true);", [$apply]);
$driver->executeScript("arguments[0].click();", [$apply]);

usleep(15000000);

$driver->executeScript('window.scrollBy(0,350)');
// Apply for the job and fill out the registration form
$email = 'test' . rand(1000, 9999) . '@example.com'; // Generate a dynamic email
$email = 'Baysalan@123';
$driver->findElement(WebDriverBy::xpath('//*[@id=\"JsApplicantRegisterForm_firstName\"]'))->sendKeys('Baysalan');
$driver->findElement(WebDriverBy::xpath('//*[@id=\"JsApplicantRegisterForm_lastName\"]'))->sendKeys($Abuahamd);
$driver->findElement(WebDriverBy::xpath('//*[@id=\"JsApplicantRegisterForm_email\"]'))->sendKeys($email);
$driver->findElement(WebDriverBy::xpath('//*[@id=\"JsApplicantRegisterForm_password\"]'))->sendKeys($password);
$driver->findElement(WebDriverBy::xpath('//*[@id=\"JsApplicantRegisterForm_mobPhone\"]'))->sendKeys('795475925');
$driver->findElement(WebDriverBy::xpath('//*[@id=\"register\"]'))->click();


usleep(3000000);
$driver->findElement(WebDriverBy::xpath('//*[@id=\"skip-btn\"]'))->click();


$actions = new Actions($driver);
//registeration form
$actions->click($driver->findElement(WebDriverBy::xpath("//*[@id=\"personalInformationForm_birthDay__r\"]")))
        ->sendKeys(WebDriverKeys::ARROW_DOWN)
        ->sendKeys(WebDriverKeys::ENTER)
        ->build()
        ->perform();
        $birthMonthElement = $driver->findElement(WebDriverBy::xpath("//*[@id=\"personalInformationForm_birthMonth__r\"]"));
        $actions->click($birthMonthElement)
                ->sendKeys(WebDriverKeys::ARROW_DOWN)
                ->sendKeys(WebDriverKeys::ENTER)
                ->build()
                ->perform();
        
        // Click on birth year element
        $birthYearElement = $driver->findElement(WebDriverBy::xpath("//*[@id=\"yw0\"]/section[2]/div[1]/div/div/div/div[3]/div[1]/div/div[1]/div[2]/div/input"));
        $birthYearElement->click();
        
        // Sleep for 1000 milliseconds (1 second)
        usleep(1000000); // 1000000 microseconds = 1 second
        
        // Enter birth year value
        $actions->click($birthYearElement)
                ->sendKeys("1999")
                ->sendKeys(WebDriverKeys::ENTER)
                ->build()
                ->perform();
        
        // Select gender
        $genderElement = $driver->findElement(WebDriverBy::xpath("//*[@id=\"personalInformationForm_gender\"]/label[2]"));
        $genderElement->click();
        
        // Perform actions on nationality and residence country elements
        $nationalityElement = $driver->findElement(WebDriverBy::xpath("//*[@id=\"personalInformationForm_nationalityCitizenAc__r\"]"));
        $residenceCountryElement = $driver->findElement(WebDriverBy::xpath("//*[@id=\"personalInformationForm_resCountry__r\"]"));
        
        $actions->click($nationalityElement)
                ->sendKeys(WebDriverKeys::ARROW_DOWN)
                ->sendKeys(WebDriverKeys::ENTER)
                ->build()
                ->perform();
        
        $actions->click($residenceCountryElement)
                ->sendKeys(WebDriverKeys::ARROW_DOWN)
                ->sendKeys(WebDriverKeys::ENTER)
                ->build()
                ->perform();

                usleep(3000000);

            // Execute JavaScript to scroll down by 150 pixels
$driver->executeScript("window.scrollBy(0,150)");

// Sleep for 6000 milliseconds (6 seconds)
usleep(6000000); // 6000000 microseconds = 6 seconds

// Click on residence city element and enter value
$resCityElement = $driver->findElement(WebDriverBy::xpath("//*[@id=\"personalInformationForm_resCity__r\"]"));
$resCityElement->click();

$actions = new Actions($driver);
$resCityInput = $driver->findElement(WebDriverBy::xpath("//*[@id=\"yw0\"]/section[2]/div[5]/div/div[1]/div/div[1]/div[2]/div/input"));
$actions->click($resCityInput)
        ->sendKeys("Aktobe")
        ->sendKeys(WebDriverKeys::ENTER)
        ->build()
        ->perform();

// Perform actions on visa status element
$visaStatusElement = $driver->findElement(WebDriverBy::xpath("//*[@id=\"personalInformationForm_visaStatus__r\"]"));
$actions->click($visaStatusElement)
        ->sendKeys(WebDriverKeys::ARROW_DOWN)
        ->sendKeys(WebDriverKeys::ENTER)
        ->build()
        ->perform();

// Execute JavaScript to scroll down by 150 pixels
$driver->executeScript("window.scrollBy(0,150)");

// Sleep for 1000 milliseconds (1 second)
usleep(1000000); // 1000000 microseconds = 1 second

// Click on the "No" option for experience
$noExperienceElement = $driver->findElement(WebDriverBy::xpath("//*[@id=\"experienceForm_hasExperience\"]/label[2]"));
$noExperienceElement->click();

// Execute JavaScript to scroll down by 350 pixels
$driver->executeScript("window.scrollBy(0,350)");

// Sleep for 2000 milliseconds (2 seconds)
usleep(2000000); // 2000000 microseconds = 2 seconds

// Click on degree element and select an option
$degreeElement = $driver->findElement(WebDriverBy::xpath("//*[@id=\"EducationForm_degree__r\"]"));
$actions = new Actions($driver);
$actions->click($degreeElement)
        ->sendKeys(WebDriverKeys::ARROW_DOWN)
        ->sendKeys(WebDriverKeys::ENTER)
        ->build()
        ->perform();

// Sleep for 2000 milliseconds (2 seconds)
usleep(2000000); // 2000000 microseconds = 2 seconds

// Click on institution element and enter value
$institutionElement = $driver->findElement(WebDriverBy::xpath("//*[@id=\"EducationForm_institution\"]"));
$institutionElement->click();
$actions->click($institutionElement)
        ->sendKeys("Jordan")
        ->build()
        ->perform();

// Sleep for 4000 milliseconds (4 seconds)
usleep(4000000); // 4000000 microseconds = 4 seconds

// Select institution value from the dropdown
$actions->sendKeys(WebDriverKeys::ARROW_DOWN)
        ->sendKeys(WebDriverKeys::ENTER)
        ->build()
        ->perform();

// Click on education country element and enter value
$educationCountryElement = $driver->findElement(WebDriverBy::xpath("//*[@id=\"EducationForm_educationCountry__r\"]"));
$educationCountryElement->click();
$actions->click($educationCountryElement)
        ->sendKeys("Jordan")
        ->build()
        ->perform();

// Sleep for 5000 milliseconds (5 seconds)
usleep(5000000); // 5000000 microseconds = 5 seconds

// Select education country value from the dropdown
$actions->sendKeys(WebDriverKeys::ARROW_DOWN)
        ->sendKeys(WebDriverKeys::ENTER)
        ->build()
        ->perform();

// Execute JavaScript to scroll down by 200 pixels
$driver->executeScript("window.scrollBy(0,200)");

// Click on education city element and enter value
$educationCityElement = $driver->findElement(WebDriverBy::xpath("//*[@id=\"EducationForm_educationCity__r\"]"));
$educationCityElement->click();
$actions->click($educationCityElement)
        ->sendKeys("Amman")
        ->build()
        ->perform();

// Sleep for 5000 milliseconds (5 seconds)
usleep(5000000); // 5000000 microseconds = 5 seconds

// Select education city value from the dropdown
$actions->sendKeys(WebDriverKeys::ARROW_DOWN)
        ->sendKeys(WebDriverKeys::ENTER)
        ->build()
        ->perform();

// Enter major value
$majorElement = $driver->findElement(WebDriverBy::xpath("//*[@id=\"EducationForm_major\"]"));
$majorElement->click();
$actions->click($majorElement)
        ->sendKeys("Education And IT")
        ->build()
        ->perform();

// Sleep for 5000 milliseconds (5 seconds)
usleep(5000000); // 5000000 microseconds = 5 seconds

// Select major value from the dropdown
$actions->sendKeys(WebDriverKeys::ARROW_DOWN)
        ->sendKeys(WebDriverKeys::ENTER)
        ->build()
        ->perform();

// Execute JavaScript to scroll down by 200 pixels
$driver->executeScript("window.scrollBy(0,200)");

// Sleep for 3000 milliseconds (3 seconds)
usleep(3000000); // 3000000 microseconds = 3 seconds

// Select completion month
$completionMonthElement = $driver->findElement(WebDriverBy::xpath("//*[@id=\"EducationForm_completionMonth__r\"]"));
$actions->click($completionMonthElement)
        ->sendKeys(WebDriverKeys::ARROW_DOWN)
        ->sendKeys(WebDriverKeys::ENTER)
        ->build()
        ->perform();

// Sleep for 3000 milliseconds (3 seconds)
usleep(3000000); // 3000000 microseconds = 3 seconds

// Click on completion year element and enter value
$completionYearElement = $driver->findElement(WebDriverBy::xpath("//*[@id=\"yw0\"]/section[5]/div[7]/div/div/div[2]/div[1]/div/div[1]/div[2]/div/input"));
$completionYearElement->click();
$actions->click($completionYearElement)
        ->sendKeys("2020")
        ->build()
        ->perform();

// Sleep for 3000 milliseconds (3 seconds)
usleep(3000000); // 3000000 microseconds = 3 seconds

// Select completion year value from the dropdown
$actions->sendKeys(WebDriverKeys::ARROW_DOWN)
        ->sendKeys(WebDriverKeys::ENTER)
        ->build()
        ->perform();

// Execute JavaScript to scroll down by 250 pixels
$driver->executeScript("window.scrollBy(0,250)");

// Sleep for 5000 milliseconds (5 seconds)
usleep(5000000); // 5000000 microseconds = 5 seconds

// Click on submit button for education form
$submitButtonElement = $driver->findElement(WebDriverBy::xpath("//*[@id=\"yw0\"]/footer/div/input"));
$submitButtonElement->click();

// Sleep for 6000 milliseconds (6 seconds)
usleep(6000000); // 6000000 microseconds = 6 seconds

// Select visa status from the dropdown
$visaStatusElement = $driver->findElement(WebDriverBy::xpath("//*[@id=\"applyToJobForm_visa_status__r\"]"));
$actions->click($visaStatusElement)
        ->sendKeys(WebDriverKeys::ARROW_DOWN)
        ->sendKeys(WebDriverKeys::ENTER)
        ->build()
        ->perform();

// Sleep for 2000 milliseconds (2 seconds)
usleep(2000000); // 2000000 microseconds = 2 seconds

// Click on submit button for applying to job form
$applyToJobFormButtonElement = $driver->findElement(WebDriverBy::xpath("//*[@id=\"applyToJobFormID\"]/footer/button"));
$applyToJobFormButtonElement->click();

// Sleep for 5000 milliseconds (5 seconds)
usleep(5000000); // 5000000 microseconds = 5 seconds

// Task 2: Click on elements and perform actions
$actions->click($driver->findElement(WebDriverBy::cssSelector("#yw0 > li.is-first > ul > li:nth-child(7) > a")))->build()->perform();
usleep(5000000); // 5000000 microseconds = 5 seconds

$actions->click($driver->findElement(WebDriverBy::cssSelector("#yw0 > li.is-first > ul > li.popover-owner.is-active > div > ul > li.has-divider > a")))->build()->perform();
usleep(5000000); // 5000000 microseconds = 5 seconds

// Perform login
$actions->click($driver->findElement(WebDriverBy::xpath("//*[@id=\"yw0\"]/li[9]/ul/li[1]/a")))->build()->perform();
usleep(5000000); // 5000000 microseconds = 5 seconds

$emailElement = $driver->findElement(WebDriverBy::xpath("//*[@id=\"LoginForm_username\"]"));
$emailElement->sendKeys($email);
$passwordElement = $driver->findElement(WebDriverBy::xpath("//*[@id=\"LoginForm_password\"]"));
$passwordElement->sendKeys($password);

$actions->click($driver->findElement(WebDriverBy::xpath("//*[@id=\"login-button\"]")))->build()->perform();
usleep(5000000); // 5000000 microseconds = 5 seconds

$actions->click($driver->findElement(WebDriverBy::cssSelector("#yw0 > li.is-first > ul > li:nth-child(7) > a")))->build()->perform();
usleep(2000000); // 2000000 microseconds = 2 seconds

$actions->click($driver->findElement(WebDriverBy::cssSelector("#yw0 > li.is-first > ul > li.popover-owner.is-active > div > ul > li:nth-child(1) > a")))->build()->perform();
usleep(5000000); // 5000000 microseconds = 5 seconds

// Scroll to the bottom of the page
$driver->executeScript("window.scrollBy(0,document.body.scrollHeight - 350)");

$actions->click($driver->findElement(WebDriverBy::cssSelector("body > div.row.box.m20t-d.m10t-m > section > div > div:nth-child(14) > div.card-content > p > a")))->build()->perform();
usleep(5000000); // 5000000 microseconds = 5 seconds

$actions->click($driver->findElement(WebDriverBy::xpath("/html/body/div[7]/section/div/div[2]/ul/li[1]/button")))->build()->perform();
usleep(5000000); // 5000000 microseconds = 5 seconds

$actions->click($driver->findElement(WebDriverBy::xpath("/html/body/div[9]/div/div/div[3]/div/button[2]")))->build()->perform();
usleep(15000000); // 15000000 microseconds = 15 seconds

// Quit the WebDriver session 
$driver->quit();

?>