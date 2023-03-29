/*question4*/
import java.util. HashMap;
import core.Document;
import indexation.Index;
import indexation.Parser;
import indexation.Parser1;
import indexation.ParserCISI;
import indexation.Stemmer;
import indexation.TextRepresenter; 

public class TestIndexation{
	 public static void main(String[] args) {
		
		Index indexconstruit = Index.deserialize(CISI); // j'utilise la méthode static

		// "55" est un document , affiche le text du doc "55"
		Document doc=new Document ("55");
		System.out.println(doc.getText());

		
		HashMap<String,Integer> hasmap= indexconstruit.getTfsForDoc(doc);
		/*getTfsFordoc sert à obtenir le nombre d'occurence 
		de tous les mots inclus dans le document "55"*/
		/* cette methode m'a fournis une hmap contenant les
		mots inclus(valeur) et leur occurences(clefs) */ 

		// afficher l'enssemble des mots inclus dans le doc et leur occurence
		// afficher la map : voici le code pour afficher une map

				for (HashMap.Entry<String, Integer> entry : hasmap.entrySet()){
   				    System.out.println(entry.getKey());		// occurence des mot inclus
 				    System.out.println(entry.getValue()); // mot inclus
				}


				/* Affiche l’ensemble des documents qui contiennent 
				le mot “attempt” son occurrence dans chaque document*/
		HashMap<String,Integer> hasmap2=indexconstruit.getTfsForStem("attempt");

		 // affichage de la deuxieme hmap avec les doc contenant le mot et
			// le nombre d'ocuurrence de ce mot dans le doc
		for (HashMap.Entry<String, Integer> entry : hasmap2.entrySet()){
   				  System.out.println(entry.getKey());   // occurence du mot attempt dans le doc
 				  System.out.println(entry.getValue()); // doc
				}

	}
}


/* question 5
  
 initalisation d'une hmap: public HashMap<Integer,String> map = new HashMap<Integer,String>();

 exemple d'insertion:

      Integer i2 = new Integer(1);
      
      HashMap<Integer, String> hm = new HashMap<>();
      hm.put(i1, "toto");
      hm.put(i2, "titi");

 - parcour:for (HashMap.Entry<String, Integer> entry : hasmap.entrySet()){
   				  entry.getKey();		
 				  entry.getValue();
 
 méthode associé:
containsKey(Object key)
Retourne true si l'objet passé en paramètre correspond à une clé de la collection.

containsValue(Object value)
Idem que ci-dessus mais sur une valeur cette fois.

entrySet()
Retourne un objet de type Set<Map.Entry<K,V> représentant le contenu de la collection. Comme vu dans le premier chapitre de cette partie, ce type d'objet nous donne une vue du contenu de la collection et est tout indiqué pour la parcourir lorsque vous avez besoin des clés et des valeurs.

get(Object key)
Retourne la valeur associée à la clé passée en paramètre ou null si cette clé n'existe pas.

keySet()
Retourne un objet de type Set<K> représentant la liste des clés contenues dans la collection.

put(K key, V value)
Ajoute la clé et la valeur dans la collection en retournant la valeur insérée. Si la clé existe déjà, sa valeur sera écrasée par celle passée en paramètre de la méthode.

putAll(Map<? extends K,? extends V> m)
Ajoute le contenu de la collection en paramètre dans la collection appelante.

remove(Object key)
Supprime le couple clé-valeur associé à la clé passée en paramètre et retourne la valeur supprimée.

values()
Retourne une objet de type Collection<V> contenant toutes les valeurs de la collection.*/