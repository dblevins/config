package org.superbiz.config;

import org.tomitribe.util.editor.Converter;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 * @author Antoine Sabot-Durand
 */
public class ConverterProducer {


    @Produces
    @Config
    public Object produceConverter(InjectionPoint ip) {
        final String toConvert = ip.getAnnotated().getAnnotation(Config.class).value();
        final Class<?> toType = (Class<?>) ip.getAnnotated().getBaseType();

        System.out.println("I have to convert " + toConvert + " to type: " + toType.toString());

        final String value = System.getProperties().getProperty(toConvert);

        return Converter.convert(value, toType, toConvert);
    }
}
