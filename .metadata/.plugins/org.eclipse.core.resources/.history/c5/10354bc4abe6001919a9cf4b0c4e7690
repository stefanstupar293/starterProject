package com.gmail.stefan.ui.views.login;

import java.util.Optional;

import com.gmail.stefan.ui.views.reviewslist.ReviewsList;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.login.AbstractLogin.LoginEvent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.Autocomplete;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.templatemodel.TemplateModel;
//import com.mnocompany.smspay.ui.LoginView.DISPLAY_VIEW;
//import com.mnocompany.smspay.ui.components.LoginForm;
import com.gmail.stefan.ui.views.login.AppUserServices;
/**
 * A Designer generated component for the login-test template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */

@Route(value = "")
@RouteAlias("login")
@PageTitle("Login")
@Tag("login-test")
@JsModule("./src/views/login/login-test.js")
public class LoginTest extends PolymerTemplate<LoginTest.LoginTestModel> implements BeforeEnterObserver {

   
	/**
	 * 
	 */
	private static final long serialVersionUID = 3695671631683052307L;

	public Button getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(Button btnLogin) {
		this.btnLogin = btnLogin;
	}

	@Id("vaadinVerticalLayout")
	private VerticalLayout vaadinVerticalLayout;
	@Id("h2")
	private H2 h2;
	@Id("emailInput")
	private TextField emailInput;
	@Id("passInput")
	private PasswordField passInput;
	@Id("btnLogin")
	private Button btnLogin;
	@Id("btnCancel")
	private Button btnCancel;
	boolean userLoggedIn;
	
	
	public TextField getEmailInput() {
		return emailInput;
	}

	public void setEmailInput(TextField emailInput) {
		this.emailInput = emailInput;
	}

	public PasswordField getPassInput() {
		return passInput;
	}

	public void setPassInput(PasswordField passInput) {
		this.passInput = passInput;
	}
	
	enum DISPLAY_VIEW{
		
		LOGIN
	}	
	DISPLAY_VIEW displayView;
	
	/**
     * Creates a new LoginTest.
     */
	
	public LoginTest() {
		btnLogin.addClickListener(e -> {  
			VaadinSession.getCurrent().setAttribute("userLoggedIn", true);
			Object intendedPath = VaadinSession.getCurrent().getAttribute("intendedPath");
			UI.getCurrent().navigate(Optional.ofNullable(intendedPath).map(Object::toString).orElse(""));
			System.out.println("Login successful");
		});
	}

	public Credentials getCredentials() {
    	Credentials c = new Credentials();
    	c.setEmail(emailInput.getValue());
    	c.setPassword(passInput.getValue());
    	return c;
    }

    /**
     * This model binds properties between LoginTest and login-test
     */
    public interface LoginTestModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	@Override
	public void beforeEnter(BeforeEnterEvent event) {
		// TODO Auto-generated method stub
		
	}
    

    
}
