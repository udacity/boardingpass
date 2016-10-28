package com.example.android.boardingpass;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

/**
 * BoardingPassInfo is a simple POJO that contains information about, you guessed it, a boarding
 * pass! Normally, it is best practice in Java to declare member variables as private and provide
 * getters, but we are leaving these fields public for ease of use.
 */
public class BoardingPassInfo {

    public String passengerName;
    public String flightCode;
    public String originCode;
    public String destCode;

    public Timestamp boardingTime;
    public Timestamp departureTime;
    public Timestamp arrivalTime;

    public String departureTerminal;
    public String departureGate;
    public String seatNumber;

    public int barCodeImageResource;

    public long getMinutesUntilBoarding() {
        long millisUntilBoarding = boardingTime.getTime() - System.currentTimeMillis();
        return TimeUnit.MILLISECONDS.toMinutes(millisUntilBoarding);
    }
}