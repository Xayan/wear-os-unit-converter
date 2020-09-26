package pl.xayan.wearos.unitconverter.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import pl.xayan.wearos.unitconverter.converter.Converter;
import pl.xayan.wearos.unitconverter.converter.WeightConverter;

import static org.junit.jupiter.api.Assertions.*;

class ConverterServiceTest {
    private ConverterService converterService;

    @BeforeEach
    void setUp() {
        converterService = new ConverterService();
    }

    private static Stream<Class<?>> getConverterDataProvider() {
        return Stream.of(
                WeightConverter.class
        );
    }

    @ParameterizedTest
    @MethodSource("getConverterDataProvider")
    void getConverter(Class<? extends Converter<?>> converterClass) {
        assertNotNull(converterService.getConverter(converterClass));
    }
}