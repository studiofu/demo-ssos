package lc.cds.ui.demo;

import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class SampleHeaderView extends VerticalLayout {

	public SampleHeaderView() {
		
		Panel panel = new Panel();
		
		
		Label headerLabel = new Label("COMMON DOCUMENT SYSTEM <small><i>alpha version 0.01</i></small>", ContentMode.HTML);
		headerLabel.setCaptionAsHtml(true);
		headerLabel.setCaption("");
		
		
		
		VerticalLayout verticalLayout = new VerticalLayout();
		verticalLayout.addComponent(headerLabel);
		
		panel.setContent(verticalLayout);		
		panel.setHeight("6em");
		panel.setWidth("50em");
		
		//this.setSizeFull();
		
		this.setMargin(false);
		this.addComponent(panel);
	}
}
