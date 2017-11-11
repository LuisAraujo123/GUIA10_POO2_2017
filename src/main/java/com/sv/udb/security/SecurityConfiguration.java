package com.sv.udb.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
		
	@Autowired
	DataSource dataSource;
	
	@Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().
		dataSource(dataSource).
		usersByUsernameQuery("select acce_usua, cont_usua, esta_usua from usuarios where acce_usua = ?").
		authoritiesByUsernameQuery("select acce_usua, nomb_perm from usuarios, permisos, permisos_usuarios where usuarios.codi_usua = permisos_usuarios.codi_usua and permisos_usuarios.codi_perm = permisos.codi_perm and acce_usua = ?");
    }
     
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       
      http.authorizeRequests()
        .antMatchers("/", "/home/").permitAll()
        .antMatchers("/tipos/**").access("hasRole('ROLE_ADMIN')")
        .antMatchers("/libros/**").access("hasRole('ROLE_ADMIN') and hasRole('ROLE_EDITOR')")
        .and().formLogin().loginPage("/home/login")
        .usernameParameter("acce_usua").passwordParameter("cont_usua")
        .and().csrf()
        .and().exceptionHandling().accessDeniedPage("/home/denegado");
    }
}
