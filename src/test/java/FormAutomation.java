package trytesting16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class FormAutomation {

    public static void main(String[] args) {
    	
        // Setup WebDriver for Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // URL of the login page
        driver.get("https://trytestingthis.netlify.app/");
        driver.manage().window().maximize();

        // Initialize WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        String FirstName = "Nebadeta";
        String LastName = "Tonney";
        
        try {
            // Wait for 3 seconds
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Locate First name and Last name fields
        WebElement firstname = driver.findElement(By.id("fname"));  
        WebElement lastname = driver.findElement(By.id("lname")); 
        
        // Enter firstname and lastname
        firstname.sendKeys(FirstName);
        lastname.sendKeys(LastName);
        
        // Radiobutton
        WebElement radiobutton = driver.findElement(By.id("female"));
        radiobutton.click();
        
        assert radiobutton.isSelected();
        
        System.out.println(radiobutton.isSelected());
        
        // Dropdown
        WebElement testdropdown = driver.findElement(By.id("option"));
        Select dropdown = new Select(testdropdown);
        
        dropdown.selectByIndex(2);
        
        // Checkbox
        WebElement testcheckbox = driver.findElement(By.name("option3"));
        testcheckbox.click();
        
        // Textbox
        String SampleText = "Automation testing is a process of using software tools to execute pre-defined tests on a system or application. It helps ensure quality by identifying bugs and errors. Automated tests are faster, repeatable, and can run anytime, making them ideal for regression testing, reducing manual effort, and increasing efficiency.";
        WebElement textbox = wait.until(ExpectedConditions.elementToBeClickable(By.name("message")));
        textbox.clear();
        textbox.sendKeys(SampleText);

        // Submit button: Wait until the submit button is clickable and click it
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[2]/form/fieldset/button")));
        try {
            // Wait for 3 seconds
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        submitButton.click();
        
        try {
            // Wait for 3 seconds
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Close the browser
        driver.quit();
    }
}
