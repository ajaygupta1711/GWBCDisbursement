package Disbursement.GWBCDisbursement;

public class BCDisbursement extends BCLoginAndDisburseProcess {

	public static void main(String[] args) {
		
		BCLoginAndDisburseProcess bcld = new BCLoginAndDisburseProcess();
		bcld.openBrowser();
		bcld.enterCredentials();
		bcld.createDisbursementProcess();
	}

}
