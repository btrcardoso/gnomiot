package gnomIoT.entities;
import java.util.Map;

import gnomIoT.view.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.awt.Image;

public class GnomIoT {
	private Map<String, Dispositivo> dispositivos = new HashMap<String, Dispositivo>();
	private ArrayList<Usuario> usuarios = new ArrayList<>();
	private Usuario usuarioLogado = null;
	private Residencia residenciaAtual = null;
	private Comodo comodoAtual = null;
	private Dispositivo dispositivoAtual = null;
	
	// isso aqui não é o perfil do usuário logado, é o perfil de alguma pessoa selecionada na casa
	private Perfil perfilDoConvidado = null;
	
	private TelaAdicionarDispositivo telaAddDispositivo;
	private TelaArCondicionado telaArCondicionado;
	private TelaCadastro telaCadastro;
	private TelaComodos telaComodos;
	private TelaCriarComodo telaCriarComodo;
	private TelaCriarResidencia telaCriarResidencia;
	private TelaDispositivo telaDispositivo;
	private TelaDispositivos telaDispositivos;
	private TelaInicial telaInicial;
	private TelaLogin telaLogin;
	private TelaResidencias telaResidencias;
	
	public GnomIoT() {
		populate();
	}
	
	// esses metodos nao é pra ser colocado no diagrama de classes
	private void populate() {
		Dispositivo temp;
		temp = (Dispositivo) new Lampada("lamp1 pro 5000 Negativo 60W","Negativo");
		cadastrarDispositivo( temp );
		temp = (Dispositivo) new Lampada("lamp2 Inteli 50W incadescente","Inteli");
		cadastrarDispositivo( temp );
		temp =  (Dispositivo) new ArCondicionado("Ar1 Embaixador Super Gelo", "Embaixador");
		cadastrarDispositivo( temp );
		temp =  (Dispositivo) new Fechadura("Fechadura Show 5000", "Negativo");
		cadastrarDispositivo( temp );
		temp =  (Dispositivo) new Tomada("Tomada ultra force", "Negativo");
		cadastrarDispositivo( temp );
	
		Usuario ze = cadastrarUsuario("Ze","ze@mail.com","12345678","senha");
		Usuario ana = cadastrarUsuario("Ana","ana@mail.com","12345676","senha");
		Usuario jorge = cadastrarUsuario("Jorge","jorge@mail.com","12345674","senha");
		Usuario filo = cadastrarUsuario("Filó","filo@mail.com","12345979","senha");
		
		Residencia casaZe = new Residencia("Casa do Ze", ze);
		casaZe.adicionarUsuario(ana, Cargo.ADMINISTRADOR);
		casaZe.adicionarUsuario(jorge, Cargo.USUARIO_PADRAO);
		
		Comodo quartoZe = casaZe.adicionarComodo("Quarto do Ze");
		Comodo salaZe = casaZe.adicionarComodo("Sala do Ze");
		
		comodoAtual = quartoZe;
		this.adicionarDispositivoAoComodo("lampada bonitinha", "lamp2 Inteli 50W incadescente");
		this.adicionarDispositivoAoComodo("lampada bonitinha2", "lamp2 Inteli 50W incadescente");
		this.adicionarDispositivoAoComodo("lampada bonitinha3", "lamp2 Inteli 50W incadescente");
		this.adicionarDispositivoAoComodo("clima de montanha", "Ar1 Embaixador Super Gelo");
		comodoAtual = null;
		casaZe.pegarPerfil(jorge).disponibilizarComodo(salaZe);
		
		casaZe.adicionarUsuario(filo, Cargo.USUARIO_PADRAO);
		casaZe.pegarPerfil(filo).disponibilizarComodo(quartoZe);
		
		Comodo banheiroDoZe = casaZe.adicionarComodo("Banheiro do Ze");
		
		casaZe.listarPerfis();
		casaZe.listarComodos();
		
		Residencia casaFilo = new Residencia("Casa da Filó", filo);
		Comodo salaFilo = casaFilo.adicionarComodo("Sala da Filó");
		Comodo cozinhaFilo = casaFilo.adicionarComodo("Cozinha da Filó");
		
		casaFilo.adicionarUsuario(jorge, Cargo.ADMINISTRADOR);
		casaFilo.adicionarUsuario(ana, Cargo.USUARIO_PADRAO);
		casaFilo.pegarPerfil(ana).disponibilizarComodo(salaFilo);
		
		Comodo quartoFilo = casaFilo.adicionarComodo("Quarto da Filó");
		
		casaFilo.listarPerfis();
		casaFilo.listarComodos();
		
		// usuarioLogado = ze;
		
	}
	
