package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import util.DriverFactorySingleton;
import java.io.IOException;

public class BaseTest {

    @BeforeTest(alwaysRun = true)
    public void setUp() {
    }

    @BeforeMethod
    public void profileSetUp() throws IOException {
        DriverFactorySingleton.getInstance().setDriver();
        DriverFactorySingleton.getInstance().getDriver();
        DriverFactorySingleton.getInstance().getBrowserURL();
    }

    @AfterMethod
    public void tearDown() {
        DriverFactorySingleton.getInstance().driverClose();
    }

}
