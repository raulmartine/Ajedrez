package gui;

import java.io.BufferedReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JTextArea;

import logica.Movimiento;

public class Reading extends Thread{
	
	private BufferedReader in = null;
	int origenfila,origencolumna,destinofila,destinocolumna;
	JButton [][]piezas;
	
	public Reading(BufferedReader in, int origenfila, int origencolumna, int destinofila, int destinocolumna, JButton[][]piezas) {
		this.in=in;
		this.origenfila=origenfila;
		this.origencolumna=origencolumna;
		this.destinofila=destinofila;
		this.destinocolumna=destinocolumna;
		this.piezas=piezas;
	}
	
	@Override
	public void run() {
		String line= "";
		while (true) {
			System.out.println("Reading while");
				try {
					System.out.println("Reading try antes in");
					line=in.readLine();
					System.out.println("Reading try pos in");
				if (line.startsWith("origen")) {
					line=in.readLine();
					origenfila=Integer.parseInt(line.substring(line.length()-3));
					origencolumna=Integer.parseInt(line.substring(line.length()-1));
					System.out.println("Reading origen");
				}
				else if (line.startsWith("destino")) {
					line=in.readLine();
					destinofila=Integer.parseInt(line.substring(line.length()-3));
					destinocolumna=Integer.parseInt(line.substring(line.length()-1));
					System.out.println("Reading destino");
					Movimiento_GUI.moverPieza(piezas[origenfila][origencolumna], piezas[destinofila][destinocolumna]);
				}
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
