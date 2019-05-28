package pageObjectWowHead;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageResultat extends AbstractPage {

	public PageResultat(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//a[@href='#npcs']")
	private WebElement ongletPNJ;
	
	public void ongletPNJ() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		ongletPNJ.click();
		wait.until(ExpectedConditions.attributeToBe(ongletPNJ, "class", "selected"));
	}
	
	public void selectBossRechercher (String boss) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement bossRechercher = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='icon-boss-padded']/a[.='"+boss+"']")));
		bossRechercher.click();
			
	}

}
