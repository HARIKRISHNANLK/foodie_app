package com.btc.app.service;

import java.sql.SQLException;
import java.util.List;

import com.btc.app.model.Restaurant;

public interface RestaurantService {

	public Restaurant addRestaurant(Restaurant restaurant) throws SQLException;

	boolean deleteRestaurantById(int RestaurantId) throws SQLException;

	List<Restaurant> getAllRestaurant() throws SQLException;

	Restaurant updateRestaurant(Restaurant restaurant) throws SQLException;

	Restaurant searchRestaurantById(int restaurantId) throws SQLException;
}
