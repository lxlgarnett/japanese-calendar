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
}
