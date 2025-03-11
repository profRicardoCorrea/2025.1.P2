package aula20250310;

import java.util.ArrayList;

import entidade.Usuario;
import repositorio.UsuarioRepositorio;
import servico.UsuarioServico;

public class Main {
	public static void main(String[] args) {
		ArrayList<Usuario> usuarios=new ArrayList();
		
		UsuarioRepositorio usuarioRepositorio=new UsuarioRepositorio(usuarios);
		
		
		UsuarioServico servico=new UsuarioServico(usuarioRepositorio);
		
		if(usuarios!=null) {
			Usuario us1=new Usuario("QWER", "");		
			servico.cadastrar(us1);
			Usuario us11=new Usuario("", "");		
			servico.cadastrar(us11);
			
			Usuario us2=new Usuario("QWER34343434", "13123123");
			servico.cadastrar(us2);
			servico.cadastrar(us2);
			
			Usuario us3=new Usuario("QWER3434345", "aaaaaaa");
			servico.cadastrar(us3);
			
			servico.cadastrar(new Usuario("AAAAAAAAA", "aaaaaaa"));
			servico.cadastrar(new Usuario("BBBBBBBBB", "aaaaaaa"));
			servico.cadastrar(new Usuario("CCCCCCCCC", "aaaaaaa"));
			
			servico.listarUsuarios();
			servico.excluir(us2);
			servico.listarUsuarios();
			
			
		}else
			System.out.println("LISTA VAZIA");
		
		
		
	}
}
