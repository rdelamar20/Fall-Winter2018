#Ryan Delamar CIS 116 Section 7776


=begin
Algorithm

1. Tell player to think of a number between 1-100! enter start to begin!
2. Program starts, computer guesses 50 to start, player enters too high or too low
3. Computer then begins to eliminate possible answers by division.
4. Track number of guesses computer makes
5. Output original number and number of guesses it took.
6. Play again?

=end
again = "y"

until again == "n"
  tracker = 0
  upper_limit = 100
  lower_limit = 0
  guess_right = "n"
  computer_guess = (upper_limit/2)
  high_low = ""
  puts "Welcome to the guessing game, Think of a number between 1 and 100."

    until guess_right == "y"

      puts "Is it: " + computer_guess.to_s + " y/n?"
      guess_right = gets.chomp.to_s.downcase

      if guess_right == "y"
        tracker +=1
      end

      if guess_right == "n"
        puts "Am I too high or low? h or l:"
        high_low = gets.chomp

        if high_low == "h"
          upper_limit = computer_guess
          computer_guess = (upper_limit - lower_limit)/2 + lower_limit
          tracker += 1

        elsif high_low == "l"
          lower_limit = computer_guess
          computer_guess = ((upper_limit - lower_limit)/2) + lower_limit
          tracker += 1
        end

      end

    end

  puts "number to guess was: " + computer_guess.to_s
  puts "number of guesses made: " + tracker.to_s
  puts "Play again? y/n"
  again = gets.chomp.downcase
  guess_right = "n"
  tracker = 0
  end
puts "Thanks for playing!"
