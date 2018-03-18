/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ap.WebNotes.controller;

import com.ap.WebNotes.model.Nota;
import com.ap.WebNotes.service.NoteService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author prof.andreapollini
 */
@Controller
public class WebNotesController {
    
    @Autowired
    private NoteService noteService;
    
    
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");
        List<Nota> listaNote = noteService.getAll();
        mav.addObject("listaNote", listaNote);
        mav.addObject("nota",new Nota());
        return mav;
    }
    
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ModelAndView add(@Valid Nota nota, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        noteService.saveNota(nota);
        List<Nota> listaNote = noteService.getAll();
        mav.addObject("listaNote", listaNote);
        mav.addObject("nota",new Nota());
        mav.setViewName("home");
        return mav;
    }
    @RequestMapping(value = "/edit/{notaId}",method = RequestMethod.GET)
    public ModelAndView update(@PathVariable Integer notaId) {
         ModelAndView mav = new ModelAndView();
         mav.addObject("nota",noteService.findById(notaId));
                 
                 
        mav.setViewName("edit_nota");
        return mav;
    }
    
    @RequestMapping(value = "/delete/{notaId}",method = RequestMethod.GET)
    public ModelAndView delete_confirm(@PathVariable Integer notaId) {
         ModelAndView mav = new ModelAndView();
        Optional<Nota> notaFound = noteService.findById(notaId);
        
         mav.addObject("nota",notaFound.get());
                 
                 
        mav.setViewName("delete_confirm");
        return mav;
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView do_update(@Valid Nota n, BindingResult bindingResult) {
        System.out.println(n.getId());
        noteService.saveNota(n);
        return new ModelAndView("redirect:/");
    }
    
    @RequestMapping(value = "/do_delete", method = RequestMethod.POST)
    public ModelAndView do_delete(@Valid Nota n, BindingResult bindingResult) {
        System.out.println(n.getId());
        noteService.deleteNota(n.getId());
        return new ModelAndView("redirect:/");
    }
    
}
