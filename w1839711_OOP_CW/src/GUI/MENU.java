package GUI;
import CLI.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MENU
{
    public static JFrame frame;
    private static JPanel panel;
    private static JButton button;
    private static JButton button2;
    private static JButton button3;
    private static JLabel label;
    private static JLabel label2;

    private static final Formula1ChampionshipManager F1 = new Formula1ChampionshipManager();

    public MENU()
    {
        initialize();
    }

    public void initialize()
    {
        //// frame creation

        frame = new JFrame();
        this.frame.setSize(1980,1080);
        this.frame.setTitle("FCM MENU V 1.2");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
        this.frame.setLayout(null);

        /// panel creation

        this.panel = new JPanel();
        this.panel.setLayout(null);
        this.panel.setSize(1980,1080);
        this.frame.add(panel);

        /// Heading Label

        this.label2= new JLabel();
        this.panel.add(label2);
        this.label2.setText("FCM - Main Menu");
        this.label2.setBounds(400, 25, 1500, 300);
        this.label2.setForeground(Color.WHITE);
        this.label2.setSize(1980,300);
        this.label2.setFont(new Font("Lucida Calligraphy", 10, 70));
        this.label2.setHorizontalTextPosition(JLabel.CENTER);

        //// Driver Info Button

        this.button= new JButton();
        this.button.setFocusable(false);
        this.panel.add(button);          // add button to panel
//        this.button.setBounds(680, 300, 550, 100);
        this.button.setBounds(500, 300, 500, 80);

        ImageIcon DrstatIcon = new ImageIcon("driverStat-01.png");
        this.button.setIcon(DrstatIcon);
        this.button.setIconTextGap(0);


        this.button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
               MENU.frame.dispose();
               DriverStat.frame.setVisible(true);


            }
        });


        //// Race Info Button

        this.button2= new JButton();
        this.button2.setFocusable(false);
        this.panel.add(button2);          // add button to panel
//        button2.setBounds(680, 500, 550, 100);
        button2.setBounds(500, 500, 500, 80);

        ImageIcon RstatIcon = new ImageIcon("racestat-01.png");
        this.button2.setIcon(RstatIcon);
        this.button2.setIconTextGap(0);

        this.button2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
               MENU.frame.dispose();
               RaceStat.frame.setVisible(true);

            }
        });



        //// Quit Button

        this.button3= new JButton();
        this.button3.setFocusable(false);
        this.panel.add(button3);          // add button to panel
//        this.button3.setBounds(680, 700, 550, 100);
        this.button3.setBounds(500, 700, 500, 80);

        ImageIcon QIcon = new ImageIcon("quit-01.png");
        this.button3.setIcon(QIcon);
        this.button3.setIconTextGap(0);

        this.button3.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MENU.frame.dispose();
                RaceStat.frame.setVisible(false);
                DriverStat.frame.setVisible(false);

            }
        });


        /// Image Label

        this.label = new JLabel();
        this.panel.add(label);
        this.label.setSize(1920,1080);
        ImageIcon  labelBG = new ImageIcon("back2.jpg");
        this.label.setIcon(labelBG);



    }


    public void showmenu()
    {
        this.frame.setVisible(true);

    }
}
