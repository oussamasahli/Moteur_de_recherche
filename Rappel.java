import java.util.HashMap;
import core.Document;
import indexation.Index;
import indexation.Parser;
import indexation.Parser1;
import indexation.ParserCISI;
import indexation.Stemmer;
import indexation.TextRepresenter;  

public class Rappel extends evaluation {

	// une liste de document c'est une hashmap, double car ils ont un score
 	public Rappel (HashMap<String,Integer>listedocAttendu, String query){
 			super(listedocAttendu,query);
 	}



public static double rappel(int N,HashMap<String,Integer>listedoc){

 		int nbelemDA=0;
 		int nbelemDninterDA=0;
 		int i=0;
 		// je calule le nombre d'élément de DN
 		for (HashMap.Entry<String,Integer> entry:listedocAttendu.entrySet()){
 
 				nbelemDA++;
 				
 		}


		for (HashMap.Entry<String, Integer> entry:listedoc.entrySet()){
   				 if (i==N){
   				 	nbelemDninterDA=nbelemDninterDA/nbelemDA;
   				    return nbelemDninterDA;;
   				  }


   				 String doc=entry.getKey();
   				 for (HashMap.Entry<String, Double> entry:listedocAttendu.entrySet()){
   						if(entry.getKey().compareto(doc)==0){
   							nbelemDninterDA++;
   							break;
   						}
   
   				}

   			i++;				
	    }

				
 	}
}
