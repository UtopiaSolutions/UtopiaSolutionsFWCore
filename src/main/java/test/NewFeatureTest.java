package test;

import com.usf.utils.DataConverter;
import org.testng.annotations.Test;

public class NewFeatureTest {

    @Test
    public static void featureTest() {

        System.out.println(DataConverter.generateDate("05/05/2085",20, DataConverter.TimeOption.YEARS, DataConverter.DateOption.FUTURE, "dd/MM/YYYY"));
    }
}
