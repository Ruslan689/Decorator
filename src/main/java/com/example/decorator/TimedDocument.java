package com.example.decorator;

import java.time.Duration;
import java.time.LocalTime;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TimedDocument implements Document{
    private Document document;

    @Override
    public String parse() {
        LocalTime starTime = LocalTime.now();
        String resoult =  document.parse();
        LocalTime endTime = LocalTime.now();

        System.out.println("Time:" + Duration.between(starTime, endTime).getSeconds());

        return resoult;
    }

}
