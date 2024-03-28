package fr.sup.galilee.pharmacy.utils;

import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.time.ZoneId;
@UtilityClass
public class Dates {
    public java.util.Date from(LocalDateTime from) {
        return Dates.from(LocalDateTime.from(from.atZone(ZoneId.systemDefault()).toInstant()));
    }
}
