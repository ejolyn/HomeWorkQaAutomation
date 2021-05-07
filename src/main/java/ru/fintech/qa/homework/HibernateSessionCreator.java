package ru.fintech.qa.homework;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.fintech.qa.homework.models.Animal;
import ru.fintech.qa.homework.models.Place;
import ru.fintech.qa.homework.models.Workman;
import ru.fintech.qa.homework.models.Zoo;


public class HibernateSessionCreator {

    private static SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }

    private static SessionFactory buildSessionFactory() {
        return new Configuration()
                .configure()
                .addAnnotatedClass(Animal.class)
                .addAnnotatedClass(Workman.class)
                .addAnnotatedClass(Place.class)
                .addAnnotatedClass(Zoo.class)
                .buildSessionFactory();
    }
}
