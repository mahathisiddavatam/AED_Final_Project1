/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.TherapistRole.TherapistAreaJPanel;
import userinterface.UniversityAdminRole.UniversityAdminWorkAreaJPanel;

/**
 *
 * @author Varakumar
 */
public class UniversityAdminRole extends Role {
    
     @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, EcoSystem business) {
        return new UniversityAdminWorkAreaJPanel(userProcessContainer, account,business);
    }
    
}
