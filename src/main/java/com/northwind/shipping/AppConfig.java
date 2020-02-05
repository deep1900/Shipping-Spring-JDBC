package com.northwind.shipping;

import com.northwind.shipping.repository.RepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com/northwind/shipping")
public class AppConfig
{

    private Environment env;

    public AppConfig(Environment env) {
        this.env = env;
    }


    @Bean
    public DataSource datasource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/shipping-db");
        dataSource.setUsername("root");
        dataSource.setPassword("password");

        return dataSource;
    }



    @Bean
    public RepositoryImpl repository(DataSource dataSource, SqlStatements sqlStatements){
        return new RepositoryImpl(dataSource,sqlStatements);
    }

}
