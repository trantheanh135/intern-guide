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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "departments")
@Where(clause = "deleted_at is null")
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "slug", nullable = false)
    private String slug;

    @ManyToOne
    @JoinColumn(name = "leader_id", nullable = false)
    private AccountEntity leader;

    @Column(name = "date_beginning", nullable = false)
    private LocalDate DateBeginning;

    @Column(name = "status")
    private byte status;

    @Column(name = "logo")
    private String logo;

    @Column(name = "created_at" , nullable = true)
    private LocalDateTime createdAt;

    @Column(name = "updated_at" , nullable = true)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at" , nullable = true)
    private LocalDateTime deletedAt;

    @OneToMany(mappedBy = "department")
    private List<CourseEntity> course;
}