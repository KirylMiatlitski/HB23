package by.epam.course.basic.services;

import java.util.ArrayList;

import by.epam.course.basic.beans.accounts.Account;
import by.epam.course.basic.beans.users.User;
import by.epam.course.basic.beans.users.UserAuth;
import by.epam.course.basic.dao.exception.DAOException;
import by.epam.course.basic.dao.factory.DAOFactory;
import by.epam.course.basic.dao.interfaces.AccountDAO;
import by.epam.course.basic.dao.interfaces.UserDAO;
import by.epam.course.basic.services.exception.ServiceException;
import by.epam.course.basic.services.interfaces.AccountsService;

public class AccountingServiceImpl implements AccountsService {

// сервисы должны валидировать входные параметры
	// да и лежит этот класс как-то кривовато
	@Override
	public User signIn(UserAuth user) throws ServiceException {
		
		try {
			DAOFactory daoF = DAOFactory.getInstance();
			UserDAO accountsDAO = daoF.getUserDAO();
			User userResult = new User();
			userResult = accountsDAO.signin(user);
			return userResult;
			
		} catch (DAOException e) {
			throw new ServiceException();
		}
	}

	@Override
	public boolean registration(UserAuth user, User userData) throws ServiceException {
		try {
			DAOFactory daoF = DAOFactory.getInstance();
			UserDAO accountsDAO = daoF.getUserDAO();
			return accountsDAO.registration(user, userData);
			
		} catch (DAOException e) {
			throw new ServiceException();// теряешь реальное исключение, оборачивай его при пробрасывании new ServiceException(e)
		}
	}

	@Override
	public ArrayList<User> getAllUsers() throws ServiceException {
		try {
			DAOFactory daoF = DAOFactory.getInstance();
			UserDAO accountsDAO = daoF.getUserDAO();
			return accountsDAO.getAllUsers();
			
		} catch (DAOException e) {
			throw new ServiceException();
		}
	}

	@Override
	public Account getAccount(User user) throws ServiceException {
		try {
			DAOFactory daoF = DAOFactory.getInstance();
			AccountDAO accountsDAO = daoF.getAccountingDAO();
			return accountsDAO.getAccountByUser(user);
			
		} catch (DAOException e) {
			throw new ServiceException();
		}
	}

}
