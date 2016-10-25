package com.example.android.boardingpass;

import java.sql.Timestamp;

/**
 * Created by asser on 10/25/16.
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

    public int getMinutesTillBoarding() {
        long milliSecs = boardingTime.getTime() - System.currentTimeMillis();
        return (int)(milliSecs/60000);
    }
}