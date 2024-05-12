package org.example.mpp_backend.repository;

import org.example.mpp_backend.entities.TiffRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiffRolesRepository extends JpaRepository<TiffRoles, Long> {
}
