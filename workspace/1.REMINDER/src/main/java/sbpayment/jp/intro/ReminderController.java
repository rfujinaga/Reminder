package sbpayment.jp.intro;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
public String detail(Model model ,String mailaddress) {
	model.addAttribute("data",jdbc.queryForList("SELECT id from service"));
	model.addAttribute("mailaddress",jdbc.queryForList("SELECT mailaddress from service").get(0).get("mailaddress"));
	return "detail";
}

//@RequestMapping("/detail/{id}")
//public String detail(Model model, @PathVariable("id") String id) {
//	model.addAttribute("id", id);
//	return "detail";
//}


@Autowired
private JdbcTemplate jdbc;


@PostMapping("/post")
public String Post(String s_name, String r_date, String t_period, String mailaddress, String card_bra, String card_num, String s_id, String password, String other, RedirectAttributes attr){
	attr.addFlashAttribute("s_name", s_name);
    attr.addFlashAttribute("r_date", r_date);
    attr.addFlashAttribute("t_period", t_period);
    attr.addFlashAttribute("mailaddress", mailaddress);
	attr.addFlashAttribute("card_bra", card_bra);
	attr.addFlashAttribute("card_num", card_num);
	attr.addFlashAttribute("s_id", s_id);
	attr.addFlashAttribute("password", password);
	attr.addFlashAttribute("other", other);
    
    jdbc.update("INSERT INTO service (s_name, r_date, t_period,mailaddress,card_bra,card_num,s_id,password,other) VALUES (?,?,?,?,?,?,?,?,?)", s_name,r_date,t_period,mailaddress,card_bra,card_num,s_id,password,other);
    attr.addFlashAttribute("data",jdbc.queryForList("SELECT * from service")); 
    
    return "redirect:/list";
}
}




