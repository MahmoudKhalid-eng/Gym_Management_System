
package gymmanagementsystem.model;

public class Client {
    private int idd,sessions;

    private String name,phone,emergency,type;

    public int getIdd() {
        return idd;
    }

    public void THEID(int idd) {
        this.idd = idd;
    }

    public int getSessions() {
        return sessions;
    }

    public void setSessions(int sessions) {
        this.sessions = sessions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmergency() {
        return emergency;
    }

    public void setEmergency(String emergency) {
        this.emergency = emergency;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    } 
}
