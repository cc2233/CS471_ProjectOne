
package meterconverter;

/**
 *
 * @author Caroline Chey CSC201
 */
public class MeterConverter2 extends javax.swing.JFrame {

    public MeterConverter2() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtm = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtresult = new javax.swing.JTextField();
        menu = new javax.swing.JMenuBar();
        menuconvert = new javax.swing.JMenu();
        mtokm = new javax.swing.JMenuItem();
        mtoin = new javax.swing.JMenuItem();
        mtoft = new javax.swing.JMenuItem();
        quit = new javax.swing.JMenuItem();
        clear = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(255, 153, 51));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("Meter Converter");
        jLabel1.setBorder(new javax.swing.border.MatteBorder(null));
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setDoubleBuffered(true);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setRequestFocusEnabled(false);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Please enter a number in meters.");

        txtm.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Result :");

        menuconvert.setText("Convert");

        mtokm.setText("1. m to km");
        mtokm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mtokmActionPerformed(evt);
            }
        });
        menuconvert.add(mtokm);

        mtoin.setText("2. m to in");
        mtoin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mtoinActionPerformed(evt);
            }
        });
        menuconvert.add(mtoin);

        mtoft.setText("3. m to ft");
        mtoft.setToolTipText("");
        mtoft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mtoftActionPerformed(evt);
            }
        });
        menuconvert.add(mtoft);

        quit.setText("4. Quit Program");
        quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitActionPerformed(evt);
            }
        });
        menuconvert.add(quit);

        clear.setText("5. Clear ");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        menuconvert.add(clear);

        menu.add(menuconvert);
        menuconvert.getAccessibleContext().setAccessibleParent(null);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(186, 186, 186))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtresult, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtm, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtresult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // clears textfields
        txtm.setText("");
        txtresult.setText("");
           
    }//GEN-LAST:event_clearActionPerformed

    private void quitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitActionPerformed
        // exits program
        System.exit(0);
    }//GEN-LAST:event_quitActionPerformed

    private void mtokmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mtokmActionPerformed
        // converts meters to kilometers
        double m = 0; //meters
        double km = 0; //kilometers
        String resultkm = "";
        
        m = Double.parseDouble(txtm.getText());
        if(m>0)
        {
            km = m*0.001;
            resultkm = km + " kilometers";
            txtresult.setText(m + " meters = " + resultkm);
        }
        else
        {
            txtresult.setText("Please clear and enter a positive number.");
        
        }
        
    }//GEN-LAST:event_mtokmActionPerformed

    private void mtoinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mtoinActionPerformed
        // converts meters to inches
        double m = 0; //meters
        double in = 0; //inches
        String resultin = "";
        m = Double.parseDouble(txtm.getText());
        if(m>0)
        {
            in = m*39.37;
            resultin = in + " inches";
            txtresult.setText(m + " meters = " + resultin);
        }
        else
        {
            txtresult.setText("Please clear and enter a positive number.");
        
        }
        
    }//GEN-LAST:event_mtoinActionPerformed

    private void mtoftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mtoftActionPerformed
        // converts meters to feet
        double m = 0; //meters
        double ft = 0; //feet
        String resultft = "";
        m = Double.parseDouble(txtm.getText());
        if(m>0)
        {
            ft = m*3.281;
            resultft = ft + " feet";
            txtresult.setText(m + " meters = " + resultft);
        }
        else
        {
            txtresult.setText("Please clear and enter a positive number.");
        
        }
    }//GEN-LAST:event_mtoftActionPerformed

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
            java.util.logging.Logger.getLogger(MeterConverter2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MeterConverter2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MeterConverter2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MeterConverter2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MeterConverter2().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem clear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menuconvert;
    private javax.swing.JMenuItem mtoft;
    private javax.swing.JMenuItem mtoin;
    private javax.swing.JMenuItem mtokm;
    private javax.swing.JMenuItem quit;
    private javax.swing.JTextField txtm;
    private javax.swing.JTextField txtresult;
    // End of variables declaration//GEN-END:variables
}
