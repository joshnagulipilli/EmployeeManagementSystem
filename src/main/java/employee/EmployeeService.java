package employee;

import java.util.List;

public class EmployeeService {
    EmployeeRepository employeeRepository ;
    EmployeeService(EmployeeRepository emp){
        this.employeeRepository =emp;
    }
    public void addEmployee(Employee employee){
        employeeRepository.addEmployee(employee);
    }
    public void removeEmployee(Employee employee){
        employeeRepository.remove(employee);
    }
    public Employee findById(int id){
        return employeeRepository.findById(id);
    }
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }
    public void update(int id){
        employeeRepository.update(id);
    }
    public void empList(){
        employeeRepository.listEmployees();
    }
}
