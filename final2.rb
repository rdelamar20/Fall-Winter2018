class WheelofFortune


  def initialize(current_player)
    @current_player = current_player
  end

  def get_next_turn
    if @current_player == 'X'
      @current_player = 'O'
    else
      @current_player = 'X'
    end
    return @current_player
  end

  def ask_player_for_guess(current_player,guess)
    played = false
    while not played
      if validate_guess(guess)
        @guess[row][col] = current_player
        played = true
      end
    end
  end

  def validate_guess(guess)

  end



end