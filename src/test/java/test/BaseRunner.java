package test;

import app.Application;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseRunner {
    public Application app;

    @BeforeClass
    public void start() {
        app = new Application();
    }

    @AfterClass
    public void tearDown() {
        app.quit();
    }
}
