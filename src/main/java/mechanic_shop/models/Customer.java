package mechanic_shop.models;

import java.util.Objects;

public class Customer {
    private int customerId;
    private String licenseId;
    private String name;
    private int age;
    private String phone;
    private String email;

    public Customer() {
    }

    public Customer(int customerId, String licenseId, String name, int age, String phone, String email) {
        this.customerId = customerId;
        this.licenseId = licenseId;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId == customer.customerId && age == customer.age && Objects.equals(licenseId, customer.licenseId) && Objects.equals(name, customer.name) && Objects.equals(phone, customer.phone) && Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, licenseId, name, age, phone, email);
    }
}
