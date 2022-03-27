import java.util.Arrays;
import java.util.Scanner;

public class Joc_de_la_vida{
	
	Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	      
		Joc_de_la_vida joc=new Joc_de_la_vida ();
		joc.principio(); 
	}
	
	private static final int VIVO = 1;
	private static final int MUERTO = 0;
	
	public void principio() {
		
		CrearMenu();
		
		
	}
	
	public void CrearMenu () {
		
		int [][] tablero = null;
		
		int [] reglas = {2,3,3};
		
		
		
		while(true) {

			System.out.println("\n0. Crear tablero"); 
			System.out.println("1. Crear celulas manualmente"); 
			System.out.println("2. Crear celulas automáticamente");
			System.out.println("3. Editar reglas del juego: ");
			System.out.println("4. Ver el tablero: ");
			System.out.println("5. Jugar partida: ");
			System.out.println("6. Salir ");
			
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
				//pedir un entero, crear un metodo crearceldasautomaticas, pasar el tablero por parametros,
				//este metodo te pedira el numero de colonias, y a partir de ahi hacer un do while, por cada colonia
				//otro do while
				
				crearcelulasAuto(tablero);				
				
				break;
				
				
			case 3: 
				reglas = editarReglas();
				break;
				
			case 4:
				imprimirTablero(tablero);
				break;
				
			case 5:
				int generaciones = 0;
				while(true) {
					generaciones ++;
					System.out.println("Generación : " + generaciones);
					tablero = empezarSimulacion(tablero, reglas);
					imprimirTablero(tablero);
					System.out.println();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
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
				System.out.print((tablero[y][x] == VIVO ? '●' : '○') + " ");
				
			}
			System.out.println();
		}
	}
	
	
	
	public void colocarVida(int filasY, int columnasX, int tablero[][]) {
		
		tablero[filasY][columnasX] = 1;  
		
	}
	
	public int [] [] empezarSimulacion(int [] [] tablero, int [] reglas) {
		
		int [][] tableroCopia = new int [tablero.length] [tablero[0].length];
		
		int minsobrevivir = reglas[0];
		int maxsobrevivir = reglas[1];
		int revivir = reglas [2];
		
		for (int recorr = 0; recorr < tablero.length; recorr ++) {
			for (int recorr2 = 0; recorr2 < tablero[recorr].length; recorr2 ++) {
				
				tableroCopia[recorr][recorr2] = tablero[recorr][recorr2];  
				
				int [][] Vecinas = coordCeldas(recorr2, recorr, tablero[0].length , tablero.length);		
				int VecinasVivas = VecinitasVivas(Vecinas, tablero);
								
				if (tablero[recorr][recorr2] == VIVO && !(VecinasVivas >= minsobrevivir && VecinasVivas <= maxsobrevivir))  {
					tableroCopia[recorr][recorr2] = MUERTO;
				}
				
				else if (tablero[recorr][recorr2] == MUERTO && VecinasVivas == revivir) {
					tableroCopia[recorr][recorr2] = VIVO;
				}
				
			}
		}
		
		tablero = tableroCopia;
		
		return tablero;
		
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
	
	public int VecinitasVivas(int [][] Vecinas, int [][] tablero) {
		
		int contadorvivas = 0;
		
		for (int vivas = 0; vivas < Vecinas.length; vivas ++ ) {
			int [] celda = Vecinas [vivas];
			
			int x = celda[0];
			int y = celda[1];
			
			
			
			if(tablero[y][x] == VIVO) {
				contadorvivas ++;
				
			}
			
		}
		
		return contadorvivas;
	}
	// recibir array de vecinas, para decir cuantas vecinas estan vivas
	
	public int[] editarReglas() {
		System.out.println("Introduce las nuevas reglas");
		String regla = entrada.next();
		String [] guardar = regla.split("/");
		int minsobrevivir = Integer.parseInt(String.valueOf(guardar[0].charAt(0)));
		int maxsobrevivir = Integer.parseInt(String.valueOf(guardar[0].charAt(1)));
		int revivir = Integer.parseInt(String.valueOf(guardar[1]));
		return new int [] {minsobrevivir,maxsobrevivir, revivir};
		
	}
	
	public void crearcelulasAuto(int [][] tablero) {
		System.out.println("Introduce cuantas colonias quieres empezar: ");
		int coloniascreadas = entrada.nextInt();
		
		for (int col = 0; col<coloniascreadas; col ++) {
			
			int coordx;
			int coordy; 
			do {
				coordx = (int)(Math.random()*tablero[0].length);
				coordy = (int)(Math.random()*tablero.length);
			}
			while(tablero[coordy][coordx] == VIVO || ((coordx == 0 || coordx == tablero[0].length) && (coordy == 0 || coordy == tablero.length))) ; 
			
			tablero[coordy][coordx] = VIVO;
			
			int [][] Vecinas = coordCeldas(coordx, coordy, tablero[0].length , tablero.length);
			
			while(VecinitasVivas(Vecinas, tablero) < 4) {
				
				int coordXVecinas;
				int coordYVecinas;
				
				do {
					int posrandomVecinas = (int)(Math.random()*Vecinas.length);
					
					coordXVecinas = Vecinas[posrandomVecinas][0];
					coordYVecinas = Vecinas[posrandomVecinas][1];
				}
				
				while(tablero[coordYVecinas][coordXVecinas] == VIVO);
			
				tablero[coordYVecinas][coordXVecinas] = VIVO;
				
				Vecinas = coordCeldas(coordx, coordy, tablero[0].length , tablero.length);
			}
			
		}
		
	}
	
	/*
	public boolean comprobarCasilla(boolean bandera, int y, int x ) {
		int contador = 0;
		
		if (!bandera && contador >= 3) return true;
		
		if (bandera && contador == 2 || contador == 3) return true;
		
		return false;
		
	}
	
	*/
	

}