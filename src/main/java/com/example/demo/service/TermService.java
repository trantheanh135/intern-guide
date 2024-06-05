package com.example.demo.service;

import com.example.demo.dto.TermDTO.TermCreateReq;
import com.example.demo.dto.TermDTO.TermUpdateReq;
import com.example.demo.repository.TermRepository;
import com.example.demo.repository.entity.TermEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TermService {
    private final TermRepository termRepository;

    @PreAuthorize("hasAnyAuthority('SCOPE_Admin')")
    public void createTerm(TermCreateReq request){
        TermEntity termEntity = new TermEntity();

        termEntity.setName(request.getName());
        termEntity.setSlug(request.getSlug());
        termEntity.setStatus(request.getStatus());
        termEntity.setYear(request.getYear());
        termEntity.setCreatedAt(LocalDateTime.now());

        termRepository.save(termEntity);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_Admin')")
    public void updateTerm(TermUpdateReq request, Long id){
        TermEntity termEntity = termRepository.findById(id).orElseThrow(() -> new RuntimeException("Term not found"));

        termEntity.setName(request.getName());
        termEntity.setSlug(request.getSlug());
        termEntity.setStatus(request.getStatus());
        termEntity.setYear(request.getYear());
        termEntity.setUpdatedAt(LocalDateTime.now());

        termRepository.save(termEntity);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_Admin')")
    public void deleteTerm(Long id){
        TermEntity termEntity = termRepository.findById(id).orElseThrow(() -> new RuntimeException("Term not found"));

        termEntity.setDeletedAt(LocalDateTime.now());

        termRepository.save(termEntity);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_Admin')")
    public TermEntity getTermById(Long id){
        return termRepository.findById(id).orElseThrow(() -> new RuntimeException("Term not found"));
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_Admin')")
    public List<TermEntity> getAllTerm(){
        return termRepository.findAll();
    }
}
