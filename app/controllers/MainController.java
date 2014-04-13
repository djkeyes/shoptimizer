package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.data.Form;
import play.data.DynamicForm;

import search.Searcher;
import models.SearchResult;

import java.util.List;
import java.util.LinkedList;

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
		String queryString = requestData.get("food").toLowerCase();
		String whichSearch = requestData.get("Search").toLowerCase();
		String sortMethod = null, filterType = null, filterValue = null;
		if(whichSearch.toLowerCase().equals("SearchAgain".toLowerCase())){
			if(requestData.get("sorters").toLowerCase().equals("price")){
				sortMethod = "price asc";
			} else if(requestData.get("sorters").toLowerCase().equals("unit_price")){
				sortMethod = "unit_price asc";
			} else if(requestData.get("sorters").toLowerCase().equals("rating")){
				sortMethod = "rating asc";
			}
			
			filterType = "brand";
			filterValue = requestData.get("filters");// for now just supply a string specifying the type of filter
		} else {
			sortMethod = "price asc";
			filterType = "";
			filterValue = "";
		}
		filterType = "";
		filterValue = "";
		
		// these are returned in sorted order
		// TODO: maybe we should return several maps of item=>prices, item=>unitPrice, item=>rating, etc, and then dynamically sort them using javascript
        List<SearchResult> groceries = Searcher.performSearch(queryString, filterType, filterValue, sortMethod);
		String output= "";
		for(SearchResult sr : groceries){
			output += sr + "\n";
		}
		
		output +=  groceries.toString();
		
		// add suggestions based on fuzzy similarity to the search string
		String suggestions="";
	
        return ok(views.html.display.render(output, "Your file", suggestions));
    }
	
    // call to get the add-a-product page
    public static Result addProductPage() {
		return ok(views.html.add.render(""));
	}
    
    // perform an http post to add a product, and redirect to add-a-product page
    public static Result addProduct() {
		// add one new item
		//Form<SearchResult> itemForm = Form.form(SearchResult.class);
		//SearchResult added = itemForm.bindFromRequest().get();
		//added.save();
		
		
		// TODO: we should probably make a Model object, if we want to use good practice. maybe.
		DynamicForm requestData = Form.form().bindFromRequest();
		String queryString =""; //= requestData.get("query");
		String sortMethod;// = requestData.get("sortBy"); // I guess this can be a string
		// should this be group of radio buttons or something?
		String filterType;// = requestData.get("filters"); // for now just supply a string specifying the type of filter
		String filterValue;// = requestData.get("filters");
		
		// for now, hardcode:
		sortMethod = "unitPrice asc";
		filterType = "organic";
		filterValue = "not";
		// these are returned in sorted order
		// TODO: maybe we should return several maps of item=>prices, item=>unitPrice, item=>rating, etc, and then dynamically sort them using javascript
        List<SearchResult> groceries = Searcher.performSearch(queryString, filterType, filterValue, sortMethod);
		String output= "";
		for(SearchResult sr : groceries){
			output += sr + "|";
		}
		
		// now return the rendered list
		return ok(views.html.add.render(output));
	}    
}
