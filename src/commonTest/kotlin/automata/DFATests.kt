package automata

import kotlin.test.Test
import kotlin.test.assertEquals

class DFATests {
    @Test
    fun testIsMatch() {
        val state0 = State ("0");
        val state1 = State("1");
        val state2 = State("2");

        val rule0 = Rule(state0, 'A', state1);
        val rule1 = Rule(state1, 'B', state2);

        val dfa0 = DFA(state0, setOf(state0, state1, state2), setOf(rule0, rule1));
        var ret = dfa0.isMatch("AB");
        assertEquals(true, ret);

        val dfa1 = DFA(state0, setOf(state0, state1, state2), setOf(rule0, rule1));
        ret = dfa1.isMatch("A");
        assertEquals(true, ret);

        val dfa2 = DFA(state0, setOf(state0, state1, state2), setOf(rule0, rule1));
        ret = dfa2.isMatch("CD");
        assertEquals(false, ret);

        val dfa3 = DFA(state0, setOf(state0, state2), setOf(rule0, rule1));
        ret = dfa3.isMatch("A");
        assertEquals(false, ret);
    }
}