	public Map<String, Dispositivo> getDispositivos() {
		return dispositivos;
	}
	
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	
	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public Residencia getResidenciaAtual() {
		return residenciaAtual;
	}

	public void setResidenciaAtual(Residencia residenciaAtual) {
		this.residenciaAtual = residenciaAtual;
	}

	public Comodo getComodoAtual() {
		return comodoAtual;
	}

	public void setComodoAtual(Comodo comodoAtual) {
		this.comodoAtual = comodoAtual;
	}

	public Dispositivo getDispositivoAtual() {
		return dispositivoAtual;
	}

	public void setDispositivoAtual(Dispositivo dispositivoAtual) {
		this.dispositivoAtual = dispositivoAtual;
	}

	public void cadastrarDispositivo(Dispositivo dispositivo) {
		dispositivos.put(dispositivo.getMODELO(),dispositivo);
	}
	
	public Perfil getPerfilDoConvidado() {
		return perfilDoConvidado;
	}
	
	public void setPerfilDoConvidado(Perfil perfilDoConvidado) {
		this.perfilDoConvidado = perfilDoConvidado;
	}
	
	public Usuario autenticarUsuario(String email, String senha) {
		for(Usuario u : usuarios) {
			if(u.getEmail().equals(email) && u.getSenha().equals(senha)) {
				usuarioLogado = u;
				return u;
			}
		}
		return null;
	}
	
	public Usuario cadastrarUsuario(String nome, String email, String telefone, String senha) {
		if(usuarioExiste(email)) {
			//Este email não pode ser utilizado
			return null;
		}
		
		Usuario usuario = new Usuario(nome, email, telefone, senha);
		usuarios.add(usuario);
		
		return usuario;
	}
	
	public Boolean usuarioExiste(String email) {
		for(Usuario u : usuarios) {
			if(u.getEmail().equals(email)) {
				return true;
			}
		}
		return false;
	}
	
	public Residencia criarResidencia(String nome) {
		return new Residencia(nome, usuarioLogado);
	}
	
	public void alterarNomeUsuario(String novoNome) {
		usuarioLogado.setNome(novoNome);
	}
	
	public Usuario excluirConta(String email, String senha) {
		for (Usuario pessoa: this.usuarios) {
			if (pessoa.getEmail().equals(email) && pessoa.getSenha().equals(senha)) {
				usuarios.remove(pessoa);
				return pessoa;
			}
		}
		return null;
	}
	
	public Boolean conferirSenhaAntiga(String senhaAntiga) {
		if(usuarioLogado.getSenha().equals(senhaAntiga)) {
			return true;
		}
		return false;
	}
	
	public void alterarSenha(String novaSenha) {
		usuarioLogado.setSenha(novaSenha);
	}
	
	public ArrayList<Residencia> listaDeResidencias() {
		return usuarioLogado.getResidencias();
	}
	
	public Boolean alterarNomeResidencia(String novoNome) {
		if(usuarioLogadoEAdministradorOuDono()) {
			residenciaAtual.setNome(novoNome);
			return true;
		}
		return false;
	}
	
	public ArrayList<Comodo> listaDeComodos(){
		return residenciaAtual.pegarPerfil(usuarioLogado).getComodos();
	}
	
	public Boolean criarComodo(String nome) {
		if(usuarioLogadoEAdministradorOuDono()){
			residenciaAtual.adicionarComodo(nome);
			return true;
		}
		return false;
	}
	
