package by.epam.course.basic.controller.command.impl;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.course.basic.beans.JSPUserListBean;
import by.epam.course.basic.controller.command.Command;
import by.epam.course.basic.controller.command.PageNames;
import by.epam.course.basic.controller.exception.CommandException;
import by.epam.course.basic.services.exception.ServiceException;
import by.epam.course.basic.services.factory.ServiceFactory;
import by.epam.course.basic.services.interfaces.AccountsService;

public class ShowAllUsers implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {

		String pagePath = "";
		JSPUserListBean jspList = null;
		try {

			AccountsService accountService = ServiceFactory.getInstance().getAccountingService();

			jspList = new JSPUserListBean(accountService.getAllUsers());
			request.setAttribute("listItems", jspList);
			pagePath = PageNames.SHOWALLUSERS;
			return pagePath;
		} catch (ServiceException e) {
			pagePath = PageNames.ERROR_PAGE;
			return pagePath;
			// show error message
		}

	}
}
