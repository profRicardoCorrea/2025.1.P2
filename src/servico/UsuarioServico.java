package servico;

import java.util.ArrayList;
import java.util.Iterator;

import entidade.Usuario;
import interfaces.IUsuarioRepositorio;
import repositorio.UsuarioRepositorio;

public class UsuarioServico {
	private IUsuarioRepositorio usuarioRepositorio;
	public UsuarioServico(UsuarioRepositorio usuarioRepositorio) {
		this.usuarioRepositorio=usuarioRepositorio;
	}
	
	public void cadastrar(Usuario novoUsuario) {
		 
		if(novoUsuario!=null) {
			//VALIDACAO LOGIN
			if(!novoUsuario.getLogin().isBlank() 
					&& !novoUsuario.getLogin().isEmpty() 
					&& novoUsuario.getLogin().length()>=8) {
				//VALIDACAO SENHA
					if(!novoUsuario.getSenha().isBlank() 
							&& !novoUsuario.getSenha().isEmpty()
							&& novoUsuario.getLogin().length()>=5) {
						Usuario usuPesquisado=this.usuarioRepositorio.pesquisarUsuarioPorLogin(novoUsuario.getLogin());
						if(usuPesquisado==null) {
							this.usuarioRepositorio.salvar(novoUsuario);
							System.out.println("USUARIO CADASTRADO!");
						}
						else
							System.out.println("LOGIN JA CADASTRADO!");
						
					}else
						System.out.println("SENHA INVALIDA!");
			}else
				System.out.println("LOGIN INVALIDA!");
			
		}else {
			System.out.println("USUARIO INVALIDO!");
		}
	}
	
	
	public boolean excluir(Usuario usuario) {
		Usuario usuPesquisado=this.usuarioRepositorio.pesquisarUsuarioPorLogin(usuario.getLogin());
		if(usuPesquisado!=null) {
			System.out.println("USUARIO REMOVIDO COM SUCESSO");
			return this.usuarioRepositorio.remover(usuario);
		}else {
			System.out.println("USUARIO INEXISTENTE");
			return false;
		}
	}
	
	public void alterar(Usuario usuario) {
		Usuario usuPesquisado=this.usuarioRepositorio.pesquisarUsuarioPorLogin(usuario.getLogin());
		if(usuPesquisado!=null) {
			usuPesquisado.setSenha(usuario.getSenha());
			this.usuarioRepositorio.alterarSenha(usuPesquisado); 
			 
		}else {
			System.out.println("USUARIO INEXISTENTE");
			 
		}
	}
	
	public void listarUsuarios(){
		for (Usuario usuario : this.usuarioRepositorio.listarTodos()) {
			System.out.println("LOGIN:"+usuario.getLogin()+"Senha: ****");
			
		}
	}

}
