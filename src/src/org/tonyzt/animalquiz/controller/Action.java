package org.tonyzt.animalquiz.controller;

import org.tonyzt.animalquiz.model.AnimalQuiz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by IntelliJ IDEA.
 * User: Tonino
 * Date: 25/12/11
 * Time: 18.02
 * To change this template use File | Settings | File Templates.
 */
public interface Action {
    public void doAction(AnimalQuiz animalQuiz,HttpServletRequest request, HttpServletResponse response);
}
