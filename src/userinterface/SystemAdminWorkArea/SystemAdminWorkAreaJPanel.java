/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SystemAdminWorkArea;

import Business.Clinic.Clinic;
import Business.EcoSystem;
import Business.MindFitness.MindFitness;
import Business.PetTherapy.PetTherapy;
import Business.Role.ClinicAdminRole;
import Business.Role.MindFitnessAdminRole;
import Business.Role.PetTherapyAdminRole;
import Business.Role.UniversityAdminRole;
import Business.University.ForumAdmin;
import Business.University.Student;
import Business.University.University;
import Business.University.Volunteer;

import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MyPC1
 */
public class SystemAdminWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SystemAdminWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private EcoSystem system;
    private UserAccount account;
    public SystemAdminWorkAreaJPanel(JPanel userProcessContainer,UserAccount account, EcoSystem ecosystem) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.system=ecosystem;
        this.account = account;
        populateTable();
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        cmbOrgType = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEnterprises = new javax.swing.JTable();
        lblUsernm = new javax.swing.JLabel();
        lblPass = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        lblUsernm1 = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblCity = new javax.swing.JLabel();
        lblPincode = new javax.swing.JLabel();
        lblCountry = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPhoneNo = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtCity = new javax.swing.JTextField();
        txtZip = new javax.swing.JTextField();
        txtCountry = new javax.swing.JTextField();
        txtSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 254, 255));

        cmbOrgType.setBackground(new java.awt.Color(255, 255, 0));
        cmbOrgType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CLINIC", "UNIVERSITY", "MIND FITNESS", "PET THERAPY" }));
        cmbOrgType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOrgTypeActionPerformed(evt);
            }
        });

        tblEnterprises.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "NAME", "Enterprise Type", "Email", "Phone", "Address"
            }
        ));
        jScrollPane2.setViewportView(tblEnterprises);

        lblUsernm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsernm.setText("USERNAME");

        lblPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPass.setText("PASSWORD");

        btnSubmit.setBackground(new java.awt.Color(255, 255, 51));
        btnSubmit.setText("SUBMIT");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        lblUsernm1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsernm1.setText("NAME");

        lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEmail.setText("EMAIL");

        lblPhone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPhone.setText("PHONE NO");

        lblAddress.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAddress.setText("ADDRESS ");

        lblCity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCity.setText("CITY");

        lblPincode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPincode.setText("ZIP CODE");

        lblCountry.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCountry.setText("COUNTRY");

        txtSave.setBackground(new java.awt.Color(255, 255, 0));
        txtSave.setText("SAVE");
        txtSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaveActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 255, 51));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/settings.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblUsernm1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCity, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPincode, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtZip, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(52, 52, 52)
                                                .addComponent(txtSave, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(77, 77, 77)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(cmbOrgType, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblPass, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lblUsernm, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(30, 30, 30)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(49, 49, 49)
                                                .addComponent(btnSubmit)))
                                        .addGap(50, 50, 50)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 211, Short.MAX_VALUE)))
                .addContainerGap(221, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbOrgType, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUsernm, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPass, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSubmit)
                            .addComponent(btnDelete))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsernm1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(txtSave)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCity, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPincode, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtZip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(144, 144, 144))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jSplitPane.setLeftComponent(jPanel1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 667, Short.MAX_VALUE)
        );

        jSplitPane.setRightComponent(jPanel4);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 667, Short.MAX_VALUE)
        );

        jSplitPane.setRightComponent(jPanel3);

        add(jSplitPane, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:

        DefaultTableModel modelOrder = (DefaultTableModel)tblEnterprises.getModel();
        int selectedIndex = tblEnterprises.getSelectedRow();
        if(selectedIndex!=-1){

            String order = modelOrder.getValueAt(selectedIndex, 0).toString();
            String type = modelOrder.getValueAt(selectedIndex, 1).toString();
            system.getUserAccountDirectory().deleteUserAccount(order);
            if(type=="Clinic"){

                system.getClinicdirectory().deleteClinic(order);

                modelOrder.removeRow(selectedIndex);
                JOptionPane.showMessageDialog(this, "Deleted!");
                return;

            }

            if(type=="University"){

                system.getUniversitydirectory().deleteUniversity(order);

                modelOrder.removeRow(selectedIndex);
                JOptionPane.showMessageDialog(this, "Deleted!");
                return;

            }

            if(type=="Pet Therapy"){

                system.getPettherapydirectory().DeletePetTherapy(order);
                modelOrder.removeRow(selectedIndex);
                JOptionPane.showMessageDialog(this, "Deleted!");
                return;

            }

            if(type=="Mind Fitness"){

                system.getMindfitnessdir().deleteMindFitness(order);
                modelOrder.removeRow(selectedIndex);
                JOptionPane.showMessageDialog(this, "Deleted!");
                return;

            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaveActionPerformed
        // TODO add your handling code here:

        if(system.getClinicdirectory().RetrieveClinic(txtUsername.getText())!=null){
            Clinic therapist = system.getClinicdirectory().RetrieveClinic(txtUsername.getText());
            String name = txtName.getText();
            String email = txtEmail.getText();
            String phno = txtPhoneNo.getText();
            String address = txtAddress.getText();
            String city = txtCity.getText();
            String country = txtCountry.getText();
            String zipcode = txtZip.getText();

            if(name==null || email==null || phno==null || address==null || city==null || country==null || zipcode==null){

                JOptionPane.showMessageDialog(this, "Fields blank!");
                return;

            }

            String reg= "^\\d{10}$";
            Pattern pat = Pattern.compile(reg);
            Matcher mat = pat.matcher(phno);

            if(!(mat.matches())){

                JOptionPane.showMessageDialog(this, "Invalid Phone!");
                return;

            }

            String regemail = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

            Pattern em = Pattern.compile(regemail);
            Matcher ma = em.matcher(email);
            int f=0;
            if((ma.matches())){

                f=1;

            }
            if(f==0){

                JOptionPane.showMessageDialog(this, "Invalid Email!");
                return;

            }
            therapist.setName(name);
            therapist.setAddress(address);
            therapist.setCountry(country);
            therapist.setCity(city);
            therapist.setEmail(email);
            therapist.setPhone(phno);
            therapist.setZipcode(zipcode);
            JOptionPane.showMessageDialog(this, "Clinic Enterprise added!");
            populateTable();
            return;

        }

        if(system.getUniversitydirectory().RetrieveUniversity(txtUsername.getText())!=null){
            University therapist = system.getUniversitydirectory().RetrieveUniversity(txtUsername.getText());
            String name = txtName.getText();
            String email = txtEmail.getText();
            String phno = txtPhoneNo.getText();
            String address = txtAddress.getText();
            String city = txtCity.getText();
            String country = txtCountry.getText();
            String zipcode = txtZip.getText();

            if(name==null || email==null || phno==null || address==null || city==null || country==null || zipcode==null){

                JOptionPane.showMessageDialog(this, "Fields blank!");
                return;

            }

            String reg= "^\\d{10}$";
            Pattern pat = Pattern.compile(reg);
            Matcher mat = pat.matcher(phno);

            if(!(mat.matches())){

                JOptionPane.showMessageDialog(this, "Invalid Phone!");
                return;

            }

            String regemail = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

            Pattern em = Pattern.compile(regemail);
            Matcher ma = em.matcher(email);
            int f=0;
            if((ma.matches())){

                f=1;

            }
            if(f==0){

                JOptionPane.showMessageDialog(this, "Invalid Email!");
                return;

            }
            therapist.setName(name);
            therapist.setAddress(address);
            therapist.setCountry(country);
            therapist.setCity(city);
            therapist.setEmail(email);
            therapist.setPhone(phno);
            therapist.setZipcode(zipcode);
            JOptionPane.showMessageDialog(this, "University Enterprise added!");
            populateTable();
            return;

        }

        if(system.getMindfitnessdir().RetrieveMindFitness(txtUsername.getText())!=null){
            MindFitness therapist = system.getMindfitnessdir().RetrieveMindFitness(txtUsername.getText());
            String name = txtName.getText();
            String email = txtEmail.getText();
            String phno = txtPhoneNo.getText();
            String address = txtAddress.getText();
            String city = txtCity.getText();
            String country = txtCountry.getText();
            String zipcode = txtZip.getText();

            if(name==null || email==null || phno==null || address==null || city==null || country==null || zipcode==null){

                JOptionPane.showMessageDialog(this, "Fields blank!");
                return;

            }

            String reg= "^\\d{10}$";
            Pattern pat = Pattern.compile(reg);
            Matcher mat = pat.matcher(phno);

            if(!(mat.matches())){

                JOptionPane.showMessageDialog(this, "Invalid Phone!");
                return;

            }

            String regemail = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

            Pattern em = Pattern.compile(regemail);
            Matcher ma = em.matcher(email);
            int f=0;
            if((ma.matches())){

                f=1;

            }
            if(f==0){

                JOptionPane.showMessageDialog(this, "Invalid Email!");
                return;

            }
            therapist.setName(name);
            therapist.setAddress(address);
            therapist.setCountry(country);
            therapist.setCity(city);
            therapist.setEmail(email);
            therapist.setPhone(phno);
            therapist.setZipcode(zipcode);
            JOptionPane.showMessageDialog(this, "Mind Fitness Enterprise added!");
            populateTable();
            return;

        }
        if(system.getPettherapydirectory().RetrievePetTherapy(txtUsername.getText())!=null){
            PetTherapy therapist = system.getPettherapydirectory().RetrievePetTherapy(txtUsername.getText());
            String name = txtName.getText();
            String email = txtEmail.getText();
            String phno = txtPhoneNo.getText();
            String address = txtAddress.getText();
            String city = txtCity.getText();
            String country = txtCountry.getText();
            String zipcode = txtZip.getText();

            if(name==null || email==null || phno==null || address==null || city==null || country==null || zipcode==null){

                JOptionPane.showMessageDialog(this, "Fields blank!");
                return;

            }

            String reg= "^\\d{10}$";
            Pattern pat = Pattern.compile(reg);
            Matcher mat = pat.matcher(phno);

            if(!(mat.matches())){

                JOptionPane.showMessageDialog(this, "Invalid Phone!");
                return;

            }

            String regemail = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

            Pattern em = Pattern.compile(regemail);
            Matcher ma = em.matcher(email);
            int f=0;
            if((ma.matches())){

                f=1;

            }
            if(f==0){

                JOptionPane.showMessageDialog(this, "Invalid Email!");
                return;

            }
            therapist.setName(name);
            therapist.setAddress(address);
            therapist.setCountry(country);
            therapist.setCity(city);
            therapist.setEmail(email);
            therapist.setPhone(phno);
            therapist.setZipcode(zipcode);
            JOptionPane.showMessageDialog(this, "Pet Therapy Enterprise added!");
            populateTable();
            return;
        }

    }//GEN-LAST:event_txtSaveActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:

        if((txtUsername.getText().isEmpty())|| (txtPassword.getText().isEmpty())
        ){

            JOptionPane.showMessageDialog(this, "Field left Blank!");
        }
        String username = txtUsername.getText();
        String password = txtPassword.getText();

        String reg = "^(?=.*[0-9])"
        + "(?=.*[a-z])(?=.*[A-Z])"
        + "(?=.*[@#$%^&+=])"
        + "(?=\\S+$).{8,20}$";
        Pattern pat = Pattern.compile(reg);
        Matcher mat = pat.matcher(password);
        int f = 0;
        if(mat.matches()){
            f=1;

        }
        if(f==0){

            JOptionPane.showMessageDialog(this, "Invalid Password!");
            return;

        }

        if(system.getUserAccountDirectory().checkIfUsernameIsUnique(username)==false){

            JOptionPane.showMessageDialog(this, "Username already taken!");
            return;

        }

        if(cmbOrgType.getSelectedItem().toString()=="CLINIC"){

            system.getUserAccountDirectory().createUserAccount(username, password, new ClinicAdminRole());
            Clinic clinic = system.getClinicdirectory().addNewClinic();
            clinic.setId(txtUsername.getText());
            JOptionPane.showMessageDialog(this, "Clinic Admin Added!");
            return;

        }

        if(cmbOrgType.getSelectedItem().toString()=="UNIVERSITY"){

            system.getUserAccountDirectory().createUserAccount(username, password, new UniversityAdminRole());
            University uni = system.getUniversitydirectory().addNewUniversity();
            uni.setId(username);
            JOptionPane.showMessageDialog(this, "University Admin Added!");
            return;

        }

        if(cmbOrgType.getSelectedItem().toString()=="PET THERAPY"){

            system.getUserAccountDirectory().createUserAccount(username, password, new PetTherapyAdminRole());
            PetTherapy pt = system.getPettherapydirectory().AddPetTherapy();
            pt.setId(username);
            JOptionPane.showMessageDialog(this, "Pet Therapy Admin Added!");
            return;

        }

        if(cmbOrgType.getSelectedItem().toString()=="MIND FITNESS"){

            system.getUserAccountDirectory().createUserAccount(username, password, new MindFitnessAdminRole());
            MindFitness mf = system.getMindfitnessdir().addNewMindFitness();
            mf.setId(username);
            JOptionPane.showMessageDialog(this, "Mind Fitness Admin Added!");
            return;

        }

    }//GEN-LAST:event_btnSubmitActionPerformed

    private void cmbOrgTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrgTypeActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_cmbOrgTypeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<String> cmbOrgType;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSplitPane jSplitPane;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblPincode;
    private javax.swing.JLabel lblUsernm;
    private javax.swing.JLabel lblUsernm1;
    private javax.swing.JTable tblEnterprises;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtCountry;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPhoneNo;
    private javax.swing.JButton txtSave;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JTextField txtZip;
    // End of variables declaration//GEN-END:variables

    private void populateTable() {
         //To change body of generated methods, choose Tools | Templates.
         
         DefaultTableModel model = (DefaultTableModel) tblEnterprises.getModel();
         model.setRowCount(0);
         
         if(system.getUniversitydirectory().getUnilist()==null){
             
             ArrayList <University> unilist = new ArrayList();
             system.getUniversitydirectory().setUnilist(unilist);
             
         }
         
         if(system.getClinicdirectory().getCliniclist()==null){
             
             
             ArrayList <Clinic> cliniclist = new ArrayList();
             system.getClinicdirectory().setCliniclist(cliniclist);
             
         }
         
         if(system.getPettherapydirectory().getpettherapylist()==null){
             
             ArrayList <PetTherapy> ptist = new ArrayList();
             system.getPettherapydirectory().setPettherapylist(ptist);
             
         }
         
                  if(system.getMindfitnessdir().getMindfitlist()==null){
             
             ArrayList <MindFitness> mflist = new ArrayList();
             system.getMindfitnessdir().setMindfitlist(mflist);
             
         }
         
         
        
       
       
       
       for(University therapist: system.getUniversitydirectory().getUnilist()){
            
            Object[] row = new Object[5];
            row[0]= therapist.getId();
            row[1]= "University";
            row[2]= therapist.getEmail();
            row[3]= therapist.getPhone();
            row[4]=therapist.getAddress();
            
            model.insertRow(0, row);
                
            
            
            
        }
       
       for(Clinic clinicstaff: system.getClinicdirectory().getCliniclist()){
            
            Object[] row = new Object[5];
            row[0]= clinicstaff.getId();
            row[1]= "Clinic";
            row[2]= clinicstaff.getEmail();
            row[3]= clinicstaff.getPhone();
            row[4]=clinicstaff.getAddress();
            
            model.insertRow(0, row);
                
            
            
            
        }
       
       for(PetTherapy clinicstaff: system.getPettherapydirectory().getpettherapylist()){
            
            Object[] row = new Object[5];
            row[0]= clinicstaff.getId();
            row[1]= "Pet Therapy";
            row[2]= clinicstaff.getEmail();
            row[3]= clinicstaff.getPhone();
            row[4]=clinicstaff.getAddress();
            
            model.insertRow(0, row);
                
       
            
            
        }
       
       for(MindFitness clinicstaff: system.getMindfitnessdir().getMindfitlist()){
            
            Object[] row = new Object[5];
            row[0]= clinicstaff.getId();
            row[1]= "Mind Fitness";
            row[2]= clinicstaff.getEmail();
            row[3]= clinicstaff.getPhone();
            row[4]=clinicstaff.getAddress();
            
            model.insertRow(0, row);
                
       
            
            
        }
    
         
         
    }
}
