package es.iestetuan.dam2.bo;

import java.util.List;

import es.iestetuan.dam2.dao.IUsuarioDao;
import es.iestetuan.dam2.dao.fictex.UsuarioFicTextDAO;
import es.iestetuan.dam2.vo.Usuario;

public class GestorUsuario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GestorUsuario gu = new GestorUsuario();
		gu.imprimirUsuario();
		// gu.imprimirUsuarios();
	}
	public void imprimirUsuario() {
		IUsuarioDao usuarioDAO = new UsuarioFicTextDAO();
		
		Usuario usuario =usuarioDAO.getUsuario(2);
		
		System.out.println(usuario.getId() + " - " + usuario.getNickname() + " - " + usuario.getEmail());
		
	}
	
	public void imprimirUsuarios() {
		IUsuarioDao usuarioDAO = new UsuarioFicTextDAO();
		List<Usuario> listaUsuarios =usuarioDAO.getListaUsuarios();
		
		for (Usuario user :listaUsuarios) {
			System.out.println(user.getId() + " - " + user.getNickname() + " - " + user.getEmail());
		}
	}

}
