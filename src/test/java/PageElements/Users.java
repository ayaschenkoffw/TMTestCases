package PageElements;


import sun.nio.cs.ext.ISO2022_CN;
import sun.nio.cs.ext.ISO2022_CN_CNS;

import javax.jws.soap.SOAPBinding;
import java.io.*;
import java.util.Properties;
import java.util.UUID;

public class Users {


    private String name;
    private String country;
    private String emailaddress;
    private String phone;
    private String zipcode;
    private String state;
    private String city;

    public Users(String pathToPropertiesFile)  {
        FileInputStream fileInputStream;
        Properties properties = new Properties();

        try{
            fileInputStream = new FileInputStream(pathToPropertiesFile);
            properties.load(new InputStreamReader(fileInputStream, "UTF-8"));
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


