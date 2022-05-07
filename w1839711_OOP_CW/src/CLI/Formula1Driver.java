package CLI;

import CLI.Driver;

public class Formula1Driver extends Driver {
    public int firstPosition=0;
    public int secondPosition=0;
    public int thirdPosition=0;
    public int noOfRace;
    public int noOfPoints;


    Formula1Driver(String driverName, String driverLocation, int driverTeam, int firstPosition, int secondPosition, int thirdPosition, int noOfRace, int noOfPoints) {
        super(driverName, driverLocation, driverTeam);
        this.firstPosition=firstPosition;
        this.secondPosition=secondPosition;
        this.thirdPosition=thirdPosition;
        this.noOfRace=noOfRace;
        this.noOfPoints=noOfPoints;
    }

    //getters & setters

    public int getFirstPosition() {
        return firstPosition;
    }

    public void setFirstPosition(int firstPosition) {
        this.firstPosition = firstPosition;
    }

    public int getSecondPosition() {
        return secondPosition;
    }

    public void setSecondPosition(int secondPosition) {
        this.secondPosition = secondPosition;
    }

    public int getThirdPosition() {
        return thirdPosition;
    }

    public void setThirdPosition(int thirdPosition) {
        this.thirdPosition = thirdPosition;
    }

    public int getNoOfRace() {
        return noOfRace;
    }

    public void setNoOfRace(int noOfRace) {
        this.noOfRace = noOfRace;
    }

    public int getNoOfPoints() {
        return noOfPoints;
    }

    public void setNoOfPoints(int noOfPoints) {
        this.noOfPoints = noOfPoints;
    }

    private static void addRace() {

    }

}