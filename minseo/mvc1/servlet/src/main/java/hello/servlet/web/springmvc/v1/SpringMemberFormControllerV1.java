package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// @Controller: 스프링이 자동으로 스프링 빈으로 등록한다.
// 내부에 @Component 어노테이션이 있어서 컴포넌트 스캔 -> 스프링 빈 등록의 대상이 된다.
@Controller
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process() {
        return new ModelAndView("new-form");
    }
}
