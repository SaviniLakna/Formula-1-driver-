package CLI;

import java.io.Serializable;

public class Race implements Serializable {

    String driverName;
    int driverTeam;
    int date;
    int position;
    int month;
    int year;



    public Race(String driverName, int driverTeam, int day, int month, int year, int position) {
        this.driverName = driverName;
        this.driverTeam = driverTeam;
        this.date = day;
        this.month=month;
        this.year = year;
        this.position = position;
    }

    public int getDate(){return date;}

    public int getMonth(){return month;}

    public int getYear(){return year;}

    public int getPosition(){return position;}

    public String getDriverName() {
        return driverName;
    }

    public int getDriverTeam() {
        return driverTeam;
    }

}
