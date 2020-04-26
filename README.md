# Implementation of a CLI based Reverse Polish (Lukasiewicz) Notation Calculator

## The Stack

This calculator operates using a simple data structure known as a stack. It is an example of a **LIFO** data structure, which stands for **Last In First Out**. Essentially as items are added to the stack, the first item that can be retrieved is the last one that was inserted. As numbers are passed to the calculator any operation will execute on the last entries in the stack, not the first.

#### How the stack grows

The stack grows when a number is provided to the CLI. This loads the provided number as the last entry in the stack, ergo the first one to be operated on.

#### How do operations affect the stack

Every calculation will add its result to the stack on completion but the number of entries they will remove varies. Some will take two, some one, and some will take the entire stack. It's important to be aware of the scope of the operations entered into the calculator.

Another concern is how operations order the entries retrieved from the stack. To give an example, supposing we had added the numbers 3, 5, and 7 to the stack in that order and then called for a subtraction. The subtraction operation would remove 7 and then 5 but it would still return the result of `5-7`, `-2`. 

## Using the CLI

The CLI can be initiated by utilizing the provided main class in `CalculatorCli.java`, either within an IDE, creating a runnable JAR, or simply using command line java operations. Once ready, the CLI will produce a title and await user input. The program accepts several recognized commands as well as numeric input. One can trigger several commands within one line by providing a space between the commands. 

For instance the line `3.5 2.5 ADD` will result in 3.5 and 2.5 being loaded to the stack and then the execution of the addition operation. This will remove two entries from the stack and add their sum right back to the stack. The stack at the end of the execution of the provided line would have one entry: `6`.

## Command Reference

The calculator supports several calculative operations. Each one has requirements for number of elements in the stack and some have additional restrictions like the prohibition on division by zero.

| Operation | Aliases | Required Stack Entries | Notes |
| --- | --- | :---: | --- |
| Addition | `+` `ADD` | 2 |  |
| Subtraction | `-` `SUB` `SUBTRACT` | 2 |  |
| Multiplication | `*` `X` `MULT` `MULTIPLY` | 2 |  |
| Division | `/` `DIV` `DIVIDE` | 2 | Division by zero is prohibited |
| Modulo | `%` `MOD` `MODULO` | 2 | Modulo implies a division so dividing by zero is prohibited |
| Absolute Value | `ABS` `ABSOLUTE_VALUE` | 1 |  |
| Square Root | `SQRT` `SQUARE_ROOT` | 1 | Calculating the root of a negative number is forbidden. This calculator does not handle imaginary numbers. |
| Cube Root | `CBRT` `CUBE_ROOT` | 1 | Calculating the root of a negative number is forbidden. This calculator does not handle imaginary numbers. |
| Exponent | `POW` `POWER` `EXP` `EXPONENT` | 2 |  |
| Scientific Notation | `E` `SCI` | 2 |  |
| Ceiling | `CEIL` `CEILING` | 1 |  |
| Floor | `FLOOR` | 1 |  |
| Average | `AVG` `AVERAGE` `MEAN` | 1* | This operation is special in that it will take the average of the entire stack and leave only the result |

Some additional commands do not trigger calculation but instead control the flow of the program.
| Operation | Aliases |
| --- | --- |
| Numeric Insertion | `Any Number` |
| Clear Stack | `C` `CLR` `CLEAR` |
| Quit | `Q` |

## Developer Commentary

#### Why Java?

When I saw the prompt for this my mind immediately went to java. Not only is it the language I'll be working with the most in the position but it lends itself very well to something this structured. JS gives you a lot of freedom but Java gives you confidence through constraints. When writing a calculator I wanted to be absolutely sure that the data handling was going to be robust and nothing would slip through the cracks. Java excels at this.

#### Given more time, what more would you have done?

Part of the architecture I implemented was getting the stream reader that handles the CLI loop out of the main class. This was done so one could run a larger jUnit test where a file with input is read and then the output from both the out and err streams is compared against comparison files. It's a fairly common practice for JS parsers to do comparisons of the stored results of previous tests against live output to ensure no drift has occurred. This should be possible given the aforementioned abstraction but again, time.

I could have also added some operations like `MIN`, `MAX`, and `MEDIAN` to accompany `AVERAGE` in taking up the whole stack but I didn't consider them at the time.

Additionally, while I did have time to hit 100% code coverage with the calculator operations unit tests and as much as possible with the tests for the calculator object, I did not have time to figure out why jUnit 5 refused to run the test suite I put together. I would have preferred to be able to run all tests at once instead of individually.

#### What best practices would you like to highlight as important?

- Any method or variable should be private unless it needs to be public.
- Keep methods static if possible, so long as it makes sense.
- All collections (arrays/lists/maps/stacks) must be declared as final to avoid losing track of the pointer.

#### Why did you organize the classes the way you did?

While the independent operations were in their own static methods from the start. I originally had them and the command processor all in the same file. As I developed the tool, I abstracted it more and more until it became something that could be used in many applications.

From the outside in the layers of the program look something like this:
- The Main Class
  - This exists to execute the program and pass the requisite streams for CLI interaction to the CLI handler.
- The stream reader and CLI loop
  - This receives a set of streams and waits until the input stream provides a line or an EOF.
  - Every line received is broken up into its individual tokens and the commands are executed in sequence.
  - If any one command causes an error the stack is reverted to its state prior to the execution of the first command.
  - On an EOF or a Q command, the CLI loop will be terminated and the method will be allowed to complete.
- The calculator object
  - This object represents the calculator itself and maintains a single stack as its data structure.
  - The command processor accepts one command at a time and either returns void or throws an exception.
  - The command processor will attempt to identify the provided command via switch statement before attempting to parse it as a double data type.
- The individual calculator operations
  - Each static method encapsulates only one operation
  - Each method checks the provided stack to ensure an appropriate length and will throw an exception if the check fails.
  
There are many philosophies for how to write software but I favor adaptability and relevance. My primary focus is how am I meeting the requirements of the application and how easily can I adapt this. Be it either adding new functionality or allowing for consumption by many different applications, I like to keep the future in view. It goes without saying that robustness of the application is always a high priority as well.

The way I laid out the command processor with a switch statement and the static methods means that to add a new command all you need to do is code a static method that takes in a stack and add two lines to the switch statement. Adding a new command alias is only a one line change, as simple as can be. 

Likewise, while the main class and the CLI handler are both only relevant for the CLI use case, were this to be developed into a service web or otherwise, the calculator object and functions could be kept exactly as they are. The unit tests would also transition seamlessly.
