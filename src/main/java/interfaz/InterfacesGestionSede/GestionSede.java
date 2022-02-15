/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Customizer.java to edit this template
 */
package interfaz.InterfacesGestionSede;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.HashSet;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author esteban
 */
public class GestionSede extends javax.swing.JPanel implements java.beans.Customizer {
    
    private Object bean;
    private JPanel registrar_sede, consultar_sede, editar_sede, eliminar_sede;
    private Registrar_sede registrar_sede_panel = new Registrar_sede();
    private Consultar_sede consultar_sede_panel = new Consultar_sede();
    private Editar_sede editar_sede_panel = new Editar_sede();
    private Eliminar_sede eliminar_sede_panel = new Eliminar_sede();

    /**
     * Creates new customizer GestionSede
     */
    public GestionSede() {
        initComponents();
        crearBotones();
        jPanel4.add(registrar_sede_panel);
        repaint();
        
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

        jToggleButton1 = new javax.swing.JToggleButton();
        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();

        jToggleButton1.setText("jToggleButton1");

        jTextField1.setText("jTextField1");

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(183, 182, 181));

        jPanel3.setBackground(new java.awt.Color(230, 98, 31));
        jPanel3.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel3.setPreferredSize(new java.awt.Dimension(301, 95));

        jLabel5.setFont(new java.awt.Font("SansSerif", 3, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(254, 254, 254));
        jLabel5.setText("Gestion de Sedes");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(183, 182, 181));
        jPanel5.setMaximumSize(new java.awt.Dimension(301, 32767));
        jPanel5.setMinimumSize(new java.awt.Dimension(301, 400));
        jPanel5.setPreferredSize(new java.awt.Dimension(301, 400));
        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 205, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        add(jPanel2);
    }// </editor-fold>//GEN-END:initComponents
 public void crearBotones(){
     
     
     //******************BOTON REGISTRAR******************************
     registrar_sede = new javax.swing.JPanel();
     registrar_sede.setPreferredSize(new Dimension(301, 50));
     registrar_sede.setBackground(new java.awt.Color(247, 247, 247));
     registrar_sede.setLayout(new FlowLayout());
     registrar_sede.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
     
     registrar_sede.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                registrar_sedeMouseReleased(evt);
            }
     });
     
     JLabel aux1 = new JLabel();
     aux1.setText("Registrar sede");
     aux1.setHorizontalAlignment(SwingConstants.CENTER);
     registrar_sede.add(aux1);
     jPanel5.add(registrar_sede);
    //******************BOTON CONSULTAR******************************
     consultar_sede = new javax.swing.JPanel();
     consultar_sede.setPreferredSize(new Dimension(301, 50));
     consultar_sede.setBackground(new java.awt.Color(247, 247, 247));
     consultar_sede.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
     
     
     consultar_sede.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                consultar_sedeMouseReleased(evt);
            }
     });
     
     JLabel aux2 = new JLabel();
     aux2.setText("Consultar sede");
     aux2.setHorizontalAlignment(SwingConstants.CENTER);
     consultar_sede.add(aux2);
     jPanel5.add(consultar_sede);
     //******************BOTON EDITAR******************************
     editar_sede = new javax.swing.JPanel();
     editar_sede.setPreferredSize(new Dimension(301, 50));
     editar_sede.setBackground(new java.awt.Color(247, 247, 247));
     editar_sede.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
     
     editar_sede.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                editar_sedeMouseReleased(evt);
            }
     });
     
     JLabel aux3 = new JLabel();
     aux3.setText("Editar sede");
     aux3.setHorizontalAlignment(SwingConstants.CENTER);
     editar_sede.add(aux3);
     jPanel5.add(editar_sede);
     //******************BOTON ELIMINAR******************************
     eliminar_sede = new javax.swing.JPanel();
     eliminar_sede.setPreferredSize(new Dimension(301, 50));
     eliminar_sede.setBackground(new java.awt.Color(247, 247, 247));
     editar_sede.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
     
     
     eliminar_sede.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                eliminar_sedeMouseReleased(evt);
            }
     });
     
     JLabel aux4 = new JLabel();
     aux4.setText("Eliminar sede");
     aux4.setHorizontalAlignment(SwingConstants.CENTER);
     eliminar_sede.add(aux4);
     jPanel5.add(eliminar_sede);
     ////////////////////////////////////////////////////////////////////
     repaint();
 }
 
 private void registrar_sedeMouseReleased(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
        registrar_sede.setBackground(new java.awt.Color(249, 152, 103));
        consultar_sede.setBackground(new java.awt.Color(247, 247, 247));
        editar_sede.setBackground(new java.awt.Color(247, 247, 247));
        eliminar_sede.setBackground(new java.awt.Color(247, 247, 247));
        jPanel4.removeAll();
        registrar_sede_panel.setVisible(true);
        jPanel4.add(registrar_sede_panel);
        repaint();
        jPanel4.setVisible(false);
        jPanel4.setVisible(true);
    }             
 
 private void consultar_sedeMouseReleased(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
        registrar_sede.setBackground(new java.awt.Color(247, 247, 247));
        consultar_sede.setBackground(new java.awt.Color(249, 152, 103));
        editar_sede.setBackground(new java.awt.Color(247, 247, 247));
        eliminar_sede.setBackground(new java.awt.Color(247, 247, 247));
        jPanel4.removeAll();
        consultar_sede_panel.setVisible(true);
        jPanel4.add(consultar_sede_panel);
        repaint();
        jPanel4.setVisible(false);
        jPanel4.setVisible(true);
    }     
 
 private void editar_sedeMouseReleased(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
        registrar_sede.setBackground(new java.awt.Color(247, 247, 247));
        consultar_sede.setBackground(new java.awt.Color(247, 247, 247));
        editar_sede.setBackground(new java.awt.Color(249, 152, 103));
        eliminar_sede.setBackground(new java.awt.Color(247, 247, 247));
        jPanel4.removeAll();
        editar_sede_panel.setVisible(true);
        jPanel4.add(editar_sede_panel);
        repaint();
        jPanel4.setVisible(false);
        jPanel4.setVisible(true);
    }     
 
 private void eliminar_sedeMouseReleased(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
        registrar_sede.setBackground(new java.awt.Color(247, 247, 247));
        consultar_sede.setBackground(new java.awt.Color(247, 247, 247));
        editar_sede.setBackground(new java.awt.Color(247, 247, 247));
        eliminar_sede.setBackground(new java.awt.Color(249, 152, 103));
        jPanel4.removeAll();
        eliminar_sede_panel.setVisible(true);
        jPanel4.add(eliminar_sede_panel);
        repaint();
        jPanel4.setVisible(false);
        jPanel4.setVisible(true);
    }     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
