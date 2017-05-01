package by.epam.course.basic.controller.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import by.epam.course.basic.beans.users.User;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter("/AuthFilter")
public class AuthFilter implements Filter {
	
	private List<String> pathFilters =  Arrays.asList(new String[]{"main.jsp"});

 	public AuthFilter() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String uri = ((HttpServletRequest) request).getRequestURI();
		String path = StringUtils.substringAfterLast(uri, "/");
		if (!pathFilters.contains(path)){
			chain.doFilter(request, response);
			return;
		}
		
		HttpSession session = ((HttpServletRequest) request).getSession();
		User user = (User) session.getAttribute("PRINCIPAL");
		if (user != null){
			chain.doFilter(request, response);
			return;
		}
		
		((HttpServletResponse) response).sendRedirect("./index.jsp");
	}

	public void destroy() {
	}

}
