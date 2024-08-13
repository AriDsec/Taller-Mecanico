package Presentacion;

/**
 * 
 *Elaborado por: Ariel Fernandez Chacon.
 *Carnet: 2019077501
 *Ultima modificacion: 12 de Junio 07:30 pm.
 *GUI
 * 
 */

import Conceptos.Mecanico;
import Conceptos.Servicio;
import Util.accesoXML;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ServiciosValidadosGUI extends javax.swing.JFrame {

    Mecanico mecanicoObj;

    public void encontrarMecanico(String id) {
        // Buscar el mecánico en la lista de mecánicos y actualizar sus datos
        if (!id.isEmpty()) {
            for (Mecanico mecanico : Mecanico.mecanicos) {
                if (mecanico != null && mecanico.getIdentificacion() == Integer.parseInt(id)) {
                    Servicio.refrescarValidacion(tablaServiciosValidados, mecanico);
                    mecanicoObj = mecanico;
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe ingresar el ID de un mecanico existente.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public ServiciosValidadosGUI() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNuevo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaServiciosValidados = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaServiciosValidados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Validado", "Servicio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaServiciosValidados);

        btnCancelar.setFont(new java.awt.Font("Yu Gothic Light", 1, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setAlignmentY(0.0F);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setMargin(new java.awt.Insets(4, 4, 4, 4));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAceptar.setFont(new java.awt.Font("Yu Gothic Light", 1, 14)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.setAlignmentY(0.0F);
        btnAceptar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAceptar.setMargin(new java.awt.Insets(4, 4, 4, 4));
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        Integer[] servicios = new Integer[1000];
        int index = 0;

        // Recorrer las filas de la tabla
        for (int i = 0; i < tablaServiciosValidados.getRowCount(); i++) {
            // Verificar si el checkbox de la fila actual está marcado
            boolean isChecked = (boolean) tablaServiciosValidados.getValueAt(i, 0);
            if (isChecked) {
                // Obtener el nombre del servicio de la fila actual
                String nombreServicio = (String) tablaServiciosValidados.getValueAt(i, 1);
                // Buscar el ID del servicio en la lista de servicios
                for (Servicio servicio : Servicio.servicios) {
                    if (servicio != null && servicio.getNombre().equals(nombreServicio)) {
                        servicios[index++] = servicio.getIdentificacion();
                        break; // Una vez encontrado el servicio, salir del bucle
                    }
                }
            }
        }

        // Crear un nuevo array del tamaño correcto para almacenar solo los servicios marcados
        Integer[] serviciosMarcados = new Integer[index];
        System.arraycopy(servicios, 0, serviciosMarcados, 0, index);

        // Pasar la lista de servicios al método agregarServiciosValidados
        accesoXML.agregarServiciosValidados(mecanicoObj, serviciosMarcados);
        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaServiciosValidados;
    // End of variables declaration//GEN-END:variables
}
