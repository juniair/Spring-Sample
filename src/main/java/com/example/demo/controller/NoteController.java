package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Note;
import com.example.demo.service.NoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/api/note")
/**
 * NoteController
 */
public class NoteController {

    @Autowired
    NoteService noteService;

    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public List<Note> findAll() {
        return noteService.findAll();
    }

    @RequestMapping(value = "find/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findNote(@PathVariable(value = "id") Long noteId) {
        try {
            Note note = noteService.findById(noteId);
            if (note == null)
                return ResponseEntity.notFound().build();

            return ResponseEntity.ok(note);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}