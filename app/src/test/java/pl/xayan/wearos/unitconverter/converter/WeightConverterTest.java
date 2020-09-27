package pl.xayan.wearos.unitconverter.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import pl.xayan.wearos.unitconverter.unit.WeightUnit;

import static org.junit.jupiter.api.Assertions.*;

class WeightConverterTest {
    private WeightConverter weightConverter;

    @BeforeEach
    void setUp() {
        weightConverter = new WeightConverter();
    }

    private static Stream<Arguments> testConverterDataProvider() {
        return Stream.of(
                Arguments.of(WeightUnit.TONNE, 1, WeightUnit.GRAM, 1e6),
                Arguments.of(WeightUnit.MILLIGRAM, 1, WeightUnit.KILOGRAM, 1e-6)
        );
    }

    @ParameterizedTest
    @MethodSource("testConverterDataProvider")
    void testConvert(WeightUnit unitFrom, Number value, WeightUnit unitTo, Number expectedResult) {
        assertEquals(
                expectedResult,
                weightConverter.convert(unitFrom, value, unitTo)
        );
    }
}