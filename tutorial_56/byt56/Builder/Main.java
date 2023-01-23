package Builder;

public class Main {
    public static void main(String[] args) {
        Person woman = new Person.Builder(Gender.FEMALE)
                .Hair(HairColor.BROWN)
                .Eye(EyeColor.GREEN)
                .Height(Height.MEDIUM)
                .build();
        System.out.println(woman);

        Person man = new Person.Builder(Gender.MALE)
                .Hair(HairColor.BROWN)
                .Eye(EyeColor.BLUE)
                .Height(Height.SHORT)
                .build();
        System.out.println(man);

    }
}
