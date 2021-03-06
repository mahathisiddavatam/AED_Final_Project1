/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package userinterface.TherapistRole;

import Business.Clinic.Therapist;
import Business.Clinic.TherapistDirectory;
import Business.EcoSystem;
import Business.University.Student;
import Business.University.StudentDirectory;

import Business.UserAccount.UserAccount;
import Business.WorkQueue.Therapy;
import Business.WorkQueue.TherapyQueue;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.MainJFrame;

/**
 *
 * @author raunak
 */
public class TherapistAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;

    private UserAccount userAccount;
    private EcoSystem system;
    public String therapistid = MainJFrame.txtUsernameMain.getText();
    public Therapist therapist;
    public TherapistDirectory therapistdirectory;
    public StudentDirectory studentdirectory; 
    public TherapyQueue therapyqueue ;
    
    /**
     * Creates new form DoctorWorkAreaJPanel
     */
    public TherapistAreaJPanel(JPanel userProcessContainer, UserAccount account, EcoSystem system) {
        initComponents();
        
         
        
        this.userProcessContainer = userProcessContainer;
      
        this.userAccount = account;
        this.system = system;
        //valueLabel.setText(enterprise.getName());
        populatePatientTable();
        setLabel();
        populateSessionTable();
        populateDailyTable();
        this.therapist = system.getClinicdirectory().getTherapistdir().RetrieveTherapist(therapistid);
        this.therapistdirectory= system.getClinicdirectory().getTherapistdir();
        this.studentdirectory = system.getUniversitydirectory().getStudentdir();
        this.therapyqueue = system.getClinicdirectory().getTherapyqueue();
    }
    
    public void populateDailyTable(){
        
        int count=0;
        
        DefaultTableModel model = (DefaultTableModel) tblDaily.getModel();
        model.setRowCount(0);
        
        for(Student student: studentdirectory.getstudentlist()){
            
            if(student.getTherapistid()!=null){
            
            if(student.getTherapistid().equals(therapist.getId()) ){
                Object[] row = new Object[3];
                row[0]= student.getId();
                
                row[1]= student.getName();
                
                for(Therapy therapy: therapyqueue.getTherapylist()){
                    
                    if(therapy.getStudentid().equals(student.getId()) && therapy.getTerminate()==true){
                        
                        count++;
                    }
                }
                
                row[2]=count;
                model.insertRow(0, row);
                count=0;
                
                
            }
            }
        }
        
        
        
        
    }
    public void populateSessionTable(){
        
        if(therapyqueue==null){
            this.therapyqueue= system.getClinicdirectory().getTherapyqueue();
        }
        
        DefaultTableModel model = (DefaultTableModel) tblSessions.getModel();
        model.setRowCount(0);
        
        for(Therapy therapy: therapyqueue.getTherapylist()){
            
            
            
            if(therapy.getTerminate()==false && therapy.getTherapistid().equals(therapistid)){
                
                Object[] row = new Object[4];
                row[0]= therapy.getId();
                
                row[1]= studentdirectory.RetrieveStudent(therapy.getStudentid()).getName();
                row[2] = therapy.getDate();
                row[3] = therapy.getTime();
                
                model.insertRow(0, row);
                
            
            
                
                
            }
        }
        
        
    }
    
    public void populatePatientTable(){
        
        DefaultTableModel model = (DefaultTableModel) tblPatient.getModel();
        model.setRowCount(0);
        
        if(this.studentdirectory==null){
            
            this.studentdirectory = system.getUniversitydirectory().getStudentdir();
            System.out.print("I am in that null loop\n");
        }
        
        for(Student student:studentdirectory.getstudentlist()){
            
            System.out.print("In for loop hello\n");
            System.out.print("Boolean value is "+ student.getAssigned());
            System.out.print("Name value is "+ student.getName());
            boolean assign = student.getAssigned();
            
            if(assign==false){
                
                Object[] row = new Object[5];
                row[0]= student.getId();
                
                row[1]= student.getName();
                row[2] = student.getGender();
                row[3] = student.getEthnicity();
                row[4] = student.getOrigin();
                model.insertRow(0, row);
                
            
            
                
                
            }
            
            
            
            
        
        
            
            //To change body of generated methods, choose Tools | Templates.
    }
        
    }
    
    public void setLabel(){
        
        if(therapist==null){
            this.therapist = system.getClinicdirectory().getTherapistdir().RetrieveTherapist(therapistid);
        }
        
        
        
        lblViewTherapistName.setText(therapist.getName());
        
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
        jPanel3 = new javax.swing.JPanel();
        txtDegrees = new javax.swing.JTextField();
        txtExpNo = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblPhoneNo = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        txtSpecialities = new javax.swing.JTextField();
        txtMessage = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblViewTherapistName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPatient = new javax.swing.JTable();
        lblQues1 = new javax.swing.JLabel();
        lblQues2 = new javax.swing.JLabel();
        lblQues3 = new javax.swing.JLabel();
        lblQues4 = new javax.swing.JLabel();
        lblQues5 = new javax.swing.JLabel();
        lblQues6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblQues8 = new javax.swing.JLabel();
        lblQues9 = new javax.swing.JLabel();
        lblQues10 = new javax.swing.JLabel();
        btnViewStudent = new javax.swing.JButton();
        btnAssign = new javax.swing.JButton();
        lblAns1 = new javax.swing.JLabel();
        lblAns2 = new javax.swing.JLabel();
        lblAns3 = new javax.swing.JLabel();
        lblAns4 = new javax.swing.JLabel();
        lblAns5 = new javax.swing.JLabel();
        lblAns6 = new javax.swing.JLabel();
        lblAns7 = new javax.swing.JLabel();
        lblAns8 = new javax.swing.JLabel();
        lblAns9 = new javax.swing.JLabel();
        lblAns10 = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSessions = new javax.swing.JTable();
        btnTerminate = new javax.swing.JButton();
        btnTerminate1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lblQues11 = new javax.swing.JLabel();
        lblQues12 = new javax.swing.JLabel();
        lblQues13 = new javax.swing.JLabel();
        txtQues14 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtQues1 = new javax.swing.JLabel();
        txtQues2 = new javax.swing.JLabel();
        txtQues3 = new javax.swing.JLabel();
        txtQues4 = new javax.swing.JLabel();
        txtQues5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDaily = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        btnViewDailyCheck = new javax.swing.JButton();
        btnRefreshDailyCheck = new javax.swing.JButton();

        jTabbedPane1.setBackground(new java.awt.Color(204, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));

        txtDegrees.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtDegrees.setPreferredSize(new java.awt.Dimension(120, 20));
        txtDegrees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDegreesActionPerformed(evt);
            }
        });

        txtExpNo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtExpNo.setPreferredSize(new java.awt.Dimension(120, 20));

        lblName.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblName.setText("Degrees Acquired:");
        lblName.setPreferredSize(new java.awt.Dimension(100, 20));
        lblName.setVerifyInputWhenFocusTarget(false);

        lblAddress.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblAddress.setText("Number of years of Experience:");

        lblPhoneNo.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblPhoneNo.setText("Specialties in:");

        lblEmail.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblEmail.setText("Message for the counselees:");

        btnSave.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        txtSpecialities.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtSpecialities.setPreferredSize(new java.awt.Dimension(120, 20));

        txtMessage.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtMessage.setPreferredSize(new java.awt.Dimension(120, 20));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Hello! Please enter your details if you haven't already or if you wish to update them");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 941, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPhoneNo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDegrees, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSpecialities, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtExpNo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(62, 62, 62)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDegrees, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtExpNo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSpecialities, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(295, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtDegrees, txtExpNo, txtMessage, txtSpecialities});

        jTabbedPane1.addTab("Therapist Details", jPanel3);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("Welcome!");

        lblViewTherapistName.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblViewTherapistName.setForeground(new java.awt.Color(153, 0, 0));
        lblViewTherapistName.setText("<therapistUserName>");

        tblPatient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Gender", "Ethnicity", "Country"
            }
        ));
        jScrollPane1.setViewportView(tblPatient);

        lblQues1.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblQues1.setText("1. What emotion have you been experiencing most recently? ");

        lblQues2.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblQues2.setText("2. Any big changes in life?");

        lblQues3.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblQues3.setText("3. How well have you been sleeping lately? (rate on a scale of 1-5)");

        lblQues4.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblQues4.setText("4. Do you know what is bothering you?");

        lblQues5.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblQues5.setText("5. How much emotional support do you feel you have?  (rate on a scale of 1-5)");

        lblQues6.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblQues6.setText("6. Do you feel you're having trouble fitting in?");

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel9.setText("7. Are you having trouble getting by on your own in everyday life?");

        lblQues8.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblQues8.setText("8. Do you feel like something bad is about to happen?");

        lblQues9.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblQues9.setText("9. Do you feel you're too self-consious to show positive feelings? (rate on a scale of 1-5)");

        lblQues10.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblQues10.setText("10. Do you think you are fundamentally different from other people? (rate on a scale of 1-5)");

        btnViewStudent.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnViewStudent.setText("View");
        btnViewStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewStudentActionPerformed(evt);
            }
        });

        btnAssign.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnAssign.setText("Assign to me");
        btnAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignActionPerformed(evt);
            }
        });

        lblAns1.setText("<Ans>");

        lblAns2.setText("<Ans>");

        lblAns3.setText("<Ans>");

        lblAns4.setText("<Ans>");

        lblAns5.setText("<Ans>");

        lblAns6.setText("<Ans>");

        lblAns7.setText("<Ans>");

        lblAns8.setText("<Ans>");

        lblAns9.setText("<Ans>");

        lblAns10.setText("<Ans>");

        btnRefresh.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblViewTherapistName)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnAssign))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(lblQues1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblQues2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblQues3, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblQues4, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblQues5, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                                                .addComponent(lblQues6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(lblQues8, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(122, 122, 122)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblAns8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblAns5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblAns1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lblAns2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lblAns3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lblAns4, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lblAns6, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lblAns7, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 28, Short.MAX_VALUE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblQues10, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
                                            .addComponent(lblQues9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblAns9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblAns10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnViewStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(62, 62, 62))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblViewTherapistName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewStudent)
                    .addComponent(btnRefresh))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQues1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAns1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQues2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAns2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQues3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAns3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQues4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAns4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQues5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAns5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQues6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAns6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAns7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQues8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAns8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQues9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAns9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQues10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAns10))
                .addGap(18, 18, 18)
                .addComponent(btnAssign)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("View Patient", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Active Session Details");

        tblSessions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "SessionID", "Client name", "Date", "Time"
            }
        ));
        jScrollPane2.setViewportView(tblSessions);

        btnTerminate.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnTerminate.setText("Terminate Session");
        btnTerminate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminateActionPerformed(evt);
            }
        });

        btnTerminate1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnTerminate1.setText("Refresh Table");
        btnTerminate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminate1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 815, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnTerminate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                        .addComponent(btnTerminate1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(21, 21, 21)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTerminate1)
                .addGap(18, 18, 18)
                .addComponent(btnTerminate)
                .addGap(0, 359, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Active session", jPanel2);

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblQues11.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblQues11.setText("1. In the past week, how often have you felt: joy, anxiety, sadness, anger, etc.?");
        jPanel4.add(lblQues11, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 234, 550, 20));

        lblQues12.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblQues12.setText("2. What colour is the best fit for how you feel today? ");
        jPanel4.add(lblQues12, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 275, 420, 20));

        lblQues13.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblQues13.setText("3. Have you been feeling physically ill in the past week?");
        jPanel4.add(lblQues13, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 315, 420, 20));

        txtQues14.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        txtQues14.setText("4. How many hours of sleep did you get this week? ");
        jPanel4.add(txtQues14, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 355, 520, 20));

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel10.setText("5. Do you feel lethargic?");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 395, 530, -1));

        txtQues1.setText("<ans>");
        jPanel4.add(txtQues1, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 235, 146, 20));

        txtQues2.setText("<ans>");
        jPanel4.add(txtQues2, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 276, 146, 20));

        txtQues3.setText("<ans>");
        jPanel4.add(txtQues3, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 316, 146, 20));

        txtQues4.setText("<ans>");
        jPanel4.add(txtQues4, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 356, 146, 20));

        txtQues5.setText("<ans>");
        jPanel4.add(txtQues5, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 393, 146, 20));

        tblDaily.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Student ID", "Student Name", "Number of therapy sessions"
            }
        ));
        jScrollPane3.setViewportView(tblDaily);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 63, 846, 95));

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Daily wellness check for patients");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, 941, -1));

        btnViewDailyCheck.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnViewDailyCheck.setText("View");
        btnViewDailyCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDailyCheckActionPerformed(evt);
            }
        });
        jPanel4.add(btnViewDailyCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(789, 176, 100, -1));

        btnRefreshDailyCheck.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnRefreshDailyCheck.setText("Refresh");
        btnRefreshDailyCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshDailyCheckActionPerformed(evt);
            }
        });
        jPanel4.add(btnRefreshDailyCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 176, 96, -1));

        jTabbedPane1.addTab("View Daily check for patients", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignActionPerformed
        // TODO add your handling code here:
        
        
        DefaultTableModel modelOrder = (DefaultTableModel)tblPatient.getModel();
        int selectedIndex = tblPatient.getSelectedRow();
        if(selectedIndex==-1){
            
            JOptionPane.showMessageDialog(this, "Please Select a Patient!");
            return;
            
        }
        String id=null;
        
        if(selectedIndex!=-1){
            
             id = modelOrder.getValueAt(selectedIndex, 0).toString();
             //createdby = modelOrder.getValueAt(selectedIndex, 2).toString();
        }
       
        studentdirectory.RetrieveStudent(id).setAssigned(Boolean.TRUE);
        studentdirectory.RetrieveStudent(id).setTherapistid(therapistid);
        populatePatientTable();
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_btnAssignActionPerformed

    private void txtDegreesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDegreesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDegreesActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        therapist.setDegrees(txtDegrees.getText());
        therapist.setMessage(txtMessage.getText());
        therapist.setExperience(txtExpNo.getText());
        therapist.setSpecialities(txtSpecialities.getText());
        JOptionPane.showMessageDialog(this, "Saved!");
            
        
        
        
        
                
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnViewStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewStudentActionPerformed
        // TODO add your handling code here:
        
        
        
        DefaultTableModel modelOrder = (DefaultTableModel)tblPatient.getModel();
        int selectedIndex = tblPatient.getSelectedRow();
        if(selectedIndex==-1){
            
            JOptionPane.showMessageDialog(this, "Please Select a Patient!");
            return;
            
        }
        String id=null;
        
        if(selectedIndex!=-1){
            
             id = modelOrder.getValueAt(selectedIndex, 0).toString();
             //createdby = modelOrder.getValueAt(selectedIndex, 2).toString();
        }
        Student student = system.getUniversitydirectory().getStudentdir().RetrieveStudent(id);
        lblAns1.setText(student.getQues1());
        lblAns2.setText(student.getQues2());
        lblAns3.setText(student.getQues3());
        lblAns4.setText(student.getQues4());
        lblAns5.setText(student.getQues5());
        lblAns6.setText(student.getQues6());
        lblAns7.setText(student.getQues7());
        lblAns8.setText(student.getQues8());
        lblAns9.setText(student.getQues10());
        lblAns10.setText(student.getQues10());
        
    }//GEN-LAST:event_btnViewStudentActionPerformed

    private void btnTerminateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminateActionPerformed
        // TODO add your handling code here:
        
         System.out.print("I am in button\n");
        DefaultTableModel modelOrder = (DefaultTableModel)tblSessions.getModel();
        int selectedIndex = tblSessions.getSelectedRow();
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
        
        
        Therapy therapy = therapyqueue.retrieveTherapy(intid);
        System.out.print(therapy.getTerminate() +" this is terminate\n");
        therapy.setTerminate(Boolean.TRUE);
        system.getUniversitydirectory().getStudentdir().RetrieveStudent(therapy.getStudentid()).setAppointment(Boolean.FALSE);
        JOptionPane.showMessageDialog(this, "Terminated!");
        
        
        
        
        
    }//GEN-LAST:event_btnTerminateActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        

        populatePatientTable();
        
        
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnTerminate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminate1ActionPerformed
        // TODO add your handling code here:
        populateSessionTable();
        
        
        
       
        
        
        
        
        
    }//GEN-LAST:event_btnTerminate1ActionPerformed

    private void btnViewDailyCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDailyCheckActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel modelOrder = (DefaultTableModel)tblDaily.getModel();
        int selectedIndex = tblDaily.getSelectedRow();
        if(selectedIndex==-1){
            
            JOptionPane.showMessageDialog(this, "Please Select a Patient!");
            return;
            
        }
        String id=null;
        
        if(selectedIndex!=-1){
            
             id = modelOrder.getValueAt(selectedIndex, 0).toString();
             //createdby = modelOrder.getValueAt(selectedIndex, 2).toString();
        }
        
        Student student = studentdirectory.RetrieveStudent(id);
        if(student.getQues11()==null){
            
            JOptionPane.showMessageDialog(this, "Student has not taken the wellness check!");
            return;
            
            
        }
        txtQues1.setText(student.getQues11());
        txtQues2.setText(student.getQues12());
        txtQues3.setText(student.getQues13());
        txtQues4.setText(student.getQues14());
        txtQues5.setText(student.getQues15());
        
        
        
    }//GEN-LAST:event_btnViewDailyCheckActionPerformed

    private void btnRefreshDailyCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshDailyCheckActionPerformed
        // TODO add your handling code here:
        populateDailyTable();
    }//GEN-LAST:event_btnRefreshDailyCheckActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssign;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRefreshDailyCheck;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnTerminate;
    private javax.swing.JButton btnTerminate1;
    private javax.swing.JButton btnViewDailyCheck;
    private javax.swing.JButton btnViewStudent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAns1;
    private javax.swing.JLabel lblAns10;
    private javax.swing.JLabel lblAns2;
    private javax.swing.JLabel lblAns3;
    private javax.swing.JLabel lblAns4;
    private javax.swing.JLabel lblAns5;
    private javax.swing.JLabel lblAns6;
    private javax.swing.JLabel lblAns7;
    private javax.swing.JLabel lblAns8;
    private javax.swing.JLabel lblAns9;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhoneNo;
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
    private javax.swing.JLabel lblViewTherapistName;
    private javax.swing.JTable tblDaily;
    private javax.swing.JTable tblPatient;
    private javax.swing.JTable tblSessions;
    private javax.swing.JTextField txtDegrees;
    private javax.swing.JTextField txtExpNo;
    private javax.swing.JTextField txtMessage;
    private javax.swing.JLabel txtQues1;
    private javax.swing.JLabel txtQues14;
    private javax.swing.JLabel txtQues2;
    private javax.swing.JLabel txtQues3;
    private javax.swing.JLabel txtQues4;
    private javax.swing.JLabel txtQues5;
    private javax.swing.JTextField txtSpecialities;
    // End of variables declaration//GEN-END:variables
}
