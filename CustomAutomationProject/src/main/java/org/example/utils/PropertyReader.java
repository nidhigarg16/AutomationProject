package org.example.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader
{
  static Properties properties;

  public PropertyReader()
  {
      loadAllProperties();
  }

  public void loadAllProperties()
  {
      properties = new Properties();

      try {
          String fileName = System.getProperty("user.dir") + "/src/main/resources/config.properties";
          properties.load(new FileInputStream(fileName));
      }
      catch (Exception e){
          throw new RuntimeException("Failed to load properties file");
      }
  }

  public static String readItems(String propertyName)
  {
      return properties.getProperty(propertyName);
      //System.out.println("Hello");
  }
}
