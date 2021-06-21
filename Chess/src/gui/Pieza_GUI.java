package gui;

import java.awt.event.MouseListener;

import javax.swing.*;

public class Pieza_GUI{
	   
	JButton [][] piezas= new JButton[8][8];
	
    public JButton[][] getPiezas() {
		return piezas;
	}

	public void setPiezas(JButton[][] piezas) {
		this.piezas = piezas;
	}

	public static ImageIcon ICONOTORRE_B = new ImageIcon(Pieza_GUI.class.getResource("/imagenes_sin_fondo/Torre_B.png"));
    public static ImageIcon ICONOTORRE_N = new ImageIcon(Pieza_GUI.class.getResource("/imagenes_sin_fondo/Torre_N.png"));
    public static ImageIcon ICONOCABALLO_B = new ImageIcon(Pieza_GUI.class.getResource("/imagenes_sin_fondo/Caballo_B.png"));
    public static ImageIcon ICONOCABALLO_N = new ImageIcon(Pieza_GUI.class.getResource("/imagenes_sin_fondo/Caballo_N.png"));
    public static ImageIcon ICONOALFIL_B = new ImageIcon(Pieza_GUI.class.getResource("/imagenes_sin_fondo/Alfil_B.png"));
    public static ImageIcon ICONOALFIL_N = new ImageIcon(Pieza_GUI.class.getResource("/imagenes_sin_fondo/Alfil_N.png"));
    public static ImageIcon ICONOREINA_B = new ImageIcon(Pieza_GUI.class.getResource("/imagenes_sin_fondo/Reina_B.png"));
    public static ImageIcon ICONOREINA_N = new ImageIcon(Pieza_GUI.class.getResource("/imagenes_sin_fondo/Reina_N.png"));
    public static ImageIcon ICONOREY_B = new ImageIcon(Pieza_GUI.class.getResource("/imagenes_sin_fondo/Rey_B.png"));
    public static ImageIcon ICONOREY_N = new ImageIcon(Pieza_GUI.class.getResource("/imagenes_sin_fondo/Rey_N.png"));
    public static ImageIcon ICONOPEON_B = new ImageIcon(Pieza_GUI.class.getResource("/imagenes_sin_fondo/Peon_B.png"));
    public static ImageIcon ICONOPEON_N = new ImageIcon(Pieza_GUI.class.getResource("/imagenes_sin_fondo/Peon_N.png"));
    
    public Pieza_GUI(JButton[][]piezas) {
    	this.piezas=piezas;
    	añadirPiezas(piezas);
    }
     
	public static void añadirPiezas(JButton[][] piezas) {
		//piezas negras
					piezas[0][0].setIcon(ICONOTORRE_N);	
					piezas[0][1].setIcon(ICONOCABALLO_N);
					piezas[0][2].setIcon(ICONOALFIL_N);	
					piezas[0][3].setIcon(ICONOREINA_N);	
					piezas[0][4].setIcon(ICONOREY_N);
					piezas[0][5].setIcon(ICONOALFIL_N);	
					piezas[0][6].setIcon(ICONOCABALLO_N);			
					piezas[0][7].setIcon(ICONOTORRE_N);
		        	for (int i = 0; i < piezas.length; i++) {
		        		piezas[1][i].setIcon(ICONOPEON_N);
					}
		//piezas blancas
		        	piezas[7][0].setIcon(ICONOTORRE_B);
		        	piezas[7][1].setIcon(ICONOCABALLO_B);
		        	piezas[7][2].setIcon(ICONOALFIL_B);
		        	piezas[7][3].setIcon(ICONOREINA_B);
		        	piezas[7][4].setIcon(ICONOREY_B);
		        	piezas[7][5].setIcon(ICONOALFIL_B);
		        	piezas[7][6].setIcon(ICONOCABALLO_B);
		        	piezas[7][7].setIcon(ICONOTORRE_B);
		        	for (int i = 0; i < piezas.length; i++) {
		        		piezas[6][i].setIcon(ICONOPEON_B);	
					}
	}
}