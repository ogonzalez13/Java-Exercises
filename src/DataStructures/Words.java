package DataStructures;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class Words {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner (System.in);
		
		//Obtener el string a analizar
		String strWord = new String();
		System.out.println("Proporciona un texto o cadena de caracteres: ");
		strWord = sc.nextLine();
		System.out.println("Tu frase es: " + strWord);
		strWord= strWord.toLowerCase();
		System.out.println();
		//Determinar si el string contiene las 26 palabras del abecedario		
		abcdario(strWord);		
		
		//Determinar si el string es palindromo
		palindromo (strWord);
		
		//Determinar que caracteres son m�s comunes en un texto
		caracteres (strWord);
		
	}
	
	/**
	 * @param strWord
	 */
	public static void abcdario (String strWord) {
		int intWordLenght = strWord.length();			
		ArrayList arrayWord = new ArrayList();		
		char arrayAbcdario[]= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		boolean blnTodas = true;
		
		//Pasar string a ArrayList		
		for (int j = 0; j < intWordLenght; j++) {arrayWord.add(strWord.charAt(j));}
		
		//Validar cada letra del Abcdario en el arraylist
		int i=0;
		while ((blnTodas==true)&&(i<26))
		{		
			if (arrayWord.contains(arrayAbcdario[i])) {								
				blnTodas = true;
				i++;
			} else {
				blnTodas = false;
				
			}
		}	
		
		if (blnTodas == true) {		
			System.out.println("****TODAS LAS LETRAS*****");
			System.out.println ("La cadena de caracteres '" + strWord + "' contiene todas las letras del abecedario.");
			System.out.println();
		} else {
			System.out.println("****TODAS LAS LETRAS*****");
			System.out.println ("La cadena de caracteres '" + strWord + "' NO contiene la letra " + arrayAbcdario[i]);
			System.out.println();
		}
		
	}
	
	public static void palindromo (String strWord) {
		String strWithoutSpaces =(strWord.replace(" ",""));		
		ArrayList<Character> arrayPal = new ArrayList ();
		ArrayList<Character> arrayInverso = new ArrayList ();
		
		
		for (int i = 0; i < strWithoutSpaces.length(); i++) { //Pasar el string a ArrayList
			arrayPal.add(strWithoutSpaces.charAt(i));
		}
		
	    for (int x=strWithoutSpaces.length()-1;x>=0;x--) { //Crear el ArrayList inverso
	    	arrayInverso.add(strWithoutSpaces.charAt(x));
	    }				
		
		/*for (int l = 0; l < arrayInverso.size(); l++) { //Pasar el string a ArrayList
			System.out.print(arrayInverso.get(l));
		}
	    System.out.println();
		System.out.println(strWithoutSpaces);*/
		if (arrayPal.equals(arrayInverso)) {
			System.out.println("******PALINDROMOS*****");
			System.out.println("La frase: '" + strWord + "' es un palindromo");
			System.out.println();
		} else {
			System.out.println("******PALINDROMOS*****");
			System.out.println("La frase: '" + strWord + "' NO es un palindromo");
			System.out.println();
		}		
	}
	
	public static void caracteres (String strWord) {
		String strWithoutSpaces =(strWord.replace(" ",""));
		TreeSet<Character> hshWord = new TreeSet();
				
		for (int i = 0; i < strWithoutSpaces.length(); i++) { //Obtener los caracteres contenidos en el string
			hshWord.add(strWithoutSpaces.charAt(i));
		}
		ArrayList<Character> lstCharacters = new ArrayList<Character>(hshWord);
		System.out.println("*****CONTADOS DE CARACTERES*****");
		for (int o = 0; o < lstCharacters.size(); o++) {
			int contador =0;
			for (int l = 0; l <strWithoutSpaces.length(); l++) {
				if (lstCharacters.get(o)==strWithoutSpaces.charAt(l)) {
					contador ++;
				}
			}		
			System.out.println("El caracter '"+lstCharacters.get(o)+"' aparece " +contador+ " veces");
		}
		System.out.println();
		//System.out.println();
		//System.out.println(lstCharacters);
		
	}
}
