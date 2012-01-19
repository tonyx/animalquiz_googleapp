package org.tonyzt.animalquiz.view.stateViews;

import org.tonyzt.animalquiz.model.IAnimalQuiz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Tonino
 * Date: 25/12/11
 * Time: 18.34
 * To change this template use File | Settings | File Templates.
 */
public interface StateView {
    public void doAction(IAnimalQuiz animalQuiz,HttpServletRequest request, HttpServletResponse response) throws IOException;
}
