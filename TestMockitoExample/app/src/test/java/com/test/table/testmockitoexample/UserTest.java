package com.test.table.testmockitoexample;

import androidx.annotation.NonNull;

import org.junit.Test;

import java.lang.reflect.Executable;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;



public class UserTest {

    @Test(expected = IllegalArgumentException.class)
    public void testUsernameIsNull() {

                    User user = new User();
                    user.setName(null);

//        assertEquals("Username cannot be blank", exception.getMessage());
    }

//    @Test
//    public void testUsernameIsNull() {
//
//        Throwable exception = assertThrows(
//                IllegalArgumentException.class, () -> {
//                    User user = new User();
//                    user.setName(null);
//                }
//        );
//
//        assertEquals("Username cannot be blank", exception.getMessage());
//    }
//
//    @Test
//    public void testUsernameIsNull() {
//
//        assertThrows(IllegalArgumentException.class, () -> {
//            User user = new User();
//            user.setName(null);
//        });
//    }
//
//    @Test
//    public void testUsernameIsNull() {
//
//        assertThrows(IllegalArgumentException.class, new Executable() {
//
//
//            @Override
//            public void execute() throws Throwable {
//                User user = new User();
//                user.setName(null);
//            }
//        });
//    }
}
