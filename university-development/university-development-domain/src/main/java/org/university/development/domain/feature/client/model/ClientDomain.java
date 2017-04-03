package org.university.development.domain.feature.client.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.university.development.commons.enumeration.ClientType;
import org.university.development.commons.enumeration.Gender;
import org.university.development.domain.feature.commons.model.AbstractDomain;

public class ClientDomain
    extends AbstractDomain {

    private static final long serialVersionUID = 1L;

    public interface AddValidations {
    }

    public interface UpdateValidations {
    }

    private String id;

    @NotNull(groups = {AddValidations.class}, message = "Name must not be null")
    @Size(min = 2, max = 10, groups = {AddValidations.class, UpdateValidations.class}, message = "Name must be between {min} and {max} chars")
    private String name;

    @NotNull(groups = {AddValidations.class}, message = "Type must not be null")
    private ClientType type;

    @NotNull(groups = {AddValidations.class}, message = "Gender must not be null")
    private Gender gender;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClientType getType() {
        return this.type;
    }

    public void setType(ClientType type) {
        this.type = type;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "ClientDomain [id=" + this.id + ", name=" + this.name + ", type=" + this.type + ", gender=" + this.gender
            + "]";
    }

}
