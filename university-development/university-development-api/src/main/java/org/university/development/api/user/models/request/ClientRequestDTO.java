package org.university.development.api.user.models.request;

import org.university.development.commons.enumeration.ClientType;
import org.university.development.commons.enumeration.Gender;

public class ClientRequestDTO
    extends AbstractRequestDTO {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private ClientType type;
    private Gender gender;

    public ClientRequestDTO() {
        super();
    }

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
        return "ClientRequestDTO [name=" + this.name + ", type=" + this.type + ", gender=" + this.gender + "]";
    }

}
