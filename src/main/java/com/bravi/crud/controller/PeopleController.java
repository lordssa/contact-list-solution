package com.bravi.crud.controller;

import com.bravi.crud.controller.converter.PeopleResourceToPeopleConverter;
import com.bravi.crud.controller.converter.PeopleToPeopleResourceConverter;
import com.bravi.crud.controller.resource.PeopleResource;
import com.bravi.crud.usecase.people.AddPeopleUseCase;
import com.bravi.crud.usecase.people.DeletePeopleUseCase;
import com.bravi.crud.usecase.people.GetPeopleUseCase;
import com.bravi.crud.usecase.people.UpdatePeopleUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static java.util.Optional.ofNullable;

@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/v1/people")
public class PeopleController {

    private final PeopleResourceToPeopleConverter peopleResourceToPeopleConverter;
    private final PeopleToPeopleResourceConverter peopleToPeopleResourceConverter;
    private final AddPeopleUseCase addPeopleUseCase;
    private final UpdatePeopleUseCase updatePeopleUseCase;
    private final GetPeopleUseCase getPeopleUseCase;
    private final DeletePeopleUseCase deletePeopleUseCase;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public PeopleResource addPeople(@RequestBody @Valid final PeopleResource request){
        return ofNullable(request)
                .map(peopleResourceToPeopleConverter::convert)
                .map(addPeopleUseCase::execute)
                .map(peopleToPeopleResourceConverter::convert)
                .orElse(PeopleResource.builder().build());
    }

    @PutMapping
    @ResponseStatus(code = HttpStatus.OK)
    public PeopleResource updatePeople(@RequestBody @Valid final PeopleResource request){
        return ofNullable(request)
                .map(peopleResourceToPeopleConverter::convert)
                .map(updatePeopleUseCase::execute)
                .map(peopleToPeopleResourceConverter::convert)
                .orElse(PeopleResource.builder().build());
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public PeopleResource getPeople(@RequestParam(required = true) String idRequest){
        final var request = PeopleResource
                .builder()
                .id(idRequest)
                .build();

        return ofNullable(request)
                .map(peopleResourceToPeopleConverter::convert)
                .map(getPeopleUseCase::execute)
                .map(peopleToPeopleResourceConverter::convert)
                .orElse(PeopleResource.builder().build());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteBlacklistedPlayerById(@PathVariable final String id) {
        deletePeopleUseCase.execute(id);
    }
}
