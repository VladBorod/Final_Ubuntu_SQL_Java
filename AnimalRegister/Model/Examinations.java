package AnimalRegister.Model;

import AnimalRegister.Model.Exceptions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Examinations {
    public static void nameExamination(String name) {
        if (!(name.chars().allMatch(Character::isLetter))) {
            throw new IncorrectNameFormatException();
        }
    }
    public static Date birthDateExamination(String birthDate){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.mm.yyy");
        Date parsedBirthDate;
        try {
            parsedBirthDate = dateFormat.parse(birthDate);
        } catch (NumberFormatException | ParseException e){
            throw new DateFormatException();
        }
        String[] dateTest = birthDate.split("\\.");
        String day = dateTest[0];
        String month = dateTest[1];
        String year = dateTest[2];
        int dayNum;
        int monthNum;
        int yearNum;
        try{
            dayNum = Integer.parseInt(day);
            if (dayNum < 1 || dayNum > 31){
                throw new DateFormatException();
            }
            monthNum = Integer.parseInt(month);
            if (monthNum < 1 || monthNum > 12){
                throw new DateFormatException();
            }
            yearNum = Integer.parseInt(year);
            if (yearNum < 1873 || yearNum > 2023){
                throw new DateFormatException();
            }
        } catch (NumberFormatException e){
            throw new DateFormatException();
        }
        return parsedBirthDate;
    }
}
