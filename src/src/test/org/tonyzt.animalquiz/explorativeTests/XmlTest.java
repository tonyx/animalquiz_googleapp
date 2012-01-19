package test.org.tonyzt.explorativeTests;

import org.junit.Assert;
import org.junit.Test;
import org.tonyzt.animalquiz.model.INode;
import org.tonyzt.animalquiz.model.LeafNode;

import java.beans.XMLEncoder;
import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: Tonino
 * Date: 27/12/11
 * Time: 19.20
 * To change this template use File | Settings | File Templates.
 */
public class XmlTest {
    @Test
    public void XmlEncode() throws  Exception {


        INode node = new LeafNode("ele");
        
        OutputStream output = new OutputStream() {
            private StringBuilder string = new StringBuilder();
            @Override
            public void write(int b) throws IOException {
                this.string.append((char)b);
            }
            public String toString() {
                return this.string.toString();
            }
        };
        
        //XMLEncoder enc = new XMLEncoder(new BufferedOutputStream(output));
        XMLEncoder enc = new XMLEncoder(new FileOutputStream("C:\\temp\\Test.xml"));
        enc.writeObject(node);
        enc.close();
        
        Assert.assertEquals("",enc.toString());

    }

//     /** Read the object from Base64 string. */
//    private static Object fromString( String s ) throws IOException ,
//                                                        ClassNotFoundException {
//        ObjectInputStream ois = new ObjectInputStream(
//                                        new ByteArrayInputStream(  data ) );
//        Object o  = ois.readObject();
//        ois.close();
//        return o;
//    }
//
//    /** Write the object to a Base64 string. */
//    private static String toString( Serializable o ) throws IOException {
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        ObjectOutputStream oos = new ObjectOutputStream( baos );
//        oos.writeObject( o );
//        oos.close();
//        return new String( Base64Coder.encode( baos.toByteArray() ) );
//    }



}
