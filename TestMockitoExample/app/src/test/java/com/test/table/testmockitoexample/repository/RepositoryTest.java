package com.test.table.testmockitoexample.repository;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.Instant;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RepositoryTest {

    @Spy
    Repository repository;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule=new InstantTaskExecutorRule();

//    @Mock
//    Repository repository;


//    @Spy
//    Repository repository;

    @Before
    public void setUp() throws Exception {

        //Old way to do it
       // MockitoAnnotations.initMocks(Repository.class);
    }

    @Test
    public void getData() {

//        MutableLiveData<String> mutableLiveData=new MutableLiveData<>();
//        mutableLiveData.setValue("this is login test");

        //mock
//        when(repository.getData()).thenReturn("This is mock string");
//        System.out.println(repository.getData());

        //@Spy
//        doReturn(repository.getData()).when(repository).getData();
//        System.out.println(repository.getData());

        //void
        //mock
//        doNothing().when(repository).getValues("a","b");

        // mock
//        when(repository.getMutableLiveData("vishal","vishal")).thenReturn(mutableLiveData);
//        System.out.println(mutableLiveData.getValue());

        //spy
        when(repository.getMutableLiveData("vishal","vishal")).thenReturn(repository.mutableLiveData);
        System.out.println(repository.mutableLiveData.getValue());
    }
}