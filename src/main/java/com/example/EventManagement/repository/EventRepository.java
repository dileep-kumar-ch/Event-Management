package com.example.EventManagement.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EventManagement.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
}
