package pl.xayan.wearos.unitconverter.converter;

import lombok.NonNull;
import lombok.val;
import pl.xayan.wearos.unitconverter.annotation.ConverterConfiguration;
import pl.xayan.wearos.unitconverter.unit.Unit;
import pl.xayan.wearos.unitconverter.unit.WeightUnit;

@ConverterConfiguration(name = "Weight", unitEnum = WeightUnit.class)
public class WeightConverter implements Converter {
    @Override
    @NonNull
    public Number convert(Unit unitFrom, Number value, Unit unitTo) {
        validateInput(unitFrom, value, unitTo);

        return convert((WeightUnit) unitFrom, value, (WeightUnit) unitTo);
    }

    @NonNull
    private Number convert(WeightUnit unitFrom, Number value, WeightUnit unitTo) {
        return value.doubleValue() * unitFrom.ratio.doubleValue() / unitTo.ratio.doubleValue();
    }
}
