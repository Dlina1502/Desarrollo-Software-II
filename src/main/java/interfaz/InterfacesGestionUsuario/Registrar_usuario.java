/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.InterfacesGestionUsuario;

import conexion_y_funciones.Funciones3;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Registrar_usuario extends javax.swing.JPanel {
    //Funciones funciones = new Funciones();
    Funciones3 funciones = new Funciones3();
    /**
     * Creates new form Registrar_usuario
     */
    public Registrar_usuario() {
        initComponents();
        funciones.boxSede(jComboBox13);
        funciones.boxRoles(jComboBox14);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jSeparator61 = new javax.swing.JSeparator();
        jTextField37 = new javax.swing.JTextField();
        jSeparator62 = new javax.swing.JSeparator();
        jTextField38 = new javax.swing.JTextField();
        jSeparator63 = new javax.swing.JSeparator();
        jTextField39 = new javax.swing.JTextField();
        jTextField40 = new javax.swing.JTextField();
        jSeparator64 = new javax.swing.JSeparator();
        jLabel38 = new javax.swing.JLabel();
        jSeparator65 = new javax.swing.JSeparator();
        jTextField41 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jSeparator66 = new javax.swing.JSeparator();
        jSeparator67 = new javax.swing.JSeparator();
        jComboBox13 = new javax.swing.JComboBox<>();
        jComboBox14 = new javax.swing.JComboBox<>();
        jLabel40 = new javax.swing.JLabel();
        jTextField42 = new javax.swing.JTextField();
        jSeparator68 = new javax.swing.JSeparator();
        jPasswordField13 = new javax.swing.JPasswordField();
        jSeparator69 = new javax.swing.JSeparator();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jSeparator70 = new javax.swing.JSeparator();
        jPasswordField14 = new javax.swing.JPasswordField();
        jButton10 = new javax.swing.JButton();

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/agregarUs.png"))); // NOI18N

        jTextField37.setForeground(new java.awt.Color(153, 153, 153));
        jTextField37.setText("Documento de identificación");
        jTextField37.setBorder(null);
        jTextField37.setPreferredSize(new java.awt.Dimension(7, 24));
        jTextField37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField37MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextField37MouseExited(evt);
            }
        });

        jTextField38.setForeground(new java.awt.Color(153, 153, 153));
        jTextField38.setText("Nombre");
        jTextField38.setBorder(null);
        jTextField38.setPreferredSize(new java.awt.Dimension(7, 24));
        jTextField38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField38MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextField38MouseExited(evt);
            }
        });

        jTextField39.setForeground(new java.awt.Color(153, 153, 153));
        jTextField39.setText("Segundo apellido");
        jTextField39.setBorder(null);
        jTextField39.setPreferredSize(new java.awt.Dimension(7, 24));
        jTextField39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField39MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextField39MouseExited(evt);
            }
        });

        jTextField40.setForeground(new java.awt.Color(153, 153, 153));
        jTextField40.setText("Primer apellido");
        jTextField40.setBorder(null);
        jTextField40.setPreferredSize(new java.awt.Dimension(7, 24));
        jTextField40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField40MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextField40MouseExited(evt);
            }
        });
        jTextField40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField40jTextField4ActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel38.setText("Datos personales:");

        jTextField41.setForeground(new java.awt.Color(153, 153, 153));
        jTextField41.setText("Teléfono");
        jTextField41.setBorder(null);
        jTextField41.setPreferredSize(new java.awt.Dimension(7, 24));
        jTextField41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField41MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextField41MouseExited(evt);
            }
        });
        jTextField41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField41jTextField5ActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel39.setText("Datos empleado:");

        jComboBox13.setForeground(new java.awt.Color(153, 153, 153));
        jComboBox13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox13MouseClicked(evt);
            }
        });

        jComboBox14.setForeground(new java.awt.Color(153, 153, 153));
        jComboBox14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox14MouseClicked(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel40.setText("Crear cuenta:");

        jTextField42.setForeground(new java.awt.Color(153, 153, 153));
        jTextField42.setText("Correo");
        jTextField42.setBorder(null);
        jTextField42.setPreferredSize(new java.awt.Dimension(7, 24));
        jTextField42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField42MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextField42MouseExited(evt);
            }
        });
        jTextField42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField42jTextField6ActionPerformed(evt);
            }
        });

        jPasswordField13.setText("jPasswordField1");
        jPasswordField13.setBorder(null);
        jPasswordField13.setMinimumSize(new java.awt.Dimension(10, 20));
        jPasswordField13.setPreferredSize(new java.awt.Dimension(112, 24));
        jPasswordField13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPasswordField13jPasswordField1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPasswordField13MouseExited(evt);
            }
        });

        jLabel41.setText("Contraseña:");

        jLabel42.setText("Comfirmar contraseña:");

        jPasswordField14.setText("jPasswordField1");
        jPasswordField14.setBorder(null);
        jPasswordField14.setMinimumSize(new java.awt.Dimension(10, 20));
        jPasswordField14.setPreferredSize(new java.awt.Dimension(112, 24));
        jPasswordField14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPasswordField14jPasswordField2MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPasswordField14MouseExited(evt);
            }
        });

        jButton10.setText("REGISTRAR");
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel40)
                .addGap(126, 126, 126))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel37)
                .addGap(200, 200, 200))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextField38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator62, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextField37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator61, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextField39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator63, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextField40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator64, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextField41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator65, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSeparator67)
                        .addComponent(jSeparator66)
                        .addComponent(jComboBox13, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox14, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPasswordField13, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator69, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(jLabel42)
                    .addComponent(jPasswordField14, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator70, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator68, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                            .addComponent(jButton10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37)
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(jLabel40))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jSeparator61, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jTextField42, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jSeparator68, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField38, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator62, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel41))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jTextField40, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator64, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPasswordField13, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator69, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField39, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42))
                .addGap(0, 0, 0)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jSeparator63, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField41, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPasswordField14, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator70, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addComponent(jSeparator65, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jSeparator66, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(2, 2, 2)
                .addComponent(jSeparator67, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 462, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 429, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField37MouseClicked
        jTextField37.setText(null);
        jTextField37.setForeground(Color.BLACK);
    }//GEN-LAST:event_jTextField37MouseClicked

    private void jTextField37MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField37MouseExited
        String a = jTextField37.getText();
        if (a.equals("")){
            jTextField37.setForeground(Color.GRAY);
            jTextField37.setText("Documento de identificación");
        }
    }//GEN-LAST:event_jTextField37MouseExited

    private void jTextField38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField38MouseClicked
        jTextField38.setText(null);
        jTextField38.setForeground(Color.BLACK);
    }//GEN-LAST:event_jTextField38MouseClicked

    private void jTextField38MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField38MouseExited
        String a = jTextField38.getText();
        if (a.equals("")){
            jTextField38.setForeground(Color.GRAY);
            jTextField38.setText("Nombre");
        }
    }//GEN-LAST:event_jTextField38MouseExited

    private void jTextField39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField39MouseClicked
        jTextField39.setText(null);
        jTextField39.setForeground(Color.BLACK);
    }//GEN-LAST:event_jTextField39MouseClicked

    private void jTextField39MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField39MouseExited
        String a = jTextField39.getText();
        if (a.equals("")){
            jTextField39.setForeground(Color.GRAY);
            jTextField39.setText("Segundo apellido");
        }
    }//GEN-LAST:event_jTextField39MouseExited

    private void jTextField40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField40MouseClicked
        jTextField40.setText(null);
        jTextField40.setForeground(Color.BLACK);
    }//GEN-LAST:event_jTextField40MouseClicked

    private void jTextField40MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField40MouseExited
        String a = jTextField40.getText();
        if (a.equals("")){
            jTextField40.setForeground(Color.GRAY);
            jTextField40.setText("Primer apellido");
        }
    }//GEN-LAST:event_jTextField40MouseExited

    private void jTextField40jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField40jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField40jTextField4ActionPerformed

    private void jTextField41MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField41MouseClicked
        jTextField41.setText(null);
        jTextField41.setForeground(Color.BLACK);
    }//GEN-LAST:event_jTextField41MouseClicked

    private void jTextField41MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField41MouseExited
        String a = jTextField41.getText();
        if (a.equals("")){
            jTextField41.setForeground(Color.GRAY);
            jTextField41.setText("Teléfono");
        }
    }//GEN-LAST:event_jTextField41MouseExited

    private void jTextField41jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField41jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField41jTextField5ActionPerformed

    private void jComboBox13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox13MouseClicked
        jComboBox13.removeAllItems();
        funciones.boxSede(jComboBox13);
    }//GEN-LAST:event_jComboBox13MouseClicked

    private void jTextField42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField42MouseClicked
        jTextField42.setText(null);
        jTextField42.setForeground(Color.BLACK);
    }//GEN-LAST:event_jTextField42MouseClicked

    private void jTextField42MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField42MouseExited
        String a = jTextField42.getText();
        if (a.equals("")){
            jTextField42.setForeground(Color.GRAY);
            jTextField42.setText("Correo");
        }
    }//GEN-LAST:event_jTextField42MouseExited

    private void jTextField42jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField42jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField42jTextField6ActionPerformed

    private void jPasswordField13jPasswordField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordField13jPasswordField1MouseClicked
        jPasswordField13.setText(null);
    }//GEN-LAST:event_jPasswordField13jPasswordField1MouseClicked

    private void jPasswordField13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordField13MouseExited
        String a = jPasswordField13.getText();
        if (a.equals("")){
            jPasswordField13.setText("Contraseña");
        }
    }//GEN-LAST:event_jPasswordField13MouseExited

    private void jPasswordField14jPasswordField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordField14jPasswordField2MouseClicked
        jPasswordField14.setText(null);
    }//GEN-LAST:event_jPasswordField14jPasswordField2MouseClicked

    private void jPasswordField14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordField14MouseExited
        String a = jPasswordField14.getText();
        if (a.equals("")){
            jPasswordField14.setText("Contraseña");
        }
    }//GEN-LAST:event_jPasswordField14MouseExited

    private void jButton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseClicked
        // TODO add your handling code here:
        String sede = (String) jComboBox13.getSelectedItem();
        String rol = (String) jComboBox14.getSelectedItem();
        String documento = jTextField37.getText();
        String nombre = jTextField38.getText();
        String apellido1 = jTextField40.getText();
        String apellido2 = jTextField39.getText();
        String telefono = jTextField41.getText();
        String correo = jTextField42.getText();
        char[] clave = jPasswordField13.getPassword();
        char[] claveConfirm = jPasswordField14.getPassword();

        String[] partsSede = sede.split("//");
        String claveConv = new String(clave);
        String claveConfirmConv = new String(claveConfirm);
        
        System.out.println(partsSede[0]);
        System.out.println(partsSede[1]);
        System.out.println(partsSede[2]);
        System.out.println(partsSede[3]);
        
       if (claveConv.equals(claveConfirmConv)){
            funciones.registrarUsuario(documento, partsSede[0],partsSede[1],partsSede[2],partsSede[3], rol, "activo", nombre, apellido1, apellido2, telefono, correo, claveConv);
        }else{
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
        }

    }//GEN-LAST:event_jButton10MouseClicked

    private void jComboBox14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox14MouseClicked
        // TODO add your handling code here:
        jComboBox14.removeAllItems();
        funciones.boxRoles(jComboBox14);
    }//GEN-LAST:event_jComboBox14MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JComboBox<String> jComboBox13;
    private javax.swing.JComboBox<String> jComboBox14;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPasswordField jPasswordField13;
    private javax.swing.JPasswordField jPasswordField14;
    private javax.swing.JSeparator jSeparator61;
    private javax.swing.JSeparator jSeparator62;
    private javax.swing.JSeparator jSeparator63;
    private javax.swing.JSeparator jSeparator64;
    private javax.swing.JSeparator jSeparator65;
    private javax.swing.JSeparator jSeparator66;
    private javax.swing.JSeparator jSeparator67;
    private javax.swing.JSeparator jSeparator68;
    private javax.swing.JSeparator jSeparator69;
    private javax.swing.JSeparator jSeparator70;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField42;
    // End of variables declaration//GEN-END:variables
}
