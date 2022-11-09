package capstone.batch3.loan.user.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import capstone.batch3.loan.user.model.ItemMaster;
import capstone.batch3.loan.user.model.response.PurchasedItemResponse;
import capstone.batch3.loan.user.repository.EmployeeIssueDetailsRepository;
import capstone.batch3.loan.user.repository.ItemMasterRepository;

/*
 * Service class to handle getAllItems and getPurchasedItems
 */

@Service
public class ItemService {

	@Autowired
	private ItemMasterRepository itemRepository;

	@Autowired
	private EmployeeIssueDetailsRepository employeeIssueDetailsRepository;

	public List<ItemMaster> getAllItems() {
		return itemRepository.findAll();
	}

	public List<PurchasedItemResponse> getPurchasedItems(Integer employeeId) {
		return employeeIssueDetailsRepository.findByEmployeeId(employeeId)
				.stream()
				.filter(item -> item.getIssueStatus().equals("Active"))
				.map(item -> new PurchasedItemResponse(item.getIssueId(), item.getItemMaster()))
				.collect(Collectors.toList());
	}

}
