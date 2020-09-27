package pl.xayan.wearos.unitconverter.converter;

import lombok.val;
import pl.xayan.wearos.unitconverter.annotation.ConverterConfiguration;
import pl.xayan.wearos.unitconverter.unit.Unit;
import pl.xayan.wearos.unitconverter.unit.WeightUnit;

public interface Converter {
    Number convert(Unit unitFrom, Number value, Unit unitTo);

    Unit getDefaultFromUnit();

    Unit getDefaultToUnit();

    default void validateInput(Unit unitFrom, Number value, Unit unitTo) {
        validateUnitFrom(unitFrom);
        validateValue(value);
        validateUnitTo(unitTo);
    }

    default void validateUnitFrom(Unit unitFrom) {
        if(unitFrom.getClass() != getSupportedUnitEnum()) {
            throw new RuntimeException("");
        }
    }

    default void validateUnitTo(Unit unitTo) {
        if(unitTo.getClass() != getSupportedUnitEnum()) {
            throw new RuntimeException("");
        }
    }

    default void validateValue(Number value) {
        if(value.doubleValue() < 0) {
            throw new RuntimeException("");
        }
    }

    default ConverterConfiguration getConfiguration() {
        val config = getClass().getAnnotation(ConverterConfiguration.class);

        if(config == null) {
            throw new RuntimeException("Missing @ConverterConfiguration annotation");
        }

        return config;
    }

    default Class<? extends Unit> getSupportedUnitEnum() {
        return getConfiguration().unitEnum();
    }

    default Unit getUnitByName(String name) {
        try {
            Unit[] units = (Unit[]) getSupportedUnitEnum().getMethod("values").invoke(this);

            return null;
        } catch (Exception ignored) {}

        return null;
    }
}
