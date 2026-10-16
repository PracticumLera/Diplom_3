package ru.stellarburgers.utils;

import java.util.UUID;

public class TestDataGenerator {

    public static String generateEmail() {
        return "test_" + UUID.randomUUID() + "@yandex.ru";
    }

    public static String generatePassword() {
        return "Pass_" + UUID.randomUUID().toString().substring(0, 8);
    }

    public static String generateShortPassword() {
        return "123";
    }

    public static String generateName() {
        return "User_" + UUID.randomUUID().toString().substring(0, 8);
    }

    private TestDataGenerator() {
    }
}