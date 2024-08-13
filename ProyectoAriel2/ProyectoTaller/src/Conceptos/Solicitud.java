package Conceptos;

import Util.accesoXML;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import javax.swing.table.DefaultTableModel;

public class Solicitud {

    private Integer identificacion;
    private String placa;
    private Servicio servicio;
    private String tipoServicio;
    private Cliente cliente;
    private String observaciones;
    private Mecanico mecanico;
    private String estado;
    private Servicio[] servicios = new Servicio[10];
    public static int cantSolicitud = 0;
    public static Solicitud[] solicitudes = new Solicitud[1000];

    public Solicitud(Integer identificacion, String placa, Servicio servicio, Cliente cliente, Mecanico mecanico, Servicio[] servicios, String estado, String observaciones) {
        this.identificacion = identificacion;
        this.placa = placa;
        this.servicio = servicio;
        this.cliente = cliente;
        this.observaciones = observaciones;
        this.mecanico = mecanico;
        this.estado = estado;
        this.servicios = servicios;

        solicitudes[cantSolicitud] = this; // Agregar la solicitud al array de solicitudes
        cantSolicitud++;
    }

    public Integer getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Servicio[] getServicios() {
        return servicios;
    }

    public void setServicios(Servicio[] servicios) {
        this.servicios = servicios;
    }

    public static int getCantSolicitud() {
        return cantSolicitud;
    }

    public static void setCantSolicitud(int cantSolicitud) {
        Solicitud.cantSolicitud = cantSolicitud;
    }

    public static Solicitud[] getSolicitudes() {
        return solicitudes;
    }

    public static void setSolicitudes(Solicitud[] solicitudes) {
        Solicitud.solicitudes = solicitudes;
    }

    // Método auxiliar para obtener un servicio por su ID
    private static Servicio obtenerServicioPorId(Integer servicioId) {
        for (Servicio servicio : Servicio.servicios) {
            if (servicio != null && servicio.getIdentificacion() == servicioId) {
                return servicio;
            }
        }
        return null; // Si no se encuentra el servicio, se puede devolver null o manejarlo según sea necesario en tu aplicación.
    }

// Método auxiliar para obtener un cliente por su ID
    private static Cliente obtenerClientePorId(Integer clienteId) {
        for (Cliente cliente : Cliente.clientes) {
            if (cliente != null && cliente.getIdentificacion() == clienteId) {
                return cliente;
            }
        }
        return null; // Si no se encuentra el cliente, se puede devolver null o manejarlo según sea necesario en tu aplicación.
    }

    public static void crear(String placa, Integer servicioId, Integer clienteId, String observaciones) {
        // Obtener el servicio y el cliente correspondientes a partir de sus IDs
        Servicio servicio = obtenerServicioPorId(servicioId);
        Cliente cliente = obtenerClientePorId(clienteId);

        // Generar un ID único de 4 dígitos
        Integer identificacion = generarIdUnico();

        // Crear una nueva instancia de Solicitud y agregarla al array de solicitudes
        Solicitud nuevaSolicitud = new Solicitud(identificacion, placa, servicio, cliente, null, null, "000", observaciones);

        accesoXML.agregarSolicitud(nuevaSolicitud);
    }

// Método para generar un ID único de 4 dígitos
    private static Integer generarIdUnico() {
        Random rand = new Random();
        Integer id;
        boolean repetido;

        do {
            // Generar un número aleatorio de 4 dígitos
            id = rand.nextInt(9000) + 1000;

            // Verificar si el ID generado ya existe en alguna otra solicitud
            repetido = false;
            for (Solicitud solicitud : solicitudes) {
                if (solicitud != null && solicitud.getIdentificacion().equals(id)) {
                    repetido = true;
                    break;
                }
            }
        } while (repetido);

        return id;
    }

    public static void atender(Integer id, String placa, Servicio servicio, Mecanico mecanico, String estado, String observaciones, Servicio[] otrosServicios) {
        try {
            Solicitud objSolicitud = null;
            
            
            for (Solicitud solicitud: solicitudes){
                if(solicitud!=null){
                    System.out.println(solicitud.getIdentificacion());
                    if(Objects.equals(solicitud.getIdentificacion(), id)){
                        System.out.println("Encontrado");
                        objSolicitud = solicitud;
                        break;
                    }
                }
            }
            
            System.out.println(objSolicitud);
            
            // Buscar el ID del estado por su nombre
            String estadoId = obtenerIdEstadoPorNombre(estado);
            if (estadoId == null) {
                System.out.println("Error: Estado no encontrado.");
                return;
            }            

            // Actualizar los atributos de la solicitud
            objSolicitud.placa = placa;
            objSolicitud.servicio = servicio;
            objSolicitud.mecanico = mecanico;
            objSolicitud.estado = estadoId;
            objSolicitud.observaciones = observaciones;
            objSolicitud.servicios = otrosServicios;
            
            /*/ Imprimir la información recibida para verificar
            System.out.println(this.placa);
            System.out.println(this.servicio.getNombre());
            System.out.println(this.mecanico.getNombre());
            System.out.println(this.estado);
            System.out.println(this.observaciones);
            System.out.println(Arrays.toString(this.servicios));*/
            
            System.out.println("ID " + objSolicitud.identificacion);
            // Llamar a la función modificarSolicitud para actualizar los datos en el archivo XML
            accesoXML.modificarSolicitud(objSolicitud);
        } catch (Exception e) {
            System.out.println("Error al atender solicitud: " + e.getMessage());
        }
    }

    private static String obtenerIdEstadoPorNombre(String nombreEstado) {
        try {
            // Obtener el mapa de estados
            HashMap<String, String> estadosMap = accesoXML.leerEstados();

            // Buscar el ID del estado por su nombre
            for (Map.Entry<String, String> entry : estadosMap.entrySet()) {
                if (entry.getValue().equals(nombreEstado)) {
                    return entry.getKey();
                }
            }
        } catch (Exception e) {
            System.out.println("Error al obtener ID del estado por nombre: " + e.getMessage());
        }
        return null;
    }

    public static void consultar(javax.swing.JTable tablaSolicitudes, String filtroEstado, String filtroTelefono, String filtroPlaca, String filtroEmail) {
        // Refrescar clientes
        // Obtener el modelo de la tabla
        DefaultTableModel model = (DefaultTableModel) tablaSolicitudes.getModel();

        // Borrar todos los registros actuales de la tabla
        model.setRowCount(0);

        HashMap<String, String> estados = accesoXML.leerEstados();

        // Verificar si hay solicitudes para mostrar
        // Iterar sobre las solicitudes y agregarlas a la tabla si coinciden con el filtro
        for (Solicitud solicitud : solicitudes) {
            if (solicitud != null
                    && ("-1".equals(filtroEstado) || solicitud.estado.equals(filtroEstado))
                    && ("".equals(filtroTelefono) || solicitud.cliente.getTelefono().equals(filtroTelefono))
                    && ("".equals(filtroPlaca) || solicitud.placa.equals(filtroPlaca))
                    && ("".equals(filtroEmail) || solicitud.cliente.getEmail().equals(filtroEmail))) {

                String estado = estados.get(solicitud.estado);

                model.addRow(new Object[]{solicitud.placa, solicitud.cliente.getNombre(), solicitud.servicio.getNombre(), estado});
            }
        }
    }
}
