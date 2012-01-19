package org.tonyzt.animalquiz.view.speakers;

import org.tonyzt.animalquiz.model.Speaker;

/**
 * Created by IntelliJ IDEA.
 * User: Tonino
 * Date: 18/12/11
 * Time: 20.06
 * To change this template use File | Settings | File Templates.
 */
public class HtmlSpeakerWithReset extends HtmlSpeaker{
    private static final long serialVersionUID = -6694314031533502739L;

    public HtmlSpeakerWithReset(Speaker speaker) {
        super(speaker);
    }
    
    @Override
    protected String htmlBody(String string) {
        return "<html><body>"+string+resetForm()+"</body></html>";
    }
    
    protected String resetForm() {
        return  "<form name =\"reset\" id =\"reset\" action =\"step\" method = \"get\">"+"<br/>"+
                "<input type =\"hidden\" name = \"reset\" id=\"resetPar\" value=\"\""+"<br/>"+
                "<input type =\"submit\" id = \"resetButtonId\" value = \"reset\"/></form>";
    }

    protected String translatorSnippet() {
        return "<div id=\"google_translate_element\"></div><script>\n" +
         "function googleTranslateElementInit() {\n" +
                "  new google.translate.TranslateElement({\n" +
                "    pageLanguage: 'en',\n" +
                "    includedLanguages: 'af,sq,ar,be,bg,ca,cs,zh-CN,zh-TW,ko,ht,hr,da,iw,et,tl,fi,fr,gl,cy,ja,el,hi,id,en,ga,is,it,lv,lt,mk,ms,mt,no,nl,fa,pl,pt,ro,ru,sr,sk,sl,es,sv,sw,th,de,tr,uk,hu,vi,yi'\n" +
                "  }, 'google_translate_element');\n" +
                "}\n" +
                "</script><script src=\"//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit\"></script>";


//        return
//return "<div id=\"google_translate_element\"></div><script>\n" +
//                "function googleTranslateElementInit() {\n" +
//                "  new google.translate.TranslateElement({\n" +
//                "    pageLanguage: 'en'\n" +
//                "  }, 'google_translate_element');\n" +
//                "}\n" +
//                "</script><script src=\"//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit\"></script>";
    }
}
