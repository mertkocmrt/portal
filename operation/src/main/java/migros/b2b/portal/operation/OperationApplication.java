package migros.b2b.portal.operation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@ComponentScan(basePackages = {"migros.b2b.portal.*"})
@PropertySources({
        @PropertySource(value = {"file:./portal-config-repository/application.properties","file:./portal-config-repository/application-dev.properties"
        ,"file:./portal-config-repository/application-test.properties","file:./portal-config-repository/application-prod.properties"},  ignoreResourceNotFound = true)
})
public class OperationApplication {
    public static void main(String[] args) {
        SpringApplication.run(OperationApplication.class, args);
    }

}
