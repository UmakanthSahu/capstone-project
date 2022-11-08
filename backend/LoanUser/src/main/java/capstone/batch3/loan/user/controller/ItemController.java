package capstone.batch3.loan.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import capstone.batch3.loan.user.model.ItemMaster;
import capstone.batch3.loan.user.model.request.EmployeeIdRequest;
import capstone.batch3.loan.user.model.response.PurchasedItemResponse;
import capstone.batch3.loan.user.service.ItemService;

@CrossOrigin(origins = {"http://localhost:3000",  "http://localhost:3001", "http://localhost:3002"})
@RestController
@RequestMapping("/api/v1")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/getAllItems")
	public ResponseEntity<List<ItemMaster>> getAllItems(){
		return ResponseEntity.ok(itemService.getAllItems());
	}
	
	@PostMapping(path = "/viewPurchasedItems", consumes = "application/json")
	public ResponseEntity<List<PurchasedItemResponse>> getPurchasedItems( @RequestBody EmployeeIdRequest employeeIdRequest){
		System.out.println(employeeIdRequest.getEmployeeId());
		return ResponseEntity.ok(itemService.getPurchasedItems(employeeIdRequest.getEmployeeId()));
	}

}
