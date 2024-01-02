package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController //string 그대로 반환 (Controller는 view로 반환됨)
    public class LogTestController {

        //로그 선언
        // private final Logger log = LoggerFactory.getLogger(getClass());
        // or private static final Logger log = LoggerFactory.getLogger(Xxx.class)
        // or 클래스 레벨에 @Slf4j
        @GetMapping("/log-test")
    public String LogTest(){
        String name = "Spring";

        // level 설정
        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info("info log={}", name);
        log.warn("warn log={}", name);
        log.error("info log={}", name);

        return "ok";
    }
}
