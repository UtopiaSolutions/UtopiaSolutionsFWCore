package test;

import com.usf.utils.DataGenerator;
import org.testng.annotations.Test;

public class NewFeatureTest {

    @Test
    public static void featureTest() {

        DataGenerator.generatePhoneNumber();

    }
}
