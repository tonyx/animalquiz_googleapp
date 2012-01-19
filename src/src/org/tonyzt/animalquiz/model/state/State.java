package org.tonyzt.animalquiz.model.state;

import org.tonyzt.animalquiz.model.Memoizer;

/**
 * Created by IntelliJ IDEA.
 * User: Tonino
 * Date: 09/12/11
 * Time: 2.18
 * To change this template use File | Settings | File Templates.
 *
 */
public interface State  {
    public String interact(StateContext sc, Memoizer memoizer, String answer);
}
