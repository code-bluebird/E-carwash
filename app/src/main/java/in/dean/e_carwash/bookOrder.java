package in.dean.e_carwash;

public class bookOrder {
    private String id,email,Olocation,Oaddress1,Oaddress2,Otitle,name,mobile;

    public bookOrder() {

    }

    public bookOrder(String id,String email,String mobile, String name,String Oaddress1, String Oaddress2,  String Olocation, String Otitle) {
        this.email = email;
        this.mobile = mobile;
        this.name = name;
        this.Oaddress1 = Oaddress1;
        this.Oaddress2 = Oaddress2;
        this.Olocation = Olocation;
        this.Otitle = Otitle;


    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOlocation() {
        return Olocation;
    }

    public void setOlocation(String olocation) {
        Olocation = olocation;
    }

    public String getOaddress1() {
        return Oaddress1;
    }

    public void setOaddress1(String oaddress1) {
        Oaddress1 = oaddress1;
    }

    public String getOaddress2() {
        return Oaddress2;
    }

    public void setOaddress2(String oaddress2) {
        Oaddress2 = oaddress2;
    }

    public String getOtitle() {
        return Otitle;
    }

    public void setOtitle(String otitle) {
        Otitle = otitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
