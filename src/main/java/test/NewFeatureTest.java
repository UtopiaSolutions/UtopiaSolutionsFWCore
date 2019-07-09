package test;

import com.usf.metadata.Metadata;
import com.usf.utils.parsers.Parser;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Map;

import static com.usf.utils.ConfigurationReader.getConfigValue;

/**
 * This class is FOR UNIT TESTING ONLY -
 * when additions are made to the framework core,
 * they are tested here for bugs and compilation errors.
 */
public class NewFeatureTest extends BaseUITest {

    @Test
    public static void featureTest() {
        Parser parser = new Parser(getConfigValue("metadata-path"), "metadata");

        parser.parseFile();


        Iterator it = Metadata.getInstance().getMetadata().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }

    }
}
