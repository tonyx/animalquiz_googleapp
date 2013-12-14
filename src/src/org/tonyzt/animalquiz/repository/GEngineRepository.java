package org.tonyzt.animalquiz.repository;

import com.google.appengine.api.datastore.*;
import org.tonyzt.animalquiz.model.INode;
import org.tonyzt.animalquiz.model.LeafNode;
import org.tonyzt.animalquiz.utils.Base64Coder;

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: Tonino
 * Date: 05/01/12
 * Time: 22.54
 * To change this template use File | Settings | File Templates.
 */
public class GEngineRepository implements Repository,Serializable {
    private static final long serialVersionUID = 6926679376060948197L;

    @Override
    public INode loadNode() {
        try {
            DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
            Query q = new Query("StoredKnowledge");
            PreparedQuery pq = ds.prepare(q);
            for (Entity result : pq.asIterable()) {
                INode node = (INode) Base64Coder.fromString((((Text) result.getProperty("encodedNode"))).getValue());
                System.out.println("Loaded node: "+node);
                return node;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        catch (ClassNotFoundException ce) {
            throw new RuntimeException(ce);
        }
        System.out.print("there are no nodes in the repository, returning the default");
        return new LeafNode("elephant");
    }


    private void removeKnowledge() {
        DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
        Query q = new Query("StoredKnowledge");
        PreparedQuery pq = ds.prepare(q);
        for (Entity result : pq.asIterable()) {
            Key key = result.getKey();
            ds.delete(key);
        }
    }


    @Override
    public void storeRootNode(INode node) {
        removeKnowledge();
        try {
            DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
            Entity localEntity = new Entity("StoredKnowledge");
            localEntity.setProperty("encodedNode",new Text(Base64Coder.toString((Serializable)node)));
            localEntity.setProperty("name","anyName");
            ds.put(localEntity);

//            // todo added this was in experimenting the pojo way in storing object

//            System.out.println("storing");
//            PersistenceManager pm = PMF.get().getPersistenceManager();
//            pm.currentTransaction().begin();
//            try {
//                pm.makePersistent(node);
//                pm.currentTransaction().commit();
//            }
//            finally {
//                if (pm.currentTransaction().isActive()) {
//                    pm.currentTransaction().rollback();
//                }
//            }
//            pm.close();


        } catch (IOException ie) {
            System.out.println(ie);
        }
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void resetMemory() {
        removeKnowledge();
    }
}

//    public void addUser(String userName) {
//        PersistenceManager pm = getPersistenceManagerInstance();
//        Key userKey = KeyFactory.createKey(User.class.getSimpleName(),userName);
//
//        pm.currentTransaction().begin();
//        try {
//            pm.getObjectById(User.class,userKey);
//        } catch (JDOObjectNotFoundException e)  {
//            User user = new User(userName,userKey);
//            pm.makePersistent(user);
//            pm.currentTransaction().commit();
//        }
//        finally {
//            if (pm.currentTransaction().isActive()) {
//                pm.currentTransaction().rollback();
//            }
//        }
//        pm.close();
//    }
