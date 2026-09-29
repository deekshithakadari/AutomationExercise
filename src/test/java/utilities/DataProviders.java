package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "LoginData")
    public String[][] loginData() throws IOException {

        String path = "C:\\Users\\DELL\\eclipse-workspace\\AutomationExercise\\src\\test\\resources\\WrongLoginCredentialsData.xlsx";

        ExcelUtils excel = new ExcelUtils(path);

        int rows = excel.getRowCount("Sheet1");

        int columns = excel.getCellCount("Sheet1", 0);

        String[][] data = new String[rows][columns];

        for (int i = 1; i <= rows; i++) {

            // Email
            data[i - 1][0] = excel.getCellData("Sheet1", i, 0);

            // Password
            data[i - 1][1] = excel.getCellData("Sheet1", i, 1);

            // Expected Message
            data[i - 1][2] = excel.getCellData("Sheet1", i, 2);
        }

        return data;
    }
}