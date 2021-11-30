/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;

import Business.Organisation;
import Business.UserAccount.UserAccount;
import userinterface.TherapistRole.TherapistAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public class TherapistRole extends Role{
    
    

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, EcoSystem business) {
        return new TherapistAreaJPanel(userProcessContainer, account,business);
    }
    
    
}
