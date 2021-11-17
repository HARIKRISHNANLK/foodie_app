package com.btc.app.service;
import java.sql.SQLException;
import java.util.List;

import com.btc.app.dao.RestaurantDao;
import com.btc.app.dao.RestaurantDaoJdbcImpl;
import com.btc.app.dao.UserDao;
import com.btc.app.dao.UserDaoJdbcImpl;
import com.btc.app.model.Restaurant;
import com.btc.app.model.User;

public class RestaurantServiceImpl implements RestaurantService{
	 private RestaurantDao daoObj;
	 
	 public RestaurantServiceImpl() {
			daoObj = new RestaurantDaoJdbcImpl();
		}
	 
	 public Restaurant  addRestaurant(Restaurant restaurant) throws SQLException {
			// TODO Auto-generated method stub
			return daoObj.addRestaurant(restaurant);
		}

	@Override
		public Restaurant searchRestaurantById(int restaurantId) throws SQLException {
			// TODO Auto-generated method stub
			return daoObj.searchRestaurantById(restaurantId);
		}
	 
	@Override
		public boolean deleteRestaurantById(int RestaurantId) throws SQLException {
			// TODO Auto-generated method stub
			return daoObj.deleteRestaurantById(RestaurantId);
		}

	@Override
		public Restaurant updateRestaurant(Restaurant restaurant) throws SQLException {
			// TODO Auto-generated method stub
			return daoObj.updateRestaurant(restaurant);
		}
	@Override
	public List<Restaurant> getAllRestaurant() throws SQLException {
		// TODO Auto-generated method stub
		return daoObj.getAllRestaurantr();
	}
	
		
	
}