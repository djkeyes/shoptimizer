package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.data.Form;

import search.Searcher;
import models.SearchResult;

public class MainController extends Controller {
    
    // call toget the start page
    public static Result index() {
        return ok(views.html.index.render("Hello from Java."));
    }
    
    // call to perform a search
    // the result is a rendered list of database entries, plus the start page
    public static Result doSearch(){
        String groceries = Searcher.performSearch("", "", "").toString();
        
        return ok(views.html.index.render("Here's a list of groceries: " + groceries));
    }
	
    // call to get the add-a-product page
    public static Result addProductPage() {
		return ok(views.html.add.render(""));
	}
    
    // perform an http post to add a product, and redirect to add-a-product page
    public static Result addProduct() {
		// add one new item
		Form<SearchResult> itemForm = Form.form(SearchResult.class);
		SearchResult added = itemForm.bindFromRequest().get();
		added.save();
		
		// now return the rendered list
		return ok(views.html.add.render(Searcher.performSearch("", "", "").toString()));
	}
    
}
