package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Note;

/**
 * NoteService
 */
public interface NoteService {
    List<Note> findAll();

    Note findById(Long noteId);

    boolean updateNote(Long noteId, Note note);

    boolean deleteNote(Long noteId);

    Note createNote(Note note);
}