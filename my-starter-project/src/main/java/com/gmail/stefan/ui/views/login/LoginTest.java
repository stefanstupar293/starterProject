package com.gmail.stefan.ui.views.login;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.login.AbstractLogin.LoginEvent;
import com.vaadin.flow.component.login.LoginForm;
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
import com.vaadin.flow.templatemodel.TemplateModel;
import com.gmail.stefan.ui.MainLayout;
import com.gmail.stefan.ui.views.login.Credentials;
//import com.mnocompany.smspay.ui.LoginView.DISPLAY_VIEW;
//import com.mnocompany.smspay.ui.components.LoginForm;
/**
 * A Designer generated component for the login-test template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */

@Route(value = "", layout = MainLayout.class)
@RouteAlias("login")
@PageTitle("Login")
@Tag("login-test")
@JsModule("./src/views/login/login-test.js")
public class LoginTest extends PolymerTemplate<LoginTest.LoginTestModel> implements BeforeEnterObserver {

   
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
	
	
	enum DISPLAY_VIEW{
		
		LOGIN
		
	}	
	DISPLAY_VIEW displayView;

	/**
     * Creates a new LoginTest.
     */
    public LoginTest() {
        // You can initialise any data required for the connected UI components here.
    	emailInput.setAutocomplete(Autocomplete.EMAIL);
    	passInput.setAutocomplete(Autocomplete.NEW_PASSWORD);
    	
    	btnLogin.addClickListener(
    	        (ComponentEventListener<ClickEvent<Button>>) buttonClickEvent -> doLogin(emailInput.getValue(),
    	            passInput.getValue()));
//    	initForLogin();
    	
//    	LoginForm loginForm = new LoginForm();
//    	content.removeAll();
//    	content.add(loginForm);
    	
    	LoginForm component = new LoginForm();
    	component.addLoginListener(e -> {
    	    boolean isAuthenticated = authenticate(e);
    	    if (isAuthenticated) {
    	        navigateToMainPage();
    	    } else {
    	        component.setError(true);
    	    }
    	});
    	
    	
    	
    }
    
    private Object doLogin(String value, String value2) {
		// TODO Auto-generated method stub
		return null;
	}

	private boolean authenticate(LoginEvent e) {
		// TODO Auto-generated method stub
    	if (emailInput.equals("admin@mno.com") && passInput.equals("admin")) {            // LAST
    		return userLoggedIn = true;
    		
    	}
		return userLoggedIn = false;
		
	}

	private void navigateToMainPage() {
		// TODO Auto-generated method stub
	}

	private void initForLogin() {
		// TODO Auto-generated method stub
    	this.displayView = DISPLAY_VIEW.LOGIN;
    	
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
