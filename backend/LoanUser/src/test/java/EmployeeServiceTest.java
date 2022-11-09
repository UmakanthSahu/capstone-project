import capstone.batch3.loan.user.model.EmployeeMaster;
import capstone.batch3.loan.user.model.response.EmployeeLoginResponse;
import capstone.batch3.loan.user.repository.EmployeeRepository;
import capstone.batch3.loan.user.service.EmployeeService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import java.text.ParseException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EmployeeServiceTest {
    private EmployeeService employeeService;
    private EmployeeRepository employeeRepository;
    @BeforeEach
    void setUp() {
        employeeService= new EmployeeService() ;
    }

    @Test
    @DisplayName("assert return values and null parameters")
    void test() throws ParseException {
//`employee_id` VARCHAR(6) NOT NULL,
//  `employee_name` VARCHAR(20) NOT NULL,
//  `designation` VARCHAR(25) NOT NULL,
//  `department` VARCHAR(25) NOT NULL,
//  `gender` CHAR(1) NOT NULL,
//  `date_of_birth` DATE NOT NULL,
//  `date_of_joining` DATE NOT NULL,
        employeeRepository= mock(EmployeeRepository.class) ;
        EmployeeMaster employee = new EmployeeMaster() ;
        employee.setEmployeeId(001);
        employee.setName("Vanshika");
        employee.setDesignation("Program Associate");
        employee.setDepartment("technical");
        employee.setEmailId("vanshika@gmail.com");
        employee.setPassword("qwerty");

        EmployeeLoginResponse employeeLoginResponse=new EmployeeLoginResponse(employee);
        employeeLoginResponse.setEmployeeid(001);
        employeeLoginResponse.setEmployeeDesignation("Program Associate");
        employeeLoginResponse.setDepartment("technical");

        when(employeeRepository.findByEmailIdAndPassword("vanshika@gmail.com","qwerty")).thenReturn(Optional.of(employee)) ;
//        doNothing().when(employeeRepository.save(employee));
        when(employeeRepository.existsById("vanshika@gmail.com")).thenReturn(false) ;

        assertEquals(employeeLoginResponse,employeeService.login("vanshika@gmail.com","qwerty")) ;
        assertEquals(employee,employeeService.addEmployee(employee));









    }
}
