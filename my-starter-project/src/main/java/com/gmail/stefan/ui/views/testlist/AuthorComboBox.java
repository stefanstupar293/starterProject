package com.gmail.stefan.ui.views.testlist;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.gmail.stefan.backend.Author;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * A Designer generated component for the author-combo-box template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("author-combo-box")
@Route("box")
@PageTitle("Box")
@JsModule("./src/views/testlist/author-combo-box.js")
public class AuthorComboBox extends PolymerTemplate<AuthorComboBox.AuthorComboBoxModel> {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6354774779761743877L;

	@Id ("h3")
	private Element h3;
	@Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;
	
	
	/**
     * Creates a new AuthorComboBox.
     */
    public AuthorComboBox() {
        // You can initialise any data required for the connected UI components here.
    	
    	ComboBox<Author> comboBox = new ComboBox<>();
    	comboBox.setItems(Author.findAll());
    	comboBox.setItemLabelGenerator(Author::getName);
    	 

//    	Grid<Author> grid = new Grid<>();
//    	grid.addColumn(Author::getName);
//    	grid.addColumn(Author::getDate);
    }

    /**
     * This model binds properties between AuthorComboBox and author-combo-box
     */
    public interface AuthorComboBoxModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
