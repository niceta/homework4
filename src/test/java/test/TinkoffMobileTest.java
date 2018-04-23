package test;

import org.testng.annotations.Test;
import pages.TariffsPage;
import pages.TinkoffMobilePage;
import pages.TinkoffPage;

public class TinkoffMobileTest extends BaseRunner {
    @Test
    public void test() {
        TinkoffPage tinkoff = app.tinkoffPage;
        tinkoff.open();
        tinkoff.click(tinkoff.mobileButton);

        TinkoffMobilePage tinkoffMobile = app.tinkoffMobilePage;
        tinkoffMobile.click(tinkoffMobile.tariffsButton);

        TariffsPage tariffs = app.tariffsPage;
        tariffs.scrollTo(tariffs.accordion);
        String price = tariffs.getPrice();

        tariffs.click(tariffs.zeroMinutes);
        tariffs.click(tariffs.zeroGb);
        tariffs.click(tariffs.messToggle);
        tariffs.click(tariffs.networkToggle);

        Validator priceValidator = new Validator(tariffs.price);
        priceValidator.validateText("0 \u20BD");

        Validator getSimValidator = new Validator(tariffs.getSimButton);
        getSimValidator.validateEnabled(false);

        tariffs.refresh();

        tariffs.scrollTo(tariffs.accordion);
        tariffs.sleep(1000);
        priceValidator.validateText(price);

        tariffs.click(tariffs.unlimInternet);
        Validator otherElementsValidator = new Validator(tariffs.limitedElements);
        otherElementsValidator.validateElementsNotVisible();

        String unlimPrice = tariffs.getPrice();
        tariffs.click(tariffs.fifteen);
        //tariffs.scrollTo(tariffs.musicToggle);
        tariffs.click(tariffs.musicToggle);
        tariffs.click(tariffs.videoToggle);

        priceValidator.validateValueLessThan(unlimPrice);

        tariffs.scrollTo(tariffs.mobileButton);
        tariffs.click(tariffs.mobileButton);

        tinkoffMobile.click(tinkoffMobile.simCardButton);

        Validator calcValudator = new Validator(tinkoffMobile.calculator);
        calcValudator.validateVisible(true);
    }
}
