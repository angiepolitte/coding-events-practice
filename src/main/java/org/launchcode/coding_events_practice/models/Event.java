package org.launchcode.coding_events_practice.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class Event {
    private int id;
    private static int nextID = 1;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 50, message = "Enter between 3 and 50 characters")
    private String name;

    @NotNull
    @Size(max = 500, message = "Description too long")
    private String description;

    @NotNull
    @NotBlank
    @Email(message = "Invalid Email, Try Again")
    private String email;

    public Event(String name, String description, String email) {
        this.name = name;
        this.description = description;
        this.email = email;
        this.id = nextID;
        nextID++;
    }
    public Event() {};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
