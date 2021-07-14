package pl.AntowskiBartosz.employee.manualWorker;

import pl.AntowskiBartosz.employee.AbstractInterfaceEmployee;

public abstract class AbstractManualWorker extends AbstractInterfaceEmployee implements ManualWorker{
    int cupboardNumber;

    public AbstractManualWorker(int ID, String firstName, String lastName, int salary, int pesel, int cupboardNumber) {
        super(ID, firstName, lastName, salary, pesel);
        this.cupboardNumber = cupboardNumber;
    }

    public int getCupboardNumber() {
        return cupboardNumber;
    }

    public void setCupboardNumber(int cupboardNumber) {
        this.cupboardNumber = cupboardNumber;
    }

}
