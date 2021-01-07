package edu.nit.librarymanage.persist;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TalkRepository extends JpaRepository<TalkEntity, Long> {
}
