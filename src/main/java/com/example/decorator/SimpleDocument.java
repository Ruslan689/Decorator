package com.example.decorator;

public class SimpleDocument implements Document {
    @Override
    public String parse() {
        return "Parsing document";
    }
}
