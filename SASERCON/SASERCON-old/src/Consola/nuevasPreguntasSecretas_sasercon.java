/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consola;

import javax.swing.JOptionPane;

/**
 *
 * @author darki
 */
public class nuevasPreguntasSecretas_sasercon extends javax.swing.JFrame {

    /**
     * Creates new form nuevasPreguntasSecretas_sasercon
     */
    public nuevasPreguntasSecretas_sasercon() {
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

        jcMousePanel1 = new jcMousePanel.jcMousePanel();
        comboPre1 = new javax.swing.JComboBox<>();
        comboPre2 = new javax.swing.JComboBox<>();
        jcMousePanel2 = new jcMousePanel.jcMousePanel();
        jLabel1 = new javax.swing.JLabel();
        txtPre1 = new javax.swing.JTextField();
        txtPre2 = new javax.swing.JTextField();
        btnGuardarPre = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jcMousePanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SASERCON/Fondo.jpeg"))); // NOI18N
        jcMousePanel1.setVisibleLogo(false);

        comboPre1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pregunta 1", "¿Como se llama tu equipo favorito?", "¿Cual es tu libro infantil favorito?", "¿Cual seria tu trabajo ideal?" }));

        comboPre2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pregunta 2", "¿Como se llamaba tu primer animal de compañia?", "¿Nombre de la calle donde vivias cuando eras niño?", "¿Cual era el nombre de pila de tu mejor amigo de la escuela?" }));

        jcMousePanel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SASERCON/Logo.jpeg"))); // NOI18N
        jcMousePanel2.setVisibleLogo(false);

        javax.swing.GroupLayout jcMousePanel2Layout = new javax.swing.GroupLayout(jcMousePanel2);
        jcMousePanel2.setLayout(jcMousePanel2Layout);
        jcMousePanel2Layout.setHorizontalGroup(
            jcMousePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jcMousePanel2Layout.setVerticalGroup(
            jcMousePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        jLabel1.setText("Seleccione dos nuevas preguntas secretas");

        btnGuardarPre.setText("Guardar preguntas");
        btnGuardarPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarPreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jcMousePanel1Layout = new javax.swing.GroupLayout(jcMousePanel1);
        jcMousePanel1.setLayout(jcMousePanel1Layout);
        jcMousePanel1Layout.setHorizontalGroup(
            jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jcMousePanel1Layout.createSequentialGroup()
                .addGap(0, 224, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(211, 211, 211))
            .addGroup(jcMousePanel1Layout.createSequentialGroup()
                .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jcMousePanel1Layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboPre1, 0, 195, Short.MAX_VALUE)
                            .addComponent(comboPre2, 0, 0, Short.MAX_VALUE)))
                    .addGroup(jcMousePanel1Layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(jcMousePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jcMousePanel1Layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPre1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                            .addComponent(txtPre2)))
                    .addGroup(jcMousePanel1Layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(btnGuardarPre)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jcMousePanel1Layout.setVerticalGroup(
            jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcMousePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcMousePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(comboPre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtPre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(comboPre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtPre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGuardarPre)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPreActionPerformed
        // TODO add your handling code here:
           String[] nuevapregunta = new String[4];
           nuevapregunta[0]="";
           nuevapregunta[1]="";
           nuevapregunta[2]="";
           nuevapregunta[3]="";
           
       this.txtPre1.getText();
       this.txtPre2.getText();
       this.comboPre1.getSelectedItem();
       this.comboPre2.getSelectedItem();
                nuevapregunta[0] = this.comboPre1.getItemAt(WIDTH);
                JOptionPane.showMessageDialog(rootPane,"Nueva pregunta 1 guardada : "+nuevapregunta[0]);
                nuevapregunta[1] = this.txtPre1.getText();
                JOptionPane.showMessageDialog(rootPane,"Nueva respuesta 2 guardada : "+nuevapregunta[1]);
                nuevapregunta[2] = this.comboPre2.getItemAt(WIDTH);
                JOptionPane.showMessageDialog(rootPane,"Nueva pregunta 2 guardada : "+nuevapregunta[2]);
                nuevapregunta[3] = this.txtPre2.getText();
                JOptionPane.showMessageDialog(rootPane,"Nueva respuesta 2 guardada : "+nuevapregunta[3]);
                JOptionPane.showMessageDialog(null, "Bienvendio usuario al menu");
    this.dispose();
    }//GEN-LAST:event_btnGuardarPreActionPerformed

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
            java.util.logging.Logger.getLogger(nuevasPreguntasSecretas_sasercon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(nuevasPreguntasSecretas_sasercon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(nuevasPreguntasSecretas_sasercon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(nuevasPreguntasSecretas_sasercon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new nuevasPreguntasSecretas_sasercon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarPre;
    private javax.swing.JComboBox<String> comboPre1;
    private javax.swing.JComboBox<String> comboPre2;
    private javax.swing.JLabel jLabel1;
    private jcMousePanel.jcMousePanel jcMousePanel1;
    private jcMousePanel.jcMousePanel jcMousePanel2;
    private javax.swing.JTextField txtPre1;
    private javax.swing.JTextField txtPre2;
    // End of variables declaration//GEN-END:variables
}
