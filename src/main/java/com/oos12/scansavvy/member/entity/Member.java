package com.oos12.scansavvy.member.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.lang.annotation.Documented;

@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter

public class Member {
    @Id
    private String id;
    @Setter
    @Getter
    private String name;
    private String email;
    private String password;
    private String phone;

    @Override
    public String toString(){
        return "Member{" +
                "id='" + id + '\'' +
                ", name='" + name +'\'' +
                ", email='" + email +'\'' +
                ", password=" + password +
                ", phone=" + phone +
                '}';
    }
}
