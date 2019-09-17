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
package com.gmail.stefan.ui.views.beveragelist;

import java.util.List;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyModifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.Grid.SelectionMode;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.gmail.stefan.backend.Beverage;
import com.gmail.stefan.backend.BeverageService;

import com.gmail.stefan.ui.MainLayout;
import com.gmail.stefan.ui.common.AbstractEditorDialog;

/**
 * Displays the list of available categories, with a search filter as well as
 * buttons to add a new category or edit existing ones.
 */
@Route(value = "beverages", layout = MainLayout.class)
@PageTitle("Beverage List")
public class BeverageList extends VerticalLayout {

    private final TextField searchField = new TextField("",
            "Search beverages");
    private final H2 header = new H2("Beverages");
    private final Grid<Beverage> grid = new Grid<>();

    private final BeverageEditorDialog form = new BeverageEditorDialog(
            this::saveBeverage, this::deleteBeverage);

    public BeverageList() {
    
    	initView();
        addSearchBar();
        addContent();
        updateView();
    }

    private void initView() {
        addClassName("beverages-list");
        setDefaultHorizontalComponentAlignment(Alignment.STRETCH);
    }

    private void addSearchBar() {
        Div viewToolbar = new Div();
        viewToolbar.addClassName("view-toolbar");

        searchField.setPrefixComponent(new Icon("lumo", "search"));
        searchField.addClassName("view-toolbar__search-field");
        searchField.addValueChangeListener(e -> updateView());
        searchField.setValueChangeMode(ValueChangeMode.EAGER);
        searchField.addFocusShortcut(Key.KEY_F, KeyModifier.CONTROL);

        Button newButton = new Button("New beverage", new Icon("lumo", "plus"));
        newButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        newButton.addClassName("view-toolbar__button");
        newButton.addClickListener(e -> form.open(new Beverage(),
                AbstractEditorDialog.Operation.ADD));
        /*
            This is a fall-back method:
            '+' is not a event.code (DOM events), so as a fall-back shortcuts
            will perform a character-based comparison. Since Key.ADD changes
            locations frequently based on the keyboard language, we opted to use
            a character instead.
         */
        newButton.addClickShortcut(Key.of("+"));

        viewToolbar.add(searchField, newButton);
        add(viewToolbar);
    }

    private void addContent() {
        VerticalLayout container = new VerticalLayout();
        container.setClassName("view-container");
        container.setAlignItems(Alignment.STRETCH);
        
        grid.addColumn(Beverage::getId).setHeader("ID").setWidth("8em")
        		.setResizable(true);									
        grid.addColumn(Beverage::getBeverage).setHeader("Beverage").setWidth("6em");
        grid.addColumn(Beverage::getAlc).setHeader("Alcohol content").setWidth("6em");
        grid.addColumn(new ComponentRenderer<>(this::createEditButton))
                .setFlexGrow(0);
        grid.setSelectionMode(SelectionMode.NONE);

        container.add(header, grid);
        add(container);
    }

    private Button createEditButton(Beverage beverage) {
        Button edit = new Button("Edit", event -> form.open(beverage,
                AbstractEditorDialog.Operation.EDIT));
        edit.setIcon(new Icon("lumo", "edit"));
        edit.addClassName("review__edit");
        edit.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        
        return edit;
    }

  

    private void updateView() {
        List<Beverage> beverages = BeverageService.getInstance()
                .findBeverage(searchField.getValue());
        grid.setItems(beverages);

        if (searchField.getValue().length() > 0) {
            header.setText("Search for “" + searchField.getValue() + "”");
        } else {
            header.setText("Beverages");
        }
    }

    private void saveBeverage(Beverage beverage,													
            AbstractEditorDialog.Operation operation) {
        BeverageService.getInstance().doSaveBeverage(beverage);

        Notification.show(
                "User successfully " + operation.getNameInText() + "ed.",
                3000, Position.BOTTOM_START)
            .addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        updateView();
    }		

//////////////////////////////////////////DELETE////////////////////////////////////
    private void deleteBeverage(Beverage beverage) {
        List<Beverage> beverageInCategory = BeverageService.getInstance()
                .findBeverage(beverage.getBeverage());
        
      
        
     BeverageService.getInstance().deleteBeverage(beverage);

        Notification.show("Beverage successfully deleted.", 3000,
                Position.BOTTOM_START)
            .addThemeVariants(NotificationVariant.LUMO_CONTRAST);
        updateView();
    }
}
