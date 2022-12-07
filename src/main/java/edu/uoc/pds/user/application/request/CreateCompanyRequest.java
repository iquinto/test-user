package edu.uoc.pds.user.application.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.uoc.pds.user.domain.Company;
import lombok.Getter;

import javax.validation.constraints.NotNull;

public class CreateCompanyRequest {

    @Getter
    @NotNull
    private final Company company;

    @JsonCreator
    public CreateCompanyRequest(@JsonProperty("company") @NotNull final  Company company) {
        this.company = company;
    }
}
