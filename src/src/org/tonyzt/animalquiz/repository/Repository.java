package org.tonyzt.animalquiz.repository;

import org.tonyzt.animalquiz.model.INode;

/**
 * Created by IntelliJ IDEA.
 * User: Tonino
 * Date: 05/01/12
 * Time: 22.53
 * To change this template use File | Settings | File Templates.
 */
public interface Repository {
     INode loadNode();
     void storeRootNode(INode node);
    void resetMemory();
}
