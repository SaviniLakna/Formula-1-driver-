package CLI;
import GUI.*;
import java.io.*;
import java.util.*;

public class Formula1ChampionshipManager implements ChampionshipManager {
    private static Formula1ChampionshipManager formula = new Formula1ChampionshipManager();  //create objects of manager to call the methods
    private static ArrayList<Formula1Driver> formulaList = new ArrayList<>(10);
    private static ArrayList<Race> raceList = new ArrayList();
    String driver = "driverData.txt";
    String raceData = "raceData.txt";


    public static void main(String[] args) {
        menu();
    }

    //menu

    public static void menu() {

        try {
            formula.getData();
            formula.getRaceData();
            boolean done = false;
            while (done != true) {
                System.out.println(" ");
                System.out.println("****** Formula 1 racing car championship Menu ******");
                System.out.println(" ");

                //display menu

                Scanner input = new Scanner(System.in);
                System.out.println(
                        "\t 1 or CND: Create New Driver \n" +
                                "\t 2 or DDT: Delete Driver & Team \n" +
                                "\t 3 or CTD: Change The Driver \n" +
                                "\t 4 or DVS: Display Various Statistics \n" +
                                "\t 5 or FDT: Display Formula 1 Driver Table \n" +
                                "\t 6 or ARD: Add a Race with Date \n" +
                                "\t 7 or WRT: Write All Data to a File \n" +
                                "\t 8 or RLD: Read Load Data \n" +
                                "\t 9 or GUI: View GUI \n"+
                                "\t 0 or EXT: Exit from the program\n"
                );
                System.out.println("****************************************************\n");
                System.out.print("Choose the number or option you want to execute: ");
                String select = input.nextLine();
                System.out.print("\n");

                if (select.equalsIgnoreCase("CND") || select.equals("1")) {
                    formula.newDriver();
                } else if (select.equalsIgnoreCase("DDT") || select.equals("2")) {
                    formula.deleteDriver();
                } else if (select.equalsIgnoreCase("CTD") || select.equals("3")) {
                    formula.changeDriver();
                } else if (select.equalsIgnoreCase("DVS") || select.equals("4")) {
                    formula.driverStatistics();
                } else if (select.equalsIgnoreCase("FDT") || select.equals("5")) {
                    formula.driverTable();
                } else if (select.equalsIgnoreCase("ARD") || select.equals("6")) {
                    formula.addRace();
                } else if (select.equalsIgnoreCase("WRT") || select.equals("7")) {
                    formula.saveData();
                } else if (select.equalsIgnoreCase("RLD") || select.equals("8")) {
                    formula.loadData();
                } else if (select.equalsIgnoreCase("GUI") || select.equals("9")) {
                    formula.run();
                } else if (select.equalsIgnoreCase("EXT") || select.equals("0")) {
                    formula.writeData();
                    formula.writeRaceData();
                    System.out.println(" ");
                    System.out.println("******************** Thank you! ********************");
                    done = true;
                } else {
                    System.out.println("Please enter valid value or character for option");
                }

            }
        } catch (Exception e) {
            System.out.println("Please enter valid value");
            menu();
        }

    }

    //create driver

