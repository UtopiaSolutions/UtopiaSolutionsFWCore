package com.usf.utils;

import me.xdrop.jrand.JRand;
import me.xdrop.jrand.generators.basics.BoolGenerator;
import me.xdrop.jrand.generators.basics.DecimalGenerator;
import me.xdrop.jrand.generators.basics.StringGenerator;
import me.xdrop.jrand.generators.money.CVVGenerator;
import me.xdrop.jrand.generators.money.CardNumberGenerator;
import me.xdrop.jrand.generators.money.ExpiryDateGenerator;
import me.xdrop.jrand.generators.money.IssueDateGenerator;
import me.xdrop.jrand.generators.person.*;
import me.xdrop.jrand.generators.text.LoremGenerator;
import me.xdrop.jrand.model.money.CardType;
import me.xdrop.jrand.model.person.Gender;
import me.xdrop.jrand.model.person.PersonType;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Random;

/**
 * Wrapper class for JRand functionality
 */
public class DataConverter {

    private static BoolGenerator bool;
    private static DecimalGenerator decimal;
    private static StringGenerator string;
    private static LoremGenerator lorem;
    private static FirstnameGenerator firstname;
    private static LastnameGenerator lastname;
    private static NameGenerator name;
    private static AgeGenerator age;
    private static BirthdayGenerator birthday;
    private static CardNumberGenerator cardNo;
    private static IssueDateGenerator issueDate;
    private static ExpiryDateGenerator expiryDate;
    private static CVVGenerator cvv;


    public enum StringOption {
        SYMBOL, ALPHA, DIGIT,
        WORD, SENTENCE, PARAGRAPH
    }

    public enum NameOption {
        FIRSTNAME_ONLY, LASTNAME_ONLY,
        WITH_MIDDLENAME, WITH_TITLE,
        LASTNAME_FIRST
    }

    public enum PersonOption {
        CHILD, TEEN, ADULT, SENIOR
    }

    public enum CardOption {
        FORMATTED, COMMON, COMMON_FORMATTED,
        FULL_YEAR, EXPIRED
    }

    public enum DateOption {
        FUTURE, PAST
    }

    public enum TimeOption {
        DAYS, WEEKS, MONTHS, YEARS
    }

    //-------------- BASIC --------------------

    public static boolean generateBoolean() {
        bool = JRand.bool();
        return bool.gen();
    }

    public static String generateDecimal() {
        decimal = JRand.decimal();
        return decimal.gen();
    }

    public static String generateDecimal(double min, double max) {
        decimal = JRand.decimal();
        return decimal.range(min, max).gen();
    }

    public static String generateRandomString() {
        string = JRand.string();
        return string.gen();
    }

    public static String generateRandomString(StringOption option) {
        string = JRand.string();
        lorem = JRand.lorem();
        switch (option) {
            case ALPHA:
                return string.alpha().gen();
            case DIGIT:
                return string.digits().gen();
            case SYMBOL:
                return string.symbols().gen();
            case WORD:
                return lorem.single().gen();
            case SENTENCE:
                return lorem.sentences(1).gen();
            case PARAGRAPH:
                return lorem.gen();
            default:
                return string.gen();
        }
    }

    //-------------- PERSON -------------------

    public static String generateName() {
        name = JRand.name();
        return name.gen();
    }

    public static String generateName(Gender gender) {
        name = JRand.name();
        return name.gender(gender).gen();
    }

    public static String generateName(NameOption option) {
        name = JRand.name();
        firstname = JRand.firstname();
        lastname = JRand.lastname();
        switch (option) {
            case FIRSTNAME_ONLY:
                return firstname.gen();
            case LASTNAME_ONLY:
                return lastname.gen();
            case WITH_MIDDLENAME:
                return name.withMiddleName().gen();
            case WITH_TITLE:
                return name.withPrefix().gen();
            case LASTNAME_FIRST:
                return name.reverseOrder().gen();
            default:
                return name.gen();
        }
    }

