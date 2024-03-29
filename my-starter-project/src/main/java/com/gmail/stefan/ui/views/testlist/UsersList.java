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
package com.gmail.stefan.ui.views.testlist;

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
import com.gmail.stefan.backend.Category;
import com.gmail.stefan.backend.CategoryService;
import com.gmail.stefan.backend.Review;
import com.gmail.stefan.backend.ReviewService;
import com.gmail.stefan.backend.UserService;
import com.gmail.stefan.backend.User;
import com.gmail.stefan.ui.MainLayout;
import com.gmail.stefan.ui.common.AbstractEditorDialog;
import com.gmail.stefan.ui.common.AbstractEditorDialog.Operation;
import com.gmail.stefan.ui.views.categorieslist.CategoryEditorDialog;

/**
 * Displays the list of available categories, with a search filter as well as
 * buttons to add a new category or edit existing ones.
 */
@Route(value = "users", layout = MainLayout.class)
@PageTitle("Users List")
public class UsersList extends VerticalLayout {

    private final TextField searchField = new TextField("",
            "Search users");
    private final H2 header = new H2("Users");
    private final Grid<User> grid = new Grid<>();
	
   private final UserEditorDialog form =
		   new UserEditorDialog(this::saveUser, this::deleteUser);

       public UsersList() {
    	   
        initView();
        addSearchBar();
        addContent();
        updateView();

    }

    private void initView() {
        addClassName("users-list");
        setDefaultHorizontalComponentAlignment(Alignment.STRETCH);
    }

    private void addSearchBar() {
        Div viewToolbar = new Div();
        viewToolbar.addClassName("view-toolbar");

        searchField.setPrefixComponent(new Icon("lumo", "search"));
        searchField.addClassName("view-toolbar__search-field");
        searchField.addValueChangeListener(e -> updateView());       //        searchField.addValueChangeListener(e -> updateView2());
        searchField.setValueChangeMode(ValueChangeMode.EAGER);
        searchField.addFocusShortcut(Key.KEY_F, KeyModifier.CONTROL);

        Button addUser = new Button("New user", new Icon("lumo", "plus"));
        addUser.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        addUser.addClassName("view-toolbar__button");	
        addUser.addClickListener(clickEvent -> form.open(new User(),						//lambda 
        		AbstractEditorDialog.Operation.ADD));

        
        /*
            This is a fall-back method:
            '+' is not a event.code (DOM events), so as a fall-back shortcuts
            will perform a character-based comparison. Since Key.ADD changes
            locations frequently based on the keyboard language, we opted to use
            a character instead.
         */
        addUser.addClickShortcut(Key.of("+"));
        
        viewToolbar.add(searchField, addUser);
        add(viewToolbar);
    }



	private void addContent() {
        VerticalLayout container = new VerticalLayout();
        container.setClassName("view-container");
        container.setAlignItems(Alignment.STRETCH);

        grid.addColumn(User::getId).setHeader("ID").setWidth("8em")
                .setResizable(true);
        grid.addColumn(User::getEmail).setHeader("email")
                .setWidth("6em");
        grid.addColumn(User::getFname).setHeader("First Name")
        		.setWidth("6em");
        grid.addColumn(User::getLname).setHeader("Last Name")
				.setWidth("6em");
        grid.addColumn(new ComponentRenderer<>(this::createEditButton))
        .setFlexGrow(0);
        grid.setSelectionMode(SelectionMode.NONE);
        

        container.add(header, grid);
        add(container);
	}
	
	
	 private Button createEditButton(User user) {
	        Button edit = new Button("Edit", event -> form.open(user,
	                AbstractEditorDialog.Operation.EDIT));
	        edit.setIcon(new Icon("lumo", "edit"));
	        edit.addClassName("user__edit");
	        edit.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
	        
	        return edit;
	    }
	
	
	
	
//	private void openForm(User users2,
//            AbstractEditorDialog.Operation operation) {
//        // Add the form lazily as the UI is not yet initialized when
//        // this view is constructed
//        if (userForm.getElement().getParent() == null) {
//            getUI().ifPresent(ui -> ui.add(userForm));
//        }
//        openForm(users2, operation);
//    }

//   

//    private String getReviewCount(Category category) {											// count of reviews 
//        List<Review> reviewsInCategory = ReviewService.getInstance()
//                .findReviews(category.getName());
//        int sum = reviewsInCategory.stream().mapToInt(Review::getCount).sum();
//        return Integer.toString(sum);
//    }
//
//    private void updateView() {
//        List<Users> users = UserService.getInstance()
//        		.findUserByfName(searchField.getValue());
//        grid.setItems(users);
//
//        if (searchField.getValue().length() > 0) {
//            header.setText("Search for “" + searchField.getValue() + "”");
//        } else {
//            header.setText("Users");
//        }
//    }
    	

    	private void updateView() {																// search by ln, fn, email last version
    		 List<User> users = UserService.getInstance(
    				 ).findUser(searchField.getValue());
    		 	grid.setItems(users);
    		 if (searchField.getValue().length()>0) {
    			 header.setText("Search for“" + searchField.getValue()+ "”");
    		 } else {
    			 header.setText("Users");
    		 }
    	}
    	
    	
//    	private void updateView2() {   															// search by last name, added updateView2()
//    		List<User> users2 = UserService.getInstance()										// old version
//    				.findUserBylName(searchField.getValue());
//    		grid.setItems(users2);
//    		if (searchField.getValue().length()>0) {
//    			header.setText("Search for “" + searchField.getValue() + "”");
//    		}else {
//    			header.setText("Users");
//    			
//    		}
//    	}
    
    private void saveUser(User user,													//changed from users2 to user
            AbstractEditorDialog.Operation operation) {
        UserService.getInstance().doSaveUser(user);

        Notification.show(
                "User successfully " + operation.getNameInText() + "ed.",
                3000, Position.BOTTOM_START)
            .addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        updateView();
    }		

    
    private void deleteUser(User user) {
        List<User> usersInCategory = UserService.getInstance()
                .findUser(user.getFname());

//        reviewsInCategory.forEach(review -> {
//            review.setCategory(
//                    CategoryService.getInstance().getUndefinedCategory());
//            ReviewService.getInstance().saveReview(review);
//        });
        UserService.getInstance().deleteUser(user);

        Notification.show("User successfully deleted.", 3000,
                Position.BOTTOM_START)
            .addThemeVariants(NotificationVariant.LUMO_CONTRAST);
        updateView();
    }
}
