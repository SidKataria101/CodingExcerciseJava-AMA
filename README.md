# CodingExcerciseJava-AMA
Character shifting in a string coding excersice in Java as given by AMA

# Requirements:
Create a function that will accept two inputs that are typed in (standard input) and return a string. The first input is a string, and the second input is a number. The resulting string will be the first input with the characters position shifted by the amount entered on the second input.
Some examples:
- Input1 = “abcdef”, Input2 = 2 -> Output = “efabcd”
- Input1 = “hello world”, Input2 = 5 -> Output = “ worldhello”

# Here are some rules to follow:
- First input accepts only letters.
- If the second input is bigger than the length of the string, it should wrap around appropriately.
- You decide how to handle restrictions and errors.
- You choose the framework and language of programming.
- Share your solution using Github.
- Add README with information on how to run your solution and any extra information you find relevant for your solution.

# How to run the program: 
Please make sure you have Java installed on your machine to be able to run this program.
Check if you have Java installed with the following command:
- java -version

To run the program, please do the follows:
1. Clone the repo
2. Using commandline, cd/go to the ShiftingCharInString/ShiftString/src
3. Enter 'java App' in your commandPrompt/Terminal to start the program
4. Enter valid string and a valid integer as prompted
5. Your shifted string will be presented in the console

# To know:
- The app takes in valid string inputs within the range of 0 to 1000. (Empty string is not considered as a valid string)
- This valid string can contain uppercase and lowercase characters with whitespaces in between or after. (regex -> [a-zA-Z]+)
- If you add additional whitespace in the string, they will be considered as valid characters. Eg: "Sid Kataria " -> 2 whitespaces.