package pl.AntowskiBartosz.employee.manualWorker;

import pl.AntowskiBartosz.employee.UniformColor;

public class Warehouseman extends AbstractManualWorker {
    private boolean licenceUTD;

    public Warehouseman(int ID, String firstName, String lastName, int salary, int pesel, int cupboardNumber, boolean licenceUTD) {
        super(ID, firstName, lastName, salary, pesel, cupboardNumber);
        this.licenceUTD = licenceUTD;
    }

    public boolean isLicenceUTD() {
        return licenceUTD;
    }

    public void setLicenceUTD(boolean licenceUTD) {
        this.licenceUTD = licenceUTD;
    }

    @Override
    public UniformColor getColour() {
        return UniformColor.RED;
    }

    @Override
    public String toString() {
        return "\nMAGAZYN -> \nID: " + getID() +
                "\nimię: " + getFirstName() +
                "\nnazwisko: " + getLastName() +
                "\npensja: " + getSalary() +
                "\npesel: " + getPesel() +
                "\nnr szafki: " + getCupboardNumber() +
                "\nlicencja UTD: " + isLicenceUTD() +
                "\nkolor stroju: " + getColour() +"\n";
    }

    @Override
    public void giveRise() {
        setSalary(getSalary() + 500);
    }
}
