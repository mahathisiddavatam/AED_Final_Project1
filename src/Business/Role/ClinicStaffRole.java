/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;

import Business.Organisation;
import Business.UserAccount.UserAccount;
import userinterface.ClinicStaffRole.ClinicStaffWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public class ClinicStaffRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, EcoSystem business) {
        return new ClinicStaffWorkAreaJPanel(userProcessContainer,business,account);
    }

    
    
}
