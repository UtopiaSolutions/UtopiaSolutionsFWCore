package test;

import com.usf.utils.ConfigurationReader;
import org.testng.annotations.Test;

public class NewFeatureTest {

    @Test
    public static void featureTest() {
        ConfigurationReader config = new ConfigurationReader("config.properties");
        System.out.println(config.getConfigValue("testval"));


    }
}
