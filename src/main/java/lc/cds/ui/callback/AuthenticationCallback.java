package lc.cds.ui.callback;

import elemental.json.JsonArray;
import lc.cds.ui.navigation.NavigationManager;
import lc.cds.ui.view.function.LandingView;

@SuppressWarnings("serial")
public class AuthenticationCallback implements com.vaadin.ui.JavaScriptFunction {
	
	NavigationManager navigationManager;
	
	public AuthenticationCallback(NavigationManager navigationManager) {
		this.navigationManager = navigationManager;
	}

	@Override
	public void call(JsonArray arguments) {
		
		System.out.println("AuthenticationCallback");
		navigationManager.navigateTo(LandingView.VIEW_NAME);
	}

}
