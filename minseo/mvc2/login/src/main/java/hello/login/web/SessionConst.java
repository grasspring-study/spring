package hello.login.web;

/**
 * HttpSession에 데이터를 보관하고 조회할 때, 같은 이름이 중복 되어 사용되므로, 상수로 정의한다.
 */
public class SessionConst { // interface나 abstract class로 쓰는 것이 더 좋다.
    public static final String LOGIN_MEMBER = "loginMember";
}
