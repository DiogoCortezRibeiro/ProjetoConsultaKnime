package automatiza.knime.dbConfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
@EnableJpaRepositories(
		basePackages  = {"automatiza.knime.controller.oracle.dto"},
		entityManagerFactoryRef = "oracleEntityManager")
public class OracleDbConfig {
	
	@Primary
	@Bean
	@ConfigurationProperties(prefix = "oracle.datasource")
	public DataSource oracleDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Primary
	@Bean
	public LocalContainerEntityManagerFactoryBean oracleEntityManager(org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder builder, @Qualifier("oracleDataSource") DataSource dataSource) {
		return builder
				.dataSource(dataSource)
				.packages("automatiza.knime.model.oracle")
				.build();
	}
}
