package org.tonyzt.animalquiz.view.speakers;

import org.tonyzt.animalquiz.model.Speaker;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: ITA86691
 * Date: 13/12/11
 * Time: 20.20
 * To change this template use File | Settings | File Templates.
 */
public class HtmlSpeaker extends SpeakerDecorator implements Serializable {
    private static final long serialVersionUID = -6386436605213346751L;

    public HtmlSpeaker(Speaker speaker) {
        super(speaker);
    }

    @Override
    public String askYesOrNot() {
        return htmlBody(withYesNoRadioButtons(speaker.askYesOrNot()));
    }

    @Override
    public String sayThankYou() {
        return htmlBody(withSubmitButton(speaker.sayThankYou()));
    }

    @Override
    public String askToThinkAboutAnAnimal() {
        return htmlBody(withSubmitButton(speaker.askToThinkAboutAnAnimal()));
    }

    @Override
    public String askWhatAnimalWas() {
        return htmlBody(withTextField(speaker.askWhatAnimalWas()));
    }

    @Override
    public String sayYeah() {
        return htmlBody(withSubmitButton(speaker.sayYeah()));
    }

    @Override
    public String askDiscriminatingQuestion(String learningAnimal, String animal) {
        return htmlBody(withTextField(speaker.askDiscriminatingQuestion(learningAnimal, animal)));
    }

    @Override
    public String askAnswerToDiscriminatingQuestion(String question, String newAnimal, String animal) {
        return htmlBody(withYesNoRadioButtons(speaker.askAnswerToDiscriminatingQuestion(question, newAnimal, animal)));
    }

    @Override
    public String isIt(String animal) {
        return htmlBody(withYesNoRadioButtons(speaker.isIt(animal)));
    }

    @Override
    public String askBinaryQuestion(String question) {
        return htmlBody(withYesNoRadioButtons(question));
    }


    protected String htmlBody(String string) {
        return "<html><body>"+string+"</body></html>";
    }

    private String withSubmitButton(String string) {
        return string+"<form name =\"input\" id=\"okForm\"  action =\"step\" method = \"get\">"+
                "<input type =\"submit\" id=\"ok\" value = \"ok\"/></form>";
    }
    
    private String withTextField(String string) {
        return "<form name =\"input\" id = \"inputText\" action =\"step\" method = \"get\">"+string+"<br/>"+
                "<input type =\"text\" id=\"text\" name = \"interaction\"/>"+
                "<input type =\"submit\" id =\"ok\" value = \"ok\"/></form>";
    }

    private String withYesNoRadioButtons(String string) {
        return "<form name =\"input\" id=\"radioYesNo\" action =\"step\" method = \"get\">"+string+"<br/>"+
                "<input type =\"radio\" name = \"interaction\" id=\"yes\" value=\""+getYes()+"\"/>"+getYes()+"<br/>"+
                "<input type =\"radio\" name = \"interaction\" id=\"no\"value=\""+getNo()+"\"/>"+getNo()+
                "<input type =\"submit\" id=\"ok\" value = \"ok\"/></form>";
    }
    

    
}


