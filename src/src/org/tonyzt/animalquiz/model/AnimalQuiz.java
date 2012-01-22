package org.tonyzt.animalquiz.model;

import org.tonyzt.animalquiz.repository.GEngineRepository;
import org.tonyzt.animalquiz.repository.Repository;
//import org.tonyzt.animalquiz.view.StateViewContext;
import org.tonyzt.animalquiz.model.state.StateContext;
import org.tonyzt.animalquiz.view.speakers.DefaultEnglishTextSpeaker;
import org.tonyzt.animalquiz.view.speakers.HtmlSpeakerWithResetAndSaveButton;



import java.io.Serializable;
import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: Tonino
 * Date: 09/12/11
 * Time: 2.15
 * To change this template use File | Settings | File Templates.
 */
public class AnimalQuiz implements Serializable,IAnimalQuiz {
    private static final Logger log = Logger.getLogger(AnimalQuiz.class.getName());

    private Repository repository;

    private static final long serialVersionUID = 2773364923500997535L;
    String lastStepOutputMemory;
    StateContext stateContext;

    INode knowledge;
    INode currentNode;

    public static IAnimalQuiz getProductionAnimalQuiz() {
        return new AnimalQuiz(new HtmlSpeakerWithResetAndSaveButton(new DefaultEnglishTextSpeaker()), new Memoizer(), new GEngineRepository());
    }

    public static IAnimalQuiz getUnitTestableAnimalQuiz() {
        return new AnimalQuiz(new DefaultEnglishTextSpeaker(), new Memoizer(), new FakeRepository(new LeafNode("elephant")));
    }

    private AnimalQuiz(Speaker speaker, Memoizer memoizer,Repository repository) {
        this.repository=repository;
        knowledge = loadDefaultNode();
        currentNode=knowledge;
        stateContext = new StateContext(this, speaker,memoizer);
    }

    @Override
    public INode getCurrentNode() {
        return currentNode;
    }

    @Override
    public void storeKnowledgeTree(INode node) {
        saveNode(node);
    }

    @Override
    public void loadKnowledgeTree(INode currentNode) {
    }

    @Override
    public void removeKnowledge() {
        repository.resetMemory();
    }

    @Override
    public void setCurrentNode(INode node) {
        this.currentNode=node;
    }

    @Override
    public INode getKnowledge() {
        return knowledge;
    }

    @Override
    public void setKnowledge(INode node)  {
        this.knowledge=node;
    }

    @Override
    public String getLastStepOutputMemory() {
        return lastStepOutputMemory;
    }


    @Override
    public String step(String answer) {
        if (answer==null) answer = "";
        this.lastStepOutputMemory = stateContext.interact(answer);
        return lastStepOutputMemory;
    }


    @Override
    public void adjustCurrentNode(String answer) {
        INode node = stateContext.getAnimalQuiz().getCurrentNode().getSubByYesNo(stateContext.getSpeaker(),answer);
        stateContext.getAnimalQuiz().setCurrentNode(node);
    }


    private INode loadDefaultNode() {
        return this.repository.loadNode();
    }

    private void saveNode(INode node) {
        this.repository.storeRootNode(node);

    }


}





