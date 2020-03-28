package automata

class NFA(var currentStates: Set<State>, val acceptStates: Set<State>, val rules: Set<Rule>) {
    fun isMatch(input: String): Boolean {
        input.map { char ->
            currentStates = currentStates.flatMap { state ->
                this.rules.filter { rule ->  rule.state == state && rule.input == char}.map { rule -> rule.nextState };
            }.toSet();
        }

        return !currentStates.intersect(acceptStates).isEmpty();
    }
}