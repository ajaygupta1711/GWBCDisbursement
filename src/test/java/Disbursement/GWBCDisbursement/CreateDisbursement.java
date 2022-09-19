package Disbursement.GWBCDisbursement;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateDisbursement {
	
	static WebDriver driver;
	
	public static void createDisbursementProcess()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// Search the account number
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='TabBar-AccountsTab']//div[@class='gw-icon gw-icon--expand']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("TabBar-AccountsTab-AccountNumberSearchItem"))).sendKeys("6060362");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar-AccountsTab-AccountNumberSearchItem_Button"))).click();
		
		// Go to Actions > New Transactions > Disbursement
		 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("AccountGroup-AccountDetailMenuActions"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='AccountGroup-AccountDetailMenuActions-AccountDetailMenuActions_NewTransaction']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='AccountGroup-AccountDetailMenuActions-AccountDetailMenuActions_NewTransaction']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='AccountGroup-AccountDetailMenuActions-AccountDetailMenuActions_NewTransaction-AccountDetailMenuActions_Disbursement'] [class='gw-action--inner gw-hasDivider']"))).click();
		
		// Enter mandatory fields details on Account Disbursement Wizard screen
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("AccountCreateDisbursementWizard-CreateDisbursementDetailScreen-CreateDisbursementDetailDV-amount"))).sendKeys("10");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("AccountCreateDisbursementWizard-CreateDisbursementDetailScreen-CreateDisbursementDetailDV-effectiveDate"))).sendKeys("10/26/2022");
		
		WebElement reason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("AccountCreateDisbursementWizard-CreateDisbursementDetailScreen-CreateDisbursementDetailDV-reason")));
		Select reasonDropdown = new Select(reason);
		reasonDropdown.selectByVisibleText("Overpayment");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Next')]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("AccountCreateDisbursementWizard-Finish"))).click();
		
	}
}