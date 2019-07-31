package lc.cds.ui.view.login;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.DesignRoot;
import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.Push;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.declarative.Design;

import lc.cds.ui.callback.AuthenticationCallback;
import lc.cds.ui.navigation.NavigationManager;

@SuppressWarnings("serial")
@SpringView(name = LoginAuthenticationView.VIEW_NAME)
@DesignRoot
@JavaScript({
	//"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js",
	//"https://cdnjs.cloudflare.com/ajax/libs/animejs/2.2.0/anime.min.js",
	"vaadin://js/jquery-3.3.1.min.js",
	"vaadin://js/anime.min.js",
	"vaadin://js/login-authentication.js",
	})
public class LoginAuthenticationView extends CssLayout implements View {
	
	// default view name	
	public static final String VIEW_NAME = "authentication";
	
	// template path
	protected final String templatePath = "/ui/template/AuthenticationView.html";
	
	@Autowired
	private NavigationManager navigationManager;
	
	
	/** UI components **/
	private Label authenticationMainLabel;
	
	public LoginAuthenticationView() {
		Design.read(templatePath, this);
	}
		
	@PostConstruct
	public void init() {

	}
	
    @Override
    public void enter(ViewChangeEvent event) {
    	
		String params = event.getParameters();
		System.out.println(params);
		// This view is constructed in the init() method()

		System.out.println("enter authentication view");

		authenticationMainLabel.setStyleName("ml12");

		com.vaadin.ui.JavaScript cjs = com.vaadin.ui.JavaScript.getCurrent();

		cjs.addFunction("lc.cds.ui.callback.AuthenticationCallback",
				new AuthenticationCallback(this.navigationManager));

		UI.getCurrent().access(new Runnable() {
			@Override
			public void run() {
				cjs.execute("startAnime();");

				cjs.execute("setTimeout('lc.cds.ui.callback.AuthenticationCallback()' ,5000);");

				UI.getCurrent().push();
			}
		});    	
    }	
	
	
}
