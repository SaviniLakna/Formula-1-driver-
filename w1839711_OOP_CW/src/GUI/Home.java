package GUI;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import static java.awt.SystemColor.menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static sun.io.Win32ErrorMode.initialize;


public class Home extends JFrame
{
    private static JFrame frame;
    private static JPanel panel;
    private static JButton button;
    private static JLabel label;
    private static JLabel label2;

    MENU menu = new MENU();

    public Home()
    {
        initialize();
    }

    public  void initialize()
    {
        //// frame creation

        frame = new JFrame();
        frame.setSize(1980,1080);
        frame.setTitle("FORMULA 1 Championship Manager BETA");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);

        /// panel creation

        panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(1980,1080);
        frame.add(panel);

        //// Heading Label

        label2 = new JLabel();
        panel.add(label2);
        label2.setText("FORMULA 1 Championship Manager ");
//        label2.setBounds(250, 30, 1500, 300);
        label2.setBounds(60, 30, 1500, 300);
        label2.setForeground(Color.WHITE);
        label2.setSize(1980,300);
        label2.setFont(new Font("Lucida Calligraphy", 10, 70));
        label2.setHorizontalTextPosition(JLabel.CENTER);

        ImageIcon logo = new ImageIcon("car.png");
        label2.setIcon(logo);

        label2.setVerticalTextPosition(JLabel.BOTTOM);


        ///// Launch Button

        button = new JButton();
        button.setFocusable(false);
        panel.add(button);          // add button to panel
//        button.setBounds(850, 500, 300, 100);
        button.setBounds(650, 500, 300, 100);

        ImageIcon launchIcon = new ImageIcon("launch-01.png");
        this.button.setIcon(launchIcon);
        this.button.setIconTextGap(0);

        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
//                JOptionPane.showMessageDialog(panel, "DONE");
                MENU menuframe = new MENU();
                menuframe.showmenu();
                Home.frame.dispose();


            }
        });



        /// Image Label

        label = new JLabel();
        panel.add(label);
        label.setSize(1980,1080);
        ImageIcon  labelBG = new ImageIcon("back1.png");
        label.setIcon(labelBG);



    }

    public void showHome()
    {
        frame.setVisible(true);
    }




}