    @Override
    public void newDriver() {
        for (int i = 0; i < 10; i++) {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter Driver Name: ");
            String driverName = input.nextLine();

            Scanner input1 = new Scanner(System.in);
            System.out.print("Enter Driver Location: ");
            String driverLocation = input1.nextLine();

            System.out.println("\n1:Mercedes" +
                    "\n2:Red Bull Racing" +
                    "\n3:Ferrari" +
                    "\n4:McLaren" +
                    "\n5:Alpine" +
                    "\n6:AlphaTauri" +
                    "\n7:AustinMartin" +
                    "\n8:Williams" +
                    "\n9:AlfaRomeoRacing" +
                    "\n10:Hass\n");

            Scanner input2 = new Scanner(System.in);
            System.out.print("\nEnter the Team NUmber of the Driver: ");
            int driverTeam = input2.nextInt();
            if(driverTeam>10){
                System.out.println("Please Enter valid team number");
                System.out.print("\nEnter the Team NUmber of the Driver: ");
                driverTeam = input2.nextInt();
            }

            for (int j = 0; j < formulaList.size(); j++) {
                for (Formula1Driver driver : formulaList) {
                    if (driver.getDriverTeam() == (driverTeam)) {
                        System.out.print("\nThis team already have a driver please enter another Team");
                        System.out.print("\nEnter the Team NUmber of the Driver: ");
                        driverTeam = input2.nextInt();
                    }
                }
            }

            Scanner input5 = new Scanner(System.in);
            System.out.print("Enter number of 1st positions driver got: ");
            int firstPosition = input5.nextInt();

            Scanner input6 = new Scanner(System.in);
            System.out.print("Enter number of 2nd positions driver got: ");
            int secondPosition = input6.nextInt();

            Scanner input7 = new Scanner(System.in);
            System.out.print("Enter number of 3rd positions driver got: ");
            int thirdPosition = input7.nextInt();

            int noOfPoints = firstPosition * 25 + secondPosition * 18 + thirdPosition * 15;
            System.out.println("Number of Point: " + noOfPoints);

            Scanner input8 = new Scanner(System.in);
            System.out.print("Enter number of Racers: ");
            int noOfRace = input8.nextInt();

            Formula1Driver d1 = new Formula1Driver(driverName, driverLocation, driverTeam, firstPosition, secondPosition, thirdPosition, noOfRace, noOfPoints);
            formulaList.add(d1);

            System.out.println(" \n *** Driver Successfully created *** \n");
            System.out.println("Driver Name: " + d1.getDriverName());
            System.out.println("Driver Location: " + d1.getDriverLocation());
            System.out.println("Team No of Driver: " + d1.getDriverTeam());
            System.out.println("First Position: " + d1.getFirstPosition());
            System.out.println("Second Position: " + d1.getSecondPosition());
            System.out.println("Third Position: " + d1.getThirdPosition());
            System.out.println("Number of Points: " + d1.noOfPoints);
            System.out.println("Number of Races " + d1.noOfRace);
            System.out.println(" ");

            break;
        }
    }

    //delete driver

    @Override
    public void deleteDriver() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the team number you want to delete the driver: " + "\n");
        int deleteTeam = input.nextInt();


