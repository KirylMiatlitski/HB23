package by.epam.course.basic.controller.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.course.basic.controller.command.Command;
import by.epam.course.basic.controller.command.CommandProvider;
import by.epam.course.basic.controller.command.PageNames;
import by.epam.course.basic.controller.exception.CommandException;

public class ServletController extends HttpServlet {
	private static final String COMMAND_NAME = "command";
	private final CommandProvider provider = new CommandProvider();

	private static final long serialVersionUID = 2916059075792547777L;

	public ServletController() {
	}

	@Override
	public void init() throws ServletException {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String commandName = null;
		Command command = null;
		String page = null;
		commandName = request.getParameter(COMMAND_NAME);
		command = provider.getCommand(commandName);
		try {
			page = command.execute(request, response);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);

			if (dispatcher != null) {
				dispatcher.forward(request, response);

			}
		} catch (CommandException e) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(PageNames.ERROR_PAGE);
			dispatcher.forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String commandName = null;
		Command command = null;
		String url = null;

		commandName = request.getParameter(COMMAND_NAME);
		command = provider.getCommand(commandName);

		try {
			url = command.execute(request, response);
			response.sendRedirect(request.getContextPath() + url);
		} catch (CommandException e) {
			response.sendRedirect(request.getContextPath() + PageNames.ERROR_PAGE);
		}
	}

}