    public static String generateName(Gender gender, NameOption option) {
        name = JRand.name();
        firstname = JRand.firstname();
        switch (option) {
            case FIRSTNAME_ONLY:
                return firstname.gender(gender).gen();
            case WITH_MIDDLENAME:
                return name.gender(gender).withMiddleName().gen();
            case WITH_TITLE:
                return name.gender(gender).withPrefix().gen();
            case LASTNAME_FIRST:
                return name.gender(gender).reverseOrder().gen();
            default:
                return name.gen();
        }
    }

    public static int generateAge() {
        age = JRand.age();
        return age.gen();
    }

    public static int generateAge(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static int generateAge(PersonOption option) {
        age = JRand.age();
        switch (option) {
            case CHILD:
                return age.child().gen();
            case TEEN:
                return age.teen().gen();
            case ADULT:
                return age.adult().gen();
            case SENIOR:
                return age.senior().gen();
            default:
                return age.personType(PersonType.GENERIC).gen();
        }
    }

    public static String generateBirthday() {
        birthday = JRand.birthday();
        return birthday.american().genString();
    }

    public static String generateBirthday(String format) {
        birthday = JRand.birthday();
        return birthday.format(format).genString();
    }

    public static String generateBirthday(PersonOption option) {
        birthday = JRand.birthday();
        switch (option) {
            case CHILD:
                return birthday.american().child().genString();
            case TEEN:
                return birthday.american().teen().genString();
            case ADULT:
                return birthday.american().adult().genString();
            case SENIOR:
                return birthday.american().senior().genString();
            default:
                return birthday.american().type(PersonType.GENERIC).genString();
        }
    }

    public static String generateBirthday(PersonOption option, String format) {
        birthday = JRand.birthday();
        switch (option) {
            case CHILD:
                return birthday.format(format).child().genString();
            case TEEN:
                return birthday.format(format).teen().genString();
            case ADULT:
                return birthday.format(format).adult().genString();
            case SENIOR:
                return birthday.format(format).senior().genString();
            default:
                return birthday.type(PersonType.GENERIC).genString();
        }
    }

    /**
     * Generate a random birth date from a random age within an age range.
     *
     * @param age1 - the minimum age
     * @param age2 - the maximum age
     * @return String in MM/dd/yy format
     */
    public static String generateBirthday(int age1, int age2) {
        DateTime now = new DateTime();
        DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yy");

        int randomAgeBetween = generateAge(age1, age2);
        int dobYear = now.minusYears(randomAgeBetween).getYear();
        DateTime yearBegin = new DateTime(dobYear, 1, 1, 0, 0);
        long mills = getRandomTimeBetweenTwoDates(now.minusYears(randomAgeBetween).getMillis(), yearBegin.getMillis());

        return formatter.print(new DateTime(mills));
    }

    /**
     * Generate a random birth date in a specified format,
     * from a random age within an age range.
     *
     * @param age1   - the minimum age
     * @param age2   - the maximum age
     * @param format - the date format
     * @return String in specified format
     */
    public static String generateBirthday(int age1, int age2, String format) {
        DateTime now = new DateTime();
        DateTimeFormatter formatter = DateTimeFormat.forPattern(format);

        int randomAgeBetween = generateAge(age1, age2);
        int dobYear = now.minusYears(randomAgeBetween).getYear();
        DateTime yearBegin = new DateTime(dobYear, 1, 1, 0, 0);
        long mills = getRandomTimeBetweenTwoDates(now.minusYears(randomAgeBetween).getMillis(), yearBegin.getMillis());

        return formatter.print(new DateTime(mills));
    }

    // TODO - Get date from today + / - time amount

    /**
     * Generate today's date.
     *
     * @return String in MM/dd/yy format
     */
    public static String generateDate() {
        DateTime now = new DateTime();
        DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yy");

        return formatter.print(now);
    }

    /**
     * Generate today's date in a specified format.
     *
     * @param format - the date format
     * @return String in specified format
     */
    public static String generateDate(String format) {
        DateTime now = new DateTime();
        DateTimeFormatter formatter = DateTimeFormat.forPattern(format);

        return formatter.print(now);
    }

    /**
     * Generate a random future or past date relative to today's date.
     *
     * @param amount    - the amount of time from today's date
     * @param duration  - DAYS, WEEKS, MONTHS, YEARS
     * @param direction - FUTURE, PAST
     * @return String in MM/dd/yy format
     */
    public static String generateDate(int amount, TimeOption duration, DateOption direction) {
        DateTime now = new DateTime();
        DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yy");

        switch (direction) {
            case FUTURE:
                switch (duration) {
                    case DAYS:
                        return formatter.print(now.plusDays(amount));
                    case WEEKS:
                        return formatter.print(now.plusWeeks(amount));
                    case MONTHS:
                        return formatter.print(now.plusMonths(amount));
                    case YEARS:
                        return formatter.print(now.plusYears(amount));
                    default:
                        return formatter.print(now);
                }
            case PAST:
                switch (duration) {
                    case DAYS:
                        return formatter.print(now.minusDays(amount));
                    case WEEKS:
                        return formatter.print(now.minusWeeks(amount));
                    case MONTHS:
                        return formatter.print(now.minusMonths(amount));
                    case YEARS:
                        return formatter.print(now.minusYears(amount));
                    default:
                        return formatter.print(now);
                }
            default:
                return formatter.print(now);
        }
    }

    /**
     * Generate a random future or past date in a specified format,
     * relative to today's date.
     *
     * @param amount    - the amount of time from today's date
     * @param duration  - DAYS, WEEKS, MONTHS, YEARS
     * @param direction - FUTURE, PAST
     * @param format    - the date format
     * @return String in specified format
     */
    public static String generateDate(int amount, TimeOption duration, DateOption direction, String format) {
        DateTime now = new DateTime();
        DateTimeFormatter formatter = DateTimeFormat.forPattern(format);

        switch (direction) {
            case FUTURE:
                switch (duration) {
                    case DAYS:
                        return formatter.print(now.plusDays(amount));
                    case WEEKS:
                        return formatter.print(now.plusWeeks(amount));
                    case MONTHS:
                        return formatter.print(now.plusMonths(amount));
                    case YEARS:
                        return formatter.print(now.plusYears(amount));
                    default:
                        return formatter.print(now);
                }
            case PAST:
                switch (duration) {
                    case DAYS:
                        return formatter.print(now.minusDays(amount));
                    case WEEKS:
                        return formatter.print(now.minusWeeks(amount));
                    case MONTHS:
                        return formatter.print(now.minusMonths(amount));
                    case YEARS:
                        return formatter.print(now.minusYears(amount));
                    default:
                        return formatter.print(now);
                }
            default:
                return formatter.print(now);
        }
    }

    /**
     * Generate a random future or past date in a specified format,
     * relative to a specified date of origin.
     *
     * @param date      - the date of origin, in MM/dd/yy
     * @param amount    - the amount of time from today's date
     * @param duration  - DAYS, WEEKS, MONTHS, YEARS
     * @param direction - FUTURE, PAST
     * @return String in MM/dd/yy format
     */
    public static String generateDate(String date, int amount, TimeOption duration, DateOption direction) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yy");
        DateTime origin = formatter.parseDateTime(date);

        switch (direction) {
            case FUTURE:
                switch (duration) {
                    case DAYS:
                        return formatter.print(origin.plusDays(amount));
                    case WEEKS:
                        return formatter.print(origin.plusWeeks(amount));
                    case MONTHS:
                        return formatter.print(origin.plusMonths(amount));
                    case YEARS:
                        return formatter.print(origin.plusYears(amount));
                    default:
                        return formatter.print(origin);
                }
            case PAST:
                switch (duration) {
                    case DAYS:
                        return formatter.print(origin.minusDays(amount));
                    case WEEKS:
                        return formatter.print(origin.minusWeeks(amount));
                    case MONTHS:
                        return formatter.print(origin.minusMonths(amount));
                    case YEARS:
                        return formatter.print(origin.minusYears(amount));
                    default:
                        return formatter.print(origin);
                }
            default:
                return formatter.print(origin);
        }
    }


