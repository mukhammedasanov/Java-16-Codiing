package anonym.model;

import java.util.Objects;

public class User {
   private Long id;
   private String username;
   private String password;
   private String INN;
   private Gender gender;
   private Phone phone;

   public User() {
   }

   public User(String username, String password, String INN, Gender gender) {
      this.username = username;
      this.password = password;
      this.INN = INN;
      this.gender = gender;
   }

   public User(Long id, String username, String password, String phoneNumber, Gender gender) {
      this.username = username;
      this.password = password;
      this.INN = phoneNumber;
      this.gender = gender;
      this.id = id;
   }


   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getINN() {
      return INN;
   }

   public void setINN(String INN) {
      this.INN = INN;
   }

   public Gender getGender() {
      return gender;
   }

   public void setGender(Gender gender) {
      this.gender = gender;
   }

   public Phone getPhone() {
      return phone;
   }

   public void setPhone(Phone phone) {
      this.phone = phone;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      User user = (User) o;
      return Objects.equals(id, user.id);
   }

   @Override
   public int hashCode() {
      return Objects.hashCode(id);
   }

   @Override
   public String toString() {
      return "User{" +
              "id=" + id +
              ", username='" + username + '\'' +
              ", password='" + password + '\'' +
              ", phoneNumber='" + INN + '\'' +
              ", gender=" + gender +
              '}';
   }
}
