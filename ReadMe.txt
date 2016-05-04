TimeTracker is a simple project based on Android Java.

It is good sample reference for android beginner to learn on
1. Android with SQLite Database
2. Passing data between multiple activity screen

This is a tutorial project from the book, Head First Android Developement (Chapter 7 to Chapter 9)

There are many errors in the text book but this project have solved all the errors.

Each activity (.java file in app/src/main/java) require a layout (.xml file in app/src/main/res)

The main activity in this project was TimeTrack.java
that take data from the activity AddTime.java and 

Please note that only java class that "extends" Activity (Eg. AppCompatActivity) are considered as activity

1. TimeTrackerAdepter.java
2. TimeRecord.java
3. TimeListDatabaseHelper.java

These classes was not considered as activity.

#################################################################################################
DETAIL:

1.
TimeTrack activity display the list of TimeRecord object and allow the user to add TimeRecord's object
through the button "ADD" that call the method onAdd(View);

2.
AddTime activity was then called in onAdd() method to prompt the user to enter the (time) and (note).
AddTime activity then pass back the RESULT ((time) & (note)) to TimeTrack activity through the method
onSave and finish the activity. (Note: Remember to finish the activity by calling finish())

After the parameter (time) and (note) was obtained, the RESULT was append to the database through the
TimeTrackerAdapter.

3.
TimeTrackerAdapter act as a pointer to the location in the database.
Iteration method was internally build and therefore all the RESULTs in the database were displayed.
Just implement bindView to display the TimeRecord's RESULT once and all the TimeRecords' RESULT will
be displayed automatically.

4.
TimeListDatabaseHelper act as a interface between SQLite database and Android java code.
an OpenHelper (internal class of TimeListDatabaseHelper) must be implemented as it used to create a
database using the method getWritableDatabase().

TimeListDatabaseHelper provide methods to get data in the database and store data in the database

5.
TimeRecord was a class that have two parameter (time) and (notes).

#############################################################################
LAYOUT:

TimeTrack activity used the layout activity_time_track.xml that store in app/src/main/res/layout folder\
The layout used can be see from the onCreate() method in each activity
The layout was the user interface that display on a smartphone

AddTime activity used the layout time_entry.xml

Although TimeRecord was not an activity but still it have it's own layout to display a single TimeRecord
object as in the layout time_item_list.xml
