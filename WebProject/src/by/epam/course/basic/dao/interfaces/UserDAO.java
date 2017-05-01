package by.epam.course.basic.dao.interfaces;


import java.util.ArrayList;

import by.epam.course.basic.beans.users.User;
import by.epam.course.basic.beans.users.UserAuth;
import by.epam.course.basic.dao.exception.DAOException;

public interface UserDAO {
	
	User signin(UserAuth user) throws DAOException;
	boolean  registration(UserAuth user, User userData) throws DAOException;
	ArrayList<User> getAllUsers() throws DAOException;
}
