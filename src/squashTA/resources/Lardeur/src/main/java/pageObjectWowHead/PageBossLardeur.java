package pageObjectWowHead;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageBossLardeur extends AbstractPage{

	public PageBossLardeur(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//a[@href='#npcs']")
	private WebElement ongletButin;	
	
	public PageEquipement selectionEquipement(String valueEquipement) {
		WebElement pieceButin = driver.findElement(By.xpath("//a[.='"+valueEquipement+"']"));
		pieceButin.click();
		return PageFactory.initElements(driver, PageEquipement.class);
	}
}
