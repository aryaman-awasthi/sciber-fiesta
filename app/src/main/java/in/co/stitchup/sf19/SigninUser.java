package in.co.stitchup.sf19;

public class SigninUser
{
    String category,email,name;

    public SigninUser() {
    }

    public SigninUser(String category, String email, String name) {
        this.category = category;
        this.email = email;
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
