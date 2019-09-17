package com.gmail.stefan.ui.views.login;



import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import com.vaadin.flow.templatemodel.TemplateModel;

/**
 * A Designer generated component for the login-buttons-bar.html template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("login-buttons-bar")
//@HtmlImport("src/views/login/login-buttons-bar.html")
//@JsModule("./src/views/login/login-buttons-bar.js")
public class LoginButtonsBar extends PolymerTemplate<LoginButtonsBar.LoginButtonsBarModel> implements LocaleChangeObserver{

	private static final long serialVersionUID = -1689908540263480549L;

	@Id("btnSubmit")
	private Button btnSubmit;
	@Id("btnForget")
	private Button btnForget;
	@Id("btnSwitch")
	private Button btnSwitch;

	/**
     * Creates a new LoginButtonsBar.
     */
    public LoginButtonsBar() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between LoginButtonsBar and login-buttons-bar.html
     */
    public interface LoginButtonsBarModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	public Button getBtnSubmit() {
		return btnSubmit;
	}

	public void setBtnSubmit(Button btnSubmit) {
		this.btnSubmit = btnSubmit;
	}

	public Button getBtnForget() {
		return btnForget;
	}

	public void setBtnForget(Button btnForget) {
		this.btnForget = btnForget;
	}

	public Button getBtnSwitch() {
		return btnSwitch;
	}

	public void setBtnSwitch(Button btnSwitch) {
		this.btnSwitch = btnSwitch;
	}

	@Override
	public void localeChange(LocaleChangeEvent arg0) {
		
		
	}
    
    
}
