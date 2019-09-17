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
package com.gmail.stefan.ui.views.reviewslist;

import java.time.LocalDate;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.gmail.stefan.backend.Beverage;
import com.gmail.stefan.backend.BeverageService;
import com.gmail.stefan.backend.Category;
import com.gmail.stefan.backend.CategoryService;
import com.gmail.stefan.backend.Review;
import com.gmail.stefan.backend.ReviewService;
import com.gmail.stefan.backend.User;
import com.gmail.stefan.backend.UserService;
import com.gmail.stefan.ui.common.AbstractEditorDialog;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.converter.StringToIntegerConverter;
import com.vaadin.flow.data.validator.DateRangeValidator;
import com.vaadin.flow.data.validator.IntegerRangeValidator;

/**
 * A dialog for editing {@link Review} objects.
 */
public class ReviewEditorDialog extends AbstractEditorDialog<Review> {

    private transient CategoryService categoryService = CategoryService
            .getInstance();
    private transient UserService userService = UserService
    		.getInstance();
    private transient BeverageService beverageService = BeverageService
    		.getInstance();

    private ComboBox<Category> categoryBox = new ComboBox<>();
    private ComboBox<String> scoreBox = new ComboBox<>();
    private DatePicker lastTasted = new DatePicker();
//    private TextField beverageName = new TextField();
    private TextField timesTasted = new TextField();
    private ComboBox<User> lastTaster = new ComboBox<>();
    private ComboBox<Beverage> beveragedd = new ComboBox<>(); // new combo box

    public ReviewEditorDialog(BiConsumer<Review, Operation> saveHandler,
            Consumer<Review> deleteHandler) {
        super("review", saveHandler, deleteHandler);

//        createNameField();
        createBeverageBox();			//dd menu for beverages
        createCategoryBox();
        createDatePicker();
        createTimesField();
        createScoreBox();
        createTasterField();
    }

    private void createScoreBox() {
        scoreBox.setLabel("Rating");
        scoreBox.setRequired(true);
        scoreBox.setAllowCustomValue(false);
        scoreBox.setItems("1", "2", "3", "4", "5");
        getFormLayout().add(scoreBox);

        getBinder().forField(scoreBox)
                .withConverter(new StringToIntegerConverter(0,
                        "The score should be a number."))
                .withValidator(new IntegerRangeValidator(
                        "The tasting count must be between 1 and 5.", 1, 5))
                .bind(Review::getScore, Review::setScore);
    }

    private void createDatePicker() {
        lastTasted.setLabel("Last tasted");
        lastTasted.setRequired(true);
        lastTasted.setMax(LocalDate.now());
        lastTasted.setMin(LocalDate.of(1, 1, 1));
        lastTasted.setValue(LocalDate.now());
        getFormLayout().add(lastTasted);

        getBinder().forField(lastTasted)
                .withValidator(Objects::nonNull,
                        "The date should be in MM/dd/yyyy format.")
                .withValidator(new DateRangeValidator(
                        "The date should be neither Before Christ nor in the future.",
                        LocalDate.of(1, 1, 1), LocalDate.now()))
                .bind(Review::getDate, Review::setDate);

    }

    private void createCategoryBox() {
        categoryBox.setLabel("Category");
        categoryBox.setRequired(true);
        categoryBox.setItemLabelGenerator(Category::getName);
        categoryBox.setAllowCustomValue(false);
        categoryBox.setItems(categoryService.findCategories(""));
        getFormLayout().add(categoryBox);

        getBinder().forField(categoryBox)
                .withValidator(Objects::nonNull,
                        "The category should be defined.")
                .bind(Review::getCategory, Review::setCategory);
    }
    
    private void createBeverageBox() {
    	beveragedd.setLabel("Beverage");
    	beveragedd.setRequired(true);
    	beveragedd.setItemLabelGenerator(Beverage::getBeverage);
    	beveragedd.setAllowCustomValue(false);
    	beveragedd.setItems(beverageService.findBeverage(""));
    	getFormLayout().add(beveragedd);
    	
    	getBinder().forField(beveragedd)
    			.withValidator(Objects::nonNull, "Beverage should be defined.")
    			.bind(Review::getBeverage, Review::setBeverage);
    	
    }

    private void createTimesField() {
        timesTasted.setLabel("Times tasted");
        timesTasted.setRequired(true);
        timesTasted.setPattern("[0-9]*");
        timesTasted.setPreventInvalidInput(true);
        getFormLayout().add(timesTasted);

        getBinder().forField(timesTasted)
                .withConverter(
                        new StringToIntegerConverter(0, "Must enter a number."))
                .withValidator(new IntegerRangeValidator(
                        "The tasting count must be between 1 and 99.", 1, 99))
                .bind(Review::getCount, Review::setCount);
    }

//    private void createNameField() {
//        beverageName.setLabel("Beverage");
//        beverageName.setRequired(true);
//        getFormLayout().add(beverageName);
//
//        getBinder().forField(beverageName)
//                .withConverter(String::trim, String::trim)
//                .withValidator(new StringLengthValidator(
//                        "Beverage name must contain at least 3 printable characters",
//                        3, null))
//                .bind(Review::getName, Review::setName);
//    }

    private void createTasterField() {												// Taster field 
    	lastTaster.setLabel("Tester");
    	lastTaster.setRequired(true);
    	lastTaster.setItemLabelGenerator(User::getFname);
    	lastTaster.setAllowCustomValue(false);
    	lastTaster.setItems(userService.findUser(""));
    	getFormLayout().add(lastTaster);
    	
    	getBinder().forField(lastTaster).withValidator(Objects::nonNull, "The user must be selected.")
    	.bind(Review::getTaster, Review::setTaster);
    }
    
    
    
    
    
    
    

    @Override
    protected void confirmDelete() {
    	 
        openConfirmationDialog("Delete review",
                "Are you sure you want to delete the review for “" + getCurrentItem().getName() + "”?", "");
    

}
    
}
