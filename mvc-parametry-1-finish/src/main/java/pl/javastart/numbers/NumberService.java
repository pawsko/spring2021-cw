package pl.javastart.numbers;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Service
class NumberService {
    private final Random random = new Random();

    /**
     *
     * @param from - lower bound inclusive
     * @param to - upper bound inclusive
     * @return random number from range [from; to]
     */
    int getRandomNumberFromRange(int from, int to) {
        int diff = to - from;
        return from + random.nextInt(diff + 1);
    }

    /**
     *
     * @param from - lower bound inclusive
     * @param to - upper bound inclusive
     * @return List with even numbers from range [from; to]
     */
    List<Integer> getEvenNumbersFromRange(int from, int to) {
        return IntStream.range(from, to + 1)
                .filter(NumberService::isEven)
                .boxed()
                .toList();
    }

    /**
     *
     * @param from - lower bound inclusive
     * @param to - upper bound inclusive
     * @return List with odd numbers from range [from; to]
     */
    List<Integer> getOddNumbersFromRange(int from, int to) {
        return IntStream.range(from, to + 1)
                .filter(NumberService::isOdd)
                .boxed()
                .toList();
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static boolean isOdd(int number) {
        return number % 2 != 0;
    }
}
