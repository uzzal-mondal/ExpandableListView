package com.example.uzzal.expandablelistview_85;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expl;
    private CustomAdapter customAdapter;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    private int lastExpandedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expl = (ExpandableListView) findViewById(R.id.expandable_id);

       prepareListData();
        customAdapter = new CustomAdapter(this, listDataHeader, listDataChild);
        expl.setAdapter(customAdapter);


        expl.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                String groupName = listDataHeader.get(groupPosition);
                Toast.makeText(MainActivity.this, "Group Name -  " + groupName + " , " + groupPosition, Toast.LENGTH_SHORT).show();

                return false;
            }
        });

        expl.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {

                String groupName = listDataHeader.get(groupPosition);
                Toast.makeText(MainActivity.this, " is collapsed", Toast.LENGTH_SHORT).show();

            }
        });

        expl.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                String child = listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);
                Toast.makeText(MainActivity.this, " Child -\n" + child, Toast.LENGTH_SHORT).show();


                return false;
            }
        });

        expl.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {

                if (lastExpandedPosition != -1 && lastExpandedPosition != groupPosition) {
                    expl.collapseGroup(lastExpandedPosition);
                }
               // lastExpandedPosition = groupPosition;
            }
        });

    }


    public void prepareListData() {

        //String[] headerString = getResources().getStringArray(R.array.abbreviations_list_header);
       // String[] childString = getResources().getStringArray(R.array.abbreviations_list_child);

        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

//        for (int i = 0; i < headerString.length; i++) {
//            // adding header data..........
//
//            listDataHeader.add(headerString[i]);
//
//            List<String> child = new ArrayList<>();
//            child.add(childString[i]);
//
//
//            listDataChild.put(listDataHeader.get(i), child);
//
//        }
              // create a header..
        listDataHeader.add("1. Introduction to Java ");
       listDataHeader.add("2. Java Virtual Machine(JVM) Basics ");
        listDataHeader.add("3. First Java Program ");
        listDataHeader.add("4. Variables in Java");
        listDataHeader.add("5. Java Data Types ");
        listDataHeader.add("6. Java Operators ");
        listDataHeader.add("7. If-else in Java ");
        listDataHeader.add("8. Switch-Case in Java ");
        listDataHeader.add("9.  Java For loop ");
        listDataHeader.add("10. Java While loop ");
        listDataHeader.add("11. do-while loop in Java ");
        listDataHeader.add("12. Java Continue statement ");
        listDataHeader.add("13. Java Break statement ");
        listDataHeader.add("14. Constructor in Java ");
        listDataHeader.add("15.  Static keyword in Java ");
        listDataHeader.add("16. Java Inheritance with example ");
        listDataHeader.add("17.  Types of inheritance in Java ");
        listDataHeader.add("18.  Aggregation in Java ");
        listDataHeader.add("19. Association in Java ");
        listDataHeader.add("20.  Super Keyword in Java ");
        listDataHeader.add("21. Method overloading in Java ");
        listDataHeader.add("22. Method overriding in Java ");
        listDataHeader.add("23.  Java – Method Overloading vs Method Overriding ");
        listDataHeader.add("24. Polymorphism in Java");
        listDataHeader.add("25.  Types of polymorphism in Java");
        listDataHeader.add("26. Static and dynamic binding ");
        listDataHeader.add("27. Abstract class in Java ");
        listDataHeader.add("28. Java Abstract method with example ");
        listDataHeader.add("29.  Interface in Java ");
        listDataHeader.add("30. Java – Abstract class vs interface ");

            // header er under a onk  gula child
        List<String> overView = new ArrayList<>();
        overView.add("1.1 What is the Java language");
        overView.add("1.2 History of Java");
        overView.add("1.3 Feature of Java");
        overView.add("1.4 Advantage of Java");




          // hash map er madhome data add korsi..!
         // header er under a child take rekhe dilam
        listDataChild.put(listDataHeader.get(0),overView);


        List<String> JVM = new ArrayList<>();
        JVM.add("1.1 javac compiler");
        JVM.add("1.2 JVM is byte code");
        JVM.add("1.3 java platform independent");
        JVM.add("1.4 Native Method stack");
        listDataChild.put(listDataHeader.get(1),JVM);

//
        List<String> firstJava = new ArrayList<>();
        firstJava.add("1.1 What is the Java language");
        firstJava.add("1.2 History of Java");
        firstJava.add("1.3 Feature of Java");
        firstJava.add("1.4 Advantage of Java");
        listDataChild.put(listDataHeader.get(2),firstJava);
//
        List<String> Variables = new ArrayList<>();
        Variables.add("1.1 What is the Java language");
        Variables.add("1.2 History of Java");
        Variables.add("1.3 Feature of Java");
        Variables.add("1.4 Advantage of Java");
        listDataChild.put(listDataHeader.get(3),Variables);
//
//
        List<String> dataTypes = new ArrayList<>();
        dataTypes.add("1.1 What is the Java language");
        dataTypes.add("1.2 History of Java");
        dataTypes.add("1.3 Feature of Java");
        dataTypes.add("1.4 Advantage of Java");
        listDataChild.put(listDataHeader.get(4),dataTypes);


        List<String> Operators = new ArrayList<>();
        Operators.add("1.1 What is the Java language");
        Operators.add("1.2 History of Java");
        Operators.add("1.3 Feature of Java");
        Operators.add("1.4 Advantage of Java");
        listDataChild.put(listDataHeader.get(5),Operators);


        List<String> if_else = new ArrayList<>();
        if_else.add("1.1 What is the Java language");
        if_else.add("1.2 History of Java");
        if_else.add("1.3 Feature of Java");
        if_else.add("1.4 Advantage of Java");
        listDataChild.put(listDataHeader.get(6),if_else);

        List<String> Switch_Case = new ArrayList<>();
        Switch_Case.add("1.1 What is the Java language");
        Switch_Case.add("1.2 History of Java");
        Switch_Case.add("1.3 Feature of Java");
        Switch_Case.add("1.4 Advantage of Java");
        listDataChild.put(listDataHeader.get(7),Switch_Case);

        List<String> For_loop = new ArrayList<>();
        For_loop.add("1.1 What is the Java language");
        For_loop.add("1.2 History of Java");
        For_loop.add("1.3 Feature of Java");
        For_loop.add("1.4 Advantage of Java");
        listDataChild.put(listDataHeader.get(8),For_loop);

        List<String> Continue = new ArrayList<>();
        Continue.add("1.1 What is the Java language");
        Continue.add("1.2 History of Java");
        Continue.add("1.3 Feature of Java");
        Continue.add("1.4 Advantage of Java");
        listDataChild.put(listDataHeader.get(9),Continue);

        List<String> while_loop = new ArrayList<>();
        while_loop.add("1.1 What is the Java language");
        while_loop.add("1.2 History of Java");
        while_loop.add("1.3 Feature of Java");
        while_loop.add("1.4 Advantage of Java");
        listDataChild.put(listDataHeader.get(10),while_loop);

        List<String> do_while = new ArrayList<>();
        do_while.add("1.1 What is the Java language");
        do_while.add("1.2 History of Java");
        do_while.add("1.3 Feature of Java");
        do_while.add("1.4 Advantage of Java");
        listDataChild.put(listDataHeader.get(11),do_while);

        List<String> Break = new ArrayList<>();
        Break.add("1.1 What is the Java language");
        Break.add("1.2 History of Java");
        Break.add("1.3 Feature of Java");
        Break.add("1.4 Advantage of Java");
        listDataChild.put(listDataHeader.get(12),Break);

        List<String> Constructor = new ArrayList<>();
        Constructor.add("1.1 What is the Java language");
        Constructor.add("1.2 History of Java");
        Constructor.add("1.3 Feature of Java");
        Constructor.add("1.4 Advantage of Java");
        listDataChild.put(listDataHeader.get(13),Constructor);

        List<String> Static = new ArrayList<>();
        Static.add("1.1 What is the Java language");
        Static.add("1.2 History of Java");
        Static.add("1.3 Feature of Java");
        Static.add("1.4 Advantage of Java");
        listDataChild.put(listDataHeader.get(14),Static);

        List<String> Inheritance = new ArrayList<>();
        Inheritance.add("1.1 What is the Java language");
        Inheritance.add("1.2 History of Java");
        Inheritance.add("1.3 Feature of Java");
        Inheritance.add("1.4 Advantage of Java");
        listDataChild.put(listDataHeader.get(15),Inheritance);

        List<String> Aggregation = new ArrayList<>();
        Aggregation.add("1.1 What is the Java language");
        Aggregation.add("1.2 History of Java");
        Aggregation.add("1.3 Feature of Java");
        Aggregation.add("1.4 Advantage of Java");
        listDataChild.put(listDataHeader.get(16),Aggregation);

        List<String> assosition = new ArrayList<>();
        assosition.add("1.1 What is the Java language");
        assosition.add("1.2 History of Java");
        assosition.add("1.3 Feature of Java");
        assosition.add("1.4 Advantage of Java");
        listDataChild.put(listDataHeader.get(17),assosition);

        List<String> encapsulation = new ArrayList<>();
        encapsulation.add("1.1 What is the Java language");
        encapsulation.add("1.2 History of Java");
        encapsulation.add("1.3 Feature of Java");
        encapsulation.add("1.4 Advantage of Java");
        listDataChild.put(listDataHeader.get(18),encapsulation);

        List<String> polymorphism = new ArrayList<>();
        polymorphism.add("1.1 What is the Java language");
        polymorphism.add("1.2 History of Java");
        polymorphism.add("1.3 Feature of Java");
        polymorphism.add("1.4 Advantage of Java");
        listDataChild.put(listDataHeader.get(19),polymorphism);

        List<String> abstarct = new ArrayList<>();
        abstarct.add("1.1 What is the Java language");
        abstarct.add("1.2 History of Java");
        abstarct.add("1.3 Feature of Java");
        abstarct.add("1.4 Advantage of Java");
        listDataChild.put(listDataHeader.get(20),abstarct);

        List<String> superclass = new ArrayList<>();
        superclass.add("1.1 What is the Java language");
        superclass.add("1.2 History of Java");
        superclass.add("1.3 Feature of Java");
        superclass.add("1.4 Advantage of Java");
        listDataChild.put(listDataHeader.get(21),superclass);

        List<String> subclass = new ArrayList<>();
        subclass.add("1.1 What is the Java language");
        subclass.add("1.2 History of Java");
        subclass.add("1.3 Feature of Java");
        subclass.add("1.4 Advantage of Java");
        listDataChild.put(listDataHeader.get(22),subclass);

        List<String> inTerface = new ArrayList<>();
        inTerface.add("1.1 What is the Java language");
        inTerface.add("1.2 History of Java");
        inTerface.add("1.3 Feature of Java");
        inTerface.add("1.4 Advantage of Java");
        listDataChild.put(listDataHeader.get(23),inTerface);

        List<String> classJava = new ArrayList<>();
        classJava.add("1.1 What is the Java language");
        classJava.add("1.2 History of Java");
        classJava.add("1.3 Feature of Java");
        classJava.add("1.4 Advantage of Java");
        listDataChild.put(listDataHeader.get(24),classJava);

        List<String> que = new ArrayList<>();
        que.add("1.1 What is the Java language");
        que.add("1.2 History of Java");
        que.add("1.3 Feature of Java");
        que.add("1.4 Advantage of Java");
        listDataChild.put(listDataHeader.get(25),que);

        List<String> ObjectJava = new ArrayList<>();
        ObjectJava.add("1.1 What is the Java language");
        ObjectJava.add("1.2 History of Java");
        ObjectJava.add("1.3 Feature of Java");
        ObjectJava.add("1.4 Advantage of Java");
        listDataChild.put(listDataHeader.get(26),ObjectJava);

        List<String> vector = new ArrayList<>();
        vector.add("1.1 What is the Java language");
        vector.add("1.2 History of Java");
        vector.add("1.3 Feature of Java");
        vector.add("1.4 Advantage of Java");
        listDataChild.put(listDataHeader.get(27),vector);

        List<String> LinkList = new ArrayList<>();
        LinkList.add("1.1 What is the Java language");
        LinkList.add("1.2 History of Java");
        LinkList.add("1.3 Feature of Java");
        LinkList.add("1.4 Advantage of Java");
        listDataChild.put(listDataHeader.get(28),LinkList);

        List<String> trycaseBlock = new ArrayList<>();
        trycaseBlock.add("1.1 What is the Java language");
        trycaseBlock.add("1.2 History of Java");
        trycaseBlock.add("1.3 Feature of Java");
        trycaseBlock.add("1.4 Advantage of Java");
        listDataChild.put(listDataHeader.get(29),trycaseBlock);
//
//        List<String> finalyBlock = new ArrayList<>();
//        finalyBlock.add("1.1 What is the Java language");
//        finalyBlock.add("1.2 History of Java");
//        finalyBlock.add("1.3 Feature of Java");
//        finalyBlock.add("1.4 Advantage of Java");
//        listDataChild.put(listDataHeader.get(30),finalyBlock);

//        List<String> CustomException = new ArrayList<>();
//        overView.add("1.1 What is the Java language");
//        overView.add("1.2 History of Java");
//        overView.add("1.3 Feature of Java");
//        overView.add("1.4 Advantage of Java");
//        listDataChild.put(listDataHeader.get(31),overView);

//        List<String> exceptionHand = new ArrayList<>();
//        overView.add("1.1 What is the Java language");
//        overView.add("1.2 History of Java");
//        overView.add("1.3 Feature of Java");
//        overView.add("1.4 Advantage of Java");
//        listDataChild.put(listDataHeader.get(32),overView);
//
//        List<String> Garbase = new ArrayList<>();
//        overView.add("1.1 What is the Java language");
//        overView.add("1.2 History of Java");
//        overView.add("1.3 Feature of Java");
//        overView.add("1.4 Advantage of Java");
//        listDataChild.put(listDataHeader.get(33),overView);
//
//        List<String> overridding = new ArrayList<>();
//        overView.add("1.1 What is the Java language");
//        overView.add("1.2 History of Java");
//        overView.add("1.3 Feature of Java");
//        overView.add("1.4 Advantage of Java");
//        listDataChild.put(listDataHeader.get(34),overView);
//
//        List<String> overloading = new ArrayList<>();
//        overView.add("1.1 What is the Java language");
//        overView.add("1.2 History of Java");
//        overView.add("1.3 Feature of Java");
//        overView.add("1.4 Advantage of Java");
//        listDataChild.put(listDataHeader.get(35),overView);
//
//        List<String> GarbaseCollect = new ArrayList<>();
//        overView.add("1.1 What is the Java language");
//        overView.add("1.2 History of Java");
//        overView.add("1.3 Feature of Java");
//        overView.add("1.4 Advantage of Java");
//        listDataChild.put(listDataHeader.get(36),overView);
//
//        List<String> AccessModifire = new ArrayList<>();
//        overView.add("1.1 What is the Java language");
//        overView.add("1.2 History of Java");
//        overView.add("1.3 Feature of Java");
//        overView.add("1.4 Advantage of Java");
//        listDataChild.put(listDataHeader.get(37),overView);




    }


}
