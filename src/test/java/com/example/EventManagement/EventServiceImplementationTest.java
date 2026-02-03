package com.example.EventManagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.EventManagement.exception.EventNotFoundException;
import com.example.EventManagement.model.Event;
import com.example.EventManagement.repository.EventRepository;
import com.example.EventManagement.service.EventServiceImplementation;

class EventServiceImplementationTest {

    @Mock
    private EventRepository repository;

    @InjectMocks
    private EventServiceImplementation service;

    private Event event;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);

        event = new Event();
        event.setId(1L);
        event.setTitle("Tech Event");
        event.setDescription("Spring Boot workshop");
        event.setLocation("Delhi");
        event.setStartTime(LocalDateTime.now());
        event.setEndTime(LocalDateTime.now().plusHours(2));
    }

    // ✅ createEvent test
    @Test
    void createEvent_shouldSaveEvent() {

        when(repository.save(any(Event.class))).thenReturn(event);

        Event saved = service.createEvent(event);

        assertNotNull(saved);
        assertEquals(1L, saved.getId());
        verify(repository, times(1)).save(event);
    }

    // ✅ getEventById success
    @Test
    void getEventById_shouldReturnEvent() {

        when(repository.findById(1L)).thenReturn(Optional.of(event));

        Event found = service.getEventById(1L);

        assertEquals("Tech Event", found.getTitle());
        verify(repository).findById(1L);
    }

    // ❌ getEventById failure
    @Test
    void getEventById_shouldThrowException() {

        when(repository.findById(2L)).thenReturn(Optional.empty());

        assertThrows(EventNotFoundException.class, () -> service.getEventById(2L));
    }
}
