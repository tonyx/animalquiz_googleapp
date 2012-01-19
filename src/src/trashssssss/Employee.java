package trashssssss;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.*;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by IntelliJ IDEA.
 * User: Tonino
 * Date: 29/12/11
 * Time: 11.15
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {
    public static void main(String args[]) throws JAXBException
    {
        final Employee john = new Employee();
        john.setId(1);
        john.setFirstName("John");
        john.setMiddleName("Robert");
        john.setLastName("Doe");

        // write it out as XML
        final JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
        StringWriter writer = new StringWriter();
        jaxbContext.createMarshaller().marshal(john, writer);

        // read it from XML
        final Employee johnRead =
                (Employee) jaxbContext.createUnmarshaller().unmarshal(
                        new StringReader(writer.toString()));
        if (john.equals(johnRead))
        {   // write the new object out as XML again.
            writer = new StringWriter();
            jaxbContext.createMarshaller().marshal(johnRead, writer);
            System.out.println(
                    "johnRead was identical to john: \n" + writer.toString());
        }
        else
        {
            System.out.println("john and johnRead are not equal");
        }
    }

    private int id;

    /**
     * Employee's first name
     */
    private
    String firstName;

    /**
     * Employee's middle name
     */
    private
    String middleName;

    /**
     * Employee's last name
     */
    private
    String lastName;

    public Employee()
    {
    }

    //@XmlAttribute
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    //@XmlElement
    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    //@XmlElement
    public String getMiddleName()
    {
        return middleName;
    }

    public void setMiddleName(String middleName)
    {
        this.middleName = middleName;
    }

    //@XmlElement
    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (firstName != null ? !firstName.equals(employee.firstName) :
                employee.firstName != null) return false;
        if (lastName != null ? !lastName.equals(employee.lastName) :
                employee.lastName != null) return false;
        if (middleName != null ? !middleName.equals(employee.middleName) :
                employee.middleName != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString()
    {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
