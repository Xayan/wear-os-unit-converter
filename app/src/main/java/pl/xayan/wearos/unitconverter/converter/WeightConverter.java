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

        val weightUnitFrom = (WeightUnit) unitFrom;
        val weightUnitTo = (WeightUnit) unitTo;

        return value.doubleValue() * weightUnitFrom.ratio.doubleValue() / weightUnitTo.ratio.doubleValue();
    }

    @Override
    public Unit getDefaultFromUnit() {
        return WeightUnit.KILOGRAM;
    }

    @Override
    public Unit getDefaultToUnit() {
        return WeightUnit.GRAM;
    }
}
