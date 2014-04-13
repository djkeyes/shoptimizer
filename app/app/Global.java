import play.*;
import play.libs.*;
import com.avaje.ebean.Ebean;
import models.*;
import java.util.*;

public class Global extends GlobalSettings {

    @Override
    public void onStart(Application app) {
        // Check if the database is empty
        if (new SearchResult.Finder(String.class, SearchResult.class).findRowCount() == 0) {
			Ebean.save(Arrays.asList(
                new SearchResult("Publix 8oz canned Garbanzo Beans"),
                new SearchResult("Public 16oz canned Garbanzo Beans"),
                new SearchResult("Bush's 8oz canned Chickpeas"),
                new SearchResult("Bush's 168oz canned Chickpeas"),
                new SearchResult("Publix 8oz organic canned Garbanzo Beans"),
                new SearchResult("Goya 8oz organic canned Chickpeas")
            ));
        }
    }
}