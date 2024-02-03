package com.lxlgarnett.japanesecalendar.validator;

import io.quarkus.logging.Log;
import picocli.CommandLine;

/**
 * This is a converter class to convert a string value to year value.
 *
 * @author lxlgarnett
 */
public class YearValueConverter implements CommandLine.ITypeConverter<Integer> {

  @Override
  public Integer convert(String yearValue) {
    Log.trace("convert --> start.");
    int year;
    try {
      year = Integer.parseInt(yearValue);
    } catch (NumberFormatException numberFormatException) {
      Log.warn(
          String.format(
              "Value %s is invalid. Year value must be a string can convert to integer.",
              yearValue));
      throw new CommandLine.TypeConversionException(
          "Year value must be a string can convert to integer.");
    }
    return year;
  }
}
