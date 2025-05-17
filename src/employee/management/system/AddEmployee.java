package employee.management.system;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField tname, tfname, taddress, tphone, taadhar, temail, tsalary, tdesignation;
    JLabel tempID;
    JDateChooser tdob;
    JComboBox educationBox;

    JButton addButton, backButton;

    Random ram = new Random();
    int number = ram.nextInt(999999);

    AddEmployee() {

        getContentPane().setBackground(new Color(60, 63, 65));



        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        heading.setForeground(Color.WHITE);
        add(heading);

        JLabel name = new JLabel("Name:");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20 ));
        name.setForeground(Color.WHITE);
        add(name);

        tname = new JTextField();
        tname.setBounds(200,150,150,30);
        tname.setBackground(Color.WHITE);
//        tname.setForeground(Color.WHITE);
        add(tname);

        JLabel fname = new JLabel("Father's Name:");
        fname.setBounds(400, 150, 150, 30);
        fname.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        fname.setForeground(Color.WHITE);
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600,150,150,30);
        tfname.setBackground(Color.WHITE);
        add(tfname);

        JLabel dob = new JLabel("Date Of Birth:");
        dob.setBounds(50, 200, 150, 30);
        dob.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        dob.setForeground(Color.WHITE);
        add(dob);

        tdob = new JDateChooser();
        tdob.setBounds(200, 200,150,30);
        tdob.setBackground(new Color(177,252,197));
        add(tdob);

        JLabel salary = new JLabel("Salary:");
        salary.setBounds(400, 200, 150, 30);
        salary.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        salary.setForeground(Color.WHITE);
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600,200,150,30);
        tsalary.setBackground(Color.WHITE);
        add(tsalary);

        JLabel address = new JLabel("Address:");
        address.setBounds(50, 250, 150, 30);
        address.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        address.setForeground(Color.WHITE);
        add(address);

        taddress = new JTextField();
        taddress.setBounds(200,250,150,30);
        taddress.setBackground(Color.WHITE);
        add(taddress);

        JLabel phone = new JLabel("Phone No:");
        phone.setBounds(400, 250, 150, 30);
        phone.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        phone.setForeground(Color.WHITE);
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(600,250,150,30);
        tphone.setBackground(Color.WHITE);
        add(tphone);

        JLabel email = new JLabel("Email:");
        email.setBounds(50, 300, 150, 30);
        email.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        email.setForeground(Color.WHITE);
        add(email);

        temail = new JTextField();
        temail.setBounds(200,300,150,30);
        temail.setBackground(Color.WHITE);
        add(temail);

        JLabel education = new JLabel("Education:");
        education.setBounds(400, 300, 150, 30);
        education.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        education.setForeground(Color.WHITE);
        add(education);

        String items[] = {"BBA", "MBA", "B.Tech", "M.Tech", "BCA", "MCA", "BSC", "B.Com", "PHD"};
        educationBox = new JComboBox(items);
        educationBox.setBounds(600,300,150,30);
        educationBox.setBackground(Color.WHITE);
        add(educationBox);

        JLabel aadhar = new JLabel("Aadhar No:");
        aadhar.setBounds(400, 350, 150, 30);
        aadhar.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        aadhar.setForeground(Color.WHITE);
        add(aadhar);

        taadhar = new JTextField();
        taadhar.setBounds(600,350,150,30);
        taadhar.setBackground(Color.WHITE);
        add(taadhar);

        JLabel empID = new JLabel("Employee ID:");
        empID.setBounds(50, 400, 150, 30);
        empID.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        empID.setForeground(Color.WHITE);
        add(empID);

        tempID = new JLabel("" + number, SwingConstants.CENTER);
        tempID.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        tempID.setHorizontalAlignment(SwingConstants.CENTER);
        tempID.setVerticalAlignment(SwingConstants.CENTER);
        tempID.setBounds(200,400,150,30);
        tempID.setBackground(Color.WHITE);
        tempID.setOpaque(true);
        add(tempID);

        JLabel designation = new JLabel("Designation:");
        designation.setBounds(50, 350, 150, 30);
        designation.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        designation.setForeground(Color.WHITE);
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(200,350,150,30);
        tdesignation.setBackground(Color.WHITE);
        add(tdesignation);


        addButton = new JButton("ADD");
        addButton.setBounds(250, 550, 150, 40);
        addButton.setBackground(Color.BLACK);
        addButton.setForeground(Color.white);
        addButton.addActionListener(this);
        add(addButton);

        backButton = new JButton("BACK");
        backButton.setBounds(450, 550, 150, 40);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.white);
        backButton.addActionListener(this);
        add(backButton);


        setSize(900, 700);
        setLocation(300, 70);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if( e.getSource() == addButton ){
            String name = tname.getText();
            String fname = tfname.getText();


            java.util.Date dobDate = tdob.getDate();


            if (dobDate != null) {
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                String dob = sdf.format(dobDate);

                String salary = tsalary.getText();
                String address = taddress.getText();
                String email = temail.getText();
                String phone = tphone.getText();
                String aadhar = taadhar.getText();
                String education = (String) educationBox.getSelectedItem();
                String designation = tdesignation.getText();
                String empID = tempID.getText();

                try {
                    Conn c = new Conn();
                    String query = "INSERT INTO employee(name, fname, dob, salary, address, email, phone, education, aadhar, designation, empID) " +
                            "VALUES('" + name + "', '" + fname + "', '" + dob + "', '" + salary + "', '" + address + "', '" + email + "', '" + phone + "', '" + education + "', '" + aadhar + "', '" + designation + "', '" + empID + "')";
                    c.statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Data Added Successfully");
                    setVisible(false);
                    new Main_class();
                } catch (Exception E) {
                    E.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please select a valid date.");
            }
        }else{
            setVisible(false);
            new Main_class();
        }
    }


    public static void main(String[] args) {
        new AddEmployee();
    }
}
