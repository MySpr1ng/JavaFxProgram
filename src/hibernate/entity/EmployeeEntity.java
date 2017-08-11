package hibernate.entity;


import hibernate.enumtypes.Role;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Spring on 01.08.2017.
 */

@Entity
@Table(name = "emp")

public class EmployeeEntity {

    @Id
    @Column(name = "EMPLOYEE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "AGE")
    private int age;

    @Temporal(TemporalType.DATE)
    private Date employedDate;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @Enumerated(EnumType.ORDINAL)
    private Role role;

    public EmployeeEntity() {
    }

    public EmployeeEntity(String name, String surname, int age, Date employedDate, String login, String password, Role role) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.employedDate = employedDate;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getEmployedDate() {
        return employedDate;
    }

    public void setEmployedDate(Date employedDate) {
        this.employedDate = employedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", employedDate=" + employedDate +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
