/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DMI;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author coner
 */
public class BuscarEmpleado extends javax.swing.JInternalFrame {
public int BEindice;
    
DefaultTableModel tbBEres;


    /**
     * Creates new form BuscarEmpleado
     */
    public BuscarEmpleado() {
        initComponents();
        this.setIconifiable(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnIEregresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        txtBEnss = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtBEmatricula = new javax.swing.JTextField();
        txtBEnombre = new javax.swing.JTextField();
        txtBEcorreo = new javax.swing.JTextField();
        cboxBEempresa = new javax.swing.JComboBox<>();
        txtBEdireccion = new javax.swing.JTextField();
        txtBEcurp = new javax.swing.JTextField();
        txtBErfc = new javax.swing.JTextField();
        btnBEmodificar = new javax.swing.JButton();
        btnBEbaja = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbBEconsulta = new javax.swing.JTable();
        btnBEbuscar = new javax.swing.JButton();

        btnIEregresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ic_arrow_back_grey600_18dp.png"))); // NOI18N
        btnIEregresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIEregresarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Empleado"));

        jLabel8.setText("NSS:");

        jLabel7.setText("RFC:");

        jLabel6.setText("CURP:");

        jLabel5.setText("Dirección:");

        jLabel4.setText("Empresa:");

        jLabel3.setText("Correo:");

        jLabel2.setText("Nombre:");

        jLabel1.setText("Matrícula:");

        cboxBEempresa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Empresa", "SERCON", "ICC", "SAMSARA", "MABA" }));

        btnBEmodificar.setText("Modificar Empleado");
        btnBEmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBEmodificarActionPerformed(evt);
            }
        });

        btnBEbaja.setText("Dar de baja");
        btnBEbaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBEbajaActionPerformed(evt);
            }
        });

        tbBEconsulta.setModel(new javax.swing.table.DefaultTableModel(
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
        tbBEconsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBEconsultaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbBEconsulta);

        btnBEbuscar.setText("Buscar Empleado");
        btnBEbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBEbuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtBEmatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtBEdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtBEcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cboxBEempresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtBEnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtBEnss))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtBErfc))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtBEcurp, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBEmodificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBEbaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBEbuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBEmatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBEnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtBEcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboxBEempresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtBEdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtBEcurp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtBErfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtBEnss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(btnBEbuscar)
                        .addGap(18, 18, 18)
                        .addComponent(btnBEmodificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnBEbaja)
                        .addContainerGap(26, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnIEregresar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnIEregresar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIEregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIEregresarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnIEregresarActionPerformed

    private void btnBEmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBEmodificarActionPerformed
        //if()    {
            BuscarEmpleado ME = new BuscarEmpleado();
            //this.dkpMAfondo.add(ME);
            ME.show();
        //}
    }//GEN-LAST:event_btnBEmodificarActionPerformed

    
    //metodo para consultar datos
    void consultarDatos(String dato)
    {
        //String[]encabezados={"ID", "NOMBRE","DIRECCION","E-MAIL"};
        String[]encabezados={"NOMBRE","DIRECCION","E-MAIL"};
        String[]filas=new String[3];
        String senSQL="";
        tbBEres=new DefaultTableModel(null,encabezados);
        
        ConexionMySQL cmysql=new ConexionMySQL();
        Connection conec=cmysql.Conectar();
        
        senSQL="SELECT matricula, nombreEmpleado, apellidoPaternoEmpleado, apellidoMaternoEmpleado, correoEmpleado, empresa.nombre, puesto.nombre, curp, numeroSeguroSocial, celular, telefonoEmergencia, nombreContacto, apellidoPaternoContacto, apellidoMaternoContacto, correoContacto, estadoActivo, telefono, RFC"+
        "FROM empleado, puesto, empresa"+
        "WHERE empleado.empresa=empresa.clave AND puesto.clave=empleado.puesto AND ";
        
        senSQL="SELECT Nombre, Direccion, Email FROM agenda "
                + "WHERE CONCAT(Nombre,' ',Direccion, ' ',Email) LIKE '%"+dato+"%'";
        try{
            Statement st=conec.createStatement();
            ResultSet rs=st.executeQuery(senSQL);
            
            while(rs.next()){
                //filas[0]=rs.getString("id");
                filas[0]=rs.getString("Nombre");
                filas[1]=rs.getString("Direccion");
                filas[2]=rs.getString("Email");
               
                tbBEres.addRow(filas);
            }
            this.tbBEconsulta.setModel(tbBEres);
            
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ex);
        }
    }

    
    
    private void btnBEbajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBEbajaActionPerformed
        ConexionMySQL cmysql = new ConexionMySQL();
        Connection conec = (Connection) cmysql.Conectar();
        
        String senSQL = "UPDATE empleado SET estadoActivo = 0 WHERE matricula = "+BEindice;
        
        try {
            PreparedStatement ps = conec.prepareStatement(senSQL);
            int n=ps.executeUpdate();
            if (n>0)    {
                JOptionPane.showOptionDialog(this, "Se dado de baja el empleado satisfactoriamente",
                        "MySQL Information", JOptionPane.INFORMATION_MESSAGE,
                        JOptionPane.INFORMATION_MESSAGE, null, new Object[]{" 0K "},"0K");
                actualizar();
            }
        } catch (Exception ex)  {
            JOptionPane.showMessageDialog(null,ex,"Error",2);
        }
    }//GEN-LAST:event_btnBEbajaActionPerformed

    private void btnBEbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBEbuscarActionPerformed
        try {
            
        } catch(Exception ex)   {
            
        }
    }//GEN-LAST:event_btnBEbuscarActionPerformed

    private void tbBEconsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBEconsultaMouseClicked
        int registro;
        String ids;
        try{
            BEindice=tbBEconsulta.getSelectedRow();

            String etiq="Modificar";
            tbBEres=(DefaultTableModel) tbBEconsulta.getModel();
            ids=(String) tbBEres.getValueAt(registro, 0);
            EditarDatos(ids);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex,"Error System Information",0);
        }
    }//GEN-LAST:event_tbBEconsultaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBEbaja;
    private javax.swing.JButton btnBEbuscar;
    private javax.swing.JButton btnBEmodificar;
    private javax.swing.JButton btnIEregresar;
    private javax.swing.JComboBox<String> cboxBEempresa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbBEconsulta;
    private javax.swing.JTextField txtBEcorreo;
    private javax.swing.JTextField txtBEcurp;
    private javax.swing.JTextField txtBEdireccion;
    private javax.swing.JTextField txtBEmatricula;
    private javax.swing.JTextField txtBEnombre;
    private javax.swing.JTextField txtBEnss;
    private javax.swing.JTextField txtBErfc;
    // End of variables declaration//GEN-END:variables
}
