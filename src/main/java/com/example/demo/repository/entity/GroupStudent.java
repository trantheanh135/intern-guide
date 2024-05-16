package com.example.demo.repository.entity;

//import com.prasac.mbs.common.entity.Audit;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "group_student")
@Where(clause = "deleted_at = null")
public class GroupStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "group_id", nullable = false)
    private int groupId;

    @Column(name = "student_id", nullable = false)
    private int studentId;

    @Column(name = "course_id", nullable = false)
    private int courseId;

    @Column(name = "teacher_id" , nullable = false)
    private int TeacherId;

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