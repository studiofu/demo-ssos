package lc.cds.ui.view.function;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;
import org.springframework.scheduling.config.ScheduledTask;
import org.vaadin.viritin.button.DownloadButton;
import org.vaadin.viritin.button.MButton;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.data.TreeData;
import com.vaadin.data.provider.TreeDataProvider;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.AbstractErrorMessage.ContentMode;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Tree;
import com.vaadin.ui.Tree.TreeContextClickEvent;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.Design;

import lc.cds.database.model.hsql.User;
import lc.cds.database.model.hsql.UserRepository;
import lc.cds.ui.navigation.NavigationManager;
import lc.cds.ui.view.BaseView;

@SuppressWarnings("serial")
@SpringView(name = TestingView.VIEW_NAME)
@DesignRoot
public class TestingView extends BaseView {
	
	// default view name	
	public static final String VIEW_NAME = "testing";
	
	// template path
	protected final String templatePath = "/ui/template/TestingView.html";
	
	@Autowired
	protected UserRepository userRepository;
	
	@Autowired	
	@Qualifier("h2-user-repository")
	protected lc.cds.database.model.h2.UserRepository userRepository2;
		
	/** UI components **/
	private Panel testingContentPanel;	
	private Tree<String> testingTree;
	
		
	public TestingView() {
		Design.read(templatePath, this);
	}
		
	@PostConstruct
	public void init() {
		
		

		
		
		// An initial planet tree
		TreeData<String> treeData = new TreeData<>();

		// Couple of childless root items
		treeData.addItem(null,"Mercury");
		treeData.addItem(null,"Venus");

		// Items with hierarchy
		treeData.addItem(null,"Earth");
		treeData.addItem("Earth","The Moon");

		TreeDataProvider inMemoryDataProvider = new TreeDataProvider<>(treeData);
		testingTree.setDataProvider(inMemoryDataProvider);
		testingTree.expand("Earth"); // Expand programmatically		
		
		// Add Mars with satellites
		treeData.addItem(null, "Mars");
		treeData.addItem("Mars", "Phobos");
		treeData.addItem("Mars", "Deimos");
	
		inMemoryDataProvider.refreshAll();

		
		testingTree.addItemClickListener(event ->
	    	Notification.show("Click", Notification.Type.HUMANIZED_MESSAGE)
	    	);
		
		
		testingTree.addContextClickListener(event -> Notification.show(
			        ((TreeContextClickEvent<String>)event).getItem() + " Clicked")
			  );
		
//		DummyProcess p = new DummyProcess();
//		
//		final DownloadButton pdfDownload = new DownloadButton(out -> p.exportPDF(out) );
//		pdfDownload.setFileName("lcs_report.pdf");
//		pdfDownload.setCaption("Test PDF Download");
//		
//		this.addComponent(pdfDownload);
		
		
		
		Button btn = new Button("Test Thread");
		
		btn.addClickListener(e-> {
			
//			Iterable<User> userList = new ArrayList<>();
//			userList = userRepository.findAll();
//			
//			for(User user: userList) {
//				System.out.println(user.getName());
//			}
			
			Iterable<lc.cds.database.model.h2.User> userList2 = new ArrayList<>();
			userList2 = userRepository2.findAll();
			
			
			System.out.println("query h2 database ");
			for(lc.cds.database.model.h2.User user: userList2) {
				System.out.println(user.getName());
			}
			
			lc.cds.database.model.h2.User a = new lc.cds.database.model.h2.User();
			a.setId(1000);
			a.setEmail("chubb.com");
			a.setName("hello");
			
			//userRepository2.save(a);
						
//		    new Thread(){
//		         public void run(){
//		        	 int i=0;
//		        	 while(true) {
//		        		 System.out.println(i++);
//		        		 try {
//							this.sleep(1000);
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//		        	 }
//		         }
//		    }.start();		
		    
		    
		});
		
		this.addComponent(btn);		
		

		
	}
	
	
	
    @Override
    public void enter(ViewChangeEvent event) {
    	
    	String params = event.getParameters();
    	System.out.println(params);
        // This view is constructed in the init() method()
    }	
	
	
}
