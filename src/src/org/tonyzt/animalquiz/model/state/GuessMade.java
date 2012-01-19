package org.tonyzt.animalquiz.model.state;

import org.tonyzt.animalquiz.model.Memoizer;

import java.io.Serializable;
import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: Tonino
 * Date: 09/12/11
 * Time: 2.20
 * To change this template use File | Settings | File Templates.
 */
public class GuessMade implements State,Serializable {
    private static final Logger log = Logger.getLogger(GuessMade.class.getName());
    private static final long serialVersionUID = -6409000320151791114L;

    @Override
    public String interact(StateContext sc, Memoizer memoizer, String answer) {
        log.info("interacting "+answer);
        if (sc.getSpeaker().isNo(answer)) {
            sc.setState(new Learning());
            return sc.getSpeaker().askWhatAnimalWas();
        }
        else if (sc.getSpeaker().isYes(answer)) {
            sc.setState(new ReadyToStart());
            sc.getAnimalQuiz().setCurrentNode(sc.getAnimalQuiz().getKnowledge());
            return sc.getSpeaker().sayYeah();
        }
        else return sc.getSpeaker().askYesOrNot();
    }
}
