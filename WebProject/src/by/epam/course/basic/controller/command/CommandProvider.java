package by.epam.course.basic.controller.command;

import java.util.HashMap;
import java.util.Map;

import by.epam.course.basic.controller.command.impl.Logout;
import by.epam.course.basic.controller.command.impl.Registration;
import by.epam.course.basic.controller.command.impl.ShowAllUsers;
import by.epam.course.basic.controller.command.impl.ShowElectricity;
import by.epam.course.basic.controller.command.impl.ShowWater;
import by.epam.course.basic.controller.command.impl.SignIn;
import by.epam.course.basic.controller.command.impl.WrongRequest;


public final class CommandProvider {
	private final Map<CommandName, Command> repository = new HashMap<>();
	
	public CommandProvider() {
		repository.put(CommandName.SIGN_IN, new SignIn());
		repository.put(CommandName.LOGOUT, new Logout());
		repository.put(CommandName.REGISTRATION, new Registration());
		repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
		repository.put(CommandName.SHOW_ALL_USERS, new ShowAllUsers());
		repository.put(CommandName.SHOW_ELECTRICITY, new ShowElectricity());
		repository.put(CommandName.SHOW_WATER, new ShowWater());
		
	}
	
	public Command getCommand(String name){
		Command command = null;
		CommandName commandName = null;
		try {
			commandName = CommandName.valueOf(name.toUpperCase().replaceAll("-", "_"));
			command = repository.get(commandName);
			
		} catch (IllegalArgumentException | NullPointerException e) {
			command = repository.get(CommandName.WRONG_REQUEST);
		}
		
		return command;
	}
}
