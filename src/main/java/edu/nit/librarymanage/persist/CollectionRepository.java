package edu.nit.librarymanage.persist;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectionRepository extends JpaRepository<CollectionEntity, Long> {
}
