import java.awt.*;
//import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
//import java.io.FilterReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

class Payment {

    public static void main(String[] args) {
        new Payment();
    }

    Payment() {

        JFrame f = new JFrame("payment");

        //header
        JPanel heading;
        heading= new JPanel();
        heading.setBackground(new Color(0,0,0,80));
        heading.setBounds(0,0,900,100); 
       
        JLabel name= new JLabel("BILL");
        name.setBounds(200,250,400,50);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Serif", Font.BOLD,30));
        heading.add(name);

        JButton back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(390,500,100,50);
        
         
        back.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if(e.getSource() == back) {
                    f.setVisible(false);
                    new Attempt();
                }
            }

        });

        ImageIcon background_image= new ImageIcon("pay.jfif");
        Image img= background_image.getImage();
        Image im= img.getScaledInstance(900,600,Image.SCALE_SMOOTH);
        background_image= new ImageIcon(im);
        JLabel background= new JLabel(" ", background_image, JLabel.CENTER);

        background.add(heading);
        background.setBounds(0,0,900,600);
        background.setVisible(true);
       
        background.add(back);
        
        f.setVisible(true);
        f.add(heading);
        f.add(background);
        background.setVisible(true);
          
        //frame
        f.setSize(900,600);
        f.setLocation(280, 40);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
