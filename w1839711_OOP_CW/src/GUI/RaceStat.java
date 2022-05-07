package GUI;
import CLI.*;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class RaceStat {

    public static JFrame frame;
    private static JPanel panel;
    private static JPanel panel2;
    private static JButton button;
    private static JButton button2;
    private static JButton button3;
    public static JTable table;
    public static JTextField jtext;
    private static JButton button4;
    private static ArrayList<Race> raceList = new ArrayList();
    private static ArrayList<Formula1Driver> formulaList = new ArrayList<>(10);
    private static final Formula1ChampionshipManager F1 = new Formula1ChampionshipManager();
    private static DefaultTableModel tablemodel;



    public RaceStat(ArrayList<Race> raceList, ArrayList<Formula1Driver> formulaList) {
        initialize(RaceStat.raceList = raceList, DriverStat.formulaList = formulaList);
    }

    public static void initialize(ArrayList<Race> raceList, ArrayList<Formula1Driver> formulaList) {
        RaceStat.raceList = raceList;

        /// creat Frame

        frame = new JFrame();
        frame.setSize(1980, 1080);
        frame.setTitle("FCM Race Stat V 1.2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);


        /// create panel

        //panel = new JPanel(new GridBagLayout());
        panel = new JPanel();
        panel.setLayout(null);
        frame.getContentPane().add(panel, BorderLayout.EAST);
        panel.setBounds(0, 0, 400, 1080);
        panel.setBackground(Color.darkGray);


        /// create back button

        button = new JButton();
        //gbc.gridx = 0;
        //gbc.gridy = 0;
        panel.add(button);
        button.setFocusable(false);
//        button.setBounds(50, 200, 300, 100);
        button.setBounds(50, 100, 300, 100);
        button.setOpaque(true);

        ImageIcon goIcon = new ImageIcon("go back-01.png");
        button.setIcon(goIcon);
        button.setIconTextGap(0);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MENU menu = new MENU();
                RaceStat.frame.dispose();
                menu.frame.setVisible(true);

            }
        });

        ///// Creat button "generate"

        button2 = new JButton();
        panel.add(button2);
        button2.setOpaque(true);
        button2.setForeground(Color.BLACK);
        button2.setBackground(Color.red);
        button2.setFocusable(false);
//        button2.setBounds(50, 400, 300, 100);
        button2.setBounds(50, 250, 300, 100);

        ImageIcon generateIcon = new ImageIcon("generate-01.png");
        button2.setIcon(generateIcon);
        button2.setIconTextGap(0);


        ///// Creat Button "Sort by date"

        button3 = new JButton();
        panel.add(button3);
        button3.setOpaque(true);
        button3.setForeground(Color.BLACK);
        button3.setBackground(Color.red);
        button3.setFocusable(false);
        button3.setBounds(50, 400, 300, 100);
//      button3.setBounds(50, 600, 300, 100);

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DefaultRowSorter sorter = ((DefaultRowSorter) table.getRowSorter());
                ArrayList list = new ArrayList();
                list.add(new RowSorter.SortKey(3, SortOrder.ASCENDING));
                sorter.setSortKeys(list);
                sorter.sort();
            }
        });

        ImageIcon placeIcon = new ImageIcon("date-01.png");
        button3.setIcon(placeIcon);
        button3.setIconTextGap(0);


        //// create text field

        jtext = new JTextField();
        panel.add(jtext);
        jtext.setFont(new Font("Lucida Console", 5, 15));
        jtext.setBounds(50, 600, 300, 50);
//        text.setBounds(50,700,300,50);

        //// create search button

        button4 = new JButton();
        panel.add(button4);
        button4.setBounds(50, 700, 300, 100);
//        button4.setBounds(50,800,300,100);
        ImageIcon searchIcon = new ImageIcon("search-01.png");
        button4.setIcon(searchIcon);
        button4.setIconTextGap(0);


        //search driver  (reference - "https://stackoverflow.com/questions/22066387/how-to-search-an-element-in-a-jtable-java")

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(table.getModel());
                table.setRowSorter(rowSorter);

                jtext.getDocument().addDocumentListener(new DocumentListener(){

                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        String text = jtext.getText();

                        if (text.trim().length() == 0) {
                            rowSorter.setRowFilter(null);
                        } else {
                            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                        }
                    }

                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        String text = jtext.getText();

                        if (text.trim().length() == 0) {
                            rowSorter.setRowFilter(null);
                        } else {
                            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                        }
                    }

                    @Override
                    public void changedUpdate(DocumentEvent e) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                });


        }
        });






        // ------------------------------- create table ---------------------------------------//


        table = new JTable();
        frame.add(table);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setBackground(Color.GRAY);


        Object[] columns = {" Driver Name ", " Team ", " Position  ", " Date "};
         tablemodel = new DefaultTableModel();

        tablemodel.setColumnIdentifiers(columns);
        table.setModel(tablemodel);
        table.setRowHeight(40);
        table.setAutoCreateRowSorter(true);
        table.getColumnModel().getColumn(0).setPreferredWidth(280);
        table.getColumnModel().getColumn(1).setPreferredWidth(280);
        table.getColumnModel().getColumn(2).setPreferredWidth(280);
        table.getColumnModel().getColumn(3).setPreferredWidth(280);

        for (Race D : raceList) {
            Object[] data = {D.getDriverName(), D.getDriverTeam(), D.getPosition(), D.getDate() + "/" + D.getMonth() + "/" + D.getYear()};
            tablemodel.addRow(data);
        }

        JScrollPane pane = new JScrollPane(table);
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        pane.setForeground(Color.darkGray);
        pane.setBackground(Color.DARK_GRAY);
        pane.setBounds(405, 0, 2000, 1000);
