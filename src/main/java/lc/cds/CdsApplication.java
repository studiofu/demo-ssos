package lc.cds;

import java.util.Arrays;



import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class CdsApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CdsApplication.class, args);
	}
	
	
//	   @Bean    
//	    public CommandLineRunner commandLineRunner(ApplicationContext ctx, PaperlessClient paperlessClient) {
//	        return args -> {
//	        	
//	            System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//	            String[] beanNames = ((ListableBeanFactory) ctx).getBeanDefinitionNames();
//	            
//	            Arrays.sort(beanNames);
//	            
//	            for (String beanName : beanNames) {
//	                System.out.println(beanName);
//	            }	        	
//	            
//	            					            
//	            GetCustomerFileListResponse response = paperlessClient.getCustomerFileList("8801646582");
//	            
//	            System.out.println(response);
//	            System.out.println(response.getGetCustomerFileListResult());
//	            
//
//	        };
//	 }
	
}
