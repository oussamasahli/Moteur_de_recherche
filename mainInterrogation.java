
import java.util.HashMap;
import core.Document;
import indexation.Index;
import indexation.Parser;
import indexation.Parser1;
import indexation.ParserCISI;
import indexation.Stemmer;
import indexation.TextRepresenter;  

public class mainInterrogation {

public static void main ( String [] args) {

	 // initialise l’index
 	 Index index=Index.deserialize ( " cisi " ) ;
	 String query = "young boy" ;

  IRModel bool = new Boolean (index);
  HashMap<String,Integer> liste = bool.getdocrequete(query);

  IRModel vect = new VectorielCartesien  (index);
  HashMap<String,Integer> liste2= vect.listedoctrier(query);

  evalation fmes = new Fmesure(liste,query);
    int eval;
    eval=Fmesure.fmesure(10,liste2);
 
  evalation prec = new Precsion(liste,query);
  eval= Precision.precision(10,liste2);

  evaluation rap= new Rappel(liste,query);
  eval= Rappel.rappel(10,liste2);


 }
}