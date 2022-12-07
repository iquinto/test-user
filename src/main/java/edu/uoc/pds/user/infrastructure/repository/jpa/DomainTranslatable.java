package edu.uoc.pds.user.infrastructure.repository.jpa;

public interface DomainTranslatable<T> {

    T toDomain();

}
