package com.btc.app.service;

import java.sql.SQLException;
import java.util.List;
import com.btc.app.dao.UserDao;
import com.btc.app.dao.UserDaoJdbcImpl;
import com.btc.app.model.User;

public class UserServiceImpl implements UserService {
	
    private UserDao daoObj;
	
	public UserServiceImpl() {
		daoObj = new UserDaoJdbcImpl();
	}

	@Override
	public User addUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		return daoObj.addUser(user);
	}

	@Override
	public User searchUserById(int userId) throws SQLException {
		// TODO Auto-generated method stub
		return daoObj.searchUserById(userId);
	}

	@Override
	public boolean deleteUserById(int userId) throws SQLException {
		// TODO Auto-generated method stub
		return daoObj.deleteUserById(userId);
	}
	
	@Override
	public boolean userLogIn(String userEmail, String password) throws SQLException {
		// TODO Auto-generated method stub
		return daoObj.userLogIn(userEmail,password);
	}

	@Override
	public User updateUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		return daoObj.updateUser(user);
	}

	@Override
	public List<User> getAllUser() throws SQLException {
		// TODO Auto-generated method stub
		return daoObj.getAllUser();
	}
	
	

}