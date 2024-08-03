
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.io.*;

class Order2 {

    public static void main(String[] args) {
        new Order2();
    }

    Order2() {
        JFrame f = new JFrame("Order");

        /**** Background ****/
        ImageIcon background_image = new ImageIcon("orderImg.jpg");
        Image img = background_image.getImage();
        Image scaledImg = img.getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(scaledImg);
        JLabel background = new JLabel(" ", background_image, JLabel.CENTER);
        background.setBounds(0,0,900,600);

        /**** Header ****/
        JPanel heading = new JPanel();
        heading.setLayout(null);
        heading.setBackground(new Color(0, 0, 0, 90));
        heading.setBounds(0, 0, 900, 100);

        JLabel name = new JLabel("ORDER");
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setVerticalAlignment(JLabel.CENTER);
        name.setSize(900, 100);
        heading.setForeground(Color.black);
        name.setFont(new Font("Poppins", Font.BOLD, 40));
        heading.add(name);

        background.add(heading);

        /**** Order_page panel ****/
        JPanel Order_page = new JPanel();
        Order_page.setLayout(null);
        Order_page.setBackground(new Color(0, 0, 0, 90));
        Order_page.setBounds(35, 140, 400, 350);
        background.add(Order_page);

        /** Order heading **/
        JPanel ORDER_HEADING = new JPanel();
        ORDER_HEADING.setLayout(null);
        ORDER_HEADING.setBounds(0, 0, 400, 70);
        ORDER_HEADING.setBackground(new Color(238, 237, 237, 100));
        ORDER_HEADING.setForeground(Color.BLACK);

        JLabel name2 = new JLabel("ORDER DETAILS");
        name2.setHorizontalAlignment(JLabel.CENTER);
        name2.setVerticalAlignment(JLabel.CENTER);
        name2.setSize(400, 70);
        name2.setForeground(Color.BLACK);
        name2.setFont(new Font("Poppins", Font.BOLD, 25));
        ORDER_HEADING.add(name2);
        Order_page.add(ORDER_HEADING);

        /** Order_page body **/
        JLabel oid = new JLabel("ENTER ORDER ID: ");
        oid.setBounds(25, 120, 150, 40);
        oid.setFont(new Font("Ubuntu", Font.BOLD, 15));
        oid.setForeground(Color.WHITE);
        Order_page.add(oid);

        JTextField OrderID = new JTextField();
        OrderID.setBounds(190, 120, 180, 40);
        OrderID.setForeground(Color.white);
        OrderID.setBackground(Color.BLACK);
        Order_page.add(OrderID);

        JLabel quantityField = new JLabel("ENTER QUANTITY: ");
        quantityField.setBounds(25, 200, 150, 40);
        quantityField.setFont(new Font("Ubuntu", Font.BOLD, 15));
        quantityField.setForeground(Color.WHITE);
        Order_page.add(quantityField);

        JTextField quantity = new JTextField("");
        quantity.setBounds(190, 200, 180, 40);
        quantity.setForeground(Color.white);
        quantity.setBackground(Color.black);
        Order_page.add(quantity);

        JButton next = new JButton("NEXT");
        next.setBounds(130, 280, 100, 40);
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        Order_page.add(next);


        /** Order_page_right panel **/
        JPanel Order_page_right = new JPanel();
        Order_page_right.setLayout(null);
        Order_page_right.setBackground(new Color(0, 0, 0, 80));
        Order_page_right.setBounds(460, 140, 400, 350);
        background.add(Order_page_right);

        /** Order_page_right body **/
        JButton show = new JButton("SHOW MENU");
        show.setBounds(590, 160, 150, 40);
        show.setBackground(Color.black);
        show.setForeground(Color.white);
        Order_page_right.add(show);
        f.add(show);

        JButton add = new JButton("ADD");
        add.setBounds(50, 290, 100, 40);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        Order_page_right.add(add);

        JButton delete = new JButton("DELETE");
        delete.setBounds(250, 290, 100, 40);
        delete.setBackground(Color.black);
        delete.setForeground(Color.white);
        Order_page_right.add(delete);

        JButton back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(370, 510, 150, 40);
        background.add(back);

        /**** Setting the frame ****/
        f.setSize(900, 600);
        f.setLocation(250, 40);
        f.add(background);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**** Handling the events ****/
        next.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String s1 = OrderID.getText();
                String s2 = quantity.getText();
                String str = "";
                try {
                    FileWriter w = new FileWriter("YourOrder.txt", true);
                    BufferedReader b = new BufferedReader(new FileReader("menu.txt"));
                    while ((str = b.readLine()) != null) {
                        if (str.startsWith(s1)) {
                            w.write(str + "         ");
                            w.write(s2 + "\n");
                        }
                    }
                    w.close();
                } catch (Exception ex) {
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(f, "ERROR");
                }
                JOptionPane.showMessageDialog(f, "Successfully Saved" + " The Details");
            }

        });

        add.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                new Add_MenuItem();
                f.setVisible(false);
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }

        });

        delete.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                new Delete_MenuItem();
                f.setVisible(false);
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }

        });


        DefaultTableModel model = new DefaultTableModel();
        JTable menu = new JTable(model);
        menu.setBounds(25, 80, 350, 195);
        menu.setVisible(false);

        menu.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        JScrollPane pane = new JScrollPane(menu, v, h);
        Order_page_right.add(pane);
        f.add(pane, BorderLayout.CENTER);
        Order_page_right.add(menu);

        model.addColumn("Item ID");
        model.addColumn("Item Name");
        model.addColumn("Item Price");
        menu.getColumnModel().getColumn(1).setPreferredWidth(130);

        show.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                try {
                    String filepath = "menu.txt";
                    File input = new File(filepath);
                    BufferedReader br = new BufferedReader(new FileReader(input));

                    String x;
                    while ((x = br.readLine()) != null) {
                        String[] row = x.split(" , ");
                        model.addRow(row);
                    }
                    menu.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        });

        back.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new Attempt();
            }

        });
    }

}