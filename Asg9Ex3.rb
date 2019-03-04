#Ryan Delamar CIS 116 Section 7776


=begin
Algorithm
1. create student class
2. create intitialze method
3. create method to add accumulated exam scores
4. create display method
5. either loop for unlimited scores or limit for 3
=end

class Student
 def initialize(name,classname,phone,exam)
   @name = name
   @classname = classname
   @phone = phone
   @exam = exam
 end

  def addscore(score)
    @exam += score
  end

  def display()
    puts "Student Name: " + @name.to_s
    puts "Class Name: " + @classname.to_s
    puts "Phone Number: " + @phone.to_s
    puts "Accumulated Exam Score: " + @exam.to_s
  end

end

joey = Student.new("Joey","Biology", "1234567", 93)
joey.display

counter = 0

until counter == 3
  puts "Please enter exam score to add to accumulated score."
  extra = gets.chomp.to_i
  joey.addscore(extra)
  counter += 1
end

joey.display