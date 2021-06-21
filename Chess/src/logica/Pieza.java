package logica;

public class Pieza {
	
	private int color;
	public static final int BLANCO=0;
	public static final int NEGRO=1;
	
	private int tipo;
	public static final int TORRE=0;
	public static final int CABALLO=1;
	public static final int ALFIL=2;
	public static final int REINA=3;
	public static final int REY=4;
	public static final int PEON=5;
	
	private int fila;
	public static final int FILA_1=0;
	public static final int FILA_2=1;
	public static final int FILA_3=2;
	public static final int FILA_4=3;
	public static final int FILA_5=4;
	public static final int FILA_6=5;
	public static final int FILA_7=6;
	public static final int FILA_8=7;
	
	private int columna;
	public static final int COLUMNA_1=0;
	public static final int COLUMNA_2=1;
	public static final int COLUMNA_3=2;
	public static final int COLUMNA_4=3;
	public static final int COLUMNA_5=4;
	public static final int COLUMNA_6=5;
	public static final int COLUMNA_7=6;
	public static final int COLUMNA_8=7;
	
	public Pieza(int color, int tipo, int fila, int columna) {
		this.color=color;
		this.tipo=tipo;
		this.fila=fila;
		this.columna=columna;
	}

	public int getColor() {
		return color;
	}

	public int getTipo() {
		return tipo;
	}

	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}
	
}