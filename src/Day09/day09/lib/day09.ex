defmodule Day09 do
  @moduledoc """
  Documentation for `Day09`.
  """

  def hack_xmas(filePath, preambleSize) do
    input = load_input(filePath)

    vulnerability = get_vulnerability(input, preambleSize)
    IO.puts(vulnerability)
    
    {i,j} = get_longest_combination(input,vulnerability)
    
    input = input
    |> Enum.slice(i..j)
    |> Enum.sort()
    
    Enum.at(input, 0) + Enum.at(input,-1)
  end

  def get_vulnerability(input, preambleSize) do
    input = Enum.with_index(input)
    input
    |> Enum.slice(preambleSize..-1)
    |> Enum.reduce_while(0, fn {x,i}, acc -> 
      if fits_pattern(Enum.slice(input, (i-preambleSize)..i), x), do: {:cont, acc}, else: {:halt, x}
    end)
  end

  def fits_pattern(input, target) do
    combinations = for {x,x_index} <- input, {y,y_index} <- input, x_index != y_index, do: {x, y}

    combinations
    |> Enum.reduce_while(0, fn {x,y}, _acc -> if x + y == target, do: {:halt, true}, else: {:cont, false} end)
  end

  def get_longest_combination(inputs, target) do
    inputs = Enum.with_index(inputs)
    inputs
    |> Enum.map(fn {_,i} -> {i, get_combination(Enum.slice(inputs, i..-1), target)} end)
    |> Enum.filter(fn {x,i} -> i > x end)
    |> Enum.sort(fn {x,i}, {y,j} -> i - x >= j - y end)
    |> Enum.fetch(0)
    |> elem(1)
  end

  def get_combination(list, target) do      
    list_size = Enum.count(list)  
    end_index = Enum.at(list, -1) |> elem(1)
    if list_size < 2 do
      0
    else
      list
      |> Enum.reduce_while(0, fn {y, j}, acc -> 
        case {y,j, acc, end_index} do
          {y,_j,_acc,_} when y == target -> {:halt, 0}
          {y,j,acc,_} when acc + y == target -> {:halt, j}
          {y,_,acc,_} when (acc + y >= target) -> {:halt, 0}
          {_,j,_acc,end_index} when j == end_index -> {:halt,0}
          {y,_,acc,_} -> {:cont, acc + y}
        end
      end)
    end
  end

  def load_input(filePath) do
    {_, input} = File.read(filePath)

    String.replace(input, "\r", "")
    |> String.split("\n")
    |> Enum.map(&Integer.parse(&1))
    |> Enum.map(fn x -> elem(x,0) end)
  end
end
