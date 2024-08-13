package Conceptos;

/**
 * 
 *Elaborado por: Ariel Fernandez Chacon.
 *Carnet: 2019077501
 *Ultima modificacion: 12 de Mayo 2:11 pm.
 *Conceptos
 * 
 */

import java.util.Objects;
import javax.swing.table.DefaultTableModel;

public class Servicio {

    private Integer identificacion;
    private String nombre;
    private Integer precio;
    public static int cantServicios = 0;
    public static Servicio[] servicios = new Servicio[1000];

    public Servicio(Integer identificacion, String nombre, Integer precio) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.precio = precio;

        servicios[cantServicios] = this;
        cantServicios++;

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

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    // Método para verificar si ya existe un servicio con el mismo ID
    public static boolean existeServicio(int id) {
        for (Servicio servicio : servicios) {
            if (servicio != null && servicio.getIdentificacion() == id) {
                return true;
            }
        }
        return false;
    }

    public static void refrescar(javax.swing.JTable tablaServicios) {
        //Refrescar servicios
        // Obtener el modelo de la tabla
        DefaultTableModel model = (DefaultTableModel) tablaServicios.getModel();

        // Borrar todos los registros actuales de la tabla
        model.setRowCount(0);

        for (Servicio servicio : servicios) {
            if (servicio != null) {
                // Agregar una nueva fila con los datos del servicio
                model.addRow(new Object[]{servicio.getIdentificacion(), servicio.getNombre(), servicio.getPrecio()});
            }
        }
    }

    public static void refrescarValidacion(javax.swing.JTable tablaServicios, Mecanico mecanico) {
        //Refrescar servicios
        // Obtener el modelo de la tabla
        DefaultTableModel model = (DefaultTableModel) tablaServicios.getModel();

        // Borrar todos los registros actuales de la tabla
        model.setRowCount(0);

        for (Servicio servicio : servicios) {
            if (servicio != null) {
                Boolean servicioValidado = false;

                // Agregar una nueva fila con los datos del servicio
                for (Integer servicioMeca : mecanico.servicios) {
                    if (Objects.equals(servicio.identificacion, servicioMeca)) {
                        servicioValidado = true;
                    }
                }

                model.addRow(new Object[]{servicioValidado, servicio.getNombre()});

            }
        }

    }
}
