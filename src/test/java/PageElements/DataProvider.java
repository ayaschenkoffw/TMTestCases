package PageElements;


public class DataProvider {
    @org.testng.annotations.DataProvider(name = "pathList")

    public Object[][] getData() throws Exception {
        Object[][] data = new Object[2][1];
        data[0][0] = "src/test/resources/ukraineUser.properties";
        data[1][0] = "src/test/resources/usaUser.properties";
        return data;
    }

    @org.testng.annotations.DataProvider(name = "languageList")
    public Object[][] getLangData() throws Exception {
        Object[][] data = new Object[3][1];
        data[0][0] = "CN";
        data[1][0] = "UA";
        data[2][0] = "ES";

        return data;
    }

}