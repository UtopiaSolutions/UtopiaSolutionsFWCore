package me.xdrop.jrand.generators.location;

import me.xdrop.jrand.Generator;
import me.xdrop.jrand.annotation.Facade;
import me.xdrop.jrand.generators.basics.DecimalGenerator;
import me.xdrop.jrand.model.Range;

@Facade(accessor = "depth")
public class DepthGenerator extends Generator<String> {
    protected DecimalGenerator decimal;
    protected int noDecimals;

    public DepthGenerator() {
        this.noDecimals = 5;
        this.decimal = new DecimalGenerator().range(Range.from(-10994.0, 0.0)).digits(noDecimals);
    }

    /**
     * Set the number of digits after the decimal place
     * @param noDecimals Number
     * @return The same generator
     */
    public DepthGenerator decimals(int noDecimals) {
        decimal.digits(noDecimals);
        return this;
    }

    /**
     * Set the minimum depth
     * @param min The minimum depth
     * @return The same generator
     */
    public DepthGenerator min(double min) {
        decimal.min(min);
        return this;
    }

    @Override
    public String gen() {
        return decimal.gen();
    }
}
