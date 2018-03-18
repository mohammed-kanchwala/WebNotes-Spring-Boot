/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ap.WebNotes.service;

import com.ap.WebNotes.model.Nota;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author prof.andreapollini
 */
public interface NoteService {
    public void saveNota(Nota n);
    public void update(Nota n);
    public List<Nota> getAll();

    public Optional<Nota> findById(Integer notaId);

    public void deleteNota(Integer id);
}
