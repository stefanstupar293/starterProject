package com.gmail.stefan.ui.views.login;
import java.awt.Panel;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;




public class Login extends VerticalLayout implements BeforeEnterObserver {

	@Id ("email")
	private TextField email; 
	@Id ("password")
	private PasswordField password;
	@Id ("login")
	private Button login;
	@Id ("cancel")
	private Button cancel;
	
	
		
	
	
	public Login () {
		
		// UI elements
		EmailField emailField = new EmailField ("Email");
		emailField.setSizeFull();
		PasswordField passwordField = new PasswordField ();
		passwordField.setLabel("Password");
		
		
		
		//Button horizontal layout
		HorizontalLayout HLayout = new HorizontalLayout();
		
		// UI elements buttons
		Button login = new Button ("login");
		
		Button cancel = new Button ("cancel");
		
		
		HLayout.addComponentAsFirst(login);
		HLayout.addComponentAsFirst(cancel);
		
		HLayout.setSpacing(true);
		
		//Form Layout
		FormLayout formLogin = new FormLayout(email, password, HLayout);
		
		// Panel
		Panel loginPanel = new Panel ();
		
		// Add Component 
		
		addComponent(loginPanel);
		
//		LoginForm component = new LoginForm();
//		component.addLoginListener(e -> {
//		boolean isAuthenticated = authenticate(e);
//		if (isAuthenticated) {
//		navigateToMainPage();
//		} else {
//		component.setError(true);
//		}
//		});
		
		
	}

	
	private void addComponent(Panel loginPanel) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void beforeEnter(BeforeEnterEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	
}