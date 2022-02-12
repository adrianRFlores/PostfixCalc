import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

class Main{

	public static void main(String[] args){

		PosfixCalc calc = new PosfixCalc();
		
		ArrayList<String> lineas = new ArrayList<String>();

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
			calc.Evaluate(lineas.get(i));

		}

	}
}