package com.example.demo.controller;

import com.example.demo.dto.TermDTO.TermCreateReq;
import com.example.demo.dto.TermDTO.TermUpdateReq;
import com.example.demo.repository.TermRepository;
import com.example.demo.repository.entity.TermEntity;
import com.example.demo.service.TermService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/term")
public class TermController {
    private final TermService termService;

    @PostMapping()
    public String create(@RequestBody TermCreateReq termCreateReq){
        termService.createTerm(termCreateReq);
        return "success";
    }

    @PutMapping("/{id}")
    public String update(@RequestBody TermUpdateReq termUpdateReq, @PathVariable Long id){
        termService.updateTerm(termUpdateReq, id);
        return "success";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        termService.deleteTerm(id);
        return "success";
    }

    @GetMapping("/{id}")
    public TermEntity getTerm(@PathVariable Long id){
        return termService.getTermById(id);
    }

    @GetMapping()
    public List<TermEntity> getAllTerms(){
        return termService.getAllTerm();
    }
}
