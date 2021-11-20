package in.co.stitchup.sf19;

public class signUpPara
{
    String email;
    String name;
    String category;

    public signUpPara() {
    }

    public signUpPara(String email, String name, String category) {
        this.email = email;
        this.name = name;
        this.category = category;
    }
    public String getEmail()
    {
        return email;
    }
    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }
}
