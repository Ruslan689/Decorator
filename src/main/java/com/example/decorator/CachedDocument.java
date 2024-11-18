package com.example.decorator;

import java.util.Map;
import java.util.HashMap;

public class CachedDocument extends DocumentDecorator {
    private Map<String, String> cache = new HashMap<>();

    public CachedDocument(Document document) {
        super(document);
    }

    @Override
    public String parse() {
        String input = "exampleInput";
        if (cache.containsKey(input)) {
            System.out.println("Cache hit");
            return cache.get(input);
        }
        System.out.println("Cache miss");
        String result = super.parse();
        cache.put(input, result);
        return result;
    }
}