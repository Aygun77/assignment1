import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoProject1 {
    public static void main(String[] args) throws InterruptedException {

        // Verify that login was successful

        System.setProperty("webdriver.chrome.driver","/Users/aygunaliyeva/Desktop/browsers/chromedriver");

        //Open a browser
        WebDriver driver = new ChromeDriver();

        //Navigate
        driver.get(" http://qa-duotify.us-east-2.elasticbeanstalk.com/register.php");
        //title
        String actualTitle = driver.getTitle();
        String expectedTitle = "Welcome to Duotify!";
        if(actualTitle.equals(expectedTitle)){
          System.out.println("Passed: " + actualTitle);
       }else{
           System.out.println("Fail: " + actualTitle);
      }

        // click sign up
        String s = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPGTSTIVWXYZ";
        String username = "";
        for (int i = 0; i < 5; i++) {
            username=username+s.charAt((int) (Math.random() * s.length()));;
        }
        driver.findElement(By.id("hideLogin")).click();
        // fill out the form
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.name("firstName")).sendKeys("Ay");
        driver.findElement(By.name("lastName")).sendKeys("Ali");
        driver.findElement(By.id("email")).sendKeys(username + "@gmail.com");
        driver.findElement(By.id("email2")).sendKeys(username + "@gmail.com");
        driver.findElement(By.id("password")).sendKeys("12345");
        driver.findElement(By.id("password2")).sendKeys("12345");
        // Sign up
        driver.findElement(By.name("registerButton")).click();
        // verify that the URL
        String currentUrl= driver.getCurrentUrl();
        String expectedUrl = "http://qa-duotify.us-east-2.elasticbeanstalk.com/browse.php?";
        if(currentUrl.equals(expectedUrl)){
            System.out.println("Passed: "+ currentUrl);
        }else{
            System.out.println("Fail: " + currentUrl);
        }

        //then click logout.
        driver.findElement(By.id("nameFirstAndLast")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("rafael")).click(); // logout
//        driver.findElement(By.id("rafael")).click();

        // verify Url
        String currentUrl2= driver.getCurrentUrl();
        String expectedUrl2 = "http://qa-duotify.us-east-2.elasticbeanstalk.com/register.php";
        if(currentUrl.equals(expectedUrl)){
            System.out.println("Passed: "+ currentUrl2);
        }else{
            System.out.println("Fail: " + currentUrl2);
        }
        Thread.sleep(2000);
        driver.findElement(By.id("loginUsername")).sendKeys(username);
        Thread.sleep(2000);
        driver.findElement(By.id("loginPassword")).sendKeys("12345");

        driver.findElement(By.name("loginButton")).click();
        Thread.sleep(2000);
        System.out.println(driver.getPageSource().contains("You Might Also Like"));

//
//       Thread.sleep(1000);
//        driver.quit();

    }
}



