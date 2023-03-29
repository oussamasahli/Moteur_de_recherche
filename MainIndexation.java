
import java.util.HashMap;
import core.Document;
import indexation.Index;
import indexation.Parser;
import indexation.Parser1;
import indexation.ParserCISI;
import indexation.Stemmer;
import indexation.TextRepresenter;  

//question 1
/*.1) Dans la classe document j'utilise la méthode getText()
qui retourne le text d'un document

.2)voir schéma hiérarchie

.3)la méthode getTfsFordoc sert à obtenir la liste de mot
 inclus dans un document , avec  pour chacun leur nombre d'occurence dans 
 le doc.
 la méthode getTfsForStem sert à obtenir le nombre d'occurence d'un mot 
pour chaque fichier où il est inclus. ( liste de documents contenant le 
mot )
 
*/

//qustion 2
public class MainIndexation {
	public static void main(String[]args){

		//je cré un index a partir dun parser et dun stemer

		ParserCISI p= new ParserCISI();
		Stemmer s= new Stemmer();
		Index index= new Index("index",p,i);

		index.index(CISI) // génère une un index pour la collection de 
		//documents CISI

	}
}

/* question 3

la méthode static Index	deserialize(java.lang.String fileName) est une 
méthode static. on peut donc l'utiliser sans avoir besoin de créer
un objet de la classe Index. Cette méthode nous évite donc de créer
un objet de type index, et elle nous permet de gagner du temps.




