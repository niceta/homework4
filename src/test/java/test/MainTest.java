package test;

import org.testng.annotations.Test;
import pages.*;

public class MainTest extends BaseRunner {
    @Test
    void test() {
        GooglePage google = app.googlePage;
        google.open();
        google.search("tinkoff");

        GoogleResultPage googleResult = app.googleResultPage;
        googleResult.goTo("https://www.tinkoff.ru/");
        app.switchWindow("Лучший интернет-банк");

        TinkoffPage tinkoff = app.tinkoffPage;
        tinkoff.click(tinkoff.payments);

        TinkoffPaymentsPage tinkoffPayments = app.paymentsPage;
        tinkoffPayments.search("Тинькофф Мобайл");

        TinkoffMobilePayPage tinkoffMobile = app.mobilePage;
        tinkoffMobile.validatePhone("1123c!@sdfgs5gs54#sg5s$#%#Fr3234543tf33453f4");
        tinkoffMobile.validateAmount("14$#%*228/14+1223-");
    }
}
