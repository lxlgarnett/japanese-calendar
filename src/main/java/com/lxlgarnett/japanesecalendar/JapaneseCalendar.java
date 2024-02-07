package com.lxlgarnett.japanesecalendar;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.Calendar;
import java.util.Locale;

@ApplicationScoped
public class JapaneseCalendar {

  public void printHeader(int year, int month) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.YEAR, year);
    calendar.set(Calendar.MONTH, month - 1);
    // Print the month and year header
    System.out.println(
        "   "
            + calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault())
            + " "
            + year);

    // Print the days of the week header
    System.out.println("Su Mo Tu We Th Fr Sa");
  }

  /**
   * Is the given date is Sunday or not.
   * @param year Year of the given date
   * @param month Month of the given date
   * @param day Day of the given date
   * @return true: Sunday false: Others
   */
  public boolean isSunday(int year, int month, int day) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.YEAR, year);
    calendar.set(Calendar.MONTH, month - 1);
    calendar.set(Calendar.DATE, day);

    return calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;
  }
}
