package hw22.ru.otus.java.basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class ArrayFunctionsTest {
    ArrayFunctions arrayFunctions;

    @BeforeEach
    public void prepare() {
        arrayFunctions = new ArrayFunctions();
    }

    public static Stream<Arguments> getArraysForAfterLastOneOk() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.of(new int[]{1, 2, 1, 2, 2}, new int[]{2, 2}));
        out.add(Arguments.of(new int[]{1, 2, 1, 2, 1}, new int[]{}));
        return out.stream();
    }

    @ParameterizedTest
    @MethodSource("getArraysForAfterLastOneOk")
    void getArrayAfterLastOneOk(int[] in, int[] result) {
        Assertions.assertArrayEquals(result, arrayFunctions.getArrayAfterLastOne(in));
    }

    @Test
    void getArrayAfterLastOneThrow() {
        Assertions.assertThrows(RuntimeException.class, () -> arrayFunctions.getArrayAfterLastOne(new int[]{2, 2, 2, 2}));
    }

    public static Stream<Arguments> getArraysForCheckTest() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.of(new int[]{1, 2}, true));
        out.add(Arguments.of(new int[]{1, 1}, false));
        out.add(Arguments.of(new int[]{1, 3}, false));
        out.add(Arguments.of(new int[]{1, 2, 2, 1}, true));
        return out.stream();
    }

    @ParameterizedTest
    @MethodSource("getArraysForCheckTest")
    void checkArrayContainsOneAndTwoOnly(int[] array, boolean result) {
        Assertions.assertEquals(result, arrayFunctions.checkArrayContainsOneAndTwoOnly(array));
    }
}