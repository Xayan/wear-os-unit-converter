package pl.xayan.wearos.unitconverter.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import pl.xayan.wearos.unitconverter.unit.Unit;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ConverterConfiguration {
    String name();

    Class<? extends Unit> unitEnum();
}
