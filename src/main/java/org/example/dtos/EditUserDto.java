package org.example.dtos;

import jakarta.validation.constraints.NotEmpty;
import org.example.models.enums.Role;

import java.util.Set;
import java.util.UUID;

public class EditUserDto {

    private UUID id;



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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    private Set<OfferDto> offers;

    public EditUserDto() {
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