package es.iestetuan.dam2.bo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import es.iestetuan.dam2.GestorConfiguracion;
import es.iestetuan.dam2.dao.IUsuarioDao;
import es.iestetuan.dam2.dao.fictex.UsuarioFicTextDAO;
import es.iestetuan.dam2.vo.Usuario;

public class GestorUsuario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GestorUsuario gu = new GestorUsuario();
		//gu.imprimirUsuario();
		gu.imprimirUsuarios();
	}
	public void imprimirUsuario() {
		IUsuarioDao usuarioDAO = new UsuarioFicTextDAO();
		
		Usuario usuario =usuarioDAO.getUsuario(2);
		
		System.out.println(usuario.getId() + " - " + usuario.getNickname() + " - " + usuario.getEmail());
		
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
