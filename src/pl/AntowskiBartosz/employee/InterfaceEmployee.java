package pl.AntowskiBartosz.employee;

import pl.AntowskiBartosz.CompanyDomain;

public interface InterfaceEmployee {

    void giveRise();

    default String generateEmail(String firstName, String lastName){
        return lastName.toLowerCase()+"."+firstName.toLowerCase()+CompanyDomain.getDomain();
    }
}
