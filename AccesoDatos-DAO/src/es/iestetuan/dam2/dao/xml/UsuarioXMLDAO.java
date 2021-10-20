package es.iestetuan.dam2.dao.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.thoughtworks.xstream.XStream;

import es.iestetuan.dam2.GestorConfiguracion;
import es.iestetuan.dam2.dao.IUsuarioDao;
import es.iestetuan.dam2.vo.Usuario;


public class UsuarioXMLDAO implements IUsuarioDao {

	private static String RUTA_FICHERO_XML=GestorConfiguracion.getInfoAtributoConfiguracion("rutaFicheroXML");
	private static String RUTA_FICHERO_USUARIOS_XML=GestorConfiguracion.getInfoAtributoConfiguracion("rutaFicheroUsuariosXML");
	@Override
	public Usuario getUsuario(int id) {
		Usuario usuario = null;
		File fichero = new File (RUTA_FICHERO_USUARIOS_XML);
		Document documento = null;
		try {
			  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			  documento = dBuilder.parse(fichero);
			  documento.getDocumentElement().normalize();
			} catch(Exception e) {
			  e.printStackTrace();
		}
		// almacenamos los nodos para luego mostrar la
		// cantidad de ellos con el método getLength()
		NodeList nListIni = documento.getElementsByTagName("usuario");
		System.out.println("Nº de bloques de usuario: " + nListIni.getLength());
		for(int temp = 0; temp < nListIni.getLength(); temp++) {
			Node nNode = nListIni.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			    Element elemento = (Element) nNode;
			    String sId = elemento.getAttribute("id");
			    if(sId!=null || !"".equals(sId)) {
				    long idXML=Long.parseLong(sId);
				    if(idXML==id) {
				    	usuario=new Usuario();
				    	String nombre= elemento.getElementsByTagName("nombre").item(0).getTextContent();
				    	String apellido1= elemento.getElementsByTagName("apellido1").item(0).getTextContent();
				    	String apellido2= elemento.getElementsByTagName("apellido2").item(0).getTextContent();
				    	usuario.setId(id);
				    	usuario.setNombre(nombre);
				    	usuario.setApellido1(apellido1);
				    	usuario.setApellido2(apellido2);
				    	break;
				    }
			    }
			}
		}
		
		return usuario;
	}

	@Override
	public List<Usuario> getListaUsuarios() {
		List<Usuario> listaUsuarios= new ArrayList<Usuario>();
		Usuario usuario=null;
		File fichero = new File (RUTA_FICHERO_USUARIOS_XML);
		Document documento = null;
		try {
			  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			  documento = dBuilder.parse(fichero);
			  documento.getDocumentElement().normalize();
			} catch(Exception e) {
			  e.printStackTrace();
		}
		// almacenamos los nodos para luego mostrar la
		// cantidad de ellos con el método getLength()
		NodeList nListIni = documento.getElementsByTagName("usuario");
		System.out.println("Nº de bloques de usuario: " + nListIni.getLength());
		for(int temp = 0; temp < nListIni.getLength(); temp++) {
			Node nNode = nListIni.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			    Element elemento = (Element) nNode;
			    String sId = elemento.getAttribute("id");
			    int id= Integer.parseInt(sId);
		    	String nombre= elemento.getElementsByTagName("nombre").item(0).getTextContent();
		    	String apellido1= elemento.getElementsByTagName("apellido1").item(0).getTextContent();
		    	String apellido2= elemento.getElementsByTagName("apellido2").item(0).getTextContent();
		    	usuario=new Usuario();
		    	usuario.setId(id);
		    	usuario.setNombre(nombre);
		    	usuario.setApellido1(apellido1);
		    	usuario.setApellido2(apellido2);
		    	listaUsuarios.add(usuario);
			}
		}
		
		return listaUsuarios;
	}

	@Override
	public void guardarUsuario(Usuario usuario) {
		XStream xstream = new XStream();

		xstream.alias("usuario", Usuario.class);
		String usuarioXML = xstream.toXML(usuario);
		String rutaXML=RUTA_FICHERO_XML.replaceFirst("\\[NIA]", String.valueOf(usuario.getId()));
		guardaFicheroXML(rutaXML, usuarioXML);
	}

	@Override
	public void guardarUsuarios(List<Usuario> listaUsuarios) {
		XStream xstream = new XStream();
		xstream.alias("usuarios", List.class);
		xstream.alias("usuario", Usuario.class);
		String usuarioXML = xstream.toXML(listaUsuarios);
		
		guardaFicheroXML(RUTA_FICHERO_USUARIOS_XML, usuarioXML);

		
	}
	private void guardaFicheroXML(String rutaXML, String infoXML) {
		FileOutputStream fos = null;
		try {
		    fos = new FileOutputStream(rutaXML);
		    fos.write("<?xml version=\"1.0\"?>\n".getBytes("UTF-8")); //write XML header, as XStream doesn't do that for us
		    byte[] bytes = infoXML.getBytes("UTF-8");
		    fos.write(bytes);

		} catch(Exception e) {
		    e.printStackTrace(); // this obviously needs to be refined.
		} finally {
		    if(fos!=null) {
		        try{ 
		            fos.close();
		        } catch (IOException e) {
		            e.printStackTrace(); // this obviously needs to be refined.
		        }
		    }
		}		
		
	} 

}
