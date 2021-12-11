/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.MindfitnessStaffRole;

import Business.EcoSystem;
import Business.MindFitness.NutrionistDirectory;
import Business.MindFitness.Nutritionist;
import Business.MindFitness.YogaInstructor;
import Business.MindFitness.YogaInstructorDirectory;
import Business.University.Student;
import Business.University.StudentDirectory;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.NutritionRequest;
import Business.WorkQueue.NutritionRequestQueue;
import Business.WorkQueue.NutritionistAppointment;
import Business.WorkQueue.NutritionistAppointmentQueue;
import Business.WorkQueue.YogaAppointment;
import Business.WorkQueue.YogaAppointmentQueue;
import Business.WorkQueue.YogaRequest;
import Business.WorkQueue.YogaRequestQueue;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Varakumar
 */
public class MindFitnessStaffWorkArea extends javax.swing.JPanel {
    private JPanel UserProcessContainer;
    private UserAccount account;
    private EcoSystem system;
    YogaAppointmentQueue yogaqueue;
    NutritionistAppointmentQueue nutriqueue;
    NutrionistDirectory nutridir;
    YogaInstructorDirectory yogadir;
    YogaRequestQueue yogarequestqueue;
    NutritionRequestQueue nutrirequestqueue;
    StudentDirectory studentdirectory;
    int pay=0;
    

    /**
     * Creates new form MindFitnessStaffWorkArea
     */
    public MindFitnessStaffWorkArea(JPanel UserProcessContainer, UserAccount account, EcoSystem system) {
        
        this.UserProcessContainer=UserProcessContainer;
        this.account=account;
        this.system=system;
        initComponents();
        this.nutridir = system.getMindfitnessdir().getNutridir();
        this.nutriqueue = system.getMindfitnessdir().getNutriqueue();
        this.yogaqueue = system.getMindfitnessdir().getYogaqueue();
        this.yogadir = system.getMindfitnessdir().getYogadir();
        this.yogarequestqueue = system.getMindfitnessdir().getYogarequestqueue();
        this.nutrirequestqueue = system.getMindfitnessdir().getNutrirequestqueue();
        this.studentdirectory = system.getUniversitydirectory().getStudentdir();
    }
    
    public void populateInstructorPaymentTable(YogaAppointment therapy, DefaultTableModel model){
        
        Object[] row = new Object[5];
        row[0]= therapy.getId();
        row[1]=therapy.getYogaid();
        row[2]=therapy.getStudentid();
        row[3]=therapy.getDate();
        if(((therapy.getTerminate()==false))) {
            
            row[4]="Session to be completed";
            
            
            
        }
        if(therapy.getPayment()==false && therapy.getTerminate()==true){
            
            pay = pay+350;
            row[4]="$350 to be paid";
            
        }
        if(therapy.getPayment()==true){
            
            
            row[4]="Payment completed";
            
        }
        
        
        model.insertRow(0, row);
        txtTotal.setText(String.valueOf(pay));
        
        
    }
    
    public void populateNutritionistPaymentTable(NutritionistAppointment therapy, DefaultTableModel model){
        
        Object[] row = new Object[5];
        row[0]= therapy.getId();
        row[1]=therapy.getNutritionistid();
        row[2]=therapy.getStudentid();
        row[3]=therapy.getDate();
        if(((therapy.getTerminate()==false))) {
            
            row[4]="Session to be completed";
            
            
            
        }
        if(therapy.getPayment()==false && therapy.getTerminate()==true){
            
            pay = pay+350;
            row[4]="$350 to be paid";
            
        }
        if(therapy.getPayment()==true){
            
            
            row[4]="Payment completed";
            
        }
        
        
        model.insertRow(0, row);
        txtTotal1.setText(String.valueOf(pay));
        
        
    }
    
    
    
    public void populateYogaInstructorTable(){
        
        DefaultTableModel model = (DefaultTableModel) tblInstructor.getModel();
        model.setRowCount(0);
        
        for(YogaInstructor nutri: yogadir.getyogainstlist()){
            
            Object[] row = new Object[2];
                 row[0]= nutri.getId();
                 
                 
                 
                
                
                row[1] = nutri.getName();
                
                model.insertRow(0, row);
        }
        
        
    }
    
