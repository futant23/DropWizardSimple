/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaeeeee.dwstart.resources;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author 
 */
public class CamelRoutes extends RouteBuilder{

    private static final Logger log =LoggerFactory.getLogger(CamelRoutes.class);
    @Override
    public void configure() throws Exception {
        from("timer://thing?fixedRate=true&period=5s").to("log:info");
    }
}
