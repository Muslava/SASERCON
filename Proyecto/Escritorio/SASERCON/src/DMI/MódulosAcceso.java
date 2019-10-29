/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DMI;

import java.awt.Color;
import java.sql.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author coner
 */
public class MódulosAcceso extends javax.swing.JFrame {
    boolean MAie = false;
    public static int x, y, MAmatricula;
    /**
     * Creates new form ModulosAcceso
     */
    public MódulosAcceso(int mat) {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/img/LOGOfdktp.png")).getImage());
        this.MAmatricula = mat;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon(getClass().getResource("/img/FONDO.png"));
        Image image = icon.getImage();
        dkpMAfondo = new javax.swing.JDesktopPane() {
            public void paintComponent(Graphics g)	{
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        btnMAingresar_empleado = new javax.swing.JButton();
        btnMAingresar_cliente = new javax.swing.JButton();
        btnMAbuscar_cliente = new javax.swing.JButton();
        btnMAbuscar_empleado = new javax.swing.JButton();
        btnMAbuscar_producto = new javax.swing.JButton();
        btnMAbuscar_servicio = new javax.swing.JButton();
        btnMAingresar_servicio = new javax.swing.JButton();
        btnMAingresar_producto = new javax.swing.JButton();
        btnMAagendar = new javax.swing.JButton();
        btnMAsalir = new javax.swing.JButton();
        panMAmover = new javax.swing.JPanel();
        lblMAmaxi_rest = new javax.swing.JLabel();
        lblMAcerrar = new javax.swing.JLabel();
        lblMAminimizar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        btnMAingresar_empleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ic_perm_contact_cal_grey600_18dp_1.png"))); // NOI18N
        btnMAingresar_empleado.setText("Ingresar Empleado");
        btnMAingresar_empleado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMAingresar_empleado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMAingresar_empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMAingresar_empleadoActionPerformed(evt);
            }
        });

