package Hospital.Management.System;
import javax.print.attribute.standard.JobOriginatingUserName;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener {
    JTextField textField;
    JPasswordField jpasswordField;
    JButton b1,b2;


    Login(){


        JLabel namelabel = new JLabel("UserName");
        namelabel.setBounds(50,20,100,30);
        namelabel.setFont(new Font("Tahoma",Font.BOLD,16));
        add(namelabel);

        JLabel password = new JLabel("Password");
        password.setBounds(50,70,100,30);
        password.setFont(new Font("Tahoma",Font.BOLD,16));
        add(password);

        textField = new JTextField();
        textField.setBounds(150,20,150,30);
        textField.setFont(new Font("Tahoma",Font.PLAIN,15));
        textField.setBackground(new Color(255,179,0));
        add(textField);

        jpasswordField = new JPasswordField();
        jpasswordField.setBounds(150,70,150,30);
        jpasswordField.setFont(new Font("Tahoma",Font.PLAIN,15));
        jpasswordField.setBackground(new Color(255,179,0));
        add (jpasswordField);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i1 = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(300,-30,300,300);
        add(label);

        b1= new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(new Color(109,164,170));
        setSize(650,300);
        setLocation(300,300);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String [] args){
      new Login();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            try {
                conn c = new conn();
                String user = textField.getText();
                String pass = jpasswordField.getText();
                String q = "Select * from login where ID = '" + user + "' and PW ='" + pass + "'";
                ResultSet resultSet = c.statement.executeQuery(q);

                if (resultSet.next()) {
                    new Reception();
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null,"Invalid");
                }

            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            System.exit(10);
        }

    }
}
