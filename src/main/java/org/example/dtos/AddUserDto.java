package org.example.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.example.models.Offer;
import org.example.models.UserRole;
import org.example.models.enums.Role;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

public class AddUserDto {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String imageUrl;
    private Role roleName;


    public Role getRoleName() {
        return roleName;
    }

    public void setRoleName(Role roleName) {
        this.roleName = roleName;
    }



    private Set<OfferDto> offers;

    public AddUserDto() {
    }

    @NotEmpty(message = "Username cannot be null or empty!")
    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }
    @NotEmpty(message = "Password cannot be null or empty!")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
@NotEmpty(message = "First name cannot be null or empty!")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
@NotEmpty(message = "Last name cannot be null or empty!")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
@NotEmpty(message = "Image url cannot be null or empty!")
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
}