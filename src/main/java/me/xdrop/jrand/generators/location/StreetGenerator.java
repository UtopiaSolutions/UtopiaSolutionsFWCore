package me.xdrop.jrand.generators.location;

import me.xdrop.jrand.Generator;
import me.xdrop.jrand.annotation.Facade;
import me.xdrop.jrand.data.Assets;
import me.xdrop.jrand.generators.basics.NaturalGenerator;
import me.xdrop.jrand.generators.text.WordGenerator;
import me.xdrop.jrand.model.location.StreetSuffix;
import me.xdrop.jrand.utils.Choose;

import java.util.ArrayList;
import java.util.List;

@Facade(accessor = "street")
public class StreetGenerator extends Generator<String> {

    protected WordGenerator wordGenerator;
    protected NaturalGenerator nat;
    protected String country;
    protected boolean shortSuffix;
    protected List<StreetSuffix> ukStreetSuffixes;
    protected List<StreetSuffix> usStreetPrefixes;
    protected List<StreetSuffix> all;
    protected boolean houseNumber;

    public StreetGenerator() {
        this.wordGenerator = new WordGenerator();
        ukStreetSuffixes = Assets.UK_STREET_SUFFIXES.loadItems();
        usStreetPrefixes = Assets.US_STREET_SUFFIXES.loadItems();
        all = new ArrayList<>(ukStreetSuffixes);
        all.addAll(usStreetPrefixes);
        this.country = "all";
        this.nat = new NaturalGenerator();
    }

    /**
     * Use street suffixes from the United States
     *
     * @return The same generator
     */
    public StreetGenerator us() {
        this.country = "us";
        return this;
    }


    /**
     * Use street suffixes from the United Kingdom
     *
     * @return The same generator
     */
    public StreetGenerator uk() {
        this.country = "uk";
        return this;
    }

    /**
     * Set whether the street suffix to be appended is in
     * it's short version
     *
     * @param enable True for short suffix,
     *               False otherwise
     * @return The same generator
     */
    public StreetGenerator shortSuffix(boolean enable) {
        this.shortSuffix = enable;
        return this;
    }

    /**
     * Set whether the street suffix to be appended is in
     * it's short version
     *
     * @return The same generator
     */
    public StreetGenerator shortSuffix() {
        return shortSuffix(true);
    }

    /**
     * Append a house number to the front of the street
     *
     * @return The same generator
     */
    public StreetGenerator houseNumber() {
        return houseNumber(true);
    }

    /**
     * Append a house number to the front of the street
     * @param enable True to append,
     *               False to not append
     * @return The same generator
     */
    public StreetGenerator houseNumber(boolean enable) {
        this.houseNumber = enable;
        return this;
    }

    @Override
    public String gen() {
        String road = "";

        if (houseNumber) {
            road += nat.range(1,200).gen() + " ";
        }

        road += wordGenerator.capitalize().gen() + " ";
        StreetSuffix suffix;

        if (country.equals("uk")) {
            suffix = Choose.one(ukStreetSuffixes);
        } else if (country.equals("us")) {
            suffix = Choose.one(usStreetPrefixes);
        } else {
            suffix = Choose.one(all);
        }

        if (shortSuffix) {
            road += suffix.getShortVersion();
        } else {
            road += suffix.getLongVersion();
        }

        return road;
    }
}
