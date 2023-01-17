import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.util.Scanner;
import java.awt.Color;
import java.awt.Font;


public class PatientData extends JFrame {
    public PatientData(){
        JFrame patientDataFrame = new JFrame("ST. Lorenzo Ruiz Hospital");

        patientDataFrame.setLayout(null);
        patientDataFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        patientDataFrame.setSize(1200, 750);
        patientDataFrame.setLocationRelativeTo(null);
        patientDataFrame.getContentPane().setBackground(new Color(125, 125, 225));
        Font fontStyle = new Font("Times New Roman", Font.BOLD, 20);

        ImageIcon icon = new ImageIcon("C:/Users/Jorenz Ferrer/Documents/NetBeansProjects/OOP FInals/hospitalLogo.png");
        patientDataFrame.setIconImage(icon.getImage());

        JLabel lblName = new JLabel("NAME:");
        lblName.setBounds(20, 500, 80, 25);
        patientDataFrame.add(lblName);

        JTextField fldName = new JTextField(20);
        fldName.setBounds(100, 500, 165, 25);
        patientDataFrame.add(fldName);

     
        JLabel lblAge = new JLabel("AGE:");
        lblAge.setBounds(20, 535, 80, 25);
        patientDataFrame.add(lblAge);


        JTextField fldAge = new JTextField(20);
        fldAge.setBounds(100, 535, 165, 25);
        patientDataFrame.add(fldAge);


        JLabel lblsex = new JLabel("SEX:");
        lblsex.setBounds(20, 570, 90, 25);
        patientDataFrame.add(lblsex);

       
        String sex[] = {"Male","Female"};
        JComboBox comboSex = new JComboBox(sex);
        comboSex.setBounds(100,  570, 165, 25);
        patientDataFrame.add(comboSex);


        JLabel lblBloodType = new JLabel("BLOOD TYPE:");
        lblBloodType.setBounds(400, 500, 90, 25);
        patientDataFrame.add(lblBloodType);

        String bloodType[] = {"A+","B+","AB+","O+","A-","B-","AB-","O-"};
        JComboBox comboBloodtype = new JComboBox(bloodType);
        comboBloodtype.setBounds(490,  500, 165, 25);
        patientDataFrame.add(comboBloodtype);

        JLabel lblMarStat = new JLabel("MARITAL STAT:");
        lblMarStat.setBounds(400, 535, 90, 25);
        patientDataFrame.add(lblMarStat);

        String MaritalStatus[] = {"Single", "Married", "Divorced", "Widow"};
        JComboBox comboMarStat = new JComboBox(MaritalStatus);
        comboMarStat.setBounds(490,  535, 165, 25);
        patientDataFrame.add(comboMarStat);

        
        JLabel lblMedHis = new JLabel("MED HISTORY:");
        lblMedHis.setBounds(400, 570, 90, 25);
        patientDataFrame.add(lblMedHis);

        String MedicalHistory[] = {"Anemia", "Asthma", "Bronchitis", "Chickenpox", "Diabetes", "Pneumonia", "Thyroid Disease", "Ulcer", "Other:"};
        JComboBox comboMedHis = new JComboBox(MedicalHistory);
        comboMedHis.setBounds(490,  570, 165, 25);
        patientDataFrame.add(comboMedHis);

      
        JLabel lblPhoneNum = new JLabel("PHONE NO.:");
        lblPhoneNum.setBounds(780, 500, 80, 25);
        patientDataFrame.add(lblPhoneNum);

        JTextField fldPhoneNum = new JTextField(20);
        fldPhoneNum.setBounds(860, 500, 165, 25);
        patientDataFrame.add(fldPhoneNum);

        JLabel lblDate = new JLabel("VISIT DATE:");
        lblDate.setBounds(780, 535, 80, 25);
        patientDataFrame.add(lblDate);

        JTextField fldDate = new JTextField(20);
        fldDate.setBounds(860, 535, 165, 25);
        patientDataFrame.add(fldDate);

        JLabel lblBalance = new JLabel("BALANCE:");
        lblBalance.setBounds(780, 570, 80, 25);
        patientDataFrame.add(lblBalance);

        JTextField fldBalance = new JTextField(20);
        fldBalance.setBounds(860, 570, 165, 25);
        patientDataFrame.add(fldBalance);

        
       
         
        JLabel lblTable = new JLabel("PATIENT INFORMATION");
        lblTable.setBounds(25, 10, 500, 30);
        patientDataFrame.add(lblTable);
        lblTable.setFont(new Font("Times New Roman", Font.BOLD, 30));


        int length = 0;
        try{
            Scanner sc = new Scanner(new File("C:/Users/Jorenz Ferrer/Documents/NetBeansProjects/OOP FInals/patientData.txt"));
            while(sc.hasNextLine()){
                length++;
                sc.nextLine();
            }
            sc.close();
        }catch(Exception e){
            System.out.println("Error");
        }

        String data[][] = new String[length][9];

        String column[] = {"NAME", "AGE","SEX", "BLOOD TYPE", "MARITAL STATUS", "MEDICAL HISTORY", "PHONE NUMBER", "VISIT DATE", "BALANCE"};

        int i = 0;
        try{
            Scanner sc = new Scanner(new File("C:/Users/Jorenz Ferrer/Documents/NetBeansProjects/OOP FInals/patientData.txt"));
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] data1 = line.split(",");
                data[i][0] = data1[0];
                data[i][1] = data1[1];
                data[i][2] = data1[2];
                data[i][3] = data1[3];
                data[i][4] = data1[4];
                data[i][5] = data1[5];
                data[i][6] = data1[6];
                data[i][7] = data1[7];
                data[i][8] = data1[8];
                i++;
            }
            sc.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        DefaultTableModel DataTable = new DefaultTableModel(data, column);
        JTable table = new JTable(DataTable);
        table.setBounds(20, 50, 1150, 425);
        patientDataFrame.add(table);

        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 50, 1150, 425);
        patientDataFrame.add(scrollPane);

        table.setRowSelectionAllowed(true);

        JButton buttonAdd = new JButton("ADD");
        buttonAdd.setBounds(50, 650, 80, 25);
        patientDataFrame.add(buttonAdd);

        JButton buttonUpdate = new JButton("UPDATE");
        buttonUpdate.setBounds(150, 650, 80, 25);
        patientDataFrame.add(buttonUpdate);

        JButton buttonDelete = new JButton("DELETE");
        buttonDelete.setBounds(350, 650, 80, 25);
        patientDataFrame.add(buttonDelete);

        JButton buttonClear = new JButton("CLEAR");
        buttonClear.setBounds(250, 650, 80, 25);
        patientDataFrame.add(buttonClear);


        JButton btnLogout = new JButton("LOGOUT");
        btnLogout.setBounds(1000, 650, 100, 25);
        patientDataFrame.add(btnLogout);
        

        patientDataFrame.setVisible(true);
        
        buttonAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a){ 
                int PatientTable = table.getSelectedRow();
                String name = fldName.getText();
                String age = fldAge.getText();
                String PhoneNumber = fldPhoneNum.getText();
                String balance = fldBalance.getText();
                String sex = comboSex.getSelectedItem().toString();
                String bloodType = comboBloodtype.getSelectedItem().toString();
                String maritalStatus = comboMarStat.getSelectedItem().toString();
                String medHistory = comboMedHis.getSelectedItem().toString();
                String visitDate = fldDate.getText();
                
                if(!name.equals("") && !age.equals("") && !sex.equals("") && !bloodType.equals("")  && !maritalStatus.equals("")  && !medHistory.equals("") && !PhoneNumber.equals("") && !visitDate.equals("") && !balance.equals("")){
                                                        try{
                                                            File file = new File("C:/Users/Jorenz Ferrer/Documents/NetBeansProjects/OOP FInals/patientData.txt");
                                                            FileWriter fileWriter = new FileWriter(file,true);
                                                            fileWriter.write(name + " , " + age + " , " +  sex + " , " + bloodType + " , " + maritalStatus + " , " + medHistory + " , " + PhoneNumber + " , " + visitDate + " , " + balance  +"\n");
                                                            JOptionPane.showMessageDialog(null, "PATIENT DATA ADDED");
                                                            fileWriter.close();
                                                        }catch(Exception ex){ex.printStackTrace();}
                                                            patientDataFrame.dispose();
                                                            new PatientData();
            
                }else{JOptionPane.showMessageDialog(null, "FILL UP BLANK FIELDS");}
    
            }
        });
    
       
        buttonUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a){
                int PatientTable = table.getSelectedRow();
                String name = fldName.getText();
                String age = fldAge.getText();
                String sex = comboSex.getSelectedItem().toString();
                String bloodType = comboBloodtype.getSelectedItem().toString();
                String PhoneNumber = fldPhoneNum.getText();
                String balance = fldBalance.getText();
                String maritalStatus = comboMarStat.getSelectedItem().toString();
                String medHistory = comboMedHis.getSelectedItem().toString();
                String visitDate = fldDate.getText();
                
                if(PatientTable==-1){
                    JOptionPane.showMessageDialog(null, "SELECT LINE TO UPDATE");
                }
                else{
                    if(!name.equals("") && !age.equals("") && !sex.equals("") && !bloodType.equals("")  && !maritalStatus.equals("")  && !medHistory.equals("") && !PhoneNumber.equals("") && !visitDate.equals("") && !balance.equals("")){
                                                        if(PatientTable >= 0) {
                                                            DataTable.setValueAt(name, PatientTable, 0);
                                                            DataTable.setValueAt(age, PatientTable, 1);
                                                            DataTable.setValueAt(sex, PatientTable, 2);
                                                            DataTable.setValueAt(bloodType, PatientTable, 3);
                                                            DataTable.setValueAt(maritalStatus, PatientTable, 4);
                                                            DataTable.setValueAt(medHistory, PatientTable, 5);
                                                            DataTable.setValueAt(PhoneNumber, PatientTable, 6);
                                                            DataTable.setValueAt(visitDate, PatientTable, 7);
                                                            DataTable.setValueAt(balance, PatientTable, 8);
                                                            
                                                            
                                                            try {
                                                                FileWriter fileWriter = new FileWriter("C:/Users/Jorenz Ferrer/Documents/NetBeansProjects/OOP FInals/patientData.txt");
                                                                for(int j = 0; j < table.getRowCount(); j++) {
                                                                    fileWriter.write(DataTable.getValueAt(j, 0).toString() + " , " + DataTable.getValueAt(j, 1).toString() + " , " + DataTable.getValueAt(j, 2).toString() + " , " + DataTable.getValueAt(j, 3).toString() + " , " + DataTable.getValueAt(j, 4).toString() + " , " + DataTable.getValueAt(j, 5).toString() + " , " + DataTable.getValueAt(j, 6).toString() + " , " +  DataTable.getValueAt(j, 7).toString() + " , " + DataTable.getValueAt(j, 8).toString() +"\n");
                                                                }
                                                                fileWriter.close();
                                                                JOptionPane.showMessageDialog(null, "UPDATED");
                                                               
                                                            } catch (IOException e1) {e1.printStackTrace();}
                                                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "FILL UP BLANK FIELDS");
                    }
    
                }
    
            }
        });
    
        
        buttonDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                int row = table.getSelectedRow();
                    if(row == -1) {
                        JOptionPane.showMessageDialog(null, "SELECT LINE TO DELETE");
                    }else {
                        int deleteData = JOptionPane.showConfirmDialog(null, "DELETE PATIENT DATA?", "DELETE", JOptionPane.YES_NO_OPTION);
                        if(deleteData == JOptionPane.YES_OPTION) {
                            DataTable.removeRow(row);
                            try {
                                FileWriter fileWriter = new FileWriter("C:/Users/Jorenz Ferrer/Documents/NetBeansProjects/OOP FInals/patientData.txt");
                                for(int j = 0; j < table.getRowCount(); j++) {
                                    fileWriter.write(DataTable.getValueAt(j, 0).toString() + " , " + DataTable.getValueAt(j, 1).toString() + " , " + DataTable.getValueAt(j, 2).toString() + " , " + DataTable.getValueAt(j, 3).toString() + " , " + DataTable.getValueAt(j, 4).toString() + " , " + DataTable.getValueAt(j, 5).toString() + " , " + DataTable.getValueAt(j, 6).toString() + " , " +  DataTable.getValueAt(j, 7).toString() + " , " + DataTable.getValueAt(j, 8).toString() +"\n");
                                }
                                fileWriter.close();
                                JOptionPane.showMessageDialog(null, "PATIENT DATA DELETED");
                            } catch (IOException e1) {e1.printStackTrace();
                        }
                    }
                }
            }
        });
    
        buttonClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                fldName.setText("");
                fldAge.setText("");
                fldPhoneNum.setText("");
                fldBalance.setText("");
                fldDate.setText("");
            }
        });  

        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a){
                patientDataFrame.dispose();
                new LoginPage();
            }
        });
    }
    public static void main(String[]args){
        new PatientData();
    }
}
