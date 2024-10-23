package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import androidx.appcompat.view.menu.MenuBuilder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */

    public CustomList MockCityList(){
        list = new CustomList(null, new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    public void testHasCity(){
        list = MockCityList();
        City newCity = new City("Saskatoon", "SK");
        assertFalse(list.HasCity(newCity));

        list.addCity(newCity);
        assertTrue(list.HasCity(newCity));
    }

    @Test
    public void testDeleteCity(){
        list = MockCityList();

        //Test deleting an existing city
        City city = new City("Calgary", "Alberta");
        list.addCity(city);
        assertTrue(list.HasCity(city));
        list.DeleteCity(city);
        assertFalse(list.HasCity(city));

        //Test deleting a city that does not exist
        City newCity = new City("Halifax", "Nova Scotia");
        assertThrows(IllegalArgumentException.class, () -> {
            list.DeleteCity(newCity);
        });
    }

    @Test
    public void testCountCities(){
        list = MockCityList();

        //Assuming mockCityList has one city
        assertEquals(1, list.CountCities());

        //Add a new city and verify the count increases
        City newCity = new City("Halifax", "Nova Scotia");
        list.addCity(newCity);
        assertEquals(2, list.CountCities());

        //Delete a city and check if the count decreases
        list.DeleteCity(newCity);
        assertEquals(1, list.CountCities());
    }

}
