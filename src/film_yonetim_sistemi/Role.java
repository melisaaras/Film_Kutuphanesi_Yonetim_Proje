package film_yonetim_sistemi;

public enum Role {

    ROLE_ADMIN("Admin"),
    ROLE_USER("User");

    String name;

    Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
