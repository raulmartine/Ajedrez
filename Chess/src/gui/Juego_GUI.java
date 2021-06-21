package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

import javax.swing.border.BevelBorder;
import java.awt.Color;

public class Juego_GUI extends JFrame{

	private JPanel contentPane;
	private static BufferedReader input;
	private static PrintStream output;
	
	public JPanel getContentPane() {
		return contentPane;
	}

	private static Juego_GUI P;
	private static Tablero_GUI fondo;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					P = new Juego_GUI(input, output);
					P.setResizable(false);
					P.pack();
					P.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Juego_GUI(BufferedReader input, PrintStream output) {
		this.input=input;
		this.output=output;
		 fondo = new Tablero_GUI(input, output);
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 753, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		setContentPane(fondo);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
	}

}
