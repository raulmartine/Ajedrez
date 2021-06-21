package gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.PrintStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Movimiento_GUI {
	int cont = 0;
	JButton origen = new JButton();
	JButton destino = new JButton();
	static JButton [][] piezas;
	
	private static BufferedReader input;
	private static PrintStream output;
	
	public Movimiento_GUI(BufferedReader input, PrintStream output, JButton origen, JButton destino, JButton [][] piezas) {
		this.origen=origen;
		this.destino=destino;
		this.piezas=piezas;
		this.input=input;
		this.output=output;
	}
	
	
	public static void moverPieza(JButton origen, JButton destino) {
		Color fondo_origen = origen.getBackground(); 
		destino.setIcon(origen.getIcon());
		origen.setBackground(fondo_origen);
		origen.setIcon(null);
		
	}
	
}