package by.epam.course.basic.controller.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.course.basic.controller.command.Command;
import by.epam.course.basic.controller.command.PageNames;
import by.epam.course.basic.controller.exception.CommandException;

public class Logout implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		String pagePath = "";
		request.getSession().invalidate();
		pagePath = PageNames.SHORT_INDEX_PAGE;
		return pagePath;

	}

}
