package Aplicacion;

/**
 * 
 *Elaborado por: Ariel Fernandez Chacon.
 *Carnet: 2019077501
 *Ultima modificacion: 12 de Junio 1:05 pm.
 *Main
 * 
 */

import Presentacion.InterfazMecanico;
import Util.accesoXML;

public class ProyectoMecanico {
    public static void main(String[] args){
       InterfazMecanico mecanicoGUI = new InterfazMecanico();
    
       //Leer los datos de los XML
       accesoXML.leerClientes();
       accesoXML.leerMecanicos();
       accesoXML.leerServicios();
       accesoXML.leerSolicitudes();
       
       mecanicoGUI.setVisible(true);
    }
}
