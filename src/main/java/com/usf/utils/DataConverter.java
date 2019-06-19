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

    // TODO - Add birthday range, and range with formatting


    // TODO - Get date from today + / - time amount

    // TODO - Get date from specified date + / - time amount


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

    //TODO - add Generate Valid <cc company> Number methods

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
}