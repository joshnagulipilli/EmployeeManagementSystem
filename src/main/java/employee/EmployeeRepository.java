package employee;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import static employee.Department.*;

public class EmployeeRepository {
   private List<Employee> employeeList = new ArrayList<>();

   public void addEmployee(Employee employee){
       employeeList.add(employee);
   }

   public void remove(Employee emp){
       employeeList.remove(emp);
       //since stream creates new list and modicy that we should not use streams here
//       employeeList.stream()
//               .map(e->e.getId()==id)
//               .forEach(e->employeeList.remove(e));
   }

   public Optional<Employee> findById(int id){
       for(Employee e : employeeList){
           if(e.id == id){
               return Optional.of(e);
           }
       }
       return Optional.empty();
   }

   public List<Employee> findAll(){
       return new ArrayList<>(employeeList);
   }

   public void updateSalary(Employee e){
   }
}
