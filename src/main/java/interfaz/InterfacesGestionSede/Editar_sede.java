/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Customizer.java to edit this template
 */
package interfaz.InterfacesGestionSede;

import conexion_y_funciones.Funciones;
import java.awt.Color;

/**
 *
 * @author esteban
 */
public class Editar_sede extends javax.swing.JPanel implements java.beans.Customizer {
    
    
    private Funciones funciones = new Funciones();
    private Object bean;

    /**
     * Creates new customizer Editar_sede
     */
    public Editar_sede() {
        initComponents();
    }
    
    public void setObject(Object bean) {
        this.bean = bean;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the FormEditor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jTextField45 = new javax.swing.JTextField();
        jSeparator75 = new javax.swing.JSeparator();
        jTextField47 = new javax.swing.JTextField();
        jSeparator77 = new javax.swing.JSeparator();
        jTextField48 = new javax.swing.JTextField();
        jSeparator78 = new javax.swing.JSeparator();
        jTextField49 = new javax.swing.JTextField();
        jSeparator79 = new javax.swing.JSeparator();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jComboBox14 = new javax.swing.JComboBox<>();

        setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel45.setText("Sede a modificar:");

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel46.setText("Datos de la sede:");

        jTextField45.setForeground(new java.awt.Color(153, 153, 153));
        jTextField45.setText("Barrio");
        jTextField45.setBorder(null);
        jTextField45.setPreferredSize(new java.awt.Dimension(7, 24));
        jTextField45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField45MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextField45MouseExited(evt);
            }
        });

        jTextField47.setForeground(new java.awt.Color(153, 153, 153));
        jTextField47.setText("Direccion");
        jTextField47.setBorder(null);
        jTextField47.setPreferredSize(new java.awt.Dimension(7, 24));
        jTextField47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField47MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextField47MouseExited(evt);
            }
        });
        jTextField47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField47jTextField4ActionPerformed(evt);
            }
        });

        jTextField48.setForeground(new java.awt.Color(153, 153, 153));
        jTextField48.setText("Ciudad");
        jTextField48.setBorder(null);
        jTextField48.setPreferredSize(new java.awt.Dimension(7, 24));
        jTextField48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField48MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextField48MouseExited(evt);
            }
        });

        jTextField49.setForeground(new java.awt.Color(153, 153, 153));
        jTextField49.setText("Teléfono");
        jTextField49.setBorder(null);
        jTextField49.setPreferredSize(new java.awt.Dimension(7, 24));
        jTextField49.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField49MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextField49MouseExited(evt);
            }
        });
        jTextField49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField49jTextField5ActionPerformed(evt);
            }
        });

        jButton14.setText("MOSTRAR DATOS");
        jButton14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton14MouseClicked(evt);
            }
        });
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setText("GUARDAR CAMBIOS");
        jButton15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton15MouseClicked(evt);
            }
        });

        jComboBox14.setForeground(new java.awt.Color(153, 153, 153));
        jComboBox14.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione sede" }));
        jComboBox14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox14MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator75)
                            .addComponent(jTextField48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator78)
                            .addComponent(jTextField47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator77)
                            .addComponent(jTextField49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator79, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel46))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox14, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel45)
                    .addComponent(jComboBox14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jLabel46)
                .addGap(5, 5, 5)
                .addComponent(jTextField45, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator75, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField47, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator77, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField48, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator78, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField49, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jSeparator79, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        add(jPanel5, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField45MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField45MouseClicked
        jTextField45.setText(null);
        jTextField45.setForeground(Color.BLACK);
    }//GEN-LAST:event_jTextField45MouseClicked

    private void jTextField45MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField45MouseExited
        String a = jTextField45.getText();
        if (a.equals("")){
            jTextField45.setForeground(Color.GRAY);
            jTextField45.setText("Barrio");
        }
    }//GEN-LAST:event_jTextField45MouseExited

    private void jTextField47MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField47MouseClicked
        jTextField47.setText(null);
        jTextField47.setForeground(Color.BLACK);
    }//GEN-LAST:event_jTextField47MouseClicked

    private void jTextField47MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField47MouseExited
        String a = jTextField47.getText();
        if (a.equals("")){
            jTextField47.setForeground(Color.GRAY);
            jTextField47.setText("Direccion");
        }
    }//GEN-LAST:event_jTextField47MouseExited

    private void jTextField47jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField47jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField47jTextField4ActionPerformed

    private void jTextField48MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField48MouseClicked
        jTextField48.setText(null);
        jTextField48.setForeground(Color.BLACK);
    }//GEN-LAST:event_jTextField48MouseClicked

    private void jTextField48MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField48MouseExited
        String a = jTextField48.getText();
        if (a.equals("")){
            jTextField48.setForeground(Color.GRAY);
            jTextField48.setText("Ciudad");
        }
    }//GEN-LAST:event_jTextField48MouseExited

    private void jTextField49MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField49MouseClicked
        jTextField49.setText(null);
        jTextField49.setForeground(Color.BLACK);
    }//GEN-LAST:event_jTextField49MouseClicked

    private void jTextField49MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField49MouseExited
        String a = jTextField49.getText();
        if (a.equals("")){
            jTextField49.setForeground(Color.GRAY);
            jTextField49.setText("Teléfono");
        }
    }//GEN-LAST:event_jTextField49MouseExited

    private void jTextField49jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField49jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField49jTextField5ActionPerformed

    private void jButton14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton14MouseClicked
        String sede = (String) jComboBox14.getSelectedItem();
        String[] parteSede = sede.split("//");
        funciones.consultarSede(parteSede[0], parteSede[1], parteSede[2], jTextField45, jTextField47, jTextField48, jTextField49);
    }//GEN-LAST:event_jButton14MouseClicked

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MouseClicked
        String sede = (String) jComboBox14.getSelectedItem();
        String ciudad = jTextField48.getText();
        String barrio = jTextField45.getText();
        String direccion = jTextField47.getText();
        String telefono = jTextField49.getText();
        String[] parteSede = sede.split("//");
        funciones.editarSede(parteSede[0],parteSede[1],parteSede[2], barrio, direccion, ciudad, telefono);
    }//GEN-LAST:event_jButton15MouseClicked

    private void jComboBox14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox14MouseClicked
        jComboBox14.removeAllItems();
        funciones.consultar_sedes_combo(jComboBox14);
    }//GEN-LAST:event_jComboBox14MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JComboBox<String> jComboBox14;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator75;
    private javax.swing.JSeparator jSeparator77;
    private javax.swing.JSeparator jSeparator78;
    private javax.swing.JSeparator jSeparator79;
    private javax.swing.JTextField jTextField45;
    private javax.swing.JTextField jTextField47;
    private javax.swing.JTextField jTextField48;
    private javax.swing.JTextField jTextField49;
    // End of variables declaration//GEN-END:variables
}