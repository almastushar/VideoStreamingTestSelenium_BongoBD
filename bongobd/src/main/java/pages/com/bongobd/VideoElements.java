package pages.com.bongobd;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VideoElements {
	WebDriver driver;

	public VideoElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='/watch/mrci3FYUx71']")
	WebElement VideoContent;

	@FindBy(xpath = "//VIDEO[@id='vid1_html5_api']")
	WebElement VideoFrame;

	@FindBy(xpath = "//button[@title='Play']")
	WebElement PlayButton;

	@FindBy(xpath = "//button[@title='Pause']")
	WebElement PauseButton;

	@FindBy(xpath = "//H3")
	WebElement VideoTitle;

	@FindBy(css = ".vjs-remaining-time-display")
	WebElement VideoTime;

	@FindBy(css = ".videoAdUiSkipButtonExperimentalText")
	WebElement SkipButton;

	public void ClickVideoContent() {
		VideoContent.click();
	}

	public WebElement Content() {
		return VideoContent;
	}

	public Boolean VideoFrame() {
		Boolean visible = VideoFrame.isDisplayed();
		return visible;
	}

	public String VideoTitle() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		VideoTitle = wait.until(ExpectedConditions.visibilityOf(VideoTitle));
		String string = VideoTitle.getText();
		return string;
	}

	public String Time() {
		WebDriverWait wait = new WebDriverWait(driver, 70);
		VideoTime = wait.until(ExpectedConditions.visibilityOf(VideoTime));
		String string = VideoTime.getText();
		return string;
	}

	public WebElement TimeElement() {
		return VideoTime;
	}

	/*
	 * public void PlayButton() { WebDriverWait wait = new WebDriverWait(driver,
	 * 70); PlayButton = wait.until(ExpectedConditions.visibilityOf(PlayButton));
	 * PlayButton.click(); }
	 * 
	 * public void PauseButton() { WebDriverWait wait = new WebDriverWait(driver,
	 * 70); PauseButton = wait.until(ExpectedConditions.visibilityOf(PauseButton));
	 * PauseButton.click(); }
	 *
	 * public void ClickSkipButton() { SkipButton.click(); }
	 * 
	 * public WebElement SkipButtonElement() { return SkipButton; }
	 * 
	 */
}
