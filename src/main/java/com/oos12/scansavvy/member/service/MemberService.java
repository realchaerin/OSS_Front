package com.oos12.scansavvy.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {
    public List<String> getMember(String name){
        System.out.println("test");
        return null;
    }
}
