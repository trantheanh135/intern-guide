package com.example.demo.dto.GroupDTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GroupDto {
    private String groupName;
    private int StudentNumber;
    private byte status;
    private String captain;
    private String department;
    private String teacher;
    private String term;
}
