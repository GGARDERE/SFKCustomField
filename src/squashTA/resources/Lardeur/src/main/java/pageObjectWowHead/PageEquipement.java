package pageObjectWowHead;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageEquipement extends AbstractPage{

	
	public PageEquipement(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public List<String> recupStatObjet() {
		List<WebElement> toto =   driver.findElements(By.xpath("//div[@class='text']//div[@data-visible]//span"));
		List<String> listCaracteristiqueObjet = new ArrayList<String>();
		toto.stream().map(WebElement::getText).forEach(listCaracteristiqueObjet::add);
		return listCaracteristiqueObjet;
	}
	
}
