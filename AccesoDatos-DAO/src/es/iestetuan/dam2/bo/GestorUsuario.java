package es.iestetuan.dam2.bo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Scanner;

import es.iestetuan.dam2.GestorConfiguracion;
import es.iestetuan.dam2.dao.IUsuarioDao;
import es.iestetuan.dam2.dao.fictex.UsuarioFicTextDAO;
import es.iestetuan.dam2.dao.xml.UsuarioJAXBDAO;
import es.iestetuan.dam2.dao.xml.UsuarioXMLDAO;
import es.iestetuan.dam2.vo.Usuario;

public class GestorUsuario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GestorUsuario gu = new GestorUsuario();
		Scanner nombreObjeto = new Scanner(System.in);
		int nia = nombreObjeto.nextInt();
		nombreObjeto.close();
		int parser = 2; //JAXB
		gu.guardarUsuarioXML(nia, parser);
		gu.guardarUsuariosXML(parser);
		//gu.imprimirUsuario(2);
		//gu.imprimirUsuarios();
	}
	public void imprimirUsuario(int nia) {
		IUsuarioDao usuarioDAO = new UsuarioFicTextDAO();
		
		Usuario usuario =usuarioDAO.getUsuario(nia);
		
		System.out.println(usuario.getId() + " - " + usuario.getNickname() + " - " + usuario.getEmail());
		
	}
	public void guardarUsuarioXML(int nia, int parser) {
		IUsuarioDao usuarioDAO = new UsuarioFicTextDAO();
		
		Usuario usuario =usuarioDAO.getUsuario(nia);
		
		if(parser==1) {
			usuarioDAO = new UsuarioXMLDAO();
		}else {
			usuarioDAO = new UsuarioJAXBDAO();
		}
		System.out.println(usuario.getId() + " - " + usuario.getNickname() + " - " + usuario.getEmail());
		usuarioDAO.guardarUsuario(usuario);		
	}	

	public void guardarUsuariosXML(int parser) {
		IUsuarioDao usuarioDAO = new UsuarioFicTextDAO();
		
		List<Usuario> listaUsuarios =usuarioDAO.getListaUsuarios();
		
		if(parser==1) {
			usuarioDAO = new UsuarioXMLDAO();
		}else {
			// Inicilizar JVM con --illegal-access=permit
			usuarioDAO = new UsuarioJAXBDAO();
		}

		usuarioDAO.guardarUsuarios(listaUsuarios);
		
	}	
	public void imprimirUsuarios() {
		IUsuarioDao usuarioDAO =null;
		String sClase=GestorConfiguracion.getInfoAtributoConfiguracion("usuariodaoimp");
		try {
			Class<?> clase= Class.forName(sClase);
			Constructor<?> constructor= clase.getDeclaredConstructor();
			usuarioDAO = (IUsuarioDao)constructor.newInstance(null);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Usuario> listaUsuarios =usuarioDAO.getListaUsuarios();
		
		for (Usuario user :listaUsuarios) {
			System.out.println(user.getId() + " - " + user.getNickname() + " - " + user.getEmail());
		}	
	}

}
