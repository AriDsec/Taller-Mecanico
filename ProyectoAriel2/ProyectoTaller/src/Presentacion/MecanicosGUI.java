package Presentacion;

/**
 * 
 *Elaborado por: Ariel Fernandez Chacon.
 *Carnet: 2019077501
 *Ultima modificacion: 12 de Junio 01:30 pm.
 *GUI
 * 
 */

import Conceptos.Mecanico;
import Util.accesoXML;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.xml.transform.TransformerException;

public class MecanicosGUI extends javax.swing.JFrame {

    public class NonEditableTableModel extends DefaultTableModel {

        public NonEditableTableModel(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false; // Todas las celdas no son editables
        }
    }

    public MecanicosGUI() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        tablaMecanicos.setModel(new NonEditableTableModel(
                new Object[][]{},
                new String[]{
                    "ID", "Nombre", "Puesto"
                }
        ));

        // Agregar ListSelectionListener a la tablaMecanicos
        tablaMecanicos.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if (!e.getValueIsAdjusting()) { // Evitar eventos duplicados
                int filaSeleccionada = tablaMecanicos.getSelectedRow();
                if (filaSeleccionada != -1) { // Si hay una fila seleccionada
                    DefaultTableModel model = (DefaultTableModel) tablaMecanicos.getModel();
                    txtID.setText(model.getValueAt(filaSeleccionada, 0).toString());
                    txtNombre.setText(model.getValueAt(filaSeleccionada, 1).toString());
                    txtPuesto.setText(model.getValueAt(filaSeleccionada, 2).toString());
                    // Aquí puedes manejar la lista de servicios según tus necesidades
                    // Por ejemplo, podrías mostrarlos en un JTextArea o en una lista desplegable.
                }
            }
        });

        Mecanico.refrescar(tablaMecanicos); // Si necesitas alguna función de actualización
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtID = new javax.swing.JTextField();
        lblID = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtPuesto = new javax.swing.JTextField();
        lblPuesto = new javax.swing.JLabel();
        lblServicios = new javax.swing.JLabel();
        btnVtnServicios = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMecanicos = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mecanicos");

        txtID.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        lblID.setFont(new java.awt.Font("Yu Gothic Light", 1, 16)); // NOI18N
        lblID.setText("ID");

        lblNombre.setFont(new java.awt.Font("Yu Gothic Light", 1, 16)); // NOI18N
        lblNombre.setText("Nombre");

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtPuesto.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPuestoActionPerformed(evt);
            }
        });

        lblPuesto.setFont(new java.awt.Font("Yu Gothic Light", 1, 16)); // NOI18N
        lblPuesto.setText("Puesto");

        lblServicios.setFont(new java.awt.Font("Yu Gothic Light", 1, 16)); // NOI18N
        lblServicios.setText("Servicios");

        btnVtnServicios.setText("Ver/Editar");
        btnVtnServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVtnServiciosActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Yu Gothic Light", 1, 14)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setAlignmentY(0.0F);
        btnModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificar.setMargin(new java.awt.Insets(4, 4, 4, 4));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnNuevo.setFont(new java.awt.Font("Yu Gothic Light", 1, 14)); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setAlignmentY(0.0F);
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setMargin(new java.awt.Insets(4, 4, 4, 4));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnBorrar.setFont(new java.awt.Font("Yu Gothic Light", 1, 14)); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.setAlignmentY(0.0F);
        btnBorrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBorrar.setMargin(new java.awt.Insets(4, 4, 4, 4));
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        tablaMecanicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Precio"
            }
        ));
        jScrollPane1.setViewportView(tablaMecanicos);

        btnSalir.setFont(new java.awt.Font("Yu Gothic Light", 1, 14)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setAlignmentY(0.0F);
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setMargin(new java.awt.Insets(4, 4, 4, 4));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblID)
                                .addGap(18, 18, 18)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblNombre)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(lblPuesto)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtPuesto))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblServicios)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnVtnServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblID)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPuesto)
                            .addComponent(txtPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblServicios)
                            .addComponent(btnVtnServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPuestoActionPerformed

    private void btnVtnServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVtnServiciosActionPerformed
        // Obtener el valor del campo txtID
        String id = txtID.getText();

        if (!"".equals(id)) {
            // Verificar si el ID corresponde a un mecánico existente
            boolean mecanicoExiste = false;
            for (Mecanico mecanico : Mecanico.mecanicos) {
                if (mecanico != null && mecanico.getIdentificacion() == Integer.parseInt(id)) {
                    mecanicoExiste = true;
                    break; // Salir del bucle una vez encontrado
                }
            }

            if (mecanicoExiste) {
                // Crear una instancia de la ventana ServiciosValidadosGUI
                ServiciosValidadosGUI vtnServiciosValidados = new ServiciosValidadosGUI();

                // Llamar al método para recibir el ID en la ventana ServiciosValidadosGUI
                vtnServiciosValidados.encontrarMecanico(id);

                // Mostrar la ventana ServiciosValidadosGUI
                vtnServiciosValidados.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "El ID ingresado no corresponde a un mecánico existente.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe ingresar el ID de un mecánico.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnVtnServiciosActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // Obtener los datos ingresados en los campos de texto
        String id = txtID.getText();
        String nombre = txtNombre.getText();
        String puesto = txtPuesto.getText();
// Aquí puedes adaptar cómo obtienes los servicios, dependiendo de tu implementación específica
        //String[] servicios = obtenerServiciosDesdeAlgunaFuente(); // Por ejemplo, una lista de servicios seleccionados

// Verificar si se ha seleccionado un mecánico en la tabla
        int filaSeleccionada = tablaMecanicos.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un mecánico de la tabla.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

// Obtener el ID del mecánico seleccionado en la tabla
        String idMecanicoSeleccionado = tablaMecanicos.getValueAt(filaSeleccionada, 0).toString();

// Verificar si el ID del mecánico seleccionado coincide con el ID ingresado en el campo de texto
        if (!idMecanicoSeleccionado.equals(id)) {
            JOptionPane.showMessageDialog(this, "El ID del mecánico seleccionado no coincide con el ID ingresado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

// Buscar el mecánico en la lista de mecánicos y actualizar sus datos
        Mecanico mecanicoAModificar = null;
        for (Mecanico mecanico : Mecanico.mecanicos) {
            if (mecanico != null && mecanico.getIdentificacion() == Integer.parseInt(id)) {
                mecanico.setNombre(nombre);
                mecanico.setPuesto(puesto);
                // Aquí puedes manejar la actualización de los servicios según tu implementación
                // Esto dependerá de cómo se almacenen los servicios en tu clase Mecanico
                mecanicoAModificar = mecanico;
                break;
            }
        }

// Llamar al método para modificar el mecánico en el archivo XML
        if (mecanicoAModificar != null) {
            accesoXML.modificarMecanico(mecanicoAModificar);

            // Limpiar los campos de texto después de modificar el mecánico
            txtID.setText("");
            txtNombre.setText("");
            txtPuesto.setText("");
            // Puedes limpiar el campo de servicios si es necesario
            //limpiarCampoServicios(); // Define este método según tu implementación

            // Actualizar la tabla de mecánicos después de modificar el mecánico
            Mecanico.refrescar(tablaMecanicos);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró ningún mecánico con el ID especificado en la lista de mecánicos.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // Obtener los datos ingresados en los campos de texto
        String id = txtID.getText();
        String nombre = txtNombre.getText();
        String puesto = txtPuesto.getText();

        // Crear objeto mecánico
        Mecanico mecanico = new Mecanico(Integer.valueOf(id), nombre, puesto, new Integer[]{});

        try {
            // Agregar el objeto al XML
            accesoXML.agregarMecanico(mecanico);
        } catch (TransformerException ex) {
            Logger.getLogger(MecanicosGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Limpiar los campos de texto después de agregar la fila
        txtID.setText("");
        txtNombre.setText("");
        txtPuesto.setText("");
        // Limpiar el campo de servicios si es necesario
        //limpiarCampoServicios(); // Define este método según tu implementación

        // Refrescar la tabla de mecánicos después de agregar la fila
        Mecanico.refrescar(tablaMecanicos);

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        // Obtener el ID del mecánico a borrar
        String idMecanicoABorrar = txtID.getText();

// Verificar si se ingresó un ID válido
        if (!idMecanicoABorrar.isEmpty()) {
            // Convertir el ID a entero
            int id = Integer.parseInt(idMecanicoABorrar);

            // Llamar a la función para borrar el mecánico con el ID especificado del archivo XML
            accesoXML.borrarMecanico(id, tablaMecanicos);

            // Limpiar los campos de texto después de borrar el mecánico
            txtID.setText("");
            txtNombre.setText("");
            txtPuesto.setText("");
            // Puedes limpiar el campo de servicios si es necesario
            //limpiarCampoServicios(); // Define este método según tu implementación

            // Actualizar la tabla de mecánicos después de borrar el mecánico
            Mecanico.refrescar(tablaMecanicos);
        } else {
            // Si no se ingresó ningún ID, mostrar un mensaje de error
            JOptionPane.showMessageDialog(this, "Por favor, ingrese el ID del mecánico a borrar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(MecanicosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MecanicosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MecanicosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MecanicosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MecanicosGUI().setVisible(true);
            }
        });
    }

    public JTextField getTxtID() {
        return txtID;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVtnServicios;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPuesto;
    private javax.swing.JLabel lblServicios;
    private javax.swing.JTable tablaMecanicos;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPuesto;
    // End of variables declaration//GEN-END:variables

}
