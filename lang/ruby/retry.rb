#!/usr/bin/ruby
for i in 0..5
   retry if i > 2
puts "Value of local variable is #{i}"
end

begin
   do_something # exception raised
rescue
   # handles error
   retry  # restart from beginning
end


