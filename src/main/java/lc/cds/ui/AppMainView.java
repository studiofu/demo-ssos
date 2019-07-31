package lc.cds.ui;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.DesignRoot;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.Design;

import lc.cds.ui.navigation.NavigationManager;
import lc.cds.ui.view.BaseView;
import lc.cds.ui.view.function.LandingView;
import lc.cds.ui.view.function.TestingView;
import lc.cds.ui.view.login.LoginView;

@SuppressWarnings("serial")
@SpringViewDisplay
@DesignRoot
public class AppMainView extends HorizontalLayout implements ViewDisplay {
	
	// template path
	protected final String templatePath = "/ui/template/AppMainView.html";
	
	@Autowired
	private NavigationManager navigationManager;
	
	private final Map<Class<? extends View>, Button> navigationButtons = new HashMap<>();
	
	private static final Logger logger = LoggerFactory.getLogger(AppMainView.class);
	
	/** UI components **/
	private CssLayout mainMenuCssLayout;
	private VerticalLayout mainContentVerticalLayout;		
	
	private Label mainMenuBarLogoLabel;
	private Button menuItemLogoutButton;
	private Button menuItemTestingButton;
		
	public AppMainView() {
		Design.read(templatePath, this);	
	}
		
	@PostConstruct
	public void init() {						
		mainMenuCssLayout.setVisible(false);	
		
		attachNavigation(menuItemLogoutButton, LoginView.class);
		attachNavigation(menuItemTestingButton, TestingView.class);
		
		logger.info("initialize the app main view");
	}
		
	private void attachNavigation(Button navigationButton, Class<? extends View> targetView) {

		navigationButtons.put(targetView, navigationButton);
		
		navigationButton.addClickListener(e-> {
			mainMenuCssLayout.setVisible(false);
			navigationManager.navigateTo(targetView);
		});
	}

	@Override
	public void showView(View view) { 
		
		// need to control menu visible in show view
		
		if(view instanceof BaseView) {
			mainMenuCssLayout.setVisible(true);
		}
				
		// apply the style to/from the button
		navigationButtons.forEach((viewClass, button) -> button.setStyleName("selected", viewClass == view.getClass()));
		
		mainContentVerticalLayout.removeAllComponents();
		mainContentVerticalLayout.addComponent(view.getViewComponent());
		
	}		
}
