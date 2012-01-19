package org.tonyzt.animalquiz.model.state;

import org.tonyzt.animalquiz.model.Memoizer;

import java.io.Serializable;
import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: Tonino
 * Date: 11/12/11
 * Time: 15.31
 * To change this template use File | Settings | File Templates.
 */
public class Learning implements State, Serializable {
    private static final Logger log = Logger.getLogger(Learning.class.getName());
    private static final long serialVersionUID = -7928156881064911558L;

    @Override
    public String interact(StateContext sc, Memoizer memoizer, String learningAnimal) {
        log.info("learning "+learningAnimal);
        sc.setState(new GettingQuestion());
        memoizer.setLearningAnimal(learningAnimal);
        return sc.getSpeaker().askDiscriminatingQuestion(learningAnimal, sc.getAnimalQuiz().getCurrentNode().getAnimal());
    }
}
