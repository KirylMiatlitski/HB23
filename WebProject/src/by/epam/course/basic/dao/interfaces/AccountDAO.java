package by.epam.course.basic.dao.interfaces;

import java.util.ArrayList;

import by.epam.course.basic.beans.accounts.Account;
import by.epam.course.basic.beans.users.User;
import by.epam.course.basic.dao.exception.DAOException;

public interface AccountDAO {
	Account getAccountByUser(User user) throws DAOException;
	ArrayList<Account> getAllAccounts() throws DAOException;
}
