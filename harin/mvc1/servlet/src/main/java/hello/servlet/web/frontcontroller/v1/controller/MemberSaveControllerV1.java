package hello.servlet.web.frontcontroller.v1.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.v1.ControllerV1;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberSaveControllerV1 implements ControllerV1 {
    private MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //파라미터 받기
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age")); // int로 파싱해줘야함

        //비즈니스 모델 호출
        Member member = new Member(username, age);
        memberRepository.save(member);

        //Model에 데이터를 보관한다.
        //내부 저장소 map같은게 있음
        request.setAttribute("member", member);

        //View로 던지기
        String viewPath = "/WEB-INF/views/save-result.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }
}
