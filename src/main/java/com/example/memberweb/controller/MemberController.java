package com.example.memberweb.controller;

import com.example.memberweb.domain.Member;
import com.example.memberweb.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller //스프링컨테이너가 뜰 때 객체를 생성해서 올린다.
public class MemberController {

    @Autowired
    private MemberService memberService;
    //private static  long sequence = 0L;

    //스프링컨테이너가 뜰 때 컨트롤러 객체가 생성되는데, 이 때 생성자가 호출되면서 MemberService 객체에 Autowired가 연결시켜준다.
    //연결될 객체(MemberService)에서는 @Service를 붙여준다.
    //SpringBootApplication main이 속한 패키지 하위의 컴포넌트(service, mapper 등)을 찾아서 연결시킨다.
    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        //회원 가입 버튼을 누르면, members/createMemberForm.html로 연결
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        //member.setId(++sequence);
        member.setName(form.getName());
        member.setPw(form.getPw());
        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping(value = "/members")
    public String memberlist(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

    @PostMapping("/members/find")
    public ModelAndView member(String name){
        ModelAndView model = new ModelAndView("/members/member");
        Optional<Member> member = memberService.findMember(name);
        model.addObject("member", member.get());
        return model;
    }
}
