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

    System.out.printf(
        "            %s  %d             %n", LocalDate.of(year, month, 1).getMonth(), year);
    System.out.println("SUN MON TUE WED THU FIR SAT");
    /*
    Foreground color
    \u001B[31m -- Red
    \u001B[34m -- Blue

    Background color
    \u001B[47m -- White
     */
    System.out.println("\u001B[31m01\u001B[0m 02 03 04 05 06 \u001B[47m\u001B[30m07\u001B[0m");
    System.out.println(month);
  }
}
