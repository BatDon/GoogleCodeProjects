package com.test.table.testmockitoexample.myviewmodel;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyIterable;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MyViewModelTest {

    MyViewModel myViewModel;
    Observer<String> mockObserver;
    Observer<ArrayList> mockObserverAL;
    //mock the live data observer
    String word;


    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule=new InstantTaskExecutorRule();



    @Before
    public void setUp() throws Exception {
        myViewModel=new MyViewModel();
        mockObserver = mock(Observer.class);
        mockObserverAL=mock(Observer.class);

//        ApplicationProvider.getApplicationContext() //context if needed

//        final Observer<ArrayList> realObserver= new Observer<ArrayList>() {
//
//            @Override
//            public void onChanged(ArrayList<String> al) {
//                String firstWord=al.get(0);
//                String secondWord=al.get(1);
//            }
//

//            Mockito.reset(mockObserver);
            // mock them here or in individual tests

    }


    @Test
    public void setNewValue() {
//        myViewModel.liveData2.observeForever();
        myViewModel.setNewValue("foo");

        assertEquals(myViewModel.liveData1.getValue(), "foo"); // Passes

        //Testing Util

        LiveDataTestUtil liveDataTestUtil=new LiveDataTestUtil();

        try{
            word=liveDataTestUtil.getOrAwaitValue(myViewModel.liveData1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals("foo",word);

        //Test Util end

        myViewModel.liveData1.observeForever(mockObserver);

        verify(mockObserver).onChanged(isA(String.class));

        myViewModel.setNewValue("gree");
        verify(mockObserver, times(1)).onChanged(same("gree"));
        myViewModel.setNewValue("org");
        verify(mockObserver).onChanged(same("org"));
        verify(mockObserver, never()).onChanged(same("df"));

    }

    @Test
    public void arraysChanged() {
        myViewModel.liveData2.observeForever(mockObserverAL);

        ArrayList<String> expectedArrayList=new ArrayList<String>();
        expectedArrayList.add("cat");
        expectedArrayList.add("dog");

        myViewModel.setLiveData2Value(expectedArrayList);
//        ArrayList al=new ArrayList();
//
//        mockObserverAL.onChanged(al){
//            al.get(0);
//        };
        verify(mockObserverAL).onChanged(isA(ArrayList.class));
        verify(mockObserverAL, times(1)).onChanged(isA(ArrayList.class));


//        ArrayList mockArrayList = mock(ArrayList.class);

        ArgumentCaptor<ArrayList> argument = ArgumentCaptor.forClass(ArrayList.class);
        verify(mockObserverAL).onChanged(argument.capture());
//        assertEquals("John", argument.getValue().getName());
        ArrayList arrayListReceived= argument.getValue();
        assertEquals(expectedArrayList.get(1),arrayListReceived.get(1));
        assertArrayEquals(expectedArrayList.toArray(), arrayListReceived.toArray());
        System.out.println("argument= "+argument.getValue());




        myViewModel.addValue("fish");
        ArrayList<String> newArrayList=expectedArrayList;
        newArrayList.add(2,"fish");

        verify(mockObserverAL).onChanged(argument.capture());
//        assertEquals("John", argument.getValue().getName());
        ArrayList received= argument.getValue();
        assertArrayEquals(newArrayList.toArray(), received.toArray());
        assertNotNull(received);



    }
}