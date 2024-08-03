
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class View_Employee {
    JFrame f;
    JTable t;

    View_Employee() {
        f = new JFrame("View Employee");

        DefaultTableModel model = new DefaultTableModel();
        t = new JTable(model);
        t.setBounds(50, 100, 650, 450);
        t.setVisible(true);
        model.addColumn("eID");
        model.addColumn("Name");
        model.addColumn("Age");
        model.addColumn("Address");
        model.addColumn("Phone Number");
        model.addColumn("Email");
        model.addColumn("Designation");
        t.getColumnModel().getColumn(1).setPreferredWidth(130);

        String[] row = new String[7];
        EmployeeList list = new EmployeeList();
        for (int i = 0; i < EmployeeList.employeeList.size(); i++) {
            Employee e = list.getEmployee(i);
            row[0] = Integer.toString(e.getID());
            row[1] = e.getName();
            row[2] = Integer.toString(e.getAge());
            row[3] = e.getAddress();
            row[4] = e.getPhoneNumber();
            row[5] = e.getEmail();
            row[6] = e.getDesignation();
            model.addRow(row);
        }

        JButton back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(370,520,150,40);
        f.add(back);

        back.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {

               if(e.getSource() == back) {
                   f.setVisible(false);
                   new Manage_Employee();
               }
           }

       });

        f.setSize(900, 600);
        f.setLocation(280, 40);
        f.setLayout(null);
        f.add(t);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
