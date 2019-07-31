package lc.cds.ui.demo;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("valo")
@SpringUI(path="/ui")
@Title("My Vaadin UI")
public class MyUI extends UI {

	private static final long serialVersionUID = -3524980528319762184L;

	@Override
	protected void init(VaadinRequest request) {
		
		final VerticalLayout layout = new VerticalLayout();
		
		HorizontalLayout labelLayout = new HorizontalLayout();
		labelLayout.addComponent(new Label("Hello! I'm the root UI!"));
				
		layout.addComponent(labelLayout);
		 
		layout.addComponent(new SampleTestingView());
				
		setContent(layout);		
		 
	}
	
	private void testingPage() {	
		//this.setContent(new SampleTestingView());
		
		Page.getCurrent().setTitle("Common Document System");
		
		SampleHeaderView sampleHeaderView = new SampleHeaderView();
		SampleCrystalReportDownloadView sampleCrystalReportDownload = new SampleCrystalReportDownloadView();
		SampleCrystalReportDownloadExcelView sampleCrystalReportDownloadExcel = new SampleCrystalReportDownloadExcelView();
		
		VerticalLayout mainLayout = new VerticalLayout();		
		mainLayout.addComponent(sampleHeaderView);

		VerticalLayout contentLayout = new VerticalLayout();
		contentLayout.addComponent(sampleCrystalReportDownload);
		contentLayout.addComponent(sampleCrystalReportDownloadExcel);
		
		Panel mainPanel = new Panel();		
		mainPanel.setWidth("50em");
		
		mainPanel.setContent(contentLayout);
		
		mainLayout.addComponent(mainPanel);
		

		
		SamplePaperlessView samplePaperlessView = new SamplePaperlessView();
		mainLayout.addComponent(samplePaperlessView);		
		
		this.setContent(mainLayout);		
	}	
}
