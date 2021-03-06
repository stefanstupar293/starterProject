package com.gmail.stefan.ui.views.testlist;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.gmail.stefan.backend.User;
import com.gmail.stefan.backend.UserService;
import com.gmail.stefan.ui.common.AbstractEditorDialog;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.validator.StringLengthValidator;

public class UserEditorDialog extends AbstractEditorDialog<User> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7195703909287524231L;
	private transient UserService userService = UserService.getInstance();
	private final TextField Fname = new TextField ("First Name");
	private final TextField Lname = new TextField ("Last Name");
	private final TextField Email = new TextField ("Email");
	
	public UserEditorDialog(BiConsumer <User, Operation> saveHandler, Consumer<User> deleteHandler) {
		super("user", saveHandler, deleteHandler);
		
		createFnameField();
		createLnameField();
		createEmailField();
		
	}
	
	private void createFnameField() {
		Fname.setRequired(true);
		getFormLayout().add(Fname);
		
		getBinder().forField(Fname) 
			.withConverter(String::trim, String::trim)
			.withValidator(new StringLengthValidator("User name must contain at least 3 printable characters", 3 , null))
			.bind(User::getFname, User::setFname);
	}
	
	private void createLnameField() {
		Lname.setRequired(true);
		getFormLayout().add(Lname);
		
		getBinder().forField(Lname) 
			.withConverter(String::trim, String::trim)
			.withValidator(new StringLengthValidator("Last name must contain at least 3 printable characters", 3 , null))
			.bind(User::getLname, User::setLname);
	}
	
	
	private void createEmailField() {
		Email.setRequired(true);
		getFormLayout().add(Email);
		
		getBinder().forField(Email) 
			.withConverter(String::trim, String::trim)
			.withValidator(new StringLengthValidator("Email must contain at least 3 printable characters", 3 , null))
			.bind(User::getEmail, User::setEmail);
	}
	
	
	
	@Override
	protected void confirmDelete() {
		// TODO Auto-generated method stub
		openConfirmationDialog("Delete user",
                "Are you sure you want to delete the user “" + getCurrentItem().getFname() + "”?", "");
	}
}