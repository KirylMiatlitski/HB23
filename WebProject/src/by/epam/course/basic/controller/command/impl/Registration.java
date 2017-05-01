package by.epam.course.basic.controller.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.course.basic.beans.users.User;
import by.epam.course.basic.beans.users.UserAuth;
import by.epam.course.basic.controller.command.Command;
import by.epam.course.basic.controller.command.PageNames;
import by.epam.course.basic.controller.exception.CommandException;
import by.epam.course.basic.services.exception.ServiceException;
import by.epam.course.basic.services.factory.ServiceFactory;
import by.epam.course.basic.services.interfaces.AccountsService;

public class Registration implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		String pagePath = "";
		UserAuth userAuth;
		User user;
		String loginname = request.getParameter("loginname");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String address = request.getParameter("address");
		try {
			if (loginname != null && password != null && firstname != null && lastname != null && address != null) {

				AccountsService accountService = ServiceFactory.getInstance().getAccountingService();

				userAuth = new UserAuth();
				user = new User();
				userAuth.setLogin(loginname);
				userAuth.setPassword(password);
				user.setFirstName(firstname);
				user.setLastName(lastname);
				user.setAddress(address);

				if (!accountService.registration(userAuth, user)) {
					pagePath = PageNames.REGISTRATION;
					return pagePath;
				}
				pagePath = PageNames.MAIN_PAGE;
				return pagePath;
			} else {
				throw new ServiceException();
			}

		} catch (ServiceException e) {
			pagePath = PageNames.ERROR_PAGE;
			return pagePath;
		}
	}

}
