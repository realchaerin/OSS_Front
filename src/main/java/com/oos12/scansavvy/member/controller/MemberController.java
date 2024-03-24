package com.oos12.scansavvy.member.controller;

import com.oos12.scansavvy.member.dto.MemberDTO;
import com.oos12.scansavvy.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/login/{name}")
    public String findByID(@PathVariable String name){
        System.out.println("test");
        return null;
    }
}
