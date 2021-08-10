package Utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.TimeZone;

import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;

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
  
            if (str.charAt(i) >= '0'
                && str.charAt(i) <= '9') {
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }
}
