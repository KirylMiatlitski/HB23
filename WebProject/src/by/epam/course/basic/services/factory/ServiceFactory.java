package by.epam.course.basic.services.factory;

import by.epam.course.basic.services.AccountingServiceImpl;
import by.epam.course.basic.services.interfaces.AccountsService;

public class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();
	private final AccountsService accountingService = new AccountingServiceImpl();

	private ServiceFactory() {
	};

	public static ServiceFactory getInstance() {
		return instance;
	}

	public AccountsService getAccountingService() {
		return accountingService;
	}

}
