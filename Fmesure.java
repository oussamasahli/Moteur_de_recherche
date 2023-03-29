import java.util.HashMap;
import core.Document;
import indexation.Index;
import indexation.Parser;
import indexation.Parser1;
import indexation.ParserCISI;
import indexation.Stemmer;
import indexation.TextRepresenter;  

public class Fmesure extends evaluation {

	// une liste de document c'est une hashmap, double car ils ont un score
 	public Fmesure (HashMap<String,Integer>listedocAttendu, String query){
 			super(listedocAttendu,query);
 	}

 public static double fmesure(int N,HashMap<String,Integer>listedoc){
 	double mesure=0;
 	mesure = presicion.Precision(N,listedoc)*rappel.Rappel(N,listedoc);
 	mesure=mesure/(presicion.Precision(N,listedoc)+rappel.Rappel(N,listedoc));
 	mesure=mesure*2;
 	return mesure;
 }
