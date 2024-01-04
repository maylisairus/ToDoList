package com.example.demo.services;

import com.example.demo.entities.Note;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoteService {
    private Map<Long, Note> notes = new HashMap<>();
    List<Note> listAll(){
        return notes.values().stream().toList();
    }

    Note add(Note note){
        Random random = new Random();
        long id = random.nextInt();
        note.setId(id);
        notes.put(id,note);
        return note;
    }

    void deleteById(long id) throws Exception{
        try {
            notes.remove(id);
        } catch(Exception ex){
            throw new Exception("Error during deleting note");
        }
    }

    void update(Note note) throws Exception{
        try{
            Note noteToChange = notes.get(note.getId());
            noteToChange.setContent(note.getContent());
            noteToChange.setName(note.getName());
        }
        catch(Exception ex){
            throw new Exception ("Error during updating note");
        }
    }

    Note getById(long id)throws Exception{
        try{

            return notes.get(id);
        }
        catch(Exception ex){
            throw new Exception ("Error during getting note");
        }
    }

}
