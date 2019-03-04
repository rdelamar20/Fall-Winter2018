#Ryan Delamar CIS 116 Section 7776


=begin
Algorithm
1.
=end


class Item
  def initialize(item, maker)
    @item = item
    @maker = maker
  end

  def display
    puts "Item ==> " + @item.to_s
    puts "Maker ==> " + @maker.to_s
  end
end

class ItemNumber < Item
  def initialize(item_number,item,maker)
    @item_number = item_number
  end

  def display
    puts "Item ==> " + @item.to_s
    puts "Maker ==> " + @maker.to_s
    puts "Item Number ==> " + @item_number.to_s
  end
end

puts "Please enter an Item Name as string"
item = gets.chomp.to_s
puts "Please enter a Maker as a string"
maker = gets.chomp.to_s
puts "Would you like to assign an item number? y/n?"
track = gets.chomp.to_s


if track == "y"
  puts "Please enter an item number in integer format"
  item_number = gets.chomp.to_i
  item_1 = ItemNumber.new(item_number, item, maker)
else
  item_1 = Item.new(item,maker)
end

item_1.display