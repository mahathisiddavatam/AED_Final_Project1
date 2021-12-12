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
        lblSelectDate = new javax.swing.JLabel();
        calendarSession = new com.toedter.calendar.JCalendar();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblStudentList = new javax.swing.JTable();
        btnConfirm = new javax.swing.JButton();
        txtDate = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
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
        lblStudents1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblStudentList1 = new javax.swing.JTable();
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

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        lblWelcome.setBackground(new java.awt.Color(255, 255, 0));
        lblWelcome.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(153, 0, 0));
        lblWelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWelcome.setText("Welcome, Mindfit Staff!");

        lblNutritionist.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblNutritionist.setText("Nutritionist Information:");
        lblNutritionist.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tblNutritionist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nutritionist ID", "Name"
            }
        ));
        jScrollPane1.setViewportView(tblNutritionist);

        btnView.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnView.setText("Click to view appointment request");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        btnManagePayNutri.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnManagePayNutri.setText("Manage Payment");
        btnManagePayNutri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManagePayNutriActionPerformed(evt);
            }
        });

        lblSelectDate.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblSelectDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSelectDate.setText("Select date to create appointment:");
        lblSelectDate.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tblStudentList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Appointment Date", "Appointment Time", "Appointment Status"
            }
        ));
        jScrollPane3.setViewportView(tblStudentList);

        btnConfirm.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnConfirm.setText("Confirm appointment");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("** Switch to next tab to manage payments for the selected therapist and student");

        lblStudents.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblStudents.setText("Student Information:");
        lblStudents.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        cbcSlot.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        cbcSlot.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Slot", "8:00 ", "9:00 ", "10:00 ", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00" }));

        btnConfirm2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnConfirm2.setText("Reject request");
        btnConfirm2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirm2ActionPerformed(evt);
            }
        });

        btnView2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnView2.setText("Refresh");
        btnView2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnView2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblWelcome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(lblSelectDate, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(292, 292, 292)
                                            .addComponent(cbcSlot, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(248, 248, 248)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(btnConfirm)
                                                .addComponent(btnConfirm2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGap(18, 18, 18)
                                    .addComponent(calendarSession, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(174, Short.MAX_VALUE))))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(418, 418, 418)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnManagePayNutri, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnView, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblNutritionist, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(385, 385, 385)
                            .addComponent(btnView2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNutritionist, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnView2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnManagePayNutri)
                .addGap(18, 18, 18)
                .addComponent(lblStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSelectDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addComponent(cbcSlot, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnConfirm2)
                        .addGap(18, 18, 18)
                        .addComponent(btnConfirm)
                        .addGap(0, 25, Short.MAX_VALUE))
                    .addComponent(calendarSession, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        jTabbedPane1.addTab("Manage Nutritionist Appointments", jPanel1);

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));

        lblNutritionist2.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        lblNutritionist2.setForeground(new java.awt.Color(153, 0, 0));
        lblNutritionist2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNutritionist2.setText("Manage Nutritionist Payment");
        lblNutritionist2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tblNutritionistPayment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Appointment ID", "Nutritionist ID", "StudentID", "Date", "Session Status"
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

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel5.setText("Amount due (in dollars $):");

        btnPayment.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnPayment.setText("Complete Payment");
        btnPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaymentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNutritionist2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnPayment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTotal1))))
                .addContainerGap(225, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblNutritionist2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(443, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manage Payment - Nutritionist", jPanel4);

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));

        lblWelcome1.setBackground(new java.awt.Color(255, 255, 0));
        lblWelcome1.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        lblWelcome1.setForeground(new java.awt.Color(153, 0, 0));
        lblWelcome1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWelcome1.setText("Welcome, Mindfit Staff!");

        lblInstructors.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblInstructors.setText("Yoga Instructor Information:");
        lblInstructors.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        btnManage.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnManage.setText("Manage Payment");
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
                "Instructor ID", "Name"
            }
        ));
        jScrollPane4.setViewportView(tblInstructor);

        btnView1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnView1.setText("Click to view appointment request");
        btnView1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnView1ActionPerformed(evt);
            }
        });

        lblStudents1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblStudents1.setText("Student Information:");
        lblStudents1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tblStudentList1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Appointment Date", "Appointment Time", "Appointment Status"
            }
        ));
        jScrollPane5.setViewportView(tblStudentList1);

        lblSelectDate1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblSelectDate1.setText("Select date to create appointment:");
        lblSelectDate1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblSelectDateTime.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblSelectDateTime.setForeground(new java.awt.Color(153, 0, 0));
        lblSelectDateTime.setText("** Switch to next tab to manage payments for the selected therapist and student");

        txtDateTime.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtDateTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateTimeActionPerformed(evt);
            }
        });

        btnConfirm1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnConfirm1.setText("Confirm Appointment");
        btnConfirm1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirm1ActionPerformed(evt);
            }
        });

        cbcSlot1.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        cbcSlot1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Slot", "8:00 ", "9:00 ", "10:00 ", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00" }));

        jCalendar1.setAutoscrolls(true);

        btnConfirm3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnConfirm3.setText("Refresh");
        btnConfirm3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirm3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblWelcome1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblStudents1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(lblInstructors, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(302, 302, 302)
                                    .addComponent(btnConfirm3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnManage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnView1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblSelectDateTime, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(lblSelectDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDateTime)
                                    .addComponent(cbcSlot1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnConfirm1, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(117, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblWelcome1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblInstructors, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnConfirm3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnView1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnManage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblStudents1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSelectDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbcSlot1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnConfirm1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblSelectDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manage Instructor Appointments", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));

        lblInstructors1.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        lblInstructors1.setForeground(new java.awt.Color(153, 0, 0));
        lblInstructors1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInstructors1.setText("Manage Instructor Payment");
        lblInstructors1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tblInstructorPayment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Appointment ID", "Instructor ID", "Student ID", "Date", "Status"
            }
        ));
        jScrollPane7.setViewportView(tblInstructorPayment);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setText("Amount due (in dollars $):");

        btnPay.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnPay.setText("Complete Payment");
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblInstructors1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnPay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTotal))))
                .addContainerGap(221, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInstructors1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(txtTotal))
                .addGap(18, 18, 18)
                .addComponent(btnPay)
                .addContainerGap(465, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manage Payment - Instructor", jPanel3);

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
