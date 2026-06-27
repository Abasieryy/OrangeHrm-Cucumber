package tests.baseTest;

import org.openqa.selenium.WebDriver;
import pages.*;
import tests.Reuse.ConfigManager;
import tests.Reuse.ExcelManager;

public class BaseTest {

    public static WebDriver driver;

    public static ConfigManager configManager;

    public static ExcelManager excelManger;

    public static LoginPage loginPage;

    public static LogoutPage logoutPage;
    public static EmployeeListPage employeeListPage;

    public static AddEmployeePage addEmployeePage;

    public static PersonalDetailsPage personalDetailsPage;

}