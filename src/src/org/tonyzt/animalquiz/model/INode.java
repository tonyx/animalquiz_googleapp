package org.tonyzt.animalquiz.model;

import org.tonyzt.animalquiz.model.state.StateContext;

import javax.jdo.annotations.PersistenceCapable;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: ITA86691
 * Date: 13/12/11
 * Time: 16.13
 * To change this template use File | Settings | File Templates.
 */

//@PersistenceCapable
public interface INode {
    public String guess(StateContext sc);

    INode learn(Speaker speaker, Memoizer memoizer);

    String getAnimal();
    
    public INode getSubByYesNo(Speaker speaker, String yesNo);

}
