package pagefactory.com.bongobd;

import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotSame;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.com.bongobd.VideoElements;


public class TestVideo {	
	WebDriver driver = new ChromeDriver(); 
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	VideoElements Videos = new VideoElements(driver);
	
	@BeforeClass
	public void BeforeTest(){
		String baseURL= "https://bongobd.com/";
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();		
	}
	
	@Test (priority=1)
	public void ClickVideoContent() throws InterruptedException{
		js.executeScript("arguments[0].scrollIntoView();", Videos.Content());
		Thread.sleep(2000);
		Videos.ClickVideoContent();
		assertEquals(Videos.VideoTitle(), "Jannat Episode - 01");
	}
	
	@Test (priority=2)
	public void LoadContent(){
		boolean v = Videos.VideoFrame();
		assertEquals(v, true);
	}
	
	@Test (priority=3)
	public void PlayVideoContent() throws InterruptedException{
		Thread.sleep(5000);
		String IntitialTime = Videos.Time();
		System.out.println(IntitialTime);
		Thread.sleep(10000);
		String AfterSomeTime = Videos.Time();
		System.out.println(AfterSomeTime);
		assertNotEquals(AfterSomeTime, IntitialTime);
	}
	
	@AfterClass
	public void AfterTest() {
		driver.close();
	}

}
