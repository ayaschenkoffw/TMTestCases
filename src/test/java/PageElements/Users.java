package PageElements;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import sun.nio.cs.ext.ISO2022_CN;
import sun.nio.cs.ext.ISO2022_CN_CNS;

import javax.jws.soap.SOAPBinding;
import java.io.*;
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
    private String name;
    private String country;
    private String emailaddress;
    private String phone;
    private String zipcode;
    private String state;
    private String city;

    public void setValue(String pathToPropertiesFile) throws FileNotFoundException {
        FileInputStream fileInputStream;
        Properties properties = new Properties();
        fileInputStream = new FileInputStream(pathToPropertiesFile);
        try{properties.load(new InputStreamReader(fileInputStream, "UTF-8"));
            this.name = properties.getProperty("username");
            this.country = properties.getProperty("country");
            this.emailaddress = properties.getProperty("emailaddress");
            this.phone = properties.getProperty("phone");
            this.zipcode = properties.getProperty("zipcode");
            this.state = properties.getProperty("state");
            this.city = properties.getProperty("city");
        }
        catch (Exception e){};




    }

    public String getName(){ return name; }
    public String getCountry(){ return country; }
    public String getEmailaddress(){ return UUID.randomUUID().toString()+emailaddress; }
    public String getPhone(){ return phone; }
    public String getZipcode(){
        return zipcode;
    }
    public String getState(){
        return state;
    }
    public String getCity(){
        return city;
    }
}


