package com.lxlgarnett.japanesecalendar.validator;

import io.quarkus.logging.Log;
import picocli.CommandLine;

/**
 * This is a converter class to covert a string value to month value.
 *
 * @author lxlgarnett
 */
public class MonthValueConverter implements CommandLine.ITypeConverter<Integer> {

  @Override
  public Integer convert(String monthValue) throws CommandLine.ParameterException {
    Log.trace("convert --> start.");
    int month;
    try {
      month = Integer.parseInt(monthValue);
    } catch (NumberFormatException numberFormatException) {
      Log.warn(
          String.format(
              "Value %s is invalid. Month value must be a string can convert to integer.",
              monthValue));
      throw new CommandLine.TypeConversionException(
          "Month value must be a string can convert to integer.");
    }
    if (month < 1 || month > 12) {
      Log.warn(String.format("Value %s is invalid. Month value must between 1 to 12.", monthValue));
      throw new CommandLine.TypeConversionException("Month value must between 1 to 12.");
    }
    return month;
  }
}
