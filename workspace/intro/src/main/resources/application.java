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
public class controller {

@GetMapping("/new")
public String index(Model model) {
//	model.addAttribute("name", "hiroki");
//	model.addAttribute("age", 23);

return "hello";
}

@GetMapping("/textarea")
public String sample(String s_name, String r_date, String t_period, String mailaddress, String card_b, int card_num, String s_id, String other,Model model) {
 model.addAttribute("s_name", s_name);
 model.addAttribute("r_date", r_date);
 model.addAttribute("t_period", t_period);
 model.addAttribute("mailaddress", mailaddress);
 model.addAttribute("card_b", card_b);
 model.addAttribute("card_num", card_num);
 model.addAttribute("s_id", s_id);
 model.addAttribute("other", other);
 
 return "list";
}

@Autowired
private JdbcTemplate jdbc;


@PostMapping("/post")
public String Post(String s_name, String r_date, String t_period, RedirectAttributes attr){
    attr.addFlashAttribute("s_name", s_name);
    attr.addFlashAttribute("r_date", r_date);
    attr.addFlashAttribute("t_period", t_period);
    
    //jdbc.update("UPDATE DBTest SET name = ?,age = ?", name,age);
    jdbc.update("INSERT INTO DBTest (name, age) VALUES (?,?)", name,age);
    attr.addFlashAttribute("people",jdbc.queryForList("SELECT * FROM DBTest")); 
    //Map<String, Object> DBTest = jdbc.queryForList("SELECT * FROM DBTest where name = ?", name).get(0);
    
    return "redirect:/hello";
}
}