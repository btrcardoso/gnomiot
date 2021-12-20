package gnomIoT.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import gnomIoT.entities.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class TelaCadastro {

	private JFrame frame;
	
	// largura e altura da tela
	private int WIDTH = 360;
	private int HEIGHT = 640;
	
	// proporções das caixas de texto
	private double wTxt = WIDTH * 0.8;
	private double hTxt = HEIGHT * 0.05;
	private JTextField txtNome;
	private JPasswordField pwdSenha;
	private JTextField txtEmail;
	private JPasswordField pwdConfirmarsenha;
	

	private static GnomIoT gnomiot;
	private JTextField txtTelefone;
	private JLabel lblTelefone;
	
	

	/**
	 * Launch the application.
	 */
	
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro window = new TelaCadastro(gnomiot);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro window = new TelaCadastro(gnomiot);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	
	/**
	 * Create the application.
	 */
	public TelaCadastro(GnomIoT _gnomiot) {
		gnomiot = _gnomiot;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(new ImageIcon(this.getClass().getResource("/CasaIcone.png")).getImage());
		frame.setTitle("GNOMIOT");
		frame.getContentPane().setBackground(new Color(255, 250, 250));
		frame.setResizable(false);
		frame.setBounds(-1, -1, WIDTH,HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNome.setBounds(36, 99, 70, 15);
		frame.getContentPane().add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setText("");
		txtNome.setBounds(36, 115, (int) wTxt, (int) hTxt);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblSenha.setBounds(36, 277, 70, 15);
		frame.getContentPane().add(lblSenha);
		
		pwdSenha = new JPasswordField();
		pwdSenha.setText("");
		pwdSenha.setBounds(36, 294, (int) wTxt, (int) hTxt);
		frame.getContentPane().add(pwdSenha);
		
		JButton btnCadastrarse = new JButton("Cadastrar-se");
		btnCadastrarse.setBorder(null);
		btnCadastrarse.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnCadastrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText();
				String email = txtEmail.getText();
				String telefone = txtTelefone.getText();
				String senha = new String(pwdSenha.getPassword());
				String confirmarSenha = new String(pwdConfirmarsenha.getPassword());
				
				if(nome.isEmpty() || email.isEmpty() ||  telefone.isEmpty() || senha.isEmpty() || confirmarSenha.isEmpty()) {
					
					JOptionPane.showMessageDialog(null,"Preencha todos os campos");
					
				} else if(senha.equals(confirmarSenha)) {
					
					Usuario usuario = gnomiot.cadastrarUsuario(nome, email, telefone, senha);
					
					if(usuario == null) {
						JOptionPane.showMessageDialog(null,"Este email já está sendo utilizado!");
					} else {
						JOptionPane.showMessageDialog(null,"Conta criada!");
						
						gnomiot.setUsuarioLogado(usuario);
						
						TelaInicial telaInicial = new TelaInicial(gnomiot);
						
						// fecha janela atual
						frame.dispose();
						
						// abre a proxima
						//telaInicial.main(null);
						telaInicial.start();

					}
					
					
				} else {
					JOptionPane.showMessageDialog(null,"As senhas não coincidem!");
				}
				
			}
		});
		btnCadastrarse.setBounds(79, 504, 199, 25);
		frame.getContentPane().add(btnCadastrarse);
		
		txtEmail = new JTextField();
		txtEmail.setText("");
		txtEmail.setColumns(10);
		txtEmail.setBounds(36, 173, 288, 32);
		frame.getContentPane().add(txtEmail);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblEmail.setBounds(36, 158, 70, 15);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblConfirmarsenha = new JLabel("Confirmar Senha");
		lblConfirmarsenha.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblConfirmarsenha.setBounds(36, 338, 199, 15);
		frame.getContentPane().add(lblConfirmarsenha);
		
		pwdConfirmarsenha = new JPasswordField();
		pwdConfirmarsenha.setText("");
		pwdConfirmarsenha.setBounds(36, 355, 288, 32);
		frame.getContentPane().add(pwdConfirmarsenha);
		
		txtTelefone = new JTextField();
		txtTelefone.setText("");
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(36, 233, 288, 32);
		frame.getContentPane().add(txtTelefone);
		
		lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblTelefone.setBounds(36, 216, 70, 15);
		frame.getContentPane().add(lblTelefone);

		JButton btnVoltar = new JButton("");
		ImageIcon imgVoltar = new ImageIcon(this.getClass().getResource("/voltar.png"));
		btnVoltar.setIcon(imgVoltar);

		btnVoltar.setBounds(10, 11, 59, 26);
		btnVoltar.setBackground(new Color(0, 191, 255));
		btnVoltar.setBorder(null);
		btnVoltar.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin telaLogin = new TelaLogin(gnomiot);
				
				// fecha janela atual
				frame.dispose();
				
				// abre a proxima
				//telaLogin.main(null);
				telaLogin.start();

			}
		});
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 0, 344, 50);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		btnVoltar.setBounds(12, 12, 59, 25);
		frame.getContentPane().add(btnVoltar);
	}
	
	public void centralize() {
		
	}
}
