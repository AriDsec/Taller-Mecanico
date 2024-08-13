package Presentacion;
/**
 * 
 *Elaborado por: Ariel Fernandez Chacon.
 *Carnet: 2019077501
 *Ultima modificacion: 12 de Junio 05:30 pm.
 *GUI
 * 
 */

public class InterfazMecanico extends javax.swing.JFrame {

    public InterfazMecanico() {
        initComponents();
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuItemConsultar = new javax.swing.JMenuItem();
        menuItemSolicitar = new javax.swing.JMenuItem();
        menuItemAtender = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuItemClientes = new javax.swing.JMenuItem();
        menuItemServicios = new javax.swing.JMenuItem();
        menuItemMecanicos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setSize(new java.awt.Dimension(1024, 768));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mecanico.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(jLabel1)
                .addContainerGap(342, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(313, Short.MAX_VALUE))
        );

        jMenu1.setText("Archivo");

        menuItemConsultar.setText("Consultar");
        menuItemConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemConsultarActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemConsultar);

        menuItemSolicitar.setText("Solicitar");
        menuItemSolicitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSolicitarActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemSolicitar);

        menuItemAtender.setText("Atender");
        menuItemAtender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAtenderActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemAtender);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Util");

        menuItemClientes.setText("Clientes");
        menuItemClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemClientesActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemClientes);

        menuItemServicios.setText("Servicios");
        menuItemServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemServiciosActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemServicios);

        menuItemMecanicos.setText("Mecánicos");
        menuItemMecanicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemMecanicosActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemMecanicos);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemClientesActionPerformed
        ClientesGUI vtnClientes = new ClientesGUI();
        
        vtnClientes.setVisible(true);
    }//GEN-LAST:event_menuItemClientesActionPerformed

    private void menuItemServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemServiciosActionPerformed
        ServiciosGUI vtnServicios = new ServiciosGUI();
        
        vtnServicios.setVisible(true);
    }//GEN-LAST:event_menuItemServiciosActionPerformed

    private void menuItemMecanicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemMecanicosActionPerformed
        MecanicosGUI vtnMecanicos = new MecanicosGUI();
        
        vtnMecanicos.setVisible(true);
    }//GEN-LAST:event_menuItemMecanicosActionPerformed

    private void menuItemSolicitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSolicitarActionPerformed
        CreaSolicitudGUI vtnSolicitarSolicitud = new CreaSolicitudGUI();
        
        vtnSolicitarSolicitud.setVisible(true);
    }//GEN-LAST:event_menuItemSolicitarActionPerformed

    private void menuItemConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemConsultarActionPerformed

        ConsultarSolicitudGUI vtnConsultarSolicitud = new ConsultarSolicitudGUI();
        
        vtnConsultarSolicitud.setVisible(true);
    }//GEN-LAST:event_menuItemConsultarActionPerformed

    private void menuItemAtenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAtenderActionPerformed
        AtenderSolicitudGUI vtnAtenderSolicitud = new AtenderSolicitudGUI();
        
        vtnAtenderSolicitud.setVisible(true);
    }//GEN-LAST:event_menuItemAtenderActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            //new InterfazMecanico().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem menuItemAtender;
    private javax.swing.JMenuItem menuItemClientes;
    private javax.swing.JMenuItem menuItemConsultar;
    private javax.swing.JMenuItem menuItemMecanicos;
    private javax.swing.JMenuItem menuItemServicios;
    private javax.swing.JMenuItem menuItemSolicitar;
    // End of variables declaration//GEN-END:variables
}
