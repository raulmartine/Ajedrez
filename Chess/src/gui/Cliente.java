package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class Cliente extends JFrame {

	private JPanel contentPane;
	private JTextField IPtextField;
	private JTextField PuertotextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente frame = new Cliente();
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
	public Cliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 450);
		
        Fondo logging_panel = new Fondo("/imagenes/Fondo_login.jpg");
        logging_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(logging_panel);
        GridBagLayout gbl_logging_panel = new GridBagLayout();
        gbl_logging_panel.columnWidths = new int[] {0, 90, 30};
        gbl_logging_panel.rowHeights = new int[] {90, 30, 30, 30, 0, 0, 0, 0, 0};
        gbl_logging_panel.columnWeights = new double[]{0.0, 0.0, 0.0};
        gbl_logging_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        logging_panel.setLayout(gbl_logging_panel);
        
        JLabel JLabelCliente = new JLabel("Cliente");
        JLabelCliente.setForeground(Color.WHITE);
        JLabelCliente.setFont(new Font("Source Sans Pro", Font.BOLD | Font.ITALIC, 44));
        GridBagConstraints gbc_JLabelCliente = new GridBagConstraints();
        gbc_JLabelCliente.insets = new Insets(0, 0, 5, 5);
        gbc_JLabelCliente.gridx = 1;
        gbc_JLabelCliente.gridy = 2;
        logging_panel.add(JLabelCliente, gbc_JLabelCliente);
        
        JLabel JLabelIP = new JLabel("IP:");
        JLabelIP.setForeground(Color.WHITE);
        JLabelIP.setFont(new Font("Source Sans Pro Black", Font.ITALIC, 22));
        GridBagConstraints gbc_JLabelIP = new GridBagConstraints();
        gbc_JLabelIP.anchor = GridBagConstraints.EAST;
        gbc_JLabelIP.insets = new Insets(0, 0, 5, 5);
        gbc_JLabelIP.gridx = 0;
        gbc_JLabelIP.gridy = 3;
        logging_panel.add(JLabelIP, gbc_JLabelIP);
        
        IPtextField = new JTextField();
        GridBagConstraints gbc_IPtextField = new GridBagConstraints();
        gbc_IPtextField.insets = new Insets(0, 0, 5, 5);
        gbc_IPtextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_IPtextField.gridx = 1;
        gbc_IPtextField.gridy = 3;
        logging_panel.add(IPtextField, gbc_IPtextField);
        IPtextField.setColumns(10);
        
        JLabel JLabelPuerto = new JLabel("Puerto:");
        JLabelPuerto.setFont(new Font("Source Sans Pro Black", Font.ITALIC, 22));
        JLabelPuerto.setForeground(Color.WHITE);
        GridBagConstraints gbc_JLabelPuerto = new GridBagConstraints();
        gbc_JLabelPuerto.anchor = GridBagConstraints.EAST;
        gbc_JLabelPuerto.insets = new Insets(0, 0, 5, 5);
        gbc_JLabelPuerto.gridx = 0;
        gbc_JLabelPuerto.gridy = 4;
        logging_panel.add(JLabelPuerto, gbc_JLabelPuerto);
        
        PuertotextField = new JTextField();
        GridBagConstraints gbc_PuertotextField = new GridBagConstraints();
        gbc_PuertotextField.insets = new Insets(0, 0, 5, 5);
        gbc_PuertotextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_PuertotextField.gridx = 1;
        gbc_PuertotextField.gridy = 4;
        logging_panel.add(PuertotextField, gbc_PuertotextField);
        PuertotextField.setColumns(10);
        
        JButton JButtonConectar = new JButton("Conectar");
        JButtonConectar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				try {
					System.out.println("Client -> Start");
	        		String puertoS = PuertotextField.getText();
	        		int puerto = Integer.parseInt(puertoS);
	        		String servidor = IPtextField.getText();
	                Socket socket;
					socket = new Socket(servidor, puerto);    
	                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	                PrintStream output = new PrintStream(socket.getOutputStream());
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
        gbc_JButtonConectar.insets = new Insets(0, 0, 5, 5);
        gbc_JButtonConectar.gridx = 1;
        gbc_JButtonConectar.gridy = 5;
        logging_panel.add(JButtonConectar, gbc_JButtonConectar);
	}

}
