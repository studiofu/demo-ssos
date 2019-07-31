package lc.cds.ui.view.function;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.DesignRoot;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.AbstractErrorMessage.ContentMode;
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
import lc.cds.ui.view.BaseView;

@SuppressWarnings("serial")
@SpringView(name = LandingView.VIEW_NAME)
@DesignRoot
public class LandingView extends BaseView {
	
	// default view name	
	public static final String VIEW_NAME = "landing";
	
	// template path
	protected final String templatePath = "/ui/template/LandingView.html";
	
	/** UI components **/
	private Label landingMainLabel;
		
	public LandingView() {
		Design.read(templatePath, this);
	}
		
	@PostConstruct
	public void init() {		
		//loginMainLayout.setSpacing(false);		
		
//		Label a = new Label();	
//		a.setContentMode(com.vaadin.shared.ui.ContentMode.HTML);
//		a.setValue(VaadinIcons.EDIT.getHtml());		
//		this.addComponent(a);
		
		//FontIcon edit = new FontIcon(VaadinIcons.EDIT);
		//Icon close = VaadinIcons.CLOSE.create();
		
	}
	
    @Override
    public void enter(ViewChangeEvent event) {
    	
    	String params = event.getParameters();
    	System.out.println(params);
        // This view is constructed in the init() method()
    }	
	
	
}
