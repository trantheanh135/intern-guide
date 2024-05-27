package com.example.demo.dto.TermDTO;

import com.example.demo.repository.entity.UserStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TermUpdateReq {
    private String name;
    private String Slug;
    private UserStatus status;
    private Integer year;
    private LocalDateTime updatedAt;
}
