package test;

import com.usf.utils.DataConverter;
import me.xdrop.jrand.model.person.Gender;
import org.testng.annotations.Test;

public class NewFeatureTest {

    @Test
    public static void featureTest() {
        System.out.println(DataConverter.generateName(Gender.MALE));

    }
}
