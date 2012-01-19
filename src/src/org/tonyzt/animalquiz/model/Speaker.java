package org.tonyzt.animalquiz.model;

/**
 * Created by IntelliJ IDEA.
 * User: ITA86691
 * Date: 13/12/11
 * Time: 20.11
 * To change this template use File | Settings | File Templates.
 */
public interface Speaker {
    String askYesOrNot();

    String sayThankYou();

    boolean isNo(String answer);

    boolean isYes(String answer);
    
    String getYes();
    
    String getNo();

    void forgetAll();

    String askToThinkAboutAnAnimal();

    String askWhatAnimalWas();

    String sayYeah();

    String askDiscriminatingQuestion(String learningAnimal, String animal);

    String askAnswerToDiscriminatingQuestion(String question, String newAnimal, String animal);

    boolean isNotYesOrNot(String answer);

    String isIt(String animal);

    String askBinaryQuestion(String question);
    
    

}
