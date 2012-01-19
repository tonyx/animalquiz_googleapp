package org.tonyzt.animalquiz.model.state;

import org.tonyzt.animalquiz.model.Memoizer;

import java.io.Serializable;
import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: Tonino
 * Date: 09/12/11
 * Time: 2.18
 * To change this template use File | Settings | File Templates.
 */
public class Guessing implements State,Serializable {
    private static final Logger log = Logger.getLogger(Guessing.class.getName());
    private static final long serialVersionUID = -6444834966006051318L;

    @Override
    public String interact(StateContext sc, Memoizer memoizer, String answer) {
        log.info("interacting, answer "+answer);
        
        sc.getAnimalQuiz().adjustCurrentNode(answer);
        memoizer.addYesNo(sc.getSpeaker(),answer);
        return sc.getAnimalQuiz().getCurrentNode().guess(sc);
    }
}
