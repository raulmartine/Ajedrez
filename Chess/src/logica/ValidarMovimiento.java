package logica;

public class ValidarMovimiento {

	private Pieza piezaOrigen;
	private Pieza piezaDestino;
	
	public void movimiento_Valido(Movimiento mov){
		int origenfila=mov.origenfila;
		int origencolumna=mov.origencolumna;
		int destinofila=mov.destinofila;
		int destinocolumna=mov.destinocolumna;
		if((origenfila < Pieza.FILA_1) || (destinofila > Pieza.FILA_8)
		|| (origencolumna < Pieza.COLUMNA_1) || (destinocolumna > Pieza.COLUMNA_8)) {
			switch(piezaOrigen.getTipo()) {
				case Pieza.TORRE:
					validar_Movimiento_Torre(origenfila, origencolumna, destinofila, destinocolumna);
				case Pieza.CABALLO:
					validar_Movimiento_Caballo(origenfila, origencolumna, destinofila, destinocolumna);
				case Pieza.ALFIL:
					validar_Movimiento_Alfil(origenfila, origencolumna, destinofila, destinocolumna);
				case Pieza.REINA:
					validar_Movimiento_Reina(origenfila, origencolumna, destinofila, destinocolumna);
				case Pieza.REY:
					validar_Movimiento_Rey(origenfila, origencolumna, destinofila, destinocolumna);
				case Pieza.PEON:
					validar_Movimiento_Peon(origenfila, origencolumna, destinofila, destinocolumna);
			}
		}
	}

	public boolean validar_Movimiento_Torre(int origenfila, int origencolumna, int destinofila, int destinocolumna){
		int difFila = destinofila - origenfila;
		int difColumna = destinocolumna - origencolumna;
		boolean valido=false;
		
		if(difFila == 0 && difColumna > 0){
			//metodo pieza en medio
		}
		else if(difFila == 0 && difColumna < 0){
			//metodo pieza en medio
		}
		else if(difFila > 0 && difColumna == 0){
			//metodo pieza en medio
		}
		else if(difFila < 0 && difColumna == 0){
			//metodo pieza en medio
		}
		else {
			valido=false;
		}
		return valido;
	}
	
	public boolean validar_Movimiento_Caballo(int origenfila, int origencolumna, int destinofila, int destinocolumna){
		int difFila = destinofila - origenfila;
		int difColumna = destinocolumna - origencolumna;
		boolean valido= false;
		
		if(difFila==difColumna && difColumna > 0){
			//metodo pieza en medio
		}
		else if(difFila==-difColumna && difColumna > 0){
			//metodo pieza en medio
		}
		else if(difFila==difColumna && difColumna < 0){	
			//metodo pieza en medio
		}
		else if(difFila==-difColumna && difColumna < 0){
			//metodo pieza en medio
		}
		else {
			valido=false;
		}
		return valido;
	}
	public boolean validar_Movimiento_Alfil(int origenfila, int origencolumna, int destinofila, int destinocolumna){
		boolean valido=false;
		
		if( origenfila+2 == destinofila && origencolumna+1 == destinocolumna){
			//metodo pieza en medio
		}
		else if( origenfila+1 == destinofila && origencolumna+2 == destinocolumna){
			//metodo pieza en medio
		}
		else if( origenfila-1 == destinofila && origencolumna+2 == destinocolumna){
			//metodo pieza en medio
		}
		else if( origenfila-2 == destinofila && origencolumna+1 == destinocolumna){
			//metodo pieza en medio
		}
		else if( origenfila-2 == destinofila && origencolumna-1 == destinocolumna){
			//metodo pieza en medio
		}
		else if( origenfila-1 == destinofila && origencolumna-2 == destinocolumna){
			//metodo pieza en medio
		}
		else if( origenfila+1 == destinofila && origencolumna-2 == destinocolumna){
			//metodo pieza en medio
		}
		else if( origenfila+2 == destinofila && origencolumna-1 == destinocolumna){
			//metodo pieza en medio
		}
		else {
			valido=false;
		}
		return valido;
	}

	public boolean validar_Movimiento_Reina(int origenfila, int origencolumna, int destinofila, int destinocolumna){
		boolean valido=(validar_Movimiento_Caballo(origenfila, origencolumna, destinofila, destinocolumna)
				|| (validar_Movimiento_Torre(origenfila, origencolumna, destinofila, destinocolumna)));
		return valido;
	}

	public boolean validar_Movimiento_Rey(int origenfila, int origencolumna, int destinofila, int destinocolumna){
		boolean valido=false;
		
				if(origenfila+1 == destinofila && origencolumna == destinocolumna){
					valido = true;
				}
				else if(origenfila+1 == destinofila && origencolumna+1 == destinocolumna){
					valido = true;
				}
				else if(origenfila == destinofila && origencolumna+1 == destinocolumna){
					valido = true;
				}
				else if(origenfila-1 == destinofila && origencolumna+1 == destinocolumna){
					valido = true;
				}
				else if(origenfila-1 == destinofila && origencolumna == destinocolumna){
					valido = true;
				}
				else if(origenfila-1 == destinofila && origencolumna-1 == destinocolumna){
					valido = true;
				}
				else if(origenfila == destinofila && origencolumna-1 == destinocolumna){
					valido = true;
				}
				else if(origenfila+1 == destinofila && origencolumna-1 == destinocolumna){
					valido = true;
				}
				else{
					valido = false;
				}
		return valido;
	}

	public boolean validar_Movimiento_Peon(int origenfila, int origencolumna, int destinofila, int destinocolumna){
		boolean valido=false;
		
			if(origencolumna==destinocolumna) {
				if(origenfila+1==destinofila) {
					valido=true;
				}
				else if(origenfila+2==destinofila) {
					valido=true;
				}
				else if(origenfila-1==destinofila) {
					valido=true;
				}
				else if(origenfila-2==destinofila) {
					valido=true;
				}
			}
			else {
				valido=false;
			}
		return valido;
	}
}