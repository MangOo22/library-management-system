package com.example.library.service.impl;

import com.example.library.dto.PatronDTO;
import com.example.library.entity.Patron;
import com.example.library.exception.ResourceNotFoundException;
import com.example.library.repository.PatronRepository;
import com.example.library.service.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatronServiceImpl implements PatronService {

    @Autowired
    private PatronRepository patronRepository;

    @Override
    public List<PatronDTO> getAllPatrons() {
        return patronRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public PatronDTO getPatronById(Long id) {
        return patronRepository.findById(id).map(this::convertToDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Patron not found with id: " + id));
    }

    @Override
    public PatronDTO addPatron(PatronDTO patronDTO) {
        Patron patron = convertToEntity(patronDTO);
        patron = patronRepository.save(patron);
        return convertToDTO(patron);
    }

    @Override
    public PatronDTO updatePatron(Long id, PatronDTO patronDTO) {
        Patron patron = patronRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patron not found with id: " + id));
        patron.setName(patronDTO.getName());
        patronDTO.setContactInformation(patronDTO.getContactInformation());
        patron = patronRepository.save(patron);
        return convertToDTO(patron);
    }

    @Override
    public void deletePatron(Long id) {
        Patron patron = patronRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patron not found with id: " + id));
        patronRepository.delete(patron);
    }

    private PatronDTO convertToDTO(Patron patron) {
        PatronDTO patronDTO = new PatronDTO();
        patronDTO.setId(patron.getId());
        patronDTO.setName(patron.getName());
        patronDTO.setContactInformation(patronDTO.getContactInformation());
        return patronDTO;
    }

    private Patron convertToEntity(PatronDTO patronDTO) {
        Patron patron = new Patron();
        patron.setName(patronDTO.getName());
        patronDTO.setContactInformation(patronDTO.getContactInformation());
        return patron;
    }


}
