package models;
import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
/**
 * Container class for results from a search+filter
 */

@Entity
public class SearchResult extends Model {
    
	@Id
	public int id;
	public String brand;
	public double size;
	public String organic;
	@Constraints.Required
    public double price;
    public double unitPrice;
    public double weight;
	public int rating;
	@Constraints.Required
	public String name;
	public String location;
    
    // this is the price for one unit of the good, in dollars. The weight is the
    // normal weight in kilograms that the good is sold in. The total price is
    // therefore weight*unitPrice
    // TODO maybe add some kind of class hierarchy for these objects?
    // public double unitPrice;
    // public double weight;
    
    public SearchResult(int id, String name, double unitPrice, double weight,
            String brand, double price, String organic, String location,
            int rating){
		this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.weight = weight;
		this.brand = brand;
		this.size = size;
		this.organic = organic;
		this.location = location;
		this.rating = rating;
    }
    
    public String toString(){
        return name + " for " + this.price;
    }
}