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
    public static List<SearchResult> performSearch(String searchQuery, String filters, String sortMethod){
        // dummy output: always return the same list
        // return Arrays.asList(new SearchResult("Publix 8oz canned Garbanzo Beans"),
        //                      new SearchResult("Public 16oz canned Garbanzo Beans"),
        //                      new SearchResult("Bush's 8oz canned Chickpeas"),
        //                      new SearchResult("Goya 16oz organic canned Chickpeas"));
                             
                             
        // better output: retrieve some elements from a database
        //Finder(primary key class, object class)
        return new Model.Finder(Integer.class, SearchResult.class).query().orderBy("price desc").where().eq("organic", "organic").findList();
    }
}