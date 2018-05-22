/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Student
 */
public class Patient {
    private StringProperty  name, lastname;
    private ObjectProperty<LocalDate> date;
    
    public Patient(String name, String lastname, LocalDate date)
    {
        this.name = new SimpleStringProperty(name);
        this.lastname = new SimpleStringProperty(lastname);
        this.date = new SimpleObjectProperty<LocalDate>(date);
    }

	public LocalDate getDateAsLocalDate() {
		return date.get();
	}

    public ObjectProperty<LocalDate> getDate() {
        return date;
    }

	public void setDate(LocalDate date) {
		this.date.set(date);
	}


    public StringProperty getName() {
        return name;
    }
    public String getNameAsString() {
        return name.get();
    }
    public StringProperty getLastname() {
        return lastname;
    }
    public String getLastnameAsString() {
        return lastname.get();
    }

    public void setName(StringProperty name) {
        this.name = name;
    }

    public void setLastname(StringProperty lastname) {
        this.lastname = lastname;
    }

    
}