        try {
            for (Formula1Driver driver : formulaList) {
                if (driver.getDriverTeam() == (deleteTeam)) {
                    for (int i = 0; i < formulaList.size(); i++) {
                        formulaList.remove(driver);
                        System.out.println("Driver " + driver.getDriverName() + " successfully removed");
                        break;
                    }

                }
            }
        } catch (Exception e) {
            System.out.println("");
        }
    }

    //change driver

    @Override
    public void changeDriver() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the team number you want to change the driver: ");
        int changeTeam = input.nextInt();


        try {
            for (Formula1Driver changeDriver : formulaList) {
                if (changeDriver.getDriverTeam() == (changeTeam)) {
                    for (int i = 0; i < formulaList.size(); i++) {
                        Scanner input1 = new Scanner(System.in);
                        System.out.print("Enter Driver Name: ");
                        String name = input1.nextLine();

                        Scanner input2 = new Scanner(System.in);
                        System.out.print("Enter Driver Location: ");
                        String location = input2.nextLine();

                        System.out.print("Enter number of 1st positions driver got: ");
                        int firstPosition = input.nextInt();

                        System.out.print("Enter number of 2nd positions driver got: ");
                        int secondPosition = input.nextInt();

                        System.out.print("Enter number of 3rd positions driver got: ");
                        int thirdPosition = input.nextInt();

                        int noOfPoints = firstPosition * 25 + secondPosition * 18 + thirdPosition * 15;
                        System.out.println("Number of Point: " + noOfPoints);

                        System.out.print("Enter number of Racers: ");
                        int noOfRace = input.nextInt();

                        changeDriver.setDriverTeam(changeTeam);
                        changeDriver.setDriverName(name);
                        changeDriver.setDriverLocation(location);
                        changeDriver.setFirstPosition(firstPosition);
                        changeDriver.setSecondPosition(secondPosition);
                        changeDriver.setThirdPosition(thirdPosition);
                        changeDriver.setNoOfPoints(noOfPoints);
                        changeDriver.setNoOfRace(noOfRace);

                        System.out.println(" ");
                        System.out.println("Driver " + changeDriver.getDriverName() + " successfully changed to " + changeDriver.getDriverTeam() + " team");
                        break;
                    }
                    break;

                }

            }
        } catch (Exception e) {
            System.out.println("enter valid value");
        }

    }

    //driver statistics

    @Override
    public void driverStatistics() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the driver Name you want to display Statistics: " + "\n");
        String name = input.nextLine();


        try {
            for (Formula1Driver statistics : formulaList) {
                if (statistics.getDriverName().equalsIgnoreCase(name)) {
                    for (int i = 0; i < formulaList.size(); i++) {
                        System.out.println(" ");
                        System.out.println("Driver Name                           \t- " + statistics.getDriverName());
                        System.out.println("Driver Location                       \t- " + statistics.getDriverLocation());
                        System.out.println("Driver Team                           \t- " + statistics.getDriverTeam());
                        System.out.println("Number of Racers                      \t- " + statistics.getNoOfRace());
                        System.out.println("Number of first positions driver got  \t- " + statistics.getFirstPosition());
                        System.out.println("Number of second positions driver got \t- " + statistics.getSecondPosition());
                        System.out.println("Number of third Position driver got   \t- " + statistics.getThirdPosition());
                        System.out.println("Total points                          \t- " + statistics.getNoOfPoints());
                        System.out.println("\n");
                        break;
                    }

                }

            }
        } catch (Exception e) {
            System.out.println("Enter valid value");
        }

    }

    // driver table

    @Override
    public void driverTable() {
        Comparator<Formula1Driver> formulaListSorted = Comparator.comparing(Formula1Driver::getNoOfPoints).thenComparing(Formula1Driver::getNoOfPoints);
        formulaList.sort(formulaListSorted);//call the collection sort method to sort the array
        Collections.reverse(formulaList);
        System.out.println(" ****************************************************************** POINTS TABLE **********************************************************************");
        System.out.println(" ");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %15s | %15s | %15s | %15s | %15s | %15s | %15s | %15s |", "Driver Name", "Driver Location", "Team No of Driver", "First Position", "Second Position", "Third Position", "Number of Points", "Number of Races");
        System.out.println(" ");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------");


        for (Formula1Driver table : formulaList) {
            System.out.format("| %15s | %15s | %17s | %15s | %15s | %15s | %16s | %15s |", table.getDriverName(), table.getDriverLocation(), table.getDriverTeam(), table.getFirstPosition(), table.getSecondPosition(), table.getThirdPosition(), table.getNoOfPoints(), table.getNoOfRace()); //display all the statics of added drivers
            System.out.println(" ");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
        System.out.println(" ");
        System.out.println("*******************************************************************************************************************************************************");
    }

    //add race

    @Override
    public void addRace() {

        try {
                    Scanner input = new Scanner(System.in);
                    System.out.print("Enter the team number you want to add Race: " + "\n");
                    int race = input.nextInt();

            for (Formula1Driver formula1Driver : formulaList) {

                    if (formula1Driver.getDriverTeam() == (race)) {
                        for (int j = 0; j < formulaList.size(); j++) {
                            System.out.print("Enter the Date: ");
                            int day = input.nextInt();

                            System.out.print("Enter the month: ");
                            int month = input.nextInt();

                            System.out.print("Enter the year: ");
                            int year = input.nextInt();


                            System.out.print("Enter driver's position: ");
                            int position = input.nextInt();

                            if (position > 10 || position <= 0) {
                                System.out.println("Please enter No between 1-10 for position");
                                System.out.print("Enter driver's position: ");
                                position = input.nextInt();
                            }

                            Race race1 = new Race(formula1Driver.getDriverName(), race, day, month, year, position);
                            raceList.add(race1);

                            //update driver statics according to the race.txt summary

                            if (position <= 10) {

                                if ((position == 1)&&(formula1Driver.getDriverTeam() == (race))) {
                                    formula1Driver.setNoOfPoints(formula1Driver.getNoOfPoints() + 25);//update points
                                    formula1Driver.setFirstPosition(formula1Driver.getFirstPosition() + 1);//update no of first places
                                    formula1Driver.setNoOfRace(formula1Driver.getNoOfRace() + 1);//updated no of races

                                } if ((position == 2)&&(formula1Driver.getDriverTeam() == (race))) {
                                    //update driver statics
                                    formula1Driver.setNoOfPoints(formula1Driver.getNoOfPoints() + 18);//update points
                                    formula1Driver.setSecondPosition(formula1Driver.getSecondPosition() + 1);//update no of second places
                                    formula1Driver.setNoOfRace(formula1Driver.getNoOfRace() + 1);//updated no of races

                                } if ((position == 3)&&(formula1Driver.getDriverTeam() == (race))) {
                                    //update driver statics
                                    formula1Driver.setNoOfPoints(formula1Driver.getNoOfPoints() + 15);//update points
                                    formula1Driver.setThirdPosition(formula1Driver.getThirdPosition() + 1);//update no of third places
                                    formula1Driver.setNoOfRace(formula1Driver.getNoOfRace() + 1);//updated no of races

                                } if ((position == 4)&&(formula1Driver.getDriverTeam() == (race))) {
                                    //update driver statics
                                    formula1Driver.setNoOfPoints(formula1Driver.getNoOfPoints() + 12);//update points
                                    formula1Driver.setNoOfRace(formula1Driver.getNoOfRace() + 1);//updated no of races

                                } if ((position == 5)&&(formula1Driver.getDriverTeam() == (race)) ) {
                                    //update driver statics
                                    formula1Driver.setNoOfPoints(formula1Driver.getNoOfPoints() + 10);//update points
                                    formula1Driver.setNoOfRace(formula1Driver.getNoOfRace() + 1);//updated no of races

                                } if ((position == 6) &&(formula1Driver.getDriverTeam() == (race))) {
                                    //update driver statics
                                    formula1Driver.setNoOfPoints(formula1Driver.getNoOfPoints() + 8);//update points
                                    formula1Driver.setNoOfRace(formula1Driver.getNoOfRace() + 1);//updated no of races

                                } if ((position == 7)&&(formula1Driver.getDriverTeam() == (race)) ) {
                                    //update driver statics
                                    formula1Driver.setNoOfPoints(formula1Driver.getNoOfPoints() + 6);//update points
                                    formula1Driver.setNoOfRace(formula1Driver.getNoOfRace() + 1);//updated no of races

                                } if ((position == 8)&&(formula1Driver.getDriverTeam() == (race))) {
                                    //update driver statics
                                    formula1Driver.setNoOfPoints(formula1Driver.getNoOfPoints() + 4);//update points
                                    formula1Driver.setNoOfRace(formula1Driver.getNoOfRace() + 1);//updated no of races

                                } if ((position == 9)&&(formula1Driver.getDriverTeam() == (race))) {
                                    //update driver statics
                                    formula1Driver.setNoOfPoints(formula1Driver.getNoOfPoints() + 2);//update points
                                    formula1Driver.setNoOfRace(formula1Driver.getNoOfRace() + 1);//updated no of races

                                } if ((position == 10)&&(formula1Driver.getDriverTeam() == (race))) {
                                    //update driver statics
                                    formula1Driver.setNoOfPoints(formula1Driver.getNoOfPoints() + 1);//update points
                                    formula1Driver.setNoOfRace(formula1Driver.getNoOfRace() + 1);//updated no of races

                                } else {
                                    formula1Driver.setNoOfRace(formula1Driver.getNoOfRace());//updated no of races
                                }
                            }
                            break;
                        }

                        System.out.println("\n Race successfully added all the statics has updated");
                        break;

                    }
            }






        } catch (Exception e) {
            System.out.println("Enter Valid value");
        }
    }

    // data write to file


    public void saveData() throws IOException {

        File doc = new File("driverStatistics.txt");
        FileWriter saveData = new FileWriter(doc, true);   //append data to the file
        saveData.write(" " + "\n");

        for (Formula1Driver formula1Driver : formulaList) {
            saveData.write("Driver Name            : " + "\t" + formula1Driver.getDriverName() + "\n");
            saveData.write("Driver Location        : " + "\t" + formula1Driver.getDriverLocation() + "\n");
            saveData.write("Driver Team            : " + "\t" + formula1Driver.getDriverTeam() + "\n");
            saveData.write("No Of First Positions  : " + "\t" + formula1Driver.getFirstPosition() + "\n");
            saveData.write("No Of Second Positions : " + "\t" + formula1Driver.getSecondPosition() + "\n");
            saveData.write("No Of Third Positions  : " + "\t" + formula1Driver.getThirdPosition() + "\n");
            saveData.write("No Of Points           : " + "\t" + formula1Driver.getNoOfPoints() + "\n");
            saveData.write("No Races               : " + "\t" + formula1Driver.getSecondPosition() + "\n");
            saveData.write("\n");
        }

        System.out.println("All the driver data are successfully saved");
        saveData.write("" + "\n");
        saveData.flush();
        saveData.close();

    }

    // read data from file

    public void loadData() throws IOException { //load all the statics of drivers
//
        System.out.println("Load Program Data from file:");


        FileReader newDoc = new FileReader("driverStatistics.txt");
        int doc = newDoc.read();
        while (doc != -1) {
            System.out.print((char) doc);
            doc = newDoc.read();
        }
        newDoc.close();
    }

    // run GUI

    public void run(){
        Home home = new Home();
        home.showHome();
        DriverStat.initialize(formulaList);
        RaceStat.initialize(raceList,formulaList);
        DriverStat.frame.setVisible(false);
        RaceStat.frame.setVisible(false);
    }

    // Serialize  driver data

    @Override
    public void writeData(){
        try{
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(driver));
            for (Formula1Driver data : formulaList){
                file.writeObject(data);
            }file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // deserialize  driver data

    @Override
    public void getData(){
        try {
            ObjectInputStream file1 = new ObjectInputStream(new FileInputStream(driver));
            while (true){
                try {
                    Formula1Driver driver1 = (Formula1Driver) file1.readObject();
                    formulaList.add(driver1);
                } catch (FileNotFoundException E) {
                    break;
                }
            }
            file1.close();

        }catch (FileNotFoundException E)

        {
            System.out.println("file not found");
        } catch (IOException e) {


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Serialize  race data

    @Override
    public void writeRaceData(){
        try{
            ObjectOutputStream file2 = new ObjectOutputStream(new FileOutputStream(raceData));
            for (Race data : raceList){
                file2.writeObject(data);
            }file2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // deserialize  driver data

    @Override
    public void getRaceData(){
        try {
            ObjectInputStream file3 = new ObjectInputStream(new FileInputStream(raceData));
            while (true){
                try {
                    Race race1 = (Race) file3.readObject();
                    raceList.add(race1);
                } catch (FileNotFoundException E) {
                    break;
                }
            }
            file3.close();

        }catch (FileNotFoundException E)

        {
            System.out.println("file not found");
        } catch (IOException e) {


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

        


        


