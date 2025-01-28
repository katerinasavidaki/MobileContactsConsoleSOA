package gr.aueb.cf.mobilecontacts.validation;

import gr.aueb.cf.mobilecontacts.dto.MobileContactInsertDTO;
import gr.aueb.cf.mobilecontacts.dto.MobileContactUpdateDTO;

public class ValidationUtil {

    /**
     * No instances of this class should be available.
     */
    private ValidationUtil() {

    }

    public static String validateDTO(MobileContactInsertDTO insertDTO) {
        String errorResponse = "";

        if (insertDTO.getPhoneNumber().length() <= 5) {
            errorResponse += "Phone number must be greater than 5 symbols\n";
        }
        if (insertDTO.getFirstname().length() < 2) {
            errorResponse += "Firstname must have at least 2 characters.\n";
        }
        if (insertDTO.getLastname().length() < 2) {
            errorResponse += "Lastname must have at least 2 characters\n";
        }
        return errorResponse;
    }

    public static String validateDTO(MobileContactUpdateDTO updateDTODTO) {
        String errorResponse = "";

        if (updateDTODTO.getPhoneNumber().length() <= 5) {
            errorResponse += "Phone number must be greater than 5 symbols\n";
        }
        if (updateDTODTO.getFirstname().length() < 2) {
            errorResponse += "Firstname must have at least 2 characters.\n";
        }
        if (updateDTODTO.getLastname().length() < 2) {
            errorResponse += "Lastname must have at least 2 characters\n";
        }
        return errorResponse;
    }
}
