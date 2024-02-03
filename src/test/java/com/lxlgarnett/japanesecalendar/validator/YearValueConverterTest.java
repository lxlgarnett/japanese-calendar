package com.lxlgarnett.japanesecalendar.validator;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

/**
 * This is a test class for YearValueConverter class.
 *
 * @author xiaolei
 */
@QuarkusTest
class YearValueConverterTest {

  private YearValueConverter yearValueConverter;

  @BeforeEach
  void setUp() {
    this.yearValueConverter = new YearValueConverter();
  }

  @Test
  void convertTestInvalidYearValueFormat() {
    Assertions.assertThrows(
        CommandLine.TypeConversionException.class,
        () -> yearValueConverter.convert("not integer string value"));
  }

  @Test
  void convertTestValidYearValue() {
    Assertions.assertEquals(2020, yearValueConverter.convert("2020"));
    Assertions.assertEquals(2023, yearValueConverter.convert("2023"));
    Assertions.assertEquals(2024, yearValueConverter.convert("2024"));
  }
}
