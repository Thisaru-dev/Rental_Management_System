
package pmsjavafx;


public class CusOblist {
    
    private int custiD;
    private String name;
    private String nic;
    private String mobile;
    private String address;
    
    
    
    public CusOblist(int custiD,String name,String nic,String mobile,String address)
    {        
    this.custiD=custiD;
    this.name=name;
    this.nic=nic;
    this.mobile=mobile;
    this.address=address;
    
    }
    
    
    
    
    
    
    
    public void setCustiD(int custiD) {
        this.custiD = custiD;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCustiD() {
        return custiD;
    }

    public String getName() {
        return name;
    }

    public String getNic() {
        return nic;
    }

    public String getMobile() {
        return mobile;
    }

    public String getAddress() {
        return address;
    }
    
}
