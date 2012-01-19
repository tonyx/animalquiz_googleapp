package org.tonyzt.animalquiz.view.speakers;

import org.tonyzt.animalquiz.model.Speaker;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: ITA86691
 * Date: 13/12/11
 * Time: 20.14
 * To change this template use File | Settings | File Templates.
 */
public  abstract class SpeakerDecorator implements Speaker,Serializable {
    private static final long serialVersionUID = 4332168828368538301L;
    protected Speaker speaker;
    public SpeakerDecorator(Speaker speaker) {
        this.speaker = speaker;
    }
    
    @Override
    public String getYes() {
        return this.speaker.getYes();
    }

    @Override
    public String getNo() {
        return this.speaker.getNo();
    }

    @Override
    public void forgetAll() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isNo(String answer) {
        return speaker.isNo(answer);
    }

    @Override
    public boolean isYes(String answer) {
        return speaker.isYes(answer);
    }

    @Override
    public boolean isNotYesOrNot(String answer) {
        return speaker.isNotYesOrNot(answer);
    }
}
