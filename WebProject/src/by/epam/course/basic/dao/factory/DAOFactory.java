package by.epam.course.basic.dao.factory;

import by.epam.course.basic.dao.ConnectMSSQLServer;
import by.epam.course.basic.dao.SQLAccountDAO;
import by.epam.course.basic.dao.SQLUserDAO;
import by.epam.course.basic.dao.interfaces.AccountDAO;
import by.epam.course.basic.dao.interfaces.UserDAO;

public class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();
	private final ConnectMSSQLServer connect = new ConnectMSSQLServer();
	//private final SQLAccountingDAO acc = new SQLAccountingDAO();
	private final SQLAccountDAO account = new SQLAccountDAO();
	private final SQLUserDAO user = new SQLUserDAO(); 
	
	private DAOFactory() {
	}
	
	public static ConnectMSSQLServer getConnection(){
		return  instance.getMSSQLServerConnect();
	}
	
	ConnectMSSQLServer getMSSQLServerConnect(){
		return this.connect;
	}
	
	public static DAOFactory getInstance(){
		return instance;
	}
	public UserDAO getUserDAO(){
		return user;
	}
	public AccountDAO getAccountingDAO(){
		return account;
	}
	/*public ProductDAO getProductDAO(){
		return prod;
	}
	public AccountingDAO getAccountingDAO(){
		return acc;
	}*/

}
