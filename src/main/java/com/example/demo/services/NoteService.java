package com.example.demo.services;

import com.example.demo.entities.Note;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoteService {
    private Map<Long, Note> notes = new HashMap<>();
    
    public List<Note> listAll(){
        return notes.values().stream().toList();
    }
    
    public Note add(Note note){
        Random random = new Random();
        long id = random.nextInt();
        note.setId(id);
        notes.put(id,note);
        return note;
    }

    public void deleteById(long id){
        try {
            notes.remove(id);
        } catch(Exception ex){
            throw new IllegalArgumentException("Error during deleting note");
        }
    }

    public void update(Note note) {
        try{
            Note noteToChange = notes.get(note.getId());
            noteToChange.setContent(note.getContent());
            noteToChange.setTitle(note.getTitle());
        }
        catch(Exception ex){
            throw new IllegalArgumentException ("Error during updating note");
        }
    }

    public Note getById(long id){
        try{

            return notes.get(id);
        }
        catch(Exception ex){
            throw new IllegalArgumentException ("Error during getting note");
        }
    }

}
