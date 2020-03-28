package dfa

class DFA(var currentState: State, val acceptStates: Set<State>, val rules: Set<Rule>) {
    fun isMatch(input: String): Boolean {
        try {
            input.forEach { char ->
                this.currentState = this.rules.first { rule -> rule.state == this.currentState && rule.input == char }.nextState;
            }
        } catch (e: NoSuchElementException) {
            return false;
        }

        return return acceptStates.contains(currentState);
    }
}