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
  public Integer convert(String monthValue)
      throws NumberFormatException, CommandLine.ParameterException {
    Log.trace("convert --> start.");
    int month = Integer.parseInt(monthValue);
    if (month < 1 || month > 12) {
      Log.warn(
          String.format("Value %s is not valid. Month value must between 1 to 12.", monthValue));
      throw new CommandLine.ParameterException(
          new CommandLine(this), "Month value must between 1 to 12.");
    }
    return month;
  }
}
