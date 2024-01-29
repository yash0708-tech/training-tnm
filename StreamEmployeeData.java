import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String gender;
    private int age;
    private String department;
    private double salary;
    private LocalDate joinDate;

    

    public Employee(String name, String gender, int age, String department, double salary, LocalDate joinDate) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.department = department;
        this.salary = salary;
        this.joinDate = joinDate;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", joinDate=" + joinDate +
                '}';
    }
}

public class StreamEmployeeData {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Yash", "Male", 30, "IT", 50000, LocalDate.of(2010, 5, 15)),
                new Employee("Vinit", "Female", 25, "HR", 45000, LocalDate.of(2018, 8, 20)),
                new Employee("Dwij", "Male", 35, "Finance", 60000, LocalDate.of(2015, 3, 10)),
                new Employee("Fenil", "Female", 28, "IT", 55000, LocalDate.of(2016, 10, 5)),
                new Employee("Fidyan", "Male", 40, "HR", 48000, LocalDate.of(2013, 7, 25))
        );

        // How many male and female employees are there in the organization?
        Map<String, Long> genderCount = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("Male count: " + genderCount.getOrDefault("Male", 0L));
        System.out.println("Female count: " + genderCount.getOrDefault("Female", 0L));

        // Print the name of all departments in the organization
        Set<String> departments = employees.stream()
                .map(Employee::getDepartment)
                .collect(Collectors.toSet());
        System.out.println("Departments: " + departments);

        // What is the average age of male and female employees?
        Map<String, Double> avgAgeByGender = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        System.out.println("Average age of male employees: " + avgAgeByGender.getOrDefault("Male", 0.0));
        System.out.println("Average age of female employees: " + avgAgeByGender.getOrDefault("Female", 0.0));

        // Get the details of the highest paid employee in the organization
        Optional<Employee> highestPaidEmployee = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
        highestPaidEmployee.ifPresent(System.out::println);

        // Get the names of all employees who have joined after 2015
        List<String> employeesJoinedAfter2015 = employees.stream()
                .filter(e -> e.getJoinDate().getYear() > 2015)
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println("Employees joined after 2015: " + employeesJoinedAfter2015);

        // Count the number of employees in each department
        Map<String, Long> employeeCountByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println("Employee count by department: " + employeeCountByDepartment);

        // What is the average salary of each department?
        Map<String, Double> avgSalaryByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("Average salary by department: " + avgSalaryByDepartment);

        // Who has the most working experience in the organization?
        Optional<Employee> mostExperiencedEmployee = employees.stream()
                .min(Comparator.comparing(Employee::getJoinDate));
        mostExperiencedEmployee.ifPresent(System.out::println);

        // Get the details of the youngest male employee in each department
        Map<String, Optional<Employee>> youngestMaleByDepartment = employees.stream()
                .filter(e -> "Male".equals(e.getGender()))
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.minBy(Comparator.comparingInt(Employee::getAge))));
        System.out.println("Youngest male by department: " + youngestMaleByDepartment);

        // What is the average salary and total salary of the whole organization?
        DoubleSummaryStatistics salaryStats = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("Average salary of the whole organization: " + salaryStats.getAverage());
        System.out.println("Total salary of the whole organization: " + salaryStats.getSum());
    }
}
