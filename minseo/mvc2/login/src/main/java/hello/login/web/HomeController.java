package hello.login.web;

import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemberRepository memberRepository;

//    @GetMapping("/")
    public String home() {

        return "home";
    }

    /**
     * 로그인 쿠키가 없는 사용자는 기존 home으로 보낸다. 로그인 쿠키가 있어도 회원이 없으면 home으로 보낸다.
     * 로그인 쿠키가 있는 사용자는 로그인 사용자 전용 홈 화면인 loginHome으로 보낸다.
     * 화면에 회원 관련 정보를 출력하기 위해 member 데이터도 모델에 담아서 전달한다.
     */
    @GetMapping("/")
    public String homeLogin(
            @CookieValue(name = "memberId", required = false) Long memberId, Model model) {

        if (memberId == null) {
            return "home";
        }

        // 로그인
        Member loginMember = memberRepository.findById(memberId);
        if (loginMember == null) {
            return "home";
        }

        model.addAttribute("member", loginMember);
        return "loginHome";
    }
}