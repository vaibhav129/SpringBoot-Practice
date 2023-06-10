package com.example.coach.rest;

import com.example.coach.common.COach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Democontroller {
    private COach mycoach;
    private COach mycoach1;

    @Autowired
    public Democontroller(@Qualifier("tenniscoach") COach thecoach,
                          @Qualifier("tenniscoach") COach thecoach1)
    {

        mycoach=thecoach;
        mycoach1=thecoach1;
    }
    @GetMapping("/workout")
    public String getworkout()
    {
        return mycoach.getworkout();
    }
    @GetMapping("/check")
    public String check()
    {
        return "compare beans" + (mycoach1==mycoach);
    }
}
