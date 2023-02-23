package com.simple.basic.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.basic.command.BuilderVO2;
import com.simple.basic.command.SimpleVO;

@Controller
@RequestMapping("/view")
public class ThymeleafController {
	
	@GetMapping("/ex01")
	public String ex01() {
		
		return "view/ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(Model model) {
		ArrayList<BuilderVO2> list = new ArrayList<>();
		for(int i =1 ; i<=10; i++) {
		 BuilderVO2 vo = BuilderVO2.builder()
				 					.name("홍길동"+i)
				 					.age(i)
				 					.build();
		 
		 list.add(vo);
		}
		
		model.addAttribute("list",list);
		
		return "view/ex02";
	}
	
	@GetMapping("/ex03")
	public String ex03(Model model) {
		ArrayList<BuilderVO2> list = new ArrayList<>();
		for(int i =1 ; i<=10; i++) {
		 BuilderVO2 vo = BuilderVO2.builder()
				 					.name("홍길동"+i)
				 					.age(i)
				 					.build();
		 
		 list.add(vo);
		}
		
		model.addAttribute("list",list);
		
		return "view/ex03";
	}
	
	//test
	@GetMapping("/test")
	public String test(@RequestParam("age") int age,
						@RequestParam("name") String name) {
		System.out.println(age);
		System.out.println(name);
		
		return "view/test";
		
	}
	
	//쿼리파라미터
	@GetMapping("/test2/{a}/{b}")
	public String test(@PathVariable("a") String a,
						@PathVariable("b") String b) {
		
		System.out.println(a);
		System.out.println(b);
		
		return "view/test";
		
	}
	
	@GetMapping("/ex04")
	public String ex04(Model model) {
		BuilderVO2 vo = new BuilderVO2("철수",5);
		model.addAttribute("name","짱구");
		model.addAttribute("vo",vo);
		
		return "view/ex04";
	}
	
	@GetMapping("/ex05")
	public String ex05(Model model) {
		//날짜의 형변환은 database, 자바, 화면에서 처리
		model.addAttribute("regdate",LocalDateTime.now());
		return "view/ex05";
	}
	
	@GetMapping("/ex06")
	public String ex06() {
		
		return "view/ex06";
	}
	
	@GetMapping("/ex07")
	public String ex07() {
		
		return "view/ex07";
	}
	
	@GetMapping("/quiz01")
	public String quiz01(Model model) {
		SimpleVO vo = new SimpleVO(940906,"lee","lee123");
		model.addAttribute("vo",vo);
		
		return "view/quiz01";
	}
	
	@GetMapping("/quiz_result01")
	public String quiz_result01(@RequestParam("userNum") int userNum,
								@RequestParam("name") String name,
								@RequestParam("id") String id,
								Model model) {
		model.addAttribute("userNum",userNum);
		model.addAttribute("name",name);
		model.addAttribute("id",id);
		return "view/quiz_result01";
	}
	
}
