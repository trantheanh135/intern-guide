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

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "group_student")
@Where(clause = "deleted_at is null")
public class GroupStudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private GroupEntity group;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private AccountEntity student;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private CourseEntity course;

    @Column(name = "absent" , nullable = true)
    private byte absent;

    @Column(name = "present" , nullable = true)
    private byte present;

    @Column(name = "created_at" , nullable = true)
    private LocalDateTime createdAt;

    @Column(name = "updated_at" , nullable = true)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at" , nullable = true)
    private LocalDateTime deletedAt;
}