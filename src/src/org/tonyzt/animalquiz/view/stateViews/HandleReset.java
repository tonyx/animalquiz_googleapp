package org.tonyzt.animalquiz.view.stateViews;

import org.tonyzt.animalquiz.repository.GEngineRepository;
import org.tonyzt.animalquiz.view.speakers.DefaultEnglishTextSpeaker;
import org.tonyzt.animalquiz.view.speakers.HtmlSpeakerWithResetAndSaveButton;
import org.tonyzt.animalquiz.model.AnimalQuiz;
import org.tonyzt.animalquiz.model.IAnimalQuiz;
import org.tonyzt.animalquiz.model.Memoizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: Tonino
 * Date: 25/12/11
 * Time: 18.51
 * To change this template use File | Settings | File Templates.
 */
public class HandleReset implements StateView,Serializable {
    private static final long serialVersionUID = 5567304544208834709L;
    @Override
    public void doAction(IAnimalQuiz animalQuiz, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getParameter("reset")!=null||animalQuiz==null) {
            animalQuiz = AnimalQuiz.getProductionAnimalQuiz();
            request.getSession().setAttribute("animalQuizInstance",animalQuiz);
        }
        
        String par = request.getParameter("interaction");
        response.getWriter().print(animalQuiz.step(par));
        request.getSession().setAttribute("animalQuizInstance",animalQuiz);
    }
}
