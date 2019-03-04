#Ryan Delamar CIS 116 Section 7776


=begin
Algorithm

1. Generate random number for game, 1-100.
2. Ask player to guess number to begin.
3. Program tells player if high or low, or very high/very low if more than 10 away.
4. Track number of guesses until finish.
5. If correct, program ends.
6. Display number of guesses at end, Along with running score.

=end

tracker = 0
again = "y"
wins = 0



until again == "n"
  number = rand(101)
  #puts number
  #Remove the hash on above line to see what number is for testing!
  puts "Welcome to the guessing game, Guess any number between 1-100 to begin!"
  guess = gets.chomp.to_i
  tracker = 0
  until guess == number
  if (guess - number <= -10)
   puts "Very Low (By 10 or more!), Guess Again: "
   guess = gets.chomp.to_i
   tracker += 1
   elsif (guess - number >= 10)
   puts "Very High (By 10 or more!), Guess Again: "
   guess = gets.chomp.to_i
   tracker += 1
   elsif (guess < number)
   puts "Too low, Guess Again: "
   guess = gets.chomp.to_i
   tracker += 1
   else
   puts "Too high, Guess again: "
   guess = gets.chomp.to_i
   tracker += 1
  end
  end
  wins +=1
  puts "Correct! The number is: " + number.to_s + " Here are your stats:"
  puts "Number of guesses: " + tracker.to_s
  puts "Number of wins so far: " +  wins.to_s
  puts "Would you like to play again? y/n"
  again = gets.chomp.downcase
end

puts "Thanks for playing!"