package com.feliperibeiro.adventofcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day07 {

  private final Set<String> nodes;
  private final Map<String, List<String>> edges;
  private final Map<String, Integer> weights;

  private Day07(Set<String> nodes, Map<String, List<String>> edges, Map<String, Integer> weights) {
    this.nodes = nodes;
    this.edges = edges;
    this.weights = weights;
  }

  boolean isBalanced(final String node) {
    return !edges.containsKey(node)
           || edges.get(node).stream().map(this::calcWeight).distinct().count() == 1;
  }

  int calcWeight(final String node) {
    if (!edges.containsKey(node)) {
      return weights.get(node);
    }

    return edges.get(node).stream().map(this::calcWeight).reduce(weights.get(node), Integer::sum);
  }

  String findRoot() {
    Set<String> childrenNodes = edges.entrySet().stream()
        .map(Map.Entry::getValue)
        .flatMap(List::stream)
        .collect(Collectors.toSet());
    return nodes.stream().filter(n -> !childrenNodes.contains(n)).findFirst().get();
  }

  int wrongWeight(String node) {
    if (isBalanced(node)) {
      return 0;
    }
    boolean balancedChildren = edges.get(node).stream().allMatch(this::isBalanced);
    if (balancedChildren) {
      final Map<Integer, List<String>> childrenWeights = edges.get(node).stream()
          .collect(Collectors.groupingBy(this::calcWeight));
      final Optional<String> diffChild = childrenWeights.entrySet()
          .stream()
          .filter(e -> e.getValue().size() == 1)
          .map(e -> e.getValue().get(0))
          .findFirst();

      return diffChild.map(c -> {
        int weight = this.calcWeight(c);
        int otherWeight =
            childrenWeights.entrySet().stream().map(Map.Entry::getKey).filter(w -> w != weight)
                .findFirst().get();
        return otherWeight - (weight - weights.get(c));
      }).orElse(0);
    }
    return wrongWeight(edges.get(node).stream().filter(n -> !this.isBalanced(n)).findFirst().get());
  }

  static Day07 parseData(final List<String> inputLines) {
    Pattern p = Pattern.compile("^([a-z]+) \\(([0-9]+)\\)+( -> (.+))?$");
    Set<String> nodes = new HashSet<>();
    Map<String, List<String>> edges = new HashMap<>();
    Map<String, Integer> weights = new HashMap<>();
    inputLines.stream().forEach(s -> {
      final Matcher m = p.matcher(s);
      if (m.find()) {
        final String name = m.group(1);
        final int weight = Integer.parseInt(m.group(2));
        List<String> children = null;
        if (m.group(3) != null) {
          children = Arrays.asList(m.group(3).substring(4).split(", "));
          edges.put(name, children);
        }
        nodes.add(name);
        weights.put(name, weight);
      }
    });

    return new Day07(nodes, edges, weights);
  }

  static String part1(final List<String> inputLines) {
    Day07 data = parseData(inputLines);
    return data.findRoot();
  }

  static int part2(final List<String> inputLines) {
    Day07 data = parseData(inputLines);

    return data.wrongWeight(data.findRoot());
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    List<String> l = new ArrayList<>();
    while (in.hasNextLine()) {
      l.add(in.nextLine());
    }
    System.out.println(part2(l));
  }


}
