package com.gxy.vbook.pojo;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private Integer id;

    private String name;

    private String password;

    private String phone;

    private String email;

    private Double balance;

    private Integer role;
}