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

@GetMapping("/hello")
public String index(Model model) {
//model.addAttribute("name", "hiroki");
//model.addAttribute("age", 23);

return "hello";
}

@GetMapping("/new")
public String test(String name, Model model) {
	model.addAttribute("name", name);
	//model.addAttribute("age", age);
	return "hello";
}

@GetMapping("/form")
public String sample(String name, int age, Model model) {

model.addAttribute("name", name);
model.addAttribute("age", age);

return "hello";
}

@Autowired
private JdbcTemplate jdbc;


@PostMapping("/post")
public String Post(String name, int age,RedirectAttributes attr){
    attr.addFlashAttribute("name", name);
    attr.addFlashAttribute("age", age);
    
    //jdbc.update("UPDATE DBTest SET name = ?,age = ?", name,age);
    jdbc.update("INSERT INTO DBTest (name, age) VALUES (?,?)", name,age);
    attr.addFlashAttribute("people",jdbc.queryForList("SELECT * FROM DBTest")); 
    //Map<String, Object> DBTest = jdbc.queryForList("SELECT * FROM DBTest where name = ?", name).get(0);
    
    return "redirect:/hello";
}
}
