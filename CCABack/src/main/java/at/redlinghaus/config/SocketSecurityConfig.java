/*
package at.redlinghaus.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer;

@Configuration
@ComponentScan("at.redlinghaus")
public class SocketSecurityConfig extends AbstractSecurityWebSocketMessageBrokerConfigurer {

    @Override
    protected void configureInbound(
            MessageSecurityMetadataSourceRegistry messages) {
        messages
//                .simpDestMatchers("/secured/**").authenticated()
                .anyMessage().authenticated();
    }

    @Override
    protected boolean sameOriginDisabled() {
        return true;
    }
}*/
