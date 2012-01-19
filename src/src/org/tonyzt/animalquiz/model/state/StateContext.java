package org.tonyzt.animalquiz.model.state;

import org.tonyzt.animalquiz.model.IAnimalQuiz;
import org.tonyzt.animalquiz.model.Memoizer;
import org.tonyzt.animalquiz.model.Speaker;
import org.tonyzt.animalquiz.view.speakers.DefaultEnglishTextSpeaker;

import java.io.Serializable;
import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: Tonino
 * Date: 09/12/11
 * Time: 2.19
 * To change this template use File | Settings | File Templates.
 */
public class StateContext implements Serializable {
    private static final Logger log = Logger.getLogger(StateContext.class.getName());
    private static final long serialVersionUID = 1414065507773916818L;

    private IAnimalQuiz animalQuiz;
    private State state;
    private Speaker speaker;
    private Memoizer memoizer;

    public StateContext(IAnimalQuiz animalQuiz, Speaker speaker) {
        this.animalQuiz= animalQuiz;
        this.state = new ReadyToStart();
        this.speaker=speaker;
        this.memoizer=new Memoizer();
    }

    public StateContext(IAnimalQuiz animalQuiz) {
        this(animalQuiz,new DefaultEnglishTextSpeaker());
    }

    public StateContext(IAnimalQuiz animalQuiz, Speaker speaker, Memoizer memoizer) {
        this(animalQuiz,speaker);
        this.memoizer = memoizer;
    }


    public void resetMemoizer() {
        this.memoizer.reset();
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setState(State state) {
        log.info("setting state "+state.getClass().getName());
        this.state = state;
    }
    
    public String getCurrentAnimal() {
        return getAnimalQuiz().getCurrentNode().getAnimal();
    }

    public IAnimalQuiz getAnimalQuiz() {
        return animalQuiz;
    }

    public String interact(String input) {
        return state.interact(this,memoizer,input);
    }
}

