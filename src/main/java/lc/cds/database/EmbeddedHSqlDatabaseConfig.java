package lc.cds.database;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hsqldb.util.DatabaseManagerSwing;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * The Spring JPA Configuration for the Embedded HSQL database.
 */
 @Configuration
 @EnableTransactionManagement
 @EnableJpaRepositories(
		 entityManagerFactoryRef = DatabaseConfigConstant.EMBEDDED_HSQL_ENTITY_MANAGER_FACTORY,
		 transactionManagerRef = DatabaseConfigConstant.EMBEDDED_HSQL_TRANSACTION_MANAGER, 
		 basePackages = {"lc.cds.database.model.hsql" })
public class EmbeddedHSqlDatabaseConfig {

	/**
	 * Initializes the data source.
	 *
	 * @return the initialized data source
	 */
	@Bean(name = DatabaseConfigConstant.EMBEDDED_HSQL_DATA_SOURCE)
	@ConfigurationProperties(prefix = "hsql.datasource")
	public DataSource dataSource() {
		
		// embedded database for HSQL example
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.HSQL)
				.addScript("db/sql/create-table.sql")
				.addScript("db/sql/insert-data-2.sql")
				.build();
		
		
		return db;
		
		// use normal connection string to create the HSQL
		// and use the value defined in the properties file
//		hsql.datasource.url=jdbc:hsqldb:file:/temp/db/data
//				hsql.datasource.jdbcUrl=${hsql.datasource.url}
//				hsql.datasource.username=sa
//				hsql.datasource.password=
//				hsql.datasource.driverClassName=org.hsqldb.jdbcDriver
		
//		return DataSourceBuilder				
//				.create()				
//				.build();
	}

	/**
	 * Creates the entity manager factory.
	 *
	 * @param builder
	 *            the entity manager factory builder
	 * @param dataSource
	 *            the data source
	 * @return the entity manager factory
	 */
	@Bean(name = DatabaseConfigConstant.EMBEDDED_HSQL_ENTITY_MANAGER_FACTORY)
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier(DatabaseConfigConstant.EMBEDDED_HSQL_DATA_SOURCE) DataSource dataSource) {
		return builder.dataSource(dataSource).packages("lc.cds.database.model.hsql").build();
	}

	/**
	 * Creates the transaction manager.
	 *
	 * @param entityManagerFactory
	 *            the entity manager factory
	 * @return the transaction manager
	 */
	@Bean(name = DatabaseConfigConstant.EMBEDDED_HSQL_TRANSACTION_MANAGER)
	public PlatformTransactionManager transactionManager(
			@Qualifier(DatabaseConfigConstant.EMBEDDED_HSQL_ENTITY_MANAGER_FACTORY) EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
	

}
