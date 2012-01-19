package org.tonyzt.animalquiz.model;

import org.tonyzt.animalquiz.view.StateViewContext;

/**
 * Created by IntelliJ IDEA.
 * User: Tonino
 * Date: 23/12/11
 * Time: 15.10
 * To change this template use File | Settings | File Templates.
 */
public interface IAnimalQuiz {

    INode getCurrentNode();

    void setCurrentNode(INode node);

    INode getKnowledge();

    void setKnowledge(INode node);

    String getLastStepOutputMemory();

    String step(String answer);

    void adjustCurrentNode(String answer);
    
    public StateViewContext getStateViewContext();

    void storeKnowledgeTree(INode node);

    void loadKnowledgeTree(INode currentNode);

    void removeKnowledge();
}
