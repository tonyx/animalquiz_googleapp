package org.tonyzt.animalquiz.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Tonino
 * Date: 14/12/11
 * Time: 23.55
 * To change this template use File | Settings | File Templates.
 */
public class Memoizer implements Serializable {
    private static final long serialVersionUID = 1226146859658684425L;
    private List<String> yesNoList;
    private String learningAnimal;
    private String answerToDiscriminatingQuestion;
    private String discriminatingQuestion;

    public void setDiscriminatingQuestion(String question) {
        this.discriminatingQuestion=question;
    }

    @Override
    public String toString() {
        return "Memoizer{" +
                "yesNoList=" + yesNoList +
                ", learningAnimal='" + learningAnimal + '\'' +
                ", answerToDiscriminatingQuestion='" + answerToDiscriminatingQuestion + '\'' +
                ", discriminatingQuestion='" + discriminatingQuestion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Memoizer)) return false;

        Memoizer memoizer = (Memoizer) o;

        if (answerToDiscriminatingQuestion != null ? !answerToDiscriminatingQuestion.equals(memoizer.answerToDiscriminatingQuestion) : memoizer.answerToDiscriminatingQuestion != null)
            return false;
        if (discriminatingQuestion != null ? !discriminatingQuestion.equals(memoizer.discriminatingQuestion) : memoizer.discriminatingQuestion != null)
            return false;
        if (learningAnimal != null ? !learningAnimal.equals(memoizer.learningAnimal) : memoizer.learningAnimal != null)
            return false;
        if (yesNoList != null ? !yesNoList.equals(memoizer.yesNoList) : memoizer.yesNoList != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = yesNoList != null ? yesNoList.hashCode() : 0;
        result = 31 * result + (learningAnimal != null ? learningAnimal.hashCode() : 0);
        result = 31 * result + (answerToDiscriminatingQuestion != null ? answerToDiscriminatingQuestion.hashCode() : 0);
        result = 31 * result + (discriminatingQuestion != null ? discriminatingQuestion.hashCode() : 0);
        return result;
    }

    public String getDiscriminatingQuestion() {
        return this.discriminatingQuestion;
    }


    public void setLearningAnimal(String animal) {
        this.learningAnimal=animal;
    }

    public String getLearningAnimal() {
        return this.learningAnimal;
    }

    public String getAnswerToDiscriminatingQuestion() {
        return answerToDiscriminatingQuestion;
    }

    public void setAnswerToDiscriminatingQuestion(String answerToDiscriminatingQuestion) {
        this.answerToDiscriminatingQuestion=answerToDiscriminatingQuestion;
    }

    public Memoizer() {
        this.yesNoList = new ArrayList<String>();
    }

    // wtf?! :D
    public void addYesNo(Speaker speaker, String yesNo) {
        if (!speaker.isNotYesOrNot(yesNo))
            yesNoList.add(yesNo);
    }
    
    public String consumeHead() {
        if (this.yesNoList.size()>0) {
            String head = this.yesNoList.get(0);
            yesNoList.remove(0);
            return head;
        } else {
            throw new RuntimeException("error in the length of the learning list ");
        }
    }
    
    public void reset() {
        this.yesNoList= new ArrayList<String>();
        this.discriminatingQuestion="";
        this.learningAnimal="";
        this.answerToDiscriminatingQuestion="";
    }
}
