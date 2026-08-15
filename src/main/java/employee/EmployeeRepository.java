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

   public void remove(Employee employee){
       employeeList.remove(employee);
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

   public void update(int id){
       ListIterator<Employee> itr = employeeList.listIterator();
       while(itr.hasNext()){
           Employee emp = itr.next();
           if(emp.id == id){
               emp.setDepartment(FINANACE);
               emp.setSalary(emp.getSalary()+20000.0);
           }
       }
   }

   public void listEmployees() {
        ListIterator<Employee> itr = employeeList.listIterator();
        while(itr.hasNext()){
            Employee e = itr.next();
            System.out.println(e.toString());
        }
   }
}
