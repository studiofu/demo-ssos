package lc.cds.ui.demo;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class SampleLoginView extends VerticalLayout{

	private static final long serialVersionUID = 1L;
	
	public SampleLoginView() {
		Label name = new Label("Name");
		Label password = new Label("Password");
		
		this.addComponent(name);
		this.addComponent(password);
	}

}
