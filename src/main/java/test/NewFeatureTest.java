package test;

import com.usf.utils.DataConverter;
import org.testng.annotations.Test;

public class NewFeatureTest {

    @Test
    public static void featureTest() {

        System.out.println(DataConverter.generateCountry());
        System.out.println(DataConverter.generateCountryCode());

    }
}
