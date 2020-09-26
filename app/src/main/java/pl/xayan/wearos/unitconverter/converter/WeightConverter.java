package pl.xayan.wearos.unitconverter.converter;

import androidx.annotation.NonNull;

import pl.xayan.wearos.unitconverter.annotation.ConverterConfiguration;
import pl.xayan.wearos.unitconverter.unit.WeightUnit;

@ConverterConfiguration(name = "Weight", unitEnum = WeightUnit.class)
public class WeightConverter implements Converter<WeightUnit> {
    @Override
    @NonNull
    public Number convert(WeightUnit unitFrom, Number value, WeightUnit unitTo) {
        return value.doubleValue() / unitFrom.ratio.doubleValue() * unitTo.ratio.doubleValue();
    }
}
