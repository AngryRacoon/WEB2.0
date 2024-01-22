package org.example.dtos;

import org.example.models.Offer;
import org.example.models.UserRole;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

public class UserDto {
    private UUID id;
    private String username;
    private String firstName;
    private String lastName;
    private boolean isActive;

    public UserDto(String username, String lastName, String firstName, String imageUrl, Date created) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.imageUrl = imageUrl;
        this.created = created;

    }

    public Date getModified() {
        return modified;
    }

    public Date getCreated() {
        return created;
    }

    private String imageUrl;
    private Date modified;
    private Date created;

    private UserRoleDto role;
    private Set<XLightOfferDto> offers;

    public UserDto(){}

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
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

    public Set<XLightOfferDto> getOffers() {
        return offers;
    }

    public void setOffers(Set<XLightOfferDto> offers) {
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