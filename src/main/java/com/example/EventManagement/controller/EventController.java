package com.example.EventManagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.EventManagement.model.Event;
import com.example.EventManagement.service.EventService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    // ================= CREATE EVENT =================

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Event createEvent(@Valid @RequestBody Event event) {
        return service.createEvent(event);
    }

    // ================= GET ALL EVENTS =================

    @GetMapping
    public List<Event> getAllEvents() {
        return service.getAllEvents();
    }

    // ================= GET EVENT BY ID =================

    @GetMapping("/{id}")
    public Event getEventById(@PathVariable Long id) {
        return service.getEventById(id);
    }

    // ================= UPDATE EVENT =================

    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable Long id,
                             @Valid @RequestBody Event event) {
        return service.updateEvent(id, event);
    }

    // ================= DELETE EVENT =================

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEvent(@PathVariable Long id) {
        service.deleteEvent(id);
    }
}
