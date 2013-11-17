package test.org.tonyzt.animalquiz.kata;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.tonyzt.animalquiz.model.*;
import org.tonyzt.animalquiz.repository.Repository;
import org.tonyzt.animalquiz.view.speakers.DefaultEnglishTextSpeaker;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Tonino
 * Date: 24/12/11
 * Time: 17.26
 * To change this template use File | Settings | File Templates.
 */
public class TestRefactoringNodeToCompositePlainText {
    Repository fakeRepository;

    @Before
    public void setUp() {
        this.fakeRepository = new FakeRepository(new LeafNode("elephant"));
    }


    @Test
    public void firstConversationIsIfItIsElephant() throws Exception {
        // given
        IAnimalQuiz animalQuiz = AnimalQuiz.getUnitTestableAnimalQuiz();

        // when
        String firstMessage =  animalQuiz.step("");

        // then
        Assert.assertEquals("Think about an animal", firstMessage);

    }

    @Test
    public void whenClickOkAtTheFirstPageSholdAskIfItIsAnElephant() throws Exception {
        // given
        IAnimalQuiz animalQuiz = AnimalQuiz.getUnitTestableAnimalQuiz();
        animalQuiz.step("");

        // when
        String firstQuestion = animalQuiz.step("");

        // then
        Assert.assertEquals("is it a elephant?", firstQuestion);
    }

//
    @Test
    public void whenItIsAnElephantShouldAnswerYeah() throws Exception {
        // given
        //AnimalQuiz animalQuiz = new AnimalQuiz(new LeafNode("elephant"),new DefaultEnglishTextSpeaker(),new Memoizer(),fakeRepository);
        IAnimalQuiz animalQuiz = AnimalQuiz.getUnitTestableAnimalQuiz();

        // when
        animalQuiz.step("");
        animalQuiz.step("");
        String output = animalQuiz.step("yes");

        // then
        Assert.assertEquals("yeah!", output);
    }

    @Test
    public void whenItIsNotAnElephantThenShouldAskWhatAnimalWas() throws Exception {
        // given
        //AnimalQuiz animalQuiz = new AnimalQuiz(new LeafNode("elephant"),new DefaultEnglishTextSpeaker(),new Memoizer(),fakeRepository);
        IAnimalQuiz animalQuiz = AnimalQuiz.getUnitTestableAnimalQuiz();

        // when
        animalQuiz.step("");
        animalQuiz.step("");
        String output = animalQuiz.step("no");

        // then
        Assert.assertEquals("can you tell me what animal was (in english language)?", output);
    }

