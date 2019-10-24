/*
 * Copyright 2000-2017 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.gmail.stefan.ui.views.login;

import java.sql.SQLException;
import java.util.List;


import java.sql.DriverManager;
import com.gmail.stefan.backend.Author;
import com.gmail.stefan.ui.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.charts.model.Label;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.data.renderer.Renderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * Displays the list of available categories, with a search filter as well as
 * buttons to add a new category or edit existing ones.
 */
@Route(value = "author-list", layout = MainLayout.class)
@PageTitle("Author")

public class AuthorList extends VerticalLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8134451770825806303L;

	@Id("vaadinVerticalLayout")
	private VerticalLayout vaadinVerticalLayout;

	@Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;

	@Id("div")
	public Div div;

	public AuthorList() throws SQLException {

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
		grid.setWidthFull();
		grid.setHeightFull();
		
		grid.addComponentColumn(a -> { 						// using component renderer
			Button b = new Button("Get " + a.getName() + "'s ID");
			b.addClickListener(e -> {
				Notification.show(a.getName() + "'s ID is: " + a.getId()).setPosition(Position.MIDDLE);
			});
			return b;
		});
		grid.addComponentColumn(c->{
			Button d = new Button ("Hello");
			d.addClickListener(f -> {
				Notification.show(c.getName()).setPosition(Position.MIDDLE);;
				});
			return d;
		});
		
		add(comboBox);
		add(grid);
		
		
//    	String AuthorName =("select * from message where authorname = "+ comboBox.getValue().getName());

	}
}
