package com.example.coach.common;
import org.springframework.stereotype.Component;

@Component
public class tenniscoach implements COach {
    @Override
    public String getworkout() {
        return "Practice tennis for 15 min";
    }
}
