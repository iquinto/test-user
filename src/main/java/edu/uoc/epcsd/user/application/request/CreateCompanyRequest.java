package edu.uoc.epcsd.user.application.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.uoc.epcsd.user.domain.Category;
import edu.uoc.epcsd.user.domain.Company;
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
