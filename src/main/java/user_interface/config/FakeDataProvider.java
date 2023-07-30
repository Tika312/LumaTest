package user_interface.config;

import com.github.javafaker.Faker;

public class FakeDataProvider {

    Faker faker = new Faker();

    public String generateFakeFullName(){
        return faker.name().fullName();
    }
    public String generateFakeFirstName(){
        return faker.name().firstName();
    }
    public String generateFakeLastName(){
        return faker.name().lastName();
    }

    public String generateFakePassword(){
        return faker.internet().password(8,20,true,true);
    }

    public String generateFakeEmail(){
        return faker.internet().emailAddress();
    }

    public String generateFakeCurrentAddress(){
        return faker.address().fullAddress();
    }

    public String generateFakePermanentAddress(){
        return faker.address().secondaryAddress();
    }
    public String generateFakeMobileNumber(){
        return faker.phoneNumber().subscriberNumber().concat(faker.phoneNumber().subscriberNumber())
                .concat(faker.phoneNumber().subscriberNumber());
    }
    public String generateAnySubject(){
        return faker.chuckNorris().toString();
    }

}
