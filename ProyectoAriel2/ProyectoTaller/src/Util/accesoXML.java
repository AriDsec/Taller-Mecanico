package Util;

/**
 * 
 *Elaborado por: Ariel Fernandez Chacon.
 *Carnet: 2019077501
 *Ultima modificacion: 12 de Junio 07:28 pm.
 *UTIL
 * 
 */

import Conceptos.Cliente;
import Conceptos.Mecanico;
import Conceptos.Servicio;
import Conceptos.Solicitud;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class accesoXML {

    public static void agregarCliente(Cliente cliente) {
        try {
            // Cargar el archivo XML
            File xmlFile = new File("src/Util/Data/clientes.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Crear un nuevo elemento cliente
            Element nuevoCliente = doc.createElement("cliente");
            nuevoCliente.setAttribute("id", cliente.getIdentificacion().toString());

            Element nombreElement = doc.createElement("nombre");
            nombreElement.appendChild(doc.createTextNode(cliente.getNombre()));
            nuevoCliente.appendChild(nombreElement);

            Element placaElement = doc.createElement("placa");
            placaElement.appendChild(doc.createTextNode(cliente.getPlaca()));
            nuevoCliente.appendChild(placaElement);

            Element telefonoElement = doc.createElement("telefono");
            telefonoElement.appendChild(doc.createTextNode(cliente.getTelefono()));
            nuevoCliente.appendChild(telefonoElement);

            Element emailElement = doc.createElement("email");
            emailElement.appendChild(doc.createTextNode(cliente.getEmail()));
            nuevoCliente.appendChild(emailElement);

            // Agregar el nuevo cliente al elemento raíz
            doc.getDocumentElement().appendChild(nuevoCliente);

            // Guardar los cambios en el archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(xmlFile);
            transformer.transform(source, result);
        } catch (Exception e) {
            System.out.println("Error al agregar cliente: " + e.getMessage());
        }
    }

    public static void modificarCliente(Cliente clienteModificado) {
        try {
            // Cargar el archivo XML
            File xmlFile = new File("src/Util/Data/clientes.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Obtener la lista de nodos de clientes
            NodeList clienteNodes = doc.getElementsByTagName("cliente");

            // Recorrer cada nodo cliente y encontrar el que tenga el ID especificado
            for (int i = 0; i < clienteNodes.getLength(); i++) {
                Element clienteElement = (Element) clienteNodes.item(i);
                String clienteId = clienteElement.getAttribute("id");
                if (clienteId.equals(String.valueOf(clienteModificado.getIdentificacion()))) {
                    // Modificar los datos del cliente en el XML
                    clienteElement.getElementsByTagName("nombre").item(0).setTextContent(clienteModificado.getNombre());
                    clienteElement.getElementsByTagName("placa").item(0).setTextContent(clienteModificado.getPlaca());
                    clienteElement.getElementsByTagName("telefono").item(0).setTextContent(clienteModificado.getTelefono());
                    clienteElement.getElementsByTagName("email").item(0).setTextContent(clienteModificado.getEmail());

                    // Guardar los cambios en el archivo XML
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                    DOMSource source = new DOMSource(doc);
                    StreamResult result = new StreamResult(xmlFile);
                    transformer.transform(source, result);

                    break; // Terminar el bucle una vez que se haya modificado el cliente
                }
            }
        } catch (Exception e) {
            System.out.println("Error al modificar cliente: " + e.getMessage());
        }
    }

    public static void borrarCliente(int id, javax.swing.JTable tablaClientes) {
        try {
            // Cargar el archivo XML
            File xmlFile = new File("src/Util/Data/clientes.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Obtener la lista de nodos de clientes
            NodeList clienteNodes = doc.getElementsByTagName("cliente");

            // Recorrer cada nodo cliente y encontrar el que tenga el ID especificado
            for (int i = 0; i < clienteNodes.getLength(); i++) {
                Element clienteElement = (Element) clienteNodes.item(i);
                String clienteId = clienteElement.getAttribute("id");
                if (clienteId.equals(String.valueOf(id))) {
                    // Eliminar el nodo cliente
                    clienteElement.getParentNode().removeChild(clienteElement);
                    System.out.println("Cliente con ID " + id + " borrado del XML.");
                    break; // Terminar el bucle una vez que se encuentre y borre el cliente
                }
            }

            // Guardar los cambios en el archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(xmlFile);
            transformer.transform(source, result);

        } catch (IOException | IllegalArgumentException | ParserConfigurationException | TransformerException | DOMException | SAXException e) {
            System.out.println("Error al borrar cliente: " + e.getMessage());
        }//Borrarlo del XML

        //Borrarlo de la LISTA
        try {
            // Buscar el cliente en la lista de clientes
            Cliente clienteABorrar = null;
            for (Cliente cliente : Cliente.clientes) {
                if (cliente != null && cliente.getIdentificacion().equals(id)) {
                    clienteABorrar = cliente;
                    break;
                }
            }

            if (clienteABorrar != null) {
                // Eliminar el cliente de la lista de clientes
                for (int i = 0; i < Cliente.cantClientes; i++) {
                    if (Cliente.clientes[i] != null && Cliente.clientes[i].getIdentificacion().equals(id)) {
                        Cliente.clientes[i] = null;
                        break;
                    }
                }

                // Refrescar la tabla de clientes
                Cliente.refrescar(tablaClientes);
            } else {
                System.out.println("No se encontró ningún cliente con el ID " + id + " en la lista de clientes.");
            }
        } catch (Exception e) {
            System.out.println("Error al borrar cliente: " + e.getMessage());
        }
    }

    public static void leerClientes() {
        try {
            // Cargar el archivo XML
            File xmlFile = new File("src/Util/Data/clientes.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Obtener la lista de nodos de clientes
            NodeList clienteNodes = doc.getElementsByTagName("cliente");

            // Recorrer cada nodo cliente y crear objetos Cliente
            for (int i = 0; i < clienteNodes.getLength(); i++) {
                Element clienteElement = (Element) clienteNodes.item(i);
                String id = clienteElement.getAttribute("id");
                String nombre = clienteElement.getElementsByTagName("nombre").item(0).getTextContent();
                String placa = clienteElement.getElementsByTagName("placa").item(0).getTextContent();
                String telefono = clienteElement.getElementsByTagName("telefono").item(0).getTextContent();
                String email = clienteElement.getElementsByTagName("email").item(0).getTextContent();

                Cliente cliente = new Cliente(Integer.parseInt(id), nombre, telefono, email, placa);
            }
        } catch (IOException | NumberFormatException | ParserConfigurationException | DOMException | SAXException e) {
            System.out.println("Error al leer clientes: " + e.getMessage());
        }
    }

    public static void leerMecanicos() {
        try {
            // Cargar el archivo XML
            File xmlFile = new File("src/Util/Data/mecanicos.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Obtener la lista de nodos de mecánicos
            NodeList mecanicoNodes = doc.getElementsByTagName("mecanico");

            // Recorrer cada nodo mecánico y crear objetos Mecanico
            for (int i = 0; i < mecanicoNodes.getLength(); i++) {
                Element mecanicoElement = (Element) mecanicoNodes.item(i);
                String id = mecanicoElement.getAttribute("id");
                String nombre = mecanicoElement.getElementsByTagName("nombre").item(0).getTextContent();
                String puesto = mecanicoElement.getElementsByTagName("puesto").item(0).getTextContent();

                // Obtener la lista de servicios
                NodeList serviciosNodes = mecanicoElement.getElementsByTagName("id");
                Integer[] servicios = new Integer[serviciosNodes.getLength()];

                for (int j = 0; j < serviciosNodes.getLength(); j++) {
                    String contenido = serviciosNodes.item(j).getTextContent();
                    if (!contenido.isEmpty()) {
                        servicios[j] = Integer.parseInt(contenido);
                    }
                }

                Mecanico mecanico = new Mecanico(Integer.parseInt(id), nombre, puesto, servicios);
            }
        } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
            System.out.println("Error al leer mecánicos: " + e.getMessage());
        }
    }

    public static void agregarMecanico(Mecanico mecanico) throws TransformerException {
        try {
            // Cargar el archivo XML
            File xmlFile = new File("src/Util/Data/mecanicos.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Crear un nuevo elemento mecanico
            Element nuevoMecanico = doc.createElement("mecanico");
            nuevoMecanico.setAttribute("id", String.valueOf(mecanico.getIdentificacion()));

            Element nombreElement = doc.createElement("nombre");
            nombreElement.appendChild(doc.createTextNode(mecanico.getNombre()));
            nuevoMecanico.appendChild(nombreElement);

            Element puestoElement = doc.createElement("puesto");
            puestoElement.appendChild(doc.createTextNode(mecanico.getPuesto()));
            nuevoMecanico.appendChild(puestoElement);

            Element serviciosElement = doc.createElement("servicios");
            nuevoMecanico.appendChild(serviciosElement);

            doc.getDocumentElement().appendChild(nuevoMecanico);

            // Guardar los cambios en el archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(xmlFile);
            transformer.transform(source, result);
        } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
            System.out.println("Error al agregar mecánico: " + e.getMessage());
        }
    }

    public static void modificarMecanico(Mecanico mecanicoModificado) {
        try {
            // Cargar el archivo XML
            File xmlFile = new File("src/Util/Data/mecanicos.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Obtener la lista de nodos de mecánicos
            NodeList mecanicoNodes = doc.getElementsByTagName("mecanico");

            // Recorrer cada nodo mecánico y encontrar el que tenga el ID especificado
            for (int i = 0; i < mecanicoNodes.getLength(); i++) {
                Element mecanicoElement = (Element) mecanicoNodes.item(i);
                String mecanicoId = mecanicoElement.getAttribute("id");
                if (mecanicoId.equals(String.valueOf(mecanicoModificado.getIdentificacion()))) {
                    // Modificar los datos del mecánico en el XML
                    mecanicoElement.getElementsByTagName("nombre").item(0).setTextContent(mecanicoModificado.getNombre());
                    mecanicoElement.getElementsByTagName("puesto").item(0).setTextContent(mecanicoModificado.getPuesto());
                    // Puedes manejar la modificación de los servicios según tu implementación
                    // Esto dependerá de cómo se almacenen los servicios en tu clase Mecanico

                    // Guardar los cambios en el archivo XML
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                    DOMSource source = new DOMSource(doc);
                    StreamResult result = new StreamResult(xmlFile);
                    transformer.transform(source, result);

                    break; // Terminar el bucle una vez que se haya modificado el mecánico
                }
            }
        } catch (IOException | IllegalArgumentException | ParserConfigurationException | TransformerException | DOMException | SAXException e) {
            System.out.println("Error al modificar mecánico: " + e.getMessage());
        }
    }

    public static void borrarMecanico(int id, javax.swing.JTable tablaMecanicos) {
        try {
            // Cargar el archivo XML
            File xmlFile = new File("src/Util/Data/mecanicos.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Obtener la lista de nodos de mecánicos
            NodeList mecanicoNodes = doc.getElementsByTagName("mecanico");

            // Recorrer cada nodo mecánico y encontrar el que tenga el ID especificado
            for (int i = 0; i < mecanicoNodes.getLength(); i++) {
                Element mecanicoElement = (Element) mecanicoNodes.item(i);
                String mecanicoId = mecanicoElement.getAttribute("id");
                if (mecanicoId.equals(String.valueOf(id))) {
                    // Eliminar el nodo mecánico
                    mecanicoElement.getParentNode().removeChild(mecanicoElement);
                    break; // Terminar el bucle una vez que se encuentre y borre el mecánico
                }
            }

            // Guardar los cambios en el archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(xmlFile);
            transformer.transform(source, result);
            Mecanico.refrescar(tablaMecanicos);
        } catch (IOException | IllegalArgumentException | ParserConfigurationException | TransformerException | DOMException | SAXException e) {
            System.out.println("Error al borrar mecánico: " + e.getMessage());
        }

        //Borrarlo de la LISTA
        try {
            // Buscar el mecánico en la lista de mecánicos
            Mecanico mecanicoABorrar = null;
            for (Mecanico mecanico : Mecanico.mecanicos) {
                if (mecanico != null && mecanico.getIdentificacion() == id) {
                    mecanicoABorrar = mecanico;
                    break;
                }
            }

            if (mecanicoABorrar != null) {
                // Eliminar el mecánico de la lista de mecánicos
                for (int i = 0; i < Mecanico.mecanicos.length; i++) {
                    if (Mecanico.mecanicos[i] != null && Mecanico.mecanicos[i].getIdentificacion() == id) {
                        Mecanico.mecanicos[i] = null;
                        break;
                    }
                }

                // Refrescar la tabla de mecánicos
                Mecanico.refrescar(tablaMecanicos);
            } else {
                System.out.println("No se encontró ningún mecánico con el ID " + id + " en la lista de mecánicos.");
            }
        } catch (Exception e) {
            System.out.println("Error al borrar mecánico: " + e.getMessage());
        }
    }

    public static void agregarServicio(Servicio servicio) {
        try {
            // Cargar el archivo XML
            File xmlFile = new File("src/Util/Data/servicios.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Crear un nuevo elemento servicio
            Element nuevoServicio = doc.createElement("servicio");
            nuevoServicio.setAttribute("id", servicio.getIdentificacion().toString());

            Element nombreElement = doc.createElement("nombre");
            nombreElement.appendChild(doc.createTextNode(servicio.getNombre()));
            nuevoServicio.appendChild(nombreElement);

            Element precioElement = doc.createElement("precio");
            precioElement.appendChild(doc.createTextNode(servicio.getPrecio().toString()));
            nuevoServicio.appendChild(precioElement);

            // Agregar el nuevo servicio al elemento raíz
            doc.getDocumentElement().appendChild(nuevoServicio);

            // Guardar los cambios en el archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(xmlFile);
            transformer.transform(source, result);
        } catch (IOException | IllegalArgumentException | ParserConfigurationException | TransformerException | DOMException | SAXException e) {
            System.out.println("Error al agregar servicio: " + e.getMessage());
        }
    }

    public static void modificarServicio(Servicio servicioModificado) {
        try {
            // Cargar el archivo XML
            File xmlFile = new File("src/Util/Data/servicios.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Obtener la lista de nodos de servicios
            NodeList servicioNodes = doc.getElementsByTagName("servicio");

            // Recorrer cada nodo servicio y encontrar el que tenga el ID especificado
            for (int i = 0; i < servicioNodes.getLength(); i++) {
                Element servicioElement = (Element) servicioNodes.item(i);
                String servicioId = servicioElement.getAttribute("id");
                if (servicioId.equals(String.valueOf(servicioModificado.getIdentificacion()))) {
                    // Modificar los datos del servicio en el XML
                    servicioElement.getElementsByTagName("nombre").item(0).setTextContent(servicioModificado.getNombre());
                    servicioElement.getElementsByTagName("precio").item(0).setTextContent(servicioModificado.getPrecio().toString());

                    // Guardar los cambios en el archivo XML
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                    DOMSource source = new DOMSource(doc);
                    StreamResult result = new StreamResult(xmlFile);
                    transformer.transform(source, result);

                    break; // Terminar el bucle una vez que se haya modificado el servicio
                }
            }
        } catch (IOException | IllegalArgumentException | ParserConfigurationException | TransformerException | DOMException | SAXException e) {
            System.out.println("Error al modificar servicio: " + e.getMessage());
        }
    }

    public static void borrarServicio(int id, javax.swing.JTable tablaServicios) {
        try {
            // Cargar el archivo XML
            File xmlFile = new File("src/Util/Data/servicios.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Obtener la lista de nodos de servicios
            NodeList servicioNodes = doc.getElementsByTagName("servicio");

            // Recorrer cada nodo servicio y encontrar el que tenga el ID especificado
            for (int i = 0; i < servicioNodes.getLength(); i++) {
                Element servicioElement = (Element) servicioNodes.item(i);
                String servicioId = servicioElement.getAttribute("id");
                if (servicioId.equals(String.valueOf(id))) {
                    // Eliminar el nodo servicio
                    servicioElement.getParentNode().removeChild(servicioElement);
                    break; // Terminar el bucle una vez que se encuentre y borre el servicio
                }
            }

            // Guardar los cambios en el archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(xmlFile);
            transformer.transform(source, result);

            Servicio.refrescar(tablaServicios);
        } catch (IOException | IllegalArgumentException | ParserConfigurationException | TransformerException | DOMException | SAXException e) {
            System.out.println("Error al borrar servicio: " + e.getMessage());
        }

        //Borrarlo de la LISTA
        try {
            // Buscar el mecánico en la lista de mecánicos
            Servicio servicioABorrar = null;
            for (Servicio servicio : Servicio.servicios) {
                if (servicio != null && servicio.getIdentificacion() == id) {
                    servicioABorrar = servicio;
                    break;
                }
            }

            if (servicioABorrar != null) {
                // Eliminar el mecánico de la lista de mecánicos
                for (int i = 0; i < Servicio.servicios.length; i++) {
                    if (Servicio.servicios[i] != null && Servicio.servicios[i].getIdentificacion() == id) {
                        Servicio.servicios[i] = null;
                        break;
                    }
                }

                // Refrescar la tabla de mecánicos
                Servicio.refrescar(tablaServicios);
            } else {
                System.out.println("No se encontró ningún mecánico con el ID " + id + " en la lista de servicios.");
            }
        } catch (Exception e) {
            System.out.println("Error al borrar servicio: " + e.getMessage());
        }
    }

    public static void leerServicios() {
        try {
            // Cargar el archivo XML
            File xmlFile = new File("src/Util/Data/servicios.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Obtener la lista de nodos de servicios
            NodeList servicioNodes = doc.getElementsByTagName("servicio");

            // Recorrer cada nodo servicio y mostrar los datos
            for (int i = 0; i < servicioNodes.getLength(); i++) {
                Element servicioElement = (Element) servicioNodes.item(i);
                String id = servicioElement.getAttribute("id");
                String nombre = servicioElement.getElementsByTagName("nombre").item(0).getTextContent();
                String precio = servicioElement.getElementsByTagName("precio").item(0).getTextContent();

                Servicio servicio = new Servicio(Integer.parseInt(id), nombre, Integer.parseInt(precio));
            }
        } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
            System.out.println("Error al leer servicios: " + e.getMessage());
        }
    }

    public static void agregarServiciosValidados(Mecanico mecanico, Integer servicios[]) {
        try {
            // Cargar el archivo XML
            File xmlFile = new File("src/Util/Data/mecanicos.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Obtener la lista de nodos de mecánicos
            NodeList mecanicoNodes = doc.getElementsByTagName("mecanico");

            // Recorrer cada nodo mecánico y encontrar el que tenga el ID especificado
            for (int i = 0; i < mecanicoNodes.getLength(); i++) {
                Element mecanicoElement = (Element) mecanicoNodes.item(i);
                String mecanicoId = mecanicoElement.getAttribute("id");
                if (mecanicoId.equals(String.valueOf(mecanico.getIdentificacion()))) {
                    // Eliminar el nodo servicios existentes del mecánico
                    NodeList serviciosNodes = mecanicoElement.getElementsByTagName("servicios");
                    for (int j = 0; j < serviciosNodes.getLength(); j++) {
                        mecanicoElement.removeChild(serviciosNodes.item(j));
                    }

                    // Agregar los nuevos servicios al mecánico
                    Element serviciosElement = doc.createElement("servicios");
                    mecanicoElement.appendChild(serviciosElement);
                    for (Integer servicio : servicios) {
                        if (servicio != null) {
                            Element nuevoServicio = doc.createElement("id");
                            nuevoServicio.appendChild(doc.createTextNode(String.valueOf(servicio)));
                            serviciosElement.appendChild(nuevoServicio);
                        }
                    }

                    break;
                }
            }

            // Guardar los cambios en el archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(xmlFile);
            transformer.transform(source, result);
        } catch (IOException | IllegalArgumentException | ParserConfigurationException | TransformerException | DOMException | SAXException e) {
            System.out.println("Error al agregar servicios al mecánico: " + e.getMessage());
        }

        // Actualizar la lista de mecánicos
        try {
            if (mecanico != null) {
                // Agregar los servicios al mecánico en la lista
                for (int i = 0; i < Mecanico.mecanicos.length; i++) {
                    if (Mecanico.mecanicos[i] != null && Objects.equals(Mecanico.mecanicos[i].getIdentificacion(), mecanico.getIdentificacion())) {
                        Mecanico.mecanicos[i].setServicios(servicios);
                        break;
                    }
                }
            } else {
                System.out.println("No se encontró ningún mecánico con el ID " + mecanico.getIdentificacion() + " en la lista de mecánicos.");
            }
        } catch (Exception e) {
            System.out.println("Error al agregar los servicios al mecánico: " + e.getMessage());
        }

    }

    public static void leerSolicitudes() {
        try {
            // Cargar el archivo XML
            File xmlFile = new File("src/Util/Data/solicitudes.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Obtener la lista de nodos de servicios
            NodeList solicitudNodes = doc.getElementsByTagName("solicitud");

            // Recorrer cada nodo servicio y mostrar los datos        
            for (int i = 0; i < solicitudNodes.getLength(); i++) {
                Element servicioElement = (Element) solicitudNodes.item(i);
                String id = servicioElement.getAttribute("id");
                String placa = servicioElement.getElementsByTagName("placa").item(0).getTextContent();
                String servicio = servicioElement.getElementsByTagName("servicio").item(0).getTextContent();
                String cliente = servicioElement.getElementsByTagName("cliente").item(0).getTextContent();
                String mecanico = servicioElement.getElementsByTagName("mecanico").item(0).getTextContent();
                String estado = servicioElement.getElementsByTagName("estado").item(0).getTextContent();
                String observaciones = servicioElement.getElementsByTagName("observaciones").item(0).getTextContent();

                // Obtener la lista de servicios
                NodeList serviciosNodes = servicioElement.getElementsByTagName("id");
                Integer[] servicios = new Integer[serviciosNodes.getLength()];

                for (int j = 0; j < serviciosNodes.getLength(); j++) {
                    String contenido = serviciosNodes.item(j).getTextContent();
                    if (!contenido.isEmpty()) {
                        servicios[j] = Integer.valueOf(contenido);
                    }
                }

                /*System.out.println(id);
                System.out.println(placa);
                System.out.println(servicio);
                System.out.println(cliente);
                System.out.println(mecanico);
                System.out.println(estado);
                System.out.println(observaciones);
                System.out.println(Arrays.toString(servicios));*/ //Lista de objetos
                Servicio objServicio = null;
                for (Servicio s : Servicio.servicios) {
                    if (s != null) {
                        if (Objects.equals(s.getIdentificacion(), Integer.valueOf(servicio))) {
                            objServicio = s;
                        }
                    }
                }

                Cliente objCliente = null;
                for (Cliente c : Cliente.clientes) {
                    if (c != null) {
                        if (Objects.equals(c.getIdentificacion(), Integer.valueOf(cliente))) {
                            objCliente = c;
                        }
                    }
                }

                Mecanico objMecanico = null;
                try {
                    for (Mecanico m : Mecanico.mecanicos) {
                        if (m != null) {
                            if (Objects.equals(m.getIdentificacion(), Integer.valueOf(mecanico))) {
                                objMecanico = m;
                            }
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }

                Servicio objServicios[] = new Servicio[10];
                int index = 0; // Índice para rastrear la posición en objServicios

                for (int idServicio : servicios) {
                    for (Servicio s : Servicio.servicios) {
                        if (s != null && Objects.equals(idServicio, s.getIdentificacion())) {
                            if (index < objServicios.length) {
                                objServicios[index++] = s; // Asigna el objeto Servicio y luego incrementa el índice
                            } else {
                                break; // Si se llena el array, sale del bucle
                            }
                        }
                    }
                }

                Solicitud solicitud = new Solicitud(Integer.parseInt(id), placa, objServicio, objCliente, objMecanico, objServicios, estado, observaciones);
            }
        } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
            System.out.println("Error al leer solicitudes: " + e.getMessage());
        }
    }

    // Método para agregar una nueva solicitud al archivo XML
    public static void agregarSolicitud(Solicitud nuevaSolicitud) {
        try {
            File xmlFile = new File("src/Util/Data/solicitudes.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            Element rootElement = doc.getDocumentElement();

            // Crear el elemento solicitud
            Element solicitudElement = doc.createElement("solicitud");
            solicitudElement.setAttribute("id", String.valueOf(nuevaSolicitud.getIdentificacion()));

            // Crear los elementos dentro de la solicitud
            Element placaElement = doc.createElement("placa");
            placaElement.appendChild(doc.createTextNode(nuevaSolicitud.getPlaca()));
            solicitudElement.appendChild(placaElement);

            Element servicioElement = doc.createElement("servicio");
            servicioElement.appendChild(doc.createTextNode(String.valueOf(nuevaSolicitud.getServicio().getIdentificacion())));
            solicitudElement.appendChild(servicioElement);

            Element clienteElement = doc.createElement("cliente");
            clienteElement.appendChild(doc.createTextNode(String.valueOf(nuevaSolicitud.getCliente().getIdentificacion())));
            solicitudElement.appendChild(clienteElement);

            Element mecanicoElement = doc.createElement("mecanico");
            mecanicoElement.appendChild(doc.createTextNode(null));
            solicitudElement.appendChild(mecanicoElement);

            Element estadoElement = doc.createElement("estado");
            estadoElement.appendChild(doc.createTextNode("000"));
            solicitudElement.appendChild(estadoElement);

            Element observacionesElement = doc.createElement("observaciones");
            observacionesElement.appendChild(doc.createTextNode(nuevaSolicitud.getObservaciones()));
            solicitudElement.appendChild(observacionesElement);

            Element otrosServiciosElement = doc.createElement("otros_servicios");

            if (nuevaSolicitud.getServicios() != null) {
                for (Servicio otroServicio : nuevaSolicitud.getServicios()) {
                    Element idElement = doc.createElement("id");
                    idElement.appendChild(doc.createTextNode(otroServicio.getNombre()));
                    otrosServiciosElement.appendChild(idElement);
                }
            }

            solicitudElement.appendChild(otrosServiciosElement);
            rootElement.appendChild(solicitudElement);

            // Guardar los cambios en el archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(xmlFile);
            transformer.transform(source, result);
        } catch (IOException | IllegalArgumentException | ParserConfigurationException | TransformerException | DOMException | org.xml.sax.SAXException e) {
            System.out.println("Error al agregar la solicitud: " + e.getMessage());
        }
    }

    public static HashMap<String, String> leerEstados() {
        LinkedHashMap<String, String> estadosMap = new LinkedHashMap<>(); // Usamos LinkedHashMap para mantener el orden de inserción

        // Agregar el elemento "Todo" primero
        estadosMap.put("-1", "Todo");

        try {
            // Cargar el archivo XML
            File xmlFile = new File("src/Util/Data/estados.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Obtener la lista de nodos de estados
            NodeList estadosNodes = doc.getElementsByTagName("estado");

            // Recorrer cada nodo estado y agregarlo al LinkedHashMap
            for (int i = 0; i < estadosNodes.getLength(); i++) {
                Element estadoElement = (Element) estadosNodes.item(i);
                String id = estadoElement.getAttribute("id");
                String nombre = estadoElement.getElementsByTagName("nombre").item(0).getTextContent();
                estadosMap.put(id, nombre);
            }
        } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
            System.out.println("Error al leer estados: " + e.getMessage());
        }

        return estadosMap;
    }

    public static void modificarSolicitud(Solicitud solicitudModificada) {
        try {
            // Cargar el archivo XML
            File xmlFile = new File("src/Util/Data/solicitudes.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Obtener la lista de nodos de solicitudes
            NodeList solicitudNodes = doc.getElementsByTagName("solicitud");

            // Recorrer cada nodo solicitud y encontrar el que tenga el ID especificado
            for (int i = 0; i < solicitudNodes.getLength(); i++) {
                Element solicitudElement = (Element) solicitudNodes.item(i);
                String solicitudId = solicitudElement.getAttribute("id");
                if (solicitudId.equals(String.valueOf(solicitudModificada.getIdentificacion()))) {
                    
                    // Modificar los datos de la solicitud en el XML
                    solicitudElement.getElementsByTagName("placa").item(0).setTextContent(solicitudModificada.getPlaca());
                    solicitudElement.getElementsByTagName("estado").item(0).setTextContent(solicitudModificada.getEstado());
                    solicitudElement.getElementsByTagName("observaciones").item(0).setTextContent(solicitudModificada.getObservaciones());

                    // Modificar el servicio
                    NodeList servicioNodeList = solicitudElement.getElementsByTagName("servicio");
                    for (int j = 0; j < servicioNodeList.getLength(); j++) {
                        Element servicioElement = (Element) servicioNodeList.item(j);
                        servicioElement.setTextContent(String.valueOf(solicitudModificada.getServicio().getIdentificacion()));
                    }

                    // Modificar el mecanico
                    NodeList mecanicoNodeList = solicitudElement.getElementsByTagName("mecanico");
                    for (int j = 0; j < mecanicoNodeList.getLength(); j++) {
                        Element mecanicoElement = (Element) mecanicoNodeList.item(j);
                        mecanicoElement.setTextContent(String.valueOf(solicitudModificada.getMecanico().getIdentificacion()));
                    }

                    // Modificar otros_servicios
                    NodeList otrosServiciosNodeList = solicitudElement.getElementsByTagName("otros_servicios");
                    for (int j = 0; j < otrosServiciosNodeList.getLength(); j++) {
                        Element otrosServiciosElement = (Element) otrosServiciosNodeList.item(j);
                        // Aquí deberías actualizar la lógica para modificar los otros servicios según tus necesidades.
                        // No se incluye la implementación específica aquí ya que no se proporciona el código relacionado.
                    }

                    // Guardar los cambios en el archivo XML
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                    DOMSource source = new DOMSource(doc);
                    StreamResult result = new StreamResult(xmlFile);
                    transformer.transform(source, result);

                    break; // Terminar el bucle una vez que se haya modificado la solicitud
                }
            }
        } catch (Exception e) {
            System.out.println("Error al modificar solicitud: " + e.getMessage());
        }
    }
}
