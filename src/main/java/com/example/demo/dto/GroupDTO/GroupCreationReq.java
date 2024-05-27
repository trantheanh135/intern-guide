package com.example.demo.dto.GroupDTO;

import com.example.demo.repository.entity.AccountEntity;
import com.example.demo.repository.entity.DepartmentEntity;
import com.example.demo.repository.entity.TermEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupCreationReq {
    private Long id;
    private String name;
    private String description;
    private Integer studentNumber;
    private String slug;
    private byte status;
    private Long captainId;
    private Long teacherId;
    private Long departmentId;
    private Long termId;
    private TermEntity term;
    private AccountEntity captain;
    private AccountEntity teacher;
    private DepartmentEntity department;
}
