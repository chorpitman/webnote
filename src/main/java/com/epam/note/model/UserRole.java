package com.epam.note.model;

import com.epam.note.type.Role;

/**
 * Created by Oleg on 06.01.16.
 */
public class UserRole {
    private int id;
    private Role role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
