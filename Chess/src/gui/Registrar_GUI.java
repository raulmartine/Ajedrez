package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import datos.Connect;

public class Registrar_GUI extends JFrame{

	private JPanel contentPane;
	private JTextField textField_Usuario;
	private JPasswordField passwordField;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrar_GUI frame = new Registrar_GUI();
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Registrar_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 650);
		

        this.setLocationRelativeTo(null);
        Fondo logging_panel = new Fondo("/imagenes/Fondo_login.jpg");
        logging_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(logging_panel);
        GridBagLayout gbl_logging_panel = new GridBagLayout();
        gbl_logging_panel.columnWidths = new int[]{332, 133, 257, 0};
        gbl_logging_panel.rowHeights = new int[]{315, 53, 0, 52, 55, 0};
        gbl_logging_panel.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
        gbl_logging_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        logging_panel.setLayout(gbl_logging_panel);
        
        JLabel JLabel_Titulo = new JLabel("Registro");
        JLabel_Titulo.setForeground(Color.WHITE);
        JLabel_Titulo.setFont(new Font("Source Serif Pro", Font.BOLD | Font.ITALIC, 44));
        GridBagConstraints gbc_JLabel_Titulo = new GridBagConstraints();
        gbc_JLabel_Titulo.gridwidth = 3;
        gbc_JLabel_Titulo.insets = new Insets(0, 0, 5, 0);
        gbc_JLabel_Titulo.gridx = 0;
        gbc_JLabel_Titulo.gridy = 0;
        logging_panel.add(JLabel_Titulo, gbc_JLabel_Titulo);
        
        JLabel JLabel_Usuario = new JLabel("Usuario:");
        JLabel_Usuario.setFont(new Font("Source Serif Pro Black", Font.ITALIC, 22));
        JLabel_Usuario.setBackground(Color.WHITE);
        JLabel_Usuario.setForeground(Color.WHITE);
        GridBagConstraints gbc_JLabel_Usuario = new GridBagConstraints();
        gbc_JLabel_Usuario.anchor = GridBagConstraints.EAST;
        gbc_JLabel_Usuario.insets = new Insets(0, 0, 5, 5);
        gbc_JLabel_Usuario.gridx = 0;
        gbc_JLabel_Usuario.gridy = 1;
        logging_panel.add(JLabel_Usuario, gbc_JLabel_Usuario);
        
        textField_Usuario = new JTextField();
        GridBagConstraints gbc_textField_Usuario = new GridBagConstraints();
        gbc_textField_Usuario.gridwidth = 2;
        gbc_textField_Usuario.anchor = GridBagConstraints.WEST;
        gbc_textField_Usuario.insets = new Insets(0, 0, 5, 0);
        gbc_textField_Usuario.gridx = 1;
        gbc_textField_Usuario.gridy = 1;
        logging_panel.add(textField_Usuario, gbc_textField_Usuario);
        textField_Usuario.setColumns(30);
        
        JLabel JLabel_Error = new JLabel("Este nombre ha sido utilizado, escriba otro nombre");
        JLabel_Error.setFont(new Font("Source Serif Pro", Font.PLAIN, 17));
        JLabel_Error.setForeground(Color.RED);
        GridBagConstraints gbc_JLabel_Error = new GridBagConstraints();
        gbc_JLabel_Error.anchor = GridBagConstraints.WEST;
        gbc_JLabel_Error.gridwidth = 2;
        gbc_JLabel_Error.insets = new Insets(0, 0, 5, 5);
        gbc_JLabel_Error.gridx = 1;
        gbc_JLabel_Error.gridy = 2;
        JLabel_Error.setVisible(false);
        logging_panel.add(JLabel_Error, gbc_JLabel_Error);
        
        JLabel JLabel_Contraseña = new JLabel("Contrase\u00F1a:");
        JLabel_Contraseña.setFont(new Font("Source Serif Pro", Font.BOLD | Font.ITALIC, 22));
        JLabel_Contraseña.setForeground(Color.WHITE);
        JLabel_Contraseña.setBackground(Color.BLACK);
        GridBagConstraints gbc_JLabel_Contraseña = new GridBagConstraints();
        gbc_JLabel_Contraseña.anchor = GridBagConstraints.EAST;
        gbc_JLabel_Contraseña.insets = new Insets(0, 0, 5, 5);
        gbc_JLabel_Contraseña.gridx = 0;
        gbc_JLabel_Contraseña.gridy = 3;
        logging_panel.add(JLabel_Contraseña, gbc_JLabel_Contraseña);
        
        passwordField = new JPasswordField();
        passwordField.setColumns(30);
        GridBagConstraints gbc_passwordField = new GridBagConstraints();
        gbc_passwordField.anchor = GridBagConstraints.WEST;
        gbc_passwordField.gridwidth = 2;
        gbc_passwordField.insets = new Insets(0, 0, 5, 0);
        gbc_passwordField.gridx = 1;
        gbc_passwordField.gridy = 3;
        logging_panel.add(passwordField, gbc_passwordField);
        
        JButton JButton_Aceptar = new JButton("Aceptar");
        JButton_Aceptar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		JLabel_Error.setVisible(false);
        		Connect conexion = new Connect();
        		if(conexion.validarUsuario(textField_Usuario.getText())) {
        			JLabel_Error.setVisible(true);
        		}
        		else {
        		conexion.registrar("insert into usuarios values ('"+textField_Usuario.getText()+"', +MD5('"+String.valueOf(passwordField.getPassword())+"'))");
        		}
        	}
        });
        GridBagConstraints gbc_JButton_Aceptar = new GridBagConstraints();
        gbc_JButton_Aceptar.anchor = GridBagConstraints.EAST;
        gbc_JButton_Aceptar.insets = new Insets(0, 0, 0, 5);
        gbc_JButton_Aceptar.gridx = 0;
        gbc_JButton_Aceptar.gridy = 4;
        logging_panel.add(JButton_Aceptar, gbc_JButton_Aceptar);
        
        JButton JButton_Cancelar = new JButton("Cancelar");
        JButton_Cancelar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Login_GUI login = new Login_GUI();
        		login.setVisible(true);
        		setVisible(false);
        		login.setResizable(false);
        	}
        });
        GridBagConstraints gbc_JButton_Cancelar = new GridBagConstraints();
        gbc_JButton_Cancelar.anchor = GridBagConstraints.WEST;
        gbc_JButton_Cancelar.gridx = 2;
        gbc_JButton_Cancelar.gridy = 4;
        logging_panel.add(JButton_Cancelar, gbc_JButton_Cancelar);
	}
	
	
}