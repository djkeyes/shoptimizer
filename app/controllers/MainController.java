package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.data.Form;
import play.data.DynamicForm;

import search.Searcher;
import models.SearchResult;

import java.util.List;

public class MainController extends Controller {
    
    // call to get the start page
    public static Result index() {
		// TODO: render a pretty start page
        return ok(views.html.index.render("Hello from Java."));
    }
    
    // call to perform a search
	// this is performed via a POST request that routes to this method
	// TODO add some kind of validation perhaps?
    // the result is a rendered list of database entries, plus the start page
    public static Result doSearch(){
		// TODO: we should probably make a Model object, if we want to use good practice. maybe.
		DynamicForm requestData = Form.form().bindFromRequest();
		String queryString = requestData.get("query");
		String sortMethod = requestData.get("sortBy"); // I guess this can be a string
		// should this be group of radio buttons or something?
		String filters = requestData.get("filters"); // for now just supply a string specifying the type of filter
		
		// for now, hardcode:
		sortMethod = "name asc";
		filters = "";
		// these are returned in sorted order
		// TODO: maybe we should return several maps of item=>prices, item=>unitPrice, item=>rating, etc, and then dynamically sort them using javascript
        List<SearchResult> groceries = Searcher.performSearch(queryString, sortMethod, filters);
	
        return ok(views.html.index.render("Here's a list of groceries: " + groceries.toString() + ", " + sortMethod));
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
