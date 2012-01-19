package org.tonyzt.animalquiz.model.state;

import org.tonyzt.animalquiz.model.INode;
import org.tonyzt.animalquiz.model.Memoizer;

import java.io.Serializable;
import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: Tonino
 * Date: 11/12/11
 * Time: 19.16
 * To change this template use File | Settings | File Templates.
 */
public class EndingLearningSayThankYou implements State, Serializable {
    private static final Logger log = Logger.getLogger(EndingLearningSayThankYou.class.getName());
    private static final long serialVersionUID = 3777686673434776951L;

    @Override
    public String interact(StateContext sc, Memoizer memoizer, String answer) {
        log.info("interacting "+answer);
        if (sc.getSpeaker().isNotYesOrNot(answer)) {
            return sc.getSpeaker().askYesOrNot();
        }  else {
            memoizer.setAnswerToDiscriminatingQuestion(answer);
            INode newNode = sc.getAnimalQuiz().getKnowledge().learn(sc.getSpeaker(),memoizer);
            memoizer.reset();
            sc.getAnimalQuiz().setKnowledge(newNode);
            sc.getAnimalQuiz().setCurrentNode(newNode);
            sc.getAnimalQuiz().storeKnowledgeTree(newNode);
            sc.setState(new ReadyToStart());
            return sc.getSpeaker().sayThankYou();
        }
    }
}
