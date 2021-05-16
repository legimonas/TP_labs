package controllers;

import forms.LoginForm;
import entities.User;

/**
 * @author user
 * @version 1.0
 * @created 11-May-2021 17:59:04
 */
public class LoginController {

	public LoginForm m_LoginForm;
	public LoginDAO m_LoginDAO;

	public LoginController(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param User
	 */
	public Role getRole(User User){
		return null;
	}

	/**
	 * 
	 * @param s1
	 * @param s2
	 */
	public void login(String s1, String s2){

	}

	/**
	 * 
	 * @param role
	 */
	public int redirect(String role){
		return 0;
	}

	public void showLoginForm(){

	}

}