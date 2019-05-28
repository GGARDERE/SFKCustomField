package pageObjectWowHead;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
	protected final WebDriver driver;
	
	public AbstractPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super();
		this.driver = driver;
	}
	
	@FindBy(xpath="//div[contains(@class, 'banner_enter')]/button[.='Continue Using Site']")
	private WebElement boutonContinueOnSite;
	
	@FindBy(xpath="//div[@class='cookie-settings-actions']/button[@class='cookie-settings-actions-opt-in btn btn-small btn-site']")
	private WebElement boutonAcceptCookies;
	
	@FindBy(xpath="//*[@id='zul-bar']//a[@class='zul-bar-user-item-locale zul-bar-icon-spacing hassubmenu']")
	private WebElement listeLangue;
	
	@FindBy(xpath="//div[@class='menu-outer']//span[.='Français']")
	private WebElement langueFrançais;
	
	@FindBy(xpath="//div[@class='header-search']//input")
	private WebElement champRehercheRapide;
	
	@FindBy(xpath="//div[@class='header-search']/a")
	private WebElement boutonRecherche;
	
	public void navAccepted() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(boutonContinueOnSite));
		boutonContinueOnSite.click();
		
	}

	public void cookiesAccepted() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(boutonAcceptCookies));
		boutonAcceptCookies.click();
	}
	
	public void changementLague(String langue) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(listeLangue));
		listeLangue.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='menu-outer']//span[.='"+langue+"']")));
		WebElement boutonLangue = driver.findElement(By.xpath("//div[@class='menu-outer']//span[.='"+langue+"']"));
		boutonLangue.click();
	}
	
	public PageResultat recherche(String recherche1) {

		champRehercheRapide.sendKeys(recherche1);
		boutonRecherche.click();
		return PageFactory.initElements(driver, PageResultat.class);
	}
	public List<String> loadFile(String filePath) throws FileNotFoundException {
	   
	    URI uri = null;
	    Scanner s = new Scanner(new File(filePath), "UTF-8");
	    ArrayList<String> list = new ArrayList<String>();
	    while (s.hasNextLine()){
	        list.add(s.nextLine());
	    }
	    s.close();
	   
	    return list;
	}
}
