package kr.ac.hansung.cse.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.hansung.cse.model.QuestList;
import kr.ac.hansung.cse.model.Sum;
import kr.ac.hansung.cse.service.EventService;

@Controller
public class UserController {

		@Autowired
		EventService eventService;
	
		@SuppressWarnings("unchecked")
		@RequestMapping(value="/connect", method=RequestMethod.POST ,produces= {"application/json;charset=utf-8"})
		public @ResponseBody JSONObject login(@RequestBody /*JSONObject info*/Map<String, Object> info) {
			
			JSONObject jsonMain = new JSONObject(); // json °´Ã¼
			
			String name = info.get("name").toString();
			String id = info.get("id").toString();
			String year = info.get("year").toString();
			String major = info.get("major").toString();
			String phone = info.get("phone").toString();
			
			System.out.println(info);
			
			eventService.login(name, id, year, major, phone);
			//eventService.login(name, id, year, major);
			
			System.out.println("connect");
			jsonMain.put("return", "success");
						
			return jsonMain;
		}
		
		@RequestMapping(value="/clearQ1", method=RequestMethod.POST ,produces= {"application/json;charset=utf-8"})
		public @ResponseBody JSONObject clearQ1(@RequestBody Map<String, Object> info) {
			
			JSONObject jsonMain = new JSONObject(); // json °´Ã¼
			String name = info.get("name").toString();
			String id = info.get("id").toString();
			String year = info.get("year").toString();
			String major = info.get("major").toString();
			
			System.out.println("clearQ1");
			
			eventService.clearQ1(name, id, year, major);
						
			return jsonMain;
		}
		@RequestMapping(value="/clearQ2", method=RequestMethod.POST ,produces= {"application/json;charset=utf-8"})
		public @ResponseBody JSONObject clearQ2(@RequestBody Map<String, Object> info) {
			
			JSONObject jsonMain = new JSONObject(); // json °´Ã¼
			String name = info.get("name").toString();
			String id = info.get("id").toString();
			String year = info.get("year").toString();
			String major = info.get("major").toString();
			
			System.out.println("clearQ2");
			eventService.claarQ2(name, id, year, major);
			
						
			return jsonMain;
		}
		
		@RequestMapping(value="/sum", method=RequestMethod.POST ,produces= {"application/json;charset=utf-8"})
		public @ResponseBody JSONObject sum(@RequestBody Map<String, Object> info) {
			
			JSONObject jsonMain = new JSONObject(); // json °´Ã¼
			String name = info.get("name").toString();
			String id = info.get("id").toString();
			String year = info.get("year").toString();
			String major = info.get("major").toString();
			
			
			eventService.sum(name, id, year, major);
			System.out.println("sum");
			
			return jsonMain;
		}
		
		@RequestMapping(value="/quest1")
		public String viewQuest1(Model model) {
			
			List<QuestList> questList = eventService.getQ1("¿Ï·á!");	
			model.addAttribute("quest", questList);
			
			return "quest1";
		}
		
		@RequestMapping(value="/quest2")
		public String viewQuest2(Model model) {
			
			List<QuestList> questList = eventService.getQ2("¿Ï·á!");	
			model.addAttribute("quest", questList);
			
			return "quest2";
		}	
		
		@RequestMapping(value="/viewsum")
		public String viewSum(Model model) {
		
			List<Sum> sumList = eventService.viewSum();
			model.addAttribute("sum", sumList);
			
			return "sum";
		}
}
