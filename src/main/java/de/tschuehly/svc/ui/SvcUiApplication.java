package de.tschuehly.svc.ui;

import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SvcUiApplication {

  public static void main(String[] args) {
    SpringApplication.run(SvcUiApplication.class, args);
  }

  // spring-view-component resolves precompiled templates from a class directory on disk,
  // which a native image does not have; load them from the classpath instead.
  @Bean
  @ConditionalOnProperty(name = "spring.view-component.local-development", havingValue = "false", matchIfMissing = true)
  TemplateEngine jteTemplateEngine() {
    return TemplateEngine.createPrecompiled(ContentType.Html);
  }

}
