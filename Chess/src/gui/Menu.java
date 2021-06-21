package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setResizable(false);
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
        Fondo logging_panel = new Fondo("/imagenes/Fondo_login.jpg");
        logging_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(logging_panel);
        GridBagLayout gbl_logging_panel = new GridBagLayout();
        gbl_logging_panel.columnWidths = new int[]{95, 65, 125, 73, 0};
        gbl_logging_panel.rowHeights = new int[]{155, 23, 0};
        gbl_logging_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_logging_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        logging_panel.setLayout(gbl_logging_panel);
        
        JButton JButtonCliente = new JButton("Cliente");
        JButtonCliente.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		Cliente cliente = new Cliente();
        		cliente.setVisible(true);
        		setVisible(false);
        		cliente.setResizable(false);
        	}
        });
        GridBagConstraints gbc_JButtonCliente = new GridBagConstraints();
        gbc_JButtonCliente.insets = new Insets(0, 0, 0, 5);
        gbc_JButtonCliente.gridx = 1;
        gbc_JButtonCliente.gridy = 1;
        logging_panel.add(JButtonCliente, gbc_JButtonCliente);
        
        JButton JButtonServidor = new JButton("Servidor");
        JButtonServidor.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Servidor servidor = new Servidor();
        		servidor.setVisible(true);
        		setVisible(false);
        		servidor.setResizable(false);
        	}
        });
        GridBagConstraints gbc_JButtonServidor = new GridBagConstraints();
        gbc_JButtonServidor.gridx = 3;
        gbc_JButtonServidor.gridy = 1;
        logging_panel.add(JButtonServidor, gbc_JButtonServidor);
		
	}

}
