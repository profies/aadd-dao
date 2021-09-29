package es.iestetuan.dam2.dao;

import java.util.List;

import es.iestetuan.dam2.vo.Usuario;

public interface IUsuarioDao {
	public Usuario getUsuario(int id);
	public List<Usuario> getListaUsuarios();
}
