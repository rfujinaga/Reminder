package sbpayment.jp.intro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class introController {

	@GetMapping("/intro")
	public String Hello() {
		return "top";
	}
}
