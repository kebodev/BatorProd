package com.kebodev.managed;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import org.apache.log4j.Logger;

import com.kebodev.breadcrumb.BreadCrumbItem;

import lombok.Data;

@Data
public class FragmentHandlerMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String actualFragmen;
	private List<BreadCrumbItem> breadCrumbItems;
	private int pageIndexToSave;
	final static Logger log = Logger.getLogger(FragmentHandlerMB.class.getName());

	public List<BreadCrumbItem> getBreadCrumbItems() {
		return breadCrumbItems;
	}

	public void setBreadCrumbItems(List<BreadCrumbItem> breadCrumbItems) {
		this.breadCrumbItems = breadCrumbItems;
	}

	public void removeBreadCrumbItem(String pageName) {

	}

	public String getActualFragmen() {
		return actualFragmen;
	}

	public void setActualFragmen(String actualFragmen) {
		this.actualFragmen = actualFragmen;
	}

	public FragmentHandlerMB() {
		super();
		this.actualFragmen = "search.xhtml";
		breadCrumbItems = new ArrayList<BreadCrumbItem>();
		pageIndexToSave = 0;
		breadCrumbItems.add(new BreadCrumbItem(BreadCrumbItem.SERACH_PAGE, "Keresés", pageIndexToSave));

	}

	public void changeFrag(String fragToOpen, String fragToOpenName, int pageIndex) {

		log.debug("invoked with params - fragToOpen: " + fragToOpen + " fragToOpenName: " + fragToOpenName
				+ " pageIndex: " + pageIndex);

		if (pageIndex == -1) {

			log.debug("req from page");

			pageIndexToSave++;

			try {

				FacesContext.getCurrentInstance().getExternalContext().redirect(fragToOpen);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				log.error(e.getStackTrace());
			}
			breadCrumbItems.add(new BreadCrumbItem(fragToOpen, fragToOpenName, pageIndexToSave));
		} else {

			log.debug("req from breadcrumb");

			List<BreadCrumbItem> breadCrumbItemsToRemove = new ArrayList<BreadCrumbItem>();

			for (BreadCrumbItem menuItem : breadCrumbItems) {

				if (menuItem.getPageIndex() > pageIndex) {

					breadCrumbItemsToRemove.add(menuItem);

				}
			}

			breadCrumbItems.removeAll(breadCrumbItemsToRemove);
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect(fragToOpen);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				log.error(e.getStackTrace());
			}

		}

	}

	public void backButtonCheckr() {

		FacesContext ctx = FacesContext.getCurrentInstance();
		String pageName = ctx.getViewRoot().getViewId().replace("/", "");
		int pageIndex = 9999;

		log.debug("invoked pageName: " + pageName);

		for (BreadCrumbItem menuItem : breadCrumbItems) {

			if (menuItem.getPageName().equalsIgnoreCase(pageName)) {

				pageIndex = menuItem.getPageIndex();

			}
		}

		List<BreadCrumbItem> breadCrumbItemsToRemove = new ArrayList<BreadCrumbItem>();
		for (BreadCrumbItem menuItem : breadCrumbItems) {
			if (menuItem.getPageIndex() > pageIndex) {
				breadCrumbItemsToRemove.add(menuItem);
			}
		}
		breadCrumbItems.removeAll(breadCrumbItemsToRemove);
	}

	public static boolean validate(String user, String password) {

		try {
			return autAD(user, password);

		} catch (Exception e) {
			log.error(e.getStackTrace());
			return false;
		}
	}

	public static boolean autAD(String UserName, String UserPass) {

		// Set up environment for creating initial context
		Hashtable<String, String> env = new Hashtable<String, String>(11);

		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, "ldap://res.hu.corp:389");

		// Authenticate as S. User and password "mysecret"
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL, UserName + "@res.hu.corp");
		env.put(Context.SECURITY_CREDENTIALS, UserPass);

		return check(env);

	}

	public static boolean check(Hashtable<String, String> env) {
		try {
			// Create initial context
			DirContext ctx = new InitialDirContext(env);
			ctx.close();
			return true;

		} catch (NamingException e) {
			return false;
		}
	}

}
