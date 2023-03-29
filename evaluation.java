
import java.util.HashMap;
import core.Document;
import indexation.Index;
import indexation.Parser;
import indexation.Parser1;
import indexation.ParserCISI;
import indexation.Stemmer;
import indexation.TextRepresenter;  

public class evaluation {

	private HashMap<String,Integer> listedocAttendu;
	private String query;
	
 	public precision (HashMap<String,Integer>listedocAttendu, String query){
 		this.listedocAttendu=listedocAttendu;
 		this.query=query;
 	}
 }