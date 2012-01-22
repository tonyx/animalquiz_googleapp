package org.tonyzt.animalquiz.view.speakers;

import org.tonyzt.animalquiz.model.Speaker;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: ITA86691
 * Date: 13/12/11
 * Time: 17.19
 * To change this template use File | Settings | File Templates.
 */
public class DefaultEnglishTextSpeaker implements Speaker,Serializable {

    private static final long serialVersionUID = -8652847933783387039L;

    @Override
    public String askYesOrNot() {
        return "Please enter 'yes' or 'not'";
    }

    @Override
    public String sayThankYou() {
        return "Thank you";
    }

    @Override
    public boolean isNo(String answer) {
        return "no".equalsIgnoreCase(answer);
    }

    @Override
    public boolean isYes(String answer) {
        return "yes".equalsIgnoreCase(answer);
    }

    @Override
    public String getYes() {
        return "yes";
    }

    @Override
    public String getNo() {
        return "no";
    }

    @Override
    public void forgetAll() {
    }

    @Override
    public String askToThinkAboutAnAnimal() {
        return "Think about an animal";
    }

    @Override
    public String askWhatAnimalWas() {
        return "can you tell me what animal was (in english language)?";

    }

    @Override
    public String sayYeah() {
        return "yeah!";
    }

    @Override
    public String askDiscriminatingQuestion(String learningAnimal, String animal) {
        return "write, in english language, a question that can be used to distinguish a "+learningAnimal+" from a "+animal+"?";

    }


    @Override
    public String askAnswerToDiscriminatingQuestion(String question, String newAnimal, String animal) {
        return "What should be the answer to the question \""+question+"\" to distinguish a "+newAnimal+" compared to a "+animal+"?";

    }

    @Override
    public boolean isNotYesOrNot(String answer) {
        return !(isNo(answer) || isYes(answer));//        return !"no".equalsIgnoreCase(answer)&&!"yes".equalsIgnoreCase(answer);
    }

    @Override
    public String isIt(String animal) {
        return "is it a "+animal+"?";

    }

    @Override
    public String askBinaryQuestion(String question) {
        return question;
    }
}
