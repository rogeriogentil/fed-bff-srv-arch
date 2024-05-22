package rogeriogentil.srv.sample.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rogeriogentil.srv.sample.core.usecase.*;
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

    @Bean
    public ToggleFeatureByKeyUseCase getToggleFeatureByKeyUseCase(
            FindToggleByKeyUseCase findToggleByKeyUseCase, ToggleGateway toggleGateway) {
        return new ToggleFeatureByKeyUseCaseImpl(findToggleByKeyUseCase, toggleGateway);
    }
}
