package org.tonyzt.animalquiz.model;
import org.tonyzt.animalquiz.model.state.GuessMade;
import org.tonyzt.animalquiz.model.state.StateContext;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: ITA86691
 * Date: 13/12/11
 * Time: 17.34
 * To change this template use File | Settings | File Templates.
 */
public class LeafNode implements INode, Serializable {

    private static final long serialVersionUID = 7619538467544476807L;

    String animal;
    
    public LeafNode(String animal) {
        this.animal=animal;
    }

    @Override
    public String guess(StateContext sc) {
        sc.setState(new GuessMade());
        return sc.getSpeaker().isIt(this.getAnimal());
    }

    @Override
    public INode learn(Speaker speaker, Memoizer memoizer) {
        if (speaker.isNo(memoizer.getAnswerToDiscriminatingQuestion()))
            return new NonLeafNode(new LeafNode(this.animal),memoizer.getDiscriminatingQuestion(),new LeafNode(memoizer.getLearningAnimal()));
        if (speaker.isYes(memoizer.getAnswerToDiscriminatingQuestion()))
            return new NonLeafNode(new LeafNode(memoizer.getLearningAnimal()),memoizer.getDiscriminatingQuestion(),new LeafNode(this.animal));
        throw new RuntimeException("parameter "+memoizer.getAnswerToDiscriminatingQuestion() + " is not valid. Expected "+speaker.getYes() +" or "+ speaker.getNo());
    }

    //@Override
    public String getAnimal() {
        return this.animal;
    }

    @Override
    public String toString() {
        return "LeafNode{" +
                "animal='" + animal + '\'' +
                '}';
    }

    @Override
    public INode getSubByYesNo(Speaker speaker, String yesNo) {
        return this;
    }
}
