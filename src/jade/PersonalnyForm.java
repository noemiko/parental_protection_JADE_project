package jade;

import jade.core.Agent;
import jade.core.AID;
import jade.lang.acl.ACLMessage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;



public class PersonalnyForm extends javax.swing.JFrame {

    private Personalny myAgent;    
    private FileRules file;
    private DefaultListModel ds = new DefaultListModel();
    
    public PersonalnyForm(Personalny a) {
        myAgent = a;
        initComponents();
    }
    
    public void showGui() {
        super.setVisible(true);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ruleInput = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        RulesList = new javax.swing.JList<>();
        AddRule = new javax.swing.JButton();
        DeleteRule = new javax.swing.JButton();
        RunBrowserHistoryDetector = new javax.swing.JButton();
        LoadRulesFromFile = new javax.swing.JButton();
        saveRules = new javax.swing.JButton();
        informLabel = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ruleInput.setText("Add rule");
        ruleInput.setToolTipText("");
        ruleInput.setName("ruleInput"); // NOI18N

        jLabel6.setText("Write your new rule");

        RulesList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RulesListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(RulesList);

        AddRule.setText("Add");
        AddRule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddRuleActionPerformed(evt);
            }
        });

        DeleteRule.setText("Delete");
        DeleteRule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteRuleActionPerformed(evt);
            }
        });

        RunBrowserHistoryDetector.setText("Run browser history detector");
        RunBrowserHistoryDetector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RunBrowserHistoryDetectorActionPerformed(evt);
            }
        });

        LoadRulesFromFile.setText("Load previous rules");
        LoadRulesFromFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadRulesFromFileActionPerformed(evt);
            }
        });

        saveRules.setText("Save new rules");
        saveRules.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveRulesActionPerformed(evt);
            }
        });

        informLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        informLabel.setText("Input new rules or get previous");
        informLabel.setToolTipText("");
        informLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        informLabel.setAutoscrolls(true);
        informLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel1.setText("Input email here");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ruleInput)
                .addContainerGap())
            .addComponent(LoadRulesFromFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(RunBrowserHistoryDetector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(saveRules, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AddRule, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DeleteRule, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(informLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(informLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(RunBrowserHistoryDetector, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LoadRulesFromFile, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveRules, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ruleInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddRule, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteRule, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)))
        );

        ruleInput.getAccessibleContext().setAccessibleName("ruleInput");
        jLabel6.getAccessibleContext().setAccessibleName("Wprowadź zabronione słowa kluczowe");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void DeleteRuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteRuleActionPerformed
        int index = RulesList.getSelectedIndex();
        ds.removeElementAt(index);
    }//GEN-LAST:event_DeleteRuleActionPerformed

    
    private void add(String rule){
        if (!"".equals(rule)){
        RulesList.setModel(ds);
        ds.addElement(rule);
        }

    }
    private void AddRuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddRuleActionPerformed
       add(ruleInput.getText());
       //clear input
       ruleInput.setText("");
    }//GEN-LAST:event_AddRuleActionPerformed

    private void RulesListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RulesListMouseClicked
       String selected = RulesList.getSelectedValue().toString();
    }//GEN-LAST:event_RulesListMouseClicked

    private void RunBrowserHistoryDetectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RunBrowserHistoryDetectorActionPerformed

        int quantityOfRules = RulesList.getModel().getSize();
        String[] allRules = new String[quantityOfRules];
        for (int i = 0; i < quantityOfRules; i++) {
                 allRules[i] = String.valueOf(RulesList.getModel().getElementAt(i));
            }
        System.out.println(allRules);
        myAgent.startHistoryDetector(allRules); 
        informLabel.setText("If anything will be detected. \n"
                + "You will get an email.");

    }//GEN-LAST:event_RunBrowserHistoryDetectorActionPerformed

    private void LoadRulesFromFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadRulesFromFileActionPerformed
        RulesList.setModel(ds);
        ds.removeAllElements();
        String[] rulesFromFile = myAgent.readFileRules();
            RulesList.setModel(ds);
               for (int i = 0; i < rulesFromFile.length; i++) {
                   System.out.println(rulesFromFile[i]);
                 ds.addElement(rulesFromFile[i]);
            }
       informLabel.setText("Rules loaded");
    }//GEN-LAST:event_LoadRulesFromFileActionPerformed

    private void saveRulesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveRulesActionPerformed
        int quantityOfRules = RulesList.getModel().getSize();
        String[] allRules = new String[quantityOfRules];
        for (int i = 0; i < quantityOfRules; i++) {
                 allRules[i] = String.valueOf(RulesList.getModel().getElementAt(i));
            }
        myAgent.saveFileRules(allRules);
        informLabel.setText("Rules saved");
    }//GEN-LAST:event_saveRulesActionPerformed


    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PersonalnyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PersonalnyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PersonalnyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PersonalnyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new projektForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddRule;
    private javax.swing.JButton DeleteRule;
    private javax.swing.JButton LoadRulesFromFile;
    private javax.swing.JList<String> RulesList;
    private javax.swing.JButton RunBrowserHistoryDetector;
    private javax.swing.JLabel informLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField ruleInput;
    private javax.swing.JButton saveRules;
    // End of variables declaration//GEN-END:variables
}
