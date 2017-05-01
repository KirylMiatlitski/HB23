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

public class SignIn implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		
		String pagePath = "";
		HttpSession session = request.getSession();
		UserAuth userAuth;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//System.out.println("LoginSevlet ");
		//System.out.println(username);
		//System.out.println(password);
		try {
			if (username != null && password != null) {
				
				AccountsService accountService = ServiceFactory.getInstance().getAccountingService();

				userAuth = new UserAuth();
				userAuth.setLogin(username);
				userAuth.setPassword(password);
				//System.out.println("Do service");
				User user = accountService.signIn(userAuth);
				//System.out.println("End Service");
				
				if (user != null) {
					//System.out.println(user.getFirstName());
					session.setAttribute("PRINCIPAL", user);
					
					//response.sendRedirect("/WebProject/main.jsp");
					pagePath = PageNames.MAIN_PAGE;
					return pagePath;
  				}
			}
			//response.sendRedirect("/WebProject/index.jsp");
			pagePath = PageNames.INDEX_PAGE;
			return pagePath;
		} catch (ServiceException e) {
			pagePath = PageNames.ERROR_PAGE;
			return pagePath;
			// show error message
		}


	}

	/*@Override
	public String execute(String request) {
		String response = "";
		String[] requstItems=request.split(" ");
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ClientService service = serviceFactory.getClientService();
		try {
			response = service.signIn(requstItems[0], requstItems[1]);
			
			
		} catch (ServiceException | IllegalArgumentException | NullPointerException e  ) {
			// TODO Auto-generated catch block
			response = "We have found an issue. Check the request.";
		} 
		return response;
	}*/

}
