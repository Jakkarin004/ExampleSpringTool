package pccth.sp.pccthspseedservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pccth.sp.pccthspseedservice.model.TahnModel;
import pccth.sp.pccthspseedservice.service.TahnService;

@RestController
@RequestMapping("Tahn-controller")
public class TahnController {
	
	@Autowired
	private TahnService tahnService;
	
	//Get
	//RequestParam แยกกันเป็น ตัวๆ เข่น firstName
	@GetMapping("/get-data")
	public List<TahnModel> getData() {
		return tahnService.getData();
	}
	
	//ส่ง firstName ไปก็จริงแต่ใน service ก็ยังบอกว่ารับ name อยู่ดี
	@GetMapping("/get-data-by-name")
	public List<TahnModel> getDataByName(@RequestParam String firstName) {
		return tahnService.getDataByName(firstName);
	}
	
//	@GetMapping("/get-data-fullname-and-age")
//	public List<TahnModel> getDataByName(@RequestParam String firstName) {
//		return tahnService.getDataByName(firstName);
//	}
	
	//POST
	//RequestBody เอามาทั้งหมด เช่น tahnModel
	@PostMapping("save-data")
	public void saveData(@RequestBody TahnModel tahnModel) {
		tahnService.saveData(tahnModel);
	}
}
