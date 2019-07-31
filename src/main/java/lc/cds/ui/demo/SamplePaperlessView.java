package lc.cds.ui.demo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout.Alignment;

//import org.vaadin.addons.autocomplete.AutocompleteExtension;

import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class SamplePaperlessView extends VerticalLayout {

	public SamplePaperlessView() {
		this.setMargin(false);

		Label headerLabel = new Label("Paperless <small><i>827 UAT</i></small>", ContentMode.HTML);
		headerLabel.setCaptionAsHtml(true);
		headerLabel.setCaption("");
		
		
		
		VerticalLayout verticalLayout = new VerticalLayout();
		verticalLayout.addComponent(headerLabel);		
		//verticalLayout.setWidth("50em");
		
		TextField planetField = new TextField();
		verticalLayout.addComponent(planetField);
		
	    // Apply extension and set suggestion generator
//	    AutocompleteExtension<String> planetExtension = new AutocompleteExtension<>(planetField);
//	    planetExtension.setSuggestionGenerator(this::suggestPlanet);
	    
	    
	    
	    // Notify when suggestion is selected
//	    planetExtension.addSuggestionSelectListener(event -> {
//	        event.getSelectedItem().ifPresent(Notification::show);
//	    });
	    
	    
		Panel panel = new Panel();
		panel.setContent(verticalLayout);
		panel.setHeight("20em");
		panel.setWidth("50em");
		
		this.addComponent(panel);
		
	    

	}
	
    // Suggestion generator function, returns a list of suggestions for a user query
    private List<String> suggestPlanet(String query, int cap) {
        //return DataSource.getPlanets().stream().filter(p -> p.contains(query))
        //        .limit(cap).collect(Collectors.toList());
    	
    	
    	ArrayList<String> list = new ArrayList<String>();

    	list.add("apple");
    	list.add("orangle");
    	
    	list.add("number");
    	list.add("01234");
    	list.add("sun");
    	list.add("earth");
    	list.add("moon");
    	list.add("moon");
    	
    	return list;
    	
    }	
}
