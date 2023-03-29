import core.Document;
import indexation.Index;
import indexation.Parser;
import indexation.Parser1;
import indexation.ParserCISI;
import indexation.Stemmer;
import indexation.TextRepresenter;

public abstract class Weighter{

	private Index index;
	public WeighterTF (Index index){
		this.index=index;
	}
public abstract  double frequence(Document doc,String motdudoc);
}