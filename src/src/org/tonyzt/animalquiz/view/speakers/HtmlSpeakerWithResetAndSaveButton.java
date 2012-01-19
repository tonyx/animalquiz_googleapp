package org.tonyzt.animalquiz.view.speakers;

import org.tonyzt.animalquiz.model.Speaker;

/**
 * Created by IntelliJ IDEA.
 * User: Tonino
 * Date: 20/12/11
 * Time: 1.00
 * To change this template use File | Settings | File Templates.
 */
public class HtmlSpeakerWithResetAndSaveButton extends HtmlSpeakerWithReset {
    private static final long serialVersionUID = 238113947391578587L;

    public HtmlSpeakerWithResetAndSaveButton(Speaker speaker) {
        super(speaker);
    }
    @Override
    protected String htmlBody(String string) {
        return "<html><body>"+string+resetForm()+saveFormButton()+loadFormButton()+deleteFormButton()+"</body></html>";
        //return "<html><body>"+translatorSnippet()+string+resetForm()+"</body></html>";
    }
    
    protected String saveFormButton() {
        return  "<form name =\"save\" id = \"saveForm\" action =\"step\" method = \"get\">"+"<br/>"+
                "<input type =\"hidden\" name = \"save\" id = \"saveId\" value=\"\"\"+<br/>"+
                "<input type =\"submit\" id = \"buttonSaveId\" value = \"save\"/></form>";
    }

    protected String loadFormButton() {
        return  "<form name =\"load\" id = \"loadForm\" action =\"step\" method = \"get\">"+"<br/>"+
                "<input type =\"hidden\" name = \"load\" id = \"loadId\" value=\"\"\"+<br/>"+
                "<input type =\"submit\" id = \"buttonLoadId\" value = \"load\"/></form>";
    }

    protected String deleteFormButton() {
        return  "<form name =\"delete\" id = \"deleteForm\" action =\"step\" method = \"get\">"+"<br/>"+
                "<input type =\"hidden\" name = \"delete\" id = \"deleteId\" value=\"\"\"+<br/>"+
                "<input type =\"submit\" id = \"buttonDeleteId\" value = \"delete\"/></form>";

    }


}
