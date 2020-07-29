package in.dean.e_carwash;

public class userRegister {
    public String name,email,mobile;


    public userRegister(String name,String email,String mobile)
    {
        this.name=name;
        this.email=email;
        this.mobile=mobile;
    }


    public String getName() {
        return name;
    }
    public String getMobile() {
        return mobile;
    }
    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
