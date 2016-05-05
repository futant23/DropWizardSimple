/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaeeeee.dwstart.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 
 */
@XmlRootElement(name = "thing")
@XmlAccessorType (XmlAccessType.FIELD)
public class Thing {
    private String name;
    private String identifier;

    public Thing() {
    }

    public Thing(String name, String identifier) {
        this.name = name;
        this.identifier = identifier;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
    
    
}
