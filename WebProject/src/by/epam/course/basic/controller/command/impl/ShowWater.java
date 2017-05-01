package by.epam.course.basic.controller.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.course.basic.beans.accounts.Account;
import by.epam.course.basic.beans.users.User;
import by.epam.course.basic.controller.command.Command;
import by.epam.course.basic.controller.command.PageNames;
import by.epam.course.basic.controller.exception.CommandException;
import by.epam.course.basic.services.exception.ServiceException;
import by.epam.course.basic.services.factory.ServiceFactory;
import by.epam.course.basic.services.interfaces.AccountsService;

public class ShowWater implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		String pagePath = "";
		HttpSession session = ((HttpServletRequest) request).getSession();
		User user = (User) session.getAttribute("PRINCIPAL");
		Account account;
		try {
			if (user.getFirstName()!= null && user.getLastName()!= null && user.getAddress()!= null) {
				
				AccountsService accountService = ServiceFactory.getInstance().getAccountingService();
				account = accountService.getAccount(user);
				
				if (account == null){
					pagePath = PageNames.ERROR_PAGE;
					return pagePath;
				}
				session.setAttribute("account", account);
				session.setAttribute("electricity", account.getElectricity());
				session.setAttribute("water", account.getWater());
				pagePath = PageNames.SHOWWATER;
				return pagePath;
			} else {
				pagePath = PageNames.ERROR_PAGE;
				return pagePath;
			}
			
		} catch (ServiceException e) {
			pagePath = PageNames.ERROR_PAGE;
			return pagePath;
			// show error message
		}
	}

}
