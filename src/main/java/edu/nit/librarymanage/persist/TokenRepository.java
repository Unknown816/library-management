package edu.nit.librarymanage.persist;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<TokenEntity,Long> {
}