    /**
     * Generate a random future or past date in a specified format,
     * relative to a specified date of origin.  Date of origin format MUST
     * be input as specified format.
     *
     * @param date      - the date of origin, input as format
     * @param amount    - the amount of time from today's date
     * @param duration  - DAYS, WEEKS, MONTHS, YEARS
     * @param direction - FUTURE, PAST
     * @param format    - the date format
     * @return String in specified format
     */
    public static String generateDate(String date, int amount, TimeOption duration, DateOption direction, String format) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern(format);
        DateTime origin = formatter.parseDateTime(date);

        switch (direction) {
            case FUTURE:
                switch (duration) {
                    case DAYS:
                        return formatter.print(origin.plusDays(amount));
                    case WEEKS:
                        return formatter.print(origin.plusWeeks(amount));
                    case MONTHS:
                        return formatter.print(origin.plusMonths(amount));
                    case YEARS:
                        return formatter.print(origin.plusYears(amount));
                    default:
                        return formatter.print(origin);
                }
            case PAST:
                switch (duration) {
                    case DAYS:
                        return formatter.print(origin.minusDays(amount));
                    case WEEKS:
                        return formatter.print(origin.minusWeeks(amount));
                    case MONTHS:
                        return formatter.print(origin.minusMonths(amount));
                    case YEARS:
                        return formatter.print(origin.minusYears(amount));
                    default:
                        return formatter.print(origin);
                }
            default:
                return formatter.print(origin);
        }
    }

    //-------------- MONEY -------------------

    public static String generateCardNumber() {
        cardNo = JRand.cardNo();
        return cardNo.gen();
    }

    public static String generateCardNumber(CardOption option) {
        cardNo = JRand.cardNo();
        switch (option) {
            case COMMON:
                return cardNo.common().gen();
            case FORMATTED:
                return cardNo.format(true).gen();
            case COMMON_FORMATTED:
                return cardNo.common().format(true).gen();
            default:
                return cardNo.gen();
        }
    }

    public static String generateCardNumber(String format) {
        cardNo = JRand.cardNo();
        return cardNo.format(format).gen();
    }

    public static String generateCardNumber(CardType cardType) {
        cardNo = JRand.cardNo();
        return cardNo.cardType(cardType).gen();
    }

    public static String generateCardNumber(CardType cardType, CardOption option) {
        cardNo = JRand.cardNo();
        if (option == CardOption.FORMATTED) {
            return cardNo.cardType(cardType).format().gen();
        } else {
            return cardNo.cardType(cardType).gen();
        }
    }

    //TODO - ????? add Generate Valid <cc company> Number methods ?????

    public static String generateCardIssueDate() {
        issueDate = JRand.issueDate();
        return issueDate.gen();
    }

    public static String generateCardIssueDate(CardOption option) {
        issueDate = JRand.issueDate();
        if (option == CardOption.FULL_YEAR) {
            return issueDate.longVersion().gen();
        } else {
            return issueDate.gen();
        }
    }

    public static String generateExpiryDate() {
        expiryDate = JRand.expiryDate();
        return expiryDate.gen();
    }

    public static String generateExpiryDate(CardOption option) {
        expiryDate = JRand.expiryDate();
        switch (option) {
            case FULL_YEAR:
                return expiryDate.longVersion().gen();
            case EXPIRED:
                return expiryDate.expired().gen();
            default:
                return expiryDate.gen();
        }
    }

    public static String generateCVV() {
        cvv = JRand.cvv();
        return cvv.gen();
    }

    public static String generateCVV(boolean isAmex) {
        cvv = JRand.cvv();
        if (isAmex) {
            return cvv.amex().gen();
        } else {
            return cvv.gen();
        }
    }

    // TODO:  J-FAKER ADDRESS FUNCTIONALITY


    private static long getRandomTimeBetweenTwoDates(long endTime, long beginTime) {
        long diff = endTime - beginTime + 1L;
        return beginTime + (long) (Math.random() * (double) diff);
    }
}