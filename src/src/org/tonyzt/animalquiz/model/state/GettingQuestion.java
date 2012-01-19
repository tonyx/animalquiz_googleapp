package org.tonyzt.animalquiz.model.state;

import org.tonyzt.animalquiz.model.Memoizer;

import java.io.Serializable;
import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: Tonino
 * Date: 11/12/11
 * Time: 16.06
 * To change this template use File | Settings | File Templates.
 */
public class GettingQuestion implements State, Serializable {
    private static final Logger log = Logger.getLogger(Guessing.class.getName());
    private static final long serialVersionUID = 8496172063992308933L;

    @Override
    public String interact(StateContext sc, Memoizer memoizer, String question) {
        log.info("interacting "+question);
        memoizer.setDiscriminatingQuestion(question);
        sc.setState(new EndingLearningSayThankYou());
        return sc.getSpeaker().askAnswerToDiscriminatingQuestion(question,memoizer.getLearningAnimal(),sc.getCurrentAnimal());
    }
}
