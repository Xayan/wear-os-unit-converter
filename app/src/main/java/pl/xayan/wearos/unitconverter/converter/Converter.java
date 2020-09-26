package pl.xayan.wearos.unitconverter.converter;

import pl.xayan.wearos.unitconverter.unit.Unit;

public interface Converter<T extends Unit> {
    public Number convert(T unitFrom, Number value, T unitTo);
}
