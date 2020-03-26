package hibernate.model;

import javax.persistence.*;

@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "contactNo")
    private String contactNo;
    @OneToMany(cascade=CascadeType.ALL,targetEntity = Account.class)
    @JoinColumn(name = "AcccountNumber")
    private Account account;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getContactNo() {
        return contactNo;
    }
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", account=" + account +
                '}';
    }
}
