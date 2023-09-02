package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity //Entity는 DB 테이블을 의미함, JPA가 Entity를 읽어들임
@Data //getTitle을 하기위해서
public class Board {

    @Id // primaryKey를 의미
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본키  생성을 데이터베이스에게 위임하는 방식
    // 기본키를 자동으로 생성할 때에는 @Id와 @GenerratedValue 어노테이션이 함께 사용되어야 한다.
    private Integer id;
    private String title;
    private String content;
}
