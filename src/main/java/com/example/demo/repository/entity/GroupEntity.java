package com.example.demo.repository.entity;

//import com.prasac.mbs.common.entity.Audit;
import jakarta.persistence.*;
//import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.List;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "groups")
@Where(clause = "deleted_at is null")
public class GroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentEntity department;

    @ManyToOne
    @JoinColumn(name = "term_id")
    private TermEntity term;

    @Column(name = "name")
    private String name;

    @Column(name = "slug")
    private String slug;

    @Column(name = "student_numbers" )
    private int studentNumber;

    @ManyToOne
    @JoinColumn(name = "teacher_id" )
    private AccountEntity teacher;

    @ManyToOne
    @JoinColumn(name = "captain_id" )
    private AccountEntity captain;

    @Column(name = "status" )
    private byte status;

    @Column(name = "created_at" , nullable = true)
    private LocalDateTime createdAt;

    @Column(name = "updated_at" , nullable = true)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at" , nullable = true)
    private LocalDateTime deletedAt;

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    private List<GroupStudentEntity> groupStudentList;

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    private List<Schedule> groupScheduleList;
}