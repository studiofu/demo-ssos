package lc.cds.ui.demo;

import com.vaadin.annotations.JavaScript;
import com.vaadin.server.BrowserWindowOpener;
import com.vaadin.server.Page;
import com.vaadin.server.Resource;
import com.vaadin.server.StreamResource;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.ProgressBar;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;



public class SampleCrystalReportDownloadView extends VerticalLayout {

	public SampleCrystalReportDownloadView() {
				
		Label label = new Label("LCS Major Claim - Crystal Report...");
		label.setCaption("<small>LCS UAT 1</small>");
		label.setCaptionAsHtml(true);		
		
		
		HorizontalLayout horizontalLayout = new HorizontalLayout();
						
		Button generateButton = new Button("Generate PDF");		
		Button downloadButton = new Button("Download PDF ");
		downloadButton.setVisible(false);
		
		Button testButton = new Button("Test Button");
		
		ProgressBar progressBar = new ProgressBar();
		progressBar.setIndeterminate(true);
		progressBar.setVisible(false);
		
		
		horizontalLayout.addComponent(generateButton);
		horizontalLayout.addComponent(progressBar);
		horizontalLayout.addComponent(downloadButton);

		//horizontalLayout.addComponent(testButton);		
		
		testButton.setId("testButton");
		testButton.addClickListener(e -> {
			//Page.getCurrent().getJavaScript().execute("alert('yo...');");
			Page.getCurrent().getJavaScript().execute("$('#testButton').animate({width: '200px'});");
			Page.getCurrent().getJavaScript().execute("$('#testButton').text('============>');");
			
		});
				
				
		this.addComponent(label);
		
		this.addComponent(horizontalLayout);
		
		downloadButton.setEnabled(false);
		
		BrowserWindowOpener opener = new BrowserWindowOpener("");
		opener.extend(downloadButton);
		
		generateButton.setDisableOnClick(true);
		generateButton.addClickListener(e-> {
			
			label.setValue("LCS Major Claim - Crystal Report...");
			progressBar.setVisible(true);
			UI.getCurrent().push();
			//this.getUI().push();

			generateButton.setEnabled(false);
			
//			DummyProcess p = new DummyProcess();			
//			StreamResource resource = p.generatePDF();			
//
//			
//			opener.setResource(resource);			
//			opener.setWindowName("_blank");
//			opener.extend(downloadButton);
			
			downloadButton.setEnabled(true);
			downloadButton.setVisible(true);
			progressBar.setVisible(false);
			
			label.setValue("LCS Major Claim - Crystal Report...");			
			
		});
		
		
		
		downloadButton.setDisableOnClick(true);
		downloadButton.addClickListener(e -> {
			
			downloadButton.setVisible(false);
			downloadButton.setEnabled(false);
			generateButton.setEnabled(true);
			
			label.setValue("LCS Major Claim - Crystal Report");
						
		});
		
	}
	

}
