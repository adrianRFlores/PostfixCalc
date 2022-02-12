import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

/**
 * @author Adrian Flores
 *
 */
class Main{

	public static void main(String[] args){

		PosfixCalc calc = new PosfixCalc();
		
		ArrayList<String> lineas = new ArrayList<String>();
		

		int resultado;

		try{
			File archivo = new File("datos.txt");
			Scanner lector = new Scanner(archivo);
			while(lector.hasNextLine()){
				lineas.add(lector.nextLine());
			}
			lector.close();
		} catch(Exception e){
			e.printStackTrace();
		}

		for(int i = 0; i<lineas.size() ; i++){
			System.out.println(lineas.get(i));
			resultado = calc.Evaluate(lineas.get(i));
			if(resultado != -999 && resultado != -998){
				System.out.println("= " + resultado + "\n");
			} else {
				System.out.println((resultado==-999)?"Division entre 0\n":"Error de entrada, revise el archivo\n");
			}
			

		}

	}
}