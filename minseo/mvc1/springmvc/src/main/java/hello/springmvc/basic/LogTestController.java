package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {

    // private final Logger log = LoggerFactory.getLogger(getClass()); // LogTestController.class
    // @Slf4j 어노테이션으로 대체 가능

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        System.out.println("name = " + name); // 항상 띄워지므로 지양하자.

        // application.properties에서 띄우고 싶은 로그를 단계별로 설정 가능하다.
        log.trace("trace log={}", name);
        log.debug("debug log={}", name); // 개발 서버 수준
        log.info("info log={}", name); // 운영 서버 수준
        log.warn("warn log={}", name);
        log.error("error log={}", name);

        return "ok"; // RestController를 쓰면 이 값을 그대로 html body에 반환할 수 있다.
    }
}
