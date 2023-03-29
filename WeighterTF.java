
import java.util. HashMap;
import core.Document;
import indexation.Index;
import indexation.Parser;
import indexation.Parser1;
import indexation.ParserCISI;
import indexation.Stemmer;
import indexation.TextRepresenter;

public class WeighterTF extends Weighter{

	public WeighterTF (Index index){
		super(index);
	}
	// méthode de pondération d'un mot 
	// ELLE retourne le poid du mot dans un doc(sa fréquence)
	public static double frequence(Document doc,String motdudoc){

		// je transforme mon document en hasmap
		HashMap<String,Integer> liste= index.getTfsForDoc(doc);
		// je cré une deuxieme hashmap qui cntiendra les fréquaence des mots
		HashMap<String,Integer> Frequence = new HashMap<>();

	  // je compte le nombre d'élément de liste
		int nbelem=0;
		// la clef est de type string , la valeur(nb d'occurrence) de type integer
		for (HashMap.Entry<String, Integer> entry : liste.entrySet()){
   			   nbelem=nbelem+entry.getValue().intValue();  // dans value il y a  le nombre d'occurence du mot

		}

		// je cré ma liste de fréquence
 		for (HashMap.Entry<String,Integer> entry : liste.entrySet()){
 			// je récupère la valeur , et je la divise par le nbelem
 			 int val =entry.getValue().intValue(); // je récupère la valeur de l'integer
 			 val=val/nbelem;
 			 Integer i = new Integer(val);
 			Frequence.put(entry.getKey(),i);
   			  
		}

	 // jobtient une hashmap où les occurence des mots sont
	//représenté sous forme de fréquence

	// je parcoure cette nouvelle hasmap pour obtenir la frequence du 
	//mot que je veux

	for (HashMap.Entry<String, Integer> entry : frequence.entrySet()){
   			  if (entry.getKey().compareto(motdudoc)==0)
   			  		return entry.getValue().intValue();
   			  		// je retourne la fréquence du mot dans le doc
		}



} 