	public Boolean alterarNomeComodo(String novoNome) {
		if(usuarioLogadoEAdministradorOuDono()) {
			comodoAtual.setNome(novoNome);
			return true;
		}
		return false;
	}
	
	public ArrayList<Perfil> listaDePerfisNaResidencia(){
		return residenciaAtual.getPerfis();
	}
	
	public Boolean alterarCargo(Cargo novoCargo) {
		Cargo cargoAntigo = perfilDoConvidado.getCargo();
		
		if(usuarioLogadoEAdministradorOuDono() && cargoAntigo != Cargo.DONO) {
			
			perfilDoConvidado.setCargo(novoCargo);
			return true;
			
		}
		
		return false;
	}
	
	public Boolean alterarAcessoComodo(Comodo comodo) {
		Cargo cargoDoPerfil = perfilDoConvidado.getCargo();
		
		if(usuarioLogadoEAdministradorOuDono() && cargoDoPerfil == Cargo.USUARIO_PADRAO) {
			
			// fazer
			
		}
		
		return false;
	}
	
	public ArrayList<Dispositivo> listaDeDispositivos(){
		return comodoAtual.getDispositivos();
	}
	
	public Boolean alterarNomeDispositivo(String novoNome) {
		if(usuarioLogadoEAdministradorOuDono()) {
			dispositivoAtual.setNome(novoNome);
			return true;
		}
		return false;
	}
	
	public Boolean usuarioLogadoEAdministradorOuDono() {
		Cargo cargo = residenciaAtual.pegarPerfil(usuarioLogado).getCargo();
		
		if(cargo == Cargo.ADMINISTRADOR || cargo == Cargo.DONO) {
			
			return true;
		}
		
		return false;
	}
	
	public Boolean adicionarUsuarioAResidencia(String email) {
		
		if(!usuarioLogadoEAdministradorOuDono()) {
			// Usuário logado não pode realizar a operação
			return false;
		}
		
		Usuario usuario = buscarUsuario(email);
		
		if(usuario == null) {
			// Não existe usuário com este email na lista
			return false;
		}
		
		// Retorna verdadeiro se a adição foi bem sucedida, e falso se o usuário já tiver na casa
		return residenciaAtual.adicionarUsuario(usuario, Cargo.USUARIO_PADRAO);		
	}
	
	private Usuario buscarUsuario(String email) {
		
		for(Usuario u : usuarios) {
			
			if(u.getEmail().equals(email)) {
				return u;
			}
			
		}
		
		return null;
	}
	
	public Boolean cadastrarDispositivoNoComodo(String nomeDispositivo, String modelo) {
		// fazer
		return false;
	}
	
	public void adicionarDispositivoAoComodo(String nome, String modelo) {
		try {
			Dispositivo tmp = this.dispositivos.get(modelo).clone();
			tmp.setNome(nome);
			
			comodoAtual.adicionarDispositivo(tmp);
			
		} catch (CloneNotSupportedException e) {
			System.out.println("Erro de clonagem!");
		}
	}
	
	public void logout() {
		usuarioLogado = null;
		residenciaAtual = null;
		comodoAtual = null;
		dispositivoAtual = null;
	}
	
	public void alterarEstadoDispositivo() {
		this.dispositivoAtual.alterarEstado();
	}
	
	
	public void iniciar() {
		if (this.usuarioLogado == null) {
			this.telaLogin = new TelaLogin(this);
			this.telaLogin.start();
		}
		else {
			this.telaInicial = new TelaInicial(this);
			this.telaInicial.start();
		}
	}
	
	public Image imagemAtual() {
		if (this.dispositivoAtual.getEstado()) {
			return dispositivoAtual.getImageEstadoOn();
		} else {
			return dispositivoAtual.getImageEstadoOff();
		}
	}
	
	public void removerDispositivo(Comodo comodo, Dispositivo dispositivo) {
		comodo.removerDispositivo(dispositivo);
	}
}