//Connection with the Apache Jenna for SparQL with java.

//Rishab Verma
//21st July 2016
//Assignment while working as an intern for Boston Analytics.


import java.util.Iterator;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.sparql.engine.http.QueryExceptionHTTP;
import com.hp.hpl.jena.query.ResultSet;

public class Example {

	public static void main(String[] args) {
		
		
		//http request
		String website = "http://dbpedia.org/sparql";
		
		//whatever query we want to parse.
		String query =  "SELECT ?abstract WHERE { { <http://dbpedia.org/resource/Ronaldo> <http://dbpedia.org/ontology/abstract> ?abstract } }";                

		//query execution using the library object.
		QueryExecution queryEx = QueryExecutionFactory.sparqlService(website, query);
		
		
		try{
			//results coming from the executed queries.
			ResultSet results = queryEx.execSelect();
			
			//prints the output.
			for(; results.hasNext();){
				//typecast results from set to qsolution
				QuerySolution answer = (QuerySolution)results.next();
				
//				System.out.println(answer.get("?abstract"));			
				
			}
		}catch(Exception e){
			
			e.printStackTrace();
		}finally{
			queryEx.close();
		}
			
	}
		
		
		
}
		
		
		
						
						

