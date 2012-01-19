package org.tonyzt.animalquiz.controller;

import org.tonyzt.animalquiz.model.AnimalQuiz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by IntelliJ IDEA.
 * User: Tonino
 * Date: 25/12/11
 * Time: 17.58
 * To change this template use File | Settings | File Templates.
 */
public class DispatchingStep {
    private Condition condition;
    private Action action;
    public DispatchingStep(Condition condition, Action action) {
        this.condition=condition;
        this.action=action;
    }
    public void doAction(AnimalQuiz animalQuiz,HttpServletRequest request, HttpServletResponse response) {
        if (condition.condition(request,response,animalQuiz)) action.doAction(animalQuiz,request,response);
    }
}
