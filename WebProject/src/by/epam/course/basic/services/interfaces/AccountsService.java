package by.epam.course.basic.services.interfaces;

import java.util.ArrayList;

import by.epam.course.basic.beans.accounts.Account;
import by.epam.course.basic.beans.users.User;
import by.epam.course.basic.beans.users.UserAuth;
import by.epam.course.basic.services.exception.ServiceException;

public interface AccountsService {
	User signIn(UserAuth user) throws ServiceException;
	boolean  registration(UserAuth user, User userData) throws ServiceException;
	ArrayList<User> getAllUsers() throws ServiceException;
	Account getAccount(User user)  throws ServiceException;
}
