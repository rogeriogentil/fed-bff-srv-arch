package rogeriogentil.srv.sample.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rogeriogentil.srv.sample.core.usecase.data.ToggleGateway;
import rogeriogentil.srv.sample.infrastructure.repository.gateway.JpaToggleGateway;

@Configuration
public class GatewayConfiguration {

    @Bean
    public ToggleGateway getToggleGateway() {
        return new JpaToggleGateway();
    }
}
