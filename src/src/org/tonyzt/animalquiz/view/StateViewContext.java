package org.tonyzt.animalquiz.view;

import org.tonyzt.animalquiz.model.IAnimalQuiz;
import org.tonyzt.animalquiz.view.stateViews.HandleReset;
import org.tonyzt.animalquiz.view.stateViews.StateView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: Tonino
 * Date: 25/12/11
 * Time: 18.34
 * To change this template use File | Settings | File Templates.
 */
public class StateViewContext implements Serializable {

    private static final long serialVersionUID = 6734394581429125656L;
    StateView currentStateview;
    public StateViewContext stateViewContext;
    public StateViewContext() {
        this.currentStateview = new HandleReset();
    }

    public void doAction(IAnimalQuiz animalQuiz,HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.currentStateview.doAction(animalQuiz,request,response);
    }
}
