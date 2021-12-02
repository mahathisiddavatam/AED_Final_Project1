/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.StudentRole;

import Business.EcoSystem;

import Business.UserAccount.UserAccount;
import Business.WorkQueue.Therapy;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raunak
 */
public class StudentWorkAreaPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    
    
    /**
     * Creates new form LabAssistantWorkAreaJPanel
     */
    public StudentWorkAreaPanel(JPanel userProcessContainer, UserAccount account, EcoSystem business) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.business = business;
      
        
        populateTable();
    }
    
    public void populateTable(){
        
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
        txtName = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        lblAge = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblEthnicity = new javax.swing.JLabel();
        lblCountry = new javax.swing.JLabel();
        cmbGender = new javax.swing.JComboBox<>();
        cmbEthnicity = new javax.swing.JComboBox<>();
        txtCountry = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblQues1 = new javax.swing.JLabel();
        lblQues2 = new javax.swing.JLabel();
        lblQues3 = new javax.swing.JLabel();
        lblQues4 = new javax.swing.JLabel();
        lblQues5 = new javax.swing.JLabel();
        btnSubmitResponse = new javax.swing.JButton();
        cmbQues1 = new javax.swing.JComboBox<>();
        cmbQues2 = new javax.swing.JComboBox<>();
        cmbQues3 = new javax.swing.JComboBox<>();
        cmbQues4 = new javax.swing.JComboBox<>();
        cmbQues5 = new javax.swing.JComboBox<>();
        lblQues6 = new javax.swing.JLabel();
        cmbQues6 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cmbQues7 = new javax.swing.JComboBox<>();
        lblQues8 = new javax.swing.JLabel();
        cmbQues8 = new javax.swing.JComboBox<>();
        lblQues9 = new javax.swing.JLabel();
        cmbQues9 = new javax.swing.JComboBox<>();
        lblQues10 = new javax.swing.JLabel();
        cmbQues10 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblQues11 = new javax.swing.JLabel();
        lblQues12 = new javax.swing.JLabel();
        lblQues13 = new javax.swing.JLabel();
        btnSaveResponse = new javax.swing.JButton();
        cmbQues11 = new javax.swing.JComboBox<>();
        cmbQues12 = new javax.swing.JComboBox<>();
        cmbQues13 = new javax.swing.JComboBox<>();
        txtQues14 = new javax.swing.JLabel();
        cmbQues14 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cmbQues15 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnView = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblTopic = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtStudentPost = new javax.swing.JTextField();
        btnPost = new javax.swing.JButton();
        lblComment = new javax.swing.JLabel();
        txtComment = new javax.swing.JTextField();
        btnRequestForumAccess = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtName.setPreferredSize(new java.awt.Dimension(120, 20));
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 160, -1));

        txtAge.setPreferredSize(new java.awt.Dimension(120, 20));
        jPanel1.add(txtAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 160, -1));

        lblName.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblName.setText("Full Name:");
        lblName.setPreferredSize(new java.awt.Dimension(100, 20));
        lblName.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 130, -1));

        lblAge.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblAge.setText("Age:");
        jPanel1.add(lblAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 90, 20));

        lblGender.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblGender.setText("Gender:");
        jPanel1.add(lblGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 70, 20));

        lblEthnicity.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblEthnicity.setText("Ethnicity:");
        jPanel1.add(lblEthnicity, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 70, 20));

        lblCountry.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblCountry.setText("Country of origin:");
        jPanel1.add(lblCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, -1, 20));

        cmbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmbGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 160, -1));

        cmbEthnicity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmbEthnicity, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 160, -1));
        jPanel1.add(txtCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, 160, -1));

        btnSave.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnSave.setText("Save");
        jPanel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 120, -1));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome, Husky! ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 760, -1));

        jLabel7.setText("IMAGE HERE!!");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 470, -1, -1));

        jTabbedPane1.addTab("Person Details", jPanel1);

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tell us a bit about yourself!");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 780, -1));

        lblQues1.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblQues1.setText("1. What emotion have you been experiencing most recently? ");
        jPanel2.add(lblQues1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 490, 20));

        lblQues2.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblQues2.setText("2. Any big changes in life?");
        jPanel2.add(lblQues2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 500, 20));

        lblQues3.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblQues3.setText("3. How well have you been sleeping lately? (rate on a scale of 1-5)");
        jPanel2.add(lblQues3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 500, 20));

        lblQues4.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblQues4.setText("4. Do you know what is bothering you?");
        jPanel2.add(lblQues4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 500, 20));

        lblQues5.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblQues5.setText("5. How much emotional support do you feel you have?  (rate on a scale of 1-5)");
        jPanel2.add(lblQues5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 520, 20));

        btnSubmitResponse.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnSubmitResponse.setText("Submit Response");
        jPanel2.add(btnSubmitResponse, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 460, 150, -1));

        cmbQues1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Joy", "Anger", "Sadness", "Anxiety", "Fear", "Mixed Emotion", " " }));
        cmbQues1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbQues1ActionPerformed(evt);
            }
        });
        jPanel2.add(cmbQues1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 60, 150, -1));

        cmbQues2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));
        jPanel2.add(cmbQues2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 100, 150, -1));

        cmbQues3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", " " }));
        jPanel2.add(cmbQues3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, 150, -1));

        cmbQues4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No", "Umm...I think so" }));
        jPanel2.add(cmbQues4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 180, 150, -1));

        cmbQues5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        jPanel2.add(cmbQues5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 220, 150, -1));

        lblQues6.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblQues6.setText("6. Do you feel you're having trouble fitting in?");
        jPanel2.add(lblQues6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 520, 20));

        cmbQues6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No", "A little bit..." }));
        jPanel2.add(cmbQues6, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 260, 150, -1));

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel9.setText("7. Are you having trouble getting by on your own in everyday life?");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 520, 20));

        cmbQues7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));
        jPanel2.add(cmbQues7, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 300, 150, -1));

        lblQues8.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblQues8.setText("8. Do you feel like something bad is about to happen?");
        jPanel2.add(lblQues8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 520, 20));

        cmbQues8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));
        jPanel2.add(cmbQues8, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 340, 150, -1));

        lblQues9.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblQues9.setText("9. Do you feel you're too self-consious to show positive feelings? (rate on a scale of 1-5)");
        jPanel2.add(lblQues9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 590, 20));

        cmbQues9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        jPanel2.add(cmbQues9, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 380, 150, -1));

        lblQues10.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblQues10.setText("10. Do you think you are fundamentally different from other people? (rate on a scale of 1-5)");
        jPanel2.add(lblQues10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 620, 20));

        cmbQues10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        jPanel2.add(cmbQues10, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 420, 150, -1));

        jLabel8.setText("IMAGE HERE!");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 600, -1, -1));

        jTabbedPane1.addTab("Questionnaire ", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Breathe in and out, notice the emotions that are inside of you. How are you feeling, really?");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 30));

        lblQues11.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblQues11.setText("1. In the past week, how often have you felt: joy, anxiety, sadness, anger, etc.?");
        jPanel3.add(lblQues11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 550, 20));

        lblQues12.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblQues12.setText("2. What colour is the best fit for how you feel today? ");
        jPanel3.add(lblQues12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 420, 20));

        lblQues13.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblQues13.setText("3. Have you been feeling physically ill in the past week?");
        jPanel3.add(lblQues13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 420, 20));

        btnSaveResponse.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnSaveResponse.setText("Save Response");
        btnSaveResponse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveResponseActionPerformed(evt);
            }
        });
        jPanel3.add(btnSaveResponse, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 260, 130, -1));

        cmbQues11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Not often", "Very often", "All the time!" }));
        jPanel3.add(cmbQues11, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, 210, -1));

        cmbQues12.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Red", "Blue", "Green", "Yellow", "Pink" }));
        jPanel3.add(cmbQues12, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, 210, -1));

        cmbQues13.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));
        jPanel3.add(cmbQues13, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, 210, -1));

        txtQues14.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        txtQues14.setText("4. How many hours of sleep did you get this week? ");
        jPanel3.add(txtQues14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 520, 20));

        cmbQues14.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "< 20 hours", "< 35 hours", "< 50 hours", "> 55 hours" }));
        jPanel3.add(cmbQues14, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, 210, -1));

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel10.setText("5. Do you feel lethargic?");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 530, -1));

        cmbQues15.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No", "All the time...." }));
        jPanel3.add(cmbQues15, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, 210, -1));

        jLabel11.setText("IMAGE HERE!");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 470, -1, -1));

        jTabbedPane1.addTab("How are you feeling today?", jPanel3);

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Welcome to the Connect iN.U Forum!");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 830, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Date", "Post"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, 370, 110));

        btnView.setText("View");
        jPanel4.add(btnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 250, 100, -1));

        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 44, 410, 590));

        jLabel6.setText("IMAGE HERE!");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(509, 60, 240, 50));

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel12.setText("Add your own post here!");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, -1, 20));

        lblTopic.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblTopic.setText("Post:");
        jPanel4.add(lblTopic, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 330, 70, 20));

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 0, 102));
        jLabel14.setText("No access? Request access below!");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 480, 260, 20));
        jPanel4.add(txtStudentPost, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 330, 270, 60));

        btnPost.setText("Post");
        jPanel4.add(btnPost, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 400, 100, -1));

        lblComment.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblComment.setText("Comment:");
        jPanel4.add(lblComment, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 510, 70, 20));
        jPanel4.add(txtComment, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 510, 270, 60));

        btnRequestForumAccess.setText("Request Access");
        jPanel4.add(btnRequestForumAccess, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 580, -1, -1));

        jTabbedPane1.addTab("Connect iN.U", jPanel4);
        jTabbedPane1.addTab("MindFit", jPanel5);
        jTabbedPane1.addTab("Pet Therapy", jPanel6);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 730));
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnSaveResponseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveResponseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveResponseActionPerformed

    private void cmbQues1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbQues1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbQues1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPost;
    private javax.swing.JButton btnRequestForumAccess;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSaveResponse;
    private javax.swing.JButton btnSubmitResponse;
    private javax.swing.JButton btnView;
    private javax.swing.JComboBox<String> cmbEthnicity;
    private javax.swing.JComboBox<String> cmbGender;
    private javax.swing.JComboBox<String> cmbQues1;
    private javax.swing.JComboBox<String> cmbQues10;
    private javax.swing.JComboBox<String> cmbQues11;
    private javax.swing.JComboBox<String> cmbQues12;
    private javax.swing.JComboBox<String> cmbQues13;
    private javax.swing.JComboBox<String> cmbQues14;
    private javax.swing.JComboBox<String> cmbQues15;
    private javax.swing.JComboBox<String> cmbQues2;
    private javax.swing.JComboBox<String> cmbQues3;
    private javax.swing.JComboBox<String> cmbQues4;
    private javax.swing.JComboBox<String> cmbQues5;
    private javax.swing.JComboBox<String> cmbQues6;
    private javax.swing.JComboBox<String> cmbQues7;
    private javax.swing.JComboBox<String> cmbQues8;
    private javax.swing.JComboBox<String> cmbQues9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblComment;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblEthnicity;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblQues1;
    private javax.swing.JLabel lblQues10;
    private javax.swing.JLabel lblQues11;
    private javax.swing.JLabel lblQues12;
    private javax.swing.JLabel lblQues13;
    private javax.swing.JLabel lblQues2;
    private javax.swing.JLabel lblQues3;
    private javax.swing.JLabel lblQues4;
    private javax.swing.JLabel lblQues5;
    private javax.swing.JLabel lblQues6;
    private javax.swing.JLabel lblQues8;
    private javax.swing.JLabel lblQues9;
    private javax.swing.JLabel lblTopic;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtComment;
    private javax.swing.JTextField txtCountry;
    private javax.swing.JTextField txtName;
    private javax.swing.JLabel txtQues14;
    private javax.swing.JTextField txtStudentPost;
    // End of variables declaration//GEN-END:variables
}
