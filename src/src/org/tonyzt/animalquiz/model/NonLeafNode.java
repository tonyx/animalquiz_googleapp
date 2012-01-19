package org.tonyzt.animalquiz.model;

import org.tonyzt.animalquiz.model.state.StateContext;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: ITA86691
 * Date: 13/12/11
 * Time: 17.35
 * To change this template use File | Settings | File Templates.
 */
public class NonLeafNode implements INode, Serializable {

    private static final long serialVersionUID = -2985931738045143040L;
    String question;
    INode  yesBranch,noBranch;
    public NonLeafNode(INode yesBranch,String question,INode noBranch ) {
        this.yesBranch=yesBranch;
        this.question=question;
        this.noBranch=noBranch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NonLeafNode)) return false;

        NonLeafNode node = (NonLeafNode) o;

        if (noBranch != null ? !noBranch.equals(node.noBranch) : node.noBranch != null) return false;
        if (question != null ? !question.equals(node.question) : node.question != null) return false;
        if (yesBranch != null ? !yesBranch.equals(node.yesBranch) : node.yesBranch != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = question != null ? question.hashCode() : 0;
        result = 31 * result + (yesBranch != null ? yesBranch.hashCode() : 0);
        result = 31 * result + (noBranch != null ? noBranch.hashCode() : 0);
        return result;
    }


    public INode getYesBranch() {
        return this.yesBranch;
    }

    //@Override
    public String getAnimal() {
        throw new RuntimeException("Internal error: the NonLeafNode does not store any animal");
    }

    @Override
    public INode getSubByYesNo(Speaker speaker, String yesNo) {
        if (speaker.isNo(yesNo)) {
            return this.getNoBranch();
        }
        if (speaker.isYes(yesNo)) {
            return this.getYesBranch();
        }
        return this;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public INode getNoBranch() {
        return this.noBranch;
    }

    @Override
    public String toString() {
        return "Node{" +
                ", question='" + question + '\'' +
                ", yesBranch=" + yesBranch +
                ", noBranch=" + noBranch +
       //         ", isLeaf=" + isLeaf +
                '}';
    }

    public String getQuestion() {
        return question;
    }

    public String guess(StateContext sc) {
        return sc.getSpeaker().askBinaryQuestion(this.getQuestion());
    }

    @Override
    public INode learn(Speaker speaker, Memoizer memoizer) {
        String head = memoizer.consumeHead();
        if (speaker.isNo(head))
              return new NonLeafNode(this.getYesBranch(),this.getQuestion(),this.getNoBranch().learn(speaker,memoizer));
        if (speaker.isYes(head))
              return new NonLeafNode(this.getYesBranch().learn(speaker,memoizer),this.getQuestion(),this.getNoBranch());
        return null;
    }

}
