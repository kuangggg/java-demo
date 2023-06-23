package design;

public class Strategy {

    interface ValidateStrategy {
        boolean execute(String s);
    }

    class IsNumberValidate implements ValidateStrategy {
        @Override
        public boolean execute(String s) {
            System.out.println(s);
            return s.matches("\\d+");
        }
    }

    class Validator {
        private final ValidateStrategy strategy;
        public Validator(ValidateStrategy s) {
            strategy = s;
        }

        public boolean validate(String s) {
            return strategy.execute(s);
        }
    }

    public static void main(String[] args) {

        Strategy strategy = new Strategy();
        Validator validator = strategy.new Validator(strategy.new IsNumberValidate());
        boolean validate = validator.validate("11zz");
        System.out.println(validate);

        Validator validator1 = strategy.new Validator((String s) -> s.matches("[a-z]+"));
        System.out.println(validator1.validate("hello"));

    }

}
