package by.epam.course.basic.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.course.basic.controller.exception.CommandException;

public interface Command {
	String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException;
}
