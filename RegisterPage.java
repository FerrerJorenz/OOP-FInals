import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.awt.*;
import java.awt.event.*;

public class RegisterPage extends JFrame{
    public RegisterPage(){
        JFrame registerFrame = new JFrame();
        
        registerFrame.getContentPane().setBackground(new Color(224,58,178));
                
        JLabel registration = new JLabel("REGISTER");
        registration.setFont(new Font("Times New Roman", Font.BOLD, 30));
        registration.setBounds(130, 20, 200, 100);
        registerFrame.add(registration);

        ImageIcon img = new ImageIcon("C:/Users/Jorenz Ferrer/Documents/NetBeansProjects/OOP FInals/hospitalLogo.png");
        registerFrame.setIconImage(img.getImage());

        JLabel lblName = new JLabel("USERNAME:");
        lblName.setBounds(40, 100, 100, 30);
        registerFrame.add(lblName);

        JTextField fldName = new JTextField(15);
        fldName.setBounds(120, 100, 200, 30);
        registerFrame.add(fldName);

        JLabel lblPass = new JLabel("PASSWORD:");
        lblPass.setBounds(40, 150, 100, 30);
        registerFrame.add(lblPass);

        JTextField fldPass = new JTextField(15);
        fldPass.setBounds(120, 150, 200, 30);
        registerFrame.add(fldPass);

        JLabel lblEmail = new JLabel("E-MAIL:");
        lblEmail.setBounds(40, 200, 100, 30);
        registerFrame.add(lblEmail);

        JTextField fldEmail = new JTextField(15);
        fldEmail.setBounds(120, 200, 200, 30);
        registerFrame.add(fldEmail);

        JButton btnBack = new JButton("BACK");
        btnBack.setBounds(75, 275 , 100, 40);
        registerFrame.add(btnBack);

        JButton btnRegister = new JButton("REGISTER");
        btnRegister.setBounds(200, 275 , 100, 40);
        registerFrame.add(btnRegister);

        registerFrame.setLayout(null);
        registerFrame.setSize(375,400);
        registerFrame.setTitle("ST. Lorenzo Ruiz Hospital");
        registerFrame.setLocationRelativeTo(null);
        registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registerFrame.setVisible(true);
        registerFrame.setResizable(false);

        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String username = fldName.getText();
                String password = fldPass.getText();
                String email = fldEmail.getText();
                
            if(!username.isEmpty() && !password.isEmpty() && !email.isEmpty()){
                try{
                    File file = new File("C:/Users/Jorenz Ferrer/Documents/NetBeansProjects/OOP FInals/LoginData.txt");
                    FileWriter fileWriter = new FileWriter(file,true);
                    fileWriter.write(username + " , " + password + " , " + email+ "\n");
                    JOptionPane.showMessageDialog(null, "REGISTER SUCCESS");
                    fileWriter.close();
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                        fldName.setText("");
                        fldPass.setText("");
                        fldEmail.setText("");
            }else{
                JOptionPane.showMessageDialog(null, "FILL IN THE BLANKS");
            }
            }
        });

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a){
                registerFrame.dispose();
                new LoginPage();
            }
        });
    }
    public static void main(String [] args){
        new RegisterPage();
    }
}
