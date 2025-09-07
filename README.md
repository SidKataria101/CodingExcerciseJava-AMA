# CodingExcerciseJava-AMA
Character shifting in a string coding excersice in Java as given by AMA

## Requirements:
Create a function that will accept two inputs that are typed in (standard input) and return a string. The first input is a string, and the second input is a number. The resulting string will be the first input with the characters position shifted by the amount entered on the second input.
Some examples:
```
- Input1 = “abcdef”, Input2 = 2 -> Output = “efabcd”
- Input1 = “hello world”, Input2 = 5 -> Output = “ worldhello”
```

## Here are some rules to follow:
- First input accepts only letters.
- If the second input is bigger than the length of the string, it should wrap around appropriately.
- You decide how to handle restrictions and errors.
- You choose the framework and language of programming.
- Share your solution using Github.
- Add README with information on how to run your solution and any extra information you find relevant for your solution.

# How to run the program: 
1. Please make sure you have Java installed on your machine to be able to run this program. Check if you have Java installed with the following command:
```
java -version
```

2. Clone the repo or download the `.zip` file from the 'Code' dropdown.
```
git clone https://github.com/SidKataria101/CodingExcerciseJava-AMA.git
```
3. Go into the project source file
```
cd CodingExcerciseJava-AMA-main/ShiftString/src
```
4. Compile and run the program:
```
javac *.java && java App
```
4. Enter valid string and a valid integer as prompted.
5. Your shifted string will be presented in the console.

## To know:
- The app takes valid string which can contain uppercase and lowercase characters with whitespaces in between or after. (regex -> `[a-zA-Z\\s]+`)
- The app takes in valid integer inputs within the range of `-1000` to `1000`. (Empty input is not considered as a valid integer)
- If you add additional whitespace in the string, they will be considered as valid characters. (Eg: "Sid Kataria " -> 2 whitespaces)
Some examples:
```
- Input1 = “ama”, Input2 = 0 -> Output = “ama”
- Input1 = “sid kataria”, Input2 = -4 -> Output = “katariasid ”
```