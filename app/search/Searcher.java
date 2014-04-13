package search;

import java.util.List;
import java.util.Arrays;

import play.db.ebean.Model;
import models.SearchResult;

/**
 * Utility class for performing a database search.
 */
public class Searcher {
    
    // TODO how do we want to pass filters and sort specifications?
	// for now only allow one filter at a time.
    public static List<SearchResult> performSearch(String searchQuery, String filterType, String filterValue, String sortMethod){
		
        // better output: retrieve some elements from a database
        //Finder(primary key class, object class)
		if(filterType.equals("") || filterValue.equals("") ){
			return new Model.Finder(Integer.class, SearchResult.class)
				.query().where().contains("name", searchQuery).orderBy(sortMethod).findList();
		} else {
			return new Model.Finder(Integer.class, SearchResult.class)
				.query().where().contains("name", searchQuery).where().eq(filterType, filterValue).orderBy(sortMethod).findList();
		}
		
		// example:
        //return new Model.Finder(Integer.class, SearchResult.class).query().orderBy("price desc").where().eq("organic", "organic").findList();
    }
}
