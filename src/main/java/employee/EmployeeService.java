package employee;

import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

public class EmployeeService {
    private final EmployeeRepository employeeRepository ;
    EmployeeService(EmployeeRepository emp){
        this.employeeRepository =emp;
    }
    public void addEmployee(Employee employee){
        employeeRepository.addEmployee(employee);
    }
    public String removeEmployee(int id){
       Optional<Employee> emp = employeeRepository.findById(id);
       if(emp.isPresent())
       {
           emp.ifPresent(e->employeeRepository.remove(e));
           return "Emmployee with "+id+" removed";
       }
       return "Employee not Found";
        //this comes in java 9+ , can remove return option
        //emp.ifPresentOrElse(e->employeeRepository.remove(e),()-> System.out.println("NotFound"));
    }
    public Optional<Employee> findById(int id){
        Optional<Employee> e = employeeRepository.findById(id);
        return e;
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
