package by.epam.course.basic.beans;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import by.epam.course.basic.beans.users.User;

public class JSPUserListBean implements Serializable {

	private static final long serialVersionUID = -4743775621751107844L;
	private Iterator<? extends User> it;
	private List<? extends User> list;

	public JSPUserListBean() {
	}

	public JSPUserListBean(List<? extends User> list) {
		this.list = list;
	}

	public int getSize() {
		it = list.iterator();
		return list.size();
	}

	public User getElement() {
		return (User) it.next();
	}

	public Iterator<? extends User> getIt() {
		return it;
	}

	public void setIt(Iterator<? extends User> it) {
		this.it = it;
	}

	public List<? extends User> getList() {
		return list;
	}

	public void setList(List<? extends User> list) {
		this.list = list;
	}

}