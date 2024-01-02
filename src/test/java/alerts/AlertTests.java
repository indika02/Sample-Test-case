package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AlertTests extends BaseTests {

    @Test
    public void testAcceptAlert(){
        var alertsPage=homePage.clickJavaScriptAlerts();
        alertsPage.triggerAlert();
        alertsPage.alert_clickAccept();
        assertEquals(alertsPage.getResult(),"You successfully clicked an alert","Alert text Incorrect!");
    }
    @Test
    public void testGetTextFromAlert(){
        var alertsPage=homePage.clickJavaScriptAlerts();
        alertsPage.triggerConfirm();
        String text=alertsPage.alert_getText();
        alertsPage.alert_clickToDismiss();
        assertEquals(text,"I am a JS Alert","Alert text incorrect" );
    }

    @Test
    public void testSetInputInAlert() {
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerPrompt();
        String text="TAU rocks!";
        alertsPage.alert_clickAccept();
        assertEquals(alertsPage.getResult(),"You entered: "+text,"Results text incorrect");
    }

}
