package lc.cds.ui.demo;

import java.net.MalformedURLException;
import java.net.URL;

import com.vaadin.annotations.Theme;
import com.vaadin.server.BrowserWindowOpener;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.Page;
import com.vaadin.server.Resource;
import com.vaadin.server.UserError;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.JavaScript;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;


public class SampleTestingView extends VerticalLayout{
	
	public SampleTestingView() {
		
		HorizontalLayout labelLayout = new HorizontalLayout();
		labelLayout.addComponent(new Label("COMMON DOCUMENT SYSTEM"));
		
		labelLayout.setStyleName("header");
				
		addComponent(labelLayout);
												
		// Testing Components
		
		Panel p = new Panel();
		p.setCaption("Panel");
		p.addClickListener(e -> { Notification.show("Closing Panel"); p.setVisible(false); UI.getCurrent().setContent(new SampleLoginView());});
		addComponent(p);
				
		
		
		Window w = new Window();
		w.setCaption("<b><small>WINDOW TITLE</small></b>");		
		w.setCaptionAsHtml(true);
		
		w.setWidth("500px");
		w.setHeight("500px");
		w.center();
		w.setModal(false);
		VerticalLayout wLayout = new VerticalLayout();
		wLayout.addComponent(new Label("inside window"));		
		
		TextField tf = new TextField();	
		tf.addValueChangeListener(e-> {
			
			Notification.show("test" + tf.getValue());
		});
		wLayout.addComponent(tf);
		
		//IntegerRangeValidator i = new IntegerRangeValidator("integer please ", 10,50);
		
		UserError error = new UserError("this is user error");
		tf.setComponentError(error);
		tf.setDescription("ages");
		
		Button btn = new Button("Check");
		btn.addClickListener(e->{ int a = Integer.parseInt(tf.getValue()); Notification.show("" + a);});
		wLayout.addComponent(btn);
		
		w.setContent(wLayout);
		
		UI.getCurrent().addWindow(w);				

		
		Button button = new Button("Click me");
		URL url = null;
		try {
			url = new URL("http://www.packtpub.com/");
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();		
		}
		
//		Resource resource = new ExternalResource(url);	
//		BrowserWindowOpener opener = new BrowserWindowOpener(resource);
//		opener.setWindowName("_blank");
//		opener.extend(button);		
		
		button.addClickListener(e -> {
			
			Notification.show("Clicked");	
			String basepath = VaadinService.getCurrent()
	                  .getBaseDirectory().getAbsolutePath();
			
			System.err.println(basepath);
			
			Page.getCurrent().getJavaScript().execute("alert('hello')");
			JavaScript.getCurrent().execute("alert('hello !')");
		
		});
		
		wLayout.addComponent(button);	
		
		
				
		
	}

}
