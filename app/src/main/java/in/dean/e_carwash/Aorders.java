package in.dean.e_carwash;

public class Aorders {
    private String email,mobile,name,oaddress1,oaddress2,olocation,otitle;

    public Aorders() {
    }

    public Aorders(String email, String mobile, String name, String oaddress1, String oaddress2, String olocation, String otitle) {
        this.email = email;
        this.mobile = mobile;
        this.name = name;
        this.oaddress1 = oaddress1;
        this.oaddress2 = oaddress2;
        this.olocation = olocation;
        this.otitle = otitle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOaddress1() {
        return oaddress1;
    }

    public void setOaddress1(String oaddress1) {
        this.oaddress1 = oaddress1;
    }

    public String getOaddress2() {
        return oaddress2;
    }

    public void setOaddress2(String oaddress2) {
        this.oaddress2 = oaddress2;
    }

    public String getOlocation() {
        return olocation;
    }

    public void setOlocation(String olocation) {
        this.olocation = olocation;
    }

    public String getOtitle() {
        return otitle;
    }

    public void setOtitle(String otitle) {
        this.otitle = otitle;
    }
}
