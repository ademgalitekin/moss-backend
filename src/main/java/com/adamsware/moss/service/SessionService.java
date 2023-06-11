package com.adamsware.moss.service;

import com.adamsware.moss.model.Session;
import com.adamsware.moss.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionService {

    private final SessionRepository sessionRepository;

    public boolean save (Session session) {
        session.setCreateDate(new Date());
        sessionRepository.save(session);
        return true;
    }

    public List<Session> getAll() {
        return sessionRepository.findAll();
    }
}
