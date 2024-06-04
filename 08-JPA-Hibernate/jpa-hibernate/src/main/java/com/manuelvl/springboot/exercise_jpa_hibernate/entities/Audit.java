package com.manuelvl.springboot.exercise_jpa_hibernate.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
// Esta clase se va a embeber en Person (Aca incluimos lo que vamos a reutilizar en otras entidades)
@Embeddable
public class Audit {
    @Column(name = "created_at")
    LocalDateTime createdAt;

    @Column(name = "updated_at")
    LocalDateTime updatedAt;

    // PrePersist -> Se ejecuta antes de que se guarde el objeto en la base de datos
    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    // PreUpdate -> Se ejecuta antes de que se actualice el objeto en la base de datos
    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
