package hello.itemservice.message;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
public class MessageSourceTest {

    @Autowired
    MessageSource ms;

    @Test
    void helloMessage() {
        String result = ms.getMessage("hello", null, null); // locale 정보가 없으면 application.properties의 basename에서 설정한 기본 이름 메시지 파일을 조회한다.
        assertThat(result).isEqualTo("안녕");
    }

    /**
     *  assertThatThrownBy 메서드를 사용하여 "no_code"에 대한 메시지가 존재하지 않을 때
     *  NoSuchMessageException이 제대로 발생하는지 확인
     */
    @Test
    void notFoundMessageCode() {
        assertThatThrownBy(() -> ms.getMessage("no_code", null, null))
                .isInstanceOf(NoSuchMessageException.class); // 메시지가 없는 경우에는 NoSuchMessageException이 발생한다.
    }

    @Test
    void notFoundMessageCodeDefaultMessage() {
        String result = ms.getMessage("no_code", null, "기본 메시지", null);
        assertThat(result).isEqualTo("기본 메시지"); // 메시지가 없어도 기본 메시지(defaultMessage)를 사용하면 기본 메시지가 반환된다.
    }

    @Test
    void argumentMessage() {
        String result = ms.getMessage("hello.name", new Object[]{"Spring"}, null);
        assertThat(result).isEqualTo("안녕 Spring"); // hello.name=안녕 {0} -> Spring 단어를 매개변수로 전달 -> 안녕 Spring
    }

    /**
     * Locale 정보가 없는 경우 Locale.getDefault()를 호출해서 시스템의 기본 로케일을 사용합니다.
     * 예) `locale = null` 인 경우 시스템 기본 `locale` 이 `ko_KR` 이므로 `messages_ko.properties` 조회 시도
     * -> 조회 실패 -> `messages.properties` 조회
     */
    @Test
    void defaultLang() {
        assertThat(ms.getMessage("hello", null, null)).isEqualTo("안녕");
        assertThat(ms.getMessage("hello", null, Locale.KOREA)).isEqualTo("안녕");
    }

    @Test
    void enLang() {
        assertThat(ms.getMessage("hello", null, Locale.ENGLISH)).isEqualTo("hello");
    }
}
