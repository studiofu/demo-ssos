package lc.cds.ui.view;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.View;
import com.vaadin.ui.CssLayout;

import lc.cds.ui.navigation.NavigationManager;

public class BaseView extends CssLayout implements View {
	@Autowired
	protected NavigationManager navigationManager;
}
