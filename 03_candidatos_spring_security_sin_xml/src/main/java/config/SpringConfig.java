package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration()
@ComponentScan(basePackages = "service")
@EnableJpaRepositories(basePackages = "dao", entityManagerFactoryRef = "factory", transactionManagerRef = "txManager")
@PropertySource(value = {"classpath:application.properties"})
public class SpringConfig {


	@Bean //para usar el datasource del servidor
    public DataSource dataSource2(@Value("${referencia}") String referencia) {
        JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
        dsLookup.setResourceRef(true);
        return dsLookup.getDataSource(referencia);
    }

	//adaptador de Hibernate
	@Bean
	public HibernateJpaVendorAdapter adapter() {
		HibernateJpaVendorAdapter adp=new HibernateJpaVendorAdapter();
		adp.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		return adp;
	}
	//factoria EntityManager: Objeto para acceder a capa de persistencia con JPA
	//con @Qualifier indicamos el datasource que queremos usar
	@Bean
	public LocalContainerEntityManagerFactoryBean factory(@Qualifier("dataSource2") DataSource dataSource,
			HibernateJpaVendorAdapter adapter, @Value("${pu}") String pu) {
		LocalContainerEntityManagerFactoryBean factory=new LocalContainerEntityManagerFactoryBean();
		factory.setPersistenceUnitName(pu);
		factory.setDataSource(dataSource);
		factory.setPackagesToScan("model");
		factory.setJpaVendorAdapter(adapter);
		return factory;
	}

	//gestor de transacción
	@Bean
	public JpaTransactionManager txManager(LocalContainerEntityManagerFactoryBean factory) {
		JpaTransactionManager manager=new JpaTransactionManager();
		manager.setEntityManagerFactory(factory.getObject());
		return manager;
	}
}