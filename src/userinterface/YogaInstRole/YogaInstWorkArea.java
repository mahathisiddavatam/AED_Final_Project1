/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.YogaInstRole;

import Business.EcoSystem;
import Business.MindFitness.YogaInstructor;
import Business.MindFitness.YogaInstructorDirectory;
import Business.University.StudentDirectory;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.YogaAppointment;
import Business.WorkQueue.YogaAppointmentQueue;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.MainJFrame;

/**
 *
 * @author Varakumar
 */
public class YogaInstWorkArea extends javax.swing.JPanel {
    
    private JPanel UserProcessContainer;
    private UserAccount account;
    private EcoSystem system;
    YogaAppointmentQueue nutriqueue;
    YogaInstructorDirectory nutridir;
    StudentDirectory studentdirectory;
    YogaInstructor nutritionist;


    /**
     * Creates new form YogaInstWorkArea
     */
    public YogaInstWorkArea(JPanel UserProcessContainer, UserAccount account, EcoSystem system) {
        initComponents();
        this.UserProcessContainer=UserProcessContainer;
        this.account=account;
        this.system=system;
        
        this.nutridir = system.getMindfitnessdir().getYogadir();
        this.nutriqueue = system.getMindfitnessdir().getYogaqueue();
        this.studentdirectory = system.getUniversitydirectory().getStudentdir();
        nutritionist=system.getMindfitnessdir().getYogadir().RetrieveYogaInstructor(MainJFrame.txtUsernameMain.getText());
    }
    
    public void populateAppointmentTable(){
        
        DefaultTableModel model = (DefaultTableModel) tblAppointmentDetails.getModel();
        model.setRowCount(0);
        
        for(YogaAppointment app: nutriqueue.getYogaAppointmentlist()){
            
            if(app.getYogaid().equals(nutritionist.getId())){
            
            if(app.getTerminate()==false){
                
                Object[] row = new Object[6];
                row[0]= app.getId();
                
                row[1]= app.getStudentid();
                row[2] = studentdirectory.RetrieveStudent(app.getStudentid()).getName();
                row[3]= app.getDate();
                row[4] = app.getTime();
                row[5] = "Upcoming";
                
                
                model.insertRow(0, row);
            }
            
            else{
                Object[] row = new Object[6];
                row[0]= app.getId();
                
                row[1]= app.getStudentid();
                row[2] = studentdirectory.RetrieveStudent(app.getStudentid()).getName();
                row[3]= app.getDate();
                row[4] = app.getTime();
                row[5] = "Session Completed";
                
                
                model.insertRow(0, row);
                
            }
        }
        }
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lblWelcome = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAppointmentDetails = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnTerminate2 = new javax.swing.JButton();
        lblSpecial1 = new javax.swing.JLabel();
        txtSpecial1 = new javax.swing.JTextField();
        btnTerminate3 = new javax.swing.JButton();
        btnSaveSpec = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        lblWelcome.setBackground(new java.awt.Color(255, 255, 0));
        lblWelcome.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblWelcome.setText("WELCOME:");

        valueLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        valueLabel.setForeground(new java.awt.Color(0, 153, 153));
        valueLabel.setText("<value>");

        tblAppointmentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "SessionID", "StudentID", "Name", "Time", "Location", "Status"
            }
        ));
        jScrollPane1.setViewportView(tblAppointmentDetails);
        if (tblAppointmentDetails.getColumnModel().getColumnCount() > 0) {
            tblAppointmentDetails.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("--APPOINTMENT REQUESTS/STATUS--");

        btnTerminate2.setText("Refresh Table");
        btnTerminate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminate2ActionPerformed(evt);
            }
        });

        lblSpecial1.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblSpecial1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSpecial1.setText("Specialties in:");
        lblSpecial1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnTerminate3.setText("Terminate Session");
        btnTerminate3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminate3ActionPerformed(evt);
            }
        });

        btnSaveSpec.setText("Save");
        btnSaveSpec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveSpecActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(btnTerminate2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblSpecial1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)
                                        .addComponent(txtSpecial1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSaveSpec))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(262, 262, 262)
                        .addComponent(btnTerminate3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnTerminate2)))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSpecial1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSpecial1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveSpec))
                .addGap(70, 70, 70)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(btnTerminate3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("View Appointments", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTerminate3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminate3ActionPerformed
        // TODO add your handling code here:
        
        System.out.print("I am in button\n");
        DefaultTableModel modelOrder = (DefaultTableModel)tblAppointmentDetails.getModel();
        int selectedIndex = tblAppointmentDetails.getSelectedRow();
        if(selectedIndex==-1){
            
            JOptionPane.showMessageDialog(this, "Please Select a row!");
            return;
            
        }
        String id=null;
        
        if(selectedIndex!=-1){
            
             id = modelOrder.getValueAt(selectedIndex, 0).toString();
             //createdby = modelOrder.getValueAt(selectedIndex, 2).toString();
        }
        int intid = Integer.parseInt(id);
        
        
        YogaAppointment therapy = nutriqueue.retrieveYogaAppointment(intid);
        //System.out.print(therapy.getTerminate() +" this is terminate\n");
        therapy.setTerminate(Boolean.TRUE);
        //system.getUniversitydirectory().getStudentdir().RetrieveStudent(therapy.getStudentid()).setAppointment(Boolean.FALSE);
        JOptionPane.showMessageDialog(this, "Terminated!");
    }//GEN-LAST:event_btnTerminate3ActionPerformed

    private void btnTerminate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminate2ActionPerformed
        // TODO add your handling code here:
        populateAppointmentTable();
    }//GEN-LAST:event_btnTerminate2ActionPerformed

    private void btnSaveSpecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveSpecActionPerformed
        // TODO add your handling code here:
       nutritionist.setSpeciality(txtSpecial1.getText());
       JOptionPane.showMessageDialog(this, "Saved");
    }//GEN-LAST:event_btnSaveSpecActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSaveSpec;
    private javax.swing.JButton btnTerminate2;
    private javax.swing.JButton btnTerminate3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblSpecial1;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JTable tblAppointmentDetails;
    private javax.swing.JTextField txtSpecial1;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
