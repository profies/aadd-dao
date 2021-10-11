package es.iestetuan.dam2.dao.xml;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.thoughtworks.xstream.XStream;

import es.iestetuan.dam2.GestorConfiguracion;
import es.iestetuan.dam2.dao.IUsuarioDao;
import es.iestetuan.dam2.vo.Usuario;


public class UsuarioXMLDAO implements IUsuarioDao {

	private static String RUTA_FICHERO_XML=GestorConfiguracion.getInfoAtributoConfiguracion("rutaFicheroXML");
	private static String RUTA_FICHERO_USUARIOS_XML=GestorConfiguracion.getInfoAtributoConfiguracion("rutaFicheroUsuariosXML");
	@Override
	public Usuario getUsuario(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> getListaUsuarios() {
		// TODO Auto-generated method stub
		return null;
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
