package user_interface.model;

import lombok.Getter;

public enum LoginCredentials {

    firstName("John"),
    lastName("Doe"),
    email("tilec92@mail.ru"),
    userName("Johny"),
    password("312312Bish@Kek");



@Getter
 String credentials;

 LoginCredentials(String credentials){
     this.credentials = credentials;
 }
}
