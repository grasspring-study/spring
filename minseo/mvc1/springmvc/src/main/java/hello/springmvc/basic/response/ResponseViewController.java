package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello");

        return mav;
    }

    /**
     * 뷰의 논리 이름인 respone/hello를 반환하면
     * templates/response/hello.html 경로의 뷰 템플릿이 랜더링 된다.
     */
    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data", "hello");
        return "response/hello";
    }

    // 아래 방식은 명시성이 떨어지므로 권장하지 않는다.
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model) {
        model.addAttribute("data", "hello");
    }

    /**
     * @ResponseBody , HttpEntity 를 사용하면 뷰 템플릿을 사용하는 것이 아니라,
     * HTTP 메시지 바디에 직접 응답 데이터를 출력할 수 있다.
     */
}
