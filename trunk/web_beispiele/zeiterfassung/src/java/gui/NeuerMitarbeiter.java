/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NeuerMitarbeiter.java
 *
 * Created on 11.03.2011, 19:18:01
 */

package gui;

import fachlogik.Mitarbeiter;
import fachlogik.Zeiterfassung;
import fachlogik.ZeiterfassungException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Rudi
 */
public class NeuerMitarbeiter extends javax.swing.JDialog {
    private DefaultListModel model;
    private Zeiterfassung zeiterfassung;

    /** Creates new form NeuerMitarbeiter */
    public NeuerMitarbeiter(java.awt.Frame parent, boolean modal, DefaultListModel model, Zeiterfassung z) {
        super(parent, modal);
        this.model = model;
        zeiterfassung = z;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfStunden = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pfPwd = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        bnSpeichern = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(0, 2));

        jLabel1.setText("Name");
        getContentPane().add(jLabel1);
        getContentPane().add(tfName);

        jLabel2.setText("Wochenstunden");
        getContentPane().add(jLabel2);
        getContentPane().add(tfStunden);

        jLabel3.setText("Kennwort");
        getContentPane().add(jLabel3);
        getContentPane().add(pfPwd);
        getContentPane().add(jLabel4);

        bnSpeichern.setText("Speichern");
        bnSpeichern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                speichern(evt);
            }
        });
        getContentPane().add(bnSpeichern);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void speichern(java.awt.event.ActionEvent evt)//GEN-FIRST:event_speichern
    {//GEN-HEADEREND:event_speichern
        try
        {
            Mitarbeiter m = new Mitarbeiter();
            m.setName(tfName.getText());
            m.setPwd(new String(pfPwd.getPassword()));
            m.setStunden(Integer.parseInt(tfStunden.getText()));
            zeiterfassung.speichern(m);
            model.addElement(m);
            dispose();
        } catch (ZeiterfassungException ex)
        {
            Logger.getLogger(NeuerMitarbeiter.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this, "Bitte bei Stunden eine Ganzzahl eingeben");
        }
    }//GEN-LAST:event_speichern

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnSpeichern;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField pfPwd;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfStunden;
    // End of variables declaration//GEN-END:variables

}
