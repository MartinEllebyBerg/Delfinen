package domain_model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    @Test
    void calculateMembershipRate() {
        //Triple A pattern

        //Arrange - setup our test objects etc.
        String birthdayStr ="1938-10-10";
        LocalDate birthday1 = LocalDate.parse(birthdayStr);
        String birthdayStr2 = "1995-09-13";
        LocalDate birthday2 = LocalDate.parse(birthdayStr2);
        Member member1 = new ExerciseMember(1, "Mette", "Munch",birthday1, true, false);
        Member member2 = new ExerciseMember(2, "Martin", "Berg", birthday2, false, true);

        //Act - do the actual
        // calc
        member1.calculateYearOfMember();
        int memberAge = member1.getYearsOfAge();
        member1.calculateMembershipRate();
        double memberShipRate = member1.getRate();
        double actualResult = memberShipRate;
        double expectedResult = 1200;

        member2.calculateMembershipRate();
        int memberAge2 = member2.getYearsOfAge();
        member2.calculateMembershipRate();
        double memberShipRate2 = member2.getRate();
        double actualResult2 = memberShipRate2;
        double expectedResult2 = 500;

        //Assert - check if actual value is equal to expected
        //Assertions.assertEquals(expectedResult, actualResult);

        Assertions.assertEquals(expectedResult2, actualResult2);
    }
}