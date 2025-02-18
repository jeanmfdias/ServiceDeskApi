package com.servicedesk.api.repositories;

import com.servicedesk.api.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public Page<User> findAllByDeletedAtIsNull(Pageable pageable);

}
