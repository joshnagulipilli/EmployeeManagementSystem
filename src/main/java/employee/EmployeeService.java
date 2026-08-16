package employee;

import java.util.List;
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
           employeeRepository.remove(emp.get());
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

    public void updateSalary(Department dep){
        List<Employee> emp = employeeRepository.findAll();
        for(Employee e:emp){
            if(e.getDepartment().equals(dep)){
                e.setSalary(e.getSalary()+20000.0);
            }
        }

    }
}
