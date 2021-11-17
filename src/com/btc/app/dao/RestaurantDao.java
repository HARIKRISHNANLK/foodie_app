package com.btc.app.dao;

import java.sql.SQLException;
import java.util.List;

import com.btc.app.model.Restaurant;
import com.btc.app.model.User;
import com.btc.app.ui.RestaurantAppUI;

public interface RestaurantDao {
	public Restaurant addRestaurant(Restaurant restaurant) throws SQLException;
	
	public Restaurant searchRestaurantById(int restaurantId) throws SQLException ;
	
	public boolean deleteRestaurantById(int restaurantId)throws SQLException;
	
	public Restaurant updateRestaurant(Restaurant restaurant) throws SQLException;

	public List<Restaurant> getAllRestaurantr() throws SQLException;

}
