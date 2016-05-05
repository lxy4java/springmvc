package lxy.demo.transactional.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lxy.demo.transactional.service.HelloService;

@RestController
public class HelloController {

	@Inject
	private HelloService helloService;

	@RequestMapping("/transactional")
	public String transactional(String id) {

		helloService.deleteCouponType(id);
		return "success";

	}

}
