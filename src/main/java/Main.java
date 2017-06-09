import model.Address;
import model.Person;
import util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by NicolasLopez on 06/06/2017.
 */
public class Main {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        List<Person> listPerson = dummyInsertPersons();

        for (Person person: listPerson) {
            System.out.println("Creating Person: " + person.getFirstName());
            session.persist(person);
        }

        session.getTransaction().commit();
        session.close();
    }

    private static List<Person> dummyInsertPersons(){

        List<Person> listPerson = new LinkedList<Person>();

        Person person1 = new Person("Belkis", "Rivero");
        Person person2 = new Person("Hugo", "Lopez");

        Address address1 = new Address("Belkis Rivero", "Muniz", "15555");
        Address address2 = new Address("Hugo Lopez", "Bella Vista", "16666");
        Address address3 = new Address("Hugo Lopez", "Jasper", "17777");

        person1.getAddresses().add(address1);
        person2.getAddresses().add(address2);
        person2.getAddresses().add(address3);

        listPerson.add(person1);
        listPerson.add(person2);
        return listPerson;
    }
}

/*
SELECT person.firstName, person.lastName, address.town, address.buildingName, address.postCode, person_address.person_id, person_address.address_id
FROM ((person_address
INNER JOIN person ON person_address.person_id = person.person_id)
INNER JOIN address ON person_address.address_id = address.address_id);
 */
