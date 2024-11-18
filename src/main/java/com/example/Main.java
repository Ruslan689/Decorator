package com.example;

import com.example.decorator.MockedDocument;
import com.example.decorator.TimedDocument;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        MockedDocument mockedDocument = new MockedDocument();
        System.out.println(mockedDocument.parse());

        TimedDocument timedDocument = new TimedDocument(mockedDocument);
        System.out.println(timedDocument.parse());

    }
}