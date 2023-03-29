import java.util. HashMap;
import core.Document;
import indexation.Index;
import indexation.Parser;
import indexation.Parser1;
import indexation.ParserCISI;
import indexation.Stemmer;
import indexation.TextRepresenter;  

public class VectorielCartesien extends IRModel {

	private Weighter weighter;

	public VectorielCartesien(Index index, Weighter w){
		super(index);
		weighter=w;
	}
	// retourne le score d'un doc dans une requete
	public double VectorialCart(String query,Document doc){
		double score=0;
		//je transforme query en doc pour pouvoir 
		// calculer le score de chacun de ses termes
		Document requete = new Document("1",query);
		//je récupère les mots de la requete dans une hashmap
		HashMap<String,Integer> requete2= index.getTfsForDoc(requete);

		//je récupère les mots du doc dans une hashmap
		HashMap<String,Integer> document= index.getTfsForDoc(doc);
		// je met les clef du document dans une liste pour 
		//pouvoir les utiliser après, pour calculer le score
		Set<String> listemotdoc =  new HashSet<String>() ;
		 listemotdoc=document.Keyset();

		int i=0;
		// je calcule le score
		for (HashMap.Entry<String, Integer> entry : requete2.entrySet()){
   			 // je recupere le score des mots de la requete et ceux du doc
			score= score + (weighterTF.frequence(requete,entry.getKey())*weighterTF.frequence(doc,listemotdoc[i]));
			i++;
		}

		return score;

	}

public double VectorialCos(String query, Document doc){

	double numerateur= VectorialCart(query,doc);

	// je calcule le dénominateur
	int denominateur;

	double sommeqicarre=0;
	//je transforme query en doc pour pouvoir 
	// calculer le score de chacun de ses termes
	Document requete = new Document("1",query);
	//je récupère les mots de la requete dans une hashmap
	HashMap<String,Integer> requete2= index.getTfsForDoc(requete);

	for (HashMap.Entry<String, Integer> entry : requete2.entrySet()){
   			   
			sommeqicarre= sommeqicarre + (weighterTF.frequence(requete,entry.getKey()))*(weighterTF.frequence(requete,entry.getKey()));
			
		}

	sommeqicarre=Math.sqrt(sommeqicarre);

 	int sommedicarre=0;
 	// je recupere les mot du doc dans une hasmap
 	HashMap<String,Integer> document= index.getTfsForDoc(doc);
 	
 	for (HashMap.Entry<String, Integer> entry : document.entrySet()){
   			   
			sommedicarre= sommedicarre + (weighterTF.frequence(doc,entry.getKey()))*(weighterTF.frequence(doc,entry.getKey()));
		
		}


		sommedicarre=Math.sqrt(sommedicarre);

		denominateur=sommeqicarre*sommedicarre;
		return denominateur;


}

// je cré une méthode qui calcule le score de tous les doc
// correspondant à une requête et qui renvoie la liste 
//ordonné ddes docs correspondant à la recherche

public HashMap<String,Integer> listedoctrier(String query){

	// je commence par créer une hasmap à partir de ma requête
	// pour pouvoir en extraire un mot
	// et ainsi former une liste de document correspondant à ma recherche
	

	Document requete = new Document("1",query);
	//je récupère les mots de la requete dans une hashmap
	HashMap<String,Integer> requete2= index.getTfsForDoc(requete);


	// je récupère la liste des docs correspondant à ma recherche
	for (HashMap.Entry<String,Integer> entry :requete2.entrySet()){
   				String mot=entry.getKey();		
   				break;
				}

		// je veux la liste des doc contenant ce mot

		HashMap<String,Integer> listedoc = index.geTfsForStem(mot);

		// maintenant jai les documents qui m'intéresse par rapport 
		// à ma recherche

		// je crée la liste qui contient les docs avec leur score
		double scoredoc;
		HashMap<String,Integer> liste = new HashMap<>();


		for (HashMap.Entry<String,Integer> entry :listedoc.entrySet()){
			// je calcule le score de chaque doc de la requete
			// je cré un doc à partir de la string pour pouvoir utiliser la méthode
			scoredoc=VectorialCart(query,new Document("1"entry.getKey()));
			// j'ajoute le doc avec son score a la liste que je vais renvoyer
			// la clef est le doc et la valeur est le score
			liste.put(entry.getKey(),scoredoc);
				}

				return liste;
}


}