package com.gmail.stefan.ui.views.login;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.atmosphere.config.service.Message;

import com.gmail.stefan.backend.Author;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.charts.model.LayoutDirection;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.data.renderer.Renderer;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.templatemodel.TemplateModel;

/**
 * A Designer generated component for the logout-test template.
 *
 * Designer will add and remove fields with @Id mappings but does not overwrite
 * or otherwise change this file.
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

	@Id("btnReturn")
	private Button btnReturn;

	@Id("vaadinVerticalLayout")
	private VerticalLayout vaadinVerticalLayout;

	@Id("div")
	private Div div;

	/**
	 * Creates a new LogoutTest.
	 * 
	 * @throws SQLException
	 */
	public LogoutTest() throws SQLException {
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

		ComboBox<Author> comboBox = new ComboBox<Author>("Select an author:");
		comboBox.setItemLabelGenerator(Author::getName);
		List<Author> items = Service.selectAllAuthors();
		comboBox.setItems(items);
		comboBox.setWidthFull();

		if (comboBox.getValue() != null) {
			comboBox.addValueChangeListener(e -> {
				System.out.println("ComboBox null");
				Notification notification = Notification.show("Choose an author");
				notification.setPosition(Position.MIDDLE);
				notification.setDuration(1500);
			});

		} else {
			System.out.println("Combo box");
			comboBox.addValueChangeListener(e -> {
				System.out.println("ComboBox selected");
				Notification notification = Notification
						.show("Hello " + comboBox.getValue().getName() + ", here is your data.");
				notification.setPosition(Position.MIDDLE);
				notification.setDuration(1500);
			});
		}

		Grid<Author> grid = new Grid<>(Author.class); // TOOD create Data Provider for Grid
		grid.setSizeFull();
//    	grid.addColumn(Author::getId).setHeader("Author ID");
//    	grid.addColumn(Author::getName).setHeader("Author name");
//    	grid.addColumn(Author::getDate).setHeader("Date joined");
		List<Author> aList = Service.selectFromAuthors();
		grid.setItems(aList);
		grid.setWidth("600px");
		grid.setHeight("400px");
		grid.addComponentColumn(a -> {											//using component renderer
			Button b = new Button("Check "+ a.getName());
			b.addClickListener(e->{
					Notification.show("sdafasdf" + a.getName()).setPosition(Position.MIDDLE);
			});
			return b;
		});
		vaadinHorizontalLayout.add(grid);
		vaadinHorizontalLayout.setAlignItems(Alignment.CENTER);

//    	String AuthorName =("select * from message where authorname = "+ comboBox.getValue().getName());
		div.add(comboBox);
		div.add(grid);
		
		
	}

	/**
	 * This model binds properties between LogoutTest and logout-test
	 */
	public interface LogoutTestModel extends TemplateModel {
		// Add setters and getters for template properties here.
	}
}
