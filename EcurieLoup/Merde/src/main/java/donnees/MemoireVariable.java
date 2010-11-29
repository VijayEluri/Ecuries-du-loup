package donnees;

import java.util.HashMap;
import java.util.Map;

public class MemoireVariable {
	private static Map<String, String> variables = new HashMap<String, String>();
	
	public static void definirVariable(String nomVariables, String valeur){
		MemoireVariable.variables.put(nomVariables, valeur);
	}
	
	public static String optenirVariable(String nomVariables){
		return MemoireVariable.variables.get(nomVariables);
	}
}
