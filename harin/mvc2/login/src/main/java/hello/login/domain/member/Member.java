package hello.login.domain.member;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class Member {
    private Long id;
    @NotEmpty
    private String loginId; //로그인아이디
    @NotEmpty
    private String name; //유저이름
    @NotEmpty
    private String password;
}
