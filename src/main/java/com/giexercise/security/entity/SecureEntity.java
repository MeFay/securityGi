package com.giexercise.security.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SecureEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(unique = true)
    private Integer id;
    @Column
    private String name;
    @Column
    private String password;
}
