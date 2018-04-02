package net.diogosilverio.checker;

public class HelloChecker {

    private String name;
    private String surname = "Doe";

    public HelloChecker() {
        this.name = "Jane";
    }

    public void hello() {
        final String fullName = name + ", " + surname;
        System.out.println(String.format("Name: %s", fullName));
    }

}
