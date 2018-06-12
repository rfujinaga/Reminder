package sbpayment.jp.intro;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ReminderController {
	
@GetMapping("/top")
public String top(Model model) {
	return "top";
}

@GetMapping("/new")
public String registration(Model model) {
	return "new";
}
	
@GetMapping("/list")
public String list(Model model) {
	model.addAttribute("data",jdbc.queryForList("SELECT * from service"));
	return "list";
}

@GetMapping("/detail")
public String detail(Model model) {
	model.addAttribute("data",jdbc.queryForList("SELECT * from service"));
	return "detail";
}




@Autowired
private JdbcTemplate jdbc;


@PostMapping("/post")
public String Post(String s_name, String r_date, String t_period, String mailaddress, String card_bra, String card_num, String s_id, String password, String other, RedirectAttributes attr){
	attr.addAttribute("s_name", s_name);
    attr.addAttribute("r_date", r_date);
    attr.addAttribute("t_period", t_period);
    attr.addAttribute("mailaddress", mailaddress);
	attr.addAttribute("card_bra", card_bra);
	attr.addAttribute("card_num", card_num);
	attr.addAttribute("s_id", s_id);
	attr.addAttribute("password", password);
	attr.addAttribute("other", other);
    
    jdbc.update("INSERT INTO service (s_name, r_date, t_period,mailaddress,card_bra,card_num,s_id,password,other) VALUES (?,?,?,?,?,?,?,?,?)", s_name,r_date,t_period,mailaddress,card_bra,card_num,s_id,password,other);
    attr.addFlashAttribute("data",jdbc.queryForList("SELECT * from service")); 
    
    return "redirect:/list";
}
}




