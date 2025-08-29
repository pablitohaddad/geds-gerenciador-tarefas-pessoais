package io.github.pablitohaddad.Gerenciador.de.Tarefas.Pessoais.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Gerenciador de tarefas pessoais")
                        .description("Uma api de gestão de tarefas pessoais")
                        .version("1.0.0")
                        .contact( new Contact()
                                .name("GEDS - Grupo de Estudo em Desenvolvimento de Software")
                                .url("https://github.com/pablitohaddad/geds-gestao-de-tarefas-pessoais")
                                .email("pablohaddad73@gmail.com")));
    }

}