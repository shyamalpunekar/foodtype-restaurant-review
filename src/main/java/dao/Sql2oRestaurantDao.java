package dao;

import models.Foodtype;
import models.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class Sql2ORestaurantDao implements restaurantDao {
    @Override
    public void add(Restaurant restaurant) {

    }

    @Override
    public List<Foodtype> getAllFoodtypesForARestaurant(int restaurantId) {

        List<Foodtype> foodtypes = new ArrayList<>();

        return foodtypes;
    }


}
