package com.digital_school.account.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class DefaultModel implements Serializable {
    @Id
    @Column(columnDefinition = "varchar(36)")
    private String id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist()
    protected void onCreate() {
        id= String.valueOf(UUID.randomUUID());
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
