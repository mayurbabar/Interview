package allergy;

import java.util.List;

public class Person {
	private String firstName;
    private String lastName;
    private Integer age;
    private Gender gender;
    private List<Address> address;
    private List<Long> contactNo;

    public Person(String firstName, String lastName, Integer age, Gender gender, List<Address> address, List<Long> contactNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.contactNo = contactNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public List<Long> getContactNo() {
        return contactNo;
    }

    public void setContactNo(List<Long> contactNo) {
        this.contactNo = contactNo;
    }

}
