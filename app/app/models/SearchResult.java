package models;
import play.db.ebean.Model;


import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Container class for results from a search+filter
 */

@Entity
public class SearchResult extends Model {
    
	@Id
    public String name;
    
    public SearchResult(String name){
        this.name = name;
    }
    
    public String toString(){
        return name;
    }
}