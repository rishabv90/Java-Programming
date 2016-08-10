//package com.jen.test;
//Connection with the Apache Jenna for SparQL with java.

//Rishab Verma
//21st July 2016
//Assignment while working as an intern for Boston Analytics.


import com.hp.hpl.jena.query.ARQ; 
import com.hp.hpl.jena.query.Query; 
import com.hp.hpl.jena.query.QueryExecution; 
import com.hp.hpl.jena.query.QueryExecutionFactory; 
import com.hp.hpl.jena.query.QueryFactory; 
import com.hp.hpl.jena.query.QuerySolution; 
import com.hp.hpl.jena.query.ResultSet; 
 
public class JenaDbpedia { 
 
    public static void main(String[] args) { 
 
    	JenaDbpedia queryDBpedia = new JenaDbpedia(); 
        queryDBpedia.queryExternalSources(); 
    } 
 
    public void queryExternalSources() { 
    /*   String sparqlQueryString2 = " SELECT ?abstract " + 
                                    " WHERE {{ " + 
                                         "   <http://dbpedia.org/resource/Sachin_Tendulkar> " + 
                                         "      <http://dbpedia.org/ontology/abstract> " + 
                                         "          ?abstract }}"; 
    	
    	String sparqlQueryString2 = "SELECT ?abstract"+
                "WHERE {"+
                "{"+ 
                "<http://dbpedia.org/resource/India> <http://dbpedia.org/ontology/abstract>?abstract"+
                "FILTER langMatches( lang(?abstract),'en')"+
                "}"+
                "}";
    	
    	String query1 = "SELECT    ?abstract"+
    	        " WHERE  {"+
    	        "{"+ 
    	        "<http://dbpedia.org/resource/GOOGLE> <http://dbpedia.org/ontology/abstract> ?abstract."+
    	        
    	        "FILTER langMatches( lang(?abstract),  'EN')"+
    	        // "FILTER langMatches( lang(?birthDate),  'EN')"+
    	        "}"+
    	        "}";
    	   */
    	
  /*String query1="PREFIX dbprop:<http://dbpedia.org/property/>\n "+
    	        "PREFIX dc: <http://dbpedia.org/resource/> \n"+
    		     "PREFIX dbpedia: <http://dbpedia.org/>  \n   "+
    		     "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> \n"+
    		     "PREFIX owl: <http://www.w3.org/2002/07/owl#> \n"+
    		      "PREFIX x: <http://dbpedia.org/ontology/abstract> \n"+
    		     "SELECT DISTINCT ?abstract ?secCik ?subsid  WHERE{{?S <http://dbpedia.org/ontology/abstract> ?abstract.?S dbprop:subsid 
    		     ?subsid.?S dbprop:subsid ?subsid.?S dbprop:secCik ?secCik.FILTER( xsd:integer(?secCik)=1288776).FILTER 
    		     langMatches( lang(?abstract),'EN')}}";
    	*/
    	
    	String query1 =  "SELECT ?abstract WHERE { { <http://dbpedia.org/resource/Ronaldo> <http://dbpedia.org/ontology/abstract> ?abstract } }";    	
    	System.out.println(query1+"\n");
  /*  String dbo=" <http://dbpedia.org/ontology/>";
    	String query1="SELECT ?name ?birth ?death ?person  WHERE  {"+
     "?person <http://dbpedia.org/ontology/birthPlace :Berlin ."+
     "?person dbo:birthDate ?birth ."+
    " ?person foaf:name ?name ."+
     "?person dbo:deathDate ?death ."+
     "FILTER (?birth < '1900-01-01'^^xsd:date) ."+
"}";*/


        Query query = QueryFactory.create(query1); 
        ARQ.getContext().setTrue(ARQ.useSAX); 
        System.out.println("Search Start!!!");
         QueryExecution qexec = QueryExecutionFactory.sparqlService("http://DBpedia.org/sparql", query); 
        ResultSet results = qexec.execSelect(); 
              while (results.hasNext()) { 
            QuerySolution soln = results.nextSolution(); 
            
            System.out.println("\n");
            System.out.println(soln.get("?abstract"));  
            //System.out.println(soln.get("?secCik")); 
            System.out.println(soln.get("?subsid")); 
         
        } 
        System.out.println("\n\nSearch Over!!!");
        qexec.close(); 
 
    } 
 
}