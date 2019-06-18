package test;

import org.testng.annotations.Test;

import static com.usf.utils.DataConverter.CardOption.*;
import static com.usf.utils.DataConverter.NameOption.*;
import static com.usf.utils.DataConverter.PersonOption.*;
import static com.usf.utils.DataConverter.StringOption.*;
import static com.usf.utils.DataConverter.*;
import static me.xdrop.jrand.model.money.CardType.*;
import static me.xdrop.jrand.model.person.Gender.FEMALE;
import static me.xdrop.jrand.model.person.Gender.MALE;

public class NewFeatureTest {

    @Test
    public static void featureTest() {

        System.out.println("Random Names:");
        System.out.println("-----------------------------");
        System.out.println("Random Full Name: " +

                generateName());

        System.out.println("Random MALE Full Name: " +

                generateName(MALE));

        System.out.println("Random FEMALE Full Name: " +

                generateName(FEMALE));

        System.out.println("Random Full Name with Title: " +

                generateName(WITH_TITLE));

        System.out.println("Random Full name with Middle Name: " +

                generateName(WITH_MIDDLENAME));

        System.out.println("Random MALE Full Name With Title: " +

                generateName(MALE, WITH_TITLE));

        System.out.println("Random MALE Full Name with Middle Name: " +

                generateName(MALE, WITH_MIDDLENAME));

        System.out.println("Random FEMALE Full Name with Title: " +

                generateName(FEMALE, WITH_TITLE));

        System.out.println("Random FEMALE Full Name with Middle Name: " +

                generateName(FEMALE, WITH_MIDDLENAME));

        System.out.println("Random Full Name, Last Name First: " +

                generateName(LASTNAME_FIRST));

        System.out.println("Random MALE Full Name, Last Name First: " +

                generateName(MALE, LASTNAME_FIRST));

        System.out.println("Random FEMALE Full Name, Last Name First: " +

                generateName(FEMALE, LASTNAME_FIRST));

        System.out.println("Random First Name Only: " +

                generateName(FIRSTNAME_ONLY));

        System.out.println("Random MALE First Name Only: " +

                generateName(MALE, FIRSTNAME_ONLY));

        System.out.println("Random FEMALE First Name Only: " +

                generateName(FEMALE, FIRSTNAME_ONLY));

        System.out.println("Random Last Name Only: " +

                generateName(LASTNAME_ONLY));

        System.out.println();
        System.out.println("Random Ages:");
        System.out.println("-----------------------------");
        System.out.println("Random Age: " +

                generateAge());

        System.out.println("Random Age between 5 - 50: " +

                generateAge(5, 50));

        System.out.println("Random Child Age: " +

                generateAge(CHILD));

        System.out.println("Random Teen Age: " +

                generateAge(TEEN));

        System.out.println("Random Adult Age: " +

                generateAge(ADULT));

        System.out.println("Random Senior Age: " +

                generateAge(SENIOR));

        System.out.println();
        System.out.println("Random Birthdays:");
        System.out.println("-----------------------------");
        System.out.println("Random Birthday: " +

                generateBirthday());

        System.out.println("Random Birthday with format dd/M/yy: " +

                generateBirthday("dd/M/yy"));

        System.out.println("Random Birthday with format MM/dd/yyyy: " +

                generateBirthday("MM/dd/yyyy"));

        System.out.println("Random Child Birthday: " +

                generateBirthday(CHILD));

        System.out.println("Random Teen Birthday: " +

                generateBirthday(TEEN));

        System.out.println("Random Adult Birthday: " +
                generateBirthday(ADULT));

        System.out.println("Random Senior Birthday: " +
                generateBirthday(SENIOR));

        System.out.println("Random Child Birthday format mm/DD/yyyy: " +

                generateBirthday(CHILD, "mm/DD/yyyy"));

        System.out.println("Random Teen Birthday format d/m/yy: " +

                generateBirthday(TEEN, "d/m/yy"));

        System.out.println("Random Adult Birthday format dd/M/yy: " +

                generateBirthday(ADULT, "dd/M/yy"));

        System.out.println("Random Senior Birthday format mm/d/yyyy: " +

                generateBirthday(SENIOR, "mm/d/yyyy"));

        System.out.println();
        System.out.println("Credit Card Info:");
        System.out.println("-----------------------------");
        System.out.println("Random Card Number: " +

                generateCardNumber());

        System.out.println("Random Formatted Card Number: " +

                generateCardNumber(FORMATTED));

        System.out.println("Random Common Card Number: " +

                generateCardNumber(COMMON));

        System.out.println("Random Formatted Common Card Number: " +

                generateCardNumber(COMMON_FORMATTED));

        System.out.println("Random Common Card Number XXX XXXX XXX XX: " +

                generateCardNumber("XXX XXXX XXX XX"));

        System.out.println("Random AMEX Card Number: " +

                generateCardNumber(AMERICAN_EXPRESS));

        System.out.println("Random FORMATTED AMEX Card Number: " +

                generateCardNumber(AMERICAN_EXPRESS, FORMATTED));

        System.out.println("Random MASTERCARD Card Number: " +

                generateCardNumber(MASTERCARD));

        System.out.println("Random FORMATTED MASTERCARD Card Number: " +

                generateCardNumber(MASTERCARD, FORMATTED));

        System.out.println("Random VISA Card Number: " +

                generateCardNumber(VISA));

        System.out.println("Random FORMATTED VISA Card Number: " +

                generateCardNumber(VISA, FORMATTED));

        System.out.println("Random DISCOVER Card Number: " +

                generateCardNumber(DISCOVER));

        System.out.println("Random FORMATTED DISCOVER Card Number: " +

                generateCardNumber(DISCOVER, FORMATTED));

        System.out.println();
        System.out.println("CVV:");
        System.out.println("Random CVV Number: " +

                generateCVV());

        System.out.println("Random Amex CVV Number: " +

                generateCVV(true));

        System.out.println();
        System.out.println("Issue Date:");
        System.out.println("Random Issue Date: " +

                generateCardIssueDate());

        System.out.println("Random Issue Date with full year: " +

                generateCardIssueDate(FULL_YEAR));

        System.out.println();
        System.out.println("Expiry Date:");
        System.out.println("Random Expiry Date: " +

                generateExpiryDate());

        System.out.println("Expiry Date with Full Year: " +

                generateExpiryDate(FULL_YEAR));

        System.out.println("Expiry date that is Expired: " +

                generateExpiryDate(EXPIRED));

        System.out.println();
        System.out.println("BASIC Data:");
        System.out.println("-----------------------------");
        System.out.println("Random Boolean: " +

                generateBoolean());

        System.out.println("Random Decimal: " +

                generateDecimal());

        System.out.println("Random Decimal Within A Provided Range of 6.77 - 88.99: " +

                generateDecimal(6.77, 88.99));

        System.out.println("Random String: " +

                generateRandomString());

        System.out.println("Random String Of Only Alpha Characters: " +

                generateRandomString(ALPHA));

        System.out.println("Random String Of Only Numbers: " +

                generateRandomString(DIGIT));

        System.out.println("Random String Of Only Symbols: " +

                generateRandomString(SYMBOL));

        System.out.println("Random Word: " +

                generateRandomString(WORD));

        System.out.println("Random Sentence: " +

                generateRandomString(SENTENCE));

        System.out.println("Random Paragraph: " +

                generateRandomString(PARAGRAPH));
    }
}
