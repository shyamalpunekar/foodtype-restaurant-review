package dao;


import models.Foodtype;
import models.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class Sql2OFoodtypeDao implements foodtypeDao {

    @Override
    public void add(Foodtype foodtype) {

    }


    @Override
    public void addFoodTypeToRestaurant(Foodtype foodtype, Restaurant restaurant) {

    }

    @Override
    public List<Restaurant> getAllRestaurantsForAFoodtype(int id) {
        List<Restaurant> restaurants = new ArrayList<>();
        return restaurants;
    }
}
