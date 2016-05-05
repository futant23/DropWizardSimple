package com.javaeeeee.dwstart;

import com.commercehub.dropwizard.camel.ManagedCamelContext;
import com.commercehub.dropwizard.camel.ManagedProducerTemplate;
import com.javaeeeee.dwstart.resources.CamelRoutes;
import com.javaeeeee.dwstart.resources.HelloResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;

public class DWGettingStartedApplication extends Application<DWGettingStartedConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DWGettingStartedApplication().run(args);
    }

    @Override
    public String getName() {
        return "DWGettingStarted";
    }

    @Override
    public void initialize(final Bootstrap<DWGettingStartedConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final DWGettingStartedConfiguration configuration,
                    final Environment environment) throws Exception {
        environment.jersey().register(new HelloResource());
        
        
        CamelContext camelContext = new DefaultCamelContext();
        environment.lifecycle().manage(ManagedCamelContext.of(camelContext));

        ProducerTemplate producerTemplate = camelContext.createProducerTemplate();
        environment.lifecycle().manage(ManagedProducerTemplate.of(producerTemplate));
        
        camelContext.addRoutes(new CamelRoutes());
    }

}
