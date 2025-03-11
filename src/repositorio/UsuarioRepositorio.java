package repositorio;

import java.util.ArrayList;

import entidade.Usuario;
import interfaces.IUsuarioRepositorio;

public class UsuarioRepositorio implements IUsuarioRepositorio{
	private ArrayList<Usuario> usuarios;

	public UsuarioRepositorio(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void salvar(Usuario novoUsuario) {
		this.usuarios.add(novoUsuario);
	}

	public Usuario pesquisarUsuarioPorLogin(String login) {
		if (this.usuarios != null) {
			for (Usuario usuario : this.usuarios) {
				if (usuario.getLogin().equals(login))
					return usuario;
			}
		} else {
			System.out.println("ARRAYLIST VAZIO");
		}
		return null;
	}
	
	public void alterarSenha(Usuario usu) {
		for (Usuario usuario : this.usuarios) {
			if (usuario.getLogin().equals(usu.getLogin())) {
				usuario.setSenha(usu.getSenha());
				break;
			}
		}
	}
	
	public ArrayList<Usuario> listarTodos(){
		return usuarios;
	}
	
	
	public boolean remover(Usuario usuario) {
		return usuarios.remove(usuario);
	}

}
