import play.*;
import play.libs.*;
import com.avaje.ebean.Ebean;
import models.*;
import java.util.*;

public class Global extends GlobalSettings {

    @Override
    public void onStart(Application app) {
        // Check if the database is empty
		// TODO use mysql, not ebean. or something.
        if (new SearchResult.Finder(String.class, SearchResult.class).findRowCount() == 0) {
			Ebean.save(Arrays.asList(
                new SearchResult(1, "Publix 8oz canned Garbanzo Beans", 0.5, 8.0, "Publix", 4.0, "not", "here", 2),
                new SearchResult(2, "Public 16oz canned Garbanzo Beans", 0.6, 16.0, "Publix", 9.6, "not", "here", 5),
                new SearchResult(3, "Bush's 8oz canned Chickpeas", 0.7, 8.0, "Bush", 5.6, "not", "there", 1),
                new SearchResult(4, "Bush's 168oz canned Chickpeas", 0.8, 16.0, "Bush", 12.8, "not", "there", 7),
                new SearchResult(5, "Publix 8oz organic canned Garbanzo Beans", 0.9, 8.0, "Publix", 7.2, "organic", "here", 3),
                new SearchResult(6, "Goya 8oz organic canned Chickpeas", .95, 8.0, "Goya", 7.6, "organic", "nowhere", 2)
            ));
        }
    }
}