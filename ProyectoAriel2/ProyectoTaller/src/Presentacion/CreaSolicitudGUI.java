package Presentacion;

/**
 * 
 *Elaborado por: Ariel Fernandez Chacon.
 *Carnet: 2019077501
 *Ultima modificacion: 12 de Junio 07:30 pm.
 *GUI
 * 
 */

import Conceptos.Cliente;
import Conceptos.Servicio;
import Conceptos.Solicitud;
import javax.swing.JFrame;

public class CreaSolicitudGUI extends javax.swing.JFrame {

    public CreaSolicitudGUI() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        llenarComboBoxTipoServicio();
        llenarComboBoxCliente();
    }

    private void llenarComboBoxTipoServicio() {
        comboBoxTipoServicio.removeAllItems(); // Limpiar el comboBox

        // Obtener los nombres de los servicios disponibles y agregarlos al comboBox
        for (Servicio servicio : Servicio.servicios) {
            if (servicio != null) {
                comboBoxTipoServicio.addItem(servicio.getNombre());
            }

        }
    }

    private void llenarComboBoxCliente() {
        comboBoxCliente.removeAllItems(); // Limpiar el comboBox

        // Obtener los nombres de los clientes disponibles y agregarlos al comboBox
        for (Cliente cliente : Cliente.clientes) {
            if (cliente != null) {
                comboBoxCliente.addItem(cliente.getNombre());
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblID5 = new javax.swing.JLabel();
        lblID6 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        comboBoxTipoServicio = new javax.swing.JComboBox<>();
        lblID7 = new javax.swing.JLabel();
        comboBoxCliente = new javax.swing.JComboBox<>();
        lblID8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();
        btnSalvar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Crear Solicitud");

        lblID5.setFont(new java.awt.Font("Yu Gothic Light", 1, 16)); // NOI18N
        lblID5.setText("Placa");

        lblID6.setFont(new java.awt.Font("Yu Gothic Light", 1, 16)); // NOI18N
        lblID6.setText("Tipo de Servicio");

        txtPlaca.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlacaActionPerformed(evt);
            }
        });

        comboBoxTipoServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxTipoServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxTipoServicioActionPerformed(evt);
            }
        });

        lblID7.setFont(new java.awt.Font("Yu Gothic Light", 1, 16)); // NOI18N
        lblID7.setText("Cliente");

        comboBoxCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxClienteActionPerformed(evt);
            }
        });

        lblID8.setFont(new java.awt.Font("Yu Gothic Light", 1, 16)); // NOI18N
        lblID8.setText("Observaciones");

        txtObservaciones.setColumns(20);
        txtObservaciones.setRows(5);
        jScrollPane1.setViewportView(txtObservaciones);

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(lblID8)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSalvar)
                        .addGap(74, 74, 74))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblID5)
                            .addComponent(lblID7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(lblID6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboBoxTipoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(comboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(650, Short.MAX_VALUE)
                    .addComponent(btnSalir)
                    .addGap(20, 20, 20)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID6)
                    .addComponent(comboBoxTipoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblID5)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID7)
                    .addComponent(comboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(lblID8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addGap(25, 25, 25))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(485, Short.MAX_VALUE)
                    .addComponent(btnSalir)
                    .addGap(25, 25, 25)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlacaActionPerformed

    }//GEN-LAST:event_txtPlacaActionPerformed

    private void comboBoxTipoServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxTipoServicioActionPerformed

    }//GEN-LAST:event_comboBoxTipoServicioActionPerformed

    private void comboBoxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxClienteActionPerformed

    }//GEN-LAST:event_comboBoxClienteActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        String placa = txtPlaca.getText();
        String observaciones = txtObservaciones.getText();

        String servicio = (String) comboBoxTipoServicio.getSelectedItem();
        String cliente = (String) comboBoxCliente.getSelectedItem();

        Integer idServicio = 0;
        Integer idCliente = 0;

        for (Servicio iServicio : Servicio.servicios) {
            if (iServicio != null) {
                if (iServicio.getNombre() == servicio) {
                    idServicio = iServicio.getIdentificacion();
                    break;
                }
            }
        }
        
        for (Cliente iCliente : Cliente.clientes) {
            if (iCliente != null) {
                if (iCliente.getNombre() == cliente) {
                    idCliente = iCliente.getIdentificacion();
                    break;
                }
            }
        }

        Solicitud.crear(placa, idServicio, idCliente, observaciones);
        
        txtPlaca.setText("");
        txtObservaciones.setText("");
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(CreaSolicitudGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreaSolicitudGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreaSolicitudGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreaSolicitudGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreaSolicitudGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> comboBoxCliente;
    private javax.swing.JComboBox<String> comboBoxTipoServicio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblID5;
    private javax.swing.JLabel lblID6;
    private javax.swing.JLabel lblID7;
    private javax.swing.JLabel lblID8;
    private javax.swing.JTextArea txtObservaciones;
    private javax.swing.JTextField txtPlaca;
    // End of variables declaration//GEN-END:variables
}
