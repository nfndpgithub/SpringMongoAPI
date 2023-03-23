package com.springmongoapi.spirngmongoapi;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record StudentDTO (String id, String firstName, String lastName, String email,
                          Gender gender, Adress adress, List<String > favouriteSubject){
}
