package CLI;

import java.io.Serializable;
import java.util.Scanner;

abstract class Driver implements Serializable {

    public String driverName;
    public String driverLocation;
    public int driverTeam;

    Driver(String driverName, String driverLocation, int driverTeam){
        this.driverName=driverName;
        this.driverLocation=driverLocation;
        this.driverTeam=driverTeam;
    }

    public String getDriverName(){
        return driverName;
    }

    public void setDriverName(String driverName){
        this.driverName = driverName;
    }
    public String getDriverLocation(){
        return driverLocation;
    }

    public void setDriverLocation(String driverLocation){
        this.driverLocation=driverLocation;
    }

    public int getDriverTeam(){
        return driverTeam;
    }

    public void setDriverTeam(int driverTeam){
        this.driverTeam=driverTeam;
    }

}