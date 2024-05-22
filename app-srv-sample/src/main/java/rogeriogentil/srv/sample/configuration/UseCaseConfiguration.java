package rogeriogentil.srv.sample.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rogeriogentil.srv.sample.core.usecase.FindAllTogglesUseCase;
import rogeriogentil.srv.sample.core.usecase.FindAllTogglesUseCaseImpl;
import rogeriogentil.srv.sample.core.usecase.FindToggleByKeyUseCase;
import rogeriogentil.srv.sample.core.usecase.FindToggleByKeyUseCaseImpl;
import rogeriogentil.srv.sample.core.usecase.data.ToggleGateway;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public FindAllTogglesUseCase getFindAllTogglesUseCase(ToggleGateway toggleGateway) {
        return new FindAllTogglesUseCaseImpl(toggleGateway);
    }

    @Bean
    public FindToggleByKeyUseCase getFindToggleByKeyUseCase(ToggleGateway toggleGateway) {
        return new FindToggleByKeyUseCaseImpl(toggleGateway);
    }
}
