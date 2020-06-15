package info.akazawa.sample;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootTemplateApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTemplateApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Show inspect the beans provided by Spring Boot!!!");
            List<String> beanList = Arrays.asList(ctx.getBeanDefinitionNames());
            beanList.stream().sorted().forEach(s -> System.out.println("【"+s+"】"));
            System.out.println("The Number of beanList is "+ beanList.size());
        };
    }
}
