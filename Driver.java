public class Driver {
    public static void main(String args[]) {

        FoodRatings fr = new FoodRatings(
                new String[]    {"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},
                new String[]    {"korean", "japanese", "japanese", "greek", "japanese", "korean"},
                new int[]       {9, 12, 8, 15, 14, 7});

        System.out.println("Highest Rated Korean Food: " + fr.highestRated("korean"));
        System.out.println("Highest Rated Japanese Food: " + fr.highestRated("japanese"));
        fr.changeRating("sushi", 16);
        System.out.println("Highest Rated Japanese Food: " + fr.highestRated("japanese"));
        fr.changeRating("ramen", 16);
        System.out.println("Highest Rated Japanese Food: " + fr.highestRated("japanese"));

        IsomorphicStrings test = new IsomorphicStrings();
        test.isIsomorphic("egcd", "adfd");
        test.isIsomorphic("egg", "add");
        test.isIsomorphic("badc", "baba");
    }
}
