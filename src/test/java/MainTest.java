import org.example.Main;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void testPeopleIndexes_Example1() {
        Main main = new Main();
        List<List<String>> favoriteCompanies = Arrays.asList(
                Arrays.asList("leetcode", "google", "facebook"),
                Arrays.asList("google", "microsoft"),
                Arrays.asList("google", "facebook"),
                Arrays.asList("google"),
                Arrays.asList("amazon")
        );
        List<Integer> expected = Arrays.asList(0, 1, 4);
        List<Integer> result = main.peopleIndexes(favoriteCompanies);
        assertEquals(expected, result);
    }

    @Test
    public void testPeopleIndexes_Example2() {
        Main main = new Main();
        List<List<String>> favoriteCompanies = Arrays.asList(
                Arrays.asList("leetcode", "google", "facebook"),
                Arrays.asList("leetcode", "amazon"),
                Arrays.asList("facebook", "google")
        );
        List<Integer> expected = Arrays.asList(0, 1);
        List<Integer> result = main.peopleIndexes(favoriteCompanies);
        assertEquals(expected, result);
    }

    @Test
    public void testPeopleIndexes_Example3() {
        Main main = new Main();
        List<List<String>> favoriteCompanies = Arrays.asList(
                Arrays.asList("leetcode"),
                Arrays.asList("google"),
                Arrays.asList("facebook"),
                Arrays.asList("amazon")
        );
        List<Integer> expected = Arrays.asList(0, 1, 2, 3);
        List<Integer> result = main.peopleIndexes(favoriteCompanies);
        assertEquals(expected, result);
    }

    @Test
    public void testPeopleIndexes_EmptyList() {
        Main main = new Main();
        List<List<String>> favoriteCompanies = Arrays.asList();
        List<Integer> expected = Arrays.asList();
        List<Integer> result = main.peopleIndexes(favoriteCompanies);
        assertEquals(expected, result);
    }

    @Test
    public void testPeopleIndexes_SingleUserList() {
        Main main = new Main();
        List<List<String>> favoriteCompanies = Arrays.asList(
                Arrays.asList("companyA", "companyB")
        );
        List<Integer> expected = Arrays.asList(0);
        List<Integer> result = main.peopleIndexes(favoriteCompanies);
        assertEquals(expected, result);
    }

    @Test
    public void testPeopleIndexes_AllSubsets() {
        Main main = new Main();
        List<List<String>> favoriteCompanies = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("a"),
                Arrays.asList("b")
        );
        List<Integer> expected = Arrays.asList();
        List<Integer> result = main.peopleIndexes(favoriteCompanies);
        assertEquals(expected, result);
    }
}
