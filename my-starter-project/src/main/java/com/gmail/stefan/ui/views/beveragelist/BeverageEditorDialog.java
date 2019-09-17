package com.gmail.stefan.ui.views.beveragelist;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.gmail.stefan.backend.Beverage;
import com.gmail.stefan.backend.BeverageService;
import com.gmail.stefan.ui.common.AbstractEditorDialog;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.validator.StringLengthValidator;

public class BeverageEditorDialog extends AbstractEditorDialog<Beverage> {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7500116468841573848L;

	private transient BeverageService beverageService = BeverageService.getInstance();
	
	private final TextField beverage = new TextField ("Beverage Name");
	private final TextField alc= new TextField ("Beverage alcohol content");
	
	
	public BeverageEditorDialog(BiConsumer <Beverage, Operation> saveHandler, Consumer<Beverage> deleteHandler) {
		super("beverage", saveHandler, deleteHandler);
		
		createBeverageField();
		createAlcField();
		
	}
	
	private void createBeverageField() {
		beverage.setRequired(true);
		getFormLayout().add(beverage);
		
		getBinder().forField(beverage) 
			.withConverter(String::trim, String::trim)
			.withValidator(new StringLengthValidator("Beverage name must contain at least 3 printable characters", 3 , null))
			.bind(Beverage::getBeverage, Beverage::setBeverage);
	}
	
	private void createAlcField() {
		alc.setRequired(true);
		getFormLayout().add(alc);
		
		getBinder().forField(alc) 
			.withConverter(String::trim, String::trim)
			.withValidator(new StringLengthValidator("Enter'%' after number, or Non-alcoholic if one.", 1 , null))
			.bind(Beverage::getAlc, Beverage::setAlc);
	}
	
	
	
	
	
//////////////////////////////////////////DELETE////////////////////////////////////	
	
	protected void confirmDelete() {
		
		openConfirmationDialog("Delete beverage",
                "Are you sure you want to delete the beverage “" + getCurrentItem().getBeverage() + "”?", "");
		
    
	}
}