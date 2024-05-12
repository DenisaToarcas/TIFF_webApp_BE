package org.example.mpp_backend.repository;

import java.util.List;

public interface IRepository<EntityType, IDType> {
    EntityType getByID(IDType ID);

    void add(EntityType entity);

    EntityType update(IDType ID, EntityType entity);

    void delete(IDType ID);

    List<EntityType> getAll();

    int numberOfEntities();

    boolean contains(IDType ID);
}
