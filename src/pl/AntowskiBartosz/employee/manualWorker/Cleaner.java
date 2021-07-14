package pl.AntowskiBartosz.employee.manualWorker;

import pl.AntowskiBartosz.employee.UniformColor;

public class Cleaner extends AbstractManualWorker {
    private String team;

    public Cleaner(int ID, String firstName, String lastName, int salary, int pesel, int cupboardNumber, String team) {
        super(ID, firstName, lastName, salary, pesel, cupboardNumber);
        this.team = team;
    }

    @Override
    public UniformColor getColour() {
        return UniformColor.BLUE;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "\nSERWIS SPRZĄTAJĄCY -> \nID: " + getID() +
                "\nimię: " + getFirstName() +
                "\nnazwisko: " + getLastName() +
                "\npensja: " + getSalary() +
                "\npesel: " + getPesel() +
                "\nnr szafki: " + getCupboardNumber() +
                "\nzespół: " + getTeam() +
                "\nkolor stroju: " + getColour() +"\n";
    }

    @Override
    public void giveRise() {
        setSalary(getSalary() + 400);
    }
}