    public void populateNutritionistTable(){
        
        DefaultTableModel model = (DefaultTableModel) tblNutritionist.getModel();
        model.setRowCount(0);
        
        for(Nutritionist nutri: nutridir.getnutritionistlist()){
            
            Object[] row = new Object[2];
                 row[0]= nutri.getId();
                 
                 
                 
                
                
                row[1] = nutri.getName();
                
                model.insertRow(0, row);
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
        lblNutritionist = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNutritionist = new javax.swing.JTable();
        btnView = new javax.swing.JButton();
        btnManagePayNutri = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblSelectDate = new javax.swing.JLabel();
        calendarSession = new com.toedter.calendar.JCalendar();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblStudentList = new javax.swing.JTable();
        btnConfirm = new javax.swing.JButton();
        txtDate = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblStudents = new javax.swing.JLabel();
        cbcSlot = new javax.swing.JComboBox<>();
        btnConfirm2 = new javax.swing.JButton();
        btnView2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lblNutritionist2 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblNutritionistPayment = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtTotal1 = new javax.swing.JTextField();
        btnPayment = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblWelcome1 = new javax.swing.JLabel();
        lblInstructors = new javax.swing.JLabel();
        btnManage = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblInstructor = new javax.swing.JTable();
        btnView1 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        lblStudents1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblStudentList1 = new javax.swing.JTable();
        jSeparator4 = new javax.swing.JSeparator();
        lblSelectDate1 = new javax.swing.JLabel();
        lblSelectDateTime = new javax.swing.JLabel();
        txtDateTime = new javax.swing.JTextField();
        btnConfirm1 = new javax.swing.JButton();
        cbcSlot1 = new javax.swing.JComboBox<>();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        btnConfirm3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblInstructors1 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblInstructorPayment = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnPay = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        lblWelcome.setBackground(new java.awt.Color(255, 255, 0));
        lblWelcome.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblWelcome.setText("WELCOME");

        lblNutritionist.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNutritionist.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNutritionist.setText("NUTRITIONISTS");
        lblNutritionist.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblNutritionist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "NUTRITIONIST ID", "NAME"
            }
        ));
        jScrollPane1.setViewportView(tblNutritionist);

        btnView.setText("CLICK TO VIEW APPOINTMENTS/REQUESTS");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        btnManagePayNutri.setText("MANAGE PAYMENTS");
        btnManagePayNutri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManagePayNutriActionPerformed(evt);
            }
        });

        lblSelectDate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSelectDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSelectDate.setText("SELECT DATE TO ASSIGN");
        lblSelectDate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblStudentList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "NAME", "APPOINTMENT DATE", "APPOINTMENT TIME", "APPOINTMENT STATUS"
            }
        ));
        jScrollPane3.setViewportView(tblStudentList);

        btnConfirm.setText("CONFIRM APPOINTMENT");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        jLabel3.setText("SELECTED TIME AND DATE");

        lblStudents.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblStudents.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStudents.setText("STUDENTS ");
        lblStudents.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbcSlot.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Slot", "8:00 ", "9:00 ", "10:00 ", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00" }));

        btnConfirm2.setText("REJECT APPOINTMENT REQUEST");
        btnConfirm2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirm2ActionPerformed(evt);
            }
        });

        btnView2.setText("REFRESH");
        btnView2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnView2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(593, 593, 593)
                .addComponent(jSeparator2))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(223, 223, 223)
                                .addComponent(lblNutritionist, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(btnManagePayNutri))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(250, 250, 250)
                                .addComponent(btnView)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnView2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(225, 225, 225)
                                .addComponent(lblStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(58, 58, 58)
                                        .addComponent(calendarSession, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(cbcSlot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(133, 133, 133)
                                        .addComponent(lblSelectDate, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(164, 164, 164)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnConfirm2)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                        .addComponent(txtDate)
                                        .addComponent(jLabel3)))))
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(246, 246, 246)
                .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblNutritionist, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(btnManagePayNutri)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnView)
                    .addComponent(btnView2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnConfirm)
                        .addGap(99, 99, 99))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSelectDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnConfirm2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(calendarSession, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(cbcSlot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(31, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("NUTRITIONIST", jPanel1);

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        lblNutritionist2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNutritionist2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNutritionist2.setText("MANAGE PAYMENTS");
        lblNutritionist2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblNutritionistPayment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "APPOINTMENT ID", "NUTRITIONIST ID", "STUDENT ID", "DATE", "STATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(tblNutritionistPayment);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("TOTAL");

        btnPayment.setText("DO PAYMENT");
        btnPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaymentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(lblNutritionist2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnPayment))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblNutritionist2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPayment))
                .addContainerGap(407, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("MANAGE PAYMENTS - NUTRITIONIST", jPanel4);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        lblWelcome1.setBackground(new java.awt.Color(255, 255, 0));
        lblWelcome1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblWelcome1.setText("WELCOME");

        lblInstructors.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblInstructors.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInstructors.setText("YOGA INSTRUCTORS");
        lblInstructors.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnManage.setText("MANAGE PAYMENTS");
        btnManage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageActionPerformed(evt);
            }
        });

        tblInstructor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "INSTRUCTOR ID", "NAME"
            }
        ));
        jScrollPane4.setViewportView(tblInstructor);

        btnView1.setText("CLICK TO VIEW REQUESTS/APPOINTMENTS");
        btnView1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnView1ActionPerformed(evt);
            }
        });

        lblStudents1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblStudents1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStudents1.setText("STUDENTS ");
        lblStudents1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblStudentList1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "NAME", "APPOINTMENT DATE", "APPOINTMENT TIME", "APPOINTMENT STATUS"
            }
        ));
        jScrollPane5.setViewportView(tblStudentList1);

        lblSelectDate1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSelectDate1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSelectDate1.setText("SELECT DATE TO ASSIGN");
        lblSelectDate1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblSelectDateTime.setText("SELECTED DATA AND TIME");

        txtDateTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateTimeActionPerformed(evt);
            }
        });

        btnConfirm1.setText("CONFIRM APPOINTMENT");
        btnConfirm1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirm1ActionPerformed(evt);
            }
        });

        cbcSlot1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Slot", "8:00 ", "9:00 ", "10:00 ", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00" }));

        jCalendar1.setAutoscrolls(true);

        btnConfirm3.setText("REFRESH");
        btnConfirm3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirm3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator3))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(lblWelcome1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(lblInstructors, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnManage))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(btnView1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(lblStudents1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(cbcSlot1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSelectDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnConfirm1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDateTime, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jSeparator4)
                                .addGap(357, 357, 357))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(lblSelectDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(253, 253, 253)))
                        .addComponent(btnConfirm3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(57, 57, 57)))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblWelcome1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInstructors, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnManage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnView1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblStudents1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSelectDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblSelectDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbcSlot1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnConfirm1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jCalendar1, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnConfirm3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("YOGA INSTRUCTOR", jPanel2);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        lblInstructors1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblInstructors1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInstructors1.setText("MANAGE PAYMENTS");
        lblInstructors1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblInstructorPayment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "APPOINTMENT ID", "INSTRUCTOR ID", "STUDENT ID", "DATE", "STATUS"
            }
        ));
        jScrollPane7.setViewportView(tblInstructorPayment);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("TOTAL");

        btnPay.setText("DO PAYMENT");
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(lblInstructors1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnPay))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInstructors1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPay))
                .addContainerGap(392, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("MANAGE PAYMENTS - INSTRUCTORS", jPanel3);

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

    private void btnManagePayNutriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManagePayNutriActionPerformed
        // TODO add your handling code here:
        pay=0;
        
        DefaultTableModel modelOrder = (DefaultTableModel)tblNutritionist.getModel();
         DefaultTableModel modelStudent = (DefaultTableModel)tblStudentList.getModel();
         int selectedIndex = tblNutritionist.getSelectedRow();
         if(selectedIndex==-1){
            
            JOptionPane.showMessageDialog(this, "Please Select a Nutritionist!");
            return;
            
        }
         String therapistid=null;
         if(selectedIndex!=-1){
            
             therapistid = modelOrder.getValueAt(selectedIndex, 0).toString();
        }
         
        int selectedIndex1 = tblStudentList.getSelectedRow();
        if(selectedIndex1==-1){
            
            JOptionPane.showMessageDialog(this, "Please Select a Student!");
            return;
            
        }
        
        
        DefaultTableModel model = (DefaultTableModel) tblNutritionistPayment.getModel();
        model.setRowCount(0);
        
        String studentid = null;
        if(selectedIndex1!=-1){
            
             studentid = modelStudent.getValueAt(selectedIndex1, 1).toString();
        }
        
        for(NutritionistAppointment therapy: nutriqueue.getNutritionistAppointmentlist()){
            
            if(therapy.getNutritionistid().equals(therapistid) && therapy.getStudentid().equals(studentid)){
                
                populateNutritionistPaymentTable(therapy,model);
            }
        }
    }//GEN-LAST:event_btnManagePayNutriActionPerformed

    private void btnManageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageActionPerformed
        // TODO add your handling code here:
        
         pay=0;
        
        DefaultTableModel modelOrder = (DefaultTableModel)tblInstructor.getModel();
         DefaultTableModel modelStudent = (DefaultTableModel)tblStudentList1.getModel();
         int selectedIndex = tblInstructor.getSelectedRow();
         if(selectedIndex==-1){
            
            JOptionPane.showMessageDialog(this, "Please Select an Instructor!");
            return;
            
        }
         String therapistid=null;
         if(selectedIndex!=-1){
            
             therapistid = modelOrder.getValueAt(selectedIndex, 0).toString();
        }
         
        int selectedIndex1 = tblStudentList1.getSelectedRow();
        if(selectedIndex1==-1){
            
            JOptionPane.showMessageDialog(this, "Please Select a Student!");
            return;
            
        }
        
        
        DefaultTableModel model = (DefaultTableModel) tblInstructorPayment.getModel();
        model.setRowCount(0);
        
        String studentid = null;
        if(selectedIndex1!=-1){
            
             studentid = modelStudent.getValueAt(selectedIndex1, 1).toString();
        }
        
        for(YogaAppointment therapy: yogaqueue.getYogaAppointmentlist()){
            
            if(therapy.getYogaid().equals(therapistid) && therapy.getStudentid().equals(studentid)){
                
                populateInstructorPaymentTable(therapy,model);
            }
        }
    }//GEN-LAST:event_btnManageActionPerformed

    private void txtDateTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateTimeActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel modelOrder = (DefaultTableModel)tblNutritionist.getModel();
        int selectedIndex = tblNutritionist.getSelectedRow();
        
        DefaultTableModel model = (DefaultTableModel)tblStudentList.getModel();
        model.setRowCount(0);
        if(selectedIndex==-1){
            
            JOptionPane.showMessageDialog(this, "Please Select a Nutritionist!");
            return;
            
        }
        String therapistid = null;
        
        if(selectedIndex!=-1){
            
             therapistid = modelOrder.getValueAt(selectedIndex, 0).toString();
        }
        
        for(NutritionRequest req: nutrirequestqueue.getNutritionRequestlist()){
            
            if(!(req.isAccept()) && !(req.isReject())){
                
                Student student = studentdirectory.RetrieveStudent(req.getStudentid());
                
                Object[] row = new Object[5];
                row[0]= req.getId();
                row[1]= student.getId();
                row[4] = "Status to be Updated";
                row[2]="To be Updated";
                row[3] ="To be Updated";
                model.insertRow(0, row);
                
                
            
           
                
            }
            
            if(req.isAccept()){
                
                Student student = studentdirectory.RetrieveStudent(req.getStudentid());
                
                Object[] row = new Object[5];
                row[0]= req.getId();
                row[1]= student.getId();
                
                NutritionistAppointment app = nutriqueue.retrieveNutritionistAppointment(req.getId());
                if(app==null){
                row[4] = "Session to be completed";
                row[2]="To be Updated";
                row[3] ="To be Updated";
                model.insertRow(0, row);
                
                }
                else{
                    
                    if(app.getTerminate()==true){
                        row[4] = "Session Completed";
                        row[2]=app.getDate();
                        row[3] =app.getTime();
                        model.insertRow(0, row);
                        
                    }
                    
                    else{
                        
                        row[4] = "Session to be Completed";
                        row[2]=app.getDate();
                        row[3] =app.getTime();
                        model.insertRow(0, row);
                       
                        
                        
                        
                    }
                    
                    
                    
                    
                    
                    
                    
                }
                    
                    
                }
            
            if(req.isReject()){
                
                Student student = studentdirectory.RetrieveStudent(req.getStudentid());
                
                Object[] row = new Object[5];
                row[0]= req.getId();
                row[1]= student.getId();
                
                row[4] = "Instructor not Available";
                row[2]= "Not Applicable";
                row[3] = "Not Applicable";
                model.insertRow(0, row);
                
                
            }
                
                
            
             
            
            
        }
        
        
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        // TODO add your handling code here:
        
        Calendar cal = calendarSession.getCalendar();
        
        Date date = cal.getTime();
        String strDate = DateFormat.getDateInstance().format(date);
        txtDate.setText(strDate);
        
        String slot = cbcSlot.getSelectedItem().toString();
        int selectedIndex = tblNutritionist.getSelectedRow();
        
        DefaultTableModel modelOrder = (DefaultTableModel)tblNutritionist.getModel();
        DefaultTableModel modelStudent = (DefaultTableModel)tblStudentList.getModel();
         if(selectedIndex==-1){
            
            JOptionPane.showMessageDialog(this, "Please Select a Nutritionist");
            return;
            
        }
         String therapistid=null;
         if(selectedIndex!=-1){
            
             therapistid = modelOrder.getValueAt(selectedIndex, 0).toString();
        }
        
        for(NutritionistAppointment therapy: nutriqueue.getNutritionistAppointmentlist()){
            
            if(therapy.getNutritionistid().equals(therapistid)){
                
            
            
            if(therapy.getDate().equals(strDate) && therapy.getTime().equals(slot)){
                
                JOptionPane.showMessageDialog(this, "Please pick another slot!");
                return;
                
                
            }
        }
        }
        
        int selectedIndex1 = tblStudentList.getSelectedRow();
        if(selectedIndex1==-1){
            
            JOptionPane.showMessageDialog(this, "Please Select a Student!");
            return;
            
        }
        
        
        
        
        String studentid = null;
        String reqid=null;
        if(selectedIndex1!=-1){
            
             studentid = modelStudent.getValueAt(selectedIndex1, 1).toString();
             reqid = modelStudent.getValueAt(selectedIndex1, 0).toString();
             
        }
        
        int appid = Integer.parseInt(reqid);
        
        
        
        NutritionistAppointment app = nutriqueue.addNutritionistAppointment();
        app.setId(appid);
        app.setDate(strDate);
        app.setTime(slot);
        app.setStudentid(studentid);
        app.setNutritionistid(therapistid);
        
        NutritionRequest nutri = nutrirequestqueue.retrieveNutritionRequest(appid);
        nutri.setAccept(true);
        
         JOptionPane.showMessageDialog(this, "Schedeuled!");
        
        
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnConfirm2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirm2ActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel modelOrder = (DefaultTableModel)tblNutritionist.getModel();
        DefaultTableModel modelStudent = (DefaultTableModel)tblStudentList.getModel();
        
        int selectedIndex = tblNutritionist.getSelectedRow();
         if(selectedIndex==-1){
            
            JOptionPane.showMessageDialog(this, "Please Select a Nutritionist");
            return;
            
        }
         String therapistid=null;
         if(selectedIndex!=-1){
            
             therapistid = modelOrder.getValueAt(selectedIndex, 0).toString();
        }
         
        int selectedIndex1 = tblStudentList.getSelectedRow();
        if(selectedIndex1==-1){
            
            JOptionPane.showMessageDialog(this, "Please Select a Student!");
            return;
            
        }
        
        
        
        
        String studentid = null;
        String reqid=null;
        if(selectedIndex1!=-1){
            
             studentid = modelStudent.getValueAt(selectedIndex1, 1).toString();
             reqid = modelStudent.getValueAt(selectedIndex1, 0).toString();
             
        }
        
        int req = Integer.parseInt(reqid);
        
        NutritionRequest nut = nutrirequestqueue.retrieveNutritionRequest(req);
        nut.setReject(true);
        
        JOptionPane.showMessageDialog(this, "Rejected!");
        
        
         
        
        
        
    }//GEN-LAST:event_btnConfirm2ActionPerformed

    private void btnView2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnView2ActionPerformed
        // TODO add your handling code here:
        populateNutritionistTable();
        
    }//GEN-LAST:event_btnView2ActionPerformed

    private void btnPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaymentActionPerformed
        // TODO add your handling code here:
        
        pay=0;
         DefaultTableModel modelOrder = (DefaultTableModel)tblNutritionistPayment.getModel();
         int selectedIndex = tblNutritionistPayment.getSelectedRow();
         int sessionid=0;
         if(selectedIndex==-1){
             
              JOptionPane.showMessageDialog(this, "Please Select a Row");
               return;
             
             
         }
         
                  if(selectedIndex!=-1){
            
             String sess = modelOrder.getValueAt(selectedIndex, 0).toString();
             sessionid = Integer.parseInt(sess);
        }
                  
        NutritionistAppointment therapy1 = nutriqueue.retrieveNutritionistAppointment(sessionid);
        therapy1.setPayment(true);
        
        
         
        
        
       
        
        
        
        
        
        
        JOptionPane.showMessageDialog(this, "Paid!");
        
        
    }//GEN-LAST:event_btnPaymentActionPerformed

    private void btnView1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnView1ActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel modelOrder = (DefaultTableModel)tblInstructor.getModel();
        int selectedIndex = tblInstructor.getSelectedRow();
        
        DefaultTableModel model = (DefaultTableModel)tblStudentList1.getModel();
        model.setRowCount(0);
        if(selectedIndex==-1){
            
            JOptionPane.showMessageDialog(this, "Please Select an Instructor!");
            return;
            
        }
        String therapistid = null;
        
        if(selectedIndex!=-1){
            
             therapistid = modelOrder.getValueAt(selectedIndex, 0).toString();
        }
        
        for(YogaRequest req: yogarequestqueue.getYogaRequestlist()){
            
            if(!(req.isAccept()) && !(req.isReject())){
                
                Student student = studentdirectory.RetrieveStudent(req.getStudentid());
                
                Object[] row = new Object[5];
                row[0]= req.getId();
                row[1]= student.getId();
                row[4] = "Status to be Updated";
                row[2]="To be Updated";
                row[3] ="To be Updated";
                model.insertRow(0, row);
                
                
            
           
                
            }
            
            if(req.isAccept()){
                
                Student student = studentdirectory.RetrieveStudent(req.getStudentid());
                
                Object[] row = new Object[5];
                row[0]= req.getId();
                row[1]= student.getId();
                
                YogaAppointment app = yogaqueue.retrieveYogaAppointment(req.getId());
                if(app==null){
                row[4] = "Session to be completed";
                row[2]="To be Updated";
                row[3] ="To be Updated";
                model.insertRow(0, row);
                
                }
                else{
                    
                    if(app.getTerminate()==true){
                        row[4] = "Session Completed";
                        row[2]=app.getDate();
                        row[3] =app.getTime();
                        model.insertRow(0, row);
                        
                    }
                    
                    else{
                        
                        row[4] = "Session to be Completed";
                        row[2]=app.getDate();
                        row[3] =app.getTime();
                        model.insertRow(0, row);
                       
                        
                        
                        
                    }
                    
                    
                    
                    
                    
                    
                    
                }
                    
                    
                }
            
            if(req.isReject()){
                
                Student student = studentdirectory.RetrieveStudent(req.getStudentid());
                
                Object[] row = new Object[5];
                row[0]= req.getId();
                row[1]= student.getId();
                
                row[4] = "Instructor not Available";
                row[2]= "Not Applicable";
                row[3] = "Not Applicable";
                model.insertRow(0, row);
                
                
            }
                
                
            
             
            
            
        }
        
        
        
    }//GEN-LAST:event_btnView1ActionPerformed

    private void btnConfirm1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirm1ActionPerformed
        // TODO add your handling code here:
        Calendar cal = jCalendar1.getCalendar();
        
        Date date = cal.getTime();
        String strDate = DateFormat.getDateInstance().format(date);
        txtDate.setText(strDate);
        
        String slot = cbcSlot1.getSelectedItem().toString();
        int selectedIndex = tblInstructor.getSelectedRow();
        
        DefaultTableModel modelOrder = (DefaultTableModel)tblInstructor.getModel();
        DefaultTableModel modelStudent = (DefaultTableModel)tblStudentList1.getModel();
         if(selectedIndex==-1){
            
            JOptionPane.showMessageDialog(this, "Please Select an Instructor");
            return;
            
        }
         String therapistid=null;
         if(selectedIndex!=-1){
            
             therapistid = modelOrder.getValueAt(selectedIndex, 0).toString();
        }
        
        for(YogaAppointment therapy: yogaqueue.getYogaAppointmentlist()){
            
            if(therapy.getYogaid().equals(therapistid)){
                
            
            
            if(therapy.getDate().equals(strDate) && therapy.getTime().equals(slot)){
                
                JOptionPane.showMessageDialog(this, "Please pick another slot!");
                return;
                
                
            }
        }
        }
        
        int selectedIndex1 = tblStudentList1.getSelectedRow();
        if(selectedIndex1==-1){
            
            JOptionPane.showMessageDialog(this, "Please Select a Student!");
            return;
            
        }
        
        
        
        
        String studentid = null;
        String reqid=null;
        if(selectedIndex1!=-1){
            
             studentid = modelStudent.getValueAt(selectedIndex1, 1).toString();
             reqid = modelStudent.getValueAt(selectedIndex1, 0).toString();
             
        }
        
        int appid = Integer.parseInt(reqid);
        
        
        
        YogaAppointment app = yogaqueue.addYogaAppointment();
        app.setId(appid);
        app.setDate(strDate);
        app.setTime(slot);
        app.setStudentid(studentid);
        app.setYogaid(therapistid);
        
        YogaRequest nutri = yogarequestqueue.retrieveYogaRequest(appid);
        nutri.setAccept(true);
        
         JOptionPane.showMessageDialog(this, "Schedeuled!");
    }//GEN-LAST:event_btnConfirm1ActionPerformed

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        // TODO add your handling code here:
        pay=0;
         DefaultTableModel modelOrder = (DefaultTableModel)tblStudentList1.getModel();
         int selectedIndex = tblInstructorPayment.getSelectedRow();
         int sessionid=0;
         if(selectedIndex==-1){
             
              JOptionPane.showMessageDialog(this, "Please Select a Row");
               return;
             
             
         }
         
                  if(selectedIndex!=-1){
            
             String sess = modelOrder.getValueAt(selectedIndex, 0).toString();
             sessionid = Integer.parseInt(sess);
        }
                  
        YogaAppointment therapy1 = yogaqueue.retrieveYogaAppointment(sessionid);
        therapy1.setPayment(true);
        
        
         
        
        
       
        
        
        
        
        
        
        JOptionPane.showMessageDialog(this, "Paid!");
    }//GEN-LAST:event_btnPayActionPerformed

    private void btnConfirm3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirm3ActionPerformed
        // TODO add your handling code here:
        populateYogaInstructorTable();
    }//GEN-LAST:event_btnConfirm3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnConfirm1;
    private javax.swing.JButton btnConfirm2;
    private javax.swing.JButton btnConfirm3;
    private javax.swing.JButton btnManage;
    private javax.swing.JButton btnManagePayNutri;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnPayment;
    private javax.swing.JButton btnView;
    private javax.swing.JButton btnView1;
    private javax.swing.JButton btnView2;
    private com.toedter.calendar.JCalendar calendarSession;
    private javax.swing.JComboBox<String> cbcSlot;
    private javax.swing.JComboBox<String> cbcSlot1;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblInstructors;
    private javax.swing.JLabel lblInstructors1;
    private javax.swing.JLabel lblNutritionist;
    private javax.swing.JLabel lblNutritionist2;
    private javax.swing.JLabel lblSelectDate;
    private javax.swing.JLabel lblSelectDate1;
    private javax.swing.JLabel lblSelectDateTime;
    private javax.swing.JLabel lblStudents;
    private javax.swing.JLabel lblStudents1;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JLabel lblWelcome1;
    private javax.swing.JTable tblInstructor;
    private javax.swing.JTable tblInstructorPayment;
    private javax.swing.JTable tblNutritionist;
    private javax.swing.JTable tblNutritionistPayment;
    private javax.swing.JTable tblStudentList;
    private javax.swing.JTable tblStudentList1;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtDateTime;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTotal1;
    // End of variables declaration//GEN-END:variables
}
