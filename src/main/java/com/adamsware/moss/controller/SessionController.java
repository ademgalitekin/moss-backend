package com.adamsware.moss.controller;

import com.adamsware.moss.model.Session;
import com.adamsware.moss.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.adamsware.moss.constant.ResponseMessageConstant.*;
import static com.adamsware.moss.constant.RestPathConstant.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(SESSION)
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class SessionController {

    private final SessionService sessionService;

    @PostMapping(SAVE)
    public ResponseEntity <?> save (@RequestBody Session session) {
        boolean result = sessionService.save(session);
        if (result) {
            return ResponseEntity.ok().body(SESSION_SAVE_SUCCESS);
        }
        else {
            return ResponseEntity.internalServerError().body(SESSION_SAVE_FAILED);
        }
    }

    @GetMapping(GETALL)
    public List<Session> getAll () {
        for (Session session : sessionService.getAll()) {
            System.out.println(session.getPrice());
        }
        return sessionService.getAll ();
    }
}
