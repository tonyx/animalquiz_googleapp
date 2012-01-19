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
public class ReadyToStart implements State,Serializable {
    private static final Logger log = Logger.getLogger(ReadyToStart.class.getName());
    private static final long serialVersionUID = -4990622512621843197L;

    @Override
    public String interact(StateContext sc, Memoizer memoizer, String answer) {
        log.info("interact");
        sc.setState(new Guessing());
        sc.resetMemoizer();
        return sc.getSpeaker().askToThinkAboutAnAnimal();
    }
}
