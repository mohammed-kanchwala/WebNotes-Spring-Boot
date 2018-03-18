/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ap.WebNotes.service;

import com.ap.WebNotes.model.Nota;
import com.ap.WebNotes.repository.NoteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("noteService")
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public void saveNota(Nota n) {
        noteRepository.save(n);
    }

    @Override
    public List<Nota> getAll() {
        return noteRepository.findAll();
    }

    @Override
    public void update(Nota n) {
        noteRepository.save(n);
    }

    @Override
    public Optional<Nota> findById(Integer notaId) {
        return noteRepository.findById(notaId);
    }

    @Override
    public void deleteNota(Integer id) {
        noteRepository.deleteById(id);
    }

}
