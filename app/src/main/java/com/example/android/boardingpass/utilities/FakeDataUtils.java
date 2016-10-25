package com.example.android.boardingpass.utilities;
import com.example.android.boardingpass.BoardingPassInfo;
import com.example.android.boardingpass.R;

import java.sql.Timestamp;

public class FakeDataUtils {
    public static BoardingPassInfo generateFakeBoardingPassInfo(){
        BoardingPassInfo bpi = new BoardingPassInfo();
        bpi.passengerName = "MR. RANDOM PERSON";
        bpi.flightCode = "UD 777";
        bpi.originCode = "JFK";
        bpi.destCode = "DCA";
        long now = System.currentTimeMillis();
        long boarding = now + (long)((Math.random()*30)*60*1000);
        long departure = boarding + 40*60*1000;
        long arrival = departure + (long)((Math.random()*5)*60*60*1000);
        bpi.boardingTime = new Timestamp(boarding);
        bpi.departureTime = new Timestamp(departure);
        bpi.arrivalTime = new Timestamp(arrival);
        bpi.departureTerminal = "3A";
        bpi.departureGate = "33C";
        bpi.seatNumber = "1A";
        bpi.barCodeImageResource = R.drawable.art_plane;
        return bpi;
    }
}

