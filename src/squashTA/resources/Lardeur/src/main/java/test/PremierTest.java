package test;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pageObjectWowHead.HomePage;
import pageObjectWowHead.PageBossLardeur;
import pageObjectWowHead.PageEquipement;
import pageObjectWowHead.PageResultat;

public class PremierTest extends AbstractTest{

	@Test
	
	public void run () throws InterruptedException, FileNotFoundException {
	String langue = "Français"; 
	String recherche1= "Lardeur";
		System.out.println("Debut du test");
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		System.out.println("Accepter données navigation Anglais");
		Thread.sleep(2000);
		homePage.navAccepted();
		Thread.sleep(2000);
		homePage.cookiesAccepted();
		System.out.println("Choix langue Francais");
		homePage.changementLague(langue);
		Thread.sleep(2000);
		homePage.navAccepted();
		Thread.sleep(2000);
		homePage.cookiesAccepted();
		System.out.println("Recherche Lardeur");
		PageResultat pageResultat = homePage.recherche(recherche1);
		System.out.println("Ouverture Onglet PNJ");
		pageResultat.ongletPNJ();
		System.out.println("Ouverture page Lardeur Boss");
		pageResultat.selectBossRechercher(recherche1);
		PageBossLardeur pageBossLardeur = PageFactory.initElements(driver, PageBossLardeur.class);
		System.out.println("Verif item 1");
		PageEquipement pageEquipement = pageBossLardeur.selectionEquipement("Chahuteurs de cadavre");
		List<String> statObjet1 = pageEquipement.recupStatObjet();
		List<String> listeRefObjet1 = pageEquipement.loadFile("src/main/resources/filesRessources/item1");
		Assert.assertEquals(listeRefObjet1, statObjet1);
		driver.navigate().back();
		System.out.println("Verif item 2");
		pageBossLardeur.selectionEquipement("Chausses de Lardeur");
		List<String> statObjet2 = pageEquipement.recupStatObjet();
		List<String> listeRefObjet2 = pageEquipement.loadFile("src/main/resources/filesRessources/item2");
		Assert.assertEquals(listeRefObjet2, statObjet2);
		driver.navigate().back();
		System.out.println("Verif item 3");
		pageBossLardeur.selectionEquipement("Pioche en fer froid");
		List<String> statObjet3 = pageEquipement.recupStatObjet();
		List<String> listeRefObjet3 = pageEquipement.loadFile("src/main/resources/filesRessources/item3");
		Assert.assertEquals(listeRefObjet3, statObjet3);
		driver.navigate().back();
		System.out.println("Verif item 4");
		pageBossLardeur.selectionEquipement("Grèves de geôlier volées");
		List<String> statObjet4 = pageEquipement.recupStatObjet();
		List<String> listeRefObjet4 = pageEquipement.loadFile("src/main/resources/filesRessources/item4");
		Assert.assertEquals(listeRefObjet4, statObjet4);
		driver.navigate().back();
		System.out.println("Verif item 5");
		pageBossLardeur.selectionEquipement("Espauliers de Tourne-Clé");
		List<String> statObjet5 = pageEquipement.recupStatObjet();
		List<String> listeRefObjet5 = pageEquipement.loadFile("src/main/resources/filesRessources/item5");
		Assert.assertEquals(listeRefObjet5, statObjet5);
		driver.navigate().back();
	}
	
	
}
