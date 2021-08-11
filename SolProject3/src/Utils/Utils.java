package Utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.TimeZone;

import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

public class Utils {

	public static void initDate(DatePicker date) {
		Calendar c = Calendar.getInstance();
		TimeZone tz = c.getTimeZone();
		ZoneId id = tz == null ? ZoneId.systemDefault() : tz.toZoneId();
		LocalDate ld = LocalDateTime.ofInstant(c.toInstant(), id).toLocalDate();
		date.setDayCellFactory(d -> new DateCell() {
			public void updateItem(LocalDate locd, boolean empty) {
				super.updateItem(locd, empty);
				setDisable(locd.isAfter(ld));
			};
		});
		date.setValue(ld);
	}
	
	public static boolean isOnlyDigits(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9')
                return false;
        }
        return true;
    }
	
    public static boolean isValidPassword(String password, Label message)
    {
            boolean isValid = true;
            if (password.length() > 15 || password.length() < 6)
            {
                    message.setText("Password must be less than 15 and more than 6 characters in length.");
                    isValid = false;
            }
            String upperCaseChars = "(.*[A-Z].*)";
            if (!password.matches(upperCaseChars ))
            {
            		message.setText("Password must have atleast one uppercase character");
                    isValid = false;
            }
            String lowerCaseChars = "(.*[a-z].*)";
            if (!password.matches(lowerCaseChars ))
            {
            		message.setText("Password must have atleast one lowercase character");
                    isValid = false;
            }
            String numbers = "(.*[0-9].*)";
            if (!password.matches(numbers ))
            {
            		message.setText("Password must have atleast one number");
                    isValid = false;
            }
            String specialChars = "(.*[@,#,$,%].*$)";
            if (!password.matches(specialChars ))
            {
            		message.setText("Password must have atleast one special character among @#$%");
                    isValid = false;
            }
            return isValid; 
    }
}
