package Builder;

public class Person {
    private final EyeColor eyeColor;
    private final Height height;
    private final Gender gender;
    private final HairColor hairColor;

    private Person(Builder builder) {
        this.gender = builder.gender;
        this.height = builder.height;
        this.eyeColor = builder.eyeColor;
        this.hairColor = builder.hairColor;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("This is a ")
                .append(gender)
                .append(" with " + hairColor + " hair ")
                .append(" with " + eyeColor + " eyes ")
                .append(" is " + height + " height ");
                sb.append(".");
        return sb.toString();
    }
    public static class Builder {

        EyeColor eyeColor;
        HairColor hairColor;
        Height height;
        Gender gender;

        public Builder(Gender gender) {
            this.gender=gender;
        }

        public Builder Hair(final HairColor hairColor) {
            this.hairColor = hairColor;
            return this;
        }

        public Builder Eye(EyeColor eyeColor) {
            this.eyeColor = eyeColor;
            return this;
        }

        public Builder Height(Height  height) {
            this. height =  height;
            return this;
        }

         public Person build() {
            return new Person(this);
         }
    }
}
