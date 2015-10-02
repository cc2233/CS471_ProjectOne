
Fall 2015 CS 471 Professor Price

Project One

by Caroline Chey



This is a Priority Queue based program; dispatcher simulator.
There are three possible states for a process: Ready, Blocked, Running

A Priority Queue of Processes maintains all Ready Processes. 
A List is used to hold all Blocked Processes.
There cannot be more than one Process Running at a time.



Provided input data files: 
   processes_A.txt (contains twenty processes #1000 - 1019)
      and 
   processes.B.txt (contains fifteen processes #2000 - 2014)


Program will read in from an input file to construct a Priority Queue.

three different levels of priority: 3 is highest and 1 is lowest.


BUTTONS:

Reset (Process Status) : Resets all text fields

Add Process :
To add a process, type in name and priority for desired new process and use the button.
It will be added to Ready. If the input for priority is invalid, default priority of 1 will be used.
Process ID will be derived automatically - cannot be typed in. 

Terminate Process :
Terminates the displayed process. A terminated process will be removed from Ready or Blocked or Running to Terminated.


Load :
Loads from input file and constructs a Priority Queue

Block :
Blocks the running process. A process must be running in order to be blocked.

Yield :
Yields to the next highest priority process in Ready.

Unblock :
Unblocks a blocked process. 

