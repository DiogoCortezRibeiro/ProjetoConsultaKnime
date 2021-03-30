package automatiza.knime.dbConfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;


@Configuration
@EnableJpaRepositories(
		basePackages  = {"automatiza.knime.controller.mysql.dto"},
		entityManagerFactoryRef = "mysqlEntityManager")
public class MysqlDbConfig {
	
	@Bean
	@ConfigurationProperties(prefix = "mysql.datasource")
	public javax.sql.DataSource mysqlDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean mysqlEntityManager(org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder builder, @Qualifier("mysqlDataSource") DataSource dataSource) {
		return builder
				.dataSource(dataSource)
				.packages("automatiza.knime.model.mysql")
				.build();
	}

}
