/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Autotective.UI;

/**
 *
 * @author ege
 */
public class EngineerUI extends javax.swing.JFrame {
    CarInventoryUI carInventoryWindow;
    SensorsUI sensorReportWindow;
    TestsUI testHistoryWindow;
    AddTesterUI addTesterWindow;
    

    /**
     * Creates new form EngineerUI
     */
    public EngineerUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        queryAllButton = new javax.swing.JButton();
        sessionsButton = new javax.swing.JButton();
        sensorCheckButton = new javax.swing.JButton();
        addTesterButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        jLabel1.setText("Welcome Engineer,");

        queryAllButton.setText("Car Inventory");
        queryAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryAllButtonActionPerformed(evt);
            }
        });

        sessionsButton.setText("See tests conducted");
        sessionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sessionsButtonActionPerformed(evt);
            }
        });

        sensorCheckButton.setText("Sensors Report");
        sensorCheckButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sensorCheckButtonActionPerformed(evt);
            }
        });

        addTesterButton.setText("Add Tester");
        addTesterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTesterButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sessionsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sensorCheckButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addTesterButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(queryAllButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(329, 329, 329))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jLabel1)
                .addGap(155, 155, 155)
                .addComponent(queryAllButton)
                .addGap(18, 18, 18)
                .addComponent(sessionsButton)
                .addGap(18, 18, 18)
                .addComponent(sensorCheckButton)
                .addGap(18, 18, 18)
                .addComponent(addTesterButton)
                .addContainerGap(164, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Goes to TestHistory Window, creates a new one if it is NULL
    private void sessionsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sessionsButtonActionPerformed
        
        if(testHistoryWindow == null){
        testHistoryWindow = new TestsUI();}
        testHistoryWindow.backWindow = this;
        testHistoryWindow.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_sessionsButtonActionPerformed

    // Goes to Car Query Window, creates a new one if it is NULL
    private void queryAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queryAllButtonActionPerformed
        
        if(carInventoryWindow == null){
        carInventoryWindow = new CarInventoryUI();}
        carInventoryWindow.backWindow = this;
        carInventoryWindow.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_queryAllButtonActionPerformed

    // Goes to Sensor Report Window, creates a new one if it is NULL
    private void sensorCheckButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sensorCheckButtonActionPerformed
        
        if(sensorReportWindow == null){
        sensorReportWindow = new SensorsUI();}
        sensorReportWindow.backWindow = this;
        sensorReportWindow.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_sensorCheckButtonActionPerformed

    
    // Goes to Tester Add Window, creates a new one if it is NULL
    private void addTesterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTesterButtonActionPerformed
        if(addTesterWindow == null){
        addTesterWindow = new AddTesterUI();}
        addTesterWindow.backWindow = this;
        addTesterWindow.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_addTesterButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(EngineerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EngineerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EngineerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EngineerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EngineerUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTesterButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton queryAllButton;
    private javax.swing.JButton sensorCheckButton;
    private javax.swing.JButton sessionsButton;
    // End of variables declaration//GEN-END:variables
}