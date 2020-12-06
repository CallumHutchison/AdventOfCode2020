defmodule Day06Test do
  use ExUnit.Case

  test "gives correct part one answer on sample input" do
    assert Day06.partOne("sampleInput.txt") == 11
  end

  test "gives correct part two answer on sample input" do
    assert Day06.partTwo("sampleInput.txt") == 6
  end
end
