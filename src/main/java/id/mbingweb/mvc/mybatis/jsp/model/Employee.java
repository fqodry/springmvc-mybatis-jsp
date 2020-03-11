package id.mbingweb.mvc.mybatis.jsp.model;

import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Employee {
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String password;
    private String email;
    private LocalDate dateOfBirth;

    public Employee(String username, String firstname, String lastname, String password, String email, LocalDate dateOfBirth) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }
}
