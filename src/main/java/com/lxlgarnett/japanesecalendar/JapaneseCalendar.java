package com.lxlgarnett.japanesecalendar;

import com.lxlgarnett.japanesecalendar.validator.MonthValueConverter;
import com.lxlgarnett.japanesecalendar.validator.YearValueConverter;
import io.quarkus.logging.Log;
import java.time.LocalDate;
import picocli.CommandLine;

/**
 * Top class for japanese calendar. This is the first class called when execute the command.
 *
 * @author xiaolei
 */
@CommandLine.Command
public class JapaneseCalendar implements Runnable {

  @CommandLine.Option(
      names = {"-m", "--month"},
      description = "Which month's calendar do you want to show?",
      converter = MonthValueConverter.class)
  int month = LocalDate.now().getMonthValue();

  @CommandLine.Option(
      names = {"-y", "--year"},
      description = "Which year's calendar do you want to show?",
      converter = YearValueConverter.class)
  int year = LocalDate.now().getYear();

  @Override
  public void run() {
    Log.info(year);
    Log.info(month);
  }
}
