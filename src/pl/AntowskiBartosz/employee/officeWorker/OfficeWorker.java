package pl.AntowskiBartosz.employee.officeWorker;

import pl.AntowskiBartosz.employee.AbstractInterfaceEmployee;

public class OfficeWorker extends AbstractInterfaceEmployee {
    private String computerCodeNumber;

    public OfficeWorker(int ID, String firstName, String lastName, int salary, int pesel, String computerNumber) {
        super(ID, firstName, lastName, salary, pesel);
        this.computerCodeNumber = computerNumber;
    }

    public String getComputerCodeNumber() {
        return computerCodeNumber;
    }

    public void setComputerCodeNumber(String computerCodeNumber) {
        this.computerCodeNumber = computerCodeNumber;
    }

    @Override
    public String toString() {
        return "\nBIURO -> \nID: " + getID() +
                "\nimię: " + getFirstName() +
                "\nnazwisko: " + getLastName() +
                "\npensja: " + getSalary() +
                "\npesel: " + getPesel() +
                "\nnr komputera: " + getComputerCodeNumber() +"\n";
    }

    @Override
    public void giveRise() {
        setSalary(getSalary() + 800);
    }
}