//        pane.setBounds(430, 0, 1458, 1000);

        frame.getContentPane().add(pane);

        frame.setVisible(true);


        //generate random race

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int rawnum=tablemodel.getRowCount();
                for (int i=0;i<rawnum;i++){
                    tablemodel.removeRow(0);
                }

                Random random = new Random();

                //get random days
                int ranDate = random.nextInt(31) + 1;
                //get random months
                int ranMonth = random.nextInt(12) + 1;
                //get random year
                int randYear = 2022;

                for (Formula1Driver formula1Driver : formulaList) {
                    int position = ThreadLocalRandom.current().nextInt(1, 10);

                    if (position == 1) {
                        formula1Driver.setNoOfPoints(formula1Driver.getNoOfPoints() + 25);//update points
                        formula1Driver.setFirstPosition(formula1Driver.getFirstPosition() + 1);//update no of first places
                        formula1Driver.setNoOfRace(formula1Driver.getNoOfRace() + 1);//updated no of races

                    }
                    if (position == 2) {
                        //update driver statics
                        formula1Driver.setNoOfPoints(formula1Driver.getNoOfPoints() + 18);//update points
                        formula1Driver.setSecondPosition(formula1Driver.getSecondPosition() + 1);//update no of second places
                        formula1Driver.setNoOfRace(formula1Driver.getNoOfRace() + 1);//updated no of races

                    }
                    if (position == 3) {
                        //update driver statics
                        formula1Driver.setNoOfPoints(formula1Driver.getNoOfPoints() + 15);//update points
                        formula1Driver.setThirdPosition(formula1Driver.getThirdPosition() + 1);//update no of third places
                        formula1Driver.setNoOfRace(formula1Driver.getNoOfRace() + 1);//updated no of races

                    }
                    if (position == 4) {
                        //update driver statics
                        formula1Driver.setNoOfPoints(formula1Driver.getNoOfPoints() + 12);//update points
                        formula1Driver.setNoOfRace(formula1Driver.getNoOfRace() + 1);//updated no of races

                    }
                    if (position == 5) {
                        //update driver statics
                        formula1Driver.setNoOfPoints(formula1Driver.getNoOfPoints() + 10);//update points
                        formula1Driver.setNoOfRace(formula1Driver.getNoOfRace() + 1);//updated no of races

                    }
                    if (position == 6) {
                        //update driver statics
                        formula1Driver.setNoOfPoints(formula1Driver.getNoOfPoints() + 8);//update points
                        formula1Driver.setNoOfRace(formula1Driver.getNoOfRace() + 1);//updated no of races

                    }
                    if (position == 7) {
                        //update driver statics
                        formula1Driver.setNoOfPoints(formula1Driver.getNoOfPoints() + 6);//update points
                        formula1Driver.setNoOfRace(formula1Driver.getNoOfRace() + 1);//updated no of races

                    }
                    if (position == 8) {
                        //update driver statics
                        formula1Driver.setNoOfPoints(formula1Driver.getNoOfPoints() + 4);//update points
                        formula1Driver.setNoOfRace(formula1Driver.getNoOfRace() + 1);//updated no of races

                    }
                    if (position == 9) {
                        //update driver statics
                        formula1Driver.setNoOfPoints(formula1Driver.getNoOfPoints() + 2);//update points
                        formula1Driver.setNoOfRace(formula1Driver.getNoOfRace() + 1);//updated no of races

                    }
                    if (position == 10) {
                        //update driver statics
                        formula1Driver.setNoOfPoints(formula1Driver.getNoOfPoints() + 1);//update points
                        formula1Driver.setNoOfRace(formula1Driver.getNoOfRace() + 1);//updated no of races

                    } else {
                        formula1Driver.setNoOfRace(formula1Driver.getNoOfRace());//updated no of races
                    }


                    Race race = new Race(formula1Driver.getDriverName(), formula1Driver.getDriverTeam(), ranDate, ranMonth, randYear, position);
                    raceList.add(race);
                }


                for (Race D : raceList) {
                    Object[] data = {D.getDriverName(), D.getDriverTeam(), D.getPosition(), D.getDate() + "/" + D.getMonth() + "/" + D.getYear()};
                    tablemodel.addRow(data);
                }


            }
        });


    }

}








