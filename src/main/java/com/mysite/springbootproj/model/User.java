package com.mysite.springbootproj.model;

import jakarta.persistence.*;
import lombok.Data;

@Data // аннотация @Data генерирует геттеры, сеттеры, методы toString, equals и hashCode для всех полей класса
@Entity // это аннотация, которая указывает, что класс является сущностью базы данных
@Table(name = "users") // имя таблицы в базе данных, соответствующей этой сущности
public class User {
    @Id // поле id является первичным ключом сущности
    @GeneratedValue(strategy = GenerationType.IDENTITY) // значения id будут генерироваться автоматически при добавлении нового объекта в базу данных
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
}