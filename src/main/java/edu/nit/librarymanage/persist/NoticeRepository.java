package edu.nit.librarymanage.persist;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<NoticeEntity, Long> {
}
