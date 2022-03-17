import java.util.Scanner;

public class Joc_de_la_vida {
	
	Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Joc_de_la_vida joc=new Joc_de_la_vida();
		joc.principio();
	
	}
	
	private static final char Vivo = '1';
	private static final char Muerto = '0';
	
	public void principio() {
		
		int filasy = leerEntero("De cuantas filas quieres el tablero");
	
		int columnasx = leerEntero("De cuantas columnas quieres el tablero");
		
		int [][] tablero =crearTablero(filasy, columnasx);
		
		imprimirTablero(tablero);
		
		colocarCeldas(tablero);
		
		empezarSimulacion(tablero);
		
		//comprobarTablero(tablero);
		
	}
	
	public void colocarCeldas(int [] [] tablero) {
		
		int coordenadax, coordenaday;
		
		for (int coordmax = 0; coordmax < 5; coordmax ++) {
				coordenadax = leerEntero("Introduce la coordenada X")-1;
			
				coordenaday = leerEntero("Introduce la coordenada Y")-1;
				
					colocarVida(coordenaday, coordenadax, tablero);
				
					imprimirTablero(tablero);
			
		}
	}
	
	public int leerEntero(String mensaje) {
		
		System.out.print(mensaje + " : ");
		return entrada.nextInt();
		
	}
	
	public int[][] crearTablero(int filasY, int columnasX){
		
		int [][] tablero = new int [filasY] [columnasX];
		
		return tablero;
	}
	
	public void imprimirTablero(int tablero[][]) {
		for (int y = 0; y < tablero.length; y++) {
			for (int x = 0; x < tablero.length; x++) {
				System.out.print(tablero[y][x]+" ");
			}
			System.out.println();
		}
	}
	
	
	
	public void colocarVida(int filasY, int columnasX, int tablero[][]) {
		
		tablero[filasY][columnasX] = 1;  
		
	}
	
	public void empezarSimulacion(int [] [] tablero) {
		for (int recorr = 0; recorr < tablero.length; recorr ++) {
			for (int recorr2 = 0; recorr2 < tablero[recorr].length; recorr2 ++) {
				
				
				int contadorvivos;
				
				int contadormuertos;
			
				
			}
		}
	}
	
	
	public void coordCeldas() {
		//dime coordenada x y coordenada y, y buscar las vecinas, a partir de ahi construir un array 2dim , donde guardara la posx y posy de las celdas vecinas
		// otro metodo que reciba array vecinas, y devuelva cuantas de ellas estan vivas. 
	}
	
	/*public void comprobarTablero (int tablero[][]) {
		boolean bandera;
		for (int y = 0; y < tablero.length; y ++) {
			for (int x = 0; x < tablero[y].length; x ++) {
				int casilla = tablero[y][x];
				
				if (casilla == Muerto) {
					bandera = comprobarCasilla(false, y, x );
				}
				
				else {
					bandera = comprobarCasilla(true, y, x );
				}
				
				if (bandera) {
					tablero[y][x] = Vivo;
					
				}
				
				else {
					tablero[y][x] = Muerto;
				}
			}
			
		}
	}
	*/
	
	/*
	public boolean comprobarCasilla(boolean bandera, int y, int x ) {
		int contador = 0;
		
		if (!bandera && contador >= 3) return true;
		
		if (bandera && contador == 2 || contador == 3) return true;
		
		return false;
		
	}
	
	*/
	

}
