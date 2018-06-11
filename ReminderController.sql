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
public String registration(String s_name, String r_date, String t_period, String mailaddress, String card_bra, String card_num, String s_id, String other,Model model) {
	model.addAttribute("s_name", s_name);
	model.addAttribute("r_date", r_date);
	model.addAttribute("t_period", t_period);
	model.addAttribute("mailaddress", mailaddress);
	model.addAttribute("card_bra", card_bra);
	model.addAttribute("card_num", card_num);
	model.addAttribute("s_id", s_id);
	model.addAttribute("other", other);
	
	return "new";
}
	
@GetMapping("/list")
public String list(Model model) {
	return "list";
}

@GetMapping("/detail")
public String detail(Model model) {
	return "detail";
}




//@GetMapping("/new")
//public String index(Model model) {
//	model.addAttribute("name", "hiroki");
//	model.addAttribute("age", 23);
//
//	return "new";
//}



@Autowired
private JdbcTemplate jdbc;


@PostMapping("/post")
public String Post(String s_name, String r_date, String t_period, String mailaddress, String card_bra, String card_num, String s_id, String other, RedirectAttributes attr){
    System.out.println("checked");
	attr.addFlashAttribute("s_name", s_name);
    attr.addFlashAttribute("r_date", r_date);
    attr.addFlashAttribute("t_period", t_period);
    
   //jdbc.update("UPDATE DBTest SET name = ?,age = ?", name,age);
    jdbc.update("INSERT INTO service (s_name, r_date, t_period) VALUES (?,?,?)", s_name,r_date,t_period);
    attr.addFlashAttribute("people",jdbc.queryForList("SELECT s_name,r_date,t_period FROM service")); 
   // Map<String, Object> service = jdbc.queryForList("SELECT * FROM service where name = ?", s_name).get(0);
    
    return "list";
}
}
