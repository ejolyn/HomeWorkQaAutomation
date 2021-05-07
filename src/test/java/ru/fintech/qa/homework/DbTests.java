package ru.fintech.qa.homework;

import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.fintech.qa.homework.models.Animal;
import ru.fintech.qa.homework.models.Place;
import ru.fintech.qa.homework.models.Zoo;

import java.util.List;

public class DbTests {
    @BeforeAll
    public static void createBase() {
        BeforeUtils.createData();
    }

    @Test
    public void testNumberAnimal() {
        Session session = DbClient.openSession();
        List<Animal> animals = session.createNativeQuery("select * FROM animal", Animal.class).getResultList();
        Assertions.assertEquals(10, animals.size());
        session.close();
    }

    @Test
    public void testAddStrings() {
        Session session = DbClient.openSession();
        Assertions.assertTrue(DbClient.addNewAnimals(session));
        session.close();
    }

    @Test
    public void testNullWorkman() {
        Session session = DbClient.openSession();
        Assertions.assertTrue(DbClient.addNewWorkman(session, null));
        session.close();
    }
    @Test
    public void testAddPlace() {
        Session session = DbClient.openSession();
        DbClient.addNewPlace(session);
        List<Place> places = session.createNativeQuery("select * FROM places", Place.class).getResultList();
        Assertions.assertEquals(6, places.size());
        session.close();
    }
    @Test
    public void testZooCount() {
        Session session = DbClient.openSession();
        List<Zoo> zoos = session.createNativeQuery("select * FROM zoo", Zoo.class).getResultList();
        Assertions.assertEquals(3, zoos.size());
        session.close();
    }
    @Test
    public void testZooNamesCentral() {
        Session session = DbClient.openSession();
        List<Zoo> zoos = session.createNativeQuery("select * FROM zoo", Zoo.class).getResultList();
        Zoo zoo = new Zoo();
        zoo.setName("Центральный");
        Assertions.assertTrue(zoos.contains(zoo));
        session.close();
    }
    @Test
    public void testZooNamesNorth() {
        Session session = DbClient.openSession();
        List<Zoo> zoos = session.createNativeQuery("select * FROM zoo", Zoo.class).getResultList();
        Zoo zoo = new Zoo();
        zoo.setName("Северный");
        Assertions.assertTrue(zoos.contains(zoo));
        session.close();
    }
    @Test
    public void testZooNamesWest() {
        Session session = DbClient.openSession();
        List<Zoo> zoos = session.createNativeQuery("select * FROM zoo", Zoo.class).getResultList();
        Zoo zoo = new Zoo();
        zoo.setName("Западный");
        Assertions.assertTrue(zoos.contains(zoo));
        session.close();
    }
}
