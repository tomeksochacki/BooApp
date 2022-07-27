package pl.booapp.validators;

import pl.booapp.model.ObjectForRent;

public class ObjectForRentValidator {

    public static boolean validateBasics(ObjectForRent objectForRent) {
        if (objectForRent.getName().equals("") || objectForRent.getArea() == null || objectForRent.getUnitPrice() == null) {
            return false;
        }
        return true;
    }

    public static boolean validateFull(ObjectForRent objectForRent) {
        if (objectForRent.getName().equals("") || objectForRent.getUnitPrice() == null || objectForRent.getUnitPrice() < 0 || objectForRent.getArea() == null || objectForRent.getArea() < 0 || objectForRent.getDescription().equals("")) {
            return false;
        }
        return true;
    }
}