package lc.cds.ui.navigation;

import org.springframework.stereotype.Component;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.spring.internal.Conventions;
import com.vaadin.spring.navigator.SpringNavigator;
import com.vaadin.ui.UI;

import lc.cds.ui.view.login.LoginAuthenticationView;
import lc.cds.ui.view.login.LoginView;

@Component
@UIScope
public class NavigationManager extends SpringNavigator {
	
	
	public NavigationManager() {
		super();		
		//this.addView(LoginAuthenticationView.VIEW_NAME, new LoginAuthenticationView());
	}

	public void navigateToDefaultView() {		
		// check if the user has been login or not, else redirect to the login page		
		navigateTo(LoginView.VIEW_NAME);		
	}
		
	/**
	 * Find the view id (URI fragment) used for a given view class.
	 * 
	 * i.e. LoginView.class return => "login" as URI fragment  
	 *
	 * @param viewClass
	 *            the view class to find the id for
	 * @return the URI fragment for the view
	 */	
	public String getViewId(Class<? extends View> viewClass) {
		SpringView springView = viewClass.getAnnotation(SpringView.class);
		if (springView == null) {
			throw new IllegalArgumentException("The target class must be a @SpringView");
		}

		return Conventions.deriveMappingForView(viewClass, springView);
	}	
	
	
	/**
	 * Navigate to the given view class.
	 *
	 * @param viewClass
	 *            the class of the target view, must be annotated using
	 *            {@link SpringView @SpringView}
	 */
	public void navigateTo(Class<? extends View> targetView) {
		String viewId = getViewId(targetView);
		navigateTo(viewId);
	}

	public void navigateTo(Class<? extends View> targetView, Object parameter) {
		String viewId = getViewId(targetView);
		navigateTo(viewId + "/" + parameter.toString());
	}	
	
}
