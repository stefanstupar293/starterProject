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
package com.gmail.stefan.ui;

import com.gmail.stefan.ui.views.beveragelist.BeverageList;
import com.gmail.stefan.ui.views.categorieslist.CategoriesList;
import com.gmail.stefan.ui.views.login.LoginTest;
import com.gmail.stefan.ui.views.login.LogoutTest;
import com.gmail.stefan.ui.views.reviewslist.ReviewsList;
import com.gmail.stefan.ui.views.testlist.UsersList;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.InitialPageSettings;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.server.PageConfigurator;
import com.vaadin.flow.server.VaadinSession;



/**
 * The main layout contains the header with the navigation buttons, and the
 * child views below that.
 */
@CssImport(value = "./styles/view-styles.css", id = "view-styles")
@CssImport(value = "./styles/shared-styles.css", include = "view-styles")
@PWA(name = "Beverage Buddy", shortName = "BevBuddy")
@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")

public class MainLayout extends Div implements RouterLayout, PageConfigurator, BeforeEnterObserver {

	/**
	 * 
	 */
	private static final long serialVersionUID = 571498875689969135L;
	public String navigationTarget; 
	
//	List<PageInfo> pages = new ArrayList<>();
	
    public MainLayout() {
        H2 title = new H2("Beverage Buddy");
        title.addClassName("main-layout__title");
        
//        RouterLink login = new RouterLink();
//        login.add(new Icon(VaadinIcon.LOCK), new Text("Login"));
//        login.addClassName("main-layout__nav-item");

        RouterLink reviews = new RouterLink(null, ReviewsList.class);
        reviews.add(new Icon(VaadinIcon.LIST), new Text("Reviews"));
        reviews.addClassName("main-layout__nav-item");
        // Only show as active for the exact URL, but not for sub paths
        reviews.setHighlightCondition(HighlightConditions.sameLocation());
     
        RouterLink categories = new RouterLink(null, CategoriesList.class);
        categories.add(new Icon(VaadinIcon.ARCHIVES), new Text("Categories"));
        categories.addClassName("main-layout__nav-item");
        
        RouterLink beverages = new RouterLink(null, BeverageList.class);				//beverages
        beverages.add(new Icon (VaadinIcon.DROP), new Text("Beverages"));
        beverages.addClassName("main-layout__nav-item");
        
        RouterLink users = new RouterLink(null, UsersList.class);
        users.add(new Icon(VaadinIcon.USER), new Text("Users"));
        users.addClassName("main-layout__nav-item");
        
//        RouterLink login = new RouterLink(null, LoginTest.class);						// logout
//        login.add(new Icon(VaadinIcon.SIGN_OUT), new Text("Logout"));					// make new form for logout
//        login.addClassName("main-layout__nav-item");
        
//        RouterLink box = new RouterLink(null, AuthorComboBox.class);
//        box.add(new Icon (VaadinIcon.CHEVRON_CIRCLE_DOWN), new Text("Box"));
//        box.addClassName("main-layout__nav-item");
        
        RouterLink logout = new RouterLink(null, LogoutTest.class);
        logout.add(new Icon(VaadinIcon.SIGN_OUT), new Text("Logout"));
        logout.addClassName("main-layout__nav-item");
        
        

        Div navigation = new Div(reviews, categories, users, beverages, logout);   		
        navigation.addClassName("main-layout__nav");

        Div header = new Div(title, navigation);
        header.addClassName("main-layout__header");
        add(header);

        addClassName("main-layout");				
        

    }
    

    

    @Override
    public void configurePage(InitialPageSettings settings) {
        settings.addMetaTag("apple-mobile-web-app-capable", "yes");
        settings.addMetaTag("apple-mobile-web-app-status-bar-style", "black");
    }


	
	
	@Override
	public void beforeEnter(BeforeEnterEvent event) {
		
		
		if(VaadinSession.getCurrent().getAttribute("userLoggedIn") == null) {												// if user isn't logged in, deny application usage
			VaadinSession.getCurrent().setAttribute("intendedPath", event.getLocation().getPath());
			event.rerouteTo(LoginTest.class);
		}
			
		
		
		System.out.println("BeforeEnterEvent main");

		}
}
