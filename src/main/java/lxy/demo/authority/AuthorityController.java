package lxy.demo.authority;

import java.util.HashMap;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorityController {

	@Inject
	AuthorityService authorityService;

	@RequestMapping("/auth")
	public String auth(HttpServletRequest request) {

		HashMap<String, Integer> map = authorityService.getUserAuthPages("lxy");

		request.setAttribute("auth", map);

		return "auth";
	}

	@RequestMapping(value="/php",produces="text/plain;charset=UTF-8")
	public String php(HttpServletRequest request) {

		request.setAttribute("save", "保存");
		request.setAttribute("edit", "修改");
		request.setAttribute("delete", "删除");
		return "php";
	}
}
