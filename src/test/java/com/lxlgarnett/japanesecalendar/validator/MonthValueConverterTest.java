package com.lxlgarnett.japanesecalendar.validator;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

/**
 * This is a test class for MonthValueConverter class.
 *
 * @author xiaolei
 */
@QuarkusTest
class MonthValueConverterTest {

  private MonthValueConverter monthValueConverter;

  @BeforeEach
  void setUp() {
    this.monthValueConverter = new MonthValueConverter();
  }

  @Test
  void convertTestInvalidMonthValueFormat() {
    Assertions.assertThrows(
        CommandLine.TypeConversionException.class,
        () -> monthValueConverter.convert("not integer string value"));
  }

  @Test
  void convertTestMonthValueOutOfRange() {
    Assertions.assertThrows(
        CommandLine.TypeConversionException.class, () -> monthValueConverter.convert("0"));
    Assertions.assertThrows(
        CommandLine.TypeConversionException.class, () -> monthValueConverter.convert("13"));
  }

  @Test
  void convertTestValidMonthValue() {
    Assertions.assertEquals(1, monthValueConverter.convert("1"));
    Assertions.assertEquals(2, monthValueConverter.convert("2"));
    Assertions.assertEquals(3, monthValueConverter.convert("3"));
    Assertions.assertEquals(7, monthValueConverter.convert("7"));
    Assertions.assertEquals(10, monthValueConverter.convert("10"));
    Assertions.assertEquals(12, monthValueConverter.convert("12"));
  }
}
