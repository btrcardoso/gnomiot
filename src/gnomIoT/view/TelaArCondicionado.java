package gnomIoT.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import gnomIoT.entities.ArCondicionado;
import gnomIoT.entities.Comodo;
import gnomIoT.entities.Dispositivo;
import gnomIoT.entities.GnomIoT;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaArCondicionado {
	private JFrame frame;
	private JPanel contentPane;
	private static GnomIoT gnomiot;
	
// largura e altura da tela
	private int WIDTH = 360;
	private int HEIGHT = 640;
	
	private double wBtn = WIDTH * 0.8;
	private double hBtn = HEIGHT * 0.05;
	private double xBtn = (WIDTH - wBtn)/2 ;
	private JLabel lblNomeDispositivo;
	
	

	/**
	 * Launch the application.
	 */
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaArCondicionado window = new TelaArCondicionado(gnomiot);
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
					TelaArCondicionado window = new TelaArCondicionado(gnomiot);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	
	public TelaArCondicionado(GnomIoT _gnomiot) {
		gnomiot = _gnomiot;
		initialize();
	}

	/**
	 * Create the frame.
	 */
	private void initialize() {
		ArCondicionado dispositivo = (ArCondicionado) gnomiot.getDispositivoAtual();
		frame = new JFrame();
		frame.setIconImage(new ImageIcon(this.getClass().getResource("/CasaIcone.png")).getImage());
		frame.setTitle("GNOMIOT");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(-1, -1, WIDTH,HEIGHT);
		frame.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contentPane.requestFocus();
			}
		});
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBemVindo = new JLabel(gnomiot.getResidenciaAtual().getNome() + " > " + gnomiot.getComodoAtual().getNome() + " > ");
		lblBemVindo.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblBemVindo.setBounds(33, 48, 290, 25);
		frame.getContentPane().add(lblBemVindo, BorderLayout.CENTER);
		
		JLabel lblNome = new JLabel(gnomiot.getDispositivoAtual().getNome());
		lblNome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNome.setVisible(false);
				JTextField txtTrocarNome = new JTextField();
				txtTrocarNome.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
				txtTrocarNome.setBounds(33, 85, 254, 15);
				txtTrocarNome.setColumns(10);
				txtTrocarNome.setText(lblNome.getText());
				//contentPane.add(txtTrocarNome);
				txtTrocarNome.setVisible(true);
				frame.getContentPane().add(txtTrocarNome);
				
				txtTrocarNome.addFocusListener(new FocusAdapter() {
					@Override
					public void focusLost(FocusEvent e) {
						txtTrocarNome.setVisible(false);
						gnomiot.alterarNomeDispositivo(txtTrocarNome.getText());
						lblNome.setText(dispositivo.getNome());
						lblNome.setVisible(true);
					}
				});
			}
		});
			
		lblNome.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNome.setBounds(33, 85, 254, 15);
		contentPane.add(lblNome);
		
		JLabel lblModelo = new JLabel(gnomiot.getDispositivoAtual().getMODELO());
		lblModelo.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblModelo.setBounds(49, 480, 254, 15);
		contentPane.add(lblModelo);
		
		// JButton btnVoltar = new JButton("←");
		// btnVoltar.addActionListener(new ActionListener() {
		// 	public void actionPerformed(ActionEvent e) {
		// 		gnomiot.setDispositivoAtual(null);
				
		// 		TelaDispositivos telaDispositivos = new TelaDispositivos(gnomiot);
				
		// 		// fecha janela atual
		// 		frame.dispose();
				
		// 		// abre a proxima
		// 		//telaDispositivos.main(null);
		// 		telaDispositivos.start();
		// 	}
		// });
		// btnVoltar.setBounds(12, 12, 59, 25);
		// frame.getContentPane().add(btnVoltar);
		
		// JButton btnSair = new JButton("Sair");
		// btnSair.addActionListener(new ActionListener() {
		// 	public void actionPerformed(ActionEvent e) {
		// 		int reply = JOptionPane.showConfirmDialog(null, "Deseja sair?", "Sair", JOptionPane.YES_NO_OPTION);
		//         if (reply == JOptionPane.YES_OPTION) {
		//         	gnomiot.logout();
		        	
		//         	TelaLogin telaLogin = new TelaLogin(gnomiot);
					
		// 			// fecha janela atual
		// 			frame.dispose();
					
		// 			// abre a proxima
		// 			//telaLogin.main(null);
		// 			telaLogin.start();

		//         }
		// });
		// btnSair.setBounds(268, 12, 80, 25);
		// frame.getContentPane().add(btnSair);
		
		
		
		
		
		JSpinner spinnerTemperatura = new JSpinner();
		spinnerTemperatura.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		spinnerTemperatura.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		spinnerTemperatura.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				dispositivo.alterarTemperatura((int) spinnerTemperatura.getValue());
			}
		});
		spinnerTemperatura.setModel(new SpinnerNumberModel(dispositivo.getTemperatura(),(Comparable) dispositivo.getMin(), (Comparable) dispositivo.getMax(), 1));
		
		
		spinnerTemperatura.setBounds(211, 287, 44, 23);
		contentPane.add(spinnerTemperatura);
		
		JLabel lblTemperaturaAtual = new JLabel("Temperatura Atual: ");
		lblTemperaturaAtual.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblTemperaturaAtual.setBounds(65, 289, 168, 19);
		contentPane.add(lblTemperaturaAtual);
		
		invisivel(dispositivo.getEstado(), spinnerTemperatura, lblTemperaturaAtual);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(gnomiot.imagemAtual()));
		lblNewLabel.setBounds(0, 99, 348, 130);

		contentPane.add(lblNewLabel);
		
		
		JButton btnLigaDesliga = new JButton(estado(dispositivo.getEstado()));
		btnLigaDesliga.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLigaDesliga.setBorder(null);
		btnLigaDesliga.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnLigaDesliga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					dispositivo.alterarEstado();
					lblNewLabel.setIcon(new ImageIcon(gnomiot.imagemAtual()));
					
					btnLigaDesliga.setText(estado(dispositivo.getEstado()));
					invisivel(dispositivo.getEstado(), spinnerTemperatura, lblTemperaturaAtual);
					spinnerTemperatura.setValue(dispositivo.getTemperatura());
			}
		});

		JButton btnVoltar = new JButton("");

		ImageIcon imgVoltar = new ImageIcon(this.getClass().getResource("/voltar.png"));
		btnVoltar.setIcon(imgVoltar);

		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltar.setBackground(new Color(0, 191, 255));
		btnVoltar.setBorder(null);
		btnVoltar.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			gnomiot.setDispositivoAtual(null);
				
				TelaDispositivos telaDispositivos = new TelaDispositivos(gnomiot);
				
				// fecha janela atual
				frame.dispose();
				
				// abre a proxima
				//telaDispositivos.main(null);
				telaDispositivos.start();

			}
		});
		btnVoltar.setBounds(10, 11, 59, 26);
		frame.getContentPane().add(btnVoltar);


		ImageIcon imgSair = new ImageIcon(this.getClass().getResource("/sair.png"));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 0, 344, 50);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(255, 5, 79, 33);
		panel.add(btnSair);
		btnSair.setFont(new Font("Century Gothic", Font.BOLD, 11));
		btnSair.setForeground(new Color(255, 250, 250));
		btnSair.setIcon(imgSair);
		
		btnSair.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSair.setBackground(new Color(0, 191, 255));
		btnSair.setBorder(null);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int reply = JOptionPane.showConfirmDialog(null, "Deseja sair?", "Sair", JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					gnomiot.logout();
					
					TelaLogin telaLogin = new TelaLogin(gnomiot);
					
					// fecha janela atual
					frame.dispose();
					
					// abre a proxima
					//telaLogin.main(null);
					telaLogin.start();

				}
			}
		});

		btnLigaDesliga.setBounds(104, 253, 129, 23);
		contentPane.add(btnLigaDesliga);
		
		
	}
	public String estado(boolean a) {
		if (!a) return "Ligar";
		else return "Desligar";
	}
	public void invisivel(boolean a, JComponent ...componentes) {
		for (JComponent item : componentes) {
			item.setVisible(a);
		}
	}

	public Rectangle getlblMeusDispositivoslBounds() {
		return lblNomeDispositivo.getBounds();
	}
	public void setlblMeusDispositivoslBounds(Rectangle bounds) {
		lblNomeDispositivo.setBounds(bounds);
	}
}
