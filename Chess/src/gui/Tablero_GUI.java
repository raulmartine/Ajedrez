package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.TransferHandler;
import javax.swing.border.EmptyBorder;

import datos.Connect;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.PrintStream;

import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

public class Tablero_GUI extends JPanel {
	
	public int cont=0;
	private JButton origen;
	private JButton destino;
	private static JTextArea text = new JTextArea();
	private static BufferedReader input;
	private static PrintStream output;
	private Reading read;
	int origenfila, origencolumna, destinofila,destinocolumna;
	
	public Tablero_GUI(BufferedReader input, PrintStream output) {
		this.input=input;
		this.output=output;
		Tablero();
	}
	
	public void Tablero() {
		JButton[][] botones;
		botones = new JButton[8][8];
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones[i].length; j++) {
				botones[i][j] = new JButton();
				botones[i][j].setPreferredSize(new Dimension(50, 50));	
				JButton temp = botones[i][j];
				int fila=i;
				int columna=j;
				botones[i][j].addActionListener(new ActionListener() {
			        	public void actionPerformed(ActionEvent e) {
			        		 cont++;
			      	       if (cont==1) {
			      	    	 if (temp.getIcon()==null) {
				      	    		cont=0;
								}
			      	    	 else{
			      	    		 origen=temp;
			      	    		 origenfila=fila;
			      	    		 origencolumna=columna;
				      	    	   System.out.println("origen "+origenfila+" "+origencolumna);
				      	    	 text.setText("origen "+origenfila+" "+origencolumna);
				      	    	  	output.print("origen "+origenfila+" "+origencolumna);
				      	    	  text.setText("");
				      	    
			      	    	 	}
			      	       }
			      	       else {
			      	    	 destino=temp;
			      	    	 destinofila=fila;
			      	    	 destinocolumna=columna;
			      	    	 System.out.println("destino "+destinofila+" "+destinocolumna);
			      	    	 Movimiento_GUI mov=new Movimiento_GUI(input,output,origen, destino, botones);
			      	    	  mov.moverPieza(origen,destino);
			      	    	  	cont=0;
			      	    	  	text.setText("destino "+destinofila+" "+destinocolumna);
			      	    	  	output.print("destino "+destinofila+" "+destinocolumna);
			      	    	  	text.setText("");
			      	    
			      	    	  
			      	    	}
			        	}
			        });
				
				if ((i + j + 1) % 2 == 0) {
					botones[i][j].setBackground(Color.BLACK);
				}
				add(botones[i][j]);
			}
			setLayout(new GridLayout(8, 8));
		}
		Pieza_GUI piezas = new Pieza_GUI(botones);
		read = new Reading(input,origenfila,origencolumna,destinofila,destinocolumna,botones);
	    	read.start();
	}
}