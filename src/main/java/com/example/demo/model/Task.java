package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String topic;
    private LocalDate deadline;
    private boolean ended;

    @Column(length = 6000, columnDefinition = "text")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserWorker userWorker;
}
