package me.xdrop.jrand;

import me.xdrop.jrand.generators.basics.*;
import me.xdrop.jrand.generators.location.*;
import me.xdrop.jrand.generators.money.*;
import me.xdrop.jrand.generators.person.*;
import me.xdrop.jrand.generators.text.*;
import me.xdrop.jrand.generators.time.HourGenerator;
import me.xdrop.jrand.generators.time.MillisecondGenerator;
import me.xdrop.jrand.generators.time.MinuteGenerator;
import me.xdrop.jrand.generators.time.SecondGenerator;

public final class JRand
{
  public JRand() {}
  
  public static final BirthdayGenerator birthday()
  {
    return new BirthdayGenerator();
  }
  
  public static final AltitudeGenerator altitude() {
    return new AltitudeGenerator();
  }
  
  public static final CountryGenerator country() {
    return new CountryGenerator();
  }
  
  public static final ParagraphGenerator paragraph() {
    return new ParagraphGenerator();
  }
  
  public static final FirstnameGenerator firstname() {
    return new FirstnameGenerator();
  }
  
  public static final BoolGenerator bool() {
    return new BoolGenerator();
  }
  
  public static final StringGenerator string() {
    return new StringGenerator();
  }
  
  public static final GenderGenerator gender() {
    return new GenderGenerator();
  }
  
  public static final me.xdrop.jrand.generators.location.CityGenerator city() {
    return new me.xdrop.jrand.generators.location.CityGenerator();
  }
  
  public static final PrefixGenerator prefix() {
    return new PrefixGenerator();
  }
  
  public static final LatitudeGenerator latitude() {
    return new LatitudeGenerator();
  }
  
  public static final MillisecondGenerator millisecond() {
    return new MillisecondGenerator();
  }
  
  public static final AreaCodeGenerator areacode() {
    return new AreaCodeGenerator();
  }
  
  public static final CardNumberGenerator cardNo() {
    return new CardNumberGenerator();
  }
  
  public static final SecondGenerator second() {
    return new SecondGenerator();
  }
  
  public static final ExpiryDateGenerator expiryDate() {
    return new ExpiryDateGenerator();
  }
  
  public static final LoremGenerator lorem() {
    return new LoremGenerator();
  }
  
  public static final CharacterGenerator character() {
    return new CharacterGenerator();
  }
  
  public static final HourGenerator hour() {
    return new HourGenerator();
  }
  
  public static final StreetGenerator street() {
    return new StreetGenerator();
  }
  
  public static final GeohashGenerator geohash() {
    return new GeohashGenerator();
  }
  
  public static final IssueDateGenerator issueDate() {
    return new IssueDateGenerator();
  }
  
  public static final LongitudeGenerator longitude() {
    return new LongitudeGenerator();
  }
  
  public static final SentenceGenerator sentence() {
    return new SentenceGenerator();
  }
  
  public static final CVVGenerator cvv() {
    return new CVVGenerator();
  }
  
  public static final NaturalGenerator natural() {
    return new NaturalGenerator();
  }
  
  public static final SyllableGenerator syllable() {
    return new SyllableGenerator();
  }
  
  public static final CoordinatesGenerator coordinates() {
    return new CoordinatesGenerator();
  }
  
  public static final PostcodeGenerator postcode() {
    return new PostcodeGenerator();
  }
  
  public static final CardTypeGenerator cardType() {
    return new CardTypeGenerator();
  }
  
  public static final DoubleGenerator dbl() {
    return new DoubleGenerator();
  }
  
  public static final FloatGenerator flt() {
    return new FloatGenerator();
  }
  
  public static final LastnameGenerator lastname() {
    return new LastnameGenerator();
  }
  
  public static final MinuteGenerator minute() {
    return new MinuteGenerator();
  }
  
  public static final DepthGenerator depth() {
    return new DepthGenerator();
  }
  
  public static final PhoneGenerator phone() {
    return new PhoneGenerator();
  }
  
  public static final NameGenerator name() {
    return new NameGenerator();
  }
  
  public static final DecimalGenerator decimal() {
    return new DecimalGenerator();
  }
  
  public static final WordGenerator word() {
    return new WordGenerator();
  }
  
  public static final CardGenerator card() {
    return new CardGenerator();
  }
  
  public static final AgeGenerator age() {
    return new AgeGenerator();
  }
}
