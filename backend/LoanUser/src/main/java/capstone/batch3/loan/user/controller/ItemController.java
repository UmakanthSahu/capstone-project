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

/*
 * Handles getAllItems and ItemsPurchased requests
 */

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:3001", "http://localhost:3002" })
@RestController
@RequestMapping("/api/v1")
public class ItemController {

	@Autowired
	private ItemService itemService;

	// returns an list of items when a get request is made
	// empty list if no items are present in the database
	@GetMapping("/getAllItems")
	public ResponseEntity<List<ItemMaster>> getAllItems() {
		return ResponseEntity.ok(itemService.getAllItems());
	}

	// returns an list of purchased items when a post request is made with employeeId in Request Body
	// empty list if no items are present in the database
	@PostMapping(path = "/viewPurchasedItems", consumes = "application/json")
	public ResponseEntity<List<PurchasedItemResponse>> getPurchasedItems(
			@RequestBody EmployeeIdRequest employeeIdRequest) {
		return ResponseEntity.ok(itemService.getPurchasedItems(employeeIdRequest.getEmployeeId()));
	}

}
