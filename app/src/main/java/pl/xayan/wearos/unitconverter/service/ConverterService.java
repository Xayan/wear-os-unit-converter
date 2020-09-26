package pl.xayan.wearos.unitconverter.service;

import lombok.NonNull;
import lombok.val;
import pl.xayan.wearos.unitconverter.annotation.ConverterConfiguration;
import pl.xayan.wearos.unitconverter.converter.Converter;
import pl.xayan.wearos.unitconverter.unit.Unit;

public class ConverterService {
    @NonNull
    public Converter<?> getConverter(Class<? extends Converter<?>> converterClass)
    {
        val annotation = converterClass.getAnnotation(ConverterConfiguration.class);

        if(annotation == null)
        {
            throw new RuntimeException("Invalid converter");
        }

        try {
            return converterClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Converter initialization error");
        }
    }

    @NonNull
    public Unit[] getUnitsByConverter(Class<? extends Converter<?>> converterClass)
    {
        val annotation = converterClass.getAnnotation(ConverterConfiguration.class);

        if(annotation == null)
        {
            throw new RuntimeException("Invalid converter");
        }

        return annotation.unitEnum().getEnumConstants();
    }
}
