package com.adamsware.moss.repository;

import com.adamsware.moss.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository <Session, Long> {

}
