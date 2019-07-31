package lc.cds.ui.view.login;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.DesignRoot;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.Design;

import lc.cds.ui.navigation.NavigationManager;

@SuppressWarnings("serial")
@SpringView(name = LoginView.VIEW_NAME)
@DesignRoot
public class LoginView extends VerticalLayout implements View {
	
	// default view name	
	public static final String VIEW_NAME = "login";
	
	// template path
	protected final String templatePath = "/ui/template/LoginView.html";
	
	/** UI components **/
	private HorizontalLayout loginMainLayout;
	private VerticalLayout loginInfoLayout;
	private VerticalLayout loginFormLayout;
	
	private Label loginInformationLabel;
	
	private TextField loginFormLoginTextField;
	private PasswordField loginFormPasswordPasswordField;
	
	private Button loginFormSubmitButton;
	
	@Autowired
	private NavigationManager navigationManager;
	
	public LoginView() {
		Design.read(templatePath, this);
	}
		
	@PostConstruct
	public void init() {		
		//loginMainLayout.setSpacing(false);
		
		loginFormSubmitButton.addClickListener(e -> {			
			//navigationManager.navigateTo(LoginAuthenticationView.VIEW_NAME);
			navigationManager.navigateTo(LoginAuthenticationView.class);
		});
				
		
		
	}
	
    @Override
    public void enter(ViewChangeEvent event) {
    	
    	String params = event.getParameters();
    	System.out.println(params);
        // This view is constructed in the init() method()
    }	
	
	
}
