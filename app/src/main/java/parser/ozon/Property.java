package parser.ozon;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Property {

         private static final String PROPERTIES = "app.config";
        private static String data;

        public static String get(String property){
            getProperties(property);
            return data;
        }

        private static void getProperties(String property){
            FileInputStream fileInputStream;
            Properties props = new Properties();
            try {
                fileInputStream = new FileInputStream(Property.PROPERTIES);
                props.load(fileInputStream);
                data = props.getProperty(property);
            } catch (IOException e) {
                System.out.println("file not found " + Property.PROPERTIES);
            }
        }
    }