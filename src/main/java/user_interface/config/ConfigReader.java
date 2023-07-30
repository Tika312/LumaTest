package user_interface.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    // Статический блок все поля,методы внутри этого блока буду статичными

    static {
            try {
                String path = "src/main/resources/app.properties";
                FileInputStream input  = new FileInputStream(path);
                properties = new Properties();
                properties.load(input);
                input.close();
            }catch (IOException e){
                e.printStackTrace();
            }
    }

    public static String getPropertyOf(String key){
        return properties.getProperty(key).trim();
    }

}
