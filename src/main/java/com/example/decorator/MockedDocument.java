package com.example.decorator;

public class MockedDocument implements Document{

    @Override
    public String parse(){
        try {
    
            Thread.sleep(1000);
        } catch (Exception e) {}
        return "Mocked Parse Resoult";
    }
}