        btnMAingresar_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ic_account_circle_grey600_18dp.png"))); // NOI18N
        btnMAingresar_cliente.setText("Ingresar Cliente");
        btnMAingresar_cliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMAingresar_cliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMAingresar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMAingresar_clienteActionPerformed(evt);
            }
        });

        btnMAbuscar_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ic_perm_identity_grey600_18dp.png"))); // NOI18N
        btnMAbuscar_cliente.setText("Buscar Cliente");
        btnMAbuscar_cliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMAbuscar_cliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMAbuscar_cliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMAbuscar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMAbuscar_clienteActionPerformed(evt);
            }
        });

        btnMAbuscar_empleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ic_dashboard_grey600_18dp.png"))); // NOI18N
        btnMAbuscar_empleado.setText("Buscar Empleado");
        btnMAbuscar_empleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMAbuscar_empleado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMAbuscar_empleado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMAbuscar_empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMAbuscar_empleadoActionPerformed(evt);
            }
        });

        btnMAbuscar_producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ic_perm_identity_black_18dp.png"))); // NOI18N
        btnMAbuscar_producto.setText("Buscar Producto");
        btnMAbuscar_producto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMAbuscar_producto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMAbuscar_producto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMAbuscar_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMAbuscar_productoActionPerformed(evt);
            }
        });

        btnMAbuscar_servicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ic_add_to_photos_grey600_18dp.png"))); // NOI18N
        btnMAbuscar_servicio.setText("Buscar Servicio");
        btnMAbuscar_servicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMAbuscar_servicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMAbuscar_servicio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMAbuscar_servicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMAbuscar_servicioActionPerformed(evt);
            }
        });

        btnMAingresar_servicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ic_credit_card_grey600_18dp.png"))); // NOI18N
        btnMAingresar_servicio.setText("Ingresar Servicio");
        btnMAingresar_servicio.setDoubleBuffered(true);
        btnMAingresar_servicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMAingresar_servicio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMAingresar_servicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMAingresar_servicioActionPerformed(evt);
            }
        });

        btnMAingresar_producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ic_add_shopping_cart_grey600_18dp.png"))); // NOI18N
        btnMAingresar_producto.setText("Ingresar Producto");
        btnMAingresar_producto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMAingresar_producto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMAingresar_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMAingresar_productoActionPerformed(evt);
            }
        });

        btnMAagendar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ic_dashboard_white_18dp.png"))); // NOI18N
        btnMAagendar.setText("Agendar");
        btnMAagendar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMAagendar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMAagendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMAagendarActionPerformed(evt);
            }
        });

        btnMAsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ic_exit_to_app_grey600_18dp.png"))); // NOI18N
        btnMAsalir.setText("Cerrar Sesión");
        btnMAsalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMAsalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMAsalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMAsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMAsalirActionPerformed(evt);
            }
        });

        panMAmover.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panMAmover.setOpaque(false);
        panMAmover.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panMAmoverMouseDragged(evt);
            }
        });
        panMAmover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panMAmoverMousePressed(evt);
            }
        });

        lblMAmaxi_rest.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMAmaxi_rest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/MódulosAcceso/icons8_maximize_window_32px.png"))); // NOI18N
        lblMAmaxi_rest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMAmaxi_rest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMAmaxi_restMouseClicked(evt);
            }
        });

        lblMAcerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMAcerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/MódulosAcceso/icons8_close_window_32px.png"))); // NOI18N
        lblMAcerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMAcerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMAcerrarMouseClicked(evt);
            }
        });

        lblMAminimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMAminimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/MódulosAcceso/icons8_minimize_window_32px.png"))); // NOI18N
        lblMAminimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMAminimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMAminimizarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panMAmoverLayout = new javax.swing.GroupLayout(panMAmover);
        panMAmover.setLayout(panMAmoverLayout);
        panMAmoverLayout.setHorizontalGroup(
            panMAmoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panMAmoverLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblMAminimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMAmaxi_rest, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMAcerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panMAmoverLayout.setVerticalGroup(
            panMAmoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panMAmoverLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panMAmoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMAmaxi_rest, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMAminimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMAcerrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        dkpMAfondo.setLayer(btnMAingresar_empleado, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dkpMAfondo.setLayer(btnMAingresar_cliente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dkpMAfondo.setLayer(btnMAbuscar_cliente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dkpMAfondo.setLayer(btnMAbuscar_empleado, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dkpMAfondo.setLayer(btnMAbuscar_producto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dkpMAfondo.setLayer(btnMAbuscar_servicio, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dkpMAfondo.setLayer(btnMAingresar_servicio, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dkpMAfondo.setLayer(btnMAingresar_producto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dkpMAfondo.setLayer(btnMAagendar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dkpMAfondo.setLayer(btnMAsalir, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dkpMAfondo.setLayer(panMAmover, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout dkpMAfondoLayout = new javax.swing.GroupLayout(dkpMAfondo);
        dkpMAfondo.setLayout(dkpMAfondoLayout);
        dkpMAfondoLayout.setHorizontalGroup(
            dkpMAfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dkpMAfondoLayout.createSequentialGroup()
                .addGroup(dkpMAfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dkpMAfondoLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(btnMAagendar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMAsalir)
                        .addGap(81, 81, 81))
                    .addGroup(dkpMAfondoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(dkpMAfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnMAingresar_empleado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMAingresar_cliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(42, 42, 42)
                        .addGroup(dkpMAfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnMAingresar_producto, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(btnMAingresar_servicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 360, Short.MAX_VALUE)
                        .addGroup(dkpMAfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMAbuscar_cliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMAbuscar_empleado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(dkpMAfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnMAbuscar_servicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMAbuscar_producto, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))))
                .addContainerGap())
            .addComponent(panMAmover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dkpMAfondoLayout.setVerticalGroup(
            dkpMAfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dkpMAfondoLayout.createSequentialGroup()
                .addComponent(panMAmover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(dkpMAfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dkpMAfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnMAingresar_empleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMAbuscar_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnMAbuscar_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMAingresar_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(dkpMAfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMAingresar_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMAingresar_servicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMAbuscar_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMAbuscar_servicio, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                .addGroup(dkpMAfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMAsalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMAagendar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dkpMAfondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dkpMAfondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(962, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMAingresar_empleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMAingresar_empleadoActionPerformed
        IngresarEmpleado IE = new IngresarEmpleado();
        this.dkpMAfondo.add(IE);
        IE.show();
    }//GEN-LAST:event_btnMAingresar_empleadoActionPerformed

    private void btnMAingresar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMAingresar_clienteActionPerformed
        IngresarCliente IC = new IngresarCliente();
        this.dkpMAfondo.add(IC);
        IC.show();
    }//GEN-LAST:event_btnMAingresar_clienteActionPerformed

    private void btnMAbuscar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMAbuscar_clienteActionPerformed
        BuscarCliente BC = new BuscarCliente();
        this.dkpMAfondo.add(BC);
        BC.show();
    }//GEN-LAST:event_btnMAbuscar_clienteActionPerformed

    private void btnMAbuscar_empleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMAbuscar_empleadoActionPerformed
        BuscarEmpleado BE = new BuscarEmpleado();
        this.dkpMAfondo.add(BE);
        BE.show();
    }//GEN-LAST:event_btnMAbuscar_empleadoActionPerformed

    private void btnMAbuscar_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMAbuscar_productoActionPerformed
        BuscarProducto BP = new BuscarProducto();
        this.dkpMAfondo.add(BP);
        BP.show();
    }//GEN-LAST:event_btnMAbuscar_productoActionPerformed

    private void btnMAbuscar_servicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMAbuscar_servicioActionPerformed
        BuscarServicio BS = new BuscarServicio();
        this.dkpMAfondo.add(BS);
        BS.show();
    }//GEN-LAST:event_btnMAbuscar_servicioActionPerformed

    private void btnMAingresar_servicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMAingresar_servicioActionPerformed
        IngresarServicio IS = new IngresarServicio();
        this.dkpMAfondo.add(IS);
        IS.show();
    }//GEN-LAST:event_btnMAingresar_servicioActionPerformed

    private void btnMAingresar_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMAingresar_productoActionPerformed
        IngresarProducto IP = new IngresarProducto();
        this.dkpMAfondo.add(IP);
        IP.show();
    }//GEN-LAST:event_btnMAingresar_productoActionPerformed

    private void btnMAagendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMAagendarActionPerformed
        Agendar A = new Agendar();
        this.dkpMAfondo.add(A);
        A.show();
    }//GEN-LAST:event_btnMAagendarActionPerformed

    private void btnMAsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMAsalirActionPerformed
        ConexionMySQL cmysql = new ConexionMySQL();
        Connection conn = (Connection) cmysql.Conectar();
        try {
            String senSQL = "INSERT INTO bitacoraAccesos(matriculaEmpleado,fechaIngreso) VALUES ("+MAmatricula+",NOW());";
            PreparedStatement ps = conn.prepareStatement(senSQL);
            ps.executeUpdate();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        this.dispose();
        Login L = new Login();
        L.show();
    }//GEN-LAST:event_btnMAsalirActionPerformed

    private void lblMAcerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMAcerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblMAcerrarMouseClicked

    private void lblMAmaxi_restMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMAmaxi_restMouseClicked
        if(this.getExtendedState()==this.MAXIMIZED_BOTH)  {
            this.setExtendedState(this.NORMAL);
            this.lblMAmaxi_rest.setIcon(new ImageIcon(getClass().getResource("../img/MódulosAcceso/icons8_maximize_window_32px.png")));
        }
        else    {
            this.setExtendedState(this.MAXIMIZED_BOTH);
            this.lblMAmaxi_rest.setIcon(new ImageIcon(getClass().getResource("../img/MódulosAcceso/icons8_restore_window_32px.png")));
        }
    }//GEN-LAST:event_lblMAmaxi_restMouseClicked

    private void panMAmoverMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panMAmoverMouseDragged
        //setCursor(new Cursor(Cursor.MOVE_CURSOR));
        if(this.getExtendedState()==this.NORMAL)    {
            Point mueve = MouseInfo.getPointerInfo().getLocation();
            this.setLocation(mueve.x - x, mueve.y - y);
        }
    }//GEN-LAST:event_panMAmoverMouseDragged

    private void lblMAminimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMAminimizarMouseClicked
        this.setExtendedState(1);
    }//GEN-LAST:event_lblMAminimizarMouseClicked

    private void panMAmoverMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panMAmoverMousePressed
        if(this.getExtendedState()==this.NORMAL)    {
            x = evt.getX();
            y = evt.getY();
        }
    }//GEN-LAST:event_panMAmoverMousePressed

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
            java.util.logging.Logger.getLogger(MódulosAcceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MódulosAcceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MódulosAcceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MódulosAcceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MódulosAcceso(MAmatricula).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMAagendar;
    private javax.swing.JButton btnMAbuscar_cliente;
    private javax.swing.JButton btnMAbuscar_empleado;
    private javax.swing.JButton btnMAbuscar_producto;
    private javax.swing.JButton btnMAbuscar_servicio;
    private javax.swing.JButton btnMAingresar_cliente;
    private javax.swing.JButton btnMAingresar_empleado;
    private javax.swing.JButton btnMAingresar_producto;
    private javax.swing.JButton btnMAingresar_servicio;
    private javax.swing.JButton btnMAsalir;
    private javax.swing.JDesktopPane dkpMAfondo;
    private javax.swing.JLabel lblMAcerrar;
    private javax.swing.JLabel lblMAmaxi_rest;
    private javax.swing.JLabel lblMAminimizar;
    private javax.swing.JPanel panMAmover;
    // End of variables declaration//GEN-END:variables
}
