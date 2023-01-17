import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class LoginPage extends JFrame{
    public LoginPage(){
        JFrame loginFrame = new JFrame();
        loginFrame.getContentPane().setBackground(new Color(205, 103, 153));
        
        JLabel entry = new JLabel("ST. LORENZO RUIZ HOSPITAL");
        entry.setFont(new Font("Times New Roman", Font.BOLD, 30));
        entry.setBounds(150, 0, 500, 50);
        
        ImageIcon icon = new ImageIcon("C:/Users/Jorenz Ferrer/Documents/NetBeansProjects/OOP FInals/hospitalLogo.png");
        loginFrame.setIconImage(icon.getImage());

        JLabel lblLogo = new JLabel();
        lblLogo.setIcon(new ImageIcon("C:/Users/Jorenz Ferrer/Documents/NetBeansProjects/OOP FInals/hospitalLogo.png"));
        lblLogo.setBounds(275, 35, 200, 200 );
        loginFrame.add(lblLogo);
        
        
        JLabel lblName = new JLabel("USERNAME:");
        lblName.setBounds(150, 250, 100, 30);
        loginFrame.add(lblName);

        JTextField fldName = new JTextField(15);
        fldName.setBounds(250, 250, 250, 30);
        loginFrame.add(fldName);

        JLabel lblPass = new JLabel("PASSWORD:");
        lblPass.setBounds(150, 300, 200, 30);
        loginFrame.add(lblPass);

        JTextField fldPass = new JTextField(15);
        fldPass.setBounds(250, 300, 250, 30);
        loginFrame.add(fldPass);

        JButton btnLogin = new JButton("LOGIN");
        btnLogin.setBounds(250, 350 , 100, 40);
        loginFrame.add(btnLogin);

        JButton btnRegister = new JButton("REGISTER");
        btnRegister.setBounds(400, 350 , 100, 40);
        loginFrame.add(btnRegister);
    
        loginFrame.setLayout(null);
        loginFrame.setSize(750,500);
        loginFrame.setTitle("ST. LORENZO RUIZ HOSPITAL");
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setVisible(true);
        loginFrame.setResizable(true);
        loginFrame.add(entry);

       
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a){
                new RegisterPage();
                loginFrame.setVisible(false);
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a){
                String username = fldName.getText();
                String password = fldPass.getText();
                String line = "";
                
                File file = new File("C:/Users/Jorenz Ferrer/Documents/NetBeansProjects/OOP FInals/LoginData.txt");
                    if(username.isEmpty() || password.isEmpty()){
                        JOptionPane.showMessageDialog(null, "PLEASE FILL IN BLANKS");
                    }
                    try (Scanner scan = new Scanner(file)) {
                        while(scan.hasNextLine()){
                            line = scan.nextLine();
                            String[] datasplit = line.split(" , ");
                            if(username.equals(datasplit[0]) && password.equals(datasplit[1])){
                                loginFrame.dispose();
                                JOptionPane.showMessageDialog(null, "LOGIN SUCCESS");
                                new PatientData();
        
                            }
                        }
                    }catch (FileNotFoundException e){ e.printStackTrace();}
                    
                    fldName.setText("");
                    fldPass.setText("");
            }
        });
    }
    public static void main(String[]args){
        new LoginPage();
    }
}