    @Test
    public void whenItIsNotAnElephantThenShouldAllowSpecifyingByInputTextTheAnimal() throws Exception {
        // given
        //AnimalQuiz animalQuiz = new AnimalQuiz(new LeafNode("elephant"),new DefaultEnglishTextSpeaker(),new Memoizer(),fakeRepository);
        IAnimalQuiz animalQuiz = AnimalQuiz.getUnitTestableAnimalQuiz();
        animalQuiz.step("");
        animalQuiz.step("");
        animalQuiz.step("no");

        // when
        String message = animalQuiz.step("mouse");

        // then
        //Assert.assertEquals("what question can be used to distinguish a mouse from a elephant?",message);
        Assert.assertEquals("write, in english language, a question that can be used to distinguish a mouse from a elephant?",message);
    }
//
    @Test
    public void askDiscriminatingQuestion() throws Exception {
        // given
        //AnimalQuiz animalQuiz = new AnimalQuiz(new LeafNode("elephant"),new DefaultEnglishTextSpeaker(),new Memoizer(),fakeRepository);
        IAnimalQuiz animalQuiz = AnimalQuiz.getUnitTestableAnimalQuiz();
        animalQuiz.step("");
        animalQuiz.step("");
        animalQuiz.step("no");
        animalQuiz.step("mouse");

        // when
        String message = animalQuiz.step("is it small?");

        // then
        Assert.assertEquals("What should be the answer to the question \"is it small?\" to distinguish a mouse compared to a elephant?",message);

    }
//
//
//    @Test
//    public void shouldSayThankYouAfterLearnedMouseFromElephant() throws Exception {
//        // given
//        IAnimalQuiz animalQuiz = AnimalQuiz.getUnitTestableAnimalQuiz();
//        animalQuiz.step("");
//        animalQuiz.step("");
//        animalQuiz.step("no");
//        animalQuiz.step("mouse");
//        animalQuiz.step("is it small?");
//
//        // when
//        String message = animalQuiz.step("yes");
//
//        // then
//        Assert.assertEquals("Thank you",message);
//
//    }
//
//    @Test
//    public void afterAddedMouseToTheKnowledgeBaseShouldSayThankYou() throws Exception  {
//        // given
//        //AnimalQuiz animalQuiz = new AnimalQuiz(new LeafNode("elephant"),new DefaultEnglishTextSpeaker(),new Memoizer(),fakeRepository);
//        IAnimalQuiz animalQuiz = AnimalQuiz.getUnitTestableAnimalQuiz();
//        animalQuiz.step("");
//        animalQuiz.step("");
//        animalQuiz.step("no");
//        animalQuiz.step("mouse");
//        animalQuiz.step("is it small?");
//        animalQuiz.step("yes");
//
//        // when
//        String message = animalQuiz.step("");
//
//        // then
//        Assert.assertNotNull(animalQuiz.getCurrentNode());
//        Assert.assertNotNull(animalQuiz.getKnowledge());
//        Assert.assertEquals("Think about an animal",message);
//    }
//
//
//    @Test
//    public void afterTheKnowledgeBaseLearnedToDistinguishTheMouseFromTheElephantICanGuessIt() throws Exception {
//        // given
//        //AnimalQuiz animalQuiz = new AnimalQuiz(new LeafNode("elephant"),new DefaultEnglishTextSpeaker(),new Memoizer(),fakeRepository);
//        IAnimalQuiz animalQuiz = AnimalQuiz.getUnitTestableAnimalQuiz();
//        learnToDistinguishElephantAndMouse(animalQuiz);
//        animalQuiz.step("");
//
//        // when
//        String message = animalQuiz.step("");
//
//        // then
//        Assert.assertNotNull(animalQuiz.getCurrentNode());
//        Assert.assertNotNull(animalQuiz.getKnowledge());
//        Assert.assertEquals("is it small?",message);
//
//    }
//
//    @Test
//    public void learnMouseAndGuessIt() throws Exception  {
//        // given
//        IAnimalQuiz animalQuiz = AnimalQuiz.getUnitTestableAnimalQuiz();
//        learnToDistinguishElephantAndMouse(animalQuiz);
//        animalQuiz.step("");
//
//        // when
//        String message = animalQuiz.step("yes");
//
//        // then
//        Assert.assertEquals("is it a mouse?",message);
//
//    }
//
//    @Test
//    public void learnMouseAndGuessItX() throws Exception  {
//        // given
//        IAnimalQuiz animalQuiz = AnimalQuiz.getUnitTestableAnimalQuiz(new FakeRepository(new NonLeafNode(new LeafNode("mouse"),"is it a mouse?",new LeafNode("elephant"))));
//        learnToDistinguishElephantAndMouse(animalQuiz);
//        animalQuiz.step("");
//
//        // when
//        String message = animalQuiz.step("yes");
//
//        // then
//        Assert.assertEquals("is it a mouse?",message);
//
//    }
//
//    @Test
//    public void learnMouseAndIsNotItThenExpectAskWhatAnimalWas() throws Exception {
//        // given
//        IAnimalQuiz animalQuiz = AnimalQuiz.getUnitTestableAnimalQuiz(new FakeRepository(new NonLeafNode(new LeafNode("mouse"),"is it a mouse?",new LeafNode("elephant"))));
//        animalQuiz.step("");
//        animalQuiz.step("no");
//
//        // when
//        String message = animalQuiz.step("no");
//
//        // then
//        Assert.assertEquals("can you tell me what animal was (in english language)?",message);
//
//    }
//
//    @Test
//    public void aCompleteAutomationElephantMouseAndAnt() throws IOException {
//       // AnimalQuiz animalQuiz = new AnimalQuiz(new LeafNode("elephant"),new DefaultEnglishTextSpeaker(),new Memoizer(),fakeRepository);
//        IAnimalQuiz animalQuiz = AnimalQuiz.getUnitTestableAnimalQuiz();
//        String message;
//
//        message = animalQuiz.step("");
//
//        Assert.assertEquals("Think about an animal",message);
//        message = animalQuiz.step("");
//        Assert.assertEquals(message, "is it a elephant?");
//        message = animalQuiz.step("no");
//        Assert.assertEquals(message, "can you tell me what animal was (in english language)?");
//        message = animalQuiz.step("mouse");
//        Assert.assertEquals(message, "write, in english language, a question that can be used to distinguish a mouse from a elephant?");
//        message = animalQuiz.step("is it small?");
//        Assert.assertEquals(message, "What should be the answer to the question \"is it small?\" to distinguish a mouse compared to a elephant?");
//        message = animalQuiz.step("yes");
//        Assert.assertEquals(message, "Thank you");
//
//        message = animalQuiz.step("");
//        Assert.assertEquals(message, "Think about an animal");
//        message = animalQuiz.step("");
//        Assert.assertEquals(message, "is it small?");
//        message = animalQuiz.step("yes");
//        Assert.assertEquals(message, "is it a mouse?");
//        message = animalQuiz.step("no");
//        Assert.assertEquals(message, "can you tell me what animal was (in english language)?");
//        message = animalQuiz.step("ant");
//        Assert.assertEquals(message, "write, in english language, a question that can be used to distinguish a ant from a mouse?");
//        message = animalQuiz.step("is it an insect?");
//        Assert.assertEquals(message, "What should be the answer to the question \"is it an insect?\" to distinguish a ant compared to a mouse?");
//        message = animalQuiz.step("yes");
//        Assert.assertEquals(message, "Thank you");
//    }
//
//
//
//
//    public void learnToDistinguishElephantAndMouse(IAnimalQuiz animalQuiz) {
//        animalQuiz.step("");
//        animalQuiz.step("");
//        animalQuiz.step("no");
//        animalQuiz.step("mouse");
//        animalQuiz.step("is it small?");
//        animalQuiz.step("yes");
//        animalQuiz.step("");
//    }
//
//
//
//
//




}
