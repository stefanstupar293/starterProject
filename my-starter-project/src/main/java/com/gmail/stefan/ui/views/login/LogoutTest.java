package com.gmail.stefan.ui.views.login;
import com.vaadin.flow.templatemodel.TemplateModel;

import java.awt.Event;
import java.util.Optional;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.button.Button;

/**
 * A Designer generated component for the logout-test template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("logout-test")
@Route("logout")
@PageTitle("Logout")
@JsModule("./src/views/logout/logout-test.js")
public class LogoutTest extends PolymerTemplate<LogoutTest.LogoutTestModel> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5284565138158916037L;
	
	@Id("h2")
	private Element h2;
	@Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;
	@Id("btnLogout")
	private Button btnLogout;
	@Id("vaadinHorizontalLayout1")
	private HorizontalLayout vaadinHorizontalLayout1;
	@Id("btnReturn")
	private Button btnReturn;

	@Id("vaadinVerticalLayout")
	private VerticalLayout vaadinVerticalLayout;

	/**
     * Creates a new LogoutTest.
     */
    public LogoutTest() { 
        // You can initialise any data required for the connected UI components here.
    	btnLogout.addClickListener(e -> { 
			VaadinSession.getCurrent().setAttribute("userLoggedIn", null);
			Object intendedPath = VaadinSession.getCurrent().getAttribute("intendedPath");
			UI.getCurrent().navigate(Optional.ofNullable(intendedPath).map(Object::toString).orElse(""));
			System.out.println("Logged out");
		});
    	btnReturn.addClickListener(r -> {
    		Object intendedPath = VaadinSession.getCurrent().getAttribute("intendedPath");
    		UI.getCurrent().navigate(Optional.ofNullable(intendedPath).map(Object::toString).orElse(""));
    		System.out.println("Returned to the app");
    	});
    	
    }
    
    																		//TODO add return button which returns to Main View

    /**
     * This model binds properties between LogoutTest and logout-test
     */
    public interface LogoutTestModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
 