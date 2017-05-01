package by.epam.course.basic.controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.course.basic.beans.users.User;
import by.epam.course.basic.beans.users.UserAuth;
import by.epam.course.basic.services.exception.ServiceException;
import by.epam.course.basic.services.factory.ServiceFactory;
import by.epam.course.basic.services.interfaces.AccountsService;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -7277310931445565627L;

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("LoginSevlet ");
		System.out.println(username);
		System.out.println(password);
		try {
			if (username != null && password != null) {
				AccountsService accountService = ServiceFactory.getInstance().getAccountingService();

				UserAuth userAuth = new UserAuth();
				userAuth.setLogin(username);
				userAuth.setPassword(password);
				User user = accountService.signIn(userAuth);
				
				if (user != null) {
					System.out.println(user.getFirstName());
					session.setAttribute("PRINCIPAL", user);
					response.sendRedirect("/WebProject/main.jsp");
					return;
  				}
			}
			response.sendRedirect("/WebProject/index.jsp");
		} catch (ServiceException e) {
			// show error message
		}
	}

}
