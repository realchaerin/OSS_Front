package com.oos12.scansavvy.member.controller;

import com.oos12.scansavvy.member.dto.MemberDTO;
import com.oos12.scansavvy.member.model.Member;
import com.oos12.scansavvy.member.service.MemberServiceImpl;
import com.oos12.scansavvy.member.service.ObjectMapperUtils;
import com.oos12.scansavvy.member.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {
    @Autowired
    private MemberServiceImpl memberService;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @GetMapping(value = "/")
    public List<MemberDTO> getAllMembers(){
        return ObjectMapperUtils.mapAll(memberService.findAll(), MemberDTO.class);
    }

    @GetMapping(value = "/byEmail/{email}")
    public MemberDTO getMemberByEmail(@PathVariable("email") String email){
        return ObjectMapperUtils.map(memberService.findByEmail(email), MemberDTO.class);
    }

    @GetMapping(value = "/byPhone/{phone}")
    public MemberDTO getMemberByPhone(@PathVariable("phone") String phone){
        return ObjectMapperUtils.map(memberService.findByPhone(phone), MemberDTO.class);
    }

    @GetMapping(value = "/orderByName")
    public List<MemberDTO> findAllByOrderByNameDesc(){
        return ObjectMapperUtils.mapAll(memberService.findAllByOrderByNameDesc(), MemberDTO.class);
    }

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveOrUpdateMember(@RequestBody MemberDTO memberDTO){
        Member member = memberService.findByEmail(memberDTO.getEmail());
        String responseMessage = "Member added success";
        if (member != null && member.getId() != null && !member.getId().isEmpty()){
            responseMessage = "This Email already Exist";
        }else {
            memberDTO.setIdx(sequenceGeneratorService.generateSequence(Member.SEQUENCE_NAME));
            memberService.saveOrUpdateMember(ObjectMapperUtils.map(memberDTO, Member.class));
        }
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @PostMapping(value = "/delete/{email}")
    public ResponseEntity<?> deleteMemberByEmail(@PathVariable String email){
        Member member = memberService.findByEmail(email);
        String responseMessage = "Member Deleted success";
        if (member != null && member.getId() != null && !member.getId().isEmpty()){
            memberService.deleteMemberById(memberService.findByEmail(email).getId());
        }else {
            responseMessage = "this Email does not exist our member list";
        }
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }
}
