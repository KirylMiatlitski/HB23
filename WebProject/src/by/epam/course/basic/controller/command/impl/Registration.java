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

public class Registration implements Command{

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
		//System.out.println("LoginSevlet ");
		//System.out.println(username);
		//System.out.println(password);
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
				//System.out.println("Do service");
				if (!accountService.registration(userAuth, user)){
					pagePath = PageNames.REGISTRATION;
					return pagePath;
				}
				
			}
			pagePath = PageNames.MAIN_PAGE;
			return pagePath;
		} catch (ServiceException e) {
			pagePath = PageNames.ERROR_PAGE;
			return pagePath;
			// show error message
		}
	}

/*	@Override
	public String execute(String request) {
		String response;
		String[] requstItems=request.split(" ");
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ClientService clinetService = serviceFactory.getClientService(); 
		try {
			clinetService.registration(requstItems[0], requstItems[1]);
			response = "The user has been created.";
		} catch (ServiceException | IllegalArgumentException | NullPointerException e  ) {
			// TODO Auto-generated catch block
			response = "We have found an issue. Check the request.";
		} 
		return response;
	}
	*/

}
