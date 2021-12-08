package userinterface.StudentRole;

import Business.Clinic.Therapist;
import Business.EcoSystem;
import Business.PetTherapy.PetParent;
import Business.PetTherapy.PetParentDirectory;
import Business.University.Student;

import Business.UserAccount.UserAccount;
import Business.WorkQueue.AccessRequest;
import Business.WorkQueue.Article;
import Business.WorkQueue.Event;
import Business.WorkQueue.EventQueue;
import Business.WorkQueue.Forum;
import Business.WorkQueue.PTherapy;
import Business.WorkQueue.Pet;
import Business.WorkQueue.PetTherapyQueue;
import Business.WorkQueue.Therapy;
import Business.WorkQueue.TherapyQueue;
import java.awt.Image;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.MainJFrame;

/**
 *
 * @author raunak
 */
public class StudentWorkAreaPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem system;
    private UserAccount userAccount;
    Student student;
    TherapyQueue therapyqueue;
    EventQueue eventqueue;
    PetParentDirectory petparentdirectory;
    PetTherapyQueue ptherapyqueue;
    
    /**
     * Creates new form LabAssistantWorkAreaJPanel
     */
    public StudentWorkAreaPanel(JPanel userProcessContainer, UserAccount account, EcoSystem business) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.system = business;
        populateAppointmentTable();
        populateEventTable();
        populatePetTable();
       // populatePetAppointment();
        this.student = system.getUniversitydirectory().getStudentdir().RetrieveStudent(MainJFrame.txtUsernameMain.getText());
        this.therapyqueue = system.getClinicdirectory().getTherapyqueue();
        this.eventqueue = system.getUniversitydirectory().getEventqueue();
        this.petparentdirectory = system.getPettherapydirectory().getPetparentdir();
        this.ptherapyqueue = system.getPettherapydirectory().getPettherapyqueue();
    
        
      
        
        
    }
    
    public void populatePetAppointment(){
        
        DefaultTableModel model = (DefaultTableModel) tblPetAppointments.getModel();
        model.setRowCount(0);
        if(this.ptherapyqueue==null){
            
            this.ptherapyqueue =system.getPettherapydirectory().getPettherapyqueue();
        }
        
        
        for(PTherapy ptherapy: ptherapyqueue.getPTherapylist() ){
            
            if(ptherapy.getStudentid().equals(MainJFrame.txtUsernameMain.getText())){
                
                Object[] row = new Object[4];
                 row[0]= ptherapy.getDog();
                 
                 
                
                
                row[1] = ptherapy.getDate();
                row[2] = ptherapy.getLocation();
                if(ptherapy.getAccept()==null){
                        
                        row[2]="Will be updated";
                        row[3]="Waiting for confirmation";
                        
                    }
                
                if(ptherapy.getAccept()!=null){
                if(ptherapy.getLocation()==null){
                    
                    if(ptherapy.getAccept()==false){
                        
                        row[2]="Not valid";
                        row[3]="Rejected";
                    }
                     
                    
                    
                    
                }
                
                if(ptherapy.getAccept()==true){
                    
                    row[3] = "Accepted";
                }
                }
                 model.insertRow(0, row);
                
                
            }
            
            
        }
        
        
    }
    
    public void populatePetTable(){
        
        DefaultTableModel model = (DefaultTableModel) tblPet.getModel();
        model.setRowCount(0);
        if(petparentdirectory==null){
            this.petparentdirectory = system.getPettherapydirectory().getPetparentdir();
        }
        for(PetParent parent: petparentdirectory.getpetparentlist()){
            
            
            for(Pet pet: parent.getPetQueue().getPetlist()){
                
                Object[] row = new Object[3];
                 row[2]= parent.getId();
                
                row[0]= pet.getName();
                row[1] = pet.getId();
                 model.insertRow(0, row);
                
                
            }
            
            
        }
       
        

        
        
        
        
        
        
    }
    
    

    
    public void populateEventTable(){
        
        DefaultTableModel model = (DefaultTableModel) tblEvents.getModel();
        model.setRowCount(0);
        if(eventqueue==null){
            eventqueue = system.getUniversitydirectory().getEventqueue();
            
            
        }
        for(Event event: eventqueue.getEventlist()){
            
            Object[] row = new Object[3];
            row[0]= event.getId();
            row[1]= event.getDate();
            row[2] = event.getPostedby();
           
            
            model.insertRow(0, row);
            
            
        }
        
        
    }
    
    public void populateAppointmentTable(){
        
        DefaultTableModel model = (DefaultTableModel) tblAppointment.getModel();
        model.setRowCount(0);
        if(student == null){
            student = system.getUniversitydirectory().getStudentdir().RetrieveStudent(MainJFrame.txtUsernameMain.getText());
            
        }
        
        if(student.getAssigned()==null){
            lblTherapistContact.setText("Will be updated shortly!");
            lblMessage.setText("Will be updated shortly!");
            lblSpecialities1.setText("Will be updated shortly!");
            lblDegree.setText("Will be updated shortly!");
            lblExp.setText("Will be updated shortly!");
            lblTherapistName3.setText("Will be updated shortly!");
            return;
        }
        
        else{
            if(student.getTherapistid()==null){
                return;
            }
            Therapist therapist = system.getClinicdirectory().getTherapistdir().RetrieveTherapist(student.getTherapistid());
            lblTherapistContact.setText(therapist.getPhno());
            lblMessage.setText(therapist.getMessage());
            lblSpecialities1.setText(therapist.getSpecialities());
            lblDegree.setText(therapist.getDegrees());
            lblExp.setText(therapist.getExperience());
            lblTherapistName3.setText(therapist.getName());
            
            
        }
        if(therapyqueue==null){
            therapyqueue = system.getClinicdirectory().getTherapyqueue();
        }
        for(Therapy therapy: therapyqueue.getTherapylist()){
            
            if(therapy.getStudentid().equals(student.getId())){
                
                if(therapy.getTerminate()==null){
                    therapy.setTerminate(false);
                }
                
                Object[] row = new Object[4];
                row[0]= therapy.getId();
                
                
                if(therapy.getDate()==null){
                    row[1]= "To be scheduled";
                    
                    
                    
                }
                if(therapy.getTerminate()==false){
                    
                    row[1]= therapy.getDate() + " Upcoming";
                }
                if(therapy.getTerminate()==true){
                    
                    row[1]= therapy.getDate();
                    
                    
                }
                if(therapy.getTime()==null){
                    row[2]= "To be scheduled";
                    
                    
                }
                else{
                    
                    row[2]= therapy.getTime();
                }
                
                
                
                if(therapy.getTerminate()==true){
                    
                    row[3] = "Session Completed";
                    
                    
                }
                
                if(therapy.getTerminate()==false){
                    
                    row[3] = "To be completed";
                    
                    
                }
                
                
            
                model.insertRow(0, row);
                
                
            }
        }
        
        
    }
    
    public void populateForumTable(){
        
        DefaultTableModel model = (DefaultTableModel) tblForums.getModel();
        model.setRowCount(0);
        
        for(Forum forum: system.getUniversitydirectory().getForumqueue().getForumlist()){
            
            System.out.print(forum.getId()+ "This is forum id\n");
            
            Object[] row = new Object[4];
            row[0]= forum.getId();
            row[1]= forum.getTitle();
            row[2] = forum.getCreatedby();
            row[3] = forum.getDate();
            
            model.insertRow(0, row);
            
            
        
        
            
            //To change body of generated methods, choose Tools | Templates.
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

        cbcSlot = new javax.swing.JComboBox<>();
        txtDate = new javax.swing.JTextField();
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
        jLabel21 = new javax.swing.JLabel();
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
        jLabel7 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAppointment = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblAppointment1 = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lblDegree = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lblTherapistName3 = new javax.swing.JLabel();
        lblExp = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblTherapistContact = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lblSpecialities1 = new javax.swing.JLabel();
        lblMessage = new javax.swing.JLabel();
        lbl = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblWelcome = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPosts = new javax.swing.JTable();
        btnView = new javax.swing.JButton();
        lblPost = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblTopic = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtStudentPost = new javax.swing.JTextField();
        btnPost = new javax.swing.JButton();
        lblComment = new javax.swing.JLabel();
        txtComment = new javax.swing.JTextField();
        btnRequestForumAccess = new javax.swing.JButton();
        lblTopic1 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lblCreated = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblForumID = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblForums = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        btnSelectForum1 = new javax.swing.JButton();
        btnSelectForum = new javax.swing.JButton();
        lblDescription = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        lblForumDescription = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblEvents = new javax.swing.JTable();
        lblViewDate = new javax.swing.JLabel();
        btnViewEvent = new javax.swing.JButton();
        lblViewDate1 = new javax.swing.JLabel();
        lblViewLocation = new javax.swing.JLabel();
        lblDetails = new javax.swing.JLabel();
        lblViewDetails = new javax.swing.JLabel();
        lblPosterImage = new javax.swing.JLabel();
        lblViewLocation2 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        lblInstructorName = new javax.swing.JLabel();
        txtInstructorName = new javax.swing.JLabel();
        lblInstSpeciality = new javax.swing.JLabel();
        txtInstructorSpeciality = new javax.swing.JLabel();
        lblInstPhone = new javax.swing.JLabel();
        txtInstPhone = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblYogaAppointment = new javax.swing.JTable();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblNurtitionAppointment = new javax.swing.JTable();
        jLabel38 = new javax.swing.JLabel();
        btnBookYoga = new javax.swing.JButton();
        btnBookNutritionist = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblPet = new javax.swing.JTable();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtPbreed = new javax.swing.JTextField();
        txtplikes = new javax.swing.JTextField();
        lblPetPhoto = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        btnBookPet = new javax.swing.JButton();
        txtPfood = new javax.swing.JTextField();
        calendarSession = new com.toedter.calendar.JCalendar();
        cbcSlot1 = new javax.swing.JComboBox<>();
        txtDate1 = new javax.swing.JTextField();
        lblDate = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        txtpage = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblPetAppointments = new javax.swing.JTable();
        btnRefreshpetApp = new javax.swing.JButton();

        cbcSlot.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Slot", "8:00 ", "9:00 ", "10:00 ", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00","17:00","18:00","19:00","20:00","21:00" }));

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

        cmbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Non-Binary", "Transgender", "Intersex","Other" }));
        cmbGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGenderActionPerformed(evt);
            }
        });
        jPanel1.add(cmbGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 160, -1));

        cmbEthnicity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "American Indian", "African Descent", "East Asian", "Hispanic","Middle Eastern","South Asian","Caucasian","Other" }));
        jPanel1.add(cmbEthnicity, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 160, -1));
        jPanel1.add(txtCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, 160, -1));

        btnSave.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 120, -1));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome, Husky! ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 820, -1));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Personal Details.png"))); // NOI18N
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 280, 300));

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
        btnSubmitResponse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitResponseActionPerformed(evt);
            }
        });
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

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/today.jpg"))); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 480, -1, 210));

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

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/feelings.png"))); // NOI18N
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, -1, 290));

        jTabbedPane1.addTab("How are you feeling today?", jPanel3);

        jPanel7.setBackground(new java.awt.Color(204, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Counselor and Appointment Details");
        jPanel7.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 5, 840, -1));

        tblAppointment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Session no.", "Date", "Time", "Session status"
            }
        ));
        jScrollPane2.setViewportView(tblAppointment);

        jPanel7.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 650, 110));

        jLabel17.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(153, 0, 0));
        jLabel17.setText("** Services are appointment based ONLY. Please call your therapist or the clinic to reschedule.");
        jPanel7.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 820, 20));

        jPanel8.setBackground(new java.awt.Color(204, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Counselor and Appointment Details");
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 5, 840, -1));

        tblAppointment1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Session no.", "Date", "Time", "Location", "Session status"
            }
        ));
        jScrollPane4.setViewportView(tblAppointment1);
        if (tblAppointment1.getColumnModel().getColumnCount() > 0) {
            tblAppointment1.getColumnModel().getColumn(3).setHeaderValue("Location");
        }

        jPanel8.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 650, 110));

        jLabel25.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(153, 0, 0));
        jLabel25.setText("** Services are appointment based ONLY. Please call your therapist or the clinic to reschedule.");
        jPanel8.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 840, 20));

        jLabel26.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel26.setText("Specialities:");
        jPanel8.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 150, 20));

        lblDegree.setText("<degree>");
        jPanel8.add(lblDegree, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, 300, 20));

        jLabel27.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel27.setText("Counselor Name:");
        jPanel8.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 150, 20));

        lblTherapistName3.setText("<therapist name>");
        jPanel8.add(lblTherapistName3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, 300, 20));

        lblExp.setText("<experience>");
        jPanel8.add(lblExp, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, 300, 20));

        jLabel22.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel22.setText("Years of Experience:");
        jPanel8.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 150, 20));

        jLabel16.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel16.setText("Contact no.:");
        jPanel8.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 140, 20));

        lblTherapistContact.setText("<therapist phone number>");
        jPanel8.add(lblTherapistContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 370, 300, 20));

        jLabel23.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel23.setText("Degree:");
        jPanel8.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 150, 20));

        lblSpecialities1.setText("<specialities>");
        jPanel8.add(lblSpecialities1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, 280, 20));

        lblMessage.setText("<message>");
        lblMessage.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel8.add(lblMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 410, 320, 30));

        lbl.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lbl.setText("Message for you:");
        jPanel8.add(lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, 150, 20));

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTabbedPane1.addTab("Counselor details", jPanel7);

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));
        jPanel4.setMinimumSize(new java.awt.Dimension(830, 700));
        jPanel4.setPreferredSize(new java.awt.Dimension(830, 700));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblWelcome.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblWelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWelcome.setText("Welcome to the Connect iN.U Forum!");
        jPanel4.add(lblWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 830, -1));

        tblPosts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Post ID", "Post Title", "Date posted"
            }
        ));
        jScrollPane1.setViewportView(tblPosts);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 370, 110));

        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        jPanel4.add(btnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 310, 100, -1));

        lblPost.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblPost.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.add(lblPost, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 44, 410, 590));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/forum.png"))); // NOI18N
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 210, 110));

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel12.setText("Add your own post here!");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, -1, 20));

        lblTopic.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblTopic.setText("Title:");
        jPanel4.add(lblTopic, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 400, 70, 20));

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 0, 102));
        jLabel14.setText("No access? Request access below!");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 540, 260, 20));
        jPanel4.add(txtStudentPost, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 440, 270, 60));

        btnPost.setText("Post");
        btnPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostActionPerformed(evt);
            }
        });
        jPanel4.add(btnPost, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 500, 100, -1));

        lblComment.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblComment.setText("Comment:");
        jPanel4.add(lblComment, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 600, 70, 20));
        jPanel4.add(txtComment, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 580, 270, 60));

        btnRequestForumAccess.setText("Request Access");
        btnRequestForumAccess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestForumAccessActionPerformed(evt);
            }
        });
        jPanel4.add(btnRequestForumAccess, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 650, -1, -1));

        lblTopic1.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblTopic1.setText("Post:");
        jPanel4.add(lblTopic1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 440, 70, 20));
        jPanel4.add(txtTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 400, 190, -1));

        jLabel4.setText("Created by");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 40, -1, -1));
        jPanel4.add(lblCreated, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, 100, 20));

        jLabel5.setText("Forum ID:");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, -1, -1));
        jPanel4.add(lblForumID, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, 60, 20));

        jTabbedPane1.addTab("Connect iN.U", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 204, 204));

        tblForums.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Forum ID", "Forum Name", "Created By", "Created On"
            }
        ));
        jScrollPane3.setViewportView(tblForums);

        jLabel18.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(153, 0, 51));
        jLabel18.setText("Select the forum you want to view!!");

        btnSelectForum1.setText("Refresh");
        btnSelectForum1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectForum1ActionPerformed(evt);
            }
        });

        btnSelectForum.setText("Select");
        btnSelectForum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectForumActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel19.setText("Description:");

        jLabel35.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Pick a forum! ");

        lblForumDescription.setText("<description>");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnSelectForum1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblForumDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 390, Short.MAX_VALUE)
                        .addComponent(btnSelectForum, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel35)
                .addGap(22, 22, 22)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelectForum)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(lblForumDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSelectForum1)
                .addContainerGap(551, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Select Forum", jPanel5);

        jPanel9.setBackground(new java.awt.Color(204, 255, 255));

        jLabel34.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Attend an event!");

        tblEvents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "EventID", " Posted on", "Posted by"
            }
        ));
        jScrollPane7.setViewportView(tblEvents);

        lblViewDate.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblViewDate.setText("Date:");

        btnViewEvent.setText("View");
        btnViewEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewEventActionPerformed(evt);
            }
        });

        lblViewDate1.setText("<date>");
        lblViewDate1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lblViewDate1FocusGained(evt);
            }
        });

        lblViewLocation.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblViewLocation.setText("Location:");

        lblDetails.setText("<location>");

        lblViewDetails.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblViewDetails.setText("Details:");

        lblPosterImage.setText("<poster image>");
        lblPosterImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblViewLocation2.setText("<location>");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jScrollPane7)
                        .addContainerGap())
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(lblPosterImage, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnViewEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblViewLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblViewDate, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblViewDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblViewDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblViewLocation2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 278, Short.MAX_VALUE))))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel34)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnViewEvent)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblViewDate, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblViewDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblViewLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblViewLocation2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPosterImage, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblViewDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(360, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Events", jPanel9);

        jPanel10.setBackground(new java.awt.Color(255, 204, 204));

        jLabel20.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(153, 0, 0));
        jLabel20.setText("** Services are appointment based ONLY. Please call your to reschedule.");

        jLabel29.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("MindFit Appointment Details");

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Session no.", "Date", "Time", "Session status"
            }
        ));
        jScrollPane8.setViewportView(jTable4);

        lblInstructorName.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblInstructorName.setText("Instructor Name:");

        txtInstructorName.setText("<instructor name>");

        lblInstSpeciality.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblInstSpeciality.setText("Specialty:");

        txtInstructorSpeciality.setText("<specialty- yoga/nutrition>");

        lblInstPhone.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblInstPhone.setText("Contact no.:");

        txtInstPhone.setText("<contactNo>");

        jLabel36.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel36.setText("Past appointments:");

        tblYogaAppointment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Name"
            }
        ));
        jScrollPane9.setViewportView(tblYogaAppointment);

        jLabel37.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel37.setText("Select new Yoga Instructor:");

        tblNurtitionAppointment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Name"
            }
        ));
        jScrollPane10.setViewportView(tblNurtitionAppointment);

        jLabel38.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel38.setText("Select new Nutritionist:");

        btnBookYoga.setText("Request Yoga Instructor");

        btnBookNutritionist.setText("Request Nutritionist");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblInstructorName, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblInstSpeciality, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblInstPhone))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtInstructorSpeciality, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtInstructorName, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtInstPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel36)
                            .addComponent(jLabel37))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnBookNutritionist, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnBookYoga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInstructorName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInstructorName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInstructorSpeciality, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInstSpeciality, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInstPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInstPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBookYoga))
                .addGap(18, 18, 18)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBookNutritionist))
                .addGap(73, 73, 73)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        jTabbedPane1.addTab("MindFit", jPanel10);

        jPanel6.setBackground(new java.awt.Color(204, 255, 255));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("WELCOME TO PET THERAPY !");

        tblPet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Pet Name", "Pet ID", "Pet Parent ID"
            }
        ));
        tblPet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPetMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblPet);

        jLabel28.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel28.setText("Breed:");

        jLabel30.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel30.setText("Loves food:");

        jLabel31.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel31.setText("Age");

        txtplikes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtplikesActionPerformed(evt);
            }
        });

        lblPetPhoto.setText("<image of the dog chosen>");
        lblPetPhoto.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel33.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel33.setText("Book To Pet!");

        btnBookPet.setText("Click to book");
        btnBookPet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookPetActionPerformed(evt);
            }
        });

        txtPfood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPfoodActionPerformed(evt);
            }
        });

        cbcSlot1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Slot", "8:00 ", "9:00 ", "10:00 ", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00","17:00","18:00","19:00","20:00","21:00" }));

        lblDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDate.setText("DATE ");

        jLabel39.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel39.setText("Likes");

        txtpage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpageActionPerformed(evt);
            }
        });

        tblPetAppointments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Pet Name", "Time Requested", "Location", "Status"
            }
        ));
        jScrollPane6.setViewportView(tblPetAppointments);

        btnRefreshpetApp.setText("Refresh Table");
        btnRefreshpetApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshpetAppActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPbreed, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel6Layout.createSequentialGroup()
                                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtpage, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(txtplikes, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(txtPfood, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(cbcSlot1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(calendarSession, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(61, 61, 61)
                                .addComponent(lblPetPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txtDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnBookPet)
                            .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRefreshpetApp))
                        .addContainerGap(37, Short.MAX_VALUE))))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPbreed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPfood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtplikes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(calendarSession, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(cbcSlot1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(lblPetPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(btnRefreshpetApp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBookPet)
                        .addGap(72, 72, 72)
                        .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(271, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Pet Therapy", jPanel6);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 870));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveResponseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveResponseActionPerformed
        // TODO add your handlif(ing code here:

            String id = MainJFrame.txtUsernameMain.getText();
            
            Student the = system.getUniversitydirectory().getStudentdir().RetrieveStudent(id);

            if(the.getTherapistid()==null){

                JOptionPane.showMessageDialog(this, "Please wait until a therapist has been assigned to answer these questions!");
                return;

            }
            the.setQues11(cmbQues11.getSelectedItem().toString());
            the.setQues12(cmbQues12.getSelectedItem().toString());
            the.setQues13(cmbQues13.getSelectedItem().toString());
            the.setQues14(cmbQues14.getSelectedItem().toString());
            the.setQues15(cmbQues15.getSelectedItem().toString());

            JOptionPane.showMessageDialog(this, "Thank you! Your answers have been recorded!");

    }//GEN-LAST:event_btnSaveResponseActionPerformed

    private void cmbQues1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbQues1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbQues1ActionPerformed

    private void btnSubmitResponseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitResponseActionPerformed
        // TODO add your handling code here:

        String id = MainJFrame.txtUsernameMain.getText();
        Student student = system.getUniversitydirectory().getStudentdir().RetrieveStudent(id);
        student.setAssigned(Boolean.FALSE);
        student.setQues1(cmbQues1.getSelectedItem().toString());
        student.setQues2(cmbQues2.getSelectedItem().toString());
        student.setQues3(cmbQues3.getSelectedItem().toString());
        student.setQues4(cmbQues4.getSelectedItem().toString());
        student.setQues5(cmbQues5.getSelectedItem().toString());

        student.setQues6(cmbQues6.getSelectedItem().toString());
        student.setQues7(cmbQues7.getSelectedItem().toString());
        student.setQues8(cmbQues8.getSelectedItem().toString());
        student.setQues9(cmbQues9.getSelectedItem().toString());
        student.setQues10(cmbQues10.getSelectedItem().toString());
        JOptionPane.showMessageDialog(this, "Thank you! A therapist will be assigned to you shortly!");

    }//GEN-LAST:event_btnSubmitResponseActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:

        String name = txtName.getText();
        String age =txtAge.getText();
        String gender = cmbGender.getSelectedItem().toString();
        String ethnicity = cmbEthnicity.getSelectedItem().toString();
        String org = txtCountry.getText();

        if(name==null || age==null || gender==null || ethnicity==null || org==null){

            JOptionPane.showMessageDialog(this, "Field left Blank!");
        }

        String id = MainJFrame.txtUsernameMain.getText();
        Student student = system.getUniversitydirectory().getStudentdir().RetrieveStudent(id);
        student.setAge(age);
        student.setEthnicity(ethnicity);
        student.setGender(gender);
        student.setOrigin(org);

        JOptionPane.showMessageDialog(this, "Your details have been saved! You can now proceed to the next tab");

    }//GEN-LAST:event_btnSaveActionPerformed

    private void cmbGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbGenderActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPostActionPerformed
        // TODO add your handling code here:
        
       int flag=0;
       
       
       int forumid = Integer.parseInt(lblForumID.getText());
       String studid = MainJFrame.txtUsernameMain.getText();
       if(system.getUniversitydirectory().getForumqueue().retrieveForum(forumid).getStudentidlist()==null){
           
           ArrayList<String> stlist = new ArrayList();
           system.getUniversitydirectory().getForumqueue().retrieveForum(forumid).setStudentidlist(stlist);
       }
       for(String student: system.getUniversitydirectory().getForumqueue().retrieveForum(forumid).getStudentidlist()){
           
           if(student.equals(studid)){
               
               flag =1;
               
           }
       }
       if(flag==0){
           
           for(AccessRequest acc: system.getUniversitydirectory().getReqaccessq().getAccessRequestlist()){
               
               if(studid.equals(acc.getStudentid())){
               
               if(acc.getAccept()==null){
                   
                   JOptionPane.showMessageDialog(this, "Your request is still waiting to be accepted");
                   return;
                   
                   
                   
               }
               
               if(acc.getAccept()==false){
                   
                   JOptionPane.showMessageDialog(this, "Your request was rejected. You can try requesting again");
                   return;
                   
                   
               }
               }
               
           }
           
           JOptionPane.showMessageDialog(this, "You do not have access to post. Please Request access!");
           return;
           
           
           
           
       }
       Article article=system.getUniversitydirectory().getForumqueue().retrieveForum(forumid).addArticle();
       Random rand = new Random();
       int id = rand.nextInt(12345);
       article.setId(id);
       
       
       article.setPost(txtStudentPost.getText());
       article.setTitle(txtTitle.getText());
       Date date = new Date();
       article.setDate(date);
       populatePostTable(system.getUniversitydirectory().getForumqueue().retrieveForum(forumid));
       JOptionPane.showMessageDialog(this, "Posted!");
       
        
       
    }//GEN-LAST:event_btnPostActionPerformed

    private void btnRequestForumAccessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestForumAccessActionPerformed
        // TODO add your handling code here:
        int forumid = Integer.parseInt(lblForumID.getText());
        for(String id: system.getUniversitydirectory().getForumqueue().retrieveForum(forumid).getStudentidlist()){
            
            if(id.equals(MainJFrame.txtUsernameMain.getText())){
                JOptionPane.showMessageDialog(this, "You have access! Continue Posting!");
                return;
                
            }
        }
        AccessRequest acc=system.getUniversitydirectory().getReqaccessq().addAccessRequest();
        
        Random rand = new Random();
        int id = rand.nextInt(12345);
        acc.setId(id);
        
        acc.setDescription(txtComment.getText());
        acc.setStudentid(MainJFrame.txtUsernameMain.getText());
        acc.setForumby(lblCreated.getText());
        Date date = new Date();
        acc.setDate(date);
        acc.setForumid(forumid);
        JOptionPane.showMessageDialog(this, "Access Requested!");
        
        
    }//GEN-LAST:event_btnRequestForumAccessActionPerformed

    private void btnSelectForumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectForumActionPerformed
        // TODO add your handling code here:
        
         DefaultTableModel modelOrder = (DefaultTableModel)tblForums.getModel();
        int selectedIndex = tblForums.getSelectedRow();
        if(selectedIndex==-1){
            
            JOptionPane.showMessageDialog(this, "Please Select a post!");
            return;
            
        }
        String forumid=null;
        String createdby=null;
        if(selectedIndex!=-1){
            
             forumid = modelOrder.getValueAt(selectedIndex, 0).toString();
             createdby = modelOrder.getValueAt(selectedIndex, 2).toString();
        }
        
        Forum forum = system.getUniversitydirectory().getForumqueue().retrieveForum(Integer.parseInt(forumid));
        
        lblForumID.setText(forumid);
        lblCreated.setText(createdby);
        lblWelcome.setText("Welcome to "+ forum.getTitle());
        lblDescription.setText(system.getUniversitydirectory().getForumqueue().retrieveForum(Integer.parseInt(forumid)).getDescription());
        
        
        populatePostTable(system.getUniversitydirectory().getForumqueue().retrieveForum(Integer.parseInt(forumid)));
        JOptionPane.showMessageDialog(this, "Switch to the next tab to view forum!");
        

        
        
    }//GEN-LAST:event_btnSelectForumActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel modelOrder = (DefaultTableModel)tblPosts.getModel();
        int selectedIndex = tblPosts.getSelectedRow();
        String postid=null;
        if(selectedIndex==-1){
            
            JOptionPane.showMessageDialog(this, "Please Select a post!");
            return;
            
        }
        //String createdby=null;
        if(selectedIndex!=-1){
            
             postid = modelOrder.getValueAt(selectedIndex, 0).toString();
             System.out.print(postid+ "This is post ID\n");
             //createdby = modelOrder.getValueAt(selectedIndex, 2).toString();
        }
        int forumid  = Integer.parseInt(lblForumID.getText());
        int posttid = Integer.parseInt(postid);
        System.out.print(posttid+ "This is post ID int\n");
        Article article = system.getUniversitydirectory().getForumqueue().retrieveForum(forumid).retrieveArticle(posttid);
        System.out.print("Aricle id" + article.getId());
        System.out.print("Aricle post" + article.getPost());
        
        String post = system.getUniversitydirectory().getForumqueue().retrieveForum(forumid).retrieveArticle(posttid).getPost();
        
        String parsedPost = post.replaceAll("(.{65})", "$1\n");
        //System.out.print(parsedPost);
        lblPost.setText("<html>" + parsedPost.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
        
    }//GEN-LAST:event_btnViewActionPerformed

    private void txtplikesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtplikesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtplikesActionPerformed

    private void btnSelectForum1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectForum1ActionPerformed
        // TODO add your handling code here:
        populateForumTable();
    }//GEN-LAST:event_btnSelectForum1ActionPerformed

    private void btnViewEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewEventActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel modelOrder = (DefaultTableModel)tblEvents.getModel();
        int selectedIndex = tblEvents.getSelectedRow();
        String eventid=null;
        if(selectedIndex==-1){
            
            JOptionPane.showMessageDialog(this, "Please Select an Event");
            return;
            
        }
        //String createdby=null;
        if(selectedIndex!=-1){
            
             eventid = modelOrder.getValueAt(selectedIndex, 0).toString();
             
             //createdby = modelOrder.getValueAt(selectedIndex, 2).toString();
        }
        
        int eventint = Integer.parseInt(eventid);
        Event event=eventqueue.retrieveEvent(eventint);
        
        lblViewDate1.setText(event.getDat());
        lblDetails.setText(event.getForum());
        lblViewLocation2.setText(event.getLocation());
        ImageIcon icon = new ImageIcon(event.getFilename());
     
        Image image = icon.getImage().getScaledInstance(lblPosterImage.getWidth(), lblPosterImage.getHeight(), Image.SCALE_SMOOTH);
        lblPosterImage.setIcon(new ImageIcon(image));
        
        
        
        
        
        
        
    }//GEN-LAST:event_btnViewEventActionPerformed

    private void lblViewDate1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lblViewDate1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_lblViewDate1FocusGained

    private void txtPfoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPfoodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPfoodActionPerformed

    private void tblPetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPetMouseClicked
        // TODO add your handling code here:
        
        DefaultTableModel modelOrder = (DefaultTableModel)tblPet.getModel();
        int selectedIndex = tblPet.getSelectedRow();
        String petid=null;
        String parentid = null;
        if(selectedIndex==-1){
            
            
            return;
            
        }
        //String createdby=null;
        if(selectedIndex!=-1){
            
             petid = modelOrder.getValueAt(selectedIndex, 1).toString();
             parentid =modelOrder.getValueAt(selectedIndex, 2).toString(); 
             
             //createdby = modelOrder.getValueAt(selectedIndex, 2).toString();
        }
        
        int petid1 = Integer.parseInt(petid);
        
        Pet pet = petparentdirectory.RetrievePetParent(parentid).getPetQueue().retrievePet(petid1);
        
        txtpage.setText(pet.getAge());
        txtPbreed.setText(pet.getBreed());
        txtPfood.setText(pet.getFood());
        txtplikes.setText(pet.getLikes());
        ImageIcon icon = new ImageIcon(pet.getFilename());
     
        Image image = icon.getImage().getScaledInstance(lblPetPhoto.getWidth(), lblPetPhoto.getHeight(), Image.SCALE_SMOOTH);
        lblPetPhoto.setIcon(new ImageIcon(image));
        
        
        
        
        
    }//GEN-LAST:event_tblPetMouseClicked

    private void txtpageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpageActionPerformed

    private void btnBookPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookPetActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel modelOrder = (DefaultTableModel)tblPet.getModel();
        int selectedIndex = tblPet.getSelectedRow();
        String petid=null;
        String parentid = null;
        if(selectedIndex==-1){
            
            JOptionPane.showMessageDialog(this, "Please Select a dog");
            return;
            
        }
        //String createdby=null;
        if(selectedIndex!=-1){
            
             petid = modelOrder.getValueAt(selectedIndex, 1).toString();
             parentid =modelOrder.getValueAt(selectedIndex, 2).toString(); 
             
             //createdby = modelOrder.getValueAt(selectedIndex, 2).toString();
        }
        
        int petid1 = Integer.parseInt(petid);
        
        Pet pet = petparentdirectory.RetrievePetParent(parentid).getPetQueue().retrievePet(petid1);
        
        if(system.getPettherapydirectory().getPettherapyqueue()==null){
            
            PetTherapyQueue ptherq = new PetTherapyQueue();
            
            system.getPettherapydirectory().setPettherapyqueue(ptherq);
        }
        
        PTherapy ptherapy = system.getPettherapydirectory().getPettherapyqueue().addPTherapy();
        
        Random rand = new Random();
        int random = rand.nextInt(12345);
        ptherapy.setId(random);
        
        ptherapy.setDog(pet.getName());
        ptherapy.setPetid(pet.getId());
        ptherapy.setTerminate(Boolean.FALSE);
        ptherapy.setStudentid(student.getId());
        Calendar cal = calendarSession.getCalendar();
        
        Date date = cal.getTime();
        String strDate = DateFormat.getDateInstance().format(date);
        txtDate1.setText(strDate);
        
        String slot = cbcSlot1.getSelectedItem().toString();
        ptherapy.setDate(strDate);
        ptherapy.setTime(slot);
        
        JOptionPane.showMessageDialog(this, "Slot Requested!");
        populatePetAppointment();
        
        
        
    }//GEN-LAST:event_btnBookPetActionPerformed

    private void btnRefreshpetAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshpetAppActionPerformed
        // TODO add your handling code here:
        
        populatePetAppointment();
    }//GEN-LAST:event_btnRefreshpetAppActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBookNutritionist;
    private javax.swing.JButton btnBookPet;
    private javax.swing.JButton btnBookYoga;
    private javax.swing.JButton btnPost;
    private javax.swing.JButton btnRefreshpetApp;
    private javax.swing.JButton btnRequestForumAccess;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSaveResponse;
    private javax.swing.JButton btnSelectForum;
    private javax.swing.JButton btnSelectForum1;
    private javax.swing.JButton btnSubmitResponse;
    private javax.swing.JButton btnView;
    private javax.swing.JButton btnViewEvent;
    private com.toedter.calendar.JCalendar calendarSession;
    private javax.swing.JComboBox<String> cbcSlot;
    private javax.swing.JComboBox<String> cbcSlot1;
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
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable4;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblComment;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblCreated;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDegree;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblDetails;
    private javax.swing.JLabel lblEthnicity;
    private javax.swing.JLabel lblExp;
    private javax.swing.JLabel lblForumDescription;
    private javax.swing.JLabel lblForumID;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblInstPhone;
    private javax.swing.JLabel lblInstSpeciality;
    private javax.swing.JLabel lblInstructorName;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPetPhoto;
    private javax.swing.JLabel lblPost;
    private javax.swing.JLabel lblPosterImage;
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
    private javax.swing.JLabel lblSpecialities1;
    private javax.swing.JLabel lblTherapistContact;
    private javax.swing.JLabel lblTherapistName3;
    private javax.swing.JLabel lblTopic;
    private javax.swing.JLabel lblTopic1;
    private javax.swing.JLabel lblViewDate;
    private javax.swing.JLabel lblViewDate1;
    private javax.swing.JLabel lblViewDetails;
    private javax.swing.JLabel lblViewLocation;
    private javax.swing.JLabel lblViewLocation2;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JTable tblAppointment;
    private javax.swing.JTable tblAppointment1;
    private javax.swing.JTable tblEvents;
    private javax.swing.JTable tblForums;
    private javax.swing.JTable tblNurtitionAppointment;
    private javax.swing.JTable tblPet;
    private javax.swing.JTable tblPetAppointments;
    private javax.swing.JTable tblPosts;
    private javax.swing.JTable tblYogaAppointment;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtComment;
    private javax.swing.JTextField txtCountry;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtDate1;
    private javax.swing.JLabel txtInstPhone;
    private javax.swing.JLabel txtInstructorName;
    private javax.swing.JLabel txtInstructorSpeciality;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPbreed;
    private javax.swing.JTextField txtPfood;
    private javax.swing.JLabel txtQues14;
    private javax.swing.JTextField txtStudentPost;
    private javax.swing.JTextField txtTitle;
    private javax.swing.JTextField txtpage;
    private javax.swing.JTextField txtplikes;
    // End of variables declaration//GEN-END:variables

    private void populatePostTable(Forum forum) {
        DefaultTableModel model = (DefaultTableModel) tblPosts.getModel();
        model.setRowCount(0);
        
        if(forum.getArticlelist()==null){
            
            ArrayList <Article> artlist = new ArrayList();
            forum.setArticlelist(artlist);
        }
        
        
        
        for(Article article: forum.getArticlelist()){
            
            Object[] row = new Object[3];
            row[0]= article.getId();
            row[1]= article.getTitle();
            row[2] = article.getDate();
            
            model.insertRow(0, row);
            
            
        }
            
            //To change body of generated methods, choose Tools | Templates.
    }
}
