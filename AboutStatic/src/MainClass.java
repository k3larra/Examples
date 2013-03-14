
public class MainClass {

	/**
	 * @param args
	 */
	private int dynamicVariable1 = 9;
	public static void main(String[] args) {
		//Om något är static så skapas det direkt 
		//Man kan inte nå sådant som inte är deklarerat static från en static kontext
		// dynamicVariable1 = 10; //FEL det blir "Cannot make a static reference to the non-static field dynamicVariable"
		
		//SÅ eftersom denna main metoden är statisk kan den inte nå dynamiska variabler som är
		//deklarerade UTANFÖR!!! men
		int dynamicVariable2 = 9;
		dynamicVariable2 = 11;
		//Men detta går bra eftersom den är deklarerad inne i denna metoden och skapas
		//när denna metoden skapas.
	}

}
