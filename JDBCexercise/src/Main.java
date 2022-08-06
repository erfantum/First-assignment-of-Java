import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {


        List<City> collect = Country.findAllCountries().stream()
                .map(Country::getCities)
                .map(cities -> cities.stream().max(Comparator.comparing(City::getPopulation)))
                .filter(Optional::isPresent)
                .map(Optional::get).collect(Collectors.toList());


        Map<String, Long> getMoviesOfDirector = Movie.getAllMovies().stream()
                .map(Movie::getAllDirectors)
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(Director::getName, Collectors.counting()));

        getMoviesOfDirector.entrySet().forEach(System.out::println);

    }
}