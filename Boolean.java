import java.util.HashMap;
import core.Document;
import indexation.Index;
import indexation.Parser;
import indexation.Parser1;
import indexation.ParserCISI;
import indexation.Stemmer;
import indexation.TextRepresenter;   

public class Boolean extends IRModel{

	public Boolean (Index i){
		super(i);
	}

	public HashMap<String,Integer> getdocrequete(String query){

		// hasmap contenant les mots de la requette
		Document req= new Document("01",query);
		HashMap<String,Integer> requete= index.geTfsForDoc(req);

		// je récupère le 1er mot de ma requête
		for (HashMap.Entry<String,Integer> entry :requete.entrySet()){
   				String mot=entry.getKey();		
   				break;
				}

		// je veux la liste des doc contenant ce mot
		HashMap<String,Integer> listedoc = index.geTfsForStem(mot);

		// liste des mots contenu dans la hashmap requete
		Set<String> listemotrequete =  new HashSet<String>() ;
		 listemotrequete=requete.Keyset();
	
	// je regarde si les mots de ma requête sont contenu dans le doc
		// si un des mot manque , alors je remove le doc de listedoc

		// je commence par transformer les doc en hasmap

		for(HashMap.Entry<String, Integer> entry :listedoc.entrySet()){
   				Document doc= new Document ("02",entry.getKey());

   				HashMap<String,Integer> document= index.geTfsForDoc(doc);

   				// je regarde si mon doc contient tous les mots de listemotrequete

   				for (int i=0;i<listemotrequete.size();i++){
   					if (document.containsKey(listemotrequete[i])==false){
   						listedoc.remove(doc);
   						break;
   					}

   				}


		}
		return listedoc; // je retourne la liste de document contenant 
							// tous les mots de la requete
	}

}