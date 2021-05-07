package ru.fintech.qa.homework;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.fintech.qa.homework.models.Animal;
import ru.fintech.qa.homework.models.Place;
import ru.fintech.qa.homework.models.Workman;

public class DbClient {

    public static Session openSession() {
        SessionFactory sessionFactory = HibernateSessionCreator.getSessionFactory();
        return sessionFactory.openSession();
    }

    public static boolean addNewAnimals(final Session session) {
        Animal[] animals;
        int check = 0;
        animals = new Animal[]{new Animal(1), new Animal(2), new Animal(3), new Animal(4), new Animal(5),
                new Animal(6), new Animal(7), new Animal(8), new Animal(9), new Animal(10)};
        for (int i = 0; i < 10; i++) {
            animals[i].setName("Any name");
            try {
                Transaction transaction = session.beginTransaction();
                session.persist(animals[i]);
                transaction.commit();
            } catch (Exception e) {
                System.out.println("Поймано исключение при создании строки c id = " + animals[i].getId());
                check++;
            }
        }
        return check == 10;
    }

    public static boolean addNewWorkman(final Session session, final String name) {
        Workman workman = new Workman();
        workman.setId(7);
        workman.setName(name);
        workman.setAge(13);
        workman.setPosition(5);
        try {
            Transaction transaction = session.beginTransaction();
            session.persist(workman);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Поймано исключение при создании строки в таблице workman c name = " + name);
            return true;
        }
        return false;
    }

    public static void addNewPlace(final Session session) {
        Place place = new Place();
        place.setId(6);
        place.setName("Загон 6");
        place.setRow(7);
        place.setPlaceNum(555);
        Transaction transaction = session.beginTransaction();
        session.persist(place);
        transaction.commit();
    }
}
