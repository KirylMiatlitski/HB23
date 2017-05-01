package by.epam.course.basic.customtags;

import java.io.IOException;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

import by.epam.course.basic.beans.JSPUserListBean;
import by.epam.course.basic.beans.users.User;


public class ShowAllUsersTag extends TagSupport  {

	private static final long serialVersionUID = 7041749831991387809L;
	
	private JSPUserListBean listItems;

	
	
	public JSPUserListBean getListItems() {
		return listItems;
	}



	public void setListItems(JSPUserListBean listItems) {
		this.listItems = listItems;
	}



	public int doStartTag() throws JspTagException {
		if(listItems.getSize() == 0){
			try {
				pageContext.getOut().write("<p> There are no users.</p>");
				return SKIP_BODY;
			} catch (IOException e) {
				throw new JspTagException(e.getMessage());
			}
		}else{
		int size = new Integer(listItems.getSize());
		try {
			pageContext.getOut().write("<table border='1' cellpadding='5' cellspacing='3'>");
			pageContext.getOut().write("<tr><th>");
			pageContext.getOut().write("#" +"</th>");
			
			pageContext.getOut().write("<th>First Namt</th>");
			pageContext.getOut().write("<th>Last Name</th>");
			pageContext.getOut().write("<th>Address</th>");
			pageContext.getOut().write("</th></tr>");

			for(int i=0; i<size; i++) {
				User item = (User)listItems.getElement();
				pageContext.getOut().write("<tr>");
				pageContext.getOut().write("<td>");
				pageContext.getOut().write(new Integer(i+1).toString());
				pageContext.getOut().write("</td>");
				
				pageContext.getOut().write("<td align='center'>");
				pageContext.getOut().write(item.getFirstName());
				pageContext.getOut().write("</td>");
				pageContext.getOut().write("<td align='center'>");
				pageContext.getOut().write(item.getLastName());
				pageContext.getOut().write("</td align='center'>");
				pageContext.getOut().write("<td align='center'>");
				pageContext.getOut().write(item.getAddress());
				pageContext.getOut().write("</td>");	
				
			}
			pageContext.getOut().write("</tr>");
			pageContext.getOut().write("</table>");
		} catch (IOException e) {
			throw new JspTagException(e.getMessage());
		}
		}
		return SKIP_BODY;
		
	}

	
}
