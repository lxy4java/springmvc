package lxy.demo.dubbo;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zszq.dubbo.sms.api.DubboSendTaskListService;

@RestController
public class TesDubboController {

	@Inject
	private DubboSendTaskListService dubboSendTaskListService;

	@RequestMapping("/test")
	public String test() {

		long id = dubboSendTaskListService.save("13714783201", "测试", "666666");
		System.out.println("#################"+id);
		return id+"";
	}

}
