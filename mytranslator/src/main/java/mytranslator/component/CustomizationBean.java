package mytranslator.component;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.stereotype.Component;

/**
 * Configure properties
 * 
 * @author pborsoni
 *
 */
@Component
public class CustomizationBean implements EmbeddedServletContainerCustomizer {

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {

		// define main url
		container.setContextPath("/mytranslator");

		container.setPort(8090);

	}

}
