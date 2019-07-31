package lc.cds.ui.demo;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification;

public class StartView extends VerticalLayout implements View {
	
	Navigator navigator;
    
	public StartView(Navigator navigator) {
		
		this.navigator = navigator;
		
        setSizeFull();
                
		Button button = new Button("Go to Main View", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				navigator.navigateTo("main");
			}

		});
		
		button.setStyleName("lc-login-app");
		
        addComponent(button);
        setComponentAlignment(button, Alignment.MIDDLE_CENTER);
    }

    @Override
    public void enter(ViewChangeEvent event) {
        //Notification.show("Welcome to the Animal Farm");
    }
}