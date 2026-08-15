package employee;

import java.util.Arrays;
import java.util.List;

import static employee.Department.*;
import static employee.EmployeeStatus.*;
import static employee.JobRole.*;

public class Main {
    public static void main(String[] args) {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        EmployeeService employeeService = new EmployeeService(employeeRepository);
        List<Employee> employeeList = Arrays.asList(new Employee(101,"joshna","joshna@gmail.com","+919676282885",23,
                MARKETING,DEVELOPER,45732.89,ACTIVE),
                new Employee(102,"jemima","jemima@gmail.com","+919689282885",21,
                        HR,MANAGER,45732.89,INACTIVE),
                new Employee(113,"Rose","rose@gmail.com","+918309277626",25,
                        MARKETING,TESTER,45732.89,ON_LEAVE));
        for(Employee e : employeeList) {
            employeeService.addEmployee(e);
            //System.out.println(e.toString());
        }

        //finding an employee
        Employee e = employeeService.findById(102);
        //System.out.println(e);
        //Removing an employee
        employeeService.removeEmployee(e);
        //getting all employees from list
        employeeService.empList();
        //updating an employee
        employeeService.update(113);
        employeeService.empList();
    }
}
