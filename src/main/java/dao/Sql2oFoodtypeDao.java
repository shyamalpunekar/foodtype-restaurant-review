package dao;
import models.Foodtype;
import models.Restaurant;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;

public class Sql2OFoodtypeDao implements foodtypeDao {

    private final Sql2o sql2o;

    public Sql2OFoodtypeDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Foodtype foodtype) {

    }


    @Override
    public void addFoodTypeToRestaurant(Foodtype foodtype, Restaurant restaurant) {

        String sql = "INSERT INTO restaurants_foodtypes (restaurantid, foodtypeid) VALUES (:restaurantId, :foodtypeId)";

        try (Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("restaurantid", restaurant.getId())
                    .addParameter("foodtypeid", foodtype.getId())
                    .executeUpdate();
        } catch (Sql2oException e){
            System.out.println(e);
        }
    }


    @Override
    public List<Restaurant> getAllRestaurantsForAFoodtype(int foodtypeId) {
        ArrayList<Restaurant> restaurants = new ArrayList<>();

        String joinQuery = "SELECT restaurantid FROM restaurants_foodtypes WHERE foodtypeid = :foodtypeId";

        try (Connection con = sql2o.open()){
            List<Integer> allRestaurantIds = con.createQuery(joinQuery)
                    .addParameter("foodtypeId", foodtypeId)
                    .executeAndFetch(Integer.class);

            for (Integer restaurantId : allRestaurantIds){
                String restaurantQuery = "SELECT * FROM restaurants WHERE id = :restaurantId";
                restaurants.add(
                        con.createQuery(restaurantQuery)
                                .addParameter("restaurantId", restaurantId)
                                .executeAndFetchFirst(Restaurant.class));
            }

        } catch (Sql2oException e){
            System.out.println(e);
        }
        return restaurants;
    }
}
