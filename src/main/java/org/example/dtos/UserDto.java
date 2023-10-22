package org.example.dtos;

import org.example.models.Offer;
import org.example.models.UserRole;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

public class UserDto {
    private UUID id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private boolean isActive;
    private String imageUrl;
    private Date modified;
    private Date created;

    private UserRoleDto role;
    private Set<OfferDto> offers;

    public UserDto(){}

    public UserDto(String username, String password, String firstName, String lastName, boolean isActive, String imageUrl, UserRoleDto role){

        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.imageUrl = imageUrl;
        this.role = role;
        this.created = new Date();
    }
    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Set<OfferDto> getOffers() {
        return offers;
    }

    public void setOffers(Set<OfferDto> offers) {
        this.offers = offers;
    }

    public UserRoleDto getRole() {
        return role;
    }

    public void setRole(UserRoleDto role) {
        this.role = role;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isActive() {
        return isActive;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}