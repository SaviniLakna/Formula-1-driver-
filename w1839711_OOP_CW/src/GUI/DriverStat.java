package GUI;

import CLI.Formula1ChampionshipManager;
import CLI.Formula1Driver;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class DriverStat {

        public static JFrame frame;
        private static JPanel panel;
        private static JPanel panel2;
        private static JButton button;
        private static JButton button2;
        private static JButton button3;
        public static JTable table;
        static ArrayList<Formula1Driver> formulaList = new ArrayList<>(10);

        private static final Formula1ChampionshipManager F1 = new Formula1ChampionshipManager();

        public DriverStat(ArrayList<Formula1Driver> formulaList)
        {
            initialize(DriverStat.formulaList=formulaList);
        }

        public static void initialize(ArrayList<Formula1Driver> formulaList) {

            DriverStat.formulaList=formulaList;

            // creat Frame

            frame = new JFrame();
            frame.setSize(1980,1080);
            frame.setTitle("FCM Driver Stat V 1.2");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setLayout(null);



            // create panel

            //panel = new JPanel(new GridBagLayout());
            panel = new JPanel();
            panel.setLayout(null);
            frame.getContentPane().add(panel, BorderLayout.EAST);
            panel.setBounds(0, 0, 350, 1080);
//            panel.setBounds(0, 0, 400, 1080);


            //GridBagConstraints gbc = new GridBagConstraints();
            //gbc.anchor = GridBagConstraints.WEST;
            //gbc.insets = new Insets(100, 100, 100, 100);
            panel.setBackground(Color.darkGray);


            // create back button

            button = new JButton();
            //gbc.gridx = 0;
            //gbc.gridy = 0;
            panel.add(button);
            button.setFocusable(false);
            button.setBounds(25, 200, 300, 100);
//            button.setBounds(50, 200, 300, 100);
            button.setOpaque(true);

            ImageIcon goIcon = new ImageIcon("go back-01.png");
            button.setIcon(goIcon);
            button.setIconTextGap(0);


            button.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    MENU menu= new MENU();
                    DriverStat.frame.dispose();
                    menu.frame.setVisible(true);

                }
            });



            // Creat button "Sort by Points"

            button2 = new JButton();
            panel.add(button2);
            button2.setOpaque(true);
            button2.setForeground(Color.BLACK);
            button2.setBackground(Color.red);
            button2.setFocusable(false);
            button2.setBounds(25, 400, 300, 100);
//            button2.setBounds(50, 400, 300, 100);

            ImageIcon pointsIcon = new ImageIcon("points-01.png");
            button2.setIcon(pointsIcon);
            button2.setIconTextGap(0);

            button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DefaultRowSorter sorter = ((DefaultRowSorter)table.getRowSorter());
                    ArrayList list = new ArrayList();
                    list.add( new RowSorter.SortKey(6, SortOrder.ASCENDING) );
                    sorter.setSortKeys(list);
                    sorter.sort();
                }
            });




            // Creat Button "Sort by First Position"

            button3 = new JButton();
            panel.add(button3);
            button3.setOpaque(true);
            button3.setForeground(Color.BLACK);
            button3.setBackground(Color.red);
            button3.setFocusable(false);
            button3.setBounds(25, 600, 300, 100);
//            button3.setBounds(50, 600, 300, 100);

            ImageIcon placeIcon = new ImageIcon("1st-01.png");
            button3.setIcon(placeIcon);
            button3.setIconTextGap(0);

            button3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    DefaultRowSorter sorter = ((DefaultRowSorter)table.getRowSorter());
                    ArrayList list = new ArrayList();
                    list.add( new RowSorter.SortKey(3, SortOrder.DESCENDING) );
                    sorter.setSortKeys(list);
                    sorter.sort();
                }
            });



            // ------------------------------- create table ---------------------------------------//



            table = new JTable();
            frame.add(table);

            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            table.setBackground(Color.GRAY);



            Object[] columns =  {"Driver Name", "Location","Team","1st Position","2nd Position","3rd Position","No of points","No of Races"};
            DefaultTableModel tablemodel = new DefaultTableModel ();


            tablemodel.setColumnIdentifiers(columns);
            table.setModel(tablemodel);
            table.setRowHeight(40);
            table.setAutoCreateRowSorter(true);
            table.getColumnModel().getColumn(0).setPreferredWidth(145);
            table.getColumnModel().getColumn(1).setPreferredWidth(145);
            table.getColumnModel().getColumn(2).setPreferredWidth(145);
            table.getColumnModel().getColumn(3).setPreferredWidth(145);
            table.getColumnModel().getColumn(4).setPreferredWidth(145);
            table.getColumnModel().getColumn(5).setPreferredWidth(145);
            table.getColumnModel().getColumn(6).setPreferredWidth(145);
            table.getColumnModel().getColumn(7).setPreferredWidth(145);


            for (Formula1Driver D: formulaList){
                Object[] data = {D.getDriverName(),D.getDriverLocation(),D.getDriverTeam(),D.getFirstPosition(),D.getSecondPosition(),D.getThirdPosition(),D.getNoOfPoints(),D.getNoOfRace()};
                tablemodel.addRow(data);
            }

            tablemodel.fireTableDataChanged();


            JScrollPane pane = new JScrollPane(table);
            pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            pane.setForeground(Color.darkGray);
            pane.setBackground(Color.DARK_GRAY);
            pane.setBounds(360, 0, 2000, 1000);
//            pane.setBounds(430, 0, 1458, 1000);

            frame.getContentPane().add(pane);

            frame.setVisible(true);
        }

}


