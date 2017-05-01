package by.epam.course.basic.controller.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.course.basic.controller.command.Command;
import by.epam.course.basic.controller.command.PageNames;
import by.epam.course.basic.controller.exception.CommandException;

public class WrongRequest implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {

		return  PageNames.ERROR_PAGE;
	}

}
