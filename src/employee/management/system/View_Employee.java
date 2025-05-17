package employee.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class View_Employee extends JFrame implements ActionListener{

    JButton searchButton, printButton, updateButton, backButton;
    Choice choiceEMP;
    JTable table;

    View_Employee(){

        getContentPane().setBackground(new Color(255, 131, 122));

        JLabel search = new JLabel("Search by employee id");
        search.setBounds(20,20,150,20);
        add(search);

        choiceEMP = new Choice();
        choiceEMP.setBounds(180,20,150,20);
        add(choiceEMP);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");

            while(resultSet.next()){
                choiceEMP.add(resultSet.getString("empId"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        table = new JTable();
        try{
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception ex){
            ex.printStackTrace();
        }

        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0,100,900,600);
        add(jp);

        searchButton = new JButton("Search");
        searchButton.setBounds(20,70,80,20);
        searchButton.addActionListener(this);
        add(searchButton);

        printButton = new JButton("Print");
        printButton.setBounds(120,70,80,20);
        printButton.addActionListener(this);
        add(printButton);

        updateButton = new JButton("Update");
        updateButton.setBounds(220,70,80,20);
        updateButton.addActionListener(this);
        add(updateButton);

        backButton = new JButton("Back");
        backButton.setBounds(320,70,80,20);
        backButton.addActionListener(this);
        add(backButton);

        setSize(900,700);
        setLayout(null);
        setLocation(300, 100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if( e.getSource() == searchButton ){
            String query = "select * from employee where empID = '"+choiceEMP.getSelectedItem()+"' ";
            try{
                Conn c = new Conn();
                ResultSet resultSet = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            }catch (Exception exp){
                exp.printStackTrace();
            }
        }else if( e.getSource() == printButton ){
            try{
                table.print();
            }catch (Exception E){
                E.printStackTrace();
            }
        }else if( e.getSource() == updateButton ){
            setVisible(false);
            new UpdateEmployee(choiceEMP.getSelectedItem());
        } else  {
            setVisible(false);
            new Main_class();
        }
    }

    public static void main(String[] args) {
        new View_Employee();
    }
}
