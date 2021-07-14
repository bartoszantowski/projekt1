package pl.AntowskiBartosz.employee.manualWorker;

import pl.AntowskiBartosz.employee.UniformColor;

public class Driver extends AbstractManualWorker {
    private String drivingLicenceCategory;
    private String vehicleRegistrationNumber;

    public Driver(int ID, String firstName, String lastName, int salary, int pesel, int cupboardNumber, String drivingLicenceCategory, String vehicleRegistrationNumber) {
        super(ID, firstName, lastName, salary, pesel, cupboardNumber);
        this.drivingLicenceCategory = drivingLicenceCategory;
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
    }

    @Override
    public UniformColor getColour() {
        return UniformColor.YELLOW;
    }

    public String getDrivingLicenceCategory() {
        return drivingLicenceCategory;
    }

    public void setDrivingLicenceCategory(String drivingLicenceCategory) {
        this.drivingLicenceCategory = drivingLicenceCategory;
    }

    public String getVehicleRegistrationNumber() {
        return vehicleRegistrationNumber;
    }

    public void setVehicleRegistrationNumber(String vehicleRegistrationNumber) {
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
    }

    @Override
    public String toString() {
        return "\nKIEROWCA -> \nID: " + getID() +
                "\nimię: " + getFirstName() +
                "\nnazwisko: " + getLastName() +
                "\npensja: " + getSalary() +
                "\npesel: " + getPesel() +
                "\nnr szafki: " + getCupboardNumber() +
                "\nprawo jazdy kat.: " + getDrivingLicenceCategory() +
                "\nnr rejsetracyjny: " + getVehicleRegistrationNumber() +
                "\nkolor stroju: " + getColour() +"\n";
    }

    @Override
    public void giveRise() {
        setSalary(getSalary() + 650);
    }
}
