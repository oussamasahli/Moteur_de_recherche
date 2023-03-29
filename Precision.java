import java.util.HashMap;
import core.Document;
import indexation.Index;
import indexation.Parser;
import indexation.Parser1;
import indexation.ParserCISI;
import indexation.Stemmer;
import indexation.TextRepresenter;

public class Presicion extends evaluation {

	// une liste de document c'est une hashmap
 	public Precision (HashMap<String,Integer>listedocAttendu, String query){
 			super(listedocAttendu,query);
 	}

 	public static  double precison(int N,HashMap<String,Integer>listedoc){

 		int nbelemDN=0;
 		int nbelemDninterDA=0;
 		int i=0;
 		// je calule le nombre d'élément de DN
 		for (HashMap.Entry<String, Integer> entry:listedoc.entrySet()){
 				if(i==N)
 					break;

 				nbelemDN++;
 				i++;
 		}

 		i=0;
		for (HashMap.Entry<String, Integer> entry:listedoc.entrySet()){
   				 if (i==N){
   				 	nbelemDninterDA=nbelemDninterDA/nbelemDN;
   				    return nbelemDninterDA;;
   				  }

               //je récupère le doc de listedoc, pour voir si il est dans la hasmap listedocattendue
   				 String doc=entry.getKey();
   				 for (HashMap.Entry<String, Integer> entry:listedocAttendu.entrySet()){
   						if(entry.getKey().compareto(doc)==0){
   							nbelemDninterDA++;
   							break;
   						}
   
   				}

   			i++;				
	    }

				
 	}

}

