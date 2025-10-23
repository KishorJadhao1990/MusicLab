package com.eao.musiclab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author kishor
 * Created on 23/10/2025
 */
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "action", catalog = "musiclab")
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "action-seq")
    @SequenceGenerator(name = "action-seq", sequenceName = "action-seq", allocationSize = 1)
    private Integer id;

    @Column
    @Enumerated(EnumType.STRING)
    private ActionType type;

    @Column(name = "user_id")
    private Integer userId;

    public enum ActionType {
        LIKE, DISLIKE
    }
}