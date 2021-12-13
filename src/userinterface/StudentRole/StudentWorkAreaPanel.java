package userinterface.StudentRole;

import Business.Clinic.Therapist;
import Business.EcoSystem;
import Business.MindFitness.NutrionistDirectory;
import Business.MindFitness.Nutritionist;
import Business.MindFitness.YogaInstructor;
import Business.MindFitness.YogaInstructorDirectory;
import Business.PetTherapy.PetParent;
import Business.PetTherapy.PetParentDirectory;
import Business.University.Student;

import Business.UserAccount.UserAccount;
import Business.WorkQueue.AccessRequest;
import Business.WorkQueue.Article;
import Business.WorkQueue.Event;
import Business.WorkQueue.EventQueue;
import Business.WorkQueue.Forum;
import Business.WorkQueue.NutritionRequest;
import Business.WorkQueue.NutritionRequestQueue;
import Business.WorkQueue.NutritionistAppointment;
import Business.WorkQueue.NutritionistAppointmentQueue;
import Business.WorkQueue.PTherapy;
import Business.WorkQueue.Pet;
import Business.WorkQueue.PetTherapyQueue;
import Business.WorkQueue.Therapy;
import Business.WorkQueue.TherapyQueue;
import Business.WorkQueue.YogaAppointment;
import Business.WorkQueue.YogaAppointmentQueue;
import Business.WorkQueue.YogaRequest;
import Business.WorkQueue.YogaRequestQueue;
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
    YogaAppointmentQueue yogaqueue;
    NutritionistAppointmentQueue nutriqueue;
    NutrionistDirectory nutridir;
    YogaInstructorDirectory yogadir;
    YogaRequestQueue yogarequestqueue;
    NutritionRequestQueue nutrirequestqueue;
    
    /**
     * Creates new form LabAssistantWorkAreaJPanel
     */
    public StudentWorkAreaPanel(JPanel userProcessContainer, UserAccount account, EcoSystem business) {
        initComponents();
        
        this.setSize(3200, 1800);
        
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
        this.nutridir = system.getMindfitnessdir().getNutridir();
        this.nutriqueue = system.getMindfitnessdir().getNutriqueue();
        this.yogaqueue = system.getMindfitnessdir().getYogaqueue();
        this.yogadir = system.getMindfitnessdir().getYogadir();
        this.yogarequestqueue = system.getMindfitnessdir().getYogarequestqueue();
        this.nutrirequestqueue = system.getMindfitnessdir().getNutrirequestqueue();
        
        
    
        
      
        
        
    }
    
    public void populateYogaInstructors(){
        
        DefaultTableModel model = (DefaultTableModel) tblYoga.getModel();
        model.setRowCount(0);
        
        for(YogaInstructor yoga: yogadir.getyogainstlist()){
            
            Object[] row = new Object[3];
                 row[0]= yoga.getId();
                 
                 
                 
                
                
                row[1] = yoga.getName();
                row[2] = yoga.getSpeciality();
                model.insertRow(0, row);
                
            
            
        }
        
        DefaultTableModel modelNutri = (DefaultTableModel) tblNutritionist.getModel();
        modelNutri.setRowCount(0);
        
        for(Nutritionist yoga: nutridir.getnutritionistlist()){
            
            Object[] row = new Object[3];
                 row[0]= yoga.getId();
                 
                 
                 
                
                
                row[1] = yoga.getName();
                row[2] = yoga.getSpeciality();
                modelNutri.insertRow(0, row);
                
            
            
        }
        
        
    }
    
    public void populateMindFitAppointments(){
        
         DefaultTableModel model = (DefaultTableModel) tblMindfitAppoinments.getModel();
         model.setRowCount(0);
         
         for(YogaAppointment yoga: yogaqueue.getYogaAppointmentlist() ){
             
             if(yoga.getStudentid().equals(student.getId())){
                 
                 Object[] row = new Object[5];
                 row[0]= yoga.getId();
                 
                 
                 
                
                
                row[1] = yoga.getDate();
                row[2] = yoga.getTime();
                row[3]= "Yoga Instructor";
                
                if(yoga.getTerminate()==false){
                    
                    row[4] = "Upcoming";
                }
                
                if(yoga.getTerminate()==true){
                    
                    row[4] = "Session Completed";
                }
                
                model.insertRow(0, row);
                
                
                
                
                 
                 
             }
             
             
         }
         for(NutritionistAppointment yoga: nutriqueue.getNutritionistAppointmentlist() ){
             
             if(yoga.getStudentid().equals(student.getId())){
                 
                 Object[] row = new Object[5];
                 row[0]= yoga.getId();
                 
                 
                 
                
                
                row[1] = yoga.getDate();
                row[2] = yoga.getTime();
                row[3]= "Nutritionist";
                
                if(yoga.getTerminate()==false){
                    
                    row[4] = "Upcoming";
                }
                
                if(yoga.getTerminate()==true){
                    
                    row[4] = "Session Completed";
                }
                
                model.insertRow(0, row);
                
                
                
                
                 
                 
             }
             
             
         }
        
        
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
        jLabel24 = new javax.swing.JLabel();
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
        jPanel8 = new javax.swing.JPanel();
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
        jLabel17 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAppointment = new javax.swing.JTable();
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
        tblMindfitAppoinments = new javax.swing.JTable();
        lblInstructorName = new javax.swing.JLabel();
        txtInstructorName = new javax.swing.JLabel();
        lblInstSpeciality = new javax.swing.JLabel();
        txtInstructorSpeciality = new javax.swing.JLabel();
        lblInstPhone = new javax.swing.JLabel();
        txtInstPhone = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblYoga = new javax.swing.JTable();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblNutritionist = new javax.swing.JTable();
        jLabel38 = new javax.swing.JLabel();
        btnBookYoga = new javax.swing.JButton();
        btnBookNutritionist = new javax.swing.JButton();
        btnBookYoga2 = new javax.swing.JButton();
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
        jLabel15 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();

        cbcSlot.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Slot", "8:00 ", "9:00 ", "10:00 ", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00","17:00","18:00","19:00","20:00","21:00" }));

        setBackground(new java.awt.Color(255, 255, 204));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 204));
        jTabbedPane1.setForeground(new java.awt.Color(153, 0, 0));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(0, 0));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1920, 1080));

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1080, 878));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtName.setPreferredSize(new java.awt.Dimension(120, 20));
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 160, 30));

        txtAge.setPreferredSize(new java.awt.Dimension(120, 20));
        jPanel1.add(txtAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 160, 30));

        lblName.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblName.setText("Full Name:");
        lblName.setPreferredSize(new java.awt.Dimension(100, 20));
        lblName.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 160, 30));

        lblAge.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblAge.setText("Age:");
        jPanel1.add(lblAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 160, 30));

        lblGender.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblGender.setText("Gender:");
        jPanel1.add(lblGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 160, 30));

        lblEthnicity.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblEthnicity.setText("Ethnicity:");
        jPanel1.add(lblEthnicity, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 160, 30));

        lblCountry.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblCountry.setText("Country of origin:");
        jPanel1.add(lblCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 160, 30));

        cmbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Non-Binary", "Transgender", "Intersex","Other" }));
        cmbGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGenderActionPerformed(evt);
            }
        });
        jPanel1.add(cmbGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 160, 30));

        cmbEthnicity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "American Indian", "African Descent", "East Asian", "Hispanic","Middle Eastern","South Asian","Caucasian","Other" }));
        jPanel1.add(cmbEthnicity, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, 160, 30));
        jPanel1.add(txtCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 340, 160, 30));

        btnSave.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, 160, 30));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome, Husky! ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 844, -1));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Personal Details.png"))); // NOI18N
        jLabel21.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 438, 270, 180));

        jLabel24.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(153, 0, 0));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Feeling blue? No worries! Our strong community of Northeastern University is here to help!");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 844, 30));

        jTabbedPane1.addTab("Person Details", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(1080, 878));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tell us a bit about yourself!");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1000, -1));

        lblQues1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblQues1.setText("1. What emotion have you been experiencing most recently? ");
        jPanel2.add(lblQues1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 750, 30));

        lblQues2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblQues2.setText("2. Any big changes in life?");
        jPanel2.add(lblQues2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 131, 750, 30));

        lblQues3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblQues3.setText("3. How well have you been sleeping lately? (rate on a scale of 1-5)");
        jPanel2.add(lblQues3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 750, 30));

        lblQues4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblQues4.setText("4. Do you know what is bothering you?");
        jPanel2.add(lblQues4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 213, 750, 30));

        lblQues5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblQues5.setText("5. How much emotional support do you feel you have?  (rate on a scale of 1-5)");
        jPanel2.add(lblQues5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 254, 750, 30));

        btnSubmitResponse.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnSubmitResponse.setText("Submit Response");
        btnSubmitResponse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitResponseActionPerformed(evt);
            }
        });
        jPanel2.add(btnSubmitResponse, new org.netbeans.lib.awtextra.AbsoluteConstraints(792, 542, 170, 40));

        cmbQues1.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        cmbQues1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Joy", "Anger", "Sadness", "Anxiety", "Fear", "Mixed Emotion", " " }));
        cmbQues1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbQues1ActionPerformed(evt);
            }
        });
        jPanel2.add(cmbQues1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 90, 150, 30));

        cmbQues2.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        cmbQues2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));
        jPanel2.add(cmbQues2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 131, 150, 30));

        cmbQues3.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        cmbQues3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", " " }));
        jPanel2.add(cmbQues3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 172, 150, 30));

        cmbQues4.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        cmbQues4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No", "Umm...I think so" }));
        cmbQues4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbQues4ActionPerformed(evt);
            }
        });
        jPanel2.add(cmbQues4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 213, 150, 30));

        cmbQues5.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        cmbQues5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        jPanel2.add(cmbQues5, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 254, 150, 30));

        lblQues6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblQues6.setText("6. Do you feel you're having trouble fitting in?");
        jPanel2.add(lblQues6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 302, 750, 30));

        cmbQues6.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        cmbQues6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No", "A little bit..." }));
        jPanel2.add(cmbQues6, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 302, 150, 30));

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel9.setText("7. Are you having trouble getting by on your own in everyday life?");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 750, 30));

        cmbQues7.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        cmbQues7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));
        jPanel2.add(cmbQues7, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 350, 150, 30));

        lblQues8.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblQues8.setText("8. Do you feel like something bad is about to happen?");
        jPanel2.add(lblQues8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 398, 750, 30));

        cmbQues8.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        cmbQues8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));
        jPanel2.add(cmbQues8, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 398, 150, 30));

        lblQues9.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblQues9.setText("9. Do you feel you're too self-consious to show positive feelings? (rate on a scale of 1-5)");
        jPanel2.add(lblQues9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 446, 750, 30));

        cmbQues9.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        cmbQues9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        jPanel2.add(cmbQues9, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 446, 150, 30));

        lblQues10.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblQues10.setText("10. Do you think you are fundamentally different from other people? (rate on a scale of 1-5)");
        jPanel2.add(lblQues10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 494, 750, 30));

        cmbQues10.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        cmbQues10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        jPanel2.add(cmbQues10, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 494, 150, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/today.jpg"))); // NOI18N
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 542, 530, 151));

        jTabbedPane1.addTab("Questionnaire ", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Breathe in and out, notice the emotions that are inside of you. How do you feel?");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 990, 30));

        lblQues11.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblQues11.setText("1. In the past week, how often have you felt: joy, anxiety, sadness, anger, etc.?");
        jPanel3.add(lblQues11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 640, 30));

        lblQues12.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblQues12.setText("2. What colour is the best fit for how you feel today? ");
        jPanel3.add(lblQues12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 640, 30));

        lblQues13.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblQues13.setText("3. Have you been feeling physically ill in the past week?");
        jPanel3.add(lblQues13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 630, 30));

        btnSaveResponse.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnSaveResponse.setText("Save Response");
        btnSaveResponse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveResponseActionPerformed(evt);
            }
        });
        jPanel3.add(btnSaveResponse, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 360, 210, 30));

        cmbQues11.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        cmbQues11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Not often", "Very often", "All the time!" }));
        jPanel3.add(cmbQues11, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 100, 210, 30));

        cmbQues12.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        cmbQues12.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Red", "Blue", "Green", "Yellow", "Pink" }));
        jPanel3.add(cmbQues12, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 150, 210, 30));

        cmbQues13.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        cmbQues13.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));
        jPanel3.add(cmbQues13, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 200, 210, 30));

        txtQues14.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtQues14.setText("4. How many hours of sleep did you get this week? ");
        jPanel3.add(txtQues14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 630, 30));

        cmbQues14.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        cmbQues14.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "< 20 hours", "< 35 hours", "< 50 hours", "> 55 hours" }));
        jPanel3.add(cmbQues14, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 250, 210, 30));

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel10.setText("5. Do you feel lethargic?");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 630, 30));

        cmbQues15.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        cmbQues15.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No", "All the time...." }));
        jPanel3.add(cmbQues15, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 300, 210, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/feelings.png"))); // NOI18N
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 430, 400, 290));

        jTabbedPane1.addTab("How are you feeling today?", jPanel3);

        jPanel7.setBackground(new java.awt.Color(204, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(255, 255, 204));
        jPanel8.setMaximumSize(new java.awt.Dimension(1000, 800));
        jPanel8.setMinimumSize(new java.awt.Dimension(1000, 800));
        jPanel8.setPreferredSize(new java.awt.Dimension(1000, 800));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel26.setText("Specialities:");
        jPanel8.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 380, 170, 30));

        lblDegree.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        lblDegree.setText("<degree>");
        jPanel8.add(lblDegree, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 280, 300, 30));

        jLabel27.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel27.setText("Counselor Name:");
        jPanel8.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 170, 30));

        lblTherapistName3.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        lblTherapistName3.setText("<therapist name>");
        jPanel8.add(lblTherapistName3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, 300, 30));

        lblExp.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        lblExp.setText("<experience>");
        jPanel8.add(lblExp, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, 300, 30));

        jLabel22.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel22.setText("Years of Experience:");
        jPanel8.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, 170, 30));

        jLabel16.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel16.setText("Contact no.:");
        jPanel8.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, 170, 30));

        lblTherapistContact.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        lblTherapistContact.setText("<therapist phone number>");
        jPanel8.add(lblTherapistContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 430, 320, 30));

        jLabel23.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel23.setText("Degree:");
        jPanel8.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 170, 30));

        lblSpecialities1.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        lblSpecialities1.setText("<specialities>");
        jPanel8.add(lblSpecialities1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 380, 320, 30));

        lblMessage.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        lblMessage.setText("<message>");
        lblMessage.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel8.add(lblMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 480, 320, 30));

        lbl.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbl.setText("Message for you:");
        jPanel8.add(lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 480, 170, 30));

        jLabel17.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(153, 0, 0));
        jLabel17.setText("** Services are appointment based ONLY. Please call your therapist or the clinic to reschedule.");
        jPanel8.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 640, 990, 20));

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 0, 51));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Counselor and Appointment Details");
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 990, -1));

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

        jPanel8.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 860, 110));

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1050));

        jTabbedPane1.addTab("Counselor details", jPanel7);

        jPanel5.setBackground(new java.awt.Color(255, 255, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel5.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 95, 900, 124));

        jLabel18.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(153, 0, 51));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Select the forum you want to view!!");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 59, 975, -1));

        btnSelectForum1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnSelectForum1.setText("Refresh");
        btnSelectForum1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectForum1ActionPerformed(evt);
            }
        });
        jPanel5.add(btnSelectForum1, new org.netbeans.lib.awtextra.AbsoluteConstraints(842, 282, 101, -1));

        btnSelectForum.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnSelectForum.setText("Select");
        btnSelectForum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectForumActionPerformed(evt);
            }
        });
        jPanel5.add(btnSelectForum, new org.netbeans.lib.awtextra.AbsoluteConstraints(842, 237, 101, -1));
        jPanel5.add(lblDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel19.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel19.setText("Description:");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 237, 133, 32));

        jLabel35.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(153, 0, 0));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Pick a forum! ");
        jPanel5.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, 975, -1));

        lblForumDescription.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        lblForumDescription.setText("<description>");
        jPanel5.add(lblForumDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 237, 571, 32));

        jTabbedPane1.addTab("Select Forum", jPanel5);

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));
        jPanel4.setName(""); // NOI18N
        jPanel4.setPreferredSize(new java.awt.Dimension(1920, 1080));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblWelcome.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(153, 0, 0));
        lblWelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWelcome.setText("Welcome to the Connect iN.U Forum!");
        lblWelcome.setPreferredSize(new java.awt.Dimension(3200, 1800));
        jPanel4.add(lblWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(-900, -680, -1, 1440));

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

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 450, 110));

        btnView.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        jPanel4.add(btnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 320, 100, -1));

        lblPost.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblPost.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.add(lblPost, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 64, 460, 656));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/forum.png"))); // NOI18N
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, -1, 110));

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 0, 102));
        jLabel12.setText("Add your own post here!");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, 450, 30));

        lblTopic.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblTopic.setText("Title:");
        jPanel4.add(lblTopic, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 410, 100, 30));

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 0, 102));
        jLabel14.setText("No access? Request access below!");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 580, 450, 30));
        jPanel4.add(txtStudentPost, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 460, 320, 60));

        btnPost.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnPost.setText("Post");
        btnPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostActionPerformed(evt);
            }
        });
        jPanel4.add(btnPost, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 530, 100, -1));

        lblComment.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblComment.setText("Comment:");
        jPanel4.add(lblComment, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 620, 120, 30));
        jPanel4.add(txtComment, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 620, 310, 60));

        btnRequestForumAccess.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnRequestForumAccess.setText("Request Access");
        btnRequestForumAccess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestForumAccessActionPerformed(evt);
            }
        });
        jPanel4.add(btnRequestForumAccess, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 690, -1, 30));

        lblTopic1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblTopic1.setText("Post:");
        jPanel4.add(lblTopic1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 460, 100, 30));
        jPanel4.add(txtTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 410, 320, 30));

        jLabel4.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jLabel4.setText("Created by:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 70, 90, 20));
        jPanel4.add(lblCreated, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 70, 100, 20));

        jLabel5.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jLabel5.setText("Forum ID:");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 140, 90, 20));
        jPanel4.add(lblForumID, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 140, 100, 20));

        jTabbedPane1.addTab("Connect iN.U", jPanel4);

        jPanel9.setBackground(new java.awt.Color(255, 255, 204));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(153, 0, 0));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Attend an event!");
        jPanel9.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, 990, -1));

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

        jPanel9.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 73, 947, 110));

        lblViewDate.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblViewDate.setText("Date:");
        jPanel9.add(lblViewDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 296, 90, 24));

        btnViewEvent.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnViewEvent.setText("View");
        btnViewEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewEventActionPerformed(evt);
            }
        });
        jPanel9.add(btnViewEvent, new org.netbeans.lib.awtextra.AbsoluteConstraints(706, 201, 155, -1));

        lblViewDate1.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        lblViewDate1.setText("<date>");
        lblViewDate1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lblViewDate1FocusGained(evt);
            }
        });
        jPanel9.add(lblViewDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 296, 170, 24));

        lblViewLocation.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblViewLocation.setText("Location:");
        jPanel9.add(lblViewLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 338, 90, 24));

        lblDetails.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        lblDetails.setText("<details>");
        jPanel9.add(lblDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 380, 170, 24));

        lblViewDetails.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblViewDetails.setText("Details:");
        jPanel9.add(lblViewDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 380, 90, 24));

        lblPosterImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPosterImage.setText("Poster here");
        lblPosterImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel9.add(lblPosterImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 226, 232, 270));

        lblViewLocation2.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        lblViewLocation2.setText("<location>");
        jPanel9.add(lblViewLocation2, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 338, 170, 24));

        jTabbedPane1.addTab("Events", jPanel9);

        jPanel10.setBackground(new java.awt.Color(255, 255, 204));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(153, 0, 0));
        jLabel20.setText("** Services are appointment based ONLY. Please call your to reschedule.");
        jPanel10.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 699, 975, 20));

        jLabel29.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(153, 0, 0));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("MindFit Appointment Details");
        jPanel10.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, 975, -1));

        tblMindfitAppoinments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Session no.", "Date", "Time", "Instructor type", "Session status"
            }
        ));
        tblMindfitAppoinments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMindfitAppoinmentsMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tblMindfitAppoinments);

        jPanel10.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 89, 900, 119));

        lblInstructorName.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblInstructorName.setText("Instructor Name:");
        jPanel10.add(lblInstructorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 228, 167, 33));

        txtInstructorName.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        txtInstructorName.setText("<instructor name>");
        jPanel10.add(txtInstructorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 225, 213, 36));

        lblInstSpeciality.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblInstSpeciality.setText("Specialty:");
        jPanel10.add(lblInstSpeciality, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 273, 167, 28));

        txtInstructorSpeciality.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        txtInstructorSpeciality.setText("<specialty- yoga/nutrition>");
        jPanel10.add(txtInstructorSpeciality, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 272, 213, 30));

        lblInstPhone.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblInstPhone.setText("Contact no.:");
        jPanel10.add(lblInstPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 313, 167, 33));

        txtInstPhone.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        txtInstPhone.setText("<contactNo>");
        jPanel10.add(txtInstPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 313, 213, 33));

        jLabel36.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel36.setText("Past appointments:");
        jPanel10.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 55, -1, 23));

        tblYoga.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane9.setViewportView(tblYoga);

        jPanel10.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 403, 398, 102));

        jLabel37.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel37.setText("Select new Yoga Instructor:");
        jPanel10.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 355, -1, 30));

        tblNutritionist.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane10.setViewportView(tblNutritionist);

        jPanel10.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 566, 400, 102));

        jLabel38.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel38.setText("Select new Nutritionist:");
        jPanel10.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 523, 220, 25));

        btnBookYoga.setText("Request Yoga Instructor");
        btnBookYoga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookYogaActionPerformed(evt);
            }
        });
        jPanel10.add(btnBookYoga, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 470, -1, -1));

        btnBookNutritionist.setText("Request Nutritionist");
        btnBookNutritionist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookNutritionistActionPerformed(evt);
            }
        });
        jPanel10.add(btnBookNutritionist, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 645, 151, -1));

        btnBookYoga2.setText("Refresh");
        btnBookYoga2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookYoga2ActionPerformed(evt);
            }
        });
        jPanel10.add(btnBookYoga2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 220, -1, -1));

        jTabbedPane1.addTab("MindFit", jPanel10);

        jPanel6.setBackground(new java.awt.Color(255, 255, 204));
        jPanel6.setPreferredSize(new java.awt.Dimension(975, 600));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Welcome to Pawsitive!");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, 975, 28));

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

        jPanel6.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 93, 834, 92));

        jLabel28.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel28.setText("Breed:");
        jPanel6.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 206, 139, 26));

        jLabel30.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel30.setText("Favourite food:");
        jPanel6.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 240, 139, 26));

        jLabel31.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel31.setText("Age:");
        jPanel6.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 317, 139, -1));
        jPanel6.add(txtPbreed, new org.netbeans.lib.awtextra.AbsoluteConstraints(469, 208, 163, 26));

        txtplikes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtplikesActionPerformed(evt);
            }
        });
        jPanel6.add(txtplikes, new org.netbeans.lib.awtextra.AbsoluteConstraints(469, 279, 163, 27));

        lblPetPhoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPetPhoto.setText("Dog photo");
        lblPetPhoto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.add(lblPetPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 191, 152, 153));

        jLabel33.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(153, 0, 0));
        jLabel33.setText("Book To Pet!");
        jPanel6.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 362, 103, 24));

        btnBookPet.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnBookPet.setText("Click to book");
        btnBookPet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookPetActionPerformed(evt);
            }
        });
        jPanel6.add(btnBookPet, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 484, 159, -1));

        txtPfood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPfoodActionPerformed(evt);
            }
        });
        jPanel6.add(txtPfood, new org.netbeans.lib.awtextra.AbsoluteConstraints(469, 240, 163, 26));
        jPanel6.add(calendarSession, new org.netbeans.lib.awtextra.AbsoluteConstraints(394, 362, 382, 235));

        cbcSlot1.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        cbcSlot1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Slot", "8:00 ", "9:00 ", "10:00 ", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00","17:00","18:00","19:00","20:00","21:00" }));
        jPanel6.add(cbcSlot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 440, 159, -1));
        jPanel6.add(txtDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 406, 159, 25));

        lblDate.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblDate.setText("Select date and time:");
        jPanel6.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 404, 186, 25));

        jLabel39.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel39.setText("Favourite activity:");
        jPanel6.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 277, -1, 27));

        txtpage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpageActionPerformed(evt);
            }
        });
        jPanel6.add(txtpage, new org.netbeans.lib.awtextra.AbsoluteConstraints(469, 315, 163, 27));

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

        jPanel6.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 615, 836, 92));

        btnRefreshpetApp.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnRefreshpetApp.setText("Refresh Table");
        btnRefreshpetApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshpetAppActionPerformed(evt);
            }
        });
        jPanel6.add(btnRefreshpetApp, new org.netbeans.lib.awtextra.AbsoluteConstraints(718, 196, -1, -1));

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel15.setText("Appointment details:");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 570, -1, 27));

        jLabel25.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(153, 0, 51));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Boost your serotonin levels with the help of our furry friends! ");
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 57, 975, -1));

        jTabbedPane1.addTab("Pet Therapy", jPanel6);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
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
        lblForumDescription.setText(system.getUniversitydirectory().getForumqueue().retrieveForum(Integer.parseInt(forumid)).getDescription());
        
        
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

    private void cmbQues4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbQues4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbQues4ActionPerformed

    private void btnBookYogaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookYogaActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel modelOrder = (DefaultTableModel)tblYoga.getModel();
        int selectedIndex = tblYoga.getSelectedRow();
        String eventid=null;
        if(selectedIndex==-1){
            
            JOptionPane.showMessageDialog(this, "Please Select an Instructor");
            return;
            
        }
        //String createdby=null;
        if(selectedIndex!=-1){
            
             eventid = modelOrder.getValueAt(selectedIndex, 0).toString();
             
             //createdby = modelOrder.getValueAt(selectedIndex, 2).toString();
        }
        
        YogaRequest yogareq = yogarequestqueue.addYogaRequest();
        
        yogareq.setYogaid(eventid);
        yogareq.setStudentid(student.getId());
        Date date = new Date();
        yogareq.setDate(date);
        
        JOptionPane.showMessageDialog(this, "Requested! Please check appointment table for updates");
    }//GEN-LAST:event_btnBookYogaActionPerformed

    private void btnBookNutritionistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookNutritionistActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel modelOrder = (DefaultTableModel)tblNutritionist.getModel();
        int selectedIndex = tblNutritionist.getSelectedRow();
        String eventid=null;
        if(selectedIndex==-1){
            
            JOptionPane.showMessageDialog(this, "Please Select a Nutritionist");
            return;
            
        }
        //String createdby=null;
        if(selectedIndex!=-1){
            
             eventid = modelOrder.getValueAt(selectedIndex, 0).toString();
             
             //createdby = modelOrder.getValueAt(selectedIndex, 2).toString();
        }
        
        NutritionRequest yogareq = nutrirequestqueue.addNutritionRequest();
        
        yogareq.setYogaid(eventid);
        yogareq.setStudentid(student.getId());
        Date date = new Date();
        yogareq.setDate(date);
        
        JOptionPane.showMessageDialog(this, "Requested! Please check appointment table for updates");
        
    }//GEN-LAST:event_btnBookNutritionistActionPerformed

    private void tblMindfitAppoinmentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMindfitAppoinmentsMouseClicked
        // TODO add your handling code here:
        
        DefaultTableModel modelOrder = (DefaultTableModel)tblMindfitAppoinments.getModel();
        int selectedIndex = tblMindfitAppoinments.getSelectedRow();
        String petid=null;
        String type=null;
        
        if(selectedIndex==-1){
            
            JOptionPane.showMessageDialog(this, "Please Select a dog");
            return;
            
        }
        //String createdby=null;
        if(selectedIndex!=-1){
            
             petid = modelOrder.getValueAt(selectedIndex, 0).toString();
             type = modelOrder.getValueAt(selectedIndex, 3).toString();
             
             
             
             //createdby = modelOrder.getValueAt(selectedIndex, 2).toString();
        }
        
        int id = Integer.parseInt(petid);
        
        if(type== "Yoga Instructor"){
            
            YogaInstructor yoga = yogadir.RetrieveYogaInstructor(yogaqueue.retrieveYogaAppointment(id).getYogaid());
            
            txtInstructorName.setText(yoga.getName());
            txtInstructorSpeciality.setText(yoga.getSpeciality());
            txtInstPhone.setText(yoga.getPhone());
        }
        
        if(type== "Nutritionist"){
            
            Nutritionist yoga = nutridir.RetrieveNutritionist(nutriqueue.retrieveNutritionistAppointment(id).getNutritionistid());
            
            txtInstructorName.setText(yoga.getName());
            txtInstructorSpeciality.setText(yoga.getSpeciality());
            txtInstPhone.setText(yoga.getPhone());
        }
    }//GEN-LAST:event_tblMindfitAppoinmentsMouseClicked

    private void btnBookYoga2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookYoga2ActionPerformed
        // TODO add your handling code here:
        populateMindFitAppointments();
        populateYogaInstructors();
    }//GEN-LAST:event_btnBookYoga2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBookNutritionist;
    private javax.swing.JButton btnBookPet;
    private javax.swing.JButton btnBookYoga;
    private javax.swing.JButton btnBookYoga2;
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
    private javax.swing.JLabel jLabel24;
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
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
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
    private javax.swing.JTable tblEvents;
    private javax.swing.JTable tblForums;
    private javax.swing.JTable tblMindfitAppoinments;
    private javax.swing.JTable tblNutritionist;
    private javax.swing.JTable tblPet;
    private javax.swing.JTable tblPetAppointments;
    private javax.swing.JTable tblPosts;
    private javax.swing.JTable tblYoga;
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
