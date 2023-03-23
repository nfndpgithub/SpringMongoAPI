package com.springmongoapi.spirngmongoapi;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record StudentRegistrationRequest(String firstName, String lastName, String email, Gender gender, Adress adress, List<String > favouriteSubject, BigDecimal totalSpentInBooks,
                                         LocalDateTime created) {
}
