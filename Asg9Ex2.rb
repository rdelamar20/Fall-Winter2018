#Ryan Delamar CIS 116 Section 7776


=begin
Algorithm
1. Ask user to input two numbers.
2. Make class that compares two numbers, then decides which is larger.
3. Output the larger number.
=end


puts "Please insert the first number."
first = gets.chomp.to_i
puts "Please enter the second number."
second = gets.chomp.to_i

class Compare
  def initialize (first,second)
    @first = first
    @second = second
  end

  def bigsmall()
    if @first > @second
      puts "The first number is larger: " + @first.to_s
    else
      puts "The second number is larger: " + @second.to_s
    end
  end
end

entry = Compare.new(first,second)
entry.bigsmall
