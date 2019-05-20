/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author coner
 */
public class IngresarEmpleado extends javax.swing.JFrame {

public String IEmatricula;
public String IEcorreo;
public String IEnombre_de_empleado;
public String IEapellido_paterno_empleado;
public String IEapellido_materno_empleado;
public int IEempresa;
protected String IEdireccion;
protected String IEcurp;
protected String IErfc;
protected String IEnss;
public String IEcelular;
public String IEtelefono;
protected String IEtelefono_de_emergencia;
protected String IEnombre_del_contacto;
protected String IEapellido_paterno_contacto;
protected String IEapellido_materno_contacto;
protected String IEcorreo_del_contacto;
protected boolean IEvigente;

    /**
     * Creates new form ingresarEmpleado
     */
    public IngresarEmpleado() {
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
        txtIEmatricula = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtIEnombre_de_empleado = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtIEcorreo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cboxIEempresa = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtIEdireccion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtIEcurp = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtIErfc = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtIEnss = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtIEcelular = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtIEtelefono = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtIEtelefono_de_emergencia = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtIEnombre_del_contacto = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtIEcorreo_del_contacto = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        lblIEno_vigente = new javax.swing.JLabel();
        tgbIEvigente = new javax.swing.JToggleButton();
        lblIEvigente = new javax.swing.JLabel();
        btnIEguardar = new javax.swing.JButton();
        btnIEcancelar = new javax.swing.JButton();
        btnIEfoto = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtIEapellido_paterno_empleado = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtIEapellido_materno_empleado = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtIEapellido_paterno_contacto = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtIEapellido_materno_contacto = new javax.swing.JTextField();
        btnIEregresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingresar Empleado"));

        jLabel1.setText("Matrícula:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Correo:");

        jLabel4.setText("Empresa:");

        cboxIEempresa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Empresa" }));

        jLabel5.setText("Dirección:");

        jLabel6.setText("CURP:");

        jLabel7.setText("RFC:");

        jLabel8.setText("NSS:");

        jLabel9.setText("Teléfono celular:");

        jLabel10.setText("Teléfono:");

        txtIEtelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIEtelefonoActionPerformed(evt);
            }
        });

        jLabel11.setText("Teléfono emergencia:");

        jLabel12.setText("Nombre de contacto:");

        jLabel13.setText("Correo de contacto:");

        jLabel14.setText("Status:");

        lblIEno_vigente.setText("No vigente");

        tgbIEvigente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ic_check_box_grey600_18dp.png"))); // NOI18N
        tgbIEvigente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tgbIEvigenteActionPerformed(evt);
            }
        });

        lblIEvigente.setText("Vigente");

        btnIEguardar.setText("Guardar");
        btnIEguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIEguardarActionPerformed(evt);
            }
        });

        btnIEcancelar.setText("Cancelar");
        btnIEcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIEcancelarActionPerformed(evt);
            }
        });

        btnIEfoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ic_assignment_ind_grey600_36dp.png"))); // NOI18N
        btnIEfoto.setText("Foto");
        btnIEfoto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnIEfoto.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnIEfoto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel15.setText("Apellido Paterno:");

        jLabel16.setText("Apellido Materno:");

        jLabel17.setText("Apellido Paterno:");

        jLabel18.setText("Apellido Materno:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIEcorreo_del_contacto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel14)
                                .addGap(33, 33, 33)
                                .addComponent(lblIEno_vigente)
                                .addGap(18, 18, 18)
                                .addComponent(tgbIEvigente, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblIEvigente)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIEapellido_paterno_contacto, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIEapellido_materno_contacto, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtIEmatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtIEnombre_de_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtIEcelular, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtIEtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtIEtelefono_de_emergencia, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtIEnombre_del_contacto, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtIEdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cboxIEempresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtIEnss))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtIErfc))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtIEcurp, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtIEcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(34, 34, 34))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIEapellido_paterno_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIEapellido_materno_empleado)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnIEcancelar)
                                .addGap(29, 29, 29)
                                .addComponent(btnIEguardar))
                            .addComponent(btnIEfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnIEfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 356, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIEcancelar)
                    .addComponent(btnIEguardar))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIEmatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIEnombre_de_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtIEapellido_paterno_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txtIEapellido_materno_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtIEcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboxIEempresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtIEdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtIEcurp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtIErfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtIEnss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtIEcelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtIEtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtIEtelefono_de_emergencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtIEnombre_del_contacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtIEapellido_paterno_contacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(txtIEapellido_materno_contacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtIEcorreo_del_contacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tgbIEvigente, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIEvigente)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(lblIEno_vigente)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnIEregresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ic_arrow_back_grey600_18dp.png"))); // NOI18N
        btnIEregresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIEregresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnIEregresar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btnIEregresar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIEtelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIEtelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIEtelefonoActionPerformed

    private void tgbIEvigenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tgbIEvigenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tgbIEvigenteActionPerformed

    private void btnIEguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIEguardarActionPerformed
        IEmatricula = this.txtIEmatricula.getText().trim();
        IEcorreo = this.txtIEcorreo.getText().trim();
        IEnombre_de_empleado = this.txtIEnombre_de_empleado.getText().trim();
        IEapellido_paterno_empleado = this.txtIEapellido_paterno_empleado.getText().trim();
        IEapellido_materno_empleado = this.txtIEapellido_materno_empleado.getText().trim();
        IEempresa = this.cboxIEempresa.getSelectedIndex();
        IEdireccion = this.txtIEdireccion.getText().trim();
        IEcurp = this.txtIEcurp.getText().trim();
        IErfc = this.txtIErfc.getText().trim();
        IEnss = this.txtIEnss.getText().trim();
        IEcelular = this.txtIEcelular.getText().trim();
        IEtelefono = this.txtIEtelefono.getText().trim();
        IEtelefono_de_emergencia = this.txtIEtelefono_de_emergencia.getText().trim();
        IEnombre_del_contacto = this.txtIEnombre_del_contacto.getText().trim();
        IEapellido_paterno_contacto = this.txtIEapellido_paterno_contacto.getText().trim();
        IEapellido_materno_contacto = this.txtIEapellido_materno_contacto.getText().trim();
        IEcorreo_del_contacto = this.txtIEcorreo_del_contacto.getText().trim();
        IEvigente = this.tgbIEvigente.isSelected();
        
        if(this.txtIEcelular.getText().trim().equals(""))    {
            JOptionPane.showOptionDialog(this, "No se puede dejar campos vacíos", "Error System Information", JOptionPane.ERROR_MESSAGE, HEIGHT, null, new Object[]{" Aceptar "},"Cancelar");
        }
        else    {
            ingresar();
        }
    }//GEN-LAST:event_btnIEguardarActionPerformed

    public void ingresar()  {
        IEmatricula = this.txtIEmatricula.getText().trim();
        IEcorreo = this.txtIEcorreo.getText().trim();
        IEnombre_de_empleado = this.txtIEnombre_de_empleado.getText().trim();
        IEapellido_paterno_empleado = this.txtIEapellido_paterno_empleado.getText().trim();
        IEapellido_materno_empleado = this.txtIEapellido_materno_empleado.getText().trim();
        IEempresa = this.cboxIEempresa.getSelectedIndex();
        IEdireccion = this.txtIEdireccion.getText().trim();
        IEcurp = this.txtIEcurp.getText().trim();
        IErfc = this.txtIErfc.getText().trim();
        IEnss = this.txtIEnss.getText().trim();
        IEcelular = this.txtIEcelular.getText().trim();
        IEtelefono = this.txtIEtelefono.getText().trim();
        IEtelefono_de_emergencia = this.txtIEtelefono_de_emergencia.getText().trim();
        IEnombre_del_contacto = this.txtIEnombre_del_contacto.getText().trim();
        IEapellido_paterno_contacto = this.txtIEapellido_paterno_contacto.getText().trim();
        IEapellido_materno_contacto = this.txtIEapellido_materno_contacto.getText().trim();
        IEcorreo_del_contacto = this.txtIEcorreo_del_contacto.getText().trim();
        IEvigente = this.tgbIEvigente.isSelected();
        
        ConexionMySQL cmysql = new ConexionMySQL();
        Connection conec = (Connection) cmysql.Conectar();
        
        String senSQL;
        senSQL = "INSERT INTO empleado (matricula,nombreEmpleado,ApellidoPaternoEmpleado,apellidoMaternoEmpleado,empresa,puesto,contraseña,curp,numeroSeguroSocial,telefonoEmergencia,nombreContacto,apellidoPaternoContacto,apellidoMaternoContacto,correoContacto,estadoActivo,telefono) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps;
            ps = conec.prepareStatement(senSQL);
            ps.setString(1,IEmatricula);
            ps.setString(2,IEcorreo);
            ps.setString(3,IEnombre_de_empleado);
            ps.setString(4,IEapellido_paterno_empleado);
            ps.setString(5,IEapellido_materno_empleado);
            ps.setString(6,IEempresa);
            ps.setString(7,IEdireccion);
            ps.setString(8,IEcurp);
            ps.setString(9,IErfc);
            ps.setString(10,IEnss);
            ps.setString(11,IEcelular);
            ps.setString(12,IEtelefono);
            ps.setString(13,IEtelefono_de_emergencia);
            ps.setString(14,IEnombre_del_contacto);
            ps.setString(15,IEapellido_paterno_contacto);
            ps.setString(16,IEapellido_materno_contacto);
            ps.setString(17,IEcorreo_del_contacto);
            ps.setString(18,IEvigente);
            int n = ps.executeUpdate();
            if (n > 0)  {
                vaciar();
                JOptionPane.showOptionDialog(this, "Se han guardado sus datos satisfactoriamente",
                        "MySQL Information", JOptionPane.INFORMATION_MESSAGE,
                        JOptionPane.INFORMATION_MESSAGE, null, new Object[]{" 0K "},"0K");

            }
        }
        catch( SQLException ex )    {
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    
    private void btnIEcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIEcancelarActionPerformed
        vaciar();
    }//GEN-LAST:event_btnIEcancelarActionPerformed

    public void vaciar() {
        this.txtIEmatricula.setText("");
        this.txtIEcorreo.setText("");
        this.txtIEnombre_de_empleado.setText("");
        this.txtIEapellido_paterno_empleado.setText("");
        this.txtIEapellido_materno_empleado.setText("");
        this.cboxIEempresa.setSelectedIndex(0);
        this.txtIEdireccion.setText("");
        this.txtIEcurp.setText("");
        this.txtIErfc.setText("");
        this.txtIEnss.setText("");
        this.txtIEcelular.setText("");
        this.txtIEtelefono.setText("");
        this.txtIEtelefono_de_emergencia.setText("");
        this.txtIEnombre_del_contacto.setText("");
        this.txtIEapellido_paterno_contacto.setText("");
        this.txtIEapellido_materno_contacto.setText("");
        this.txtIEcorreo_del_contacto.setText("");
        this.tgbIEvigente.setSelected(true);
    }
    private void btnIEregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIEregresarActionPerformed
        solo regresar
    }//GEN-LAST:event_btnIEregresarActionPerformed

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
            java.util.logging.Logger.getLogger(IngresarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresarEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIEcancelar;
    private javax.swing.JButton btnIEfoto;
    private javax.swing.JButton btnIEguardar;
    private javax.swing.JButton btnIEregresar;
    private javax.swing.JComboBox<String> cboxIEempresa;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblIEno_vigente;
    private javax.swing.JLabel lblIEvigente;
    private javax.swing.JToggleButton tgbIEvigente;
    private javax.swing.JTextField txtIEapellido_materno_contacto;
    private javax.swing.JTextField txtIEapellido_materno_empleado;
    private javax.swing.JTextField txtIEapellido_paterno_contacto;
    private javax.swing.JTextField txtIEapellido_paterno_empleado;
    private javax.swing.JTextField txtIEcelular;
    private javax.swing.JTextField txtIEcorreo;
    private javax.swing.JTextField txtIEcorreo_del_contacto;
    private javax.swing.JTextField txtIEcurp;
    private javax.swing.JTextField txtIEdireccion;
    private javax.swing.JTextField txtIEmatricula;
    private javax.swing.JTextField txtIEnombre_de_empleado;
    private javax.swing.JTextField txtIEnombre_del_contacto;
    private javax.swing.JTextField txtIEnss;
    private javax.swing.JTextField txtIErfc;
    private javax.swing.JTextField txtIEtelefono;
    private javax.swing.JTextField txtIEtelefono_de_emergencia;
    // End of variables declaration//GEN-END:variables
}
