package pl.AntowskiBartosz.employee;

public abstract class AbstractInterfaceEmployee extends Employee {

    private int salary;
    private int pesel;

    public AbstractInterfaceEmployee(int ID, String firstName, String lastName, int salary, int pesel) {
        super(ID, firstName, lastName);
        this.salary = salary;
        this.pesel = pesel;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getPesel() {
        return pesel;
    }

    public void setPesel(int pesel) {
        this.pesel = pesel;
    }
}
