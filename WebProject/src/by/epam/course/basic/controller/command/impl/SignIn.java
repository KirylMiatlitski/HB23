package by.epam.course.basic.controller.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.course.basic.beans.users.User;
import by.epam.course.basic.beans.users.UserAuth;
import by.epam.course.basic.controller.command.Command;
import by.epam.course.basic.controller.command.PageNames;
import by.epam.course.basic.controller.exception.CommandException;
import by.epam.course.basic.services.exception.ServiceException;
import by.epam.course.basic.services.factory.ServiceFactory;
import by.epam.course.basic.services.interfaces.AccountsService;

public class SignIn implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {

		String pagePath = "";
		HttpSession session = request.getSession();
		UserAuth userAuth;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			if (username != null && password != null) {

				AccountsService accountService = ServiceFactory.getInstance().getAccountingService();

				userAuth = new UserAuth();
				userAuth.setLogin(username);
				userAuth.setPassword(password);

				User user = accountService.signIn(userAuth);

				if (user != null) {
					session.setAttribute("PRINCIPAL", user);

					pagePath = PageNames.MAIN_PAGE;
					return pagePath;
				}
				pagePath = PageNames.INDEX_PAGE;
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
