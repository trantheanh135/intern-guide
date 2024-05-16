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

import java.time.LocalDateTime;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "accounts")
@Where(clause = "deleted_at = null")
public class Accounts{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "role_id", nullable = false)
    private int roleId;

    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "username", nullable = false)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "status" , nullable = false)
    private byte status;

    @Column(name = "ip_client" , nullable = true)
    private String ipClient;

    @Column(name = "last_login" , nullable = false)
    private LocalDateTime lastLogin;

    @Column(name = "last_logout" , nullable = false)
    private LocalDateTime lastLogout;

    @Column(name = "created_at" , nullable = true)
    private LocalDateTime createdAt;

    @Column(name = "updated_at" , nullable = true)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at" , nullable = true)
    private LocalDateTime deletedAt;
}