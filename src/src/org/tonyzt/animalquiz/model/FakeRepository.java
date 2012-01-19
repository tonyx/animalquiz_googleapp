package org.tonyzt.animalquiz.model;

import org.tonyzt.animalquiz.model.INode;
import org.tonyzt.animalquiz.model.LeafNode;
import org.tonyzt.animalquiz.repository.Repository;

/**
 * Created by IntelliJ IDEA.
 * User: Tonino
 * Date: 06/01/12
 * Time: 2.11
 * To change this template use File | Settings | File Templates.
 */
public class FakeRepository implements Repository {
    private INode node;
    private INode defaultNode;

    public FakeRepository(INode defaultNode) {
        this.defaultNode=defaultNode;
    }
    @Override
    public INode loadNode() {
        if (node!=null)
            return node;
        return defaultNode;
    }

    @Override
    public void storeRootNode(INode node) {
        this.node = node;
    }

    @Override
    public void resetMemory() {
        this.node = new LeafNode("elephant");
    }
}
