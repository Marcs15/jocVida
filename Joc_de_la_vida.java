import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;

public class Joc_de_la_vida {
	
	Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	      
		Joc_de_la_vida joc=new Joc_de_la_vida();
		joc.principio();
	
	}
	
	private static final int Vivo = 1;
	private static final int Muerto = 0;
	
	public void principio() {
		
		/*/////////////////////////////////////////////////////////////////////////////////////////////////
									boolean ahueboperro = true; 
									
									while (ahueboperro) {
										System.out.println("x");
										int x = entrada.nextInt();
										
										System.out.println("y");
										int y = entrada.nextInt();
										
										int ahueboperron[][] = coordCeldas(x,y, 10, 10);
										for(int puta = 0; puta < ahuebop	erron.length; puta++) {
											System.out.println("vecinas: " + puta + " x : " + ahueboperron[puta][0] + " y : " + ahueboperron[puta][1] );
										}
									}
		//////////////////////////////////////////////////////////////////////////////////////////////// */
		
		CrearMenu();
		

		
		//comprobarTablero(tablero);
		
		
		
	}
	
	public void CrearMenu () {
		
		int [][] tablero = null;
								
		System.out.println("0. Crear tablero"); 
		System.out.println("1. Crear celulas manualmente"); 
		System.out.println("2. Crear celulas automáticamente");
		System.out.println("3. Editar medida tablero: ");
		System.out.println("4. Ver el tablero: ");
		System.out.println("5. Jugar partida: ");
		System.out.println("6. Salir ");
		
		while(true) {
			
			int opcio = leerEntero("Introduce una opcion:");
			
			switch (opcio) {
			
			case 0:
				int filasy = leerEntero("De cuantas filas quieres el tablero");
				
				int columnasx = leerEntero("De cuantas columnas quieres el tablero");
				tablero =crearTablero(filasy, columnasx);
				
				break;
			
			case 1: 
				
				colocarCeldas(tablero);
				
				break;
				
			case 2: 
				break;
				
			case 3: 
				break;
				
			case 4:
				imprimirTablero(tablero);
				break;
				
			case 5:
				empezarSimulacion(tablero);
				break;
			case 6:
				System.exit(0);
				break;
			default:
				System.err.println("Introdueix una opcio vàlida");
				
			
	
		}
			
		}
				
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
				System.out.print((tablero[y][x] == Vivo ? (char)9679 : (char)9675) + " ");
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
	
	
	public int [][] coordCeldas(int x, int y, int columnasX, int filasY) {
		//dime coordenada x y coordenada y, y buscar las vecinas, a partir de ahi construir un array 2dim , donde guardara la posx y posy de las celdas vecinas
		// otro metodo que reciba array vecinas, y devuelva cuantas de ellas estan vivas. 
		
		int[][] vecinitas = new int [8][2];
		
		y--;
	
		vecinitas[0][0] = x;
		vecinitas[0][1] = y;
		x++;
		
		vecinitas[1][0] = x;
		vecinitas[1][1] = y;
		x--;
		x--;
		
		vecinitas[2][0] = x;
		vecinitas[2][1] = y;
		
		y++;
		
		vecinitas[3][0] = x;
		vecinitas[3][1] = y;
		
		y++;
		
		vecinitas[4][0] = x;
		vecinitas[4][1] = y;
		
		x++;
		
		vecinitas[5][0] = x;
		vecinitas[5][1] = y;
		
		x++;
		
		vecinitas[6][0] = x;
		vecinitas[6][1] = y;
		
		y--;
		
		vecinitas[7][0] = x;
		vecinitas[7][1] = y;
		
		int [][] vecinitasfinal  = new int [8][2];
		
		int contador = 0;
		
		for (int recorrer = 0; recorrer < vecinitas.length; recorrer ++) {
			if ((vecinitas[recorrer][0] >= 0 && vecinitas[recorrer][0] < columnasX) && (vecinitas[recorrer][1] >= 0 && vecinitas[recorrer][1] < filasY)) {
				vecinitasfinal [contador] = vecinitas[recorrer];
				contador ++;
			}
			
		}

		return Arrays.copyOfRange(vecinitasfinal, 0, contador);
	}
	
	//public 
	// recibir array de vecinas, para decir cuantas vecinas estan vivas
	
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
