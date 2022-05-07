package CLI;

import java.io.IOException;

public interface ChampionshipManager {
    void newDriver();
    void deleteDriver() throws IllegalAccessException;
    void changeDriver() throws IllegalAccessException;
    void driverStatistics();
    void driverTable();
    void addRace();
    void writeData();
    void getData();
    void writeRaceData();
    void getRaceData();;

}
