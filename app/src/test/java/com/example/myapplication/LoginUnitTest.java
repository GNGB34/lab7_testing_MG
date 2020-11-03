package com.example.myapplication;

import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.junit.Assert.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class LoginUnitTest {

    private static final String VALID_STRING = "Login was successful";
    private static final String INVALID_STRING = "Invalid login!";

    @InjectMocks
    LoginActivity myObjectUnderTest;

    @Mock
    Context mMockContext;

    @Test
    public void readStringFromContext_LocalizedString() {

        myObjectUnderTest = new LoginActivity(mMockContext);

        // ...when the string is returned from the object under test...
        String result = myObjectUnderTest.validate("admin","admin");


        // ...then the result should be the expected one.
        assertThat(result, is(VALID_STRING));

    }

    @Test
    public void passEmailVerification(){
        myObjectUnderTest = new LoginActivity(mMockContext);

        String result_case_valid = myObjectUnderTest.emailValidate("micheal.kagnew@gmail.com");
        assertThat(result_case_valid, is(VALID_STRING));
    }

    @Test
    public void failEmailVerification(){
        myObjectUnderTest = new LoginActivity(mMockContext);

        String result_case_invalid = myObjectUnderTest.emailValidate("gabe@cordo~ado@hotmail.net");
        assertThat(result_case_invalid, is(INVALID_STRING));

    }
}
