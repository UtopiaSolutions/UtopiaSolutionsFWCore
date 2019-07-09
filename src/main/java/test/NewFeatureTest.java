package test;

import com.usf.utils.parsers.Parser;
import org.testng.annotations.Test;

import static com.usf.utils.ConfigurationReader.getConfigValue;
import static com.usf.utils.ConfigurationReader.readConfigurations;

public class NewFeatureTest {

    @Test
    public static void featureTest() {
        readConfigurations();
        Parser parser = new Parser(getConfigValue("metadata-path"), "c-metadata");

        parser.parseFile();

    }
}
