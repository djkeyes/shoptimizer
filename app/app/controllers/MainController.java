package controllers;

import play.mvc.Controller;
import play.mvc.Result;

import search.Searcher;
import models.SearchResult;

public class MainController extends Controller {
    
    public static Result index() {
		
        return ok(views.html.index.render("Hello from Java."));
    }
    
    public static Result doSearch(){
        String groceries = Searcher.performSearch("", "", "").toString();
        
        return ok(views.html.index.render("Here's a list of groceries: " + groceries));
    }
	
	public static Result addProduct() {
		
		return null;
	}
    
}
