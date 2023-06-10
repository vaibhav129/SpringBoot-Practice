package com.example.coach.common;

import org.springframework.stereotype.Component;

@Component
public class trackcoach implements COach{
    @Override
    public String getworkout() {
        return "Practice ruunning for 15 min";
    }
}
