package Conceptos;

/**
 * 
 *Elaborado por: Ariel Fernandez Chacon.
 *Carnet: 2019077501
 *Ultima modificacion: 12 de Mayo 1:15 pm.
 *Conceptos
 * 
 */

import javax.swing.table.DefaultTableModel;

public class Mecanico {

    private Integer identificacion;
    private String nombre;
    private String puesto;
    public Integer servicios[];
    public static int cantMecanicos = 0;
    public static Mecanico[] mecanicos = new Mecanico[1000];

    public Mecanico(Integer identificacion, String nombre, String puesto, Integer[] servicios) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.puesto = puesto;

        // Inicializar el arreglo de servicios
        this.servicios = new Integer[1000]; // Tamaño predeterminado

        // Copiar los servicios proporcionados si existen
        if (servicios != null && servicios.length > 0) {
            for (int i = 0; i < servicios.length; i++) {
                this.servicios[i] = servicios[i];
            }
        }

        // Agregar el nuevo mecánico al arreglo de mecánicos
        mecanicos[cantMecanicos] = this;
        cantMecanicos++;
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

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Integer[] getServicios() {
        return servicios;
    }

    public void setServicios(Integer[] servicios) {
        this.servicios = servicios;
    }

    // Método para verificar si ya existe un mecánico con el mismo ID
    public static boolean existeMecanico(int id) {
        for (Mecanico mecanico : mecanicos) {
            if (mecanico != null && mecanico.getIdentificacion() == id) {
                return true;
            }
        }
        return false;
    }

    public static void refrescar(javax.swing.JTable tablaMecanicos) {
        //Refrescar mecánicos
        // Obtener el modelo de la tabla
        DefaultTableModel model = (DefaultTableModel) tablaMecanicos.getModel();

        // Borrar todos los registros actuales de la tabla
        model.setRowCount(0);

        for (Mecanico mecanico : mecanicos) {
            if (mecanico != null) {
                // Aquí debes adaptar cómo obtienes los datos del mecanico para llenar la tabla
                // Esto dependerá de cómo tengas implementada la clase Mecanico
                model.addRow(new Object[]{mecanico.getIdentificacion(), mecanico.getNombre(), mecanico.getPuesto()/*, mecanico.getServicios()*/});
            }
        }
    }
}
