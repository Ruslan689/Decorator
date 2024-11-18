package com.example.decorator;

public abstract class DocumentDecorator implements Document {
    protected Document document;

    public DocumentDecorator(Document document) {
        this.document = document;
    }

    @Override
    public String parse() {
        return document.parse();
    }
}