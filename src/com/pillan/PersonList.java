package com.pillan;


import java.util.ArrayList;
import java.util.List;

public class PersonList {

    public List<Person> personList = new ArrayList<>();


    public void addPerson(Person person) {
        personList.add(person);
    }

}
