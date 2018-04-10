package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Note;
import com.example.demo.repository.NoteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * NoteServiceImpl
 */
@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    NoteRepository noteRepository;

    @Override
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    @Override
    public Note findById(Long noteId) {
        try {
            return noteRepository.findById(noteId)
                    .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean updateNote(Long noteId, Note modifyNote) {
        Note note = findById(noteId);
        if (note == null)
            return false;
        try {
            note.setTitle(modifyNote.getTitle());
            note.setContent(modifyNote.getContent());
            noteRepository.save(note);
            return true;
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteNote(Long noteId) {
        try {
            Note note = this.findById(noteId);
            noteRepository.delete(note);
            return true;
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            return false;
        }

    }

}