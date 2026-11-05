
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Student {
    String prn, name, school, program;
    String studentClass, division, mobile, email;

    Student(String prn, String name, String school, String program,
            String studentClass, String division, String mobile, String email) {
        this.prn = prn;
        this.name = name;
        this.school = school;
        this.program = program;
        this.studentClass = studentClass;
        this.division = division;
        this.mobile = mobile;
        this.email = email;
    }

    public String toString() {
        return "PRN: " + prn + ", Name: " + name
                + ", School: " + school + ", Program: " + program
                + ", Class: " + studentClass + ", Division: " + division
                + ", Mobile: " + mobile + ", Email: " + email;
    }
}

public class StudentRegistration extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8;
    JButton submit, clear;

    ArrayList<Student> students = new ArrayList<Student>();

    StudentRegistration() {
        setTitle("Student Registration System");
        setSize(450, 500);
        setLayout(new GridLayout(9, 2, 10, 10));

        l1 = new JLabel("Student PRN:");
        l2 = new JLabel("Student Name:");
        l3 = new JLabel("School Name:");
        l4 = new JLabel("Program Name:");
        l5 = new JLabel("Class:");
        l6 = new JLabel("Division:");
        l7 = new JLabel("Mobile:");
        l8 = new JLabel("Email:");

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        t7 = new JTextField();
        t8 = new JTextField();

        submit = new JButton("Submit");
        clear = new JButton("Clear");

        add(l1); add(t1);
        add(l2); add(t2);
        add(l3); add(t3);
        add(l4); add(t4);
        add(l5); add(t5);
        add(l6); add(t6);
        add(l7); add(t7);
        add(l8); add(t8);
        add(submit); add(clear);

        submit.addActionListener(this);
        clear.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == submit) {

                if (t1.getText().trim().isEmpty()
                        || t2.getText().trim().isEmpty()
                        || t3.getText().trim().isEmpty()
                        || t4.getText().trim().isEmpty()
                        || t5.getText().trim().isEmpty()
                        || t6.getText().trim().isEmpty()
                        || t7.getText().trim().isEmpty()
                        || t8.getText().trim().isEmpty()) {

                    JOptionPane.showMessageDialog(this,
                            "Please fill all fields!",
                            "Missing Information",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    Student s = new Student(
                            t1.getText().trim(),
                            t2.getText().trim(),
                            t3.getText().trim(),
                            t4.getText().trim(),
                            t5.getText().trim(),
                            t6.getText().trim(),
                            t7.getText().trim(),
                            t8.getText().trim()
                    );

                    students.add(s);

                    System.out.println("Student Registered Successfully!");
                    System.out.println(s);
                    System.out.println("------------------------------");

                    JOptionPane.showMessageDialog(this,
                            "Student Registered Successfully!");

                }

            } else if (e.getSource() == clear) {
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                t7.setText("");
                t8.setText("");

                JOptionPane.showMessageDialog(this,
                        "All fields cleared!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Error: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new StudentRegistration();
    }
}
