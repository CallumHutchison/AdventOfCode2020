defmodule Day06 do
  @moduledoc """
  Solution for Day 6 of the Advent of Code competition 2020.
  Challenge: https://adventofcode.com/2020/day/6
  """

  def partOne(filePath) do
    loadInput(filePath)
    |> Enum.map(fn s -> String.replace(s, "\n", "") end)
    |> Enum.map(fn s -> countUniqueLetters(s) end)
    |> Enum.reduce(fn count, acc -> acc + count end)
  end

  @doc """
  Count the number of unique letters in a string, to a maximum of 26.
  Case sensitive.

  ## Examples

    iex> Day06.countUniqueLetters("abcde")
    5

  """
  def countUniqueLetters(string) do
    String.graphemes("abcdefghijklmnopqrstuvwxyz")
    |> Enum.reduce(0, fn letter, acc -> if string =~ letter, do: acc + 1, else: acc end)
  end

  def partTwo(filePath) do
    loadInput(filePath)
    |> Enum.map(fn s -> countCommonLetters(String.split(s, "\n")) end)
    |> Enum.reduce(fn count, acc -> acc + count end)
  end

  @doc """
  Count the number of letters that occur in every string in a list, to a maximum of 26.
  Case sensitive.

  ## Examples

    iex> Day06.countCommonLetters(String.split("abc\nabc\nab"))
    2

  """
  def countCommonLetters(lines) do
    String.graphemes("abcdefghijklmnopqrstuvwxyz")
    |> Enum.reduce(0, fn letter, acc ->
      if Enum.reduce(lines, true, fn line, acc ->
           if acc == true and line =~ letter, do: true, else: false
         end) == true,
         do: acc + 1,
         else: acc
    end)
  end

  def loadInput(filePath) do
    {_, input} = File.read(filePath)

    String.replace(input, "\r", "")
    |> String.split("\n\n")
  end
end
