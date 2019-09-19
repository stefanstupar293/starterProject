import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;

/**
 * A Designer generated component for the login-test template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("login-test")
@JsModule("./src/views/login/login-test.js")
public class LoginTest extends PolymerTemplate<LoginTest.LoginTestModel> {

    @Id("vaadinLoginForm")
	private LoginForm vaadinLoginForm;
	@Id("vaadinButton")
	private Button vaadinButton;
	@Id("vaadinVerticalLayout")
	private VerticalLayout vaadinVerticalLayout;
	@Id("email")
	private EmailField email;

	/**
     * Creates a new LoginTest.
     */
    public LoginTest() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between LoginTest and login-test
     */
    public interface LoginTestModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
