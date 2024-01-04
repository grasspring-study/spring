package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {
    @RequestMapping("/response-view-1")
    public ModelAndView responseViewV1(){
        ModelAndView mav = new ModelAndView("/response/hello")
                .addObject("data", "hello!");
        return mav;
    }

    //@ResponseBody 쓰면 안됨
    @RequestMapping("/response-view-2")
    public String responseViewV2(Model model){
        model.addAttribute("data", "hello!");
        return "/response/hello"; //ModelAndView로 자동 매핑
    }

    // 추천 안함
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model){
        model.addAttribute("data", "hello!");
    }
}
