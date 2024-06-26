package com.example.demo.repository.entity;

//import com.prasac.mbs.common.entity.Audit;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "accounts")
@Where(clause = "deleted_at is null")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private UserEntity user;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "status" )
    private AccountStatus status;

    @Column(name  = "created_at")
    private LocalDateTime createdAt;

    @Column(name  = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name  = "deleted_at")
    private LocalDateTime deletedAt;

    @OneToMany(mappedBy = "leader", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<DepartmentEntity> leaderDepartment;

    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
    private List<GroupEntity> teacherGroup;

    @OneToMany(mappedBy = "captain", fetch = FetchType.LAZY)
    private List<GroupEntity> captainGroup;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<GroupStudentEntity> studentGroupStudent;

    @OneToMany(mappedBy = "teahcerSchedule", fetch = FetchType.LAZY)
    private List<Schedule> teahcerSchedule;
}