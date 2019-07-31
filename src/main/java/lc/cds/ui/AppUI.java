package lc.cds.ui;

import javax.annotation.PostConstruct;

import org.hsqldb.util.DatabaseManagerSwing;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.AbstractErrorMessage.ContentMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import lc.cds.ui.demo.SampleCrystalReportDownloadExcelView;
import lc.cds.ui.demo.SampleCrystalReportDownloadView;
import lc.cds.ui.demo.SampleHeaderView;
import lc.cds.ui.demo.SamplePaperlessView;
import lc.cds.ui.navigation.NavigationManager;
import lc.cds.ui.view.login.LoginAuthenticationView;

//@Theme("valo")
@SuppressWarnings("serial")
@Theme("mytheme")
@SpringUI
@Push
//@UIScope
@Title("C.D.S.")
//@JavaScript({"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js",
//	"https://cdnjs.cloudflare.com/ajax/libs/animejs/2.2.0/anime.min.js",
//	"vaadin://js/login-authentication.js",
//	})
public class AppUI extends UI  {
		
	/** core navigation logic implemented in the navigation manager **/
	private final NavigationManager navigationManager;
			
	private final AppMainView appMainView;
		
	
	/** default constructor to initialize all the required class **/
	@Autowired
	public AppUI(NavigationManager navigationManager, AppMainView appMainView) {
		this.navigationManager = navigationManager;
		this.appMainView = appMainView;		
	}
	
	
	@Override
	protected void init(VaadinRequest request) {
								        
		String fragment = getPage().getUriFragment();
		
		if(fragment != null) {
			// need to add uri fragment change listener to handle when uri change
			System.out.println("url fragment: " + fragment);
			if(fragment.contains(LoginAuthenticationView.VIEW_NAME)) {
				System.out.println("navigate to "+ LoginAuthenticationView.VIEW_NAME);
				navigationManager.navigateTo(LoginAuthenticationView.VIEW_NAME);
			}
		}else {
			
	        // check login session and if no login information
	        // redirect to the login screen
	        //getUI().getPage().setLocation("/#!login");
			
			System.out.println("navigationManager.navigateToDefaultView();");
			
			navigationManager.navigateToDefaultView();
			
		}
		
		setContent(appMainView);						      						
	}
	



}
