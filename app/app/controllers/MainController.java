package controllers;

import play.mvc.Controller;
import play.mvc.Result;

import search.Searcher;
import models.SearchResult;

public class MainController extends Controller {
    
    public static Result index() {
		// first insert some groceries somehow
		SearchResult sr = new SearchResult("asdfasdfasdf");
		sr.save();
		
        return ok(views.html.index.render("Hello from Java."));
    }
    
    public static Result doSearch(){
        String groceries = Searcher.performSearch("", "", "").toString();
        
        return ok(views.html.index.render("Hello from Java. Groceries: " + groceries));
    }
    
}
