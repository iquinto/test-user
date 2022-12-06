package edu.uoc.epcsd.user.application.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.uoc.epcsd.user.domain.Category;
import lombok.Getter;

import javax.validation.constraints.NotNull;

public class CreateCategoryRequest {

    @Getter
    @NotNull
    private final Category category;

    @JsonCreator
    public CreateCategoryRequest(@JsonProperty("category") @NotNull final Category category) {
        this.category = category;
    }
}
