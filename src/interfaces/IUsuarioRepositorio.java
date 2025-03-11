package interfaces;

import java.util.ArrayList;

import entidade.Usuario;

public interface IUsuarioRepositorio {
	void salvar(Usuario usuario);
	Usuario pesquisarUsuarioPorLogin(String login);
	 boolean remover(Usuario usuario) ;
	 ArrayList<Usuario> listarTodos();
	 void alterarSenha(Usuario usu);

}
