package com.project.Member.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Member.entity.Member;
import com.project.Member.exception.MemberNotFoundException;
import com.project.Member.repository.MemberRepository;

@RestController
@RequestMapping("/api/member")
public class MemberController {
	
	@Autowired
	private MemberRepository memberRepository;
	
	
	@GetMapping
	public List<Member> getAllMembers(){
		return memberRepository.findAll();
	}
	
	@GetMapping("/membername/{id}")
	public String getNameById(@PathVariable("id")int memberID) {
		return memberRepository.findNameById(memberID);
	}
	
	@PostMapping("/newmember")
	public Member createMember(@RequestBody Member member) {
		return memberRepository.save(member);
	}
	
	@GetMapping("/{id}")
	public Optional<Member> getMemberId(@PathVariable (value="id")Integer memberId){
		Optional<Member> member = memberRepository.findById(memberId);
		if(member.isPresent()) {
			return memberRepository.findById(memberId);
		}else {
			throw new MemberNotFoundException("Member Id"+memberId+" is Not Found");
		}
	}
	
	@DeleteMapping("/{id}")
	public Optional<Member> deleteMember(@PathVariable("id") Integer ID){
		Optional<Member>member = memberRepository.findById(ID);
		if(member.isPresent()) {
			this.memberRepository.deleteById(ID);
		}else {
			throw new MemberNotFoundException("Member Id is not Found");
		}
		return member;
	}
	
	@PutMapping("/updatemember/{id}")
	public Member updateMember(@RequestBody Member member,@PathVariable("id")Integer id) {
		Optional<Member> obj =this.memberRepository.findById(id);
		if(obj.isPresent()) {
			Member existingMember=obj.get();
			existingMember.setMemberName(member.getMemberName());
			existingMember.setPhoneNumber(member.getPhoneNumber());
			return this.memberRepository.save(existingMember);
		}else {
			throw new MemberNotFoundException("Member Id is not Found");
		}
	}

}
