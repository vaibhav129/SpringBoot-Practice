package com.example.coach.common;

import org.springframework.stereotype.Component;

@Component
public class cricketcoach implements COach {
    @Override
    public String getworkout() {
        return "Practice bowling";
    }
}
