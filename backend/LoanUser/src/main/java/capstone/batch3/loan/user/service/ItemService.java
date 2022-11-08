package capstone.batch3.loan.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import capstone.batch3.loan.user.model.EmployeeIssueDetails;
import capstone.batch3.loan.user.model.ItemMaster;
import capstone.batch3.loan.user.model.response.PurchasedItemResponse;
import capstone.batch3.loan.user.repository.EmployeeIssueDetailsRepository;
import capstone.batch3.loan.user.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private EmployeeIssueDetailsRepository employeeIssueDetailsRepository;

	public List<ItemMaster> getAllItems() {
		return itemRepository.findAll();
	}

	public List<PurchasedItemResponse> getPurchasedItems(Integer employeeId) {
		return employeeIssueDetailsRepository.findByEmployeeId(employeeId).stream()
				.map(item -> new PurchasedItemResponse(item.getIssueId(), item.getItemMaster())).toList();
	}

}
