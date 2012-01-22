package org.tonyzt.animalquiz.controller;

import org.tonyzt.animalquiz.repository.GEngineRepository;
import org.tonyzt.animalquiz.view.stateViews.StateView;
import org.tonyzt.animalquiz.view.speakers.DefaultEnglishTextSpeaker;
import org.tonyzt.animalquiz.view.speakers.HtmlSpeakerWithResetAndSaveButton;
import org.tonyzt.animalquiz.model.AnimalQuiz;
import org.tonyzt.animalquiz.model.IAnimalQuiz;
import org.tonyzt.animalquiz.model.Memoizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Tonino
 * Date: 25/12/11
 * Time: 16.10
 * To change this template use File | Settings | File Templates.
 */
public class Dispatcher  {
    private static Dispatcher instance = null;

    private Dispatcher() {
    }

    public static synchronized Dispatcher getInstance() {
        if (instance==null) {
            instance = new Dispatcher();
        }
        return instance;
    }

    // ok I surrender: put here all the control based behavior
    public void doAction(HttpServletRequest request, HttpServletResponse response, IAnimalQuiz animalQuiz)  throws IOException {
        if (animalQuiz==null) {
            animalQuiz = AnimalQuiz.getProductionAnimalQuiz();
            request.getSession().setAttribute("animalQuizInstance",animalQuiz);
        }

        String savePar = request.getParameter("save");
        if (savePar!=null) {
            animalQuiz.storeKnowledgeTree(animalQuiz.getKnowledge());
            response.getWriter().print(animalQuiz.getLastStepOutputMemory());
            return;
        }

        String deletePar = request.getParameter("delete");
        if (deletePar!=null) {
            animalQuiz.removeKnowledge();
            response.getWriter().print(animalQuiz.getLastStepOutputMemory());
            return;
        }

        String loadPar = request.getParameter("load");
        if (loadPar!=null) {
            animalQuiz.loadKnowledgeTree(animalQuiz.getCurrentNode()); // fake
            response.getWriter().print(animalQuiz.getLastStepOutputMemory());
            return;
        }

        String resetPar = request.getParameter("reset");
        if (resetPar!=null) {
            animalQuiz = AnimalQuiz.getProductionAnimalQuiz();
            request.getSession().setAttribute("animalQuizInstance",animalQuiz);
        }

        String par = request.getParameter("interaction");
        response.getWriter().print(animalQuiz.step(par));
        request.getSession().setAttribute("animalQuizInstance",animalQuiz);

        //animalQuiz.getStateViewContext().doAction(animalQuiz,request,response);
        // debug
        response.getWriter().print("you can contribute to select the next features for this " +
                "game voting the user stories <a href =\"https://trello.com/board/animalquiz/4eb509e38f42f468e70846c8\"> here</a><br/>");

        response.getWriter().print("for any questions send an email to \"tonyx1(at)gmail.com\"");

        response.getWriter().print("For more info about the problem google \"kata animal quiz\", or take a look here: <a href = \"http://www.rubyquiz.com/quiz15.html\">http://www.rubyquiz.com/quiz15.html</a><br/>");

        response.getWriter().print("The project is in java and is done using test driven development, it is a variant of the code that can be found here: <a href = \"https://github.com/tonyx/newanimalquiz\"> https://github.com/tonyx/newanimalquiz</a><br/>");
        response.getWriter().print("Please note that there is no undo or rollback.  I can just restart the knowledge based from scratch if someone will mess it up! ;-) <br/>");
    }
}
