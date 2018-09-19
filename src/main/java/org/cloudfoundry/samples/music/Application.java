package org.cloudfoundry.samples.music;

import org.cloudfoundry.samples.music.config.SpringApplicationContextInitializer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.util.logging.Logger;

@EnableResourceServer
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    private static final Logger LOG = Logger.getLogger(Application.class.getName());
    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).
                initializers(new SpringApplicationContextInitializer())
                .application()
                .run(args);
    }
}