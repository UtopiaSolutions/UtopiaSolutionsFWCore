package test;

import com.usf.utils.parsers.JSONReader;
import com.usf.utils.parsers.Parser;
import org.testng.annotations.Test;

public class NewFeatureTest {

    @Test
    public static void featureTest() {
        Parser parser = new JSONReader();


        parser.parse("metadata");

    }
}
