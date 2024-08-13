package Conceptos;

/**
 * 
 *Elaborado por: Ariel Fernandez Chacon.
 *Carnet: 2019077501
 *Ultima modificacion: 12 de Mayo 12:15 pm.
 *Conceptos
 * 
 */

import javax.swing.table.DefaultTableModel;

public class Cliente {

    private Integer identificacion;
    private String nombre;
    private String telefono;
    private String email;
    private String placa;
    public static int cantClientes = 0;
    public static Cliente[] clientes = new Cliente[1000];

    public Cliente(int identificacion, String nombre, String telefono, String email, String placa) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.placa = placa;

        clientes[cantClientes] = this;
        cantClientes++;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Método para verificar si ya existe un cliente con el mismo ID
    public static boolean existeCliente(int id) {
        for (Cliente cliente : clientes) {
            if (cliente != null && cliente.getIdentificacion() == id) {
                return true;
            }
        }
        return false;
    }

    public static void refrescar(javax.swing.JTable tablaClientes) {
        //Refrescar clientes
        // Obtener el modelo de la tabla
        DefaultTableModel model = (DefaultTableModel) tablaClientes.getModel();

        // Borrar todos los registros actuales de la tabla
        model.setRowCount(0);

        for (Cliente cliente : clientes) {
            if (cliente != null) {
                model.addRow(new Object[]{cliente.identificacion, cliente.nombre, cliente.telefono, cliente.email, cliente.placa});
            }

        }
    }
}
