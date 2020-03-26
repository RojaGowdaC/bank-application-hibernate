package hibernate.model;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name="branch")
public class Branch {
    @Id
    @GenericGenerator(name = "sequence_branch_id", strategy = "org.example.model.IdCreator")
    @GeneratedValue(generator = "sequence_branch_id")
    @Column(name="BranchIFSC")
    private String branchIFSC;
    @Column(name = "name")
    private String name;
    @Column(name = "Type")
    private String Type;
    @Column(name = "Address")
    private String Address;
    public void setBranchIFSC(String branchIFSC) {
        this.branchIFSC = branchIFSC;
    }
    public String getBranchIFSC() {
        return branchIFSC;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return Type;
    }
    public void setType(String type) {
        Type = type;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
    @Override
    public String toString() {
        return "Branch{" +
                "branchIFSC='" + branchIFSC + '\'' +
                ", name='" + name + '\'' +
                ", Type='" + Type + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }
}
