import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

/**
 * @author Adrian Flores
 *
 */
class Main{

	/***
	 * Método main
	 * @param args argumentos a pasar a la hora de ejecución
	 */
	public static void main(String[] args){

		PosfixCalc calc = new PosfixCalc();
		
		ArrayList<String> lineas = new ArrayList<String>();

		int resultado;

		try{ //Se intenta leer el archivo en un try-catch
			File archivo = new File("datos.txt");
			Scanner lector = new Scanner(archivo);
			while(lector.hasNextLine()){
				//Se agregan todas las expresiones a un arraylist para iterar sobre cada una y que no se vea tan amontonado aquí.
				//Uso inefeciente de memoria y tiempo? Tal vez! 
				//Nos importa? No! :D
				lineas.add(lector.nextLine()); 
			}
			lector.close();
		} catch(Exception e){
			e.printStackTrace();
		}

		//Se itera sobre cada expresion
		for(int i = 0; i<lineas.size() ; i++){
			System.out.println(lineas.get(i));
			//Se almacena el resultado de la expresion en una variable para poder utilizarlo en múltiples lugares sin tener que estar llamando la función cada vez.
			resultado = calc.Evaluate(lineas.get(i));
			//Se revisan los códigos de error definidos en la documentacion de Evaluate para poder mostrar el mensaje correcto
			if(resultado != -999 && resultado != -998){
				System.out.println("= " + resultado + "\n"); //Resultado normal
			} else {
				System.out.println((resultado==-999)?"Division entre 0\n":"Error de entrada, revise el archivo\n"); //en caso de error
			}
			

		}

	}
}