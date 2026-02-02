package com.example.EventManagement.service;

import java.util.UUID;

import com.example.EventManagement.model.Event;

public interface EventService {

    Event createEvent(Event event);

    Event getEventById(UUID id);
}
