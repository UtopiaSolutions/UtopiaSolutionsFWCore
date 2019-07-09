package test;

import com.usf.utils.parsers.Parser;
import org.testng.annotations.Test;

import static com.usf.utils.ConfigurationReader.getConfigValue;

public class NewFeatureTest extends BaseUITest {

    @Test
    public static void featureTest() {
        Parser parser = new Parser(getConfigValue("metadata-path"), "metadata");

        parser.parseFile();

    }
}
