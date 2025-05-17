package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateEmployee extends JFrame implements ActionListener {

    JTextField teducation, tfname, taddress, tphone, temail, tsalary, tdesignation;
    JLabel tempID, tname, tdob, taadhar;
    JButton updateButton, backButton;
    String number;

    UpdateEmployee(String number) {
        this.number = number;

        getContentPane().setBackground(new Color(60, 63, 65));
        setLayout(null);

        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        heading.setForeground(Color.WHITE);
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        name.setForeground(Color.WHITE);
        add(name);

        tname = new JLabel();
        tname.setBounds(200, 150, 150, 30);
        tname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tname.setOpaque(true);
        tname.setBackground(Color.GRAY);
        tname.setForeground(Color.WHITE);
        add(tname);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400, 150, 150, 30);
        fname.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        fname.setForeground(Color.WHITE);
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600, 150, 150, 30);
        tfname.setBackground(Color.WHITE);
        add(tfname);

        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(50, 200, 150, 30);
        dob.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        dob.setForeground(Color.WHITE);
        add(dob);

        tdob = new JLabel();
        tdob.setBounds(200, 200, 150, 30);
        tdob.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tdob.setOpaque(true);
        tdob.setBackground(Color.GRAY);
        tdob.setForeground(Color.WHITE);
        add(tdob);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(400, 200, 150, 30);
        salary.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        salary.setForeground(Color.WHITE);
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600, 200, 150, 30);
        tsalary.setBackground(Color.WHITE);
        add(tsalary);

        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 150, 30);
        address.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        address.setForeground(Color.WHITE);
        add(address);

        taddress = new JTextField();
        taddress.setBounds(200, 250, 150, 30);
        taddress.setBackground(Color.WHITE);
        add(taddress);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(400, 250, 150, 30);
        phone.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        phone.setForeground(Color.WHITE);
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(600, 250, 150, 30);
        tphone.setBackground(Color.WHITE);
        add(tphone);

        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 150, 30);
        email.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        email.setForeground(Color.WHITE);
        add(email);

        temail = new JTextField();
        temail.setBounds(200, 300, 150, 30);
        temail.setBackground(Color.WHITE);
        add(temail);

        JLabel education = new JLabel("Highest Education");
        education.setBounds(400, 300, 180, 30);
        education.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        education.setForeground(Color.WHITE);
        add(education);

        teducation = new JTextField();
        teducation.setBounds(600, 300, 150, 30);
        teducation.setBackground(Color.WHITE);
        add(teducation);

        JLabel designation = new JLabel("Designation");
        designation.setBounds(50, 350, 150, 30);
        designation.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        designation.setForeground(Color.WHITE);
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(200, 350, 150, 30);
        tdesignation.setBackground(Color.WHITE);
        add(tdesignation);

        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setBounds(400, 350, 150, 30);
        aadhar.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        aadhar.setForeground(Color.WHITE);
        add(aadhar);

        taadhar = new JLabel();
        taadhar.setBounds(600, 350, 150, 30);
        taadhar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        taadhar.setOpaque(true);
        taadhar.setBackground(Color.GRAY);
        taadhar.setForeground(Color.WHITE);
        add(taadhar);

        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(50, 400, 150, 30);
        empid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        empid.setForeground(Color.WHITE);
        add(empid);

        tempID = new JLabel();
        tempID.setBounds(200, 400, 150, 30);
        tempID.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        tempID.setOpaque(true);
        tempID.setBackground(Color.GRAY);
        tempID.setForeground(Color.WHITE);
        add(tempID);

        try {
            Conn c = new Conn();
            String query = "select * from employee where empID = '" + number + "'";
            ResultSet resultSet = c.statement.executeQuery(query);
            while (resultSet.next()) {
                tname.setText(resultSet.getString("name"));
                tfname.setText(resultSet.getString("fname"));
                tdob.setText(resultSet.getString("dob"));
                taddress.setText(resultSet.getString("address"));
                tsalary.setText(resultSet.getString("salary"));
                tphone.setText(resultSet.getString("phone"));
                temail.setText(resultSet.getString("email"));
                teducation.setText(resultSet.getString("education"));
                taadhar.setText(resultSet.getString("aadhar"));
                tempID.setText(resultSet.getString("empID"));
                tdesignation.setText(resultSet.getString("designation"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        updateButton = new JButton("UPDATE");
        updateButton.setBounds(250, 550, 150, 40);
        updateButton.setBackground(Color.BLACK);
        updateButton.setForeground(Color.WHITE);
        updateButton.addActionListener(this);
        add(updateButton);

        backButton = new JButton("BACK");
        backButton.setBounds(450, 550, 150, 40);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        add(backButton);

        setSize(900, 700);
        setLocation(300, 70);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if( e.getSource() == updateButton ){
            String fname = tfname.getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = teducation.getText();
            String designation = tdesignation.getText();

            try {
                Conn c = new Conn();
                String query = "update employee set fname = '"+fname+"', salary = '"+salary+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"', education = '"+education+"', designation = '"+designation+"' where empId = '"+number+"'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new Main_class();
            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
            new View_Employee();
        }
    }

    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}
