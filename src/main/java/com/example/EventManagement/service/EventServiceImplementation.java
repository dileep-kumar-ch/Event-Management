package com.example.EventManagement.service;

import java.util.List;

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

    // ================= CREATE EVENT =================

    @Override
    public Event createEvent(Event event) {
        return repository.save(event);
    }

    // ================= GET ALL EVENTS =================

    @Override
    public List<Event> getAllEvents() {
        return repository.findAll();
    }

    // ================= GET EVENT BY ID =================

    @Override
    public Event getEventById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EventNotFoundException("Event not found with id: " + id));
    }

    // ================= UPDATE EVENT =================

    @Override
    public Event updateEvent(Long id, Event event) {

        Event existingEvent = repository.findById(id)
                .orElseThrow(() -> new EventNotFoundException("Event not found with id: " + id));

        existingEvent.setTitle(event.getTitle());
        existingEvent.setDescription(event.getDescription());
        existingEvent.setLocation(event.getLocation());
        existingEvent.setStartTime(event.getStartTime());
        existingEvent.setEndTime(event.getEndTime());

        return repository.save(existingEvent);
    }

    // ================= DELETE EVENT =================

    @Override
    public void deleteEvent(Long id) {

        if (!repository.existsById(id)) {
            throw new EventNotFoundException("Event not found with id: " + id);
        }

        repository.deleteById(id);
    }
}
