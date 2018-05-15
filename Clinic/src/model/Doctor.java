/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Student
 */
public class Doctor {
    private StringProperty  name, lastname;
    private ObjectProperty<Specialization> spec;
    
    public Doctor(String name, String lastname, Specialization sp)
    {
        this.name = new SimpleStringProperty(name);
        this.lastname = new SimpleStringProperty(lastname);
        this.spec = new SimpleObjectProperty(sp); 
    }

    public StringProperty getName() {
        return name;
    }
    
    public String getNameAsString() {
        return name.get();
    }
    
    public void setName(StringProperty name) {
        this.name = name;
    }

    public StringProperty getLastname() {
        return lastname;
    }
    public String getLastnameAsString() {
        return lastname.get();
    }

    public void setLastname(StringProperty lastname) {
        this.lastname = lastname;
    }

    public ObjectProperty<Specialization> getSpec() {
        return spec;
    }
    public Specialization getSpecialization() {
        return spec.get();
    }
    public void setSpec(ObjectProperty<Specialization> spec) {
        this.spec = spec;
    }
    
    
}
