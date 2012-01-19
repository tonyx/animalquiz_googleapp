package org.tonyzt.animalquiz.controller;

import org.tonyzt.animalquiz.model.IAnimalQuiz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by IntelliJ IDEA.
 * User: Tonino
 * Date: 25/12/11
 * Time: 18.00
 * To change this template use File | Settings | File Templates.
 */
public interface Condition {
     boolean condition(HttpServletRequest request, HttpServletResponse response,IAnimalQuiz animalQuiz);
}
