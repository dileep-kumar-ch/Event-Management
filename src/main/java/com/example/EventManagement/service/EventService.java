package com.example.EventManagement.service;

import java.util.List;

import com.example.EventManagement.model.Event;

public interface EventService {

    // CREATE
    Event createEvent(Event event);

    // READ ALL
    List<Event> getAllEvents();

    // READ BY ID
    Event getEventById(Long id);

    // UPDATE
    Event updateEvent(Long id, Event event);

    // DELETE
    void deleteEvent(Long id);
}
