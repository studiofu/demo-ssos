package lc.cds.ui.demo;

import java.io.IOException;
import java.util.Date;
import java.util.Locale;

import com.vaadin.annotations.Theme;
import com.vaadin.server.RequestHandler;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinResponse;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("valo")
@SpringUI(path = "/mydownload")
public class MyDownload extends UI {

	@Override
	protected void init(VaadinRequest request) {
		
//		System.out.println(request.getPathInfo());
//
//		// A request handler for generating some content
//		VaadinSession.getCurrent().addRequestHandler(new RequestHandler() {
//			@Override
//			public boolean handleRequest(VaadinSession session, VaadinRequest request, VaadinResponse response)
//					throws IOException {
//				
//				System.out.println(request.getPathInfo());
//				//if ("/mydownload".equals(request.getPathInfo())) {
//					// Generate a plain text document
//					response.setContentType("text/plain");
//					response.getWriter().append("Here's some dynamically generated content.\n");
//					response.getWriter().format(Locale.ENGLISH, "Time: %Tc\n", new Date());
//
//					// Use shared session data
//					response.getWriter().format("Session data: %s\n", session.getAttribute("mydata"));
//
//					return true; // We wrote a response
////				} else
////					return false; // No response was written
//			}
//		});

	}

}
