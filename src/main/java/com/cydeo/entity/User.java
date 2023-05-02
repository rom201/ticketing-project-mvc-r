package com.cydeo.entity;

import com.cydeo.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;


@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
@Where(clause = "is_deleted=false")// auto added to repository of this class
public class User extends BaseEntity{

    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private boolean enabled;
    private String phone;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;


}
