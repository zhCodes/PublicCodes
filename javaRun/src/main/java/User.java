package main.java;

import java.util.Objects;

/**
 * @author Zhanghuihui
 * @date 2023/3/30 10:57
 * @description
 */

public class User {

  private Integer id;
  private String userName;
  private String password;
  private Integer phone;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Integer getPhone() {
    return phone;
  }

  public void setPhone(Integer phone) {
    this.phone = phone;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return id.equals(user.id) && userName.equals(user.userName) && password.equals(user.password)
        && phone.equals(user.phone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userName, password, phone);
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", userName='" + userName + '\'' +
        ", password='" + password + '\'' +
        ", phone=" + phone +
        '}';
  }
}
