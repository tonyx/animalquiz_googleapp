package trashssssss;


import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Text;
//import static com.google.appengine.api.datastore;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: Tonino
 * Date: 27/12/11
 * Time: 12.18
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class StoredKnowledge implements Serializable {
    private static final long serialVersionUID = -7067171569476203586L;
    private static DatastoreService ds = DatastoreServiceFactory.getDatastoreService();

    private Text encodedNode;

    @Id
    private String name;
    public String getName() {
        return "theOnlyOne";
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setEncodedNode(Text encodeNode) {
        this.encodedNode=encodedNode;
    }

    public Text getEncodedNode() {
        return encodedNode;
    }
}
