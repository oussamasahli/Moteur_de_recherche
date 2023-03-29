
import java.util. HashMap;
import core.Document;
import indexation.Index;
import indexation.Parser;
import indexation.Parser1;
import indexation.ParserCISI;
import indexation.Stemmer;
import indexation.TextRepresenter;  

public class WeighterTFIDF extends Weighter{

	public WeighterTFIDF (Index index){
		super(index);
	}

	// calcule la fréquence d'un mot dans un doc
	public static double frequence(Document doc , String motdudoc){
		double idf;
		// on va calculé l'idf 
		// connaitre le nombre de doc qui contient le terme 

		HashMap<String,Integer> liste= index.getTfsForStem(motdudoc);
		int nbdoc;

		for (HashMap.Entry<String, Integer> entry : liste.entrySet()){
			nbdoc++;    

		}
		// N = nombre de terme du doc 
		HashMap<String,Integer> liste= index.getTfsForDoc(doc);
		 // je compte le nombre d'élément de liste
		int nbelem=0;
		// la clef est de type string , la valeur(nb d'occurrence) de type integer
		for (HashMap.Entry<String, Integer> entry : liste.entrySet()){
   			   nbelem=nbelem+entry.getValue().intValue();  // dans value il y a  le nombre d'occurence du mot

		}

 		idf=nbelem/nbdoc;
 		idf=Math.log(idf);
 		idf=idf*(WeighterTF.frequence(doc,motdudoc); // multiplication de tf avec idf
 		return idf;

	}

}