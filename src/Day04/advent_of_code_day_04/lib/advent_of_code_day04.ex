defmodule AdventOfCodeDay04 do
  @moduledoc """
  Documentation for `AdventOfCodeDay04`.
  """

  def fields do
    [
      "byr:",
      "iyr:",
      "eyr:",
      "hgt:",
      "hcl:",
      "ecl:",
      "pid:"
    ]
  end

  def countValidPassports(filePath) do
    loadInput(filePath)
    |> Enum.filter(fn s ->
      Enum.reduce(fields(), 0, fn field, acc ->
        if String.contains?(s, field), do: acc + 1, else: acc
      end) == Enum.count(fields())
    end)
    |> Enum.filter(fn s ->
      String.split(s, " ")
      |> Enum.reduce(0, fn field, acc ->
        if String.length(field) == 0 || isFieldValid(field) do
          acc
        else
          IO.puts(field)
          acc + 1
        end
      end) == 0
    end)
    |> Enum.count()
  end

  def loadInput(filePath) do
    {_, input} = File.read(filePath)

    String.replace(input, "\r", "")
    |> String.split("\n\n")
    |> Enum.map(fn s -> String.replace(s, "\n", " ") end)
  end

  def isFieldValid(field) do
    {break, _} = :binary.match(field, ":")
    field = String.replace(field, ":", "")

    case String.split_at(field, break) do
      {"byr", val} ->
        {year, _} = Integer.parse(val)
        year >= 1920 and year <= 2002

      {"iyr", val} ->
        {year, _} = Integer.parse(val)
        year >= 2010 and year <= 2020

      {"eyr", val} ->
        {year, _} = Integer.parse(val)
        year >= 2020 and year <= 2030

      {"pid", val} ->
        String.match?(val, ~r/^[0-9]{9}$/)

      {"ecl", val} ->
        String.match?(val, ~r/^(amb|blu|brn|gry|grn|hzl|oth)$/)

      {"hcl", val} ->
        String.match?(val, ~r/^[#][0-9a-f]{6}$/)

      {"hgt", val} ->
        String.match?(val, ~r/^([1][5-8][0-9]cm|[1][9][0-3]cm|59in|[6][0-9]in|[7][0-6]in)$/)

      {"cid", _} ->
        true

      _ ->
        false
    end
  end
end
