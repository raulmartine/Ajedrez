package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class Servidor extends JFrame {

	private JPanel contentPane;
	private JTextField PuertotextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Servidor frame = new Servidor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Servidor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 450);
		 Fondo logging_panel = new Fondo("/imagenes/Fondo_login.jpg");
	        logging_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(logging_panel);
	        GridBagLayout gbl_logging_panel = new GridBagLayout();
	        gbl_logging_panel.columnWidths = new int[] {10, 10, 0, 0, 0};
	        gbl_logging_panel.rowHeights = new int[] {90, 30, 0};
	        gbl_logging_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
	        gbl_logging_panel.rowWeights = new double[]{0.0, 0.0, 0.0};
	        logging_panel.setLayout(gbl_logging_panel);
	        
	        JLabel JLabelServidor = new JLabel("Servidor");
	        JLabelServidor.setFont(new Font("Source Serif Pro", Font.BOLD | Font.ITALIC, 44));
	        JLabelServidor.setForeground(Color.WHITE);
	        GridBagConstraints gbc_JLabelServidor = new GridBagConstraints();
	        gbc_JLabelServidor.anchor = GridBagConstraints.SOUTH;
	        gbc_JLabelServidor.gridwidth = 3;
	        gbc_JLabelServidor.insets = new Insets(0, 0, 5, 0);
	        gbc_JLabelServidor.gridx = 2;
	        gbc_JLabelServidor.gridy = 0;
	        logging_panel.add(JLabelServidor, gbc_JLabelServidor);
	        
	        JLabel JLabelPuerto = new JLabel("Puerto:");
	        JLabelPuerto.setForeground(Color.WHITE);
	        JLabelPuerto.setFont(new Font("Source Serif Pro Black", Font.PLAIN, 22));
	        GridBagConstraints gbc_JLabelPuerto = new GridBagConstraints();
	        gbc_JLabelPuerto.insets = new Insets(0, 0, 5, 5);
	        gbc_JLabelPuerto.gridx = 2;
	        gbc_JLabelPuerto.gridy = 1;
	        logging_panel.add(JLabelPuerto, gbc_JLabelPuerto);
	        
	        PuertotextField = new JTextField();
	        GridBagConstraints gbc_PuertotextField = new GridBagConstraints();
	        gbc_PuertotextField.gridwidth = 2;
	        gbc_PuertotextField.insets = new Insets(0, 0, 5, 0);
	        gbc_PuertotextField.fill = GridBagConstraints.HORIZONTAL;
	        gbc_PuertotextField.gridx = 3;
	        gbc_PuertotextField.gridy = 1;
	        logging_panel.add(PuertotextField, gbc_PuertotextField);
	        PuertotextField.setColumns(10);
	        
	        JButton JButtonConectar = new JButton("Conectar");
	        JButtonConectar.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
					try {
						String puertoS = PuertotextField.getText();
		        		int puerto = Integer.parseInt(puertoS);
		        		ServerSocket server;
						server = new ServerSocket(puerto);
						System.out.println("Server started");
		                Socket client;
		                System.out.println("Server waiting for a client...");  
		                client = server.accept();
		                System.out.println("Connected to: "+client.toString());        
		                client.setSoLinger (true, 10);
		                BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
		                PrintStream output = new PrintStream(client.getOutputStream());
		                Juego_GUI juego = new Juego_GUI(input, output);
		                juego.setVisible(true);
		                setVisible(false);
		                juego.setResizable(false);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
	                
	        	}
	        });
	        GridBagConstraints gbc_JButtonConectar = new GridBagConstraints();
	        gbc_JButtonConectar.gridwidth = 3;
	        gbc_JButtonConectar.insets = new Insets(0, 0, 0, 5);
	        gbc_JButtonConectar.gridx = 2;
	        gbc_JButtonConectar.gridy = 2;
	        logging_panel.add(JButtonConectar, gbc_JButtonConectar);
	}

}
