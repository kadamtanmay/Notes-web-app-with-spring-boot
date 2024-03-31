package com.becoder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.becoder.entity.Notes;
import com.becoder.entity.User;
import com.becoder.repository.NotesRepository;

@Service
public class NotesServiceImpl implements NotesService{

	@Autowired
	private NotesRepository notesRepository;
	
	@Override
	public Notes savaNotes(Notes notes) {
		// TODO Auto-generated method stub
		return notesRepository.save(notes);
	}

	@Override
	public Notes getNotesById(int id) {
		return notesRepository.findById(id).get();
	}

	@Override
	public Page<Notes> getNotesByUser(User user, int pageNo) {
		Pageable pageable = PageRequest.of(pageNo, 5);
		return notesRepository.findByUser(user, pageable);
	}

	@Override
	public Notes updateNotes(Notes notes) {
		
		return notesRepository.save(notes);
	}

	@Override
	public boolean deleteNotes(int id) {
		Notes notes = notesRepository.findById(id).get();
		
		if(notes != null) {
			notesRepository.delete(notes);
			return true;
		}
		return false;
	}

}
