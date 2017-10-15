package PageElements;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import sun.nio.cs.ext.ISO2022_CN;
import sun.nio.cs.ext.ISO2022_CN_CNS;

import javax.jws.soap.SOAPBinding;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Properties;
import java.util.UUID;
//import PageElements.User1;

public class Users {

    public String pullOutOfPropertiesFile(String propertyKey, String choosePropFile) throws Exception {
        FileInputStream fileInputStream;
        Properties properties = new Properties();
        fileInputStream = new FileInputStream("src/test/resources/"+choosePropFile);
        properties.load(new InputStreamReader(fileInputStream, "UTF-8"));
        String propertyValue = properties.getProperty(propertyKey);
        return propertyValue;

    }
}





