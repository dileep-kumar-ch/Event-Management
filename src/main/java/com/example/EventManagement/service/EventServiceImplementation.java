package com.example.EventManagement.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.EventManagement.exception.EventNotFoundException;
import com.example.EventManagement.model.Event;
import com.example.EventManagement.repository.EventRepository;

@Service
public class EventServiceImplementation implements EventService {

    private final EventRepository repository;

    public EventServiceImplementation(EventRepository repository) {
        this.repository = repository;
    }

    @Override
    public Event createEvent(Event event) {
        return repository.save(event);
    }

    @Override
    public Event getEventById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EventNotFoundException("Event not found: " + id));
    }
}
