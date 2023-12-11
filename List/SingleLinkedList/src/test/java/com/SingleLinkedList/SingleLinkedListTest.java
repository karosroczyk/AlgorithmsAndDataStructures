package com.SingleLinkedList;

import org.example.SingleLinkedList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SingleLinkedListTest {
    @Test
    public void addFirstTest() {
        SingleLinkedList l = new SingleLinkedList();
        l.addFirst(1);
        l.addFirst(2);
        l.addFirst(5);

        assertEquals(l.size(), 3);
    }
}
