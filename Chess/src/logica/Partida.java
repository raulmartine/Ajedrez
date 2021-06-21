package logica;

import java.util.ArrayList;

public class Partida {

	static public ArrayList<Pieza> piezas = new ArrayList<Pieza>();
	static public ArrayList<Pieza> piezas_capturadas = new ArrayList<Pieza>();
	
	public void crearPartida() {
	//piezas blancas
		piezas.add(new Pieza(0,0,0,0)); //torre
		piezas.add(new Pieza(0,1,0,1)); //caballo
		piezas.add(new Pieza(0,2,0,2)); //alfil
		piezas.add(new Pieza(0,3,0,3)); //reina
		piezas.add(new Pieza(0,4,0,4));	//rey
		piezas.add(new Pieza(0,2,0,5));	//alfil
		piezas.add(new Pieza(0,1,0,6));	//caballo
		piezas.add(new Pieza(0,0,0,7));	//torre
		piezas.add(new Pieza(0,5,1,0));	//peon
		piezas.add(new Pieza(0,5,1,1)); //peon
		piezas.add(new Pieza(0,5,1,2)); //peon
		piezas.add(new Pieza(0,5,1,3)); //peon
		piezas.add(new Pieza(0,5,1,4)); //peon
		piezas.add(new Pieza(0,5,1,5)); //peon
		piezas.add(new Pieza(0,5,1,6)); //peon
		piezas.add(new Pieza(0,5,1,7)); //peon
	//piezas negras
		piezas.add(new Pieza(1,0,7,0)); //torre
		piezas.add(new Pieza(1,1,7,1)); //caballo
		piezas.add(new Pieza(1,2,7,2)); //alfil
		piezas.add(new Pieza(1,3,7,3)); //reina
		piezas.add(new Pieza(1,4,7,4)); //rey
		piezas.add(new Pieza(1,2,7,5)); //alfil
		piezas.add(new Pieza(1,1,7,6)); //caballo
		piezas.add(new Pieza(1,0,7,7)); //torre
		piezas.add(new Pieza(1,5,6,0)); //peon
		piezas.add(new Pieza(1,5,6,1)); //peon
		piezas.add(new Pieza(1,5,6,2)); //peon
		piezas.add(new Pieza(1,5,6,3)); //peon
		piezas.add(new Pieza(1,5,6,4)); //peon
		piezas.add(new Pieza(1,5,6,5)); //peon
		piezas.add(new Pieza(1,5,6,6)); //peon
		piezas.add(new Pieza(1,5,6,7)); //peon
	}
	
}