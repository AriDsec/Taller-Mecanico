package Presentacion;

/**
 * 
 *Elaborado por: Ariel Fernandez Chacon.
 *Carnet: 2019077501
 *Ultima modificacion: 12 de Junio 06:30 pm.
 *GUI
 * 
 */

import Conceptos.Cliente;
import Util.accesoXML;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

public class ClientesGUI extends javax.swing.JFrame {

    public class NonEditableTableModel extends DefaultTableModel {

        public NonEditableTableModel(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false; // Todas las celdas no son editables
        }
    }

    public ClientesGUI() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        tablaClientes.setModel(new NonEditableTableModel(
                new Object[][]{},
                new String[]{
                    "ID", "Nombre", "Teléfono", "Email", "Placa"
                }
        ));

        // Agregar ListSelectionListener a la tablaClientes
        tablaClientes.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if (!e.getValueIsAdjusting()) { // Evitar eventos duplicados
                int filaSeleccionada = tablaClientes.getSelectedRow();
                if (filaSeleccionada != -1) { // Si hay una fila seleccionada
                    DefaultTableModel model = (DefaultTableModel) tablaClientes.getModel();
                    txtID.setText(model.getValueAt(filaSeleccionada, 0).toString());
                    txtNombre.setText(model.getValueAt(filaSeleccionada, 1).toString());
                    txtTelefono.setText(model.getValueAt(filaSeleccionada, 2).toString());
                    txtEmail.setText(model.getValueAt(filaSeleccionada, 3).toString());
                    txtPlaca.setText(model.getValueAt(filaSeleccionada, 4).toString());
                }
            }
        });

        Cliente.refrescar(tablaClientes);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        lblPlaca = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        btnSalir1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Clientes");

        lblID.setFont(new java.awt.Font("Yu Gothic Light", 1, 16)); // NOI18N
        lblID.setText("ID");

        txtID.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        lblPlaca.setFont(new java.awt.Font("Yu Gothic Light", 1, 16)); // NOI18N
        lblPlaca.setText("Placa");

        txtPlaca.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlacaActionPerformed(evt);
            }
        });

        lblNombre.setFont(new java.awt.Font("Yu Gothic Light", 1, 16)); // NOI18N
        lblNombre.setText("Nombre");

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        lblTelefono.setFont(new java.awt.Font("Yu Gothic Light", 1, 16)); // NOI18N
        lblTelefono.setText("Teléfono");

        txtTelefono.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        lblEmail.setFont(new java.awt.Font("Yu Gothic Light", 1, 16)); // NOI18N
        lblEmail.setText("Email");

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
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

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Placa", "Teléfono", "Email"
            }
        ));
        jScrollPane1.setViewportView(tablaClientes);

        btnSalir1.setFont(new java.awt.Font("Yu Gothic Light", 1, 14)); // NOI18N
        btnSalir1.setText("Salir");
        btnSalir1.setAlignmentY(0.0F);
        btnSalir1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir1.setMargin(new java.awt.Insets(4, 4, 4, 4));
        btnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lblPlaca))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblID)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtID, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                    .addComponent(txtPlaca))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTelefono)
                    .addComponent(lblNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEmail, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombre)
                    .addComponent(txtTelefono)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addGap(29, 29, 29))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(844, Short.MAX_VALUE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(32, 32, 32)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(857, Short.MAX_VALUE)
                    .addComponent(btnSalir1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(19, 19, 19)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTelefono)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblID)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPlaca)
                            .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblEmail)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(547, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(566, Short.MAX_VALUE)
                    .addComponent(btnSalir1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlacaActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // Obtener los datos ingresados en los campos de texto
        String id = txtID.getText();
        String nombre = txtNombre.getText();
        String telefono = txtTelefono.getText();
        String email = txtEmail.getText();
        String placa = txtPlaca.getText();

        // Verificar si ya existe un cliente con el mismo ID
        if (Cliente.existeCliente(Integer.parseInt(id))) {
            JOptionPane.showMessageDialog(this, "Ya existe un cliente con el mismo ID. Por favor, ingrese un ID único.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Crear objeto cliente
        Cliente cliente = new Cliente(Integer.parseInt(id), nombre, telefono, email, placa);

        //Agrega el objeto al XML
        accesoXML.agregarCliente(cliente);

        // Limpiar los campos de texto después de agregar la fila
        txtID.setText("");
        txtNombre.setText("");
        txtPlaca.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");

        Cliente.refrescar(tablaClientes);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        // Obtener el ID del cliente a borrar
        String idClienteABorrar = txtID.getText();

        // Verificar si se ingresó un ID válido
        if (!idClienteABorrar.isEmpty()) {
            // Convertir el ID a entero
            int id = Integer.parseInt(idClienteABorrar);

            // Llamar a la función para borrar el cliente con el ID especificado del archivo XML y de la lista de clientes
            accesoXML.borrarCliente(id, tablaClientes);

            // Limpiar los campos de texto después de borrar el cliente
            txtID.setText("");
            txtNombre.setText("");
            txtPlaca.setText("");
            txtTelefono.setText("");
            txtEmail.setText("");

            // Actualizar la tabla de clientes después de borrar el cliente
            Cliente.refrescar(tablaClientes);
        } else {
            // Si no se ingresó ningún ID, mostrar un mensaje de error
            JOptionPane.showMessageDialog(this, "Por favor, ingrese el ID del cliente a borrar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // Obtener los datos ingresados en los campos de texto
        String id = txtID.getText();
        String nombre = txtNombre.getText();
        String telefono = txtTelefono.getText();
        String email = txtEmail.getText();
        String placa = txtPlaca.getText();

        // Verificar si se ha seleccionado un cliente en la tabla
        int filaSeleccionada = tablaClientes.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un cliente de la tabla.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Obtener el ID del cliente seleccionado en la tabla
        String idClienteSeleccionado = tablaClientes.getValueAt(filaSeleccionada, 0).toString();

        // Verificar si el ID del cliente seleccionado coincide con el ID ingresado en el campo de texto
        if (!idClienteSeleccionado.equals(id)) {
            JOptionPane.showMessageDialog(this, "El ID del cliente seleccionado no coincide con el ID ingresado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Buscar el cliente en la lista de clientes y actualizar sus datos
        Cliente clienteAModificar = null;
        for (Cliente cliente : Cliente.clientes) {
            if (cliente != null && cliente.getIdentificacion().equals(Integer.parseInt(id))) {
                cliente.setNombre(nombre);
                cliente.setTelefono(telefono);
                cliente.setEmail(email);
                cliente.setPlaca(placa);
                clienteAModificar = cliente;
                break;
            }
        }

        // Llamar al método para modificar el cliente en el archivo XML
        if (clienteAModificar != null) {
            accesoXML.modificarCliente(clienteAModificar);

            // Limpiar los campos de texto después de modificar el cliente
            txtID.setText("");
            txtNombre.setText("");
            txtPlaca.setText("");
            txtTelefono.setText("");
            txtEmail.setText("");

            // Actualizar la tabla de clientes después de modificar el cliente
            Cliente.refrescar(tablaClientes);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró ningún cliente con el ID especificado en la lista de clientes.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
         dispose();
    }//GEN-LAST:event_btnSalir1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new ClientesGUI().setVisible(true